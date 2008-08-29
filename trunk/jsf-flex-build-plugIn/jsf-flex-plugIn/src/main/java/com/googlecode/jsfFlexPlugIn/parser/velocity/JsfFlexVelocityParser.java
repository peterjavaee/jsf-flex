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
package com.googlecode.jsfFlexPlugIn.parser.velocity;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import com.googlecode.jsfFlexPlugIn.parser._JsfFlexParserListener;

/**
 * @author Ji Hoon Kim
 */
public class JsfFlexVelocityParser {
	
	private final static Log _log = LogFactory.getLog(JsfFlexVelocityParser.class);
	
	private List<_JsfFlexParserListener> _jsfFlexVelocityParserListeners;
	private VelocityEngine _velocityEngine;
	private VelocityContext _context;
	private Properties _initProperties;
	
	public JsfFlexVelocityParser(){
		super();
		_initProperties = null;
	}
	
	public JsfFlexVelocityParser(Properties initProperties){
		super();
		_initProperties = initProperties;
	}
	
	{
		_velocityEngine = new VelocityEngine();
		_context = new VelocityContext();
		_jsfFlexVelocityParserListeners = new LinkedList<_JsfFlexParserListener>();
	}
	
	public void init(){
		try{
			if(_initProperties != null){
				_velocityEngine.init(_initProperties);
			}else{
				_velocityEngine.init();
			}
			
		}catch(Exception _exceptionWhileInitializing){
			throw new RuntimeException(_exceptionWhileInitializing);
		}
		
	}
	
	public synchronized void mergeCollectionToTemplate(String _template, Map<String, Object> _contextInfo, Writer _targetWriter){
		
		String _currKey;
		for(Iterator<String> _contextInfoIterator = _contextInfo.keySet().iterator(); _contextInfoIterator.hasNext();){
			_currKey = _contextInfoIterator.next();
			_context.put(_currKey, _contextInfo.get(_currKey));
		}
		
		try{
			_velocityEngine.mergeTemplate(_template, _context, _targetWriter);
			_targetWriter.flush();
			
		}catch(Exception _exceptionWhileMerging){
			throw new RuntimeException(_exceptionWhileMerging);
		}finally{
			try{
				if(_targetWriter != null){
					_targetWriter.close();
				}
			}catch(IOException closerException){
				_log.debug("Error in closing the writer within mergeCollectionToTemplate", closerException);
			}
		}
		
		mergeCollectionToTemplateFinished();
	}
	
	public synchronized void addParserListener(_JsfFlexParserListener _callBack){
		_jsfFlexVelocityParserListeners.add(_callBack);
	}
	
	private synchronized void mergeCollectionToTemplateFinished(){
		for(_JsfFlexParserListener _mergeCollectionToTemplateCallBack : _jsfFlexVelocityParserListeners){
			_mergeCollectionToTemplateCallBack.mergeCollectionToTemplateFinished();
		}
	}
	
}
