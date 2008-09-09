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
import com.googlecode.jsfFlex.framework.component.MXMLButtonTemplate;
import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;
import com.googlecode.jsfFlex.shared.adapter._MXMLContract;

/**
 * @author Ji Hoon Kim
 */
@JsfFlexAttributeProperties(
		componentName="RadioButton",
		componentFamily="javax.faces.MXMLInput",
		rendererName="com.googlecode.jsfFlex.MXMLRadioButton",
		rendererClass="com.googlecode.jsfFlex.framework.component.ext.MXMLRadioButton",
		mxmlComponentPackage="mx.controls",
		mxmlComponentName="RadioButton",
		componentNodeAttributes={
				@JsfFlexComponentNodeAttribute(
						htmlType="INPUT",
						typeAttributeValue="HIDDEN",
						isValueDynamic=true,
						isValueNested=true,
						valueNestedValues={"group", "selectedValue"},
						nameAttributeValue="groupName",
						isNameDynamic=true,
						nameAppend="_selectedValue"),
				@JsfFlexComponentNodeAttribute(
						htmlType="INPUT",
						typeAttributeValue="HIDDEN",
						valueAttributeValue="selected",
						isValueDynamic=true,
						isValueNested=false,
						valueNestedValues={},
						nameAttributeValue="id",
						isNameDynamic=true,
						nameAppend="_selected")
		},

		jsfFlexAttributes={
				@JsfFlexAttribute(attribute="groupName", byMethod=true),
				@JsfFlexAttribute(attribute="value", byMethod=true)
		}
)
public final class MXMLRadioButton extends MXMLButtonTemplate {
	
	public MXMLRadioButton(){
		super();
	}
	
	public void buildComponentBegin(Object componentObj) throws ComponentBuildException{
		super.buildComponentBegin(componentObj);
		
		mapFields(MXMLRadioButton.class, componentObj, null);
		
	}
	
	public void buildComponentInterlude(Object componentObj) throws ComponentBuildException {
		super.buildComponentInterlude(componentObj);
		
		_MXMLContract componentMXML = (_MXMLContract) componentObj;
		createPreMxml(componentMXML, MXMLRadioButton.class.getAnnotation(JsfFlexAttributeProperties.class).componentName(), 
								null);

	}

}
