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
import com.googlecode.jsfFlex.framework.component.MXMLScrollControlTemplate;
import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;
import com.googlecode.jsfFlex.shared.adapter._MXMLContract;

/**
 * @author Ji Hoon Kim
 */
@JsfFlexAttributeProperties(
		componentName="TextArea",
		componentFamily="javax.faces.MXMLInput",
		rendererName="com.googlecode.jsfFlex.MXMLTextArea",
		rendererClass="com.googlecode.jsfFlex.framework.component.ext.MXMLTextArea",
		mxmlComponentPackage="mx.controls",
		mxmlComponentName="TextArea",
		componentNodeAttributes={
				@JsfFlexComponentNodeAttribute(
						htmlType="INPUT",
						typeAttributeValue="HIDDEN",
						valueAttributeValue="text",
						isValueDynamic=true,
						isValueNested=false,
						valueNestedValues={},
						nameAttributeValue="id",
						isNameDynamic=true,
						nameAppend="_text"),
				@JsfFlexComponentNodeAttribute(
						htmlType="INPUT",
						typeAttributeValue="HIDDEN",
						valueAttributeValue="htmlText",
						isValueDynamic=true,
						isValueNested=false,
						valueNestedValues={},
						nameAttributeValue="id",
						isNameDynamic=true,
						nameAppend="_htmlText")
		},

		jsfFlexAttributes={
				@JsfFlexAttribute(attribute="condenseWhite", byMethod=false),
				@JsfFlexAttribute(attribute="data", byMethod=false),
				@JsfFlexAttribute(attribute="displayAsPassword", byMethod=false),
				@JsfFlexAttribute(attribute="editable", byMethod=false),
				@JsfFlexAttribute(attribute="imeMode", byMethod=false),
				@JsfFlexAttribute(attribute="listData", byMethod=false),
				@JsfFlexAttribute(attribute="maxChars", byMethod=false),
				@JsfFlexAttribute(attribute="restrict", byMethod=false),
				@JsfFlexAttribute(attribute="selectionBeginIndex", byMethod=false),
				@JsfFlexAttribute(attribute="selectionEndIndex", byMethod=false),
				@JsfFlexAttribute(attribute="styleSheet", byMethod=false),
				@JsfFlexAttribute(attribute="wordWrap", byMethod=false),
				@JsfFlexAttribute(attribute="disabledColor", byMethod=false),
				@JsfFlexAttribute(attribute="focusAlpha", byMethod=false),
				@JsfFlexAttribute(attribute="focusRoundedCorners", byMethod=false),
				@JsfFlexAttribute(attribute="paddingLeft", byMethod=false),
				@JsfFlexAttribute(attribute="paddingRight", byMethod=false),
				@JsfFlexAttribute(attribute="change", byMethod=false)
		}
)
public final class MXMLTextArea extends MXMLScrollControlTemplate {
	
	public MXMLTextArea(){
		super();
	}
	
	public void buildComponentBegin(Object componentObj) throws ComponentBuildException{
		super.buildComponentBegin(componentObj);
		
		mapFields(MXMLTextArea.class, componentObj, null);
		
	}
	
	public void buildComponentInterlude(Object componentObj) throws ComponentBuildException {
		super.buildComponentInterlude(componentObj);
		
		_MXMLContract componentMXML = (_MXMLContract) componentObj;
		addCreatePreMxmlTask(componentMXML, MXMLTextArea.class.getAnnotation(JsfFlexAttributeProperties.class).componentName(), 
								null);
		
	}

}
