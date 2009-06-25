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

import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFComponent;

import com.googlecode.jsfFlex.attributes._MXMLUIBackgroundAlphaAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIBackgroundAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUIBackgroundColorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIBackgroundDisabledColorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIBarColorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIBaseAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUIBorderAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUIBorderColorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIBorderThicknessAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIColorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUICornerRadiusAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIDataChangeAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIDataProviderAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIDirectionAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIDisabledColorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIFontFamilyAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIFontGeneralAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUIFontSpecificAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUIGapAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUIHorizontalAlignAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIHorizontalScrollPositionAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIIconAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIIconFieldAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIItemClickAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUILabelAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUILabelFieldAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIPaddingHorizontalAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUIPaddingVerticalAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUIScrollAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIScrollAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUISelectedButtonTextStyleNameAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUISelectedIndexAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIShadowAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUITextStyleAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUIThumbSkinAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUIToggleOnClickAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIToolTipFieldAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUITrackAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUIVerticalAlignAttribute;
import com.googlecode.jsfFlex.component.MXMLUISimpleBase;

/**
 * @JSFJspProperties
 * 		properties	=		
 *   						@JSFJspProperty
 * 							 name		= "firstTabStyleName"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Name of CSS style declaration that specifies styles for the first tab."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "lastTabStyleName"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Name of CSS style declaration that specifies styles for the last tab."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "selectedTabTextStyleName"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Name of CSS style declaration that specifies styles for the text of the selected tab."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "tabHeight"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Height of each tab, in pixels."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "tabStyleName"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Name of CSS style declaration that specifies styles for the tabs."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "tabWidth"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Width of each tab, in pixels."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "buttonHeight"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Height of each button, in pixels."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "buttonStyleName"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Name of CSS style declaration that specifies styles for the buttons."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "buttonWidth"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Width of each button, in pixels."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "firstButtonStyleName"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Name of CSS style declaration that specifies styles for the first button."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "lastButtonStyleName"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Name of CSS style declaration that specifies styles for the last button."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "focusAlpha"
 *  						 returnType = "java.lang.String"
 *  						 longDesc	= "Specifies the alpha transparency value of the focus skin."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "focusRoundedCorners"
 *  						 returnType = "java.lang.String"
 *  						 longDesc	= "Specifies which corners of the focus rectangle should be rounded."
 *    
 * @author Ji Hoon Kim
 */
@JSFComponent(
        name                =   "jf:mxmlTabBar",
        clazz               =   "com.googlecode.jsfFlex.component.ext.MXMLUITabBar",
        type                =   "com.googlecode.jsfFlex.MXMLUITabBar",
        tagClass            =   "com.googlecode.jsfFlex.taglib.ext.MXMLUITabBarTag",
        family              =   "javax.faces.MXMLSimple",
        defaultRendererType =   "com.googlecode.jsfFlex.MXMLTabBar"
)
public abstract class AbstractMXMLUITabBar 
						extends MXMLUISimpleBase
						implements _MXMLUISelectedButtonTextStyleNameAttribute, _MXMLUIToggleOnClickAttribute, 
						_MXMLUIToolTipFieldAttribute, _MXMLUIIconAttribute, _MXMLUIContainerAttributes, 
						_MXMLUIBaseAttributes, _MXMLUIBackgroundAlphaAttribute, _MXMLUIBackgroundAttributes, 
						_MXMLUIBackgroundColorAttribute, _MXMLUIBackgroundDisabledColorAttribute, 
						_MXMLUIBarColorAttribute, _MXMLUIBorderAttributes, _MXMLUIBorderColorAttribute, 
						_MXMLUIBorderThicknessAttribute, _MXMLUIColorAttribute, _MXMLUICornerRadiusAttribute, 
						_MXMLUIDataChangeAttribute, _MXMLUIDataProviderAttribute, _MXMLUIDirectionAttribute, 
						_MXMLUIFontFamilyAttribute, _MXMLUIFontGeneralAttributes, _MXMLUIFontSpecificAttributes, 
						_MXMLUIGapAttributes, _MXMLUIHorizontalAlignAttribute, _MXMLUIHorizontalScrollPositionAttribute,  
						_MXMLUIIconFieldAttribute, _MXMLUIItemClickAttribute, _MXMLUILabelAttribute, _MXMLUILabelFieldAttribute,  
						_MXMLUIPaddingHorizontalAttributes, _MXMLUIPaddingVerticalAttributes, _MXMLUIScrollAttribute, 
						_MXMLUIScrollAttributes, _MXMLUIScrollBarAttributes, _MXMLUISelectedIndexAttribute, 
						_MXMLUIShadowAttributes, _MXMLUITextStyleAttributes, _MXMLUIThumbSkinAttributes, 
						_MXMLUITrackAttributes, _MXMLUIVerticalAlignAttribute, _MXMLUIDisabledColorAttribute {
	
}
