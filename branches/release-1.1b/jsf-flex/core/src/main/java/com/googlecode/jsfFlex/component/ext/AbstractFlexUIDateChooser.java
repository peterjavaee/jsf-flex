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

import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFComponent;

import com.googlecode.jsfFlex.attributes.IFlexUIAllowDisjointSelectionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIAllowMultipleSelectionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBackgroundAlphaAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBackgroundColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBaseAttributes;
import com.googlecode.jsfFlex.attributes.IFlexUIBorderColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBorderThicknessAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIChangeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUICornerRadiusAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDayNamesAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDisabledColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDisabledDaysAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDisabledIconColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDisabledRangesAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDisplayedMonthAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDisplayedYearAttribute;
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
import com.googlecode.jsfFlex.attributes.IFlexUIHeaderColorsAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIHeaderStyleNameAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIHighlightAlphasAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIHorizontalGapAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIIconColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUILeadingAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIMaxYearAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIMinYearAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIMonthNamesAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIMonthSymbolAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUINextMonthDisabledSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUINextMonthDownSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUINextMonthOverSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUINextMonthSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUINextMonthUpSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUINextYearDisabledSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUINextYearDownSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUINextYearOverSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUINextYearSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUINextYearUpSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPrevMonthDisabledSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPrevMonthDownSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPrevMonthOverSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPrevMonthSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPrevMonthUpSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPrevYearDisabledSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPrevYearDownSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPrevYearOverSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPrevYearSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPrevYearUpSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIRollOverColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIRollOverIndicatorSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIScrollAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISelectableRangeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISelectedDateAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISelectedRangesAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISelectionColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISelectionIndicatorSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIShowTodayAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextAlignAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextDecorationAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextIndentAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITodayColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITodayIndicatorSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITodayStyleNameAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIVerticalGapAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIWeekDayStyleNameAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIYearNavigationEnabledAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIYearSymbolAttribute;
import com.googlecode.jsfFlex.component.AbstractUIInputBase;

/**
 * @author Ji Hoon Kim
 */
