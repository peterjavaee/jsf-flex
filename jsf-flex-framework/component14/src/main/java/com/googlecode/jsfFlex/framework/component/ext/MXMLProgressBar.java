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
 * 	conversion=false
 * 	direction=false
 * 	indeterminate=false
 * 	label=false
 * 	labelPlacement=false
 * 	maximum=false
 * 	minimum=false
 * 	mode=false
 * 	source=false
 * 	barColor=false
 * 	barSkin=false
 * 	borderColor=false
 * 	color=false
 * 	disabledColor=false
 * 	fontAntiAliasType=false
 * 	fontFamily=false
 * 	fontGridFitType=false
 * 	fontSharpness=false
 * 	fontSize=false
 * 	fontThickness=false
 * 	fontStyle=false
 * 	fontWeight=false
 * 	horizontalGap=false
 * 	indeterminateSkin=false
 * 	labelWidth=false
 * 	leading=false
 * 	paddingLeft=false
 * 	paddingRight=false
 * 	textAlign=false
 * 	textDecoration=false
 * 	textIndent=false
 * 	themeColor=false
 * 	trackColors=false
 * 	trackHeight=false
 * 	trackSkin=false
 * 	verticalGap=false
 * 	complete=false
 * 	hide=false
 * 	progress=false
 * 	show=false
 * 	completeEffect=false
 * 
 * @JsfFlexRenderKitAttribute
 *  componentFamily=javax.faces.MXMLSimpleBase
 *  rendererName=com.googlecode.jsfFlex.MXMLProgressBar
 *  rendererClass=com.googlecode.jsfFlex.framework.component.ext.MXMLProgressBar
 * 
 * @author Ji Hoon Kim
 */
public class MXMLProgressBar extends MXMLComponentBase {
	
	private static final String MXML_PROGRESS_BAR_REPLACE_MAPPING;
	private static final String MXML_COMPONENT_NAME = "ProgressBar";
	
	static{
		//TODO : find a better method to implement the below tasks
		String packageName = MXMLProgressBar.class.getPackage().getName();
		packageName = packageName.replace('.', '/');
		MXML_PROGRESS_BAR_REPLACE_MAPPING = packageName + "/replaceMapping/MXMLProgressBarReplaceMapping.xml";
	}
	
	public MXMLProgressBar(){
		super();
	}
	
	public void buildComponentBegin(Object componentObj) throws ComponentBuildException{
		super.buildComponentBegin(componentObj);
		
		mapFields(MXMLProgressBar.class, componentObj, MXML_PROGRESS_BAR_REPLACE_MAPPING);
		
	}
	
	public void buildComponentInterlude(Object componentObj) throws ComponentBuildException {
		super.buildComponentInterlude(componentObj);
		
		_MXMLContract componentMXML = (_MXMLContract) componentObj;
		addCreatePreMxmlTask(componentMXML, MXML_COMPONENT_NAME, null);
		
	}

}
