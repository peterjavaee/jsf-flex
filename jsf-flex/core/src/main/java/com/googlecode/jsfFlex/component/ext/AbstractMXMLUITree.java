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

import com.googlecode.jsfFlex.component.MXMLUISelectedIndexBase;
import com.googlecode.jsfFlex.component.attributes._MXMLUIAllowMultipleSelectionAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBackgroundAlphaAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBackgroundAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBackgroundColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBorderAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBorderColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBorderThicknessAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIChangeAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIColumnCountAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUICornerRadiusAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDataChangeAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDataProviderAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDataViewAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDisabledColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDragAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDropDownEventColorAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIEditableAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFocusAlphaAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFocusRoundedCornersAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFontFamilyAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFontGeneralAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIHorizontalScrollPositionAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIIconFieldAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIImeModeAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIImmediateAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIItemAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIItemClickAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIItemEventAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIItemInfoAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUILabelFieldAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUILabelFunctionAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUILeadingAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIOpenDurationAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIOpenEasingFunctionAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIPaddingHorizontalAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIPaddingVerticalAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIRepeatAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIScrollAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIScrollAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIScrollBarAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUISelectableAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUISelectedIndexAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUISelectedItemAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUISelectionAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIShadowAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUITextAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUITextEventColorAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUITextStyleAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIThumbSkinAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUITrackAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIVerticalAlignAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIWordWrapAttribute;
import com.googlecode.jsfFlex.component.attributes.compBase._MXMLUIBaseAttributes;
import com.googlecode.jsfFlex.component.attributes.compBase._MXMLUIListAttributes;
import com.googlecode.jsfFlex.component.attributes.compBase._MXMLUIListBaseAttributes;
import com.googlecode.jsfFlex.component.attributes.compBase._MXMLUIScrollControlAttributes;

/**
 * @JSFComponent
 *   name     = "jf:mxmlTree"
 *   class    = "com.googlecode.jsfFlex.component.ext.MXMLUITree"
 *   type     = "com.googlecode.jsfFlex.MXMLUITree"
 *   tagClass = "com.googlecode.jsfFlex.taglib.ext.MXMLUITreeTag"
 *   family   = "javax.faces.MXMLInput"
 *   tagSuperclass = "org.apache.myfaces.shared_impl.taglib.UIComponentTagBase"
 *   defaultRendererType= "com.googlecode.jsfFlex.MXMLInput"
 *   
 * @JSFJspProperties
 * 		properties	=		
 *   						@JSFJspProperty
 * 							 name		= "firstVisibleItem"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The item that is currently displayed in the top row of the tree."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "itemIcons"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "An object that specifies the icons for the items."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "openItems"
 *   						 returnType	= "java.lang.String" 
 *   						 longDesc	= "The items that have been opened or set opened."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "defaultLeafIcon"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Specifies the default icon for a leaf item."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "depthColors"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Array of colors used in the Tree control, in descending order."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "disclosureClosedIcon"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Specifies the icon that is displayed next to a parent item that is closed so that its children are not displayed (the subtree is collapsed)."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "disclosureOpenIcon"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Specifies the icon that is displayed next to a parent item that is open so that its children are displayed."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "folderClosedIcon"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Specifies the folder closed icon for a branch item of the tree."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "folderOpenIcon"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Specifies the folder open icon for a branch item of the tree."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "indentation"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Indentation for each tree level, in pixels."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "itemClose"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Dispatched when a branch is closed or collapsed."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "itemOpen"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Dispatched when a branch is opened or expanded."
 *   						,   
 *   						
 *   						@JSFJspProperty
 * 							 name		= "itemOpening"
 *   						 returnType	= "java.lang.String" 
 *   						 longDesc	= "Dispatched when a branch open or close is initiated."
 *   						
 * @author Ji Hoon Kim
 */
public abstract class AbstractMXMLUITree 
						extends MXMLUISelectedIndexBase
						implements _MXMLUIListAttributes, _MXMLUIListBaseAttributes, _MXMLUIScrollControlAttributes, 
						_MXMLUIBaseAttributes, _MXMLUITextAttribute, _MXMLUIAllowMultipleSelectionAttribute, 
						_MXMLUIBackgroundAlphaAttribute, _MXMLUIBackgroundAttributes, _MXMLUIBackgroundColorAttribute, 
						_MXMLUIBorderAttributes, _MXMLUIBorderColorAttribute, _MXMLUIBorderThicknessAttribute, 
						_MXMLUIChangeAttribute, _MXMLUIColorAttribute, _MXMLUIWordWrapAttribute, 
						_MXMLUICornerRadiusAttribute, _MXMLUIDataChangeAttribute, _MXMLUIDataProviderAttribute, 
						_MXMLUIDataViewAttributes, _MXMLUIDisabledColorAttribute, _MXMLUIDragAttributes, 
						_MXMLUIDropDownEventColorAttributes, _MXMLUIEditableAttribute, _MXMLUIFocusAlphaAttribute, 
						_MXMLUIFocusRoundedCornersAttribute, _MXMLUIFontFamilyAttribute, _MXMLUIFontGeneralAttributes,  
						_MXMLUIHorizontalScrollPositionAttribute, _MXMLUIIconFieldAttribute, _MXMLUIImeModeAttribute, 
						_MXMLUIImmediateAttribute, _MXMLUIItemAttributes, _MXMLUIItemClickAttribute, 
						_MXMLUIItemEventAttributes, _MXMLUIItemInfoAttributes, _MXMLUILabelFieldAttribute, 
						_MXMLUILabelFunctionAttribute, _MXMLUILeadingAttribute, _MXMLUIOpenDurationAttribute, 
						_MXMLUIOpenEasingFunctionAttribute, _MXMLUIPaddingHorizontalAttributes, _MXMLUIPaddingVerticalAttributes,  
						_MXMLUIRepeatAttributes, _MXMLUIScrollAttribute, _MXMLUIScrollAttributes, _MXMLUIScrollBarAttributes,  
						_MXMLUISelectableAttribute, _MXMLUISelectedItemAttribute, _MXMLUIColumnCountAttribute,
						_MXMLUISelectionAttributes, _MXMLUIShadowAttributes, _MXMLUITextEventColorAttributes, 
						_MXMLUITextStyleAttributes, _MXMLUIThumbSkinAttributes, _MXMLUITrackAttributes, 
						_MXMLUIVerticalAlignAttribute, _MXMLUISelectedIndexAttribute {
	
	private static final String MXML_COMPONENT_RENDERER = "com.googlecode.jsfFlex.MXMLTree";
	
	public String getMXMLComponentRenderer() {
		return MXML_COMPONENT_RENDERER;
	}
	
}
