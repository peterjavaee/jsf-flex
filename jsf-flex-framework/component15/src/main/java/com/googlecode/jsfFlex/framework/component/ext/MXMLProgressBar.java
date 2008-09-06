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
import com.googlecode.jsfFlex.framework.component.MXMLComponentBase;
import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;
import com.googlecode.jsfFlex.shared.adapter._MXMLContract;

/**
 * @author Ji Hoon Kim
 */
@JsfFlexAttributeProperties(
		componentName="ProgressBar",
		componentFamily="javax.faces.MXMLInput",
		rendererName="com.googlecode.jsfFlex.MXMLProgressBar",
		rendererClass="com.googlecode.jsfFlex.framework.component.ext.MXMLProgressBar",
		mxmlComponentPackage="mx.controls",
		mxmlComponentName="ProgressBar",
		componentNodeAttributes={
				@JsfFlexComponentNodeAttribute(
						htmlType="INPUT",
						typeAttributeValue="HIDDEN",
						valueAttributeValue="value",
						isValueDynamic=true,
						isValueNested=false,
						valueNestedValues={},
						nameAttributeValue="id",
						isNameDynamic=true,
						nameAppend="_value")
		},

		jsfFlexAttributes={
				@JsfFlexAttribute(attribute="conversion", byMethod=false),
				@JsfFlexAttribute(attribute="direction", byMethod=false),
				@JsfFlexAttribute(attribute="indeterminate", byMethod=false),
				@JsfFlexAttribute(attribute="label", byMethod=false),
				@JsfFlexAttribute(attribute="labelPlacement", byMethod=false),
				@JsfFlexAttribute(attribute="maximum", byMethod=false),
				@JsfFlexAttribute(attribute="minimum", byMethod=false),
				@JsfFlexAttribute(attribute="mode", byMethod=false),
				@JsfFlexAttribute(attribute="source", byMethod=false),
				@JsfFlexAttribute(attribute="barColor", byMethod=false),
				@JsfFlexAttribute(attribute="barSkin", byMethod=false),
				@JsfFlexAttribute(attribute="borderColor", byMethod=false),
				@JsfFlexAttribute(attribute="color", byMethod=false),
				@JsfFlexAttribute(attribute="disabledColor", byMethod=false),
				@JsfFlexAttribute(attribute="fontAntiAliasType", byMethod=false),
				@JsfFlexAttribute(attribute="fontFamily", byMethod=false),
				@JsfFlexAttribute(attribute="fontGridFitType", byMethod=false),
				@JsfFlexAttribute(attribute="fontSharpness", byMethod=false),
				@JsfFlexAttribute(attribute="fontSize", byMethod=false),
				@JsfFlexAttribute(attribute="fontThickness", byMethod=false),
				@JsfFlexAttribute(attribute="fontStyle", byMethod=false),
				@JsfFlexAttribute(attribute="fontWeight", byMethod=false),
				@JsfFlexAttribute(attribute="horizontalGap", byMethod=false),
				@JsfFlexAttribute(attribute="indeterminateSkin", byMethod=false),
				@JsfFlexAttribute(attribute="labelWidth", byMethod=false),
				@JsfFlexAttribute(attribute="leading", byMethod=false),
				@JsfFlexAttribute(attribute="paddingLeft", byMethod=false),
				@JsfFlexAttribute(attribute="paddingRight", byMethod=false),
				@JsfFlexAttribute(attribute="textAlign", byMethod=false),
				@JsfFlexAttribute(attribute="textDecoration", byMethod=false),
				@JsfFlexAttribute(attribute="textIndent", byMethod=false),
				@JsfFlexAttribute(attribute="themeColor", byMethod=false),
				@JsfFlexAttribute(attribute="trackColors", byMethod=false),
				@JsfFlexAttribute(attribute="trackHeight", byMethod=false),
				@JsfFlexAttribute(attribute="trackSkin", byMethod=false),
				@JsfFlexAttribute(attribute="verticalGap", byMethod=false),
				@JsfFlexAttribute(attribute="complete", byMethod=false),
				@JsfFlexAttribute(attribute="hide", byMethod=false),
				@JsfFlexAttribute(attribute="progress", byMethod=false),
				@JsfFlexAttribute(attribute="show", byMethod=false),
				@JsfFlexAttribute(attribute="completeEffect", byMethod=false)
		}
)
public final class MXMLProgressBar extends MXMLComponentBase {
	
	public MXMLProgressBar(){
		super();
	}
	
	public void buildComponentBegin(Object componentObj) throws ComponentBuildException{
		super.buildComponentBegin(componentObj);
		
		mapFields(MXMLProgressBar.class, componentObj, null);
		
	}
	
	public void buildComponentInterlude(Object componentObj) throws ComponentBuildException {
		super.buildComponentInterlude(componentObj);
		
		_MXMLContract componentMXML = (_MXMLContract) componentObj;
		addCreatePreMxmlTask(componentMXML, MXMLProgressBar.class.getAnnotation(JsfFlexAttributeProperties.class).componentName(), 
								null);
		
	}

}
