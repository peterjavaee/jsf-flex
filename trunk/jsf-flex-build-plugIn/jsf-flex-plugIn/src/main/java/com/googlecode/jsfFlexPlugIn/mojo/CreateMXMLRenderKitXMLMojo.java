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
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;

import com.googlecode.jsfFlexPlugIn.inspector._JsfFlexInspectListener;
import com.googlecode.jsfFlexPlugIn.inspector.qdox.JsfFlexQdoxInspector;
import com.googlecode.jsfFlexPlugIn.parser._JsfFlexParserListener;
import com.googlecode.jsfFlexPlugIn.parser.velocity.JsfFlexVelocityParser;

/**
 * TODO : Finish the implementation and test it
 * 
 * @goal    createMXMLRenderKitXML
 * @phase   process-classes
 * @author Ji Hoon Kim
 */
public class CreateMXMLRenderKitXMLMojo extends AbstractMojo 
										implements _JsfFlexInspectListener, _JsfFlexParserListener {
	
	private static final String JSF_FLEX_RENDERKIT_ATTRIBUTE = "JsfFlexRenderKitAttribute";
	
	private static final String JSF_FLEX_RENDERERLIST_ATTRIBUTE = "rendererList";
	private static final String JSF_FLEX_RENDERKIT_XML_TEMPLATE = "jsf-flex-mxmlRenderKitXML.vm";
	private static final String TO_CREATE_MXML_RENDERKIT_XML_FILE_NAME = "mxmlRenderKit.xml";
	private static final String FILE_RESOURCE_LOADER_PATH_KEY = "file.resource.loader.path";
	private static final List<String> _parameterList = new LinkedList<String>();
	
	private static final String COMPONENT_FAMILY_KEY = "componentFamily";
	private static final String RENDERER_NAME_KEY = "rendererName";
	private static final String RENDERER_CLASS_KEY = "rendererClass";
	
	private static final int HASH_CODE_INIT_VALUE = 3;
	private static final int HASH_CODE_MULTIPLY_VALUE = 31;
	
	static{
		_parameterList.add(COMPONENT_FAMILY_KEY);
		_parameterList.add(RENDERER_NAME_KEY);
		_parameterList.add(RENDERER_CLASS_KEY);
	}
	
	private JsfFlexQdoxInspector _jsfFlexQdoxInspector;
	private JsfFlexVelocityParser _jsfFlexVelocityParser;
	private Map<String, Renderer> _rendererMap;
	
	/**
	 * @parameter expression="${project}"
	 */
	private MavenProject project;
	
	/**
     * @parameter expression="target/classes/com/googlecode/jsfFlex/framework/util"
     */
	private File toCreateMxmlRenderKitXMLPath;
	
	/**
     * @parameter expression="src/main/resources/META-INF"
     */
    private File templateSourceDirectory;
	
	public CreateMXMLRenderKitXMLMojo(){
		super();
		_rendererMap = new HashMap<String, Renderer>();
	}
	
	public class Renderer{
		
		private String _componentFamily;
		private Set<RendererInfo> _rendererInfoSet;
		
		public Renderer(){
			super();
		}
		
		public Renderer(String componentFamily){
			super();
			_componentFamily = componentFamily;
		}
		
		{
			_rendererInfoSet = new LinkedHashSet<RendererInfo>();
		}
		
		public void addRendererInfo(RendererInfo _rendInfo){
			_rendererInfoSet.add(_rendInfo);
		}
		
		public String getComponentFamily() {
			return _componentFamily;
		}
		public void setComponentFamily(String componentFamily) {
			_componentFamily = componentFamily;
		}
		public Set getRendererInfoSet() {
			return _rendererInfoSet;
		}
		public void setRendererInfoSet(Set rendererInfoSet) {
			_rendererInfoSet = rendererInfoSet;
		}
		
		@Override
		public boolean equals(Object _instance) {
			if(!(_instance instanceof Renderer)){
				return false;
			}
			
			Renderer _rendererInstance = (Renderer) _instance;
			return this.getComponentFamily().equals(_rendererInstance.getComponentFamily());
		}
		
		@Override
		public int hashCode() {
			return getComponentFamily().hashCode();
		}
		
	}
	
	public class RendererInfo{
		
		private String _rendererClass;
		private String _rendererName;
		
		public RendererInfo(String rendererClass, String rendererName){
			super();
			_rendererClass = rendererClass;
			_rendererName = rendererName;
		}
		
		public String getRendererClass() {
			return _rendererClass;
		}
		public void setRendererClass(String rendererClass) {
			_rendererClass = rendererClass;
		}
		public String getRendererName() {
			return _rendererName;
		}
		public void setRendererName(String rendererName) {
			_rendererName = rendererName;
		}
		
		@Override
		public boolean equals(Object _instance) {
			if(!(_instance instanceof RendererInfo)){
				return false;
			}
			
			RendererInfo _rendererInfoInstance = (RendererInfo) _instance;
			return this.getRendererClass().equals(_rendererInfoInstance.getRendererClass()) && this.getRendererName().equals(_rendererInfoInstance.getRendererName());
		}
		
		@Override
		public int hashCode() {
			int hashCodeVal = HASH_CODE_INIT_VALUE;
			hashCodeVal = HASH_CODE_MULTIPLY_VALUE * hashCodeVal + getRendererClass().hashCode();
			hashCodeVal = HASH_CODE_MULTIPLY_VALUE * hashCodeVal + getRendererName().hashCode();
			return hashCodeVal;
		}
		
	}
	
	public void execute() throws MojoExecutionException, MojoFailureException {
		List _compileSourceRoots = project.getCompileSourceRoots();
		String _currDirPath;
		
		for(Iterator _compileSourceRootsIterator = _compileSourceRoots.iterator(); 
													_compileSourceRootsIterator.hasNext();){
			_currDirPath = (String) _compileSourceRootsIterator.next();
			_jsfFlexQdoxInspector = new JsfFlexQdoxInspector(_currDirPath);
			_jsfFlexQdoxInspector.addInspectListener(this);
			
			Properties _velocityParserProperties = new Properties();
			_velocityParserProperties.put(FILE_RESOURCE_LOADER_PATH_KEY, templateSourceDirectory.getPath());
			
			_jsfFlexVelocityParser = new JsfFlexVelocityParser(_velocityParserProperties);
			_jsfFlexVelocityParser.init();
			_jsfFlexVelocityParser.addParserListener(this);
			
			_jsfFlexQdoxInspector.inspectFiles(JSF_FLEX_RENDERKIT_ATTRIBUTE, _parameterList);
			
		}
		
	}
	
	public void inspectFileFinished(Map _inspected, String _sourceInspected, String _package) {
		
		if(_inspected != null && _inspected.size() > 0){
			
			String _compFamily = (String) _inspected.get(COMPONENT_FAMILY_KEY);
			Object _renderer;
			Renderer _currRenderer;
			
			String _rendererName;
			String _rendererClass;
			
			if((_renderer = _rendererMap.get(_compFamily)) != null){
				_currRenderer = (Renderer) _renderer;
			}else{
				_currRenderer = new Renderer(_compFamily);
				_rendererMap.put(_compFamily, _currRenderer);
			}
			
			_rendererClass = (String) _inspected.get(RENDERER_CLASS_KEY);
			_rendererName = (String) _inspected.get(RENDERER_NAME_KEY);
			
			_currRenderer.addRendererInfo(new RendererInfo(_rendererClass, _rendererName));
		}
		
	}
	
	public void inspectionCompleted(String _pattern, List<String> _parameters){
		
		String _toCreateMxmlRenderKitXMLFilePath = toCreateMxmlRenderKitXMLPath.getPath() + TO_CREATE_MXML_RENDERKIT_XML_FILE_NAME;
		
		try{
			
			//FileWriter _writer = new FileWriter(new File(_toCreateMxmlRenderKitXMLFilePath));
			FileWriter _writer = new FileWriter(new File("C:\\test\\" + TO_CREATE_MXML_RENDERKIT_XML_FILE_NAME));
			Map<String, Object> _contextInfoMap = new HashMap<String, Object>();
			
			_contextInfoMap.put(JSF_FLEX_RENDERERLIST_ATTRIBUTE, _rendererMap);
			_jsfFlexVelocityParser.mergeCollectionToTemplate(JSF_FLEX_RENDERKIT_XML_TEMPLATE, _contextInfoMap, _writer);
			
		}catch(IOException _ioException){
			
		}
		
	}
	
	public void mergeCollectionToTemplateFinished() {
		
	}
	
}
