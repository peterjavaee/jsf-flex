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

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Constructor;
import java.util.Properties;

/**
 * @author Ji Hoon Kim
 */
public final class MXMLJsfFactory {
	
	private static final String MXML_JSF_FACTORY_IMPL_PROPERTIES = "mxmlJsfFactoryImpl.properties";
	
	private static final String MXML_RESPONSE_STATE_MANAGER_BASE_IMPL_KEY = "mxmlResponseStateManagerBaseImpl";
	private static final String MXML_RESPONSE_WRITER_BASE_IMPL_KEY = "mxmlResponseWriterBaseImpl";
	
	private static final String MXML_RESPONSE_STATE_MANAGER_BASE_IMPL_PACKAGE_CLASS_NAME;
	private static final String MXML_RESPONSE_WRITER_BASE_IMPL_PACKAGE_CLASS_NAME;
	
	private static final String MXML_RESPONSE_WRITER_IMPL_PACKAGE_CLASS_NAME = "com.googlecode.jsfFlex.renderkit.mxml.MXMLResponseWriterImpl";
	private static final Constructor MXML_RESPONSE_WRITER_IMPLEMENTOR_CONSTRUCTOR;
	
	private static final String MXML_RESPONSE_STATE_MANAGER_IMPL_PACKAGE_CLASS_NAME = "com.googlecode.jsfFlex.renderkit.mxml.MXMLResponseStateManagerImpl";
	private static final Class MXML_RESPONSE_STATE_MANAGER_IMPLEMENTOR_CLASS;
	
	static{
		
		Properties mxmlJsfFactoryImpl = new Properties();
		
		try{
			mxmlJsfFactoryImpl.load(MXMLJsfFactory.class.getResourceAsStream(MXML_JSF_FACTORY_IMPL_PROPERTIES));
		}catch(IOException _ioExcept){
			throw new RuntimeException("Exception thrown when loading of " + MXML_JSF_FACTORY_IMPL_PROPERTIES, _ioExcept);
		}
		
		String systemPropertyMxmlResponseStateManagerBaseImpl = System.getProperty(MXML_RESPONSE_STATE_MANAGER_BASE_IMPL_KEY);
		String systemPropertyMxmlResponseWriterBaseImpl = System.getProperty(MXML_RESPONSE_WRITER_BASE_IMPL_KEY);
		
		MXML_RESPONSE_STATE_MANAGER_BASE_IMPL_PACKAGE_CLASS_NAME = systemPropertyMxmlResponseStateManagerBaseImpl == null ? mxmlJsfFactoryImpl.getProperty(MXML_RESPONSE_STATE_MANAGER_BASE_IMPL_KEY) : systemPropertyMxmlResponseStateManagerBaseImpl;
		MXML_RESPONSE_WRITER_BASE_IMPL_PACKAGE_CLASS_NAME = systemPropertyMxmlResponseWriterBaseImpl == null ? mxmlJsfFactoryImpl.getProperty(MXML_RESPONSE_WRITER_BASE_IMPL_KEY) : systemPropertyMxmlResponseWriterBaseImpl;
		
		
		/* Getting reference to MXML_RESPONSE_WRITER_IMPLEMENTOR_CONSTRUCTOR */
		Class mxmlResponseWriterImplementorClass;
		
		try{
			mxmlResponseWriterImplementorClass = Class.forName(MXML_RESPONSE_WRITER_IMPL_PACKAGE_CLASS_NAME, false, Thread.currentThread().getContextClassLoader());
		}catch(ClassNotFoundException classNotFound){
			throw new RuntimeException("Failure in retrieving the class for " + MXML_RESPONSE_WRITER_IMPL_PACKAGE_CLASS_NAME, classNotFound);
		}
		
		try{
			MXML_RESPONSE_WRITER_IMPLEMENTOR_CONSTRUCTOR = mxmlResponseWriterImplementorClass.getDeclaredConstructor(new Class[]{Writer.class, String.class, String.class});
		}catch(NoSuchMethodException noSuchMethod){
			throw new RuntimeException("Failure in retrieving the constructor for " +  MXML_RESPONSE_WRITER_IMPL_PACKAGE_CLASS_NAME, noSuchMethod);
		}
		/* End of getting reference to MXML_RESPONSE_WRITER_IMPLEMENTOR_CONSTRUCTOR */
		
		
		/* Getting reference to MXML_RESPONSE_STATE_MANAGER_IMPL_PACKAGE_CLASS */
		try{
			MXML_RESPONSE_STATE_MANAGER_IMPLEMENTOR_CLASS = Class.forName(MXML_RESPONSE_STATE_MANAGER_IMPL_PACKAGE_CLASS_NAME, false, Thread.currentThread().getContextClassLoader());
		}catch(ClassNotFoundException classNotFound){
			throw new RuntimeException("Failure in retrieving the class for " + MXML_RESPONSE_STATE_MANAGER_IMPL_PACKAGE_CLASS_NAME, classNotFound);
		}
		/* End of getting reference to MXML_RESPONSE_STATE_MANAGER_IMPL_PACKAGE_CLASS */
		
	}
	
	private MXMLJsfFactory(){
		super();
	}
	
	public static AbstractMXMLResponseWriter getMXMLResponseWriterImpl(Writer writer, String selectedContentType, String characterEncoding){
		
		try{
			return (AbstractMXMLResponseWriter) MXML_RESPONSE_WRITER_IMPLEMENTOR_CONSTRUCTOR.newInstance(new Object[]{writer, selectedContentType, characterEncoding});
		}catch(Exception instantiatingException){
			throw new RuntimeException("Failure in instantiating a class for " + MXML_RESPONSE_WRITER_IMPL_PACKAGE_CLASS_NAME, instantiatingException);
		}
	}
	
	public static AbstractMXMLResponseStateManager getMXMLResponseStateManagerImpl(){
		
		try{
			return (AbstractMXMLResponseStateManager) MXML_RESPONSE_STATE_MANAGER_IMPLEMENTOR_CLASS.newInstance();
		}catch(Exception instantiatingException){
			throw new RuntimeException("Failure in instantiating a class for " + MXML_RESPONSE_STATE_MANAGER_IMPL_PACKAGE_CLASS_NAME, instantiatingException);
		}
	}
	
	static String getMXMLResponseStateManagerBaseImplPackageClassName(){
		return MXML_RESPONSE_STATE_MANAGER_BASE_IMPL_PACKAGE_CLASS_NAME;
	}
	
	static String getMXMLResponseWriterBaseImplPackageClassName(){
		return MXML_RESPONSE_WRITER_BASE_IMPL_PACKAGE_CLASS_NAME;
	}
	
}
