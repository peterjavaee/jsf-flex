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

import com.googlecode.jsfFlex.framework.component.MXMLComboBaseTemplate;
import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;
import com.googlecode.jsfFlex.shared.adapter._MXMLContract;

/**
 * @JsfFlexAttributes
 * 	dropdownFactory=false
 * 	dropdownWidth=false
 * 	itemRenderer=false
 * 	labelField=false
 * 	labelFunction=false
 * 	prompt=false
 * 	rowCount=false
 * 	alternatingItemColors=false
 * 	arrowButtonWidth=false
 * 	borderColor=false
 * 	borderThickness=false
 * 	closeDuration=false
 * 	closeEasingFunction=false
 * 	color=false
 * 	cornerRadius=false
 * 	disabledColor=false
 * 	dropDownBorderColor=false
 * 	dropDownStyleName=false
 * 	fillAlphas=false
 * 	fillColors=false
 * 	focusAlpha=false
 * 	focusRoundedCorners=false
 * 	fontAntiAliasType=false
 * 	fontFamily=false
 * 	fontGridFitType=false
 * 	fontSharpness=false
 * 	fontSize=false
 * 	fontStyle=false
 * 	fontThickness=false
 * 	fontWeight=false
 * 	highlightAlphas=false
 * 	leading=false
 * 	openDuration=false
 * 	openEasingFunction=false
 * 	paddingLeft=false
 * 	paddingRight=false
 * 	rollOverColor=false
 * 	selectionColor=false
 * 	selectionDuration=false
 * 	selectionEasingFunction=false
 * 	textAlign=false
 * 	textDecoration=false
 * 	textIndent=false
 * 	textRollOverColor=false
 * 	textSelectedColor=false
 * 	change=false
 * 	close=false
 * 	dataChange=false
 * 	enter=false
 * 	itemRollOut=false
 * 	itemRollOver=false
 * 	open=false
 * 	scroll=false
 * 
 * @JsfFlexRenderKitAttribute
 *  componentFamily=javax.faces.MXMLInput
 *  rendererName=com.googlecode.jsfFlex.MXMLComboBox
 *  rendererClass=com.googlecode.jsfFlex.framework.component.ext.MXMLComboBox
 * 
 * @author Ji Hoon Kim
 */
public class MXMLComboBox extends MXMLComboBaseTemplate {
	
	private static final String MXML_COMBO_BOX_REPLACE_MAPPING;
	private static final String MXML_COMPONENT_NAME = "ComboBox";
	
	static{
		//TODO : find a better method to implement the below tasks
		String packageName = MXMLComboBox.class.getPackage().getName();
		packageName = packageName.replace('.', '/');
		MXML_COMBO_BOX_REPLACE_MAPPING = packageName + "/replaceMapping/MXMLComboBoxReplaceMapping.xml";
	}
	
	public MXMLComboBox(){
		super();
	}
	
	public void buildComponentBegin(Object componentObj) throws ComponentBuildException{
		super.buildComponentBegin(componentObj);
		
		mapFields(MXMLComboBox.class, componentObj, MXML_COMBO_BOX_REPLACE_MAPPING);
		
	}
	
	public void buildComponentInterlude(Object componentObj) throws ComponentBuildException {
		super.buildComponentInterlude(componentObj);
		
		_MXMLContract componentMXML = (_MXMLContract) componentObj;
		addCreatePreMxmlTask(componentMXML, MXML_COMPONENT_NAME, null);

	}

}
