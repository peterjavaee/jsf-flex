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

import com.googlecode.jsfFlex.renderkit.annotation.JsfFlexAttribute;
import com.googlecode.jsfFlex.renderkit.annotation.JsfFlexAttributeProperties;
import com.googlecode.jsfFlex.renderkit.mxml.AbstractMXMLResponseWriter;

/**
 * @author Ji Hoon Kim
 */
@JsfFlexAttributeProperties(
		mxmlComponentNodeAttributes={},

		jsfFlexAttributes={
				@JsfFlexAttribute(attribute="border", byMethod=true),
				@JsfFlexAttribute(attribute="horizontalScrollPolicy", byMethod=true),
				@JsfFlexAttribute(attribute="horizontalScrollPosition", byMethod=true),
				@JsfFlexAttribute(attribute="liveScrolling", byMethod=true),
				@JsfFlexAttribute(attribute="maxHorizontalScrollPosition", byMethod=true),
				@JsfFlexAttribute(attribute="maxVerticalScrollPosition", byMethod=true),
				@JsfFlexAttribute(attribute="scrollTipFunction", byMethod=true),
				@JsfFlexAttribute(attribute="showScrollTips", byMethod=true),
				@JsfFlexAttribute(attribute="verticalScrollPolicy", byMethod=true),
				@JsfFlexAttribute(attribute="verticalScrollPosition", byMethod=true),
				@JsfFlexAttribute(attribute="backgroundAlpha", byMethod=true),
				@JsfFlexAttribute(attribute="backgroundColor", byMethod=true),
				@JsfFlexAttribute(attribute="backgroundImage", byMethod=true),
				@JsfFlexAttribute(attribute="backgroundSize", byMethod=true),
				@JsfFlexAttribute(attribute="borderColor", byMethod=true),
				@JsfFlexAttribute(attribute="borderSides", byMethod=true),
				@JsfFlexAttribute(attribute="borderSkin", byMethod=true),
				@JsfFlexAttribute(attribute="borderStyle", byMethod=true),
				@JsfFlexAttribute(attribute="borderThickness", byMethod=true),
				@JsfFlexAttribute(attribute="color", byMethod=true),
				@JsfFlexAttribute(attribute="cornerRadius", byMethod=true),
				@JsfFlexAttribute(attribute="disabledColor", byMethod=true),
				@JsfFlexAttribute(attribute="dropShadowColor", byMethod=true),
				@JsfFlexAttribute(attribute="dropShadowEnabled", byMethod=true),
				@JsfFlexAttribute(attribute="fontFamily", byMethod=true),
				@JsfFlexAttribute(attribute="fontSize", byMethod=true),
				@JsfFlexAttribute(attribute="fontStyle", byMethod=true),
				@JsfFlexAttribute(attribute="fontWeight", byMethod=true),
				@JsfFlexAttribute(attribute="horizontalScrollBarStyleName", byMethod=true),
				@JsfFlexAttribute(attribute="leading", byMethod=true),
				@JsfFlexAttribute(attribute="repeatDelay", byMethod=true),
				@JsfFlexAttribute(attribute="repeatInterval", byMethod=true),
				@JsfFlexAttribute(attribute="shadowDirection", byMethod=true),
				@JsfFlexAttribute(attribute="shadowDistance", byMethod=true),
				@JsfFlexAttribute(attribute="textAlign", byMethod=true),
				@JsfFlexAttribute(attribute="textDecoration", byMethod=true),
				@JsfFlexAttribute(attribute="textIndent", byMethod=true),
				@JsfFlexAttribute(attribute="verticalScrollBarStyleName", byMethod=true),
				@JsfFlexAttribute(attribute="scroll", byMethod=true)
		}
)
public abstract class MXMLScrollControlTemplateRenderer extends MXMLComponentBaseRenderer {
	
	@Override
	public void encodeBegin(FacesContext context, UIComponent componentObj) throws IOException {
		super.encodeBegin(context, componentObj);
		
		AbstractMXMLResponseWriter writer = (AbstractMXMLResponseWriter) context.getResponseWriter();
		writer.mapFields(MXMLScrollControlTemplateRenderer.class, componentObj, null);
		
	}
	
}
