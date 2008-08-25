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
import com.googlecode.jsfFlex.framework.component.MXMLListTemplate;
import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;
import com.googlecode.jsfFlex.shared.adapter._MXMLContract;

/**
 * @author Ji Hoon Kim
 */
@JsfFlexAttributeProperties(
		componentName="Tree",
		componentFamily="javax.faces.MXMLInput",
		rendererName="com.googlecode.jsfFlex.MXMLTree",
		rendererClass="com.googlecode.jsfFlex.framework.component.ext.MXMLTree",
		
		jsfFlexAttributes={
			@JsfFlexAttribute(attribute="dataDescriptor", byMethod=false),
			@JsfFlexAttribute(attribute="firstVisibleItem", byMethod=false),
			@JsfFlexAttribute(attribute="itemIcons", byMethod=false),
			@JsfFlexAttribute(attribute="openItems", byMethod=false),
			@JsfFlexAttribute(attribute="showRoot", byMethod=false),
			@JsfFlexAttribute(attribute="defaultLeafIcon", byMethod=false),
			@JsfFlexAttribute(attribute="depthColors", byMethod=false),
			@JsfFlexAttribute(attribute="disclosureClosedIcon", byMethod=false),
			@JsfFlexAttribute(attribute="disclosureOpenIcon", byMethod=false),
			@JsfFlexAttribute(attribute="folderClosedIcon", byMethod=false),
			@JsfFlexAttribute(attribute="folderOpenIcon", byMethod=false),
			@JsfFlexAttribute(attribute="indentation", byMethod=false),
			@JsfFlexAttribute(attribute="openDuration", byMethod=false),
			@JsfFlexAttribute(attribute="openEasingFunction", byMethod=false),
			@JsfFlexAttribute(attribute="itemClose", byMethod=false),
			@JsfFlexAttribute(attribute="itemOpen", byMethod=false),
			@JsfFlexAttribute(attribute="itemOpening", byMethod=false)
		}
	)
public class MXMLTree extends MXMLListTemplate {
	
	public MXMLTree(){
		super();
	}
	
	public void buildComponentBegin(Object componentObj) throws ComponentBuildException{
		super.buildComponentBegin(componentObj);
		
		mapFields(MXMLTree.class, componentObj, null);
		
	}
	
	public void buildComponentInterlude(Object componentObj) throws ComponentBuildException {
		super.buildComponentInterlude(componentObj);
		
		_MXMLContract componentMXML = (_MXMLContract) componentObj;
		addCreatePreMxmlTask(componentMXML, MXMLTree.class.getAnnotation(JsfFlexAttributeProperties.class).componentName(), 
								null);

	}

}
