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
package com.googlecode.jsfFlex.renderkit.mxml;

import java.io.Writer;
import java.lang.reflect.Constructor;

/**
 * @author Ji Hoon Kim
 */
public final class MXMLJsfFactory {
	
	private static final String MXML_RESPONSE_WRITER_IMPLEMENTOR = "com.googlecode.jsfFlex.renderkit.mxml.MXMLResponseWriterImpl";
	private static final Constructor MXML_RESPONSE_WRITER_IMPLEMENTOR_CONSTRUCTOR;
	
	private static final String MXML_RESPONSE_STATE_MANAGER_IMPLEMENTOR = "com.googlecode.jsfFlex.renderkit.mxml.MXMLResponseStateManagerImpl";
	private static final Class MXML_RESPONSE_STATE_MANAGER_IMPLEMENTOR_CLASS;
	
	static{
		
		/** Beginning for getting the Constructor for MXMLResponseWriterImpl */
		Class mxmlResponseWriterImplementorClass;
		
		try{
			mxmlResponseWriterImplementorClass = Class.forName(MXML_RESPONSE_WRITER_IMPLEMENTOR, false, Thread.currentThread().getContextClassLoader());
		}catch(ClassNotFoundException _classNotFound){
			throw new RuntimeException("Failure in retrieving the class for " + MXML_RESPONSE_WRITER_IMPLEMENTOR, _classNotFound);
		}
		
		try{
			MXML_RESPONSE_WRITER_IMPLEMENTOR_CONSTRUCTOR = mxmlResponseWriterImplementorClass.getDeclaredConstructor(new Class[]{Writer.class, String.class, String.class});
		}catch(NoSuchMethodException _noSuchMethod){
			throw new RuntimeException("Failure in retrieving the constructor for " + MXML_RESPONSE_WRITER_IMPLEMENTOR, _noSuchMethod);
		}
		/** End for getting the Constructor for MXMLResponseWriterImpl */
		
		
		/** Beginning for getting the Class for MXMLResponseStateManagerImpl, since will be using default constructor do not require a specific Constructor */
		try{
			MXML_RESPONSE_STATE_MANAGER_IMPLEMENTOR_CLASS = Class.forName(MXML_RESPONSE_STATE_MANAGER_IMPLEMENTOR, false, Thread.currentThread().getContextClassLoader());
		}catch(ClassNotFoundException _classNotFound){
			throw new RuntimeException("Failure in retrieving the class for " + MXML_RESPONSE_STATE_MANAGER_IMPLEMENTOR, _classNotFound);
		}
		/** End for getting the Class for MXMLResponseStateManagerImpl */
		
	}
	
	private MXMLJsfFactory(){
		super();
	}
	
	public static AbstractMXMLResponseWriter getMXMLResponseWriterImpl(Writer writer, String selectedContentType, String characterEncoding){
		
		try{
        	return (AbstractMXMLResponseWriter) MXML_RESPONSE_WRITER_IMPLEMENTOR_CONSTRUCTOR.newInstance(new Object[]{writer, selectedContentType, characterEncoding});
		}catch(Exception _instantiatingException){
			throw new RuntimeException("Failure in instantiating a class for " + MXML_RESPONSE_WRITER_IMPLEMENTOR, _instantiatingException);
		}
		
	}
	
	public static AbstractMXMLResponseStateManager getMXMLResponseStateManagerImpl(){
		
		try{
			return (AbstractMXMLResponseStateManager) MXML_RESPONSE_STATE_MANAGER_IMPLEMENTOR_CLASS.newInstance();
		}catch(Exception _instantiatingException){
			throw new RuntimeException("Failure in instantiating a class for " + MXML_RESPONSE_STATE_MANAGER_IMPLEMENTOR, _instantiatingException);
		}
	}
	
}
