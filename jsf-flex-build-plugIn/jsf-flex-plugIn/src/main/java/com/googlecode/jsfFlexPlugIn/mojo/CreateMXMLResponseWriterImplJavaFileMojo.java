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
import java.util.Map;
import java.util.Properties;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import com.googlecode.jsfFlexPlugIn.parser._JsfFlexParserListener;
import com.googlecode.jsfFlexPlugIn.parser.velocity.JsfFlexVelocityParser;

/**
 * @goal    createMXMLResponseWriterImplJavaFile
 * @phase   generate-sources
 * @author Ji Hoon Kim
 */
public class CreateMXMLResponseWriterImplJavaFileMojo extends AbstractMojo
													implements _JsfFlexParserListener {
	
	private static final String MXML_RESPONSE_WRITER_BASE_IMPLEMENTOR = "mxmlResponseWriterBaseImplementor";
	
	private static final String JSF_FLEX_MXML_RESPONSE_WRITER_BASE_IMPLEMENTOR_TEMPLATE = "MXMLResponseWriterImpl.vm";
	private static final String TO_CREATE_JSF_FLEX_MXML_RESPONSE_WRITER_BASE_IMPLEMENTOR_FILE_NAME = "MXMLResponseWriterImpl.java";
	
	private static final String FILE_RESOURCE_LOADER_PATH_KEY = "file.resource.loader.path";
	
	/**
     * @parameter expression="${mxmlResponseWriterImpl}"
     */
	private String _mxmlResponseWriterImpl;
	
	/**
     * @parameter expression="${basedir}/target/jsfFlex-builder-plugin/main/java/com/googlecode/jsfFlex/renderkit/mxml"
     */
	private File _toCreateMXMLResponseWriterImplPath;
	
	/**
     * @parameter expression="src/main/resources/META-INF"
     */
    private File _templateSourceDirectory;
	
    private JsfFlexVelocityParser _jsfFlexVelocityParser;
    
	public void execute() throws MojoExecutionException, MojoFailureException {
		
		Properties _velocityParserProperties = new Properties();
		_velocityParserProperties.put(FILE_RESOURCE_LOADER_PATH_KEY, _templateSourceDirectory.getPath());
		
		_jsfFlexVelocityParser = new JsfFlexVelocityParser(_velocityParserProperties);
		_jsfFlexVelocityParser.init();
		_jsfFlexVelocityParser.addParserListener(this);
		
		String toCreateMXMLResponseWriterImplJavaPath = _toCreateMXMLResponseWriterImplPath.getPath();
		
		try{
			File _toCreateMXMLResponseWriterImplFilePath = new File(toCreateMXMLResponseWriterImplJavaPath);
			if(!_toCreateMXMLResponseWriterImplFilePath.exists()){
				_toCreateMXMLResponseWriterImplFilePath.mkdirs();
			}
			toCreateMXMLResponseWriterImplJavaPath +=  File.separatorChar + TO_CREATE_JSF_FLEX_MXML_RESPONSE_WRITER_BASE_IMPLEMENTOR_FILE_NAME;
			FileWriter _writer = new FileWriter(new File(toCreateMXMLResponseWriterImplJavaPath));
			Map<String, Object> _contextInfoMap = new HashMap<String, Object>();
			
			_contextInfoMap.put(MXML_RESPONSE_WRITER_BASE_IMPLEMENTOR, _mxmlResponseWriterImpl);
			_jsfFlexVelocityParser.mergeCollectionToTemplate(JSF_FLEX_MXML_RESPONSE_WRITER_BASE_IMPLEMENTOR_TEMPLATE, _contextInfoMap, 
																_writer, toCreateMXMLResponseWriterImplJavaPath);
			
		}catch(IOException _ioException){
			
		}
		
	}
	
	public void mergeCollectionToTemplateFinished(String _fileMerged) {
		
	}
	
}
