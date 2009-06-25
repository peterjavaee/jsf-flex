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

import java.util.Map;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFComponent;
import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFProperty;
import org.json.JSONException;
import org.json.JSONObject;

import com.googlecode.jsfFlex.attributes._MXMLUIBorderColorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIChangeAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUICloseAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUICloseDurationAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUICloseEasingFunctionAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIColorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIColorFieldAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIDataProviderAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIDisabledIconColorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIEditableAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIEnterAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIFillAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUIFocusAlphaAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIFocusRoundedCornersAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIFontFamilyAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIFontGeneralAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUIFontSpecificAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUIHighlightAlphaAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIIconColorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIItemEventAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUILabelFieldAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUILeadingAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIOpenAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIOpenDurationAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIOpenEasingFunctionAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIPaddingHorizontalAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUIPaddingVerticalAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUISelectedIndexAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIShowTextFieldAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUISwatchBorderColorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUISwatchBorderSizeAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUISwatchPanelStyleNameAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUITextAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUITextStyleAttributes;
import com.googlecode.jsfFlex.component.MXMLUIInputBase;

/**
 * @author Ji Hoon Kim
 */
@JSFComponent(
        name                =   "jf:mxmlColorPicker",
        clazz               =   "com.googlecode.jsfFlex.component.ext.MXMLUIColorPicker",
        type                =   "com.googlecode.jsfFlex.MXMLUIColorPicker",
        tagClass            =   "com.googlecode.jsfFlex.taglib.ext.MXMLUIColorPickerTag",
        family              =   "javax.faces.MXMLInput",
        defaultRendererType =   "com.googlecode.jsfFlex.MXMLColorPicker",
        tagSuperclass       =   "com.googlecode.jsfFlex.taglib.MXMLUIInputTagBase"
)
public abstract class AbstractMXMLUIColorPicker 
						extends MXMLUIInputBase
                        implements _MXMLUIComboBaseAttributes, _MXMLUILabelFieldAttribute, _MXMLUIBorderColorAttribute, _MXMLUICloseDurationAttribute,
                        _MXMLUIColorFieldAttribute, _MXMLUIShowTextFieldAttribute, _MXMLUICloseEasingFunctionAttribute,
                        _MXMLUIColorAttribute, _MXMLUIDisabledIconColorAttribute, _MXMLUIFillAttributes, 
                        _MXMLUIFocusAlphaAttribute, _MXMLUIFocusRoundedCornersAttribute, _MXMLUIFontGeneralAttributes,
                        _MXMLUIFontSpecificAttributes, _MXMLUIFontFamilyAttribute, _MXMLUIHighlightAlphaAttribute, 
                        _MXMLUIIconColorAttribute, _MXMLUILeadingAttribute, _MXMLUIOpenDurationAttribute, 
                        _MXMLUIOpenEasingFunctionAttribute, _MXMLUIPaddingVerticalAttributes, _MXMLUIPaddingHorizontalAttributes,
                        _MXMLUISwatchBorderColorAttribute, _MXMLUISwatchBorderSizeAttribute, _MXMLUISwatchPanelStyleNameAttribute,
                        _MXMLUITextStyleAttributes, _MXMLUIChangeAttribute, _MXMLUICloseAttribute, _MXMLUIEnterAttribute,
                        _MXMLUIItemEventAttributes, _MXMLUIOpenAttribute, _MXMLUISelectedIndexAttribute,
                        _MXMLUITextAttribute, _MXMLUIEditableAttribute, _MXMLUIDataProviderAttribute {
	
	private final static Log _log = LogFactory.getLog(AbstractMXMLUIColorPicker.class);
	
	private static final String SELECTED_COLOR_ATTR = "selectedColor";
	private static final String SELECTED_COLOR_ID_APPENDED = "_selectedColor";
	
	private JSONObject initValue;
	
	{
		try{
			initValue = new JSONObject();
			initValue.put(ATTRIBUTE, SELECTED_COLOR_ATTR);
			
			_initValues.put(initValue);
			
		}catch(JSONException jsonException){
			_log.info("Error while formatting to JSON content", jsonException);
		}
	}
	
	protected void populateComponentInitValues(){
		try{
			if(getSelectedColor() != null){
				initValue.put(VALUE, getSelectedColor());
			}
		}catch(JSONException jsonException){
			_log.info("Error while formatting to JSON content", jsonException);
		}
	}
	
	public void decode(FacesContext context) {
    	super.decode(context);
    	
    	Map requestMap = context.getExternalContext().getRequestParameterMap();
    	
    	String selectedColorId = getId() + SELECTED_COLOR_ID_APPENDED;
    	String selectedColorUpdateVal = (String) requestMap.get(selectedColorId);
    	
    	if(selectedColorUpdateVal != null){
    		setSelectedColor(selectedColorUpdateVal);
    		setSubmittedValue(selectedColorUpdateVal);
    	}
    	
    }
	
	public void processUpdates(FacesContext context) {
    	super.processUpdates(context);
    	
    	if (!isRendered() || !isValid()){
    		return;
    	}
    	
    	ValueExpression ve = getValueExpression(SELECTED_COLOR_ATTR);
    	
    	if(ve != null && !ve.isReadOnly(context.getELContext())){
    		ve.setValue(context.getELContext(), getSelectedColor());
    		setSelectedColor(null);
    	}
    	
    }
	
	/**
	 * The value of the currently selected color in the SwatchPanel object.
	 */
    @JSFProperty(desc   =   "The value of the currently selected color in the SwatchPanel object.")
	public abstract String getSelectedColor();
	
	public abstract void setSelectedColor(String selectedColor);
	
}
