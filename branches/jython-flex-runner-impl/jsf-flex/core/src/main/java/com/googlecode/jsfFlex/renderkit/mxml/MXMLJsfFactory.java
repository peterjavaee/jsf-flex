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
import java.util.Properties;

/**
 * @author Ji Hoon Kim
 */
public final class MXMLJsfFactory {
	
	private static final String MXML_JSF_FACTORY_IMPL_PROPERTIES = "mxmlJsfFactoryImpl.properties";
	
	private static final String MXML_RESPONSE_STATE_MANAGER_IMPL_KEY = "mxmlResponseStateManagerImpl";
	private static final String MXML_RESPONSE_WRITER_IMPL_KEY = "mxmlResponseWriterImpl";
	
	private static final String MXML_RESPONSE_STATE_MANAGER_IMPL_PACKAGE_CLASS;
	private static final String MXML_RESPONSE_WRITER_IMPL_PACKAGE_CLASS;
	
	static{
		
		Properties mxmlJsfFactoryImpl = new Properties();
		
		try{
			mxmlJsfFactoryImpl.load(MXMLJsfFactory.class.getResourceAsStream(MXML_JSF_FACTORY_IMPL_PROPERTIES));
			
			String systemPropertyMxmlResponseStateManagerImpl = System.getProperty(MXML_RESPONSE_STATE_MANAGER_IMPL_KEY);
			String systemPropertyMxmlResponseWriterImpl = System.getProperty(MXML_RESPONSE_WRITER_IMPL_KEY);
			
			MXML_RESPONSE_STATE_MANAGER_IMPL_PACKAGE_CLASS = systemPropertyMxmlResponseStateManagerImpl == null ? 
													mxmlJsfFactoryImpl.getProperty(MXML_RESPONSE_STATE_MANAGER_IMPL_KEY) : systemPropertyMxmlResponseStateManagerImpl;
			MXML_RESPONSE_WRITER_IMPL_PACKAGE_CLASS = systemPropertyMxmlResponseWriterImpl == null ? 
													mxmlJsfFactoryImpl.getProperty(MXML_RESPONSE_WRITER_IMPL_KEY) : systemPropertyMxmlResponseWriterImpl;
		}catch(IOException _ioExcept){
			throw new RuntimeException("Exception thrown when loading of " + MXML_JSF_FACTORY_IMPL_PROPERTIES, _ioExcept);
		}
		
	}
	
	private MXMLJsfFactory(){
		super();
	}
	
	public static AbstractMXMLResponseWriter getMXMLResponseWriterImpl(Writer writer, String selectedContentType, String characterEncoding){
		return new MXMLResponseWriterImpl(writer, selectedContentType, characterEncoding);
	}
	
	public static AbstractMXMLResponseStateManager getMXMLResponseStateManagerImpl(){
		return new MXMLResponseStateManagerImpl();
	}
	
	static String getMXMLResponseStateManagerImplPackageClass(){
		return MXML_RESPONSE_STATE_MANAGER_IMPL_PACKAGE_CLASS;
	}
	
	static String getMXMLResponseWriterImplPackageClass(){
		return MXML_RESPONSE_WRITER_IMPL_PACKAGE_CLASS;
	}
	
}
