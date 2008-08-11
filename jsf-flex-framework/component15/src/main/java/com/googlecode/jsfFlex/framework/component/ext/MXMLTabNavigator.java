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
package com.googlecode.jsfFlex.framework.component.ext;

import com.googlecode.jsfFlex.framework.annotation.JsfFlexAttribute;
import com.googlecode.jsfFlex.framework.annotation.JsfFlexAttributeProperties;
import com.googlecode.jsfFlex.framework.component.MXMLViewStackTemplate;
import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;
import com.googlecode.jsfFlex.shared.adapter._MXMLContract;

/**
 * @author Ji Hoon Kim
 */
@JsfFlexAttributeProperties(
		componentName="TabNavigator",
		
		jsfFlexAttributes={
			@JsfFlexAttribute(attribute="fillAlphas", byMethod=false),
			@JsfFlexAttribute(attribute="fillColors", byMethod=false),
			@JsfFlexAttribute(attribute="firstTabStyleName", byMethod=false),
			@JsfFlexAttribute(attribute="focusAlpha", byMethod=false),
			@JsfFlexAttribute(attribute="focusRoundedCorners", byMethod=false),
			@JsfFlexAttribute(attribute="horizontalAlign", byMethod=false),
			@JsfFlexAttribute(attribute="lastTabStyleName", byMethod=false),
			@JsfFlexAttribute(attribute="selectedTabTextStyleName", byMethod=false),
			@JsfFlexAttribute(attribute="tabHeight", byMethod=false),
			@JsfFlexAttribute(attribute="tabStyleName", byMethod=false),
			@JsfFlexAttribute(attribute="tabWidth", byMethod=false)
		}
	)
public class MXMLTabNavigator extends MXMLViewStackTemplate {
	
	public MXMLTabNavigator(){
		super();
	}
	
	public void buildComponentBegin(Object componentObj) throws ComponentBuildException{
		super.buildComponentBegin(componentObj);
		
		mapFields(MXMLTabNavigator.class, componentObj, null);
		
	}
	
	public void buildComponentInterlude(Object componentObj) throws ComponentBuildException {
		super.buildComponentInterlude(componentObj);
		
		_MXMLContract componentMXML = (_MXMLContract) componentObj;
		addCreatePreMxmlTask(componentMXML, MXMLTabNavigator.class.getAnnotation(JsfFlexAttributeProperties.class).componentName(), 
								null);

	}

}
