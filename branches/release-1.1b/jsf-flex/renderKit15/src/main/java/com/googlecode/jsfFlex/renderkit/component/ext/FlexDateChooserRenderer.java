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
import com.googlecode.jsfFlex.renderkit.component.AbstractFlexComponentRenderer;
import com.googlecode.jsfFlex.renderkit.flex.AbstractFlexResponseWriter;
import com.googlecode.jsfFlex.shared.adapter.IFlexContract;

/**
 * @author Ji Hoon Kim
 */
@JSFRenderer(
        renderKitId="FLEX_BASIC",
        family="javax.faces.FlexInput",
        type="com.googlecode.jsfFlex.FlexDateChooser"
)
@IJsfFlexAttributeProperties(
        componentPackage="mx.controls",
        componentName="DateChooser",
        componentNodeAttributes={
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
                @IJsfFlexAttribute(attribute="allowDisjointSelection"),
                @IJsfFlexAttribute(attribute="allowMultipleSelection"),
                @IJsfFlexAttribute(attribute="dayNames"),
                @IJsfFlexAttribute(attribute="disabledDays"),
                @IJsfFlexAttribute(attribute="disabledRanges"),
                @IJsfFlexAttribute(attribute="displayedMonth"),
                @IJsfFlexAttribute(attribute="displayedYear"),
                @IJsfFlexAttribute(attribute="firstDayOfWeek"),
                @IJsfFlexAttribute(attribute="maxYear"),
                @IJsfFlexAttribute(attribute="minYear"),
                @IJsfFlexAttribute(attribute="monthNames"),
                @IJsfFlexAttribute(attribute="monthSymbol"),
                @IJsfFlexAttribute(attribute="selectableRange"),
                @IJsfFlexAttribute(attribute="selectedRanges"),
                @IJsfFlexAttribute(attribute="showToday"),
                @IJsfFlexAttribute(attribute="yearNavigationEnabled"),
                @IJsfFlexAttribute(attribute="yearSymbol"),
                @IJsfFlexAttribute(attribute="backgroundColor"),
                @IJsfFlexAttribute(attribute="backgroundAlpha"),
                @IJsfFlexAttribute(attribute="borderColor"),
                @IJsfFlexAttribute(attribute="borderThickness"),
                @IJsfFlexAttribute(attribute="color"),
                @IJsfFlexAttribute(attribute="cornerRadius"),
                @IJsfFlexAttribute(attribute="disabledColor"),
                @IJsfFlexAttribute(attribute="disabledIconColor"),
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
                @IJsfFlexAttribute(attribute="headerColors"),
                @IJsfFlexAttribute(attribute="headerStyleName"),
                @IJsfFlexAttribute(attribute="highlightAlphas"),
                @IJsfFlexAttribute(attribute="horizontalGap"),
                @IJsfFlexAttribute(attribute="iconColor"),
                @IJsfFlexAttribute(attribute="leading"),
                @IJsfFlexAttribute(attribute="nextMonthDisabledSkin"),
                @IJsfFlexAttribute(attribute="nextMonthDownSkin"),
                @IJsfFlexAttribute(attribute="nextMonthOverSkin"),
                @IJsfFlexAttribute(attribute="nextMonthSkin"),
                @IJsfFlexAttribute(attribute="nextMonthUpSkin"),
                @IJsfFlexAttribute(attribute="nextYearDisabledSkin"),
                @IJsfFlexAttribute(attribute="nextYearDownSkin"),
                @IJsfFlexAttribute(attribute="nextYearOverSkin"),
                @IJsfFlexAttribute(attribute="nextYearSkin"),
                @IJsfFlexAttribute(attribute="nextYearUpSkin"),
                @IJsfFlexAttribute(attribute="prevMonthDisabledSkin"),
                @IJsfFlexAttribute(attribute="prevMonthDownSkin"),
                @IJsfFlexAttribute(attribute="prevMonthOverSkin"),
                @IJsfFlexAttribute(attribute="prevMonthSkin"),
                @IJsfFlexAttribute(attribute="prevMonthUpSkin"),
                @IJsfFlexAttribute(attribute="prevYearDisabledSkin"),
                @IJsfFlexAttribute(attribute="prevYearDownSkin"),
                @IJsfFlexAttribute(attribute="prevYearOverSkin"),
                @IJsfFlexAttribute(attribute="prevYearSkin"),
                @IJsfFlexAttribute(attribute="prevYearUpSkin"),
                @IJsfFlexAttribute(attribute="rollOverColor"),
                @IJsfFlexAttribute(attribute="rollOverIndicatorSkin"),
                @IJsfFlexAttribute(attribute="selectionColor"),
                @IJsfFlexAttribute(attribute="selectionIndicatorSkin"),
                @IJsfFlexAttribute(attribute="textAlign"),
                @IJsfFlexAttribute(attribute="textDecoration"),
                @IJsfFlexAttribute(attribute="textIndent"),
                @IJsfFlexAttribute(attribute="todayColor"),
                @IJsfFlexAttribute(attribute="todayIndicatorSkin"),
                @IJsfFlexAttribute(attribute="todayStyleName"),
                @IJsfFlexAttribute(attribute="verticalGap"),
                @IJsfFlexAttribute(attribute="weekDayStyleName"),
                @IJsfFlexAttribute(attribute="change"),
                @IJsfFlexAttribute(attribute="scroll")
        }
)
public final class FlexDateChooserRenderer extends AbstractFlexComponentRenderer {

    @Override
    public void encodeBegin(FacesContext context, UIComponent componentObj) throws IOException {
        super.encodeBegin(context, componentObj);
        
        IFlexContract componentFlex = IFlexContract.class.cast( componentObj );
        
        AbstractFlexResponseWriter writer = AbstractFlexResponseWriter.class.cast( context.getResponseWriter() );
        writer.mapFields(FlexDateChooserRenderer.class, componentObj, null);
        writer.createPreMxml(componentFlex, FlexDateChooserRenderer.class.getAnnotation(IJsfFlexAttributeProperties.class).componentName(), 
                null);
        
    }
    
}
