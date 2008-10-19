/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.googlecode.jsfFlexPlugIn.mojo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;
import org.apache.velocity.util.StringUtils;

import com.googlecode.jsfFlexPlugIn.inspector._JsfFlexInspectListener;
import com.googlecode.jsfFlexPlugIn.inspector._JsfFlexInspectorBase;
import com.googlecode.jsfFlexPlugIn.inspector.qdox.JsfFlexQdoxInspector;
import com.googlecode.jsfFlexPlugIn.parser._JsfFlexParserListener;
import com.googlecode.jsfFlexPlugIn.parser.velocity.JsfFlexVelocityParser;
import com.googlecode.jsfFlexPlugIn.utils.tasks.ReplaceText;

/**
 * @goal    createMXMLComponentReplaceMappingXML
 * @phase   generate-resources
 * @author Ji Hoon Kim
 */
public final class CreateReplaceMappingXMLMojo extends AbstractMojo 
											   implements _JsfFlexInspectListener, _JsfFlexParserListener {
	
	private static final String JSF_FLEX_ATTRIBUTE = "JsfFlexAttributes";
	
	private static final String REPLACE_MAPPING_XML_ATTRIBUTE = "tokenList";
	private static final String REPLACE_MAPPING_XML_TEMPLATE = "jsf-flex-replaceMappingXML.vm";
	private static final String TO_CREATE_REPLACE_MAPPING_XML_DIRECTORY_NAME = "replaceMapping";
	private static final String TO_CREATE_REPLACE_MAPPING_XML_FILE_SUFFIX = "ReplaceMapping.xml";
	private static final String FILE_RESOURCE_LOADER_PATH_KEY = "file.resource.loader.path";
	
	private _JsfFlexInspectorBase _jsfFlexInspector;
	private JsfFlexVelocityParser _jsfFlexVelocityParser;
	
	public CreateReplaceMappingXMLMojo(){
		super();
	}
	
	/**
	 * @parameter expression="${project}"
	 */
	private MavenProject project;
	
	/**
     * @parameter expression="target/classes"
     */
	private File rootResourceDirectory;
	
	/**
     * @parameter expression="src/main/resources/META-INF"
     */
    private File templateSourceDirectory;
	
	public void execute() throws MojoExecutionException, MojoFailureException {
		List _compileSourceRoots = project.getCompileSourceRoots();
		
		for(Iterator _compileSourceRootsIterator = _compileSourceRoots.iterator(); 
													_compileSourceRootsIterator.hasNext();){
			String _currDirPath = (String) _compileSourceRootsIterator.next();
			_jsfFlexInspector = new JsfFlexQdoxInspector(_currDirPath, JSF_FLEX_ATTRIBUTE);
			_jsfFlexInspector.addInspectListener(this);
			
			Properties _velocityParserProperties = new Properties();
			_velocityParserProperties.put(FILE_RESOURCE_LOADER_PATH_KEY, templateSourceDirectory.getPath());
			
			_jsfFlexVelocityParser = new JsfFlexVelocityParser(_velocityParserProperties);
			_jsfFlexVelocityParser.init();
			_jsfFlexVelocityParser.addParserListener(this);
			
			_jsfFlexInspector.inspectFiles();
			
		}
		
	}
	
	public final static class ReplaceMappingXMLVelocityObject{
		
		private final String _token;
		private final Boolean _byMethod;
		
		private ReplaceMappingXMLVelocityObject(){
			super();
			_token = null;
			_byMethod = null;
		}
		
		public ReplaceMappingXMLVelocityObject(String token, Boolean byMethod){
			super();
			_token = token;
			_byMethod = byMethod;
		}
		
		public String getToken(){
			return _token;
		}
		public Boolean getByMethod(){
			return _byMethod;
		}
		
	}
	
	public void inspectFileFinished(List<Map<String, ? extends Object>> _inspected, String _sourceInspected, String _package){
		
		/*
		 * For this Mojo there will be a breakage in terms of concept for the Inspector's inspectFiles method
		 * Meaning under the design the implementation should be that each documentation of JsfFlexAttributes should contain
		 * a separate value for the keys "attribute" and "byMethod" within the _inspected Map.
		 * 
		 * However since this Mojo will be specifically used for JRE < 1.4, which is only for backward compatibility,
		 * and the size of the component files will grow tremendously under this method, documentation will be :
		 * @JsfFlexAttributes
		 *   attributeValue=byMethodValue
		 *   
		 * rather than the design that should be followed for all other implementation where the key value is unique
		 * [since the current implementation is per Class. if non-unique key entries are needed per Class, then
		 * simply change the implementation to invoke "inspectFileFinishedMap" per loop but realize the impact to
		 * this class]
		 * @JsfFlexAttributes
		 *   attribute=attributeValue
		 *   byMethod=byMethodValue
		 * 
		 */
		String _path = StringUtils.getPackageAsPath(_package);
		String _replaceMappingXMLFileName = rootResourceDirectory.getPath() + File.separatorChar + _path + TO_CREATE_REPLACE_MAPPING_XML_DIRECTORY_NAME + 
												File.separatorChar + _sourceInspected + TO_CREATE_REPLACE_MAPPING_XML_FILE_SUFFIX;
		String _checkDirExists = rootResourceDirectory.getPath() + File.separatorChar + _path + TO_CREATE_REPLACE_MAPPING_XML_DIRECTORY_NAME + 
										File.separatorChar;
		try{
			
			File _checkExists = new File(_checkDirExists);
			if(!_checkExists.exists()){
				_checkExists.mkdirs();
			}
			
			FileWriter _writer = new FileWriter(new File(_replaceMappingXMLFileName));
			List<ReplaceMappingXMLVelocityObject> replaceMappingXMLVelocityObjects = generateReplaceMappingXMLVelocityObjects(_inspected);
			Map<String, Object> _contextInfoMap = new HashMap<String, Object>();
			_contextInfoMap.put(REPLACE_MAPPING_XML_ATTRIBUTE, replaceMappingXMLVelocityObjects);
			_jsfFlexVelocityParser.mergeCollectionToTemplate(REPLACE_MAPPING_XML_TEMPLATE, _contextInfoMap, 
																_writer, _replaceMappingXMLFileName);
			
		}catch(IOException _ioExcept){
			throw new RuntimeException("Error thrown for file " + _replaceMappingXMLFileName, _ioExcept);
		}
		
	}
	
	public void inspectionCompleted(){
		
	}
	
	private List<ReplaceMappingXMLVelocityObject> generateReplaceMappingXMLVelocityObjects(List<Map<String, ? extends Object>> _readNamedParameterList){
		List<ReplaceMappingXMLVelocityObject> _replaceMappingXMLVelocityObjects = new LinkedList<ReplaceMappingXMLVelocityObject>();
		
		for(Map<String, ? extends Object> _readNamedParameter : _readNamedParameterList){
			
			for(String _token : _readNamedParameter.keySet()){
				Object _byMethod = _readNamedParameter.get(_token);
				_byMethod = _byMethod == null ? "false" : _byMethod;
				_replaceMappingXMLVelocityObjects.add(new ReplaceMappingXMLVelocityObject(_token, Boolean.valueOf((String) _byMethod)));
			}
			
		}
		
		return _replaceMappingXMLVelocityObjects;
	}
	
	public void mergeCollectionToTemplateFinished(String _fileMerged){
		
		ReplaceText removeEmptySpace = new ReplaceText(_fileMerged);
		removeEmptySpace.replaceRegExp(true);
		removeEmptySpace.regMatch(ReplaceText.CLEAN_REG_EXP_MATCH);
		removeEmptySpace.regReplace(ReplaceText.CLEAN_REG_EXP_REPLACE_WITH);
		
		removeEmptySpace.performTask();
		
	}
	
}
