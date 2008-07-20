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

import com.googlecode.jsfFlex.component.MXMLUIButtonBase;
import com.googlecode.jsfFlex.component.attributes._MXMLUIArrowButtonWidthAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBorderColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIChangeAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUICloseAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUICloseAttributes;
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
import com.googlecode.jsfFlex.component.attributes._MXMLUIOpenAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIOpenDurationAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIOpenEasingFunctionAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIPaddingHorizontalAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIPaddingVerticalAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIRepeatAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUITextAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUITextEventColorAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUITextStyleAttributes;
import com.googlecode.jsfFlex.component.attributes.compBase._MXMLUIBaseAttributes;
import com.googlecode.jsfFlex.component.attributes.compBase._MXMLUIButtonAttributes;
import com.googlecode.jsfFlex.component.attributes.compBase._MXMLUIPopUpButtonAttributes;

/**
 * @JSFComponent
 *   name     = "jf:mxmlPopUpButton"
 *   class    = "com.googlecode.jsfFlex.component.ext.MXMLUIPopUpButton"
 *   type     = "com.googlecode.jsfFlex.MXMLUIPopUpButton"
 *   tagClass = "com.googlecode.jsfFlex.taglib.ext.MXMLUIPopUpButtonTag"
 *   family   = "javax.faces.MXMLInput"
 *   tagSuperclass = "org.apache.myfaces.shared_impl.taglib.UIComponentTagBase"
 *   defaultRendererType= "com.googlecode.jsfFlex.MXMLInput"
 *   
 * @author Ji Hoon Kim
 */
public abstract class AbstractMXMLUIPopUpButton 
							extends MXMLUIButtonBase 
							implements _MXMLUIPopUpButtonAttributes, _MXMLUITextEventColorAttributes, _MXMLUIBaseAttributes, 
							_MXMLUIIconAttribute, _MXMLUIArrowButtonWidthAttribute, _MXMLUIBorderColorAttribute, 
							_MXMLUIChangeAttribute, _MXMLUICloseAttribute, _MXMLUICloseAttributes, 
							_MXMLUIColorAttribute, _MXMLUIControlSkinAttributes, _MXMLUITextStyleAttributes, 
							_MXMLUICornerRadiusAttribute, _MXMLUIDataChangeAttribute, _MXMLUIDisabledColorAttribute, 
							_MXMLUIFillAttributes, _MXMLUIFocusAlphaAttribute, _MXMLUIFocusRoundedCornersAttribute, 
							_MXMLUIFontFamilyAttribute, _MXMLUIFontGeneralAttributes, _MXMLUIFontSpecificAttributes, 
							_MXMLUIGapAttributes, _MXMLUIHighlightAlphaAttribute, _MXMLUIImmediateAttribute, 
							_MXMLUILabelAttribute, _MXMLUILabelPlacementAttribute, _MXMLUILeadingAttribute, 
							_MXMLUIOpenAttribute, _MXMLUIOpenDurationAttribute, _MXMLUIOpenEasingFunctionAttribute, 
							_MXMLUIPaddingHorizontalAttributes, _MXMLUIPaddingVerticalAttributes, _MXMLUIRepeatAttributes,
							_MXMLUIButtonAttributes, _MXMLUITextAttribute {
	
	private static final String MXML_COMPONENT_RENDERER = "com.googlecode.jsfFlex.MXMLPopUpButton";
	
	public String getMXMLComponentRenderer(){
    	return MXML_COMPONENT_RENDERER;
    }
	
}
