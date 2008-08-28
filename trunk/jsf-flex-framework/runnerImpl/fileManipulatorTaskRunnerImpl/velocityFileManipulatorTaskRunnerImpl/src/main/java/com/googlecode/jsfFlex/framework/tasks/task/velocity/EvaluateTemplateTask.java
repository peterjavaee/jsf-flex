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
package com.googlecode.jsfFlex.framework.tasks.task.velocity;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;
import com.googlecode.jsfFlex.framework.tasks._Task;

/**
 * @author Ji Hoon Kim
 */
public final class EvaluateTemplateTask extends _Task {
	
	private final static Log _log = LogFactory.getLog(EvaluateTemplateTask.class);
	
	private VelocityEngine _velocityEngine;
	private VelocityContext _context;
	private Properties _initProperties;
	private Map _contextValues;
	private String _logTag;
	private Reader _template;
	private Writer _writer;
	
	public EvaluateTemplateTask(){
		super();
	}
	
	public EvaluateTemplateTask(Properties initProperties, Map contextValues, String logTag, 
									Reader template, Writer writer){
		super();
		_initProperties = initProperties;
		_contextValues = contextValues;
		_logTag = logTag;
		_template = template;
		_writer = writer;
	}
	
	{
		_velocityEngine = new VelocityEngine();
		_context = new VelocityContext();
	}

	protected void performTask() throws ComponentBuildException {
		
		init();
		populateContext();
		mergeCollectionToTemplate();
		
	}
	
	private void init(){
		try{
			if(_initProperties != null){
				_velocityEngine.init(_initProperties);
			}else{
				_velocityEngine.init();
			}
			
		}catch(Exception _exceptionWhileInitializing){
			StringBuffer errorMessage = new StringBuffer();
			errorMessage.append("Error in MergeTemplateTask's init with following fields \n");
			errorMessage.append(toString());
			throw new ComponentBuildException(errorMessage.toString(), _exceptionWhileInitializing);
		}
		
	}
	
	private void populateContext(){
		Iterator _keys = _contextValues.keySet().iterator();
		Object _key;
		Object _value;
		
		while(_keys.hasNext()){
			_key = _keys.next();
			_value = _contextValues.get(_key);
			_context.put(_key.toString(), _value);
		}
		
	}
	
	private void mergeCollectionToTemplate() throws ComponentBuildException {
		
		try{
			_velocityEngine.evaluate(_context, _writer, _logTag, _template);
			_writer.flush();
			_log.debug("Executiong has been completed for " + toString());
		}catch(Exception _exceptionWhileMerging){
			StringBuffer errorMessage = new StringBuffer();
			errorMessage.append("Error in MergeTemplateTask's mergeCollectionToTemplate with following fields \n");
			errorMessage.append(toString());
			throw new ComponentBuildException(errorMessage.toString(), _exceptionWhileMerging);
		}finally{
			try{
				if(_writer != null){
					_writer.close();
				}
			}catch(IOException closerException){
				_log.debug("Error while closing the writer within mergeCollectionToTemplate", closerException);
			}
		}
		
	}
	
	public String toString() {
		StringBuffer content = new StringBuffer();
		
		content.append("contextValues [ ");
		Iterator _keys = _contextValues.keySet().iterator();
		Object _key;
		Object _value;
		while(_keys.hasNext()){
			_key = _keys.next();
			_value = _contextValues.get(_key);
			content.append(_key.toString());
			content.append(":");
			content.append(_value.toString());
			if(_keys.hasNext()){
				content.append(", ");
			}
		}
		content.append(" ] ");
		content.append(" logTag [ ");
		content.append(_logTag);
		content.append(" ] ");
		
		return content.toString();
	}

	public Map getContextValues() {
		return _contextValues;
	}
	public void setContextValues(Map contextValues) {
		_contextValues = contextValues;
	}
	public Properties getInitProperties() {
		return _initProperties;
	}
	public void setInitProperties(Properties initProperties) {
		_initProperties = initProperties;
	}
	public String getLogTag() {
		return _logTag;
	}
	public void setLogTag(String logTag) {
		_logTag = logTag;
	}
	public Reader getTemplate() {
		return _template;
	}
	public void setTemplate(Reader template) {
		_template = template;
	}
	public Writer getWriter() {
		return _writer;
	}
	public void setWriter(Writer writer) {
		_writer = writer;
	}
	
}
