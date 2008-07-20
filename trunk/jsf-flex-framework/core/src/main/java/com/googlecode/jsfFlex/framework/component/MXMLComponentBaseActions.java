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
package com.googlecode.jsfFlex.framework.component;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.googlecode.jsfFlex.framework._Component;
import com.googlecode.jsfFlex.framework.context.MxmlContext;
import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;
import com.googlecode.jsfFlex.framework.mapper.MXMLAttributeMapper;
import com.googlecode.jsfFlex.framework.mapper.MXMLMethodMapper;
import com.googlecode.jsfFlex.framework.mapper._MXMLMapper;
import com.googlecode.jsfFlex.framework.tasks._CommonTaskRunner;
import com.googlecode.jsfFlex.framework.tasks._FlexTaskRunner;
import com.googlecode.jsfFlex.framework.util.MXMLConstants;
import com.googlecode.jsfFlex.framework.util._FileManipulator;
import com.googlecode.jsfFlex.shared.adapter._MXMLApplicationContract;
import com.googlecode.jsfFlex.shared.adapter._MXMLContract;

/**
 * @author Ji Hoon Kim
 */
public abstract class MXMLComponentBaseActions implements _Component {
	
	private final static Log _log = LogFactory.getLog(MXMLComponentBaseActions.class);
	
	private static final String BY_ATTRIBUTE = "byAttribute";
	private static final String BY_METHOD = "byMethod";
	
	private MXMLReplaceMappingHandler _mxmlReplaceMappingHandler;
	private _MXMLMapper _mapper;
	private Map _replaceTextLists;
	private Set _filterOutAttributes;
	
	protected MXMLComponentBaseActions(){
		super();
		_replaceTextLists = new HashMap();
		_filterOutAttributes = new HashSet();
		_mapper = MXMLAttributeMapper.getInstance();
		_mxmlReplaceMappingHandler = new MXMLReplaceMappingHandler();
	}
	
	protected void execute() throws ComponentBuildException {
		getCurrCommonTaskRunner().execute();
		getFlexTaskRunner().execute();
	}
	
	protected void addCreatePreMxmlTask(_MXMLContract comp, String mxmlInputTemplatePath) throws ComponentBuildException {
		getFlexTaskRunner().addCreatePreMxmlTask(comp, mxmlInputTemplatePath, getComponentTemplate(mxmlInputTemplatePath));
	}
	
	protected void addInsertComponentTemplateTask(_MXMLContract comp, String contentToken, String contentTemplate) throws ComponentBuildException {
		getFlexTaskRunner().addInsertComponentTemplateTask(comp, contentToken, contentTemplate);
	}
	
	protected void addMakeDirectoryTask(String directoryToCreate) throws ComponentBuildException {
		getFlexTaskRunner().addMakeDirectoryTask(directoryToCreate);
	}
	
	protected void addReplaceTokenWithValueTask(_MXMLContract applicationInstance, String valueToReplaceWith, String tokenReplace) throws ComponentBuildException {
		getFlexTaskRunner().addReplaceTokenWithValueTask(applicationInstance, valueToReplaceWith, tokenReplace);
	}
	
	protected void createMXML(_MXMLContract applicationInstance, String copyTo) throws ComponentBuildException {
		getFlexTaskRunner().createMXML(applicationInstance, copyTo);
	}
	
	protected void createMxmlcSourceFiles(String _mxmlPath, String[] _systemSourceFiles) throws ComponentBuildException {
		getFlexTaskRunner().createMxmlcSourceFiles(_mxmlPath, _systemSourceFiles);
	}
	
	protected void createSWF(_MXMLApplicationContract componentMXML, String mxmlFile, 
									String swfPath, String flexSDKRootPath) throws ComponentBuildException {
		getFlexTaskRunner().createSWF(componentMXML, mxmlFile, swfPath, flexSDKRootPath);
	}
	
	protected void createSwfSourceFiles(String _swfBasePath, String[] _systemSwfSourceFiles) throws ComponentBuildException {
		getFlexTaskRunner().createSwfSourceFiles(_swfBasePath, _systemSwfSourceFiles);
	}
	
	public void deleteResources(String deleteResource, boolean isDirectory) throws ComponentBuildException {
		getFlexTaskRunner().deleteResources(deleteResource, isDirectory);
	}
	
	protected void unZipFlexSDK(String _unZipFile, String _unZipDest) throws ComponentBuildException {
		getCurrCommonTaskRunner().unZipFile(_unZipFile, _unZipDest);
	}
	
	protected void addReplaceTokenTask(_MXMLContract comp) throws ComponentBuildException {
		getFlexTaskRunner().addReplaceTokenTask(comp, getReplaceTextLists());
	}
	
	protected void mapFields(Object componentObj, String mappingFile) throws ComponentBuildException {
		try{
			
			SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
			_mxmlReplaceMappingHandler.setComponentObj(componentObj);
			parser.parse(MXMLComponentBase.class.getClassLoader().getResourceAsStream(mappingFile), _mxmlReplaceMappingHandler);
		}catch(SAXException saxExcept){
			Exception except = saxExcept.getException();
			if(except != null && except instanceof ComponentBuildException){
				throw (ComponentBuildException) except;
			}else{
				throw new ComponentBuildException(getErrorMessage("mapFields", mappingFile), saxExcept);
			}
		}catch(ParserConfigurationException parserConfigExcept){
			throw new ComponentBuildException(getErrorMessage("mapFields", mappingFile), parserConfigExcept);
		}catch(IOException ioExcept){
			throw new ComponentBuildException(getErrorMessage("mapFields", mappingFile), ioExcept);
		}
	}
	
