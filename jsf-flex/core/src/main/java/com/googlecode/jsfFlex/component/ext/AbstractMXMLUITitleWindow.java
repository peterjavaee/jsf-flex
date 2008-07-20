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

import com.googlecode.jsfFlex.component.MXMLUISimpleBase;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBackgroundAlphaAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBackgroundAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBackgroundColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBackgroundDisabledColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBarColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBorderAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBorderColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBorderThicknessAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUICloseAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUICornerRadiusAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDataChangeAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDisabledColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFontFamilyAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFontGeneralAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFontSpecificAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIGapAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIHeaderColorsAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIHeaderHeightAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIHighlightAlphaAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIHorizontalAlignAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIHorizontalScrollPositionAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIIconAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUILabelAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUILayoutAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIModalAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIPaddingHorizontalAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIPaddingVerticalAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIScrollAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIScrollAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIScrollBarAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIShadowAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUITextStyleAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIThumbSkinAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUITitleAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUITrackAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIVerticalAlignAttribute;
import com.googlecode.jsfFlex.component.attributes.compBase._MXMLUIBaseAttributes;
import com.googlecode.jsfFlex.component.attributes.compBase._MXMLUIContainerAttributes;
import com.googlecode.jsfFlex.component.attributes.compBase._MXMLUIPanelAttributes;

/**
 * @JSFComponent
 *   name     = "jf:mxmlTitleWindow"
 *   class    = "com.googlecode.jsfFlex.component.ext.MXMLUITitleWindow"
 *   type     = "com.googlecode.jsfFlex.MXMLUITitleWindow"
 *   tagClass = "com.googlecode.jsfFlex.taglib.ext.MXMLUITitleWindowTag"
 *   family   = "javax.faces.MXMLSimpleBase"
 *   tagSuperclass = "org.apache.myfaces.shared_impl.taglib.UIComponentTagBase"
 *   defaultRendererType= "com.googlecode.jsfFlex.MXMLSimpleBase"
 *   
 * @JSFJspProperty
 *   name		= "showCloseButton"
 *   returnType = "java.lang.String"
 *   longDesc	= "Whether to display a Close button in the TitleWindow container."
 * 
 * @author Ji Hoon Kim
 */
public abstract class AbstractMXMLUITitleWindow 
						extends MXMLUISimpleBase 
						implements _MXMLUIPanelAttributes, _MXMLUIContainerAttributes, _MXMLUIBaseAttributes, 
						_MXMLUIBackgroundAlphaAttribute, _MXMLUIBackgroundAttributes, _MXMLUIBackgroundColorAttribute, 
						_MXMLUIBackgroundDisabledColorAttribute, _MXMLUIBarColorAttribute, _MXMLUIBorderAttributes, 
						_MXMLUIBorderColorAttribute, _MXMLUIBorderThicknessAttribute, _MXMLUICloseAttribute, 
						_MXMLUIColorAttribute, _MXMLUICornerRadiusAttribute, _MXMLUIDataChangeAttribute, 
						_MXMLUIDisabledColorAttribute, _MXMLUIFontFamilyAttribute, _MXMLUIFontGeneralAttributes, 
						_MXMLUIFontSpecificAttributes, _MXMLUIGapAttributes, _MXMLUIHeaderColorsAttribute, 
						_MXMLUIHighlightAlphaAttribute, _MXMLUIHorizontalAlignAttribute, _MXMLUIHorizontalScrollPositionAttribute,  
						_MXMLUILabelAttribute, _MXMLUILayoutAttribute, _MXMLUIModalAttributes, _MXMLUIPaddingHorizontalAttributes,  
						_MXMLUIPaddingVerticalAttributes, _MXMLUIScrollAttribute, _MXMLUIScrollAttributes, 
						_MXMLUIScrollBarAttributes, _MXMLUIShadowAttributes, _MXMLUITextStyleAttributes, 
						_MXMLUIThumbSkinAttributes, _MXMLUITrackAttributes, _MXMLUIVerticalAlignAttribute, 
						_MXMLUITitleAttribute, _MXMLUIHeaderHeightAttribute, _MXMLUIIconAttribute {

	private static final String MXML_COMPONENT_RENDERER = "com.googlecode.jsfFlex.MXMLTitleWindow";
	
	public String getMXMLComponentRenderer() {
		return MXML_COMPONENT_RENDERER;
	}
	
}
