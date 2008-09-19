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

import java.io.IOException;
import java.util.Properties;

import com.googlecode.jsfFlex.renderkit.annotationDocletParser._AnnotationDocletParser;
import com.googlecode.jsfFlex.shared.tasks._CommonTaskRunner;
import com.googlecode.jsfFlex.shared.tasks._FileManipulatorTaskRunner;
import com.googlecode.jsfFlex.shared.tasks._FlexTaskRunner;

/**
 * Each implementation of _RunnerFactory should return a String specifying the package class<br>
 * for each of the following interfaces :<br>
 * <ul>
 *     <li> _CommonTaskRunner
 *     <li> _FileManipulatorTaskRunner
 *     <li> _FlexTaskRunner
 *     <li> _AnnotationDocletParser
 * </ul>
 * 
 * @author Ji Hoon Kim
 */
public abstract class _RunnerFactory {
	
	private static final String RUNNER_FACTORY_IMPL_PROPERTIES = "runnerFactoryImpl.properties";
	
	private static final String RUNNER_FACTORY_IMPL_PACKAGE_CLASS;
	private static final String RUNNER_FACTORY_IMPL_KEY = "runner_factory_impl";
	
	private static _RunnerFactory _instance;
	
	static{
		
		String runnerFactoryImplFromProperty = System.getProperty(RUNNER_FACTORY_IMPL_KEY);
		
		if(runnerFactoryImplFromProperty != null){
			RUNNER_FACTORY_IMPL_PACKAGE_CLASS = runnerFactoryImplFromProperty;
		}else{
			Properties _runnerFactoryImplProperties = new Properties();
			try{
				_runnerFactoryImplProperties.load(_RunnerFactory.class.getResourceAsStream(RUNNER_FACTORY_IMPL_PROPERTIES));
				RUNNER_FACTORY_IMPL_PACKAGE_CLASS = _runnerFactoryImplProperties.getProperty(RUNNER_FACTORY_IMPL_KEY);
			}catch(IOException _ioExcept){
				throw new RuntimeException("Exception thrown when loading of " + RUNNER_FACTORY_IMPL_PROPERTIES, _ioExcept);
			}
		}
	}
	
	protected _RunnerFactory(){
		super();
	}
	
	public final static synchronized _RunnerFactory getInstance(){
		final String METHOD = "getInstance()";
		
		if(_instance == null){
			try{
				Class _specificClass = Class.forName(RUNNER_FACTORY_IMPL_PACKAGE_CLASS);
				_instance = (_RunnerFactory) _specificClass.newInstance();
			}catch(ClassNotFoundException _classNotFound){
				throw new RuntimeException(errorMessage(METHOD, _classNotFound), _classNotFound);
			}catch(IllegalAccessException _illegalAccess){
				throw new RuntimeException(errorMessage(METHOD, _illegalAccess), _illegalAccess);
			}catch(InstantiationException _instantiation){
				throw new RuntimeException(errorMessage(METHOD, _instantiation), _instantiation);
			}
		}
		
		return _instance;
	}
	
	public final synchronized _CommonTaskRunner getCommonTaskRunnerImpl(){
		final String METHOD = "getCommonTaskRunnerImpl()";
		
		_CommonTaskRunner _specificInstance = null;
		String _commonTaskRunnerImplPackage = getCommonTaskRunnerImplPackage();
		
		try{
			Class _specificClass = Class.forName(_commonTaskRunnerImplPackage);
			_specificInstance = (_CommonTaskRunner) _specificClass.newInstance();
		}catch(ClassNotFoundException _classNotFound){
			throw new RuntimeException(errorMessage(METHOD, _classNotFound), _classNotFound);
		}catch(IllegalAccessException _illegalAccess){
			throw new RuntimeException(errorMessage(METHOD, _illegalAccess), _illegalAccess);
		}catch(InstantiationException _instantiation){
			throw new RuntimeException(errorMessage(METHOD, _instantiation), _instantiation);
		}
		
		return _specificInstance;
	}
	
	public final synchronized _FileManipulatorTaskRunner getFileManipulatorTaskRunnerImpl(){
		final String METHOD = "getFileManipulatorTaskRunnerImpl()";
		
		_FileManipulatorTaskRunner _specificInstance = null;
		String _fileManipulatorTaskRunnerImplPackage = getFileManipulatorTaskRunnerImplPackage();
		
		try{
			Class _specificClass = Class.forName(_fileManipulatorTaskRunnerImplPackage);
			_specificInstance = (_FileManipulatorTaskRunner) _specificClass.newInstance();
		}catch(ClassNotFoundException _classNotFound){
			throw new RuntimeException(errorMessage(METHOD, _classNotFound), _classNotFound);
		}catch(IllegalAccessException _illegalAccess){
			throw new RuntimeException(errorMessage(METHOD, _illegalAccess), _illegalAccess);
		}catch(InstantiationException _instantiation){
			throw new RuntimeException(errorMessage(METHOD, _instantiation), _instantiation);
		}
		
		return _specificInstance;
	}
	
	public final synchronized _AnnotationDocletParser getAnnotationDocletParserImpl(){
		final String METHOD = "getAnnotationDocletParserImpl()";
		
		_AnnotationDocletParser _specificInstance = null;
		String _annotationDocletParserImplPackage = getAnnotationDocletParserImplPackage();
		
		try{
			Class _specificClass = Class.forName(_annotationDocletParserImplPackage);
			_specificInstance = (_AnnotationDocletParser) _specificClass.newInstance();
		}catch(ClassNotFoundException _classNotFound){
			throw new RuntimeException(errorMessage(METHOD, _classNotFound), _classNotFound);
		}catch(IllegalAccessException _illegalAccess){
			throw new RuntimeException(errorMessage(METHOD, _illegalAccess), _illegalAccess);
		}catch(InstantiationException _instantiation){
			throw new RuntimeException(errorMessage(METHOD, _instantiation), _instantiation);
		}
		
		return _specificInstance;
	}
	
	public final synchronized _FlexTaskRunner getFlexTaskRunnerImpl(){
		final String METHOD = "getFlexTaskRunnerImpl()";
		
		_FlexTaskRunner _specificInstance = null;
		String _flexTaskRunnerImplPackage = getFlexTaskRunnerImplPackage();
		
		try{
			Class _specificClass = Class.forName(_flexTaskRunnerImplPackage);
			_specificInstance = (_FlexTaskRunner) _specificClass.newInstance();
		}catch(ClassNotFoundException _classNotFound){
			throw new RuntimeException(errorMessage(METHOD, _classNotFound), _classNotFound);
		}catch(IllegalAccessException _illegalAccess){
			throw new RuntimeException(errorMessage(METHOD, _illegalAccess), _illegalAccess);
		}catch(InstantiationException _instantiation){
			throw new RuntimeException(errorMessage(METHOD, _instantiation), _instantiation);
		}
		
		return _specificInstance;
	}
	
	private static String errorMessage(String _method, Exception _type){
		StringBuffer errorMessage = new StringBuffer();
		
		errorMessage.append("While creating an instance within method " + _method);
		errorMessage.append(_type.getClass().getName());
		errorMessage.append(" Exception was thrown.");
		
		return errorMessage.toString();
	}
	
	abstract String getCommonTaskRunnerImplPackage();
	
	abstract String getFileManipulatorTaskRunnerImplPackage();
	
	abstract String getAnnotationDocletParserImplPackage();
	
	abstract String getFlexTaskRunnerImplPackage();
	
}
