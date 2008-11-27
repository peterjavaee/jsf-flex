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
public final class CreateMXMLResponseWriterImplJavaFileMojo 
												extends	AbstractMojo 
												implements _JsfFlexParserListener {
	
	private static final String JSF_FLEX_MXML_RESPONSE_WRITER_IMPL_12_BASE_IMPL_TEMPLATE = "MXMLResponseWriterImpl12.vm";
	
	private static final String VERSION_12 = "1.2";
	
	private static final String TO_CREATE_JSF_FLEX_MXML_RESPONSE_WRITER_IMPL_BASE_IMPL_FILE_NAME = "MXMLResponseWriterImpl.java";
	
	private static final String FILE_RESOURCE_LOADER_PATH_KEY = "file.resource.loader.path";
	
	/**
     * @parameter expression="${implVersion}"
     */
	private String _implVersion;
	
	/**
     * @parameter expression="${basedir}/target/jsfFlex-builder-plugin/main/java/com/googlecode/jsfFlex/renderkit/mxml"
     */
	private File _toCreateMXMLResponseWriterImplBaseImplPath;
	
	/**
     * @parameter expression="src/main/resources/META-INF"
     */
    private File _templateSourceDirectory;
    
    private JsfFlexVelocityParser _jsfFlexVelocityParser;
	
	public void execute() throws MojoExecutionException, MojoFailureException {
		
		Properties velocityParserProperties = new Properties();
		velocityParserProperties.put(FILE_RESOURCE_LOADER_PATH_KEY, _templateSourceDirectory.getPath());
		
		_jsfFlexVelocityParser = new JsfFlexVelocityParser(velocityParserProperties);
		_jsfFlexVelocityParser.init();
		_jsfFlexVelocityParser.addParserListener(this);
		
		String toCreateMXMLResponseWriterImplBaseImplJavaPath = _toCreateMXMLResponseWriterImplBaseImplPath.getPath();
		
		try{
			File toCreateMXMLResponseWriterImplBaseFilePath = new File(toCreateMXMLResponseWriterImplBaseImplJavaPath);
			if(!toCreateMXMLResponseWriterImplBaseFilePath.exists()){
				toCreateMXMLResponseWriterImplBaseFilePath.mkdirs();
			}
			toCreateMXMLResponseWriterImplBaseImplJavaPath +=  File.separatorChar + 
																			TO_CREATE_JSF_FLEX_MXML_RESPONSE_WRITER_IMPL_BASE_IMPL_FILE_NAME;
			FileWriter writer = new FileWriter(new File(toCreateMXMLResponseWriterImplBaseImplJavaPath));
			Map<String, Object> contextInfoMap = new HashMap<String, Object>();
			
			String template = null;
			if(_implVersion.trim().equals(VERSION_12)){
				template = JSF_FLEX_MXML_RESPONSE_WRITER_IMPL_12_BASE_IMPL_TEMPLATE;
			}
			
			_jsfFlexVelocityParser.mergeCollectionToTemplate(template, contextInfoMap, writer, toCreateMXMLResponseWriterImplBaseImplJavaPath);
			
		}catch(IOException ioException){
			
		}
		
	}
	
	public void mergeCollectionToTemplateFinished(String fileMerged) {
		
	}
	
}
