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
package com.googlecode.jsfFlex.framework.component;

import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;

/**
 * @JsfFlexAttributes
 * 	allowDragSelection=true
 * 	allowMultipleSelection=true
 * 	columnCount=true
 * 	columnWidth=true
 * 	dataProvider=true
 * 	dataTipField=true
 * 	dataTipFunction=true
 * 	dragEnabled=true
 * 	dragMoveEnabled=true
 * 	dropEnabled=true
 * 	iconField=true
 * 	iconFunction=true
 * 	itemRenderer=true
 * 	labelField=true
 * 	labelFunction=true
 * 	lockedColumnCount=true
 * 	lockedRowCount=true
 * 	menuSelectionMode=true
 * 	rowCount=true
 * 	rowHeight=true
 * 	selectable=true
 * 	selectedIndex=true
 * 	selectedIndices=true
 * 	selectedItem=true
 * 	selectedItems=true
 * 	showDataTips=true
 * 	variableRowHeight=true
 * 	wordWrap=true
 * 	alternatingItemColors=true
 * 	dropIndicatorSkin=true
 * 	focusAlpha=true
 * 	focusRoundedCorners=true
 * 	paddingBottom=true
 * 	paddingLeft=true
 * 	paddingRight=true
 * 	paddingTop=true
 * 	rollOverColor=true
 * 	selectionColor=true
 * 	selectionDisabledColor=true
 * 	selectionDuration=true
 * 	selectionEasingFunction=true
 * 	textRollOverColor=true
 * 	textSelectedColor=true
 * 	useRollOver=true
 * 	verticalAlign=true
 * 	change=true
 * 	dataChange=true
 * 	itemDoubleClick=true
 * 	itemRollOut=true
 * 	itemRollOver=true
 * 	itemClick=true
 * 
 * @author Ji Hoon Kim
 */
public class MXMLListBaseTemplate extends MXMLScrollControlTemplate {
	
	private static final String MXML_LIST_BASE_TEMPLATE_REPLACE_MAPPING;
	
	static{
		//TODO : find a better method to implement the below tasks
		String packageName = MXMLListBaseTemplate.class.getPackage().getName();
		packageName = packageName.replace('.', '/');
		MXML_LIST_BASE_TEMPLATE_REPLACE_MAPPING = packageName + 
										"/replaceMapping/MXMLListBaseTemplateReplaceMapping.xml";
	}
	
	public MXMLListBaseTemplate(){
		super();
	}

	public void buildComponentBegin(Object componentObj) throws ComponentBuildException {
		super.buildComponentBegin(componentObj);
		
		mapFields(MXMLListBaseTemplate.class, componentObj, MXML_LIST_BASE_TEMPLATE_REPLACE_MAPPING);
		
	}
	
}
