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

import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.servlet.http.HttpServletRequest;

import com.googlecode.jsfFlex.component.MXMLUIInputBase;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBackgroundColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBorderColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIChangeAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUICloseAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUICloseAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIColumnCountAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIControlSkinAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDataProviderAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIEditableAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIEnterAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFillAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFocusAlphaAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFocusRoundedCornersAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFontFamilyAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFontSpecificAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIGapAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIHighlightAlphaAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIImeModeAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIImmediateAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIItemEventAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUILabelFieldAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUILeadingAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIOpenAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIOpenDurationAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIOpenEasingFunctionAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIPaddingHorizontalAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIPaddingVerticalAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIRestrictAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUISelectedIndexAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUISelectedItemAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUITextAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUITextStyleAttributes;
import com.googlecode.jsfFlex.component.attributes.compBase._MXMLUIBaseAttributes;
import com.googlecode.jsfFlex.component.attributes.compBase._MXMLUIComboBaseAttributes;

/**
 * @JSFComponent
 *   name     = "jf:mxmlColorPicker"
 *   class    = "com.googlecode.jsfFlex.component.ext.MXMLUIColorPicker"
 *   type     = "com.googlecode.jsfFlex.MXMLUIColorPicker"
 *   tagClass = "com.googlecode.jsfFlex.taglib.ext.MXMLUIColorPickerTag"
 *   family   = "javax.faces.MXMLInput"
 *   tagSuperclass = "org.apache.myfaces.shared_impl.taglib.UIComponentTagBase"
 *   defaultRendererType= "com.googlecode.jsfFlex.MXMLInput"
 *   
 * @JSFJspProperties
 * 		properties	=		
 *   						@JSFJspProperty
 * 							 name		= "colorField"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Name of the field in the objects of the dataProvider Array that specifies the hexadecimal values of the colors that the swatch panel displays."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "showTextField"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Specifies whether to show the text box that displays the color label or hexadecimalcolor value."
 *   						, 
 *   						
 *   						@JSFJspProperty
 * 							 name		= "previewHeight"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Height of the larger preview swatch that appears above the swatch grid on theupper left of the SwatchPanel object."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "previewWidth"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Width of the larger preview swatch."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "swatchBorderColor"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Color of the swatches' borders."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "swatchBorderSize"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Size of the outlines of the swatches' borders."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "swatchGridBackgroundColor"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Color of the background rectangle behind the swatch grid."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "swatchGridBorderSize"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Size of the single border around the grid of swatches."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "swatchHeight"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Height of each swatch."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "swatchHighlightColor"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Color of the highlight that appears around the swatch when the user rollsover a swatch."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "swatchHighlightSize"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Size of the highlight that appears around the swatch when the user rollsover a swatch."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "swatchPanelStyleName"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Name of the style for the SwatchPanel object."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "swatchWidth"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Width of each swatch."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "textFieldWidth"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Width of the text box that appears above the swatch grid."
 *   						
 * @author Ji Hoon Kim
 */
public abstract class AbstractMXMLUIColorPicker 
						extends MXMLUIInputBase 
						implements _MXMLUIComboBaseAttributes, _MXMLUIBaseAttributes, _MXMLUITextAttribute, 
						_MXMLUIBackgroundColorAttribute, _MXMLUIBorderColorAttribute, _MXMLUIChangeAttribute, 
						_MXMLUICloseAttribute, _MXMLUICloseAttributes, _MXMLUIColorAttribute, _MXMLUIControlSkinAttributes, 
						_MXMLUITextStyleAttributes, _MXMLUIDataProviderAttribute, _MXMLUIEditableAttribute, 
						_MXMLUIEnterAttribute, _MXMLUIFillAttributes, _MXMLUIFocusAlphaAttribute, 
						_MXMLUIFocusRoundedCornersAttribute, _MXMLUIFontFamilyAttribute, _MXMLUIFontSpecificAttributes,  
						_MXMLUIGapAttributes, _MXMLUIHighlightAlphaAttribute, _MXMLUIImeModeAttribute, 
						_MXMLUIImmediateAttribute, _MXMLUIItemEventAttributes, _MXMLUILabelFieldAttribute, 
						_MXMLUILeadingAttribute, _MXMLUIOpenAttribute, _MXMLUIOpenDurationAttribute, 
						_MXMLUIOpenEasingFunctionAttribute, _MXMLUIPaddingHorizontalAttributes, _MXMLUIPaddingVerticalAttributes,  
						_MXMLUIRestrictAttribute, _MXMLUISelectedIndexAttribute, _MXMLUISelectedItemAttribute, 
						_MXMLUIColumnCountAttribute {
	
	private static final String MXML_COMPONENT_RENDERER = "com.googlecode.jsfFlex.MXMLColorPicker";
	private static final String SELECTED_COLOR_ID_APPENDED = "_selectedColor";
	
	public String getMXMLComponentRenderer() {
		return MXML_COMPONENT_RENDERER;
	}
	
	public Map getComponentValues() {
		_componentValues.put("selectedColor", getSelectedColor());
		return super.getComponentValues();
	}
	
	public void decode(FacesContext context) {
    	super.decode(context);
    	
    	HttpServletRequest httpRequest = (HttpServletRequest) context.getExternalContext().getRequest();
    	
    	String selectedColorId = getId() + SELECTED_COLOR_ID_APPENDED;
    	String selectedColorUpdateVal = httpRequest.getParameter(selectedColorId);
    	
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
    	
    	ValueBinding vb = getValueBinding("selectedColor");
		if(vb != null && !vb.isReadOnly(getFacesContext())){
			vb.setValue(getFacesContext(), getSelectedColor());
			setSelectedColor(null);
		}
    	
    }

	/**
	 * The value of the currently selected color in the SwatchPanel object.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = true
	 *    desc            = "The value of the currently selected color in the SwatchPanel object."
	 */
	public abstract String getSelectedColor();
	
	public abstract void setSelectedColor(String selectedColor);
	
}
