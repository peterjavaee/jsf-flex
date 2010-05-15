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
import org.json.JSONException;
import org.json.JSONObject;

import com.googlecode.jsfFlex.attributes.IFlexUIBorderColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIChangeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUICloseAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUICloseDurationAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUICloseEasingFunctionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIColorFieldAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDataProviderAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDisabledIconColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIEditableAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIEnterAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFillAlphasAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFillColorsAttribute;
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
import com.googlecode.jsfFlex.attributes.IFlexUIHighlightAlphasAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIIconColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIItemRollOutAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIItemRollOverAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUILabelFieldAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUILeadingAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIOpenAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIOpenDurationAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIOpenEasingFunctionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPaddingBottomAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPaddingLeftAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPaddingRightAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPaddingTopAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISelectedColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISelectedIndexAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIShowTextFieldAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISwatchBorderColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISwatchBorderSizeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISwatchPanelStyleNameAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextAlignAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextDecorationAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextIndentAttribute;
import com.googlecode.jsfFlex.component.AbstractFlexUIInputBase;

/**
 * @author Ji Hoon Kim
 */
@JSFComponent(
        name                =   "jf:flexColorPicker",
        clazz               =   "com.googlecode.jsfFlex.component.ext.FlexUIColorPicker",
        type                =   "com.googlecode.jsfFlex.FlexUIColorPicker",
        tagClass            =   "com.googlecode.jsfFlex.taglib.component.ext.FlexUIColorPickerTag",
        family              =   "javax.faces.FlexInput",
        defaultRendererType =   "com.googlecode.jsfFlex.FlexColorPicker",
        tagSuperclass       =   "com.googlecode.jsfFlex.taglib.AbstractFlexUIInputTagBase"
)
public abstract class AbstractFlexUIColorPicker 
						extends AbstractFlexUIInputBase
                        implements IFlexUIComboBaseAttributes, IFlexUIColorFieldAttribute, IFlexUILabelFieldAttribute, 
                        IFlexUIShowTextFieldAttribute, IFlexUIBorderColorAttribute, IFlexUICloseDurationAttribute, 
                        IFlexUICloseEasingFunctionAttribute, IFlexUIColorAttribute, IFlexUIDisabledIconColorAttribute, 
                        IFlexUIFillAlphasAttribute, IFlexUIFillColorsAttribute, IFlexUIFocusAlphaAttribute, 
                        IFlexUIFocusRoundedCornersAttribute, IFlexUIFontAntiAliasTypeAttribute, IFlexUIFontFamilyAttribute, 
                        IFlexUIFontGridFitTypeAttribute, IFlexUIFontSharpnessAttribute, IFlexUIFontSizeAttribute, 
                        IFlexUIFontStyleAttribute, IFlexUIFontThicknessAttribute, IFlexUIFontWeightAttribute, 
                        IFlexUIHighlightAlphasAttribute, IFlexUIIconColorAttribute, IFlexUILeadingAttribute, 
                        IFlexUIOpenDurationAttribute, IFlexUIOpenEasingFunctionAttribute, IFlexUIPaddingBottomAttribute, 
                        IFlexUIPaddingLeftAttribute, IFlexUIPaddingRightAttribute, IFlexUIPaddingTopAttribute, 
                        IFlexUISwatchBorderColorAttribute, IFlexUISwatchBorderSizeAttribute, IFlexUISwatchPanelStyleNameAttribute, 
                        IFlexUITextAlignAttribute, IFlexUITextDecorationAttribute, IFlexUITextIndentAttribute, 
                        IFlexUIChangeAttribute, IFlexUICloseAttribute, IFlexUIEnterAttribute, IFlexUIItemRollOutAttribute,
                        IFlexUIItemRollOverAttribute, IFlexUIOpenAttribute, IFlexUIDataProviderAttribute, 
                        IFlexUIEditableAttribute, IFlexUISelectedIndexAttribute, IFlexUITextAttribute,
                        IFlexUISelectedColorAttribute {
	
	private final static Log _log = LogFactory.getLog(AbstractFlexUIColorPicker.class);
	
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
    	
    	Map<String, String> requestMap = context.getExternalContext().getRequestParameterMap();
    	
    	String selectedColorId = getId() + SELECTED_COLOR_ID_APPENDED;
    	String selectedColorUpdateVal = requestMap.get(selectedColorId);
    	
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
	
}
