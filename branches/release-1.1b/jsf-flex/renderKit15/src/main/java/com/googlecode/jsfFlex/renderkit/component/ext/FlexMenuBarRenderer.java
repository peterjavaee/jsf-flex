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
package com.googlecode.jsfFlex.renderkit.component.ext;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFRenderer;

import com.googlecode.jsfFlex.renderkit.annotation.IJsfFlexAttribute;
import com.googlecode.jsfFlex.renderkit.annotation.IJsfFlexAttributeProperties;
import com.googlecode.jsfFlex.renderkit.component.AbstractFlexComponentRenderer;
import com.googlecode.jsfFlex.renderkit.flex.AbstractFlexResponseWriter;
import com.googlecode.jsfFlex.shared.adapter.IFlexContract;

/**
 * @author Ji Hoon Kim
 */
@JSFRenderer(
		renderKitId="FLEX_BASIC",
		family="javax.faces.FlexSimpleBase",
		type="com.googlecode.jsfFlex.FlexMenuBar"
)
@IJsfFlexAttributeProperties(
		componentName="MenuBar",
		componentNodeAttributes={},

		jsfFlexAttributes={
				@IJsfFlexAttribute(attribute="dataDescriptor"),
				@IJsfFlexAttribute(attribute="dataProvider", byMethod=true),
				@IJsfFlexAttribute(attribute="iconField"),
				@IJsfFlexAttribute(attribute="labelField"),
				@IJsfFlexAttribute(attribute="labelFunction"),
                @IJsfFlexAttribute(attribute="menuBarItemRenderer"),
				@IJsfFlexAttribute(attribute="menubarItems"),
				@IJsfFlexAttribute(attribute="menus"),
				@IJsfFlexAttribute(attribute="selectedIndex", byMethod=true),
				@IJsfFlexAttribute(attribute="showRoot"),
				@IJsfFlexAttribute(attribute="backgroundAlpha"),
				@IJsfFlexAttribute(attribute="backgroundColor"),
				@IJsfFlexAttribute(attribute="backgroundSkin"),
				@IJsfFlexAttribute(attribute="borderColor"),
				@IJsfFlexAttribute(attribute="color"),
				@IJsfFlexAttribute(attribute="cornerRadius"),
				@IJsfFlexAttribute(attribute="disabledColor"),
				@IJsfFlexAttribute(attribute="fillAlphas"),
				@IJsfFlexAttribute(attribute="fillColors"),
				@IJsfFlexAttribute(attribute="focusAlpha"),
				@IJsfFlexAttribute(attribute="focusRoundedCorners"),
				@IJsfFlexAttribute(attribute="fontAntiAliasType"),
				@IJsfFlexAttribute(attribute="fontFamily"),
				@IJsfFlexAttribute(attribute="fontGridFitType"),
				@IJsfFlexAttribute(attribute="fontSharpness"),
				@IJsfFlexAttribute(attribute="fontSize"),
				@IJsfFlexAttribute(attribute="fontStyle"),
				@IJsfFlexAttribute(attribute="fontThickness"),
				@IJsfFlexAttribute(attribute="fontWeight"),
				@IJsfFlexAttribute(attribute="highlightAlphas"),
				@IJsfFlexAttribute(attribute="itemDownSkin"),
				@IJsfFlexAttribute(attribute="itemOverSkin"),
				@IJsfFlexAttribute(attribute="itemUpSkin"),
				@IJsfFlexAttribute(attribute="leading"),
                @IJsfFlexAttribute(attribute="menuStyleName"),
                @IJsfFlexAttribute(attribute="rollOverColor"),
				@IJsfFlexAttribute(attribute="selectionColor"),
				@IJsfFlexAttribute(attribute="textAlign"),
				@IJsfFlexAttribute(attribute="textDecoration"),
				@IJsfFlexAttribute(attribute="textIndent"),
				@IJsfFlexAttribute(attribute="itemClick"),
				@IJsfFlexAttribute(attribute="itemRollOut"),
				@IJsfFlexAttribute(attribute="itemRollOver"),
				@IJsfFlexAttribute(attribute="menuHide"),
				@IJsfFlexAttribute(attribute="menuShow")
		}
)
public final class FlexMenuBarRenderer extends AbstractFlexComponentRenderer {
	
	@Override
	public void encodeBegin(FacesContext context, UIComponent componentObj) throws IOException {
		super.encodeBegin(context, componentObj);
		
		IFlexContract componentFlex = IFlexContract.class.cast( componentObj );
		
		AbstractFlexResponseWriter writer = AbstractFlexResponseWriter.class.cast( context.getResponseWriter() );
		writer.mapFields(FlexMenuBarRenderer.class, componentObj, null);
		writer.createPreMxml(componentFlex, FlexMenuBarRenderer.class.getAnnotation(IJsfFlexAttributeProperties.class).componentName(), 
				null);
		
	}
	
}
