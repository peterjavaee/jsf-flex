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
package com.googlecode.jsfFlex.framework.tasks;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;
import com.googlecode.jsfFlex.framework.tasks.task.velocity.EvaluateTemplateTask;

/**
 * A Velocity implementation of _FileManipulatorTaskRunner interface.<br>
 * 
 * @author Ji Hoon Kim
 */
public final class VelocityFileManipulatorTaskRunnerImpl extends _FileManipulatorTaskRunner {
	
	private final static String JSF_FLEX_LOG_TAG = "jsf-flex";
	private final static String JSF_FLEX_TEMPLATE = "jsf-flex-template.vm";
	private final static String TOKEN_LIST_TOKEN = "tokenList";
	private final static String MXML_COMPONENT_NAME_TOKEN = "mxmlComponent";
	private final static String BODY_CONTENT_TOKEN = "bodyContent";
	private final static String CHILD_PRE_MXML_IDENTIFIER_TOKEN = "childIdentifier";
	private final static String SIBLING_PRE_MXML_IDENTIFIER_TOKEN = "siblingIdentifier";
	
	private final static String JSF_FLEX_MXML_OBJECT_BEAN_TEMPLATE = "jsf-flex-mxml-object-bean-template.vm";
	private final static String MXML_OBJECT_SET_TEMP_FILE_NAME = "mxmlObjectSetTempFile.tmp";
	private final static String MXML_OBJECT_SET_TOKEN = "mxmlObjectSet";
	
	public VelocityFileManipulatorTaskRunnerImpl(){
		super();
	}
	
	public synchronized void createPreMxmlFile(String _preMxmlFilePath, Properties _initProperties, Set _tokenList, String _mxmlComponentName, 
													String _bodyContent, String _childIdentifier, String _siblingIdentifier) throws ComponentBuildException {
		if(_tokenList == null){
			_tokenList = new LinkedHashSet();
		}
		
		_bodyContent = _bodyContent == null ? "" : _bodyContent;
		
		Map _tokenMap = new HashMap();
		_tokenMap.put(TOKEN_LIST_TOKEN, _tokenList);
		_tokenMap.put(MXML_COMPONENT_NAME_TOKEN, _mxmlComponentName);
		_tokenMap.put(BODY_CONTENT_TOKEN, _bodyContent);
		_tokenMap.put(CHILD_PRE_MXML_IDENTIFIER_TOKEN, _childIdentifier);
		_tokenMap.put(SIBLING_PRE_MXML_IDENTIFIER_TOKEN, _siblingIdentifier);
		
		try{
			Reader _templateReader = new InputStreamReader(EvaluateTemplateTask.class.getResourceAsStream(JSF_FLEX_TEMPLATE));
			FileWriter _targetWriter = new FileWriter(new File(_preMxmlFilePath));
			EvaluateTemplateTask _mergeTemplateTask = new EvaluateTemplateTask(_initProperties, _tokenMap, JSF_FLEX_LOG_TAG, _templateReader, _targetWriter);
			addTask(_mergeTemplateTask);
			
		}catch(IOException _ioException){
			StringBuffer _errorMessage = new StringBuffer();
			_errorMessage.append("preMxmlFilePath [ ");
			_errorMessage.append(_preMxmlFilePath);
			_errorMessage.append(" ] ");
			
			_errorMessage.append("tokenList [ ");
			Object _tokenValue;
			for(Iterator _tokenIterator = _tokenList.iterator(); _tokenIterator.hasNext(); ){
				_tokenValue = _tokenIterator.next();
				_errorMessage.append(_tokenValue.toString());
				if(_tokenIterator.hasNext()){
					_errorMessage.append(" , ");
				}
			}
			_errorMessage.append(" ] ");
			
			_errorMessage.append("mxmlComponentName [ ");
			_errorMessage.append(_mxmlComponentName);
			_errorMessage.append(" ] ");
			_errorMessage.append("bodyContent [ ");
			_errorMessage.append(_bodyContent);
			_errorMessage.append(" ] ");
			
			throw new ComponentBuildException(_errorMessage.toString(), _ioException);
		}
	}
	
	public synchronized String generateMXMLObjectBeanContent(Set _mxmlObjectBeanSet, String _fileOutPutPath) throws ComponentBuildException {
		if(_mxmlObjectBeanSet == null){
			_mxmlObjectBeanSet = new HashSet();
		}
		
		Map _tokenMap = new HashMap();
		_tokenMap.put(MXML_OBJECT_SET_TOKEN, _mxmlObjectBeanSet);
		_fileOutPutPath += File.separatorChar + MXML_OBJECT_SET_TEMP_FILE_NAME;
		
		try{
			Reader _templateReader = new InputStreamReader(EvaluateTemplateTask.class.getResourceAsStream(JSF_FLEX_MXML_OBJECT_BEAN_TEMPLATE));
			FileWriter _targetWriter = new FileWriter(new File(_fileOutPutPath));
			EvaluateTemplateTask _mergeTemplateTask = new EvaluateTemplateTask(null, _tokenMap, JSF_FLEX_LOG_TAG, _templateReader, _targetWriter);
			addTask(_mergeTemplateTask);
			
		}catch(IOException _ioException){
			StringBuffer _errorMessage = new StringBuffer();
			_errorMessage.append("fileOutPutPath [ ");
			_errorMessage.append(_fileOutPutPath);
			_errorMessage.append(" ] ");
			throw new ComponentBuildException(_errorMessage.toString(), _ioException);
		}
		
		return readFileContent(_fileOutPutPath);
	}
	
}
