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
package com.googlecode.jsfFlex.framework.tasks.factory;

import java.io.IOException;
import java.util.Properties;

/**
 * Default implementation of _RunnerFactory. It simply loads the defaultImplementation.properties<br>
 * and returns a String specifying the package class for each interface that _RunnerFactory should instantiate.<br>
 * Note that property of "annotation_doclet_parser_impl_package" is set during build time by maven.<br>
 * 
 * @author Ji Hoon Kim
 */
public class DefaultRunnerFactoryImpl extends _RunnerFactory {
	
	private static final String DEFAULT_IMPLEMENTATION_PROPERTIES = "defaultImplementation.properties";
	
	private static final String COMMON_TASK_RUNNER_IMPL_PACKAGE_CLASS;
	private static final String FILE_MANIPULATOR_TASK_RUNNER_IMPL_PACKAGE_CLASS;
	private static final String ANNOTATION_DOCLET_PARSER_IMPL_PACKAGE_CLASS;
	private static final String FLEX_TASK_RUNNER_IMPL_PACKAGE_CLASS;
	
	private static final String COMMON_TASK_RUNNER_IMPL_PACKAGE_CLASS_KEY = "common_task_rummer_impl_package";
	private static final String FILE_MANIPULATOR_TASK_RUNNER_IMPL_PACKAGE_CLASS_KEY = "file_manipulator_task_runner_impl_package";
	private static final String ANNOTATION_DOCLET_PARSER_IMPL_PACKAGE_CLASS_KEY = "annotation_doclet_parser_impl_package";
	private static final String FLEX_TASK_RUNNER_IMPL_PACKAGE_CLASS_KEY = "flex_task_runner_impl_package";
	
	static{
		Properties _defaultImplementation = new Properties();
		try{
			_defaultImplementation.load(DefaultRunnerFactoryImpl.class.getResourceAsStream(DEFAULT_IMPLEMENTATION_PROPERTIES));
			
			COMMON_TASK_RUNNER_IMPL_PACKAGE_CLASS = _defaultImplementation.getProperty(COMMON_TASK_RUNNER_IMPL_PACKAGE_CLASS_KEY);
			FILE_MANIPULATOR_TASK_RUNNER_IMPL_PACKAGE_CLASS = _defaultImplementation.getProperty(FILE_MANIPULATOR_TASK_RUNNER_IMPL_PACKAGE_CLASS_KEY);
			ANNOTATION_DOCLET_PARSER_IMPL_PACKAGE_CLASS = _defaultImplementation.getProperty(ANNOTATION_DOCLET_PARSER_IMPL_PACKAGE_CLASS_KEY);
			FLEX_TASK_RUNNER_IMPL_PACKAGE_CLASS = _defaultImplementation.getProperty(FLEX_TASK_RUNNER_IMPL_PACKAGE_CLASS_KEY);
		}catch(IOException _ioExcept){
			throw new RuntimeException("Exception thrown when loading of " + DEFAULT_IMPLEMENTATION_PROPERTIES, _ioExcept);
		}
		
	}
	
	DefaultRunnerFactoryImpl(){
		super();
	}
	
	String getCommonTaskRunnerImplPackage() {
		return COMMON_TASK_RUNNER_IMPL_PACKAGE_CLASS;
	}
	
	String getFileManipulatorTaskRunnerImplPackage() {
		return FILE_MANIPULATOR_TASK_RUNNER_IMPL_PACKAGE_CLASS;
	}
	
	String getAnnotationDocletParserImplPackage(){
		return ANNOTATION_DOCLET_PARSER_IMPL_PACKAGE_CLASS;
	}
	
	String getFlexTaskRunnerImplPackage() {
		return FLEX_TASK_RUNNER_IMPL_PACKAGE_CLASS;
	}
	
}
