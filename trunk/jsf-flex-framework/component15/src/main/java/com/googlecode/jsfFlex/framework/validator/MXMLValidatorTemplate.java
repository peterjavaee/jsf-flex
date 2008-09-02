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
package com.googlecode.jsfFlex.framework.validator;

import com.googlecode.jsfFlex.framework.annotation.JsfFlexAttribute;
import com.googlecode.jsfFlex.framework.annotation.JsfFlexAttributeProperties;
import com.googlecode.jsfFlex.framework.component.MXMLComponentBaseActions;
import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;

/**
 * @author Ji Hoon Kim
 */
@JsfFlexAttributeProperties(
		componentNodeAttributes={},
		
		jsfFlexAttributes={
			@JsfFlexAttribute(attribute="id", byMethod=true),
			@JsfFlexAttribute(attribute="enabled", byMethod=true),
			@JsfFlexAttribute(attribute="listener", byMethod=true),
			@JsfFlexAttribute(attribute="property", byMethod=true),
			@JsfFlexAttribute(attribute="required", byMethod=true),
			@JsfFlexAttribute(attribute="requiredFieldError", byMethod=true),
			@JsfFlexAttribute(attribute="source", byMethod=true),
			@JsfFlexAttribute(attribute="trigger", byMethod=true),
			@JsfFlexAttribute(attribute="triggerEvent", byMethod=true)
		}
	)
public class MXMLValidatorTemplate extends MXMLComponentBaseActions {
	
	public MXMLValidatorTemplate(){
		super();
	}

	public void buildComponentBegin(Object componentObj) throws ComponentBuildException {
		super.buildComponentBegin(componentObj);
		
		mapFields(MXMLValidatorTemplate.class, componentObj, null);
		
	}
	
}
