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

import com.googlecode.jsfFlex.attributes.IFlexUIAutoRepeatAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBaseAttributes;
import com.googlecode.jsfFlex.attributes.IFlexUIBorderColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIButtonDownAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIChangeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUICornerRadiusAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDataChangeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDisabledColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDisabledIconAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDisabledSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDownIconAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDownSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIEmphasizedAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFillAlphasAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFillColorsAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFocusAlphaAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFocusRoundedCornersAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontAntiAliasTypeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontContextAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontFamilyAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontGridFitTypeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontSharpnessAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontSizeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontStyleAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontThicknessAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontWeightAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIHighlightAlphasAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIHorizontalGapAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIIconAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIKerningAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUILabelAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUILabelPlacementAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUILeadingAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUILetterSpacingAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIOverIconAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIOverSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPaddingBottomAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPaddingLeftAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPaddingRightAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPaddingTopAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIRepeatDelayAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIRepeatIntervalAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISelectedDisabledIconAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISelectedDisabledSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISelectedDownIconAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISelectedDownSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISelectedFieldAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISelectedOverIconAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISelectedOverSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISelectedUpIconAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISelectedUpSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIStickyHighlightingAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextAlignAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextDecorationAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextIndentAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextRollOverColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextSelectedColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIToggleAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIUpIconAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIUpSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIVerticalGapAttribute;

/**
 * @author Ji Hoon Kim
 */
@JSFComponent
interface IFlexUIButtonAttributes 
                    extends IFlexUIAutoRepeatAttribute, IFlexUIEmphasizedAttribute, IFlexUILabelAttribute, 
                    IFlexUILabelPlacementAttribute, IFlexUISelectedFieldAttribute, IFlexUIStickyHighlightingAttribute,
                    IFlexUIToggleAttribute, IFlexUIBorderColorAttribute, IFlexUIColorAttribute, IFlexUICornerRadiusAttribute,
                    IFlexUIDisabledColorAttribute, IFlexUIDisabledIconAttribute, IFlexUIDisabledSkinAttribute, 
                    IFlexUIDownIconAttribute, IFlexUIDownSkinAttribute, IFlexUIFillAlphasAttribute, IFlexUIFillColorsAttribute,
                    IFlexUIFocusAlphaAttribute, IFlexUIFocusRoundedCornersAttribute, IFlexUIFontAntiAliasTypeAttribute, 
                    IFlexUIFontFamilyAttribute, IFlexUIFontGridFitTypeAttribute, IFlexUIFontSharpnessAttribute, 
                    IFlexUIFontSizeAttribute, IFlexUIFontStyleAttribute, IFlexUIFontThicknessAttribute, IFlexUIFontWeightAttribute, 
                    IFlexUIHighlightAlphasAttribute, IFlexUIHorizontalGapAttribute, IFlexUIIconAttribute, IFlexUILeadingAttribute, 
                    IFlexUIOverIconAttribute, IFlexUIOverSkinAttribute, IFlexUIPaddingBottomAttribute, IFlexUIPaddingLeftAttribute, 
                    IFlexUIPaddingRightAttribute, IFlexUIPaddingTopAttribute, IFlexUIRepeatDelayAttribute, IFlexUIRepeatIntervalAttribute, 
                    IFlexUISelectedDisabledIconAttribute, IFlexUISelectedDisabledSkinAttribute, IFlexUISelectedDownIconAttribute, 
                    IFlexUISelectedDownSkinAttribute, IFlexUISelectedOverIconAttribute, IFlexUISelectedOverSkinAttribute, 
                    IFlexUISelectedUpIconAttribute, IFlexUISelectedUpSkinAttribute, IFlexUITextAlignAttribute, IFlexUITextDecorationAttribute, 
                    IFlexUITextIndentAttribute, IFlexUITextRollOverColorAttribute, IFlexUITextSelectedColorAttribute, 
                    IFlexUIUpIconAttribute, IFlexUIUpSkinAttribute, IFlexUIVerticalGapAttribute, IFlexUIButtonDownAttribute, 
                    IFlexUIChangeAttribute, IFlexUIDataChangeAttribute, IFlexUIFontContextAttribute, IFlexUIKerningAttribute, 
                    IFlexUILetterSpacingAttribute, IFlexUISkinAttribute, IFlexUIBaseAttributes {
    
}
