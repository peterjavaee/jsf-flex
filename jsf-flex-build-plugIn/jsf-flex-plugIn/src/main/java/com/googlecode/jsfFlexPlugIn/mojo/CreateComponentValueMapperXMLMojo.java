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
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;

import com.googlecode.jsfFlex.framework.annotation.JsfFlexAttributeProperties;
import com.googlecode.jsfFlex.framework.annotation.JsfFlexComponentNodeAttribute;
import com.googlecode.jsfFlexPlugIn.inspector._JsfFlexInspectListener;
import com.googlecode.jsfFlexPlugIn.inspector._JsfFlexInspectorBase;
import com.googlecode.jsfFlexPlugIn.inspector.qdox.JsfFlexQdoxInspector;
import com.googlecode.jsfFlexPlugIn.parser._JsfFlexParserListener;
import com.googlecode.jsfFlexPlugIn.parser.velocity.JsfFlexVelocityParser;
import com.googlecode.jsfFlexPlugIn.utils.tasks.ReplaceText;
import com.thoughtworks.qdox.JavaDocBuilder;
import com.thoughtworks.qdox.model.JavaClass;

/**
 * @goal    createComponentValueMapperXML
 * @phase   generate-resources
 * @author Ji Hoon Kim
 */
public class CreateComponentValueMapperXMLMojo extends AbstractMojo 
											   implements _JsfFlexInspectListener, _JsfFlexParserListener {
	
	private static final String JSF_FLEX_COMPONENT_VALUE_CLASS_INFO_ATTRIBUTE = "JsfFlexComponentValueClassInfo";
	private static final String JSF_FLEX_COMPONENT_NODE_ATTRIBUTE = "JsfFlexComponentNodeAttribute";
	
	private static final String CORE_PROJECT_NAME = "core";
	private static final String COMPONENT_14_PROJECT_NAME = "component14";
	private static final String COMPONENT_15_PROJECT_NAME = "component15";
	
	private static final String JSF_FLEX_CLASS_SET_ATTRIBUTE = "classSet";
	private static final String JSF_FLEX_COMPONENT_VALUE_MAPPER_TEMPLATE = "jsf-flex-componentValueMapperXML.vm";
	private static final String TO_CREATE_COMPONENT_VALUE_MAPPER_XML_FILE_NAME = "componentValueMapper.xml";
	private static final String FILE_RESOURCE_LOADER_PATH_KEY = "file.resource.loader.path";
	
	private static final String MXML_CLASS_PACKAGE_KEY = "classPackage";
	private static final String MXML_CLASS_NAME_KEY = "className";
	
	private static final String HTML_TYPE_KEY = "htmlType";
	private static final String TYPE_ATTRIBUTE_VALUE_KEY = "typeAttributeValue";
	
	private static final String VALUE_ATTRIBUTE_VALUE_KEY = "valueAttributeValue";
	private static final String VALUE_DYNAMIC_KEY = "valueDynamic";
	private static final String VALUE_NESTED_KEY = "valueNested";
	private static final String VALUE_NESTED_VALUES_KEY = "valueNestedValues";
	
	private static final String NAME_ATTRIBUTE_VALUE_KEY = "nameAttributeValue";
	private static final String NAME_DYNAMIC_KEY = "nameDynamic";
	private static final String NAME_APPEND_KEY = "nameAppend";
	
	private _JsfFlexInspectorBase _jsfFlexInspector;
	private JsfFlexVelocityParser _jsfFlexVelocityParser;
	
	/**
	 * @parameter expression="${project}"
	 */
	private MavenProject project;
	
	/**
     * @parameter expression="${targetComponentProject}"
     */
	private String targetComponentProject;
	
	/**
     * @parameter expression="${basedir}/target/classes/com/googlecode/jsfFlex/framework/swfSourceFiles"
     */
	private File toCreateComponentValueMapperXMLPath;
	
	/**
     * @parameter expression="src/main/resources/META-INF"
     */
    private File templateSourceDirectory;
    
    private Set<ClassInfo> _classInfoSet;
	
    public CreateComponentValueMapperXMLMojo(){
    	super();
    	_classInfoSet = new HashSet<ClassInfo>();
    }
    
    public static final class ClassInfo{
    	
    	private final String _fullClassName;
    	private final List<NodeInfo> _nodeList;
    	
    	private ClassInfo(){
    		super();
    		_fullClassName = null;
    		_nodeList = null;
    	}
    	
    	public ClassInfo(String fullClassName){
    		super();
    		_fullClassName = fullClassName;
    		_nodeList = new LinkedList<NodeInfo>();
    	}
    	
    	public void addNodeInfo(NodeInfo _nodeInfo){
    		_nodeList.add(_nodeInfo);
    	}
    	
		public String getFullClassName() {
			return _fullClassName;
		}
		public List<NodeInfo> getNodeList() {
			return _nodeList;
		}
		
		@Override
		public boolean equals(Object _instance) {
			if(!(_instance instanceof ClassInfo)){
				return false;
			}
			
			ClassInfo _classInfoInstance = (ClassInfo) _instance;
			return this._fullClassName.equals(_classInfoInstance.getFullClassName());
		}
		
		@Override
		public int hashCode() {
			return _fullClassName.hashCode();
		}
    	
    }
    
    public static final class NodeInfo{
    	
    	private final String _htmlType;
    	private final String _typeAttributeValue;
    	
    	private final Boolean _valueNested;
    	private final Boolean _valueDynamic;
    	private final String _valueAttributeValue;
    	private final List<String> _nestedList;
    	
    	private final Boolean _nameDynamic;
    	private final String _nameAppend;
    	private final String _nameAttributeValue;
    	
    	private NodeInfo(){
    		super();
    		_htmlType = null;
    		_typeAttributeValue = null;
    		
    		_valueNested = Boolean.FALSE;
    		_valueDynamic = Boolean.FALSE;
    		_valueAttributeValue = null;
    		_nestedList = null;
    		
    		_nameDynamic = Boolean.FALSE;
    		_nameAppend = null;
    		_nameAttributeValue = null;
    	}
    	
    	public NodeInfo(String htmlType, String typeAttributeValue, Boolean valueNested, Boolean valueDynamic,
    						String valueAttributeValue, List<String> nestedList, Boolean nameDynamic, 
    						String nameAppend, String nameAttributeValue){
    		super();
    		_htmlType = htmlType;
    		_typeAttributeValue = typeAttributeValue;
    		
    		_valueNested = valueNested;
    		_valueDynamic = valueDynamic;
    		_valueAttributeValue = valueAttributeValue;
    		_nestedList = nestedList;
    		
    		_nameDynamic = nameDynamic;
    		_nameAppend = nameAppend;
    		_nameAttributeValue = nameAttributeValue;
    	}

		public String getHtmlType() {
			return _htmlType;
		}
		public String getNameAppend() {
			return _nameAppend;
		}
		public String getNameAttributeValue() {
			return _nameAttributeValue;
		}
		public Boolean isNameDynamic() {
			return _nameDynamic;
		}
		public List<String> getNestedList() {
			/*
			 * since it's final it should be returned as a defensive copy,
			 * but it's a plug-in so return it
			 */
			return _nestedList;
		}
		public String getTypeAttributeValue() {
			return _typeAttributeValue;
		}
		public String getValueAttributeValue() {
			return _valueAttributeValue;
		}
		public Boolean isValueDynamic() {
			return _valueDynamic;
		}
		public Boolean isValueNested() {
			return _valueNested;
		}
    	
    }
	
	public void execute() throws MojoExecutionException, MojoFailureException {
		
		//HACK for now, since QDOX seems to have issues reading Java files with annotations
		targetComponentProject = COMPONENT_14_PROJECT_NAME;
		
		String _currDirPath = (String) project.getCompileSourceRoots().get(0);
		_currDirPath = (targetComponentProject.equals(COMPONENT_14_PROJECT_NAME)) ? 
												_currDirPath.replace(CORE_PROJECT_NAME, COMPONENT_14_PROJECT_NAME) : 
												_currDirPath.replace(CORE_PROJECT_NAME, COMPONENT_15_PROJECT_NAME);
		
		Properties _velocityParserProperties = new Properties();
		_velocityParserProperties.put(FILE_RESOURCE_LOADER_PATH_KEY, templateSourceDirectory.getPath());
		
		_jsfFlexVelocityParser = new JsfFlexVelocityParser(_velocityParserProperties);
		_jsfFlexVelocityParser.init();
		_jsfFlexVelocityParser.addParserListener(this);
		
		if(targetComponentProject.equals(COMPONENT_14_PROJECT_NAME)){
			_jsfFlexInspector = new JsfFlexQdoxInspector(_currDirPath, JSF_FLEX_COMPONENT_VALUE_CLASS_INFO_ATTRIBUTE, 
															JSF_FLEX_COMPONENT_NODE_ATTRIBUTE);
		}else{
			
			_jsfFlexInspector = new _JsfFlexInspectorBase(_currDirPath){
				public void inspectFiles(){
					/*
					 * In order to keep in synch with the QDox parsing, following is the 
					 * format to be inserted into the LinkedList<Map<String, ? extends Object>> :
					 * 		(1) Map containing 	CLASS_PACKAGE_KEY
					 * 							CLASS_NAME_KEY
					 * 
					 * 		(2) Map containing 	HTML_TYPE_KEY
					 * 							TYPE_ATTRIBUTE_VALUE_KEY
					 * 							
					 * 							VALUE_ATTRIBUTE_VALUE_KEY
					 * 							VALUE_DYNAMIC_KEY
					 * 							VALUE_NESTED_KEY
					 * 							VALUE_NESTED_VALUES_KEY
					 * 							
					 * 							NAME_ATTRIBUTE_VALUE_KEY
					 * 							NAME_DYNAMIC_KEY
					 * 							NAME_APPEND_KEY
					 * 							
					 */
					List<Map<String, ? extends Object>> _inspectedList;
					Map<String, String> _inspectedMap;
					JavaDocBuilder builder = new JavaDocBuilder();
					builder.addSourceTree(new File(getDirPath()));
					JavaClass[] _inspectableFiles = builder.getClasses();
					JsfFlexAttributeProperties _jsfFlexAttributeList;
					StringBuilder _toBuildString;
					String _builtString;
					
					for(JavaClass _currClass : _inspectableFiles){
						_jsfFlexAttributeList = _currClass.getClass().getAnnotation(JsfFlexAttributeProperties.class);
						_inspectedList = new LinkedList<Map<String, ? extends Object>>();
						_inspectedMap = new LinkedHashMap<String, String>();
						
						if(_jsfFlexAttributeList == null || _jsfFlexAttributeList.mxmlComponentPackage() == null || 
									_jsfFlexAttributeList.mxmlComponentName().length() == 0){
							continue;
						}
						
						_inspectedMap.put(MXML_CLASS_PACKAGE_KEY, _jsfFlexAttributeList.mxmlComponentPackage());
						_inspectedMap.put(MXML_CLASS_NAME_KEY, _jsfFlexAttributeList.mxmlComponentName());
						
						_inspectedList.add(_inspectedMap);
						//have added Map info containing CLASS_* info
						
						for(JsfFlexComponentNodeAttribute _currComponentNodeInfo : _jsfFlexAttributeList.componentNodeAttributes()){
							_inspectedMap = new LinkedHashMap<String, String>();
							
							_inspectedMap.put(HTML_TYPE_KEY, _currComponentNodeInfo.htmlType());
							_inspectedMap.put(TYPE_ATTRIBUTE_VALUE_KEY, _currComponentNodeInfo.typeAttributeValue());
							
							_inspectedMap.put(VALUE_ATTRIBUTE_VALUE_KEY, _currComponentNodeInfo.valueAttributeValue());
							_inspectedMap.put(VALUE_DYNAMIC_KEY, String.valueOf(_currComponentNodeInfo.isValueDynamic()));
							_inspectedMap.put(VALUE_NESTED_KEY, String.valueOf(_currComponentNodeInfo.isValueNested()));
							
							if(_currComponentNodeInfo.isValueNested()){
								_toBuildString = new StringBuilder();
								
								for(String _buildInto : _currComponentNodeInfo.valueNestedValues()){
									_toBuildString.append(_buildInto);
									_toBuildString.append("_");
								}
								
								_toBuildString.deleteCharAt(_toBuildString.length()-1);
								_builtString = _toBuildString.toString();
							}else{
								_builtString = "";
							}
							
							_inspectedMap.put(VALUE_NESTED_VALUES_KEY, _builtString);
							
							_inspectedMap.put(NAME_ATTRIBUTE_VALUE_KEY, _currComponentNodeInfo.nameAttributeValue());
							_inspectedMap.put(NAME_DYNAMIC_KEY, String.valueOf(_currComponentNodeInfo.isNameDynamic()));
							_inspectedMap.put(NAME_APPEND_KEY, _currComponentNodeInfo.nameAppend());
							
							_inspectedList.add(_inspectedMap);
						}
						
						inspectFileFinished(_inspectedList, _currClass.getName(), _currClass.getPackage());
					}
					
					inspectionCompleted();
				}
			};
			
		}
		
		_jsfFlexInspector.addInspectListener(this);
		
		_jsfFlexInspector.inspectFiles();
		
	}
	
	public void inspectFileFinished(List<Map<String, ? extends Object>> _inspectedList, String _sourceInspected, String _package) {
		
		ClassInfo _currClassInfo = null;
		
		for(Map<String, ? extends Object> _inspected : _inspectedList){
		
			if(_inspected != null && _inspected.size() > 0){
				
				if(_currClassInfo == null){
					String _classPackage = (String) _inspected.get(MXML_CLASS_PACKAGE_KEY);
					String _className = (String) _inspected.get(MXML_CLASS_NAME_KEY);
					
					String _fullClassName = _classPackage + "::" + _className;
					
					_currClassInfo  = new ClassInfo(_fullClassName);
					_classInfoSet.add(_currClassInfo);
					continue;
				}
				//created the ClassInfo instance and now created the NodeInfo to add
				
				Object htmlType = _inspected.get(HTML_TYPE_KEY);
				Object typeAttributeValue = _inspected.get(TYPE_ATTRIBUTE_VALUE_KEY);
				
				Object valueAttributeValue = _inspected.get(VALUE_ATTRIBUTE_VALUE_KEY);
				Boolean isValueDynamic = _inspected.get(VALUE_DYNAMIC_KEY) != null && _inspected.get(VALUE_DYNAMIC_KEY).equals("true");
				Boolean isValueNested = _inspected.get(VALUE_NESTED_KEY) != null && _inspected.get(VALUE_NESTED_KEY).equals("true");
				Object valueNestedValues = _inspected.get(VALUE_NESTED_VALUES_KEY);
				List<String> valueNestedList;
				if(valueNestedValues != null){
					valueNestedList = Arrays.asList( ((String) valueNestedValues).split("_") );
				}else{
					valueNestedList = new LinkedList<String>();
				}
				
				Object nameAttributeValue = _inspected.get(NAME_ATTRIBUTE_VALUE_KEY);
				Boolean isNameDynamic = _inspected.get(NAME_DYNAMIC_KEY) != null && _inspected.get(NAME_DYNAMIC_KEY).equals("true");
				Object nameAppend = _inspected.get(NAME_APPEND_KEY);
				
				_currClassInfo.addNodeInfo(new NodeInfo(returnEmptyStringForNull(htmlType), returnEmptyStringForNull(typeAttributeValue), isValueNested, 
															isValueDynamic, returnEmptyStringForNull(valueAttributeValue), valueNestedList, isNameDynamic, 
															returnEmptyStringForNull(nameAppend), returnEmptyStringForNull(nameAttributeValue)));
				
			}
		
		}
		
	}
	
	private String returnEmptyStringForNull(Object checkForNull){
		return checkForNull == null ? "" : checkForNull.toString();
	}
	
	public void inspectionCompleted() {
		
		String _toCreateComponentValueMapperXMLPath = toCreateComponentValueMapperXMLPath.getPath();
		
		try{
			File _toCreateComponentValueMapperXMLFilePath = new File(_toCreateComponentValueMapperXMLPath);
			if(!_toCreateComponentValueMapperXMLFilePath.exists()){
				_toCreateComponentValueMapperXMLFilePath.mkdirs();
			}
			_toCreateComponentValueMapperXMLPath +=  File.separatorChar + TO_CREATE_COMPONENT_VALUE_MAPPER_XML_FILE_NAME; 
			FileWriter _writer = new FileWriter(new File(_toCreateComponentValueMapperXMLPath));
			Map<String, Object> _contextInfoMap = new HashMap<String, Object>();
			
			_contextInfoMap.put(JSF_FLEX_CLASS_SET_ATTRIBUTE, _classInfoSet);
			_jsfFlexVelocityParser.mergeCollectionToTemplate(JSF_FLEX_COMPONENT_VALUE_MAPPER_TEMPLATE, _contextInfoMap, 
																_writer, _toCreateComponentValueMapperXMLPath);
			
		}catch(IOException _ioException){
			
		}
		
	}
	
	public void mergeCollectionToTemplateFinished(String _fileMerged) {
		
		ReplaceText removeEmptySpace = new ReplaceText(_fileMerged);
		removeEmptySpace.setReplaceRegExp(true);
		removeEmptySpace.setRegMatch(ReplaceText.CLEAN_REG_EXP_MATCH);
		removeEmptySpace.setRegReplace(ReplaceText.CLEAN_REG_EXP_REPLACE_WITH);
		
		removeEmptySpace.performTask();
		
	}
	
}
