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
import com.googlecode.jsfFlex.framework.component.MXMLComboBaseTemplate;
import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;
import com.googlecode.jsfFlex.shared.adapter._MXMLContract;

/**
 * @author Ji Hoon Kim
 */
@JsfFlexAttributeProperties(
		componentName="ComboBox",
		componentFamily="javax.faces.MXMLInput",
		rendererName="com.googlecode.jsfFlex.MXMLComboBox",
		rendererClass="com.googlecode.jsfFlex.framework.component.ext.MXMLComboBox",
		
		jsfFlexAttributes={
			@JsfFlexAttribute(attribute="dropdownFactory", byMethod=false),
			@JsfFlexAttribute(attribute="dropdownWidth", byMethod=false),
			@JsfFlexAttribute(attribute="itemRenderer", byMethod=false),
			@JsfFlexAttribute(attribute="labelField", byMethod=false),
			@JsfFlexAttribute(attribute="labelFunction", byMethod=false),
			@JsfFlexAttribute(attribute="prompt", byMethod=false),
			@JsfFlexAttribute(attribute="rowCount", byMethod=false),
			@JsfFlexAttribute(attribute="alternatingItemColors", byMethod=false),
			@JsfFlexAttribute(attribute="arrowButtonWidth", byMethod=false),
			@JsfFlexAttribute(attribute="borderColor", byMethod=false),
			@JsfFlexAttribute(attribute="borderThickness", byMethod=false),
			@JsfFlexAttribute(attribute="closeDuration", byMethod=false),
			@JsfFlexAttribute(attribute="closeEasingFunction", byMethod=false),
			@JsfFlexAttribute(attribute="color", byMethod=false),
			@JsfFlexAttribute(attribute="cornerRadius", byMethod=false),
			@JsfFlexAttribute(attribute="disabledColor", byMethod=false),
			@JsfFlexAttribute(attribute="dropDownBorderColor", byMethod=false),
			@JsfFlexAttribute(attribute="dropDownStyleName", byMethod=false),
			@JsfFlexAttribute(attribute="fillAlphas", byMethod=false),
			@JsfFlexAttribute(attribute="fillColors", byMethod=false),
			@JsfFlexAttribute(attribute="focusAlpha", byMethod=false),
			@JsfFlexAttribute(attribute="focusRoundedCorners", byMethod=false),
			@JsfFlexAttribute(attribute="fontAntiAliasType", byMethod=false),
			@JsfFlexAttribute(attribute="fontFamily", byMethod=false),
			@JsfFlexAttribute(attribute="fontGridFitType", byMethod=false),
			@JsfFlexAttribute(attribute="fontSharpness", byMethod=false),
			@JsfFlexAttribute(attribute="fontSize", byMethod=false),
			@JsfFlexAttribute(attribute="fontStyle", byMethod=false),
			@JsfFlexAttribute(attribute="fontThickness", byMethod=false),
			@JsfFlexAttribute(attribute="fontWeight", byMethod=false),
			@JsfFlexAttribute(attribute="highlightAlphas", byMethod=false),
			@JsfFlexAttribute(attribute="leading", byMethod=false),
			@JsfFlexAttribute(attribute="openDuration", byMethod=false),
			@JsfFlexAttribute(attribute="openEasingFunction", byMethod=false),
			@JsfFlexAttribute(attribute="paddingLeft", byMethod=false),
			@JsfFlexAttribute(attribute="paddingRight", byMethod=false),
			@JsfFlexAttribute(attribute="rollOverColor", byMethod=false),
			@JsfFlexAttribute(attribute="selectionColor", byMethod=false),
			@JsfFlexAttribute(attribute="selectionDuration", byMethod=false),
			@JsfFlexAttribute(attribute="selectionEasingFunction", byMethod=false),
			@JsfFlexAttribute(attribute="textAlign", byMethod=false),
			@JsfFlexAttribute(attribute="textDecoration", byMethod=false),
			@JsfFlexAttribute(attribute="textIndent", byMethod=false),
			@JsfFlexAttribute(attribute="textRollOverColor", byMethod=false),
			@JsfFlexAttribute(attribute="textSelectedColor", byMethod=false),
			@JsfFlexAttribute(attribute="change", byMethod=false),
			@JsfFlexAttribute(attribute="close", byMethod=false),
			@JsfFlexAttribute(attribute="dataChange", byMethod=false),
			@JsfFlexAttribute(attribute="enter", byMethod=false),
			@JsfFlexAttribute(attribute="itemRollOut", byMethod=false),
			@JsfFlexAttribute(attribute="itemRollOver", byMethod=false),
			@JsfFlexAttribute(attribute="open", byMethod=false),
			@JsfFlexAttribute(attribute="scroll", byMethod=false)
		}
	)
public class MXMLComboBox extends MXMLComboBaseTemplate {
	
	public MXMLComboBox(){
		super();
	}
	
	public void buildComponentBegin(Object componentObj) throws ComponentBuildException{
		super.buildComponentBegin(componentObj);
		
		mapFields(MXMLComboBox.class, componentObj, null);
		
	}
	
	public void buildComponentInterlude(Object componentObj) throws ComponentBuildException {
		super.buildComponentInterlude(componentObj);
		
		_MXMLContract componentMXML = (_MXMLContract) componentObj;
		addCreatePreMxmlTask(componentMXML, MXMLComboBox.class.getAnnotation(JsfFlexAttributeProperties.class).componentName(), 
								null);

	}

}
