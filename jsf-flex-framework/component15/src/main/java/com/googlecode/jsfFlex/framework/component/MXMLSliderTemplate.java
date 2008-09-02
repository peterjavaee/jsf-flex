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
			@JsfFlexAttribute(attribute="allowThumbOverlap", byMethod=true),
			@JsfFlexAttribute(attribute="allowTrackClick", byMethod=true),
			@JsfFlexAttribute(attribute="dataTipFormatFunction", byMethod=true),
			@JsfFlexAttribute(attribute="direction", byMethod=true),
			@JsfFlexAttribute(attribute="labels", byMethod=true),
			@JsfFlexAttribute(attribute="liveDragging", byMethod=true),
			@JsfFlexAttribute(attribute="maximum", byMethod=true),
			@JsfFlexAttribute(attribute="minimum", byMethod=true),
			@JsfFlexAttribute(attribute="showDataTip", byMethod=true),
			@JsfFlexAttribute(attribute="sliderDataTipClass", byMethod=true),
			@JsfFlexAttribute(attribute="sliderThumbClass", byMethod=true),
			@JsfFlexAttribute(attribute="snapInterval", byMethod=true),
			@JsfFlexAttribute(attribute="thumbCount", byMethod=true),
			@JsfFlexAttribute(attribute="tickInterval", byMethod=true),
			@JsfFlexAttribute(attribute="borderColor", byMethod=true),
			@JsfFlexAttribute(attribute="dataTipOffset", byMethod=true),
			@JsfFlexAttribute(attribute="dataTipPrecision", byMethod=true),
			@JsfFlexAttribute(attribute="dataTipStyleName", byMethod=true),
			@JsfFlexAttribute(attribute="fillAlphas", byMethod=true),
			@JsfFlexAttribute(attribute="fillColors", byMethod=true),
			@JsfFlexAttribute(attribute="labelOffset", byMethod=true),
			@JsfFlexAttribute(attribute="labelStyleName", byMethod=true),
			@JsfFlexAttribute(attribute="showTrackHighlight", byMethod=true),
			@JsfFlexAttribute(attribute="slideDuration", byMethod=true),
			@JsfFlexAttribute(attribute="slideEasingFunction", byMethod=true),
			@JsfFlexAttribute(attribute="thumbDisabledSkin", byMethod=true),
			@JsfFlexAttribute(attribute="thumbDownSkin", byMethod=true),
			@JsfFlexAttribute(attribute="thumbOffset", byMethod=true),
			@JsfFlexAttribute(attribute="thumbOverSkin", byMethod=true),
			@JsfFlexAttribute(attribute="thumbUpSkin", byMethod=true),
			@JsfFlexAttribute(attribute="tickColor", byMethod=true),
			@JsfFlexAttribute(attribute="tickLength", byMethod=true),
			@JsfFlexAttribute(attribute="tickOffset", byMethod=true),
			@JsfFlexAttribute(attribute="tickThickness", byMethod=true),
			@JsfFlexAttribute(attribute="trackColors", byMethod=true),
			@JsfFlexAttribute(attribute="trackHighlightSkin", byMethod=true),
			@JsfFlexAttribute(attribute="trackMargin", byMethod=true),
			@JsfFlexAttribute(attribute="trackSkin", byMethod=true),
			@JsfFlexAttribute(attribute="change", byMethod=true),
			@JsfFlexAttribute(attribute="thumbDrag", byMethod=true),
			@JsfFlexAttribute(attribute="thumbPress", byMethod=true),
			@JsfFlexAttribute(attribute="thumbRelease", byMethod=true)
		}
	)
public class MXMLSliderTemplate extends MXMLComponentBase {
	
	public MXMLSliderTemplate(){
		super();
	}

	public void buildComponentBegin(Object componentObj) throws ComponentBuildException {
		super.buildComponentBegin(componentObj);
		
		mapFields(MXMLSliderTemplate.class, componentObj, null);
		
	}
	
}
