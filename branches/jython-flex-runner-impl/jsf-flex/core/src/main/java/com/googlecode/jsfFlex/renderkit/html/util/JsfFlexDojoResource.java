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
package com.googlecode.jsfFlex.renderkit.html.util;

import java.io.IOException;
import java.util.Collection;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Ji Hoon Kim
 */
public abstract class JsfFlexDojoResource extends JsfFlexResource {
	
	private static final String DOJO_PROPERTY_FILE_NAME = "dojo.properties";
	
	private static final String DOJO_VERSION_KEY = "dojo_version";
	private static final String DOJO_ROOT_FOLDER_NAME_KEY = "dojo_root_folder_name";
	
	private static final String DOJO_VERSION;
	private static final String DOJO_ROOT_FOLDER_NAME;
	
	private static final String DOJO_DIRECTORY;
	private static final String DIJIT_DIRECTORY;
	private static final String DOJOX_DIRECTORY;
	
	private static final String DOJO_MAIN_JS;
	private static final String DIJIT_MAIN_JS;
	
	static{
		Properties dojoProperties = new Properties();
		
		try{
			dojoProperties.load(JsfFlexDojoResource.class.getResourceAsStream(DOJO_PROPERTY_FILE_NAME));
		}catch(IOException _ioExcept){
			throw new RuntimeException("Exception thrown when loading of " + DOJO_PROPERTY_FILE_NAME, _ioExcept);
		}
		
		DOJO_VERSION = (String) dojoProperties.get(DOJO_VERSION_KEY);
		DOJO_ROOT_FOLDER_NAME = ((String) dojoProperties.get(DOJO_ROOT_FOLDER_NAME_KEY)) + DOJO_VERSION;
		
		DOJO_DIRECTORY = DOJO_ROOT_FOLDER_NAME + "/dojo";
		DIJIT_DIRECTORY = DOJO_ROOT_FOLDER_NAME + "/dijit";
		DOJOX_DIRECTORY = DOJO_ROOT_FOLDER_NAME + "/dojox";
		
		DOJO_MAIN_JS = DOJO_DIRECTORY + "/dojo.js";
		DIJIT_MAIN_JS = DIJIT_DIRECTORY + "/dijit.js";
	}
	
	JsfFlexDojoResource(){
		super();
	}
	
	private static ThreadLocal _currentResourceInstance = new ThreadLocal()
    {
        protected Object initialValue()
        {
            return null;
        }
    };
    
    public static synchronized JsfFlexDojoResource getDojoInstance(){
		JsfFlexDojoResource dojoInstance = null;
		if(_currentResourceInstance.get() == null){
			dojoInstance = new JsfFlexDojoResource(){
				
				private JsfFlexResource _jsfFlexResource;
				
				{
					_jsfFlexResource = JsfFlexResource.getInstance();
				}
				
				public void addDojoMain(){
					_jsfFlexResource.addResource(JsfFlexDojoResource.class, DOJO_MAIN_JS);
				}
				
				public void addDijitMain(){
					_jsfFlexResource.addResource(JsfFlexDojoResource.class, DIJIT_MAIN_JS);
				}
				
				public void addResource(Class jsfFlexComponent, String resourceName){
					_jsfFlexResource.addResource(jsfFlexComponent, resourceName);
				}
				
				public Collection getResources(){
					return _jsfFlexResource.getResources();
				}
				
				public void processRequestResource(HttpServletResponse httpResponse, String[] requestURISplitted){
					_jsfFlexResource.processRequestResource(httpResponse, requestURISplitted);
				}
				
			};
			_currentResourceInstance.set(dojoInstance);
		}else{
			dojoInstance = (JsfFlexDojoResource) _currentResourceInstance.get();
		}
		
		return dojoInstance;
	}
    
    public static synchronized JsfFlexResource getInstance(){
		return (JsfFlexResource) JsfFlexDojoResource.getDojoInstance();
	}
	
	public abstract void addDojoMain();
	
	public abstract void addDijitMain();
	
}
