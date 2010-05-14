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
package com.googlecode.jsfFlex.renderkit.component;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import com.googlecode.jsfFlex.renderkit.annotation.IJsfFlexAttribute;
import com.googlecode.jsfFlex.renderkit.annotation.IJsfFlexAttributeProperties;
import com.googlecode.jsfFlex.renderkit.flex.AbstractFlexResponseWriter;

/**
 * @author Ji Hoon Kim
 */
@IJsfFlexAttributeProperties(
		componentNodeAttributes={},

		jsfFlexAttributes={
				@IJsfFlexAttribute(attribute="allowThumbOverlap"),
				@IJsfFlexAttribute(attribute="allowTrackClick"),
				@IJsfFlexAttribute(attribute="dataTipFormatFunction"),
				@IJsfFlexAttribute(attribute="direction"),
				@IJsfFlexAttribute(attribute="labels"),
				@IJsfFlexAttribute(attribute="liveDragging"),
				@IJsfFlexAttribute(attribute="maximum"),
				@IJsfFlexAttribute(attribute="minimum"),
				@IJsfFlexAttribute(attribute="showDataTip"),
				@IJsfFlexAttribute(attribute="sliderDataTipClass"),
				@IJsfFlexAttribute(attribute="sliderThumbClass"),
				@IJsfFlexAttribute(attribute="snapInterval"),
				@IJsfFlexAttribute(attribute="thumbCount"),
				@IJsfFlexAttribute(attribute="tickInterval"),
                @IJsfFlexAttribute(attribute="tickValues"),
                @IJsfFlexAttribute(attribute="borderColor"),
				@IJsfFlexAttribute(attribute="dataTipOffset"),
				@IJsfFlexAttribute(attribute="dataTipPrecision"),
				@IJsfFlexAttribute(attribute="dataTipStyleName"),
				@IJsfFlexAttribute(attribute="fillAlphas"),
				@IJsfFlexAttribute(attribute="fillColors"),
				@IJsfFlexAttribute(attribute="labelOffset"),
				@IJsfFlexAttribute(attribute="labelStyleName"),
				@IJsfFlexAttribute(attribute="showTrackHighlight"),
				@IJsfFlexAttribute(attribute="slideDuration"),
				@IJsfFlexAttribute(attribute="slideEasingFunction"),
				@IJsfFlexAttribute(attribute="thumbDisabledSkin"),
				@IJsfFlexAttribute(attribute="thumbDownSkin"),
				@IJsfFlexAttribute(attribute="thumbOffset"),
				@IJsfFlexAttribute(attribute="thumbOverSkin"),
				@IJsfFlexAttribute(attribute="thumbUpSkin"),
				@IJsfFlexAttribute(attribute="tickColor"),
				@IJsfFlexAttribute(attribute="tickLength"),
				@IJsfFlexAttribute(attribute="tickOffset"),
				@IJsfFlexAttribute(attribute="tickThickness"),
				@IJsfFlexAttribute(attribute="trackColors"),
				@IJsfFlexAttribute(attribute="trackHighlightSkin"),
				@IJsfFlexAttribute(attribute="trackMargin"),
				@IJsfFlexAttribute(attribute="trackSkin"),
				@IJsfFlexAttribute(attribute="change"),
				@IJsfFlexAttribute(attribute="thumbDrag"),
				@IJsfFlexAttribute(attribute="thumbPress"),
				@IJsfFlexAttribute(attribute="thumbRelease")
		}
)
public abstract class AbstractFlexSliderTemplateRenderer extends AbstractFlexComponentRenderer {
	
	@Override
	public void encodeBegin(FacesContext context, UIComponent componentObj) throws IOException {
		super.encodeBegin(context, componentObj);
		
		AbstractFlexResponseWriter writer = AbstractFlexResponseWriter.class.cast( context.getResponseWriter() );
		writer.mapFields(AbstractFlexSliderTemplateRenderer.class, componentObj, null);
		
	}
	
}
