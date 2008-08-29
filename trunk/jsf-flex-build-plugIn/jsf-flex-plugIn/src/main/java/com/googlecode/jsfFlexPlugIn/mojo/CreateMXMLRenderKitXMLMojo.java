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
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;

import com.googlecode.jsfFlex.framework.annotation.JsfFlexAttributeProperties;
import com.googlecode.jsfFlexPlugIn.inspector._JsfFlexInspectListener;
import com.googlecode.jsfFlexPlugIn.inspector._JsfFlexInspectorBase;
import com.googlecode.jsfFlexPlugIn.inspector.qdox.JsfFlexQdoxInspector;
import com.googlecode.jsfFlexPlugIn.parser._JsfFlexParserListener;
import com.googlecode.jsfFlexPlugIn.parser.velocity.JsfFlexVelocityParser;
import com.thoughtworks.qdox.JavaDocBuilder;
import com.thoughtworks.qdox.model.JavaClass;

/**
 * @goal    createMXMLRenderKitXML
 * @phase   generate-resources
 * @author Ji Hoon Kim
 */
public final class CreateMXMLRenderKitXMLMojo extends AbstractMojo 
											  implements _JsfFlexInspectListener, _JsfFlexParserListener {
	
	private static final String JSF_FLEX_RENDERKIT_ATTRIBUTE = "JsfFlexRenderKitAttribute";
	
	private static final String CORE_PROJECT_NAME = "core";
	private static final String COMPONENT_14_PROJECT_NAME = "component14";
	private static final String COMPONENT_15_PROJECT_NAME = "component15";
	
	private static final String JSF_FLEX_RENDERERLIST_ATTRIBUTE = "rendererList";
	private static final String JSF_FLEX_RENDERKIT_XML_TEMPLATE = "jsf-flex-mxmlRenderKitXML.vm";
	private static final String TO_CREATE_MXML_RENDERKIT_XML_FILE_NAME = "mxmlRenderKit.xml";
	private static final String FILE_RESOURCE_LOADER_PATH_KEY = "file.resource.loader.path";
	
	private static final String COMPONENT_FAMILY_KEY = "componentFamily";
	private static final String RENDERER_NAME_KEY = "rendererName";
	private static final String RENDERER_CLASS_KEY = "rendererClass";
	
	private static final int HASH_CODE_INIT_VALUE = 3;
	private static final int HASH_CODE_MULTIPLY_VALUE = 31;
	
	private _JsfFlexInspectorBase _jsfFlexInspector;
	private JsfFlexVelocityParser _jsfFlexVelocityParser;
	private Map<String, Renderer> _rendererMap;
	
	/**
	 * @parameter expression="${project}"
	 */
	private MavenProject project;
	
	/**
     * @parameter expression="${targetComponentProject}"
     */
	private String targetComponentProject;
	
	/**
     * @parameter expression="${basedir}/target/classes/com/googlecode/jsfFlex/framework/util"
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
	
	public final static class Renderer{
		
		private final String _componentFamily;
		private final Set<RendererInfo> _rendererInfoSet;
		
		private Renderer(){
			super();
			_componentFamily = null;
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
		
		public String getComponentFamily(){
			return _componentFamily;
		}
		public Set<RendererInfo> getRendererInfoSet(){
			/*
			 * since it's final it should be returned as a defensive copy,
			 * but it's a plug-in so return it
			 */
			return _rendererInfoSet;
		}
		
		@Override
		public boolean equals(Object _instance) {
			if(!(_instance instanceof Renderer)){
				return false;
			}
			
			Renderer _rendererInstance = (Renderer) _instance;
			return this._componentFamily.equals(_rendererInstance._componentFamily);
		}
		
		@Override
		public int hashCode() {
			return _componentFamily.hashCode();
		}
		
	}
	
	public final static class RendererInfo{
		
		private final String _rendererClass;
		private final String _rendererName;
		
		private RendererInfo(){
			super();
			_rendererClass = null;
			_rendererName = null;
		}
		
		public RendererInfo(String rendererClass, String rendererName){
			super();
			_rendererClass = rendererClass;
			_rendererName = rendererName;
		}
		
		public String getRendererClass(){
			return _rendererClass;
		}
		public String getRendererName(){
			return _rendererName;
		}
		
		@Override
		public boolean equals(Object _instance) {
			if(!(_instance instanceof RendererInfo)){
				return false;
			}
			
			RendererInfo _rendererInfoInstance = (RendererInfo) _instance;
			return this._rendererClass.equals(_rendererInfoInstance._rendererClass) && this._rendererName.equals(_rendererInfoInstance._rendererName);
		}
		
		@Override
		public int hashCode() {
			int hashCodeVal = HASH_CODE_INIT_VALUE;
			hashCodeVal = HASH_CODE_MULTIPLY_VALUE * hashCodeVal + _rendererClass.hashCode();
			hashCodeVal = HASH_CODE_MULTIPLY_VALUE * hashCodeVal + _rendererName.hashCode();
			return hashCodeVal;
		}
		
	}
	
	public void execute() throws MojoExecutionException, MojoFailureException {
		
		String _currDirPath = (String) project.getCompileSourceRoots().get(0);
		_currDirPath = (targetComponentProject.equals(COMPONENT_14_PROJECT_NAME)) ? 
												_currDirPath.replace(CORE_PROJECT_NAME, COMPONENT_14_PROJECT_NAME) : 
												_currDirPath.replace(CORE_PROJECT_NAME, COMPONENT_15_PROJECT_NAME);
		
		Properties _velocityParserProperties = new Properties();
		_velocityParserProperties.put(FILE_RESOURCE_LOADER_PATH_KEY, templateSourceDirectory.getPath());
		
		_jsfFlexVelocityParser = new JsfFlexVelocityParser(_velocityParserProperties);
		_jsfFlexVelocityParser.init();
		_jsfFlexVelocityParser.addParserListener(this);
		
		//HACK for now, since QDOX seems to have issues reading Java files with annotations
		targetComponentProject = COMPONENT_14_PROJECT_NAME;
		if(targetComponentProject.equals(COMPONENT_14_PROJECT_NAME)){
			_jsfFlexInspector = new JsfFlexQdoxInspector(JSF_FLEX_RENDERKIT_ATTRIBUTE, _currDirPath);
		}else{
			
			_jsfFlexInspector = new _JsfFlexInspectorBase(_currDirPath){
				public void inspectFiles(){
					Map<String, String> _inspectedMap;
					JavaDocBuilder builder = new JavaDocBuilder();
					builder.addSourceTree(new File(getDirPath()));
					JavaClass[] _inspectableFiles = builder.getClasses();
					JsfFlexAttributeProperties _jsfFlexAttributeList;
					
					for(JavaClass _currClass : _inspectableFiles){
						_jsfFlexAttributeList = _currClass.getClass().getAnnotation(JsfFlexAttributeProperties.class);
						_inspectedMap = new LinkedHashMap<String, String>();
						
						if(_jsfFlexAttributeList == null || _jsfFlexAttributeList.componentFamily() == null || 
									_jsfFlexAttributeList.componentFamily().length() == 0){
							continue;
						}
						
						_inspectedMap.put(COMPONENT_FAMILY_KEY, _jsfFlexAttributeList.componentFamily());
						_inspectedMap.put(RENDERER_NAME_KEY, _jsfFlexAttributeList.rendererName());
						_inspectedMap.put(RENDERER_CLASS_KEY, _jsfFlexAttributeList.rendererClass());
						
						inspectFileFinished(_inspectedMap, _currClass.getName(), _currClass.getPackage());
					}
					
					inspectionCompleted();
				}
			};
			
		}
		
		_jsfFlexInspector.addInspectListener(this);
		
		_jsfFlexInspector.inspectFiles();
		
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
	
	public void inspectionCompleted(){
		
		String _toCreateMxmlRenderKitXMLFilePath = toCreateMxmlRenderKitXMLPath.getPath();
		
		try{
			File _mxmlRenderKitFilePath = new File(_toCreateMxmlRenderKitXMLFilePath);
			if(!_mxmlRenderKitFilePath.exists()){
				_mxmlRenderKitFilePath.mkdirs();
			}
			_toCreateMxmlRenderKitXMLFilePath +=  File.separatorChar + TO_CREATE_MXML_RENDERKIT_XML_FILE_NAME; 
			FileWriter _writer = new FileWriter(new File(_toCreateMxmlRenderKitXMLFilePath));
			Map<String, Object> _contextInfoMap = new HashMap<String, Object>();
			
			_contextInfoMap.put(JSF_FLEX_RENDERERLIST_ATTRIBUTE, _rendererMap);
			_jsfFlexVelocityParser.mergeCollectionToTemplate(JSF_FLEX_RENDERKIT_XML_TEMPLATE, _contextInfoMap, _writer);
			
		}catch(IOException _ioException){
			
		}
		
	}
	
	public void mergeCollectionToTemplateFinished() {
		
	}
	
}
