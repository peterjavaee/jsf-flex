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

import com.googlecode.jsfFlex.framework.annotation.JsfFlexAttribute;
import com.googlecode.jsfFlex.framework.annotation.JsfFlexAttributeProperties;
import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;

/**
 * @author Ji Hoon Kim
 */
@JsfFlexAttributeProperties(
		componentNodeAttributes={},
		
		jsfFlexAttributes={
			@JsfFlexAttribute(attribute="dataProvider", byMethod=true),
			@JsfFlexAttribute(attribute="editable", byMethod=true),
			@JsfFlexAttribute(attribute="imeMode", byMethod=true),
			@JsfFlexAttribute(attribute="restrict", byMethod=true),
			@JsfFlexAttribute(attribute="selectedIndex", byMethod=true),
			@JsfFlexAttribute(attribute="selectedItem", byMethod=true),
			@JsfFlexAttribute(attribute="disabledSkin", byMethod=true),
			@JsfFlexAttribute(attribute="downSkin", byMethod=true),
			@JsfFlexAttribute(attribute="editableDisabledSkin", byMethod=true),
			@JsfFlexAttribute(attribute="editableDownSkin", byMethod=true),
			@JsfFlexAttribute(attribute="editableOverSkin", byMethod=true),
			@JsfFlexAttribute(attribute="editableUpSkin", byMethod=true),
			@JsfFlexAttribute(attribute="overSkin", byMethod=true),
			@JsfFlexAttribute(attribute="upSkin", byMethod=true)
		}
	)
public abstract class MXMLComboBaseTemplate extends MXMLComponentBase {
	
	public MXMLComboBaseTemplate(){
		super();
	}

	public void buildComponentBegin(Object componentObj) throws ComponentBuildException {
		super.buildComponentBegin(componentObj);
		
		mapFields(MXMLComboBaseTemplate.class, componentObj, null);
		
	}
	
}
