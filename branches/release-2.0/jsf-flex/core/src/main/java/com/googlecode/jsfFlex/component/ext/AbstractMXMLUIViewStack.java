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
import com.googlecode.jsfFlex.attributes._MXMLUIDisabledColorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIFontFamilyAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIFontGeneralAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUIFontSpecificAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUIHorizontalScrollPositionAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIIconAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUILabelAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIPaddingHorizontalAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUIPaddingVerticalAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUIScrollAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIScrollAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUIShadowAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUITextStyleAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUIThumbSkinAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUITrackAttributes;
import com.googlecode.jsfFlex.component.MXMLUIViewStackBase;

/**
 * @JSFJspProperties
 * 		properties	=		
 *   						@JSFJspProperty
 * 							 name		= "historyManagementEnabled"
 *  						 returnType = "java.lang.String"
 *  						 longDesc	= "If true, enables history management within this ViewStack container."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "resizeToContent"
 *  						 returnType = "java.lang.String"
 *  						 longDesc	= "If true, the ViewStack container automatically resizes to the size of its current child."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "horizontalGap"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Horizontal gap."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "verticalGap"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Vertical gap."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "change"
 *  						 returnType = "java.lang.String"
 *  						 longDesc	= "Dispatched when the selectedIndex or selectedItem property changes as a result of user interaction."
 *   
 * Since ViewStack is written to maintain it's state, it will extend directly from MXMLUIInputBase
 * 
 * @author Ji Hoon Kim
 */
@JSFComponent(
        name                =   "jf:mxmlViewStack",
        clazz               =   "com.googlecode.jsfFlex.component.ext.MXMLUIViewStack",
        type                =   "com.googlecode.jsfFlex.MXMLUIViewStack",
        tagClass            =   "com.googlecode.jsfFlex.taglib.ext.MXMLUIViewStackTag",
        family              =   "javax.faces.MXMLInput",
        defaultRendererType =   "com.googlecode.jsfFlex.MXMLViewStack",
        tagSuperclass       =   "com.googlecode.jsfFlex.taglib.MXMLUIInputTagBase"
)
public abstract class AbstractMXMLUIViewStack 
						extends MXMLUIViewStackBase
						implements _MXMLUIContainerAttributes, _MXMLUIBaseAttributes, _MXMLUIThumbSkinAttributes, 
						_MXMLUIShadowAttributes, _MXMLUIBackgroundAlphaAttribute, _MXMLUIBackgroundAttributes, 
						_MXMLUIBackgroundColorAttribute, _MXMLUIBackgroundDisabledColorAttribute, 
						_MXMLUIBarColorAttribute, _MXMLUIBorderAttributes, _MXMLUIBorderColorAttribute, 
						_MXMLUIBorderThicknessAttribute, _MXMLUIColorAttribute, _MXMLUIIconAttribute, 
						_MXMLUITrackAttributes, _MXMLUICornerRadiusAttribute, _MXMLUIDataChangeAttribute, 
						_MXMLUIDisabledColorAttribute, _MXMLUIFontFamilyAttribute, _MXMLUIFontGeneralAttributes, 
						_MXMLUIFontSpecificAttributes, _MXMLUIHorizontalScrollPositionAttribute,  
						_MXMLUITextStyleAttributes, _MXMLUILabelAttribute, _MXMLUIPaddingHorizontalAttributes, 
						_MXMLUIPaddingVerticalAttributes, _MXMLUIScrollAttribute, _MXMLUIScrollAttributes, 
						_MXMLUIScrollBarAttributes {
	
}