	public String getComponentTemplate(String template) throws ComponentBuildException {
		
		return getCurrFileManipulator().getComponentTemplate(template);
	}
	
	protected String readFileContent(String fileName) throws ComponentBuildException {
		
		return getCurrFileManipulator().readFileContent(fileName);
	}
	
	protected String childReplaceTokenWithPreMxmlIdentifier(_MXMLContract currInstance){
		StringBuffer toReturn = new StringBuffer();
		
		toReturn.append(MXMLConstants.CHILD_REPLACE_TOKEN_PREMXML_IDENTIFIER_PRE);
		toReturn.append(currInstance.getPreMxmlIdentifier());
		toReturn.append(MXMLConstants.CHILD_REPLACE_TOKEN_PREMXML_IDENTIFIER_SUFF);
		
		return toReturn.toString();
	}
	
	protected String siblingReplaceTokenWithPreMxmlIdentifier(_MXMLContract currInstance){
		StringBuffer toReturn = new StringBuffer();
		
		toReturn.append(MXMLConstants.SIBLING_REPLACE_TOKEN_PREMXML_IDENTIFIER_PRE);
		toReturn.append(currInstance.getPreMxmlIdentifier());
		toReturn.append(MXMLConstants.SIBLING_REPLACE_TOKEN_PREMXML_IDENTIFIER_SUFF);
		
		return toReturn.toString();
	}
	
	private static String getErrorMessage(String caller, String parameter){
		StringBuffer errorMessage = new StringBuffer();
		errorMessage.append("Exception when ");
		errorMessage.append(caller);
		errorMessage.append(" with parameter(s) [ ");
		errorMessage.append(parameter);
		errorMessage.append(" ] ");
		return errorMessage.toString();
	}
	
	private _CommonTaskRunner getCurrCommonTaskRunner(){
		MxmlContext mxmlContext = MxmlContext.getCurrentInstance();
		return mxmlContext.getCommonRunner();
	}
		
	private _FileManipulator getCurrFileManipulator(){
		MxmlContext mxmlContext = MxmlContext.getCurrentInstance();
		return mxmlContext.getFileManipulator();
	}
	
	protected _FlexTaskRunner getFlexTaskRunner(){
		MxmlContext mxmlContext = MxmlContext.getCurrentInstance();
		return mxmlContext.getFlexRunner();
	}
	
	protected Map getReplaceTextLists() {
		return _replaceTextLists;
	}
	
	protected void addMapperFilterString(String toBlankOut){
		_filterOutAttributes.add(toBlankOut);
	}
	
	protected void setMapper(_MXMLMapper mapperToSet){
		_mapper = mapperToSet;
	}
	
	private class MXMLReplaceMappingHandler extends DefaultHandler{
		
		private Object componentObj;
		
		private StringBuffer nodeValue;
		private String replace_token;
		private String jsf_attribute;
		
		private boolean replace_tokenCheck;
		private boolean byMethod;
		
		private String _tokenToBlankOut;
		
		private MXMLReplaceMappingHandler(){
			super();
		}
		
		private void setComponentObj(Object componentObj){
			this.componentObj = componentObj;
		}
		
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			super.startElement(uri, localName, qName, attributes);
			
			if(qName.equals("replace-token")){
				replace_tokenCheck = true;
				byMethod = (attributes.getLength() == 0 || (jsf_attribute = attributes.getValue(BY_ATTRIBUTE)) == null);
				//byMethod = (attributes.getLength() != 0 && (jsf_attribute = attributes.getValue(BY_METHOD)) != null);
			}
			
			nodeValue = new StringBuffer();
		}
		
		public void endElement(String uri, String localName, String qName) throws SAXException {
			super.endElement(uri, localName, qName);
			String currentValue = null;
			
			if(nodeValue != null){
				currentValue = nodeValue.toString().trim();
			}
			
			if(replace_tokenCheck){
				replace_token = currentValue;
				try{
					/*
					 * Later change this to byMethod check [meaning default of byAttribute]
					 * Hopefully this would be doable with the change of plugIn
					 */
					if(byMethod){
						setMapper(MXMLMethodMapper.getInstance());
					}else{
						setMapper(MXMLAttributeMapper.getInstance());
					}
					if(_filterOutAttributes.contains(replace_token)){
						//since filtering out this attribute, replace with a blank
						_tokenToBlankOut = "${" + replace_token + "}";
						_replaceTextLists.put(_tokenToBlankOut, "");
						return;
					}
					
					_mapper.mapField(jsf_attribute, replace_token, componentObj, _replaceTextLists);
				}catch(ComponentBuildException componentBuildExcept){
					//HACK, change later when attribute Map for the plugin works
					_log.debug("For " + componentObj.getClass().getName() + " lacking " + replace_token);
					setMapper(MXMLAttributeMapper.getInstance());
					_mapper.mapField(jsf_attribute, replace_token, componentObj, _replaceTextLists);
					//throw new SAXException(componentBuildExcept);
				}
				replace_tokenCheck = false;
			}
			
		}
		
		public void characters(char[] ch, int start, int length) throws SAXException {
			super.characters(ch, start, length);
			if(!replace_tokenCheck){
				return;
			}
			nodeValue.append(new String(ch, start, length));
		}
		
	}
	
}
