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
import com.googlecode.jsfFlex.component.attributes._MXMLUIBackgroundColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBorderColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUICornerRadiusAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDataProviderAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDataViewAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDisabledColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDropDownEventColorAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFillAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFocusAlphaAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFocusRoundedCornersAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFontFamilyAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFontGeneralAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFontSpecificAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIHighlightAlphaAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIIconFieldAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIItemClickAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIItemEventAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUILabelFieldAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUILabelFunctionAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUILeadingAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUISelectedIndexAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUITextStyleAttributes;
import com.googlecode.jsfFlex.component.attributes.compBase._MXMLUIBaseAttributes;

/**
 * @JSFComponent
 *   name     = "jf:mxmlMenuBar"
 *   class    = "com.googlecode.jsfFlex.component.ext.MXMLUIMenuBar"
 *   type     = "com.googlecode.jsfFlex.MXMLUIMenuBar"
 *   tagClass = "com.googlecode.jsfFlex.taglib.ext.MXMLUIMenuBarTag"
 *   family   = "javax.faces.MXMLSimpleBase"
 *   tagSuperclass = "org.apache.myfaces.shared_impl.taglib.UIComponentTagBase"
 *   defaultRendererType= "com.googlecode.jsfFlex.MXMLSimpleBase"
 *   
 * @JSFJspProperties
 * 		properties	=		
 *   						@JSFJspProperty
 * 							 name		= "menubarItems"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "An Array of MenuBarItem objects that populate this MenuBar."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "menus"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "An Array containing the Menu objects for this MenuBar."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "backgroundSkin"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The background skin of the MenuBar control."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "itemDownSkin"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The skin when a MenuBar item is selected."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "itemOverSkin"
 *   						 returnType	= "java.lang.String" 
 *   						 longDesc	= "The skin when focus is over a MenuBar item either."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "itemUpSkin"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The skin when a MenuBar item is not selected."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "menuHide"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Dispatched when a menu or submenu closes."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "menuShow"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Dispatched when a menu or submenu opens, or the mouse pointer rolls over an item with no drop-down menu."
 *   						
 * @author Ji Hoon Kim
 */
public abstract class AbstractMXMLUIMenuBar 
						extends MXMLUISimpleBase 
						implements _MXMLUIBaseAttributes, _MXMLUIBackgroundAlphaAttribute, 
						_MXMLUIBackgroundColorAttribute, _MXMLUIBorderColorAttribute, _MXMLUIColorAttribute, 
						_MXMLUICornerRadiusAttribute, _MXMLUIDataProviderAttribute, _MXMLUIDataViewAttributes, 
						_MXMLUIDisabledColorAttribute, _MXMLUIDropDownEventColorAttributes, _MXMLUIFillAttributes, 
						_MXMLUIFocusAlphaAttribute, _MXMLUIFocusRoundedCornersAttribute, _MXMLUIFontFamilyAttribute, 
						_MXMLUIFontGeneralAttributes, _MXMLUIFontSpecificAttributes, _MXMLUIHighlightAlphaAttribute, 
						_MXMLUIIconFieldAttribute, _MXMLUIItemClickAttribute, _MXMLUIItemEventAttributes, 
						_MXMLUILabelFieldAttribute, _MXMLUILabelFunctionAttribute, _MXMLUILeadingAttribute, 
						_MXMLUISelectedIndexAttribute, _MXMLUITextStyleAttributes {

	private static final String MXML_COMPONENT_RENDERER = "com.googlecode.jsfFlex.MXMLMenuBar";
	
	public String getMXMLComponentRenderer() {
		return MXML_COMPONENT_RENDERER;
	}
	
}
