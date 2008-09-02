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
import com.googlecode.jsfFlex.framework.annotation.JsfFlexComponentNodeAttribute;
import com.googlecode.jsfFlex.framework.component.MXMLContainerTemplate;
import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;
import com.googlecode.jsfFlex.shared.adapter._MXMLContract;

/**
 * @author Ji Hoon Kim
 */
@JsfFlexAttributeProperties(
		componentName="Accordion",
		componentFamily="javax.faces.MXMLInput",
		rendererName="com.googlecode.jsfFlex.MXMLAccordion",
		rendererClass="com.googlecode.jsfFlex.framework.component.ext.MXMLAccordion",
		mxmlComponentPackage="mx.containers",
		mxmlComponentName="Accordion",
		componentNodeAttributes={
			@JsfFlexComponentNodeAttribute(htmlType="INPUT",
						typeAttributeValue="HIDDEN",
						valueAttributeValue="selectedIndex",
						isValueDynamic=true,
						isValueNested=false,
						valueNestedValues={},
						nameAttributeValue="id",
						isNameDynamic=true,
						nameAppend="_selectedIndex")
		},
		
		jsfFlexAttributes={
			@JsfFlexAttribute(attribute="headerRenderer", byMethod=false),
			@JsfFlexAttribute(attribute="historyManagementEnabled", byMethod=false),
			@JsfFlexAttribute(attribute="resizeToContent", byMethod=false),
			@JsfFlexAttribute(attribute="fillAlphas", byMethod=false),
			@JsfFlexAttribute(attribute="fillColors", byMethod=false),
			@JsfFlexAttribute(attribute="focusAlpha", byMethod=false),
			@JsfFlexAttribute(attribute="focusRoundedCorners", byMethod=false),
			@JsfFlexAttribute(attribute="headerHeight", byMethod=false),
			@JsfFlexAttribute(attribute="headerStyleName", byMethod=false),
			@JsfFlexAttribute(attribute="horizontalGap", byMethod=false),
			@JsfFlexAttribute(attribute="openDuration", byMethod=false),
			@JsfFlexAttribute(attribute="openEasingFunction", byMethod=false),
			@JsfFlexAttribute(attribute="selectedFillColors", byMethod=false),
			@JsfFlexAttribute(attribute="textRollOverColor", byMethod=false),
			@JsfFlexAttribute(attribute="textSelectedColor", byMethod=false),
			@JsfFlexAttribute(attribute="verticalGap", byMethod=false),
			@JsfFlexAttribute(attribute="change", byMethod=false)
		}
	)
public final class MXMLAccordion extends MXMLContainerTemplate {
	
	public MXMLAccordion(){
		super();
	}
	
	public void buildComponentBegin(Object componentObj) throws ComponentBuildException{
		super.buildComponentBegin(componentObj);
		
		mapFields(MXMLAccordion.class, componentObj, null);
		
	}
	
	public void buildComponentInterlude(Object componentObj) throws ComponentBuildException {
		super.buildComponentInterlude(componentObj);
		
		_MXMLContract componentMXML = (_MXMLContract) componentObj;
		addCreatePreMxmlTask(componentMXML, MXMLAccordion.class.getAnnotation(JsfFlexAttributeProperties.class).componentName(), 
								null);
		
	}
	
}
