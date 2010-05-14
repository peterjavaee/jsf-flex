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

import com.googlecode.jsfFlex.attributes.IFlexUIBackgroundAlphaAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBackgroundColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBackgroundSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBaseAttributes;
import com.googlecode.jsfFlex.attributes.IFlexUIBorderColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUICornerRadiusAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDataDescriptorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDataProviderAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDisabledColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFillAlphasAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFillColorsAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFocusAlphaAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFocusRoundedCornersAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontAntiAliasTypeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontFamilyAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontGridFitTypeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontSharpnessAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontSizeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontStyleAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontThicknessAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontWeightAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIHighlightAlphasAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIIconFieldAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIItemClickAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIItemDownSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIItemOverSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIItemRollOutAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIItemRollOverAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIItemUpSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUILabelFieldAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUILabelFunctionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUILeadingAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIMenuBarItemRendererAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIMenuHideAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIMenuShowAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIMenuStyleNameAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIMenubarItemsAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIMenusAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIRollOverColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISelectedIndexAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISelectionColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIShowRootAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextAlignAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextDecorationAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextIndentAttribute;
import com.googlecode.jsfFlex.component.AbstractFlexUISimpleBase;

/**
 * @author Ji Hoon Kim
 */
@JSFComponent(
        name                =   "jf:flexMenuBar",
        clazz               =   "com.googlecode.jsfFlex.component.ext.FlexUIMenuBar",
        type                =   "com.googlecode.jsfFlex.FlexUIMenuBar",
        tagClass            =   "com.googlecode.jsfFlex.taglib.component.ext.FlexUIMenuBarTag",
        family              =   "javax.faces.FlexSimpleBase",
        defaultRendererType =   "com.googlecode.jsfFlex.FlexMenuBar"
)
public abstract class AbstractFlexUIMenuBar 
						extends AbstractFlexUISimpleBase 
						implements IFlexUIBaseAttributes, IFlexUIDataDescriptorAttribute, IFlexUIDataProviderAttribute, 
                        IFlexUIIconFieldAttribute, IFlexUILabelFieldAttribute, IFlexUILabelFunctionAttribute, IFlexUIMenuBarItemRendererAttribute, 
                        IFlexUIMenubarItemsAttribute, IFlexUIMenusAttribute, IFlexUISelectedIndexAttribute, 
                        IFlexUIShowRootAttribute, IFlexUIBackgroundAlphaAttribute, IFlexUIBackgroundColorAttribute, 
                        IFlexUIBackgroundSkinAttribute, IFlexUIBorderColorAttribute, IFlexUIColorAttribute, 
                        IFlexUICornerRadiusAttribute, IFlexUIDisabledColorAttribute, IFlexUIFillAlphasAttribute, 
                        IFlexUIFillColorsAttribute, IFlexUIFocusAlphaAttribute, IFlexUIFocusRoundedCornersAttribute, 
                        IFlexUIFontAntiAliasTypeAttribute, IFlexUIFontFamilyAttribute, IFlexUIFontGridFitTypeAttribute, 
                        IFlexUIFontSharpnessAttribute, IFlexUIFontSizeAttribute, IFlexUIFontStyleAttribute, 
                        IFlexUIFontThicknessAttribute, IFlexUIFontWeightAttribute, IFlexUIHighlightAlphasAttribute, 
                        IFlexUIItemDownSkinAttribute, IFlexUIItemOverSkinAttribute, IFlexUIItemUpSkinAttribute, 
                        IFlexUILeadingAttribute, IFlexUIMenuStyleNameAttribute, IFlexUIRollOverColorAttribute, IFlexUISelectionColorAttribute, 
                        IFlexUITextAlignAttribute, IFlexUITextDecorationAttribute, IFlexUITextIndentAttribute, 
                        IFlexUIItemClickAttribute, IFlexUIItemRollOutAttribute, IFlexUIItemRollOverAttribute, 
                        IFlexUIMenuHideAttribute, IFlexUIMenuShowAttribute {
	
}
