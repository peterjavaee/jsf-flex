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
package com.googlecode.jsfFlex.framework.tasks;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import com.googlecode.jsfFlex.framework.mapper._MXMLMapper;

/**
 * @author Ji Hoon Kim
 */
public abstract class _AnnotationDocletParser {
	
	public static final String BY_ATTRIBUTE = "byAttribute";
	
	private Set _filterOutAttributes;
	private Set _tokenValueSet;
	
	private _MXMLMapper _mapper;
	
	public _AnnotationDocletParser(){
		super();
	}
	
	{
		_filterOutAttributes = new HashSet();
		_tokenValueSet = new LinkedHashSet();
	}
	
	public Set getFilterOutAttributes(){
		return _filterOutAttributes;
	}
	public Set getTokenValueSet(){
		return _tokenValueSet;
	}
	
	protected _MXMLMapper getMapper(){
		return _mapper;
	}
	protected void setMapper(_MXMLMapper mapperToSet){
		_mapper = mapperToSet;
	}
	
	protected static String getErrorMessage(String caller, String parameter){
		StringBuffer errorMessage = new StringBuffer();
		errorMessage.append("Exception when ");
		errorMessage.append(caller);
		errorMessage.append(" with parameter(s) [ ");
		errorMessage.append(parameter);
		errorMessage.append(" ] ");
		return errorMessage.toString();
	}
	
	public abstract void mapComponentFields(Class mapClass, ClassLoader loader, Object _componentObj, String _replaceMappingXML);
	
}
