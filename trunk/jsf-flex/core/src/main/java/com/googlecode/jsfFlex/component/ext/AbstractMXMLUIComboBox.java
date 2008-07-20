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

import com.googlecode.jsfFlex.component.MXMLUIInputBase;
import com.googlecode.jsfFlex.component.attributes._MXMLUIArrowButtonWidthAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBorderColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBorderThicknessAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIChangeAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUICloseAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUICloseAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIControlSkinAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUICornerRadiusAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDataChangeAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDataProviderAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDisabledColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDropDownEventColorAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIEditableAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIEnterAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFillAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFocusRoundedCornersAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFontFamilyAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFontGeneralAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFontSpecificAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIHighlightAlphaAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIImeModeAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIImmediateAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIItemEventAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIItemInfoAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUILabelFieldAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUILabelFunctionAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUILeadingAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIOpenAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIOpenDurationAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIOpenEasingFunctionAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIPaddingHorizontalAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIRestrictAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIScrollAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUISelectedIndexAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUISelectedItemAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUISelectionAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUITextAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUITextEventColorAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUITextStyleAttributes;
import com.googlecode.jsfFlex.component.attributes.compBase._MXMLUIBaseAttributes;
import com.googlecode.jsfFlex.component.attributes.compBase._MXMLUIComboBaseAttributes;

/**
 * @JSFComponent
 *   name     = "jf:mxmlComboBox"
 *   class    = "com.googlecode.jsfFlex.component.ext.MXMLUIComboBox"
 *   type     = "com.googlecode.jsfFlex.MXMLUIComboBox"
 *   tagClass = "com.googlecode.jsfFlex.taglib.ext.MXMLUIComboBoxTag"
 *   family   = "javax.faces.MXMLInput"
 *   tagSuperclass = "org.apache.myfaces.shared_impl.taglib.UIComponentTagBase"
 *   defaultRendererType= "com.googlecode.jsfFlex.MXMLInput"
 *   
 * @JSFJspProperties
 * 		properties	=		
 *   						@JSFJspProperty
 * 							 name		= "dropdownFactory"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The IFactory that creates a ListBase-derived instance to use as the drop-down."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "dropdownWidth"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Width of the drop-down list, in pixels."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "prompt"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The prompt for the ComboBox control."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "dropDownBorderColor"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The color of the border of the ComboBox."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "dropDownStyleName"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The name of a CSSStyleDeclaration to be used by the drop-down list."
 *   						
 * @author Ji Hoon Kim
 */
public abstract class AbstractMXMLUIComboBox 
						extends MXMLUIInputBase 
						implements _MXMLUIComboBaseAttributes, _MXMLUIBaseAttributes, _MXMLUITextAttribute, 
						_MXMLUIArrowButtonWidthAttribute, _MXMLUIBorderColorAttribute, _MXMLUIBorderThicknessAttribute, 
						_MXMLUIChangeAttribute, _MXMLUICloseAttribute, _MXMLUICloseAttributes, _MXMLUIColorAttribute, 
						_MXMLUIControlSkinAttributes, _MXMLUITextStyleAttributes, _MXMLUICornerRadiusAttribute, 
						_MXMLUIDataChangeAttribute, _MXMLUIDataProviderAttribute, _MXMLUIDisabledColorAttribute, 
						_MXMLUIDropDownEventColorAttributes, _MXMLUIEditableAttribute, _MXMLUIEnterAttribute, 
						_MXMLUIFillAttributes, _MXMLUIFocusRoundedCornersAttribute, _MXMLUIFontFamilyAttribute, 
						_MXMLUIFontGeneralAttributes, _MXMLUIFontSpecificAttributes, _MXMLUIHighlightAlphaAttribute, 
						_MXMLUIImeModeAttribute, _MXMLUIImmediateAttribute, _MXMLUIItemEventAttributes, 
						_MXMLUIItemInfoAttributes, _MXMLUILabelFieldAttribute, _MXMLUILabelFunctionAttribute, 
						_MXMLUILeadingAttribute, _MXMLUIOpenAttribute, _MXMLUIOpenDurationAttribute, 
						_MXMLUIOpenEasingFunctionAttribute, _MXMLUIPaddingHorizontalAttributes, _MXMLUIRestrictAttribute,  
						_MXMLUIScrollAttribute, _MXMLUISelectedIndexAttribute, _MXMLUISelectedItemAttribute, 
						_MXMLUISelectionAttributes, _MXMLUITextEventColorAttributes {

	private static final String MXML_COMPONENT_RENDERER = "com.googlecode.jsfFlex.MXMLComboBox";
	
	public String getMXMLComponentRenderer() {
		return MXML_COMPONENT_RENDERER;
	}
	
}
