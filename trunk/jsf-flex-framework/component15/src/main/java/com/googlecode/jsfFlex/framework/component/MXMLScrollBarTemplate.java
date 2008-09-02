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
			@JsfFlexAttribute(attribute="direction", byMethod=true),
			@JsfFlexAttribute(attribute="lineScrollSize", byMethod=true),
			@JsfFlexAttribute(attribute="maxScrollPosition", byMethod=true),
			@JsfFlexAttribute(attribute="minScrollPosition", byMethod=true),
			@JsfFlexAttribute(attribute="pageScrollSize", byMethod=true),
			@JsfFlexAttribute(attribute="pageSize", byMethod=true),
			@JsfFlexAttribute(attribute="scrollPosition", byMethod=true),
			@JsfFlexAttribute(attribute="borderColor", byMethod=true),
			@JsfFlexAttribute(attribute="cornerRadius", byMethod=true),
			@JsfFlexAttribute(attribute="downArrowDisabledSkin", byMethod=true),
			@JsfFlexAttribute(attribute="downArrowDownSkin", byMethod=true),
			@JsfFlexAttribute(attribute="downArrowOverSkin", byMethod=true),
			@JsfFlexAttribute(attribute="downArrowUpSkin", byMethod=true),
			@JsfFlexAttribute(attribute="fillAlphas", byMethod=true),
			@JsfFlexAttribute(attribute="fillColors", byMethod=true),
			@JsfFlexAttribute(attribute="highlightAlphas", byMethod=true),
			@JsfFlexAttribute(attribute="thumbDownSkin", byMethod=true),
			@JsfFlexAttribute(attribute="thumbIcon", byMethod=true),
			@JsfFlexAttribute(attribute="thumbOverSkin", byMethod=true),
			@JsfFlexAttribute(attribute="thumbUpSkin", byMethod=true),
			@JsfFlexAttribute(attribute="trackColors", byMethod=true),
			@JsfFlexAttribute(attribute="trackSkin", byMethod=true),
			@JsfFlexAttribute(attribute="upArrowDisabledSkin", byMethod=true),
			@JsfFlexAttribute(attribute="upArrowDownSkin", byMethod=true),
			@JsfFlexAttribute(attribute="upArrowOverSkin", byMethod=true),
			@JsfFlexAttribute(attribute="upArrowUpSkin", byMethod=true)
		}
	)
public class MXMLScrollBarTemplate extends MXMLComponentBase {
	
	public MXMLScrollBarTemplate(){
		super();
	}

	public void buildComponentBegin(Object componentObj) throws ComponentBuildException {
		super.buildComponentBegin(componentObj);
		
		mapFields(MXMLScrollBarTemplate.class, componentObj, null);
		
	}
	
}