@JSFComponent(
        name                =   "jf:flexDateChooser",
        clazz               =   "com.googlecode.jsfFlex.component.ext.FlexUIDateChooser",
        type                =   "com.googlecode.jsfFlex.FlexUIDateChooser",
        tagClass            =   "com.googlecode.jsfFlex.taglib.component.ext.FlexUIDateChooserTag",
        family              =   "javax.faces.FlexInput",
        defaultRendererType =   "com.googlecode.jsfFlex.FlexDateChooser",
        tagSuperclass       =   "com.googlecode.jsfFlex.taglib.FlexUIInputTagBase"
)
public abstract class AbstractFlexUIDateChooser 
                            extends AbstractUIInputBase 
                            implements IFlexUIBaseAttributes, IFlexUIAllowDisjointSelectionAttribute, IFlexUIAllowMultipleSelectionAttribute, 
                            IFlexUIDayNamesAttribute, IFlexUIDisabledDaysAttribute, IFlexUIDisabledRangesAttribute, 
                            IFlexUIDisplayedMonthAttribute, IFlexUIDisplayedYearAttribute, IFlexUIFirstDayOfWeekAttribute, 
                            IFlexUIMaxYearAttribute, IFlexUIMinYearAttribute, IFlexUIMonthNamesAttribute, IFlexUIMonthSymbolAttribute, 
                            IFlexUISelectableRangeAttribute, IFlexUISelectedDateAttribute, IFlexUISelectedRangesAttribute, 
                            IFlexUIShowTodayAttribute, IFlexUIYearNavigationEnabledAttribute, IFlexUIYearSymbolAttribute, 
                            IFlexUIBackgroundColorAttribute, IFlexUIBackgroundAlphaAttribute, IFlexUIBorderColorAttribute, 
                            IFlexUIBorderThicknessAttribute, IFlexUIColorAttribute, IFlexUICornerRadiusAttribute, 
                            IFlexUIDisabledColorAttribute, IFlexUIDisabledIconColorAttribute, IFlexUIFillAlphasAttribute, 
                            IFlexUIFillColorsAttribute, IFlexUIFocusAlphaAttribute, IFlexUIFocusRoundedCornersAttribute, 
                            IFlexUIFontAntiAliasTypeAttribute, IFlexUIFontFamilyAttribute, IFlexUIFontGridFitTypeAttribute, 
                            IFlexUIFontSharpnessAttribute, IFlexUIFontSizeAttribute, IFlexUIFontStyleAttribute, 
                            IFlexUIFontThicknessAttribute, IFlexUIFontWeightAttribute, IFlexUIHeaderColorsAttribute, 
                            IFlexUIHeaderStyleNameAttribute, IFlexUIHighlightAlphasAttribute, IFlexUIHorizontalGapAttribute, 
                            IFlexUIIconColorAttribute, IFlexUILeadingAttribute, IFlexUINextMonthDisabledSkinAttribute, 
                            IFlexUINextMonthDownSkinAttribute, IFlexUINextMonthOverSkinAttribute, IFlexUINextMonthSkinAttribute, 
                            IFlexUINextMonthUpSkinAttribute, IFlexUINextYearDisabledSkinAttribute, IFlexUINextYearDownSkinAttribute, 
                            IFlexUINextYearOverSkinAttribute, IFlexUINextYearSkinAttribute, IFlexUINextYearUpSkinAttribute, 
                            IFlexUIPrevMonthDisabledSkinAttribute, IFlexUIPrevMonthDownSkinAttribute, IFlexUIPrevMonthOverSkinAttribute, 
                            IFlexUIPrevMonthSkinAttribute, IFlexUIPrevMonthUpSkinAttribute, IFlexUIPrevYearDisabledSkinAttribute, 
                            IFlexUIPrevYearDownSkinAttribute, IFlexUIPrevYearOverSkinAttribute, IFlexUIPrevYearSkinAttribute, 
                            IFlexUIPrevYearUpSkinAttribute, IFlexUIRollOverColorAttribute, IFlexUIRollOverIndicatorSkinAttribute, 
                            IFlexUISelectionColorAttribute, IFlexUISelectionIndicatorSkinAttribute, IFlexUITextAlignAttribute, 
                            IFlexUITextDecorationAttribute, IFlexUITextIndentAttribute, IFlexUITodayColorAttribute, 
                            IFlexUITodayIndicatorSkinAttribute, IFlexUITodayStyleNameAttribute, IFlexUIVerticalGapAttribute, 
                            IFlexUIWeekDayStyleNameAttribute, IFlexUIChangeAttribute, IFlexUIScrollAttribute {
    
    private final static org.apache.commons.logging.Log _log = org.apache.commons.logging.LogFactory.getLog(AbstractFlexUIDateChooser.class);
    
    private static final String SELECTED_DATE_ATTR = "selectedDate";
    private static final String SELECTED_DATE_ID_APPENDED = "_selectedDate";
    
    private static final String DATE_TYPE_INIT_VALUE = "Date";
    private static final String DATE_FORMAT_DEFAULT = "EEE MMM dd HH:mm:ss z Z yyyy";
    
    private org.json.JSONObject initValue;
    
    protected void populateComponentInitValues(){
        try{
            if(getSelectedDate() != null){
                getInitValue().put(VALUE, com.googlecode.jsfFlex.shared.util.JSONConverter.convertJavaDateToASDateConstructorArguments( getSelectedDate() ));
            }
        }catch(org.json.JSONException jsonException){
            _log.info("Error while formatting to JSON content", jsonException);
        }
    }
    
    private synchronized org.json.JSONObject getInitValue(){
        if(initValue == null){
            try{
                initValue = new org.json.JSONObject();
                initValue.put(ATTRIBUTE, SELECTED_DATE_ATTR);
                initValue.put(SPECIFIC_OBJECT_TYPE_INIT, DATE_TYPE_INIT_VALUE);
                
                _initValues.put(initValue);
                
            }catch(org.json.JSONException jsonException){
                _log.info("Error while formatting to JSON content", jsonException);
            }
        }
        return initValue;
    }
    
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
                setSubmittedValue(selectedDateUpdateVal);
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
