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
package com.googlecode.jsfFlex.framework.annotationDocletParser;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.googlecode.jsfFlex.framework.annotation.JsfFlexAttribute;
import com.googlecode.jsfFlex.framework.annotation.JsfFlexAttributeProperties;
import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;
import com.googlecode.jsfFlex.framework.beans.TokenValue;

/**
 * A class that extends _AnnotationDocletParser for JRE greater than 1.4. This class will get<br>
 * the fields to inspect by inspecting the class' annotation.<br>
 * 
 * @author Ji Hoon Kim
 */
public final class AnnotationDocletParser15Impl extends _AnnotationDocletParser {
	
	private final static Log _log = LogFactory.getLog(AnnotationDocletParser15Impl.class);
	
	public AnnotationDocletParser15Impl(){
		super();
	}
	
	public void mapComponentFields(Class mapClass, final ClassLoader loader, final Object componentObj, final String replaceMappingXML){
		
		JsfFlexAttributeProperties _jsfFlexAttributeList = (JsfFlexAttributeProperties) mapClass.getAnnotation(JsfFlexAttributeProperties.class);
		
		JsfFlexAttribute[] jsfFlexAttributes = _jsfFlexAttributeList.jsfFlexAttributes();
		
		for(JsfFlexAttribute currAttribute : jsfFlexAttributes){
			
			if(!getFilterOutAttributes().contains(currAttribute.attribute())){
			
				if(currAttribute.byMethod()){
					setMapper(MXML_METHOD_MAPPER);
				}else{
					setMapper(MXML_ATTRIBUTE_MAPPER);
				}
				
				try{
					TokenValue _tokenValue = getMapper().mapField(currAttribute.attribute(), componentObj);
					if(_tokenValue != null){
						getTokenValueSet().add(_tokenValue);
					}
				}catch(ComponentBuildException _componentBuildExcept){
					_log.debug("Exception thrown for [ Class : " + componentObj.getClass().getName() + ", replaceToken : " + currAttribute.attribute() + " ] ");
				}
			
			}
			
		}
		
	}
	
}
