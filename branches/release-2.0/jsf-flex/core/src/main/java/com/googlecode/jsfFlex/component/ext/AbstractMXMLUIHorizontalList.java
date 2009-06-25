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

import com.googlecode.jsfFlex.attributes._MXMLUIAllowMultipleSelectionAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIBackgroundAlphaAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIBackgroundAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUIBackgroundColorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIBaseAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUIBorderAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUIBorderColorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIBorderThicknessAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIChangeAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIColorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIColumnCountAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUICornerRadiusAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIDataChangeAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIDataProviderAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIDisabledColorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIDragAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUIDropDownEventColorAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUIFocusAlphaAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIFocusRoundedCornersAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIFontFamilyAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIFontGeneralAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUIHorizontalScrollPositionAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIIconFieldAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIItemClickAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIItemEventAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUIItemInfoAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUILabelFieldAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUILabelFunctionAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUILeadingAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIPaddingHorizontalAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUIPaddingVerticalAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUIRepeatAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUIRowCount;
import com.googlecode.jsfFlex.attributes._MXMLUIScrollAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIScrollAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUISelectableAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUISelectedItemAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUISelectionAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUIShadowAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUITextEventColorAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUITextStyleAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUIThumbSkinAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUITrackAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUIVerticalAlignAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIWordWrapAttribute;

/**
 * @author Ji Hoon Kim
 */
@JSFComponent(
        name                =   "jf:mxmlHorizontalList",
        clazz               =   "com.googlecode.jsfFlex.component.ext.MXMLUIHorizontalList",
        type                =   "com.googlecode.jsfFlex.MXMLUIHorizontalList",
        tagClass            =   "com.googlecode.jsfFlex.taglib.ext.MXMLUIHorizontalListTag",
        family              =   "javax.faces.MXMLInput",
        defaultRendererType =   "com.googlecode.jsfFlex.MXMLHorizontalList",
        tagSuperclass       =   "com.googlecode.jsfFlex.taglib.MXMLUIInputTagBase"
)
public abstract class AbstractMXMLUIHorizontalList 
						extends com.googlecode.jsfFlex.component.MXMLUISelectedIndexBase
						implements _MXMLUIListBaseAttributes, _MXMLUIScrollControlAttributes, _MXMLUIBaseAttributes, 
						_MXMLUIAllowMultipleSelectionAttribute, _MXMLUITrackAttributes, _MXMLUIBackgroundAlphaAttribute, 
						_MXMLUIBackgroundAttributes, _MXMLUIBackgroundColorAttribute, _MXMLUIBorderAttributes, 
						_MXMLUIBorderColorAttribute, _MXMLUIBorderThicknessAttribute, _MXMLUIChangeAttribute, 
						_MXMLUIColorAttribute, _MXMLUIWordWrapAttribute, _MXMLUICornerRadiusAttribute, 
						_MXMLUIDataChangeAttribute, _MXMLUIDataProviderAttribute, _MXMLUIDisabledColorAttribute, 
						_MXMLUIDragAttributes, _MXMLUIDropDownEventColorAttributes, _MXMLUIFocusAlphaAttribute, 
						_MXMLUIFocusRoundedCornersAttribute, _MXMLUIFontFamilyAttribute, _MXMLUIFontGeneralAttributes,  
						_MXMLUIHorizontalScrollPositionAttribute, _MXMLUIIconFieldAttribute, _MXMLUIVerticalAlignAttribute,  
						_MXMLUIItemClickAttribute, _MXMLUIItemEventAttributes, _MXMLUIItemInfoAttributes, 
						_MXMLUILabelFieldAttribute, _MXMLUILabelFunctionAttribute, _MXMLUILeadingAttribute, 
						_MXMLUIPaddingHorizontalAttributes, _MXMLUIPaddingVerticalAttributes, _MXMLUIRepeatAttributes,  
						_MXMLUIScrollAttribute, _MXMLUIScrollAttributes, _MXMLUIScrollBarAttributes, _MXMLUISelectableAttribute,  
						_MXMLUISelectedItemAttribute, _MXMLUISelectionAttributes, _MXMLUIColumnCountAttribute,
						_MXMLUIShadowAttributes, _MXMLUITextEventColorAttributes, _MXMLUITextStyleAttributes, 
						_MXMLUIThumbSkinAttributes, _MXMLUIRowCount  {
	
}
