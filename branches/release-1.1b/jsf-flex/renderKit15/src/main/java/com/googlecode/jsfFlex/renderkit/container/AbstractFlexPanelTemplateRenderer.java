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
package com.googlecode.jsfFlex.renderkit.container;

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
				@IJsfFlexAttribute(attribute="layout"),
				@IJsfFlexAttribute(attribute="status"),
				@IJsfFlexAttribute(attribute="title", byMethod=true),
				@IJsfFlexAttribute(attribute="titleIcon"),
				@IJsfFlexAttribute(attribute="borderAlpha"),
				@IJsfFlexAttribute(attribute="borderThicknessBottom"),
				@IJsfFlexAttribute(attribute="borderThicknessLeft"),
				@IJsfFlexAttribute(attribute="borderThicknessRight"),
				@IJsfFlexAttribute(attribute="borderThicknessTop"),
                @IJsfFlexAttribute(attribute="closeButtonDisabledSkin"),
                @IJsfFlexAttribute(attribute="closeButtonDownSkin"),
                @IJsfFlexAttribute(attribute="closeButtonOverSkin"),
                @IJsfFlexAttribute(attribute="closeButtonUpSkin"),
                @IJsfFlexAttribute(attribute="controlBarStyleName"),
				@IJsfFlexAttribute(attribute="footerColors"),
				@IJsfFlexAttribute(attribute="headerColors"),
				@IJsfFlexAttribute(attribute="headerHeight"),
				@IJsfFlexAttribute(attribute="highlightAlphas"),
				@IJsfFlexAttribute(attribute="horizontalAlign"),
				@IJsfFlexAttribute(attribute="horizontalGap"),
				@IJsfFlexAttribute(attribute="modalTransparency"),
				@IJsfFlexAttribute(attribute="modalTransparencyBlur"),
				@IJsfFlexAttribute(attribute="modalTransparencyColor"),
				@IJsfFlexAttribute(attribute="modalTransparencyDuration"),
				@IJsfFlexAttribute(attribute="roundedBottomCorners"),
				@IJsfFlexAttribute(attribute="statusStyleName"),
				@IJsfFlexAttribute(attribute="titleBackgroundSkin"),
				@IJsfFlexAttribute(attribute="titleStyleName"),
				@IJsfFlexAttribute(attribute="verticalAlign"),
				@IJsfFlexAttribute(attribute="verticalGap"),
				@IJsfFlexAttribute(attribute="resizeEndEffect"),
				@IJsfFlexAttribute(attribute="resizeStartEffect"),
                @IJsfFlexAttribute(attribute="close")
		}
)
public abstract class AbstractFlexPanelTemplateRenderer extends AbstractFlexContainerTemplateRenderer {
	
	@Override
	public void encodeBegin(FacesContext context, UIComponent componentObj) throws IOException {
		super.encodeBegin(context, componentObj);
		
		AbstractFlexResponseWriter writer = AbstractFlexResponseWriter.class.cast( context.getResponseWriter() );
		writer.mapFields(AbstractFlexPanelTemplateRenderer.class, componentObj, null);
		
	}
	
}
