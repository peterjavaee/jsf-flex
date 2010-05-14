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
package com.googlecode.jsfFlex.component.ext;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFComponent;

import com.googlecode.jsfFlex.attributes.IFlexUIBorderColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBorderThicknessAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIChangeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUICloseAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUICornerRadiusAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDataChangeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDataProviderAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDateChooserStyleNameAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDayNamesAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDisabledColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDisabledDaysAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDisabledRangesAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDisplayedMonthAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDisplayedYearAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDropdownFactoryAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIEditableAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFillAlphasAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFillColorsAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFirstDayOfWeekAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFocusAlphaAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFocusRoundedCornersAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontAntiAliasTypeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontFamilyAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontGridFitTypeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontSharpnessAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontSizeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontStyleAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontThicknessAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontWeightAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFormatStringAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIHeaderColorsAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIHeaderStyleNameAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIHighlightAlphasAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIIconColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUILabelFunctionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUILeadingAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIMaxYearAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIMinYearAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIMonthNamesAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIMonthSymbolAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIOpenAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPaddingLeftAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPaddingRightAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIParseFunctionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIRollOverColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIScrollAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISelectableRangeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISelectedDateAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISelectedIndexAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISelectionColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIShowTodayAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextAlignAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextDecorationAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextIndentAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITodayColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITodayStyleNameAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIWeekDayStyleNameAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIYearNavigationEnabledAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIYearSymbolAttribute;

/**
 * @author Ji Hoon Kim
 */
@JSFComponent(
        name                =   "jf:flexDateField",
        clazz               =   "com.googlecode.jsfFlex.component.ext.FlexUIDateField",
        type                =   "com.googlecode.jsfFlex.FlexUIDateField",
        tagClass            =   "com.googlecode.jsfFlex.taglib.component.ext.FlexUIDateFieldTag",
        family              =   "javax.faces.FlexInput",
        defaultRendererType =   "com.googlecode.jsfFlex.FlexDateField",
        tagSuperclass       =   "com.googlecode.jsfFlex.taglib.FlexUIInputTagBase"
)
public abstract class AbstractFlexUIDateField 
						extends com.googlecode.jsfFlex.component.FlexUITextInputBase 
						implements IFlexUIComboBaseAttributes, IFlexUIDayNamesAttribute, IFlexUIDisabledDaysAttribute, 
                        IFlexUIDisabledRangesAttribute, IFlexUIDisplayedMonthAttribute, IFlexUIDisplayedYearAttribute, 
                        IFlexUIDropdownFactoryAttribute, IFlexUIFirstDayOfWeekAttribute, IFlexUIFormatStringAttribute, 
                        IFlexUILabelFunctionAttribute, IFlexUIMaxYearAttribute, IFlexUIMinYearAttribute, IFlexUIMonthNamesAttribute, 
                        IFlexUIMonthSymbolAttribute, IFlexUIParseFunctionAttribute, IFlexUISelectableRangeAttribute, 
                        IFlexUISelectedDateAttribute, IFlexUIShowTodayAttribute, IFlexUIYearNavigationEnabledAttribute, 
                        IFlexUIYearSymbolAttribute, IFlexUIBorderColorAttribute, IFlexUIBorderThicknessAttribute, IFlexUIColorAttribute, 
                        IFlexUICornerRadiusAttribute, IFlexUIDateChooserStyleNameAttribute, IFlexUIDisabledColorAttribute, 
                        IFlexUIFillAlphasAttribute, IFlexUIFillColorsAttribute, IFlexUIFocusAlphaAttribute, 
                        IFlexUIFocusRoundedCornersAttribute, IFlexUIFontAntiAliasTypeAttribute, IFlexUIFontFamilyAttribute, 
                        IFlexUIFontGridFitTypeAttribute, IFlexUIFontSharpnessAttribute, IFlexUIFontSizeAttribute, 
                        IFlexUIFontStyleAttribute, IFlexUIFontThicknessAttribute, IFlexUIFontWeightAttribute, IFlexUIIconColorAttribute,
                        IFlexUIHeaderColorsAttribute, IFlexUIHeaderStyleNameAttribute, IFlexUIHighlightAlphasAttribute, 
                        IFlexUILeadingAttribute, IFlexUIPaddingLeftAttribute, IFlexUIPaddingRightAttribute, 
                        IFlexUIRollOverColorAttribute, IFlexUISelectionColorAttribute, IFlexUITextAlignAttribute, 
                        IFlexUITextDecorationAttribute, IFlexUITextIndentAttribute, IFlexUITodayColorAttribute, 
                        IFlexUITodayStyleNameAttribute, IFlexUIWeekDayStyleNameAttribute, IFlexUIChangeAttribute, 
                        IFlexUICloseAttribute, IFlexUIDataChangeAttribute, IFlexUIOpenAttribute, IFlexUIScrollAttribute,
                        IFlexUIDataProviderAttribute, IFlexUIEditableAttribute, IFlexUISelectedIndexAttribute {
	
    private final static Log _log = LogFactory.getLog(AbstractFlexUIDateField.class);
    
    private static final String SELECTED_DATE_ATTR = "selectedDate";
    private static final String SELECTED_DATE_ID_APPENDED = "_selectedDate";
    
    private static final String DATE_FORMAT_DEFAULT = "EEE MMM dd HH:mm:ss z Z yyyy";
    
    public void decode(FacesContext context) {
        super.decode(context);
        
        java.util.Map<String, String> requestMap = context.getExternalContext().getRequestParameterMap();
        
        String selectedDateId = getId() + SELECTED_DATE_ID_APPENDED;
        String selectedDateUpdateVal = requestMap.get(selectedDateId);
        
        if(selectedDateUpdateVal != null && selectedDateUpdateVal.length() > 0){
            /*
             * HACK: Since ActionScript returns date in format of "Thu Aug 23 00:00:00 GMT-0700 2009"
             * and "EEE MMM dd HH:mm:ss zZ yyyy" pattern doesn't seem to match it within SimpleDateFormat,
             * place a space between z + Z
             */
            int dashIndex = selectedDateUpdateVal.indexOf("-");
            if(dashIndex != -1){
                selectedDateUpdateVal = selectedDateUpdateVal.substring(0, dashIndex) + " " + selectedDateUpdateVal.substring(dashIndex);
            }
            Calendar instance = Calendar.getInstance();
            try{
                DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_DEFAULT);
                dateFormat.setLenient(true);
                instance.setTime( dateFormat.parse(selectedDateUpdateVal) );
                setSelectedDate(instance);
            }catch(ParseException parsingException){
                setValid(false);
                context.addMessage(getId(), new FacesMessage("Parsing exception for value : " + selectedDateUpdateVal));
                _log.error("Parsing exception for value : " + selectedDateUpdateVal, parsingException);
            }
        }
    }
    
    public void processUpdates(FacesContext context) {
        super.processUpdates(context);
        
        if (!isRendered() || !isValid()){
            return;
        }
        
        javax.el.ValueExpression ve = getValueExpression(SELECTED_DATE_ATTR);
        
        if(ve != null && !ve.isReadOnly(context.getELContext())){
            ve.setValue(context.getELContext(), getSelectedDate());
            setSelectedDate(null);
        }
        
    }
    
}
