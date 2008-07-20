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

import com.googlecode.jsfFlex.component.MXMLUITextInputBase;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBackgroundAlphaAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBackgroundAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBackgroundColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBackgroundDisabledColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBarColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBorderAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBorderColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBorderThicknessAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIChangeAttribute;
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
import com.googlecode.jsfFlex.component.attributes._MXMLUIHtmlTextAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIIconAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIImmediateAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUILabelAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUILayoutAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIModalAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIPaddingHorizontalAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIPaddingVerticalAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIScrollAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIScrollAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIScrollBarAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIShadowAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUITextAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUITextAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUITextBindingAttribute;
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
 *   name     = "jf:mxmlRichTextEditor"
 *   class    = "com.googlecode.jsfFlex.component.ext.MXMLUIRichTextEditor"
 *   type     = "com.googlecode.jsfFlex.MXMLUIRichTextEditor"
 *   tagClass = "com.googlecode.jsfFlex.taglib.ext.MXMLUIRichTextEditorTag"
 *   family   = "javax.faces.MXMLInput"
 *   tagSuperclass = "org.apache.myfaces.shared_impl.taglib.UIComponentTagBase"
 *   defaultRendererType= "com.googlecode.jsfFlex.MXMLInput"
 *   
 * @JSFJspProperties
 * 		properties	=		
 *   						@JSFJspProperty
 * 							 name		= "defaultLinkProtocol"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The default protocol string to use at the start of link text."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "showControlBar"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Specifies whether to display the control bar that contains the text formatting controls."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "showToolTips"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Specifies whether to display tooltips for the text formatting controls."
 *   						
 * @author Ji Hoon Kim
 */
public abstract class AbstractMXMLUIRichTextEditor 
						extends MXMLUITextInputBase 
						implements _MXMLUIPanelAttributes, _MXMLUIContainerAttributes, _MXMLUIBaseAttributes, 
						_MXMLUITextAttribute, _MXMLUIBackgroundAlphaAttribute, _MXMLUIBackgroundAttributes, 
						_MXMLUIBackgroundColorAttribute, _MXMLUIBackgroundDisabledColorAttribute, _MXMLUITextAttributes,
						_MXMLUIBarColorAttribute, _MXMLUIBorderAttributes, _MXMLUIBorderColorAttribute, 
						_MXMLUIBorderThicknessAttribute, _MXMLUIChangeAttribute, _MXMLUICloseAttribute, 
						_MXMLUIColorAttribute, _MXMLUIVerticalAlignAttribute, _MXMLUICornerRadiusAttribute, 
						_MXMLUIDataChangeAttribute, _MXMLUIDisabledColorAttribute, _MXMLUIFontFamilyAttribute, 
						_MXMLUIFontGeneralAttributes, _MXMLUIFontSpecificAttributes, _MXMLUIGapAttributes, 
						_MXMLUIHeaderColorsAttribute, _MXMLUIHighlightAlphaAttribute, _MXMLUIHorizontalAlignAttribute,   
						_MXMLUIHorizontalScrollPositionAttribute, _MXMLUIImmediateAttribute, _MXMLUIHeaderHeightAttribute,
						_MXMLUILabelAttribute, _MXMLUILayoutAttribute, _MXMLUIModalAttributes, _MXMLUIPaddingHorizontalAttributes, 
						_MXMLUIPaddingVerticalAttributes, _MXMLUIScrollAttribute, _MXMLUIScrollAttributes, 
						_MXMLUIScrollBarAttributes, _MXMLUIShadowAttributes, _MXMLUIIconAttribute,
						_MXMLUITextStyleAttributes, _MXMLUIThumbSkinAttributes, _MXMLUITrackAttributes, 
						_MXMLUITitleAttribute, _MXMLUIHtmlTextAttribute, _MXMLUITextBindingAttribute {
	
	private static final String MXML_COMPONENT_RENDERER = "com.googlecode.jsfFlex.MXMLRichTextEditor";
	
    public String getMXMLComponentRenderer() {
		return MXML_COMPONENT_RENDERER;
	}
	
}
