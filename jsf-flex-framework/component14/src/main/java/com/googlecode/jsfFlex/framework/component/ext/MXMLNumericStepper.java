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

import com.googlecode.jsfFlex.framework.component.MXMLComponentBase;
import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;
import com.googlecode.jsfFlex.shared.adapter._MXMLContract;

/**
 * @JsfFlexAttributes
 * 	imeMode=false
 * 	maxChars=false
 * 	maximum=false
 * 	minimum=false
 * 	stepSize=false
 * 	backgroundAlpha=false
 * 	backgroundColor=false
 * 	backgroundImage=false
 * 	backgroundSize=false
 * 	borderCapColor=false
 * 	borderColor=false
 * 	borderSides=false
 * 	borderSkin=false
 * 	borderStyle=false
 * 	borderThickness=false
 * 	color=false
 * 	cornerRadius=false
 * 	disabledColor=false
 * 	downArrowDisabledSkin=false
 * 	downArrowDownSkin=false
 * 	downArrowOverSkin=false
 * 	downArrowUpSkin=false
 * 	dropShadowEnabled=false
 * 	dropShadowColor=false
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
 * 	paddingLeft=false
 * 	paddingRight=false
 * 	shadowDirection=false
 * 	shadowDistance=false
 * 	textAlign=false
 * 	textDecoration=false
 * 	textIndent=false
 * 	upArrowDisabledSkin=false
 * 	upArrowDownSkin=false
 * 	upArrowOverSkin=false
 * 	upArrowUpSkin=false
 * 	change=false
 * 	dataChange=false
 * 
 * @JsfFlexRenderKitAttribute
 *  componentFamily=javax.faces.MXMLInput
 *  rendererName=com.googlecode.jsfFlex.MXMLNumericStepper
 *  rendererClass=com.googlecode.jsfFlex.framework.component.ext.MXMLNumericStepper
 * 
 * @author Ji Hoon Kim
 */
public final class MXMLNumericStepper extends MXMLComponentBase {
	
	private static final String MXML_NUMERIC_STEPPER_REPLACE_MAPPING;
	private static final String MXML_COMPONENT_NAME = "NumericStepper";
	
	static{
		//TODO : find a better method to implement the below tasks
		String packageName = MXMLNumericStepper.class.getPackage().getName();
		packageName = packageName.replace('.', '/');
		MXML_NUMERIC_STEPPER_REPLACE_MAPPING = packageName + "/replaceMapping/MXMLNumericStepperReplaceMapping.xml";
	}
	
	public MXMLNumericStepper(){
		super();
	}
	
	public void buildComponentBegin(Object componentObj) throws ComponentBuildException{
		super.buildComponentBegin(componentObj);
		
		mapFields(MXMLNumericStepper.class, componentObj, MXML_NUMERIC_STEPPER_REPLACE_MAPPING);
		
	}
	
	public void buildComponentInterlude(Object componentObj) throws ComponentBuildException {
		super.buildComponentInterlude(componentObj);
		
		_MXMLContract componentMXML = (_MXMLContract) componentObj;
		addCreatePreMxmlTask(componentMXML, MXML_COMPONENT_NAME, null);

	}

}
