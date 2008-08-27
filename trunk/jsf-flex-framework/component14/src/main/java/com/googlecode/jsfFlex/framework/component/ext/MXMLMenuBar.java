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
 * 	dataDescriptor=false
 * 	dataProvider=false
 * 	iconField=false
 * 	labelField=false
 * 	labelFunction=false
 * 	menubarItems=false
 * 	menus=false
 * 	selectedIndex=true
 * 	showRoot=false
 * 	backgroundAlpha=false
 * 	backgroundColor=false
 * 	backgroundSkin=false
 * 	borderColor=false
 * 	color=false
 * 	cornerRadius=false
 * 	disabledColor=false
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
 * 	itemDownSkin=false
 * 	itemOverSkin=false
 * 	itemUpSkin=false
 * 	leading=false
 * 	rollOverColor=false
 * 	selectionColor=false
 * 	textAlign=false
 * 	textDecoration=false
 * 	textIndent=false
 * 	itemClick=false
 * 	itemRollOut=false
 * 	itemRollOver=false
 * 	menuHide=false
 * 	menuShow=false
 * 
 * @JsfFlexRenderKitAttribute
 *  componentFamily=javax.faces.MXMLSimpleBase
 *  rendererName=com.googlecode.jsfFlex.MXMLMenuBar
 *  rendererClass=com.googlecode.jsfFlex.framework.component.ext.MXMLMenuBar
 * 
 * @author Ji Hoon Kim
 */
public final class MXMLMenuBar extends MXMLComponentBase {
	
	private static final String MXML_MENU_BAR_REPLACE_MAPPING;
	private static final String MXML_COMPONENT_NAME = "MenuBar";
	
	static{
		//TODO : find a better method to implement the below tasks
		String packageName = MXMLMenuBar.class.getPackage().getName();
		packageName = packageName.replace('.', '/');
		MXML_MENU_BAR_REPLACE_MAPPING = packageName + "/replaceMapping/MXMLMenuBarReplaceMapping.xml";
	}
	
	public MXMLMenuBar(){
		super();
	}
	
	public void buildComponentBegin(Object componentObj) throws ComponentBuildException{
		super.buildComponentBegin(componentObj);
		
		mapFields(MXMLMenuBar.class, componentObj, MXML_MENU_BAR_REPLACE_MAPPING);
		
	}
	
	public void buildComponentInterlude(Object componentObj) throws ComponentBuildException {
		super.buildComponentInterlude(componentObj);
		
		_MXMLContract componentMXML = (_MXMLContract) componentObj;
		addCreatePreMxmlTask(componentMXML, MXML_COMPONENT_NAME, null);

	}
	
}
