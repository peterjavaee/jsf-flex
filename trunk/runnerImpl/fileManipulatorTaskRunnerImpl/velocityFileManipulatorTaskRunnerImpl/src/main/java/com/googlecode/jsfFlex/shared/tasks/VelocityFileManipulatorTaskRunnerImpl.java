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
package com.googlecode.jsfFlex.shared.tasks;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.googlecode.jsfFlex.shared.exception.ComponentBuildException;
import com.googlecode.jsfFlex.shared.tasks.velocity.EvaluateTemplateTask;

/**
 * A Velocity implementation of _FileManipulatorTaskRunner interface.<br>
 * 
 * @author Ji Hoon Kim
 */
final class VelocityFileManipulatorTaskRunnerImpl extends _FileManipulatorTaskRunner {
	
	private final static String JSF_FLEX_LOG_TAG = "jsf-flex";
	private final static String JSF_FLEX_TEMPLATE = "jsf-flex-template.vm";
	private final static String TOKEN_LIST_TOKEN = "tokenList";
	private final static String MXML_COMPONENT_NAME_TOKEN = "mxmlComponent";
	private final static String INITIAL_BODY_CONTENT_TOKEN = "initialBodyContent";
	private final static String CHILD_PRE_MXML_IDENTIFIER_TOKEN = "childIdentifier";
	private final static String SIBLING_PRE_MXML_IDENTIFIER_TOKEN = "siblingIdentifier";
	
	VelocityFileManipulatorTaskRunnerImpl(){
		super();
	}
	
	public synchronized void createFileContent(String _filePath, String _templateFile, Properties _initProperties, Map _tokenMap){
		
		try{
			Reader _templateReader = new InputStreamReader(EvaluateTemplateTask.class.getResourceAsStream(_templateFile));
			FileWriter _targetWriter = new FileWriter(new File(_filePath));
			EvaluateTemplateTask _mergeTemplateTask = new EvaluateTemplateTask(_initProperties, _tokenMap, JSF_FLEX_LOG_TAG, _templateReader, _targetWriter);
			addTask(_mergeTemplateTask);
			
		}catch(IOException _ioException){
			StringBuffer _errorMessage = new StringBuffer();
			_errorMessage.append("filePath [ ");
			_errorMessage.append(_filePath);
			_errorMessage.append(" ] ");
			_errorMessage.append("templateFile [ ");
			_errorMessage.append(_templateFile);
			_errorMessage.append(" ] ");
			
			if(_tokenMap != null){
				
				_errorMessage.append("overView of tokenMap [ ");
				for(Iterator keyIterate = _tokenMap.keySet().iterator(); keyIterate.hasNext();){
					String key = (String) keyIterate.next();
					_errorMessage.append("key : ");
					_errorMessage.append(key);
					_errorMessage.append(", value : ");
					
					Object value = _tokenMap.get(key);
					_errorMessage.append(value.toString());
					_errorMessage.append(" ");
					
				}
				_errorMessage.append(" ] ");
			}
			
			throw new ComponentBuildException(_errorMessage.toString(), _ioException);
		}
		
	}
	
	public synchronized void createPreMxmlFile(String _preMxmlFilePath, Properties _initProperties, Set _tokenList, String _mxmlComponentName, 
													String _bodyContent, String _childIdentifier, String _siblingIdentifier) {
		if(_tokenList == null){
			_tokenList = new LinkedHashSet();
		}
		
		_bodyContent = _bodyContent == null ? "" : _bodyContent;
		
		Map _tokenMap = new HashMap();
		_tokenMap.put(TOKEN_LIST_TOKEN, _tokenList);
		_tokenMap.put(MXML_COMPONENT_NAME_TOKEN, _mxmlComponentName);
		_tokenMap.put(INITIAL_BODY_CONTENT_TOKEN, _bodyContent);
		_tokenMap.put(CHILD_PRE_MXML_IDENTIFIER_TOKEN, _childIdentifier);
		_tokenMap.put(SIBLING_PRE_MXML_IDENTIFIER_TOKEN, _siblingIdentifier);
		
		createFileContent(_preMxmlFilePath, JSF_FLEX_TEMPLATE, _initProperties, _tokenMap);
		
	}
	
}
