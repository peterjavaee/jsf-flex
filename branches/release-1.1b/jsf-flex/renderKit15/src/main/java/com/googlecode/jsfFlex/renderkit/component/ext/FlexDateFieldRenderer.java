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

import com.googlecode.jsfFlex.renderkit.annotation.IFlexComponentNodeAttribute;
import com.googlecode.jsfFlex.renderkit.annotation.IJsfFlexAttribute;
import com.googlecode.jsfFlex.renderkit.annotation.IJsfFlexAttributeProperties;
import com.googlecode.jsfFlex.renderkit.component.AbstractFlexComboBaseTemplateRenderer;
import com.googlecode.jsfFlex.renderkit.flex.AbstractFlexResponseWriter;
import com.googlecode.jsfFlex.shared.adapter.IFlexContract;

/**
 * @author Ji Hoon Kim
 */
@JSFRenderer(
		renderKitId="FLEX_BASIC",
		family="javax.faces.FlexInput",
		type="com.googlecode.jsfFlex.FlexDateField"
)
@IJsfFlexAttributeProperties(
		componentName="DateField",
		componentPackage="mx.controls",
		componentNodeAttributes={
				@IFlexComponentNodeAttribute(
						htmlType="input",
						typeAttributeValue="hidden",
						valueAttributeValue="text",
						isValueDynamic=true,
						isValueNested=false,
						valueNestedValues={},
						nameAttributeValue="id",
						isNameDynamic=true,
						nameAppend="_text"),
                @IFlexComponentNodeAttribute(
                        htmlType="input",
                        typeAttributeValue="hidden",
                        valueAttributeValue="selectedDate",
                        isValueDynamic=true,
                        isValueNested=false,
                        valueNestedValues={},
                        nameAttributeValue="id",
                        isNameDynamic=true,
                        nameAppend="_selectedDate")
		},

		jsfFlexAttributes={
				@IJsfFlexAttribute(attribute="dayNames"),
				@IJsfFlexAttribute(attribute="disabledDays"),
				@IJsfFlexAttribute(attribute="disabledRanges"),
				@IJsfFlexAttribute(attribute="displayedMonth"),
				@IJsfFlexAttribute(attribute="displayedYear"),
                @IJsfFlexAttribute(attribute="dropdownFactory"),
                @IJsfFlexAttribute(attribute="firstDayOfWeek"),
				@IJsfFlexAttribute(attribute="formatString"),
				@IJsfFlexAttribute(attribute="labelFunction"),
				@IJsfFlexAttribute(attribute="maxYear"),
				@IJsfFlexAttribute(attribute="minYear"),
				@IJsfFlexAttribute(attribute="monthNames"),
				@IJsfFlexAttribute(attribute="monthSymbol"),
				@IJsfFlexAttribute(attribute="parseFunction"),
				@IJsfFlexAttribute(attribute="selectableRange"),
				@IJsfFlexAttribute(attribute="showToday"),
				@IJsfFlexAttribute(attribute="yearNavigationEnabled"),
				@IJsfFlexAttribute(attribute="yearSymbol"),
				@IJsfFlexAttribute(attribute="borderColor"),
				@IJsfFlexAttribute(attribute="borderThickness"),
				@IJsfFlexAttribute(attribute="color"),
				@IJsfFlexAttribute(attribute="cornerRadius"),
				@IJsfFlexAttribute(attribute="dateChooserStyleName"),
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
                @IJsfFlexAttribute(attribute="iconColor"),
				@IJsfFlexAttribute(attribute="headerColors"),
				@IJsfFlexAttribute(attribute="headerStyleName"),
				@IJsfFlexAttribute(attribute="highlightAlphas"),
				@IJsfFlexAttribute(attribute="leading"),
				@IJsfFlexAttribute(attribute="paddingLeft"),
				@IJsfFlexAttribute(attribute="paddingRight"),
				@IJsfFlexAttribute(attribute="rollOverColor"),
				@IJsfFlexAttribute(attribute="selectionColor"),
				@IJsfFlexAttribute(attribute="textAlign"),
				@IJsfFlexAttribute(attribute="textDecoration"),
				@IJsfFlexAttribute(attribute="textIndent"),
				@IJsfFlexAttribute(attribute="todayColor"),
				@IJsfFlexAttribute(attribute="todayStyleName"),
				@IJsfFlexAttribute(attribute="weekDayStyleName"),
				@IJsfFlexAttribute(attribute="change"),
				@IJsfFlexAttribute(attribute="close"),
				@IJsfFlexAttribute(attribute="dataChange"),
				@IJsfFlexAttribute(attribute="open"),
				@IJsfFlexAttribute(attribute="scroll")
		}
)
public final class FlexDateFieldRenderer extends AbstractFlexComboBaseTemplateRenderer {
	
	@Override
	public void encodeBegin(FacesContext context, UIComponent componentObj) throws IOException {
		super.encodeBegin(context, componentObj);
		
		IFlexContract componentFlex = IFlexContract.class.cast( componentObj );
		
		AbstractFlexResponseWriter writer = AbstractFlexResponseWriter.class.cast( context.getResponseWriter() );
		writer.mapFields(FlexDateFieldRenderer.class, componentObj, null);
		writer.createPreMxml(componentFlex, FlexDateFieldRenderer.class.getAnnotation(IJsfFlexAttributeProperties.class), 
				null);
		
	}

}
