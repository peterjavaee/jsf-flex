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
package com.googlecode.jsfFlex.framework.component;

import com.googlecode.jsfFlex.framework.annotation.JsfFlexAttribute;
import com.googlecode.jsfFlex.framework.annotation.JsfFlexAttributeProperties;
import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;

/**
 * @author Ji Hoon Kim
 */
@JsfFlexAttributeProperties(
		componentNodeAttributes={},
		
		jsfFlexAttributes={
			@JsfFlexAttribute(attribute="openAlways", byMethod=false),
			@JsfFlexAttribute(attribute="popUp", byMethod=false),
			@JsfFlexAttribute(attribute="arrowButtonWidth", byMethod=false),
			@JsfFlexAttribute(attribute="closeDuration", byMethod=false),
			@JsfFlexAttribute(attribute="closeEasingFunction", byMethod=false),
			@JsfFlexAttribute(attribute="openDuration", byMethod=false),
			@JsfFlexAttribute(attribute="openEasingFunction", byMethod=false),
			@JsfFlexAttribute(attribute="popUpDownSkin", byMethod=false),
			@JsfFlexAttribute(attribute="popUpGap", byMethod=false),
			@JsfFlexAttribute(attribute="popUpIcon", byMethod=false),
			@JsfFlexAttribute(attribute="popUpOverSkin", byMethod=false),
			@JsfFlexAttribute(attribute="close", byMethod=false),
			@JsfFlexAttribute(attribute="open", byMethod=false)
		}
	)
public abstract class MXMLPopUpButtonTemplate extends MXMLButtonTemplate {
	
	public MXMLPopUpButtonTemplate(){
		super();
	}
	
	public void buildComponentBegin(Object componentObj) throws ComponentBuildException{
		super.buildComponentBegin(componentObj);
		
		mapFields(MXMLPopUpButtonTemplate.class, componentObj, null);
		
	}
	
}
