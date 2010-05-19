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
import com.googlecode.jsfFlex.renderkit.component.AbstractFlexComponentBaseRenderer;
import com.googlecode.jsfFlex.renderkit.flex.AbstractFlexResponseWriter;
import com.googlecode.jsfFlex.shared.adapter.IFlexContract;

/**
 * @author Ji Hoon Kim
 */
@JSFRenderer(
		renderKitId="FLEX_BASIC",
		family="javax.faces.FlexInput",
		type="com.googlecode.jsfFlex.FlexDataGridColumn"
)
@IJsfFlexAttributeProperties(
		componentName="DataGridColumn",
		componentNodeAttributes={},

		jsfFlexAttributes={
				@IJsfFlexAttribute(attribute="dataField", byMethod=true),
				@IJsfFlexAttribute(attribute="dataTipField"),
				@IJsfFlexAttribute(attribute="dataTipFunction"),
				@IJsfFlexAttribute(attribute="editable", byMethod=true),
				@IJsfFlexAttribute(attribute="editorDataField"),
				@IJsfFlexAttribute(attribute="editorHeightOffset"),
				@IJsfFlexAttribute(attribute="editorUsesEnterKey"),
				@IJsfFlexAttribute(attribute="editorWidthOffset"),
				@IJsfFlexAttribute(attribute="editorXOffset"),
				@IJsfFlexAttribute(attribute="editorYOffset"),
				@IJsfFlexAttribute(attribute="headerRenderer"),
				@IJsfFlexAttribute(attribute="headerText"),
				@IJsfFlexAttribute(attribute="headerWordWrap"),
				@IJsfFlexAttribute(attribute="imeMode"),
				@IJsfFlexAttribute(attribute="itemEditor"),
				@IJsfFlexAttribute(attribute="itemRenderer"),
				@IJsfFlexAttribute(attribute="labelFunction"),
				@IJsfFlexAttribute(attribute="minWidth"),
				@IJsfFlexAttribute(attribute="rendererIsEditor"),
				@IJsfFlexAttribute(attribute="resizable"),
				@IJsfFlexAttribute(attribute="showDataTips"),
				@IJsfFlexAttribute(attribute="sortable"),
				@IJsfFlexAttribute(attribute="sortCompareFunction"),
				@IJsfFlexAttribute(attribute="sortDescending"),
				@IJsfFlexAttribute(attribute="visible"),
				@IJsfFlexAttribute(attribute="wordWrap"),
				@IJsfFlexAttribute(attribute="backgroundColor"),
				@IJsfFlexAttribute(attribute="color"),
				@IJsfFlexAttribute(attribute="disabledColor"),
				@IJsfFlexAttribute(attribute="fontAntiAliasType"),
				@IJsfFlexAttribute(attribute="fontFamily"),
				@IJsfFlexAttribute(attribute="fontGridFitType"),
				@IJsfFlexAttribute(attribute="fontSharpness"),
				@IJsfFlexAttribute(attribute="fontSize"),
				@IJsfFlexAttribute(attribute="fontStyle"),
				@IJsfFlexAttribute(attribute="fontThickness"),
				@IJsfFlexAttribute(attribute="fontWeight"),
				@IJsfFlexAttribute(attribute="headerStyleName"),
				@IJsfFlexAttribute(attribute="paddingLeft"),
				@IJsfFlexAttribute(attribute="paddingRight"),
				@IJsfFlexAttribute(attribute="textAlign"),
				@IJsfFlexAttribute(attribute="textDecoration"),
				@IJsfFlexAttribute(attribute="textIndent")
		}
)
public final class FlexDataGridColumnRenderer extends AbstractFlexComponentBaseRenderer {
	
	@Override
	public void encodeBegin(FacesContext context, UIComponent componentObj) throws IOException {
		super.encodeBegin(context, componentObj);
		
		IFlexContract componentFlex = IFlexContract.class.cast( componentObj );
		
		AbstractFlexResponseWriter writer = AbstractFlexResponseWriter.class.cast( context.getResponseWriter() );
		writer.mapFields(FlexDataGridColumnRenderer.class, componentObj, null);
		writer.createPreMxml(componentFlex, FlexDataGridColumnRenderer.class.getAnnotation(IJsfFlexAttributeProperties.class), 
				null);
		
	}
	
}
