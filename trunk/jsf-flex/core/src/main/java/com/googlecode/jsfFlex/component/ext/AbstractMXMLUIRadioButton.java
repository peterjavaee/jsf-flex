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

import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.servlet.http.HttpServletRequest;

import com.googlecode.jsfFlex.component.MXMLUIButtonBase;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBorderColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIChangeAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIControlSkinAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUICornerRadiusAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDataChangeAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDisabledColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFillAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFocusAlphaAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFocusRoundedCornersAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFontFamilyAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFontGeneralAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFontSpecificAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIGapAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIHighlightAlphaAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIIconAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIImmediateAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUILabelAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUILabelPlacementAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUILeadingAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIPaddingHorizontalAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIPaddingVerticalAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIRepeatAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUITextAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUITextEventColorAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUITextStyleAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIValueAttribute;
import com.googlecode.jsfFlex.component.attributes.compBase._MXMLUIBaseAttributes;
import com.googlecode.jsfFlex.component.attributes.compBase._MXMLUIButtonAttributes;

/**
 * @JSFComponent
 *   name     = "jf:mxmlRadioButton"
 *   class    = "com.googlecode.jsfFlex.component.ext.MXMLUIRadioButton"
 *   type     = "com.googlecode.jsfFlex.MXMLUIRadioButton"
 *   tagClass = "com.googlecode.jsfFlex.taglib.ext.MXMLUIRadioButtonTag"
 *   family   = "javax.faces.MXMLInput"
 *   tagSuperclass = "org.apache.myfaces.shared_impl.taglib.UIComponentTagBase"
 *   defaultRendererType= "com.googlecode.jsfFlex.MXMLInput"
 *   
 * @author Ji Hoon Kim
 */
public abstract class AbstractMXMLUIRadioButton 
						extends MXMLUIButtonBase
						implements _MXMLUIIconAttribute, _MXMLUIBaseAttributes, _MXMLUITextStyleAttributes, 
						_MXMLUIBorderColorAttribute, _MXMLUIChangeAttribute, _MXMLUIColorAttribute, 
						_MXMLUIControlSkinAttributes, _MXMLUIValueAttribute, _MXMLUICornerRadiusAttribute, 
						_MXMLUIDataChangeAttribute, _MXMLUIDisabledColorAttribute, _MXMLUIFillAttributes, 
						_MXMLUIFocusAlphaAttribute, _MXMLUIFocusRoundedCornersAttribute, _MXMLUIFontFamilyAttribute, 
						_MXMLUIFontGeneralAttributes, _MXMLUIFontSpecificAttributes, _MXMLUIGapAttributes, 
						_MXMLUIHighlightAlphaAttribute, _MXMLUIImmediateAttribute, _MXMLUILabelAttribute, 
						_MXMLUILabelPlacementAttribute, _MXMLUILeadingAttribute, _MXMLUIPaddingHorizontalAttributes, 
						_MXMLUIPaddingVerticalAttributes, _MXMLUIRepeatAttributes, _MXMLUITextEventColorAttributes, 
						_MXMLUIButtonAttributes, _MXMLUITextAttribute {
	
	private static final String MXML_COMPONENT_RENDERER = "com.googlecode.jsfFlex.MXMLRadioButton";
	private static final String SELECTED_VALUE_ID_APPENDED = "_selectedValue";
	
	public String getMXMLComponentRenderer(){
    	return MXML_COMPONENT_RENDERER;
    }
	
	public void decode(FacesContext context) {
    	super.decode(context);
    	
    	HttpServletRequest httpRequest = (HttpServletRequest) context.getExternalContext().getRequest();
    	
    	/*
    	 *	So to make it easy for databinding, will utilize groupName + _selectedValue
    	 *	as the search parameter when setting the selectedValue variable.
    	 *	This way the developer has to simply dataBind on selectedValue per groupName entry
    	 *	to check which value was selected by user.
    	 */
    	
    	String selectedValueId = getGroupName() + SELECTED_VALUE_ID_APPENDED;
    	String selectedValueUpdateVal = httpRequest.getParameter(selectedValueId);
    	if(selectedValueUpdateVal != null){
    		setSelectedValue(selectedValueUpdateVal);
    		setSubmittedValue(selectedValueUpdateVal);
    	}
    	
    	if(getValue() == null){
    		setSelected(false);
    	}else if(getSelectedValue() != null){
    		setSelected(getSelectedValue().equals(getValue()));
    	}
    	
    }
	
	public void processUpdates(FacesContext context) {
    	super.processUpdates(context);
    	
    	if (!isRendered() || !isValid()){
    		return;
    	}
    	
    	ValueBinding vb = getValueBinding("selectedValue");
		if(vb != null && !vb.isReadOnly(getFacesContext())){
			vb.setValue(getFacesContext(), getSelectedValue());
			setSelectedValue(null);
		}
    	
    }
	
	/**
	 * Specifies the name of the group to which this RadioButton control belongs, or specifies the value of the id property of a RadioButtonGroup control if this RadioButton is part of agroup defined by a RadioButtonGroup control.
	 * 
	 *@JSFProperty
	 *    required        = true
	 *    rtexprvalue     = false
	 *    desc            = "Specifies the name of the group to which this RadioButton control belongs, or specifies the value of the id property of a RadioButtonGroup control if this RadioButton is part of agroup defined by a RadioButtonGroup control."
	 */
	public abstract String getGroupName();
    
	/**
	 * This will represent the selectedValue chosen for the RadioButtonGroup. It should be used for databinding, so to figure out which radioButton within the same groupNamehas been chosen. Meaning it serves no purpose for display, so rationally you shouldhave databinded to ONE of the RadioButton with the same groupName.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = true
	 *    desc            = "This will represent the selectedValue chosen for the RadioButtonGroup. It should be used for databinding, so to figure out which radioButton within the same groupNamehas been chosen. Meaning it serves no purpose for display, so rationally you shouldhave databinded to ONE of the RadioButton with the same groupName."
	 */
	public abstract String getSelectedValue();
	
	public abstract void setSelectedValue(String selectedValue);
	
}
