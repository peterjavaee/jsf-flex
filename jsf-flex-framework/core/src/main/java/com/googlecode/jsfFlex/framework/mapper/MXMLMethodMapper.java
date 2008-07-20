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
package com.googlecode.jsfFlex.framework.mapper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;

/**
 * @author Ji Hoon Kim
 */
public class MXMLMethodMapper implements _MXMLMapper{
	
	private static MXMLMethodMapper _instance;
	
	private MXMLMethodMapper(){
		super();
	}
	
	public static synchronized _MXMLMapper getInstance(){
		if(_instance == null){
			_instance = new MXMLMethodMapper();
		}
		return _instance;
	}

	public void mapField(String jsf_attribute, String tokenName, Object componentObj, Map replaceTextLists)
															throws ComponentBuildException{
		
		try{
			String searchMethodName = "get" + String.valueOf(tokenName.charAt(0)).toUpperCase() + tokenName.substring(1);
			Method method = componentObj.getClass().getMethod(searchMethodName, null);
			Object obj = method.invoke(componentObj, null);
			String toSet;
	
			if(obj != null && obj instanceof String){
				toSet = tokenName + "=\"" + (String) obj + "\"";
			}else{
				toSet = "";
			}
			String token = "${" + tokenName + "}";
			replaceTextLists.put(token, toSet);
		}catch(NoSuchMethodException noSuchMethodExcept){
			
			throw new ComponentBuildException(getErrorMessage(jsf_attribute, tokenName, componentObj), noSuchMethodExcept);
		}catch(InvocationTargetException invocationTargetExcept){
			
			throw new ComponentBuildException(getErrorMessage(jsf_attribute, tokenName, componentObj), invocationTargetExcept);
		}catch(IllegalAccessException illegalAccessExcept){
			
			throw new ComponentBuildException(getErrorMessage(jsf_attribute, tokenName, componentObj), illegalAccessExcept);
		}

	}
	
	private String getErrorMessage(String jsf_methodName, String tokenName, Object componentObj){
		StringBuffer errorMessage = new StringBuffer();
		errorMessage.append("Exception when mapping field for jsf_methodName [ ");
		errorMessage.append(jsf_methodName);
		errorMessage.append(" ] and tokenName [ ");
		errorMessage.append(tokenName);
		errorMessage.append(" ] for ");
		errorMessage.append(componentObj.getClass().getName());
		return errorMessage.toString();
	}
	
}
