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
import com.googlecode.jsfFlex.framework.component.MXMLComponentBase;
import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;
import com.googlecode.jsfFlex.shared.adapter._MXMLContract;

/**
 * @author Ji Hoon Kim
 */
@JsfFlexAttributeProperties(
		componentName="MenuBar",
		componentFamily="javax.faces.MXMLSimpleBase",
		rendererName="com.googlecode.jsfFlex.MXMLMenuBar",
		rendererClass="com.googlecode.jsfFlex.framework.component.ext.MXMLMenuBar",
		
		jsfFlexAttributes={
			@JsfFlexAttribute(attribute="dataDescriptor", byMethod=false),
			@JsfFlexAttribute(attribute="dataProvider", byMethod=false),
			@JsfFlexAttribute(attribute="iconField", byMethod=false),
			@JsfFlexAttribute(attribute="labelField", byMethod=false),
			@JsfFlexAttribute(attribute="labelFunction", byMethod=false),
			@JsfFlexAttribute(attribute="menubarItems", byMethod=false),
			@JsfFlexAttribute(attribute="menus", byMethod=false),
			@JsfFlexAttribute(attribute="selectedIndex", byMethod=true),
			@JsfFlexAttribute(attribute="showRoot", byMethod=false),
			@JsfFlexAttribute(attribute="backgroundAlpha", byMethod=false),
			@JsfFlexAttribute(attribute="backgroundColor", byMethod=false),
			@JsfFlexAttribute(attribute="backgroundSkin", byMethod=false),
			@JsfFlexAttribute(attribute="borderColor", byMethod=false),
			@JsfFlexAttribute(attribute="color", byMethod=false),
			@JsfFlexAttribute(attribute="cornerRadius", byMethod=false),
			@JsfFlexAttribute(attribute="disabledColor", byMethod=false),
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
			@JsfFlexAttribute(attribute="itemDownSkin", byMethod=false),
			@JsfFlexAttribute(attribute="itemOverSkin", byMethod=false),
			@JsfFlexAttribute(attribute="itemUpSkin", byMethod=false),
			@JsfFlexAttribute(attribute="leading", byMethod=false),
			@JsfFlexAttribute(attribute="rollOverColor", byMethod=false),
			@JsfFlexAttribute(attribute="selectionColor", byMethod=false),
			@JsfFlexAttribute(attribute="textAlign", byMethod=false),
			@JsfFlexAttribute(attribute="textDecoration", byMethod=false),
			@JsfFlexAttribute(attribute="textIndent", byMethod=false),
			@JsfFlexAttribute(attribute="itemClick", byMethod=false),
			@JsfFlexAttribute(attribute="itemRollOut", byMethod=false),
			@JsfFlexAttribute(attribute="itemRollOver", byMethod=false),
			@JsfFlexAttribute(attribute="menuHide", byMethod=false),
			@JsfFlexAttribute(attribute="menuShow", byMethod=false)
		}
	)
public class MXMLMenuBar extends MXMLComponentBase {
	
	public MXMLMenuBar(){
		super();
	}
	
	public void buildComponentBegin(Object componentObj) throws ComponentBuildException{
		super.buildComponentBegin(componentObj);
		
		mapFields(MXMLMenuBar.class, componentObj, null);
		
	}
	
	public void buildComponentInterlude(Object componentObj) throws ComponentBuildException {
		super.buildComponentInterlude(componentObj);
		
		_MXMLContract componentMXML = (_MXMLContract) componentObj;
		addCreatePreMxmlTask(componentMXML, MXMLMenuBar.class.getAnnotation(JsfFlexAttributeProperties.class).componentName(), 
								null);

	}
	
}
