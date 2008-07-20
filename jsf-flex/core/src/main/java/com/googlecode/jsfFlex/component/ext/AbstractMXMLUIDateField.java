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
import com.googlecode.jsfFlex.component.attributes._MXMLUIBorderColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBorderThicknessAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIChangeAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUICloseAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIControlSkinAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUICornerRadiusAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDataChangeAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDataProviderAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDateAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDisabledColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDropDownEventColorAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIEditableAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFillAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFocusAlphaAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFocusRoundedCornersAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFontFamilyAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFontGeneralAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFontSpecificAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIHeaderColorsAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIHeaderStyleName;
import com.googlecode.jsfFlex.component.attributes._MXMLUIHighlightAlphaAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIImeModeAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIImmediateAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUILabelFunctionAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUILeadingAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIOpenAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIPaddingHorizontalAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIRestrictAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIScrollAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUISelectedIndexAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUISelectedItemAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUITextAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUITextStyleAttributes;
import com.googlecode.jsfFlex.component.attributes.compBase._MXMLUIBaseAttributes;
import com.googlecode.jsfFlex.component.attributes.compBase._MXMLUIComboBaseAttributes;
import com.googlecode.jsfFlex.convert.attributes._MXMLUIFormatStringAttribute;

/**
 * @JSFComponent
 *   name     = "jf:mxmlDateField"
 *   class    = "com.googlecode.jsfFlex.component.ext.MXMLUIDateField"
 *   type     = "com.googlecode.jsfFlex.MXMLUIDateField"
 *   tagClass = "com.googlecode.jsfFlex.taglib.ext.MXMLUIDateFieldTag"
 *   family   = "javax.faces.MXMLInput"
 *   tagSuperclass = "org.apache.myfaces.shared_impl.taglib.UIComponentTagBase"
 *   defaultRendererType= "com.googlecode.jsfFlex.MXMLInput"
 *   
 * @JSFJspProperties
 * 		properties	=		
 *   						@JSFJspProperty
 * 							 name		= "maxYear"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The last year selectable in the control."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "parseFunction"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Function used to parse the date entered as text in the text field area of the DateField control and return a Date object to the control."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "dateChooserStyleName"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Name of the CSS Style declaration to use for the styles for the DateChooser control's drop-down list."
 *   						
 * @author Ji Hoon Kim
 */
public abstract class AbstractMXMLUIDateField 
						extends MXMLUIInputBase 
						implements _MXMLUIComboBaseAttributes, _MXMLUIBaseAttributes, _MXMLUITextAttribute, 
						_MXMLUIBorderColorAttribute, _MXMLUIBorderThicknessAttribute, _MXMLUIChangeAttribute, 
						_MXMLUICloseAttribute, _MXMLUIColorAttribute, _MXMLUIControlSkinAttributes, 
						_MXMLUIFormatStringAttribute, _MXMLUICornerRadiusAttribute, _MXMLUIDataChangeAttribute, 
						_MXMLUIDataProviderAttribute, _MXMLUIDateAttributes, _MXMLUIDisabledColorAttribute, 
						_MXMLUIDropDownEventColorAttributes, _MXMLUIEditableAttribute, _MXMLUIFillAttributes, 
						_MXMLUIFocusAlphaAttribute, _MXMLUIFocusRoundedCornersAttribute, _MXMLUIFontFamilyAttribute, 
						_MXMLUIFontGeneralAttributes, _MXMLUIFontSpecificAttributes, _MXMLUIHeaderColorsAttribute, 
						_MXMLUIHeaderStyleName, _MXMLUIHighlightAlphaAttribute, _MXMLUIImeModeAttribute, 
						_MXMLUIImmediateAttribute, _MXMLUILabelFunctionAttribute, _MXMLUILeadingAttribute, 
						_MXMLUIOpenAttribute, _MXMLUIPaddingHorizontalAttributes, _MXMLUIRestrictAttribute, 
						_MXMLUIScrollAttribute, _MXMLUISelectedIndexAttribute, _MXMLUISelectedItemAttribute, 
						_MXMLUITextStyleAttributes {

	private static final String MXML_COMPONENT_RENDERER = "com.googlecode.jsfFlex.MXMLDateField";
	
	public String getMXMLComponentRenderer() {
		return MXML_COMPONENT_RENDERER;
	}
	
}
