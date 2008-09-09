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

import com.googlecode.jsfFlex.framework.component.MXMLContainerTemplate;
import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;
import com.googlecode.jsfFlex.shared.adapter._MXMLContract;

/**
 * @JsfFlexAttributes
 * 	headerRenderer=false
 * 	historyManagementEnabled=false
 * 	resizeToContent=false
 * 	fillAlphas=false
 * 	fillColors=false
 * 	focusAlpha=false
 * 	focusRoundedCorners=false
 * 	headerHeight=false
 * 	headerStyleName=false
 * 	horizontalGap=false
 * 	openDuration=false
 * 	openEasingFunction=false
 * 	selectedFillColors=false
 * 	textRollOverColor=false
 * 	textSelectedColor=false
 * 	verticalGap=false
 * 	change=false
 * 
 * @JsfFlexRenderKitAttribute
 *  componentFamily=javax.faces.MXMLInput
 *  rendererName=com.googlecode.jsfFlex.MXMLAccordion
 *  rendererClass=com.googlecode.jsfFlex.framework.component.ext.MXMLAccordion
 * 
 * @JsfFlexComponentValueClassInfo
 *  classPackage=mx.containers
 *  className=Accordion
 *  
 * @JsfFlexComponentNodeAttribute
 *  htmlType=INPUT
 *  typeAttributeValue=HIDDEN
 *  valueAttributeValue=selectedIndex
 *  valueDynamic=true
 *  valueNested=false
 *  nameAttributeValue=id
 *  nameDynamic=true
 *  nameAppend=_selectedIndex
 *  
 * @author Ji Hoon Kim
 */
public final class MXMLAccordion extends MXMLContainerTemplate {
	
	private static final String MXML_ACCORDION_REPLACE_MAPPING;
	private static final String MXML_COMPONENT_NAME = "Accordion";
	
	static{
		//TODO : find a better method to implement the below tasks
		String packageName = MXMLAccordion.class.getPackage().getName();
		packageName = packageName.replace('.', '/');
		MXML_ACCORDION_REPLACE_MAPPING = packageName + "/replaceMapping/MXMLAccordionReplaceMapping.xml";
	}
	
	public MXMLAccordion(){
		super();
	}
	
	public void buildComponentBegin(Object componentObj) throws ComponentBuildException{
		super.buildComponentBegin(componentObj);
		
		mapFields(MXMLAccordion.class, componentObj, MXML_ACCORDION_REPLACE_MAPPING);
		
	}
	
	public void buildComponentInterlude(Object componentObj) throws ComponentBuildException {
		super.buildComponentInterlude(componentObj);
		
		_MXMLContract componentMXML = (_MXMLContract) componentObj;
		createPreMxml(componentMXML, MXML_COMPONENT_NAME, null);
		
	}
	
}
