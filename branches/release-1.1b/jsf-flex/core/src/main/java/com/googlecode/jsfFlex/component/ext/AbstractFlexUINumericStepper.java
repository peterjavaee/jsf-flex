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
import com.googlecode.jsfFlex.attributes.IFlexUIBackgroundImageAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBackgroundSizeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBaseAttributes;
import com.googlecode.jsfFlex.attributes.IFlexUIBorderCapColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBorderColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBorderSidesAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBorderSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBorderStyleAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBorderThicknessAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIChangeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUICornerRadiusAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDataChangeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDisabledColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDownArrowDisabledSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDownArrowDownSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDownArrowOverSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDownArrowUpSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDropShadowColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDropShadowEnabledAttribute;
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
import com.googlecode.jsfFlex.attributes.IFlexUIIconColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIImeModeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUILeadingAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIMaxCharsAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIMaximumAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIMinimumAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPaddingLeftAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPaddingRightAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIShadowDirectionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIShadowDistanceAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIStepSizeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextAlignAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextDecorationAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextIndentAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIUpArrowDisabledSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIUpArrowDownSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIUpArrowOverSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIUpArrowUpSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIValueAttribute;
import com.googlecode.jsfFlex.component.AbstractFlexUIValueBase;

/**
 * @author Ji Hoon Kim
 */
@JSFComponent(
        name                =   "jf:flexNumericStepper",
        clazz               =   "com.googlecode.jsfFlex.component.ext.FlexUINumericStepper",
        type                =   "com.googlecode.jsfFlex.FlexUINumericStepper",
        tagClass            =   "com.googlecode.jsfFlex.taglib.component.ext.FlexUINumericStepperTag",
        family              =   "javax.faces.FlexInput",
        defaultRendererType =   "com.googlecode.jsfFlex.FlexNumericStepper",
        tagSuperclass       =   "com.googlecode.jsfFlex.taglib.AbstractFlexUIInputTagBase"
)
public abstract class AbstractFlexUINumericStepper 
						extends AbstractFlexUIValueBase 
						implements IFlexUIBaseAttributes, IFlexUIImeModeAttribute, IFlexUIMaxCharsAttribute, 
                        IFlexUIMaximumAttribute, IFlexUIMinimumAttribute, IFlexUIStepSizeAttribute, IFlexUIValueAttribute, 
                        IFlexUIBackgroundAlphaAttribute, IFlexUIBackgroundColorAttribute, IFlexUIBackgroundImageAttribute, 
                        IFlexUIBackgroundSizeAttribute, IFlexUIBorderCapColorAttribute, IFlexUIBorderColorAttribute, 
                        IFlexUIBorderSidesAttribute, IFlexUIBorderSkinAttribute, IFlexUIBorderStyleAttribute, 
                        IFlexUIBorderThicknessAttribute, IFlexUIColorAttribute, IFlexUICornerRadiusAttribute, 
                        IFlexUIDisabledColorAttribute, IFlexUIDownArrowDisabledSkinAttribute, IFlexUIDownArrowDownSkinAttribute, 
                        IFlexUIDownArrowOverSkinAttribute, IFlexUIDownArrowUpSkinAttribute, IFlexUIDropShadowEnabledAttribute, 
                        IFlexUIDropShadowColorAttribute, IFlexUIFocusAlphaAttribute, IFlexUIFocusRoundedCornersAttribute, 
                        IFlexUIFontAntiAliasTypeAttribute, IFlexUIFontFamilyAttribute, IFlexUIFontGridFitTypeAttribute, 
                        IFlexUIFontSharpnessAttribute, IFlexUIFontSizeAttribute, IFlexUIFontStyleAttribute, 
                        IFlexUIFontThicknessAttribute, IFlexUIFontWeightAttribute, IFlexUIHighlightAlphasAttribute, 
                        IFlexUIIconColorAttribute, IFlexUILeadingAttribute, IFlexUIPaddingLeftAttribute, IFlexUIPaddingRightAttribute, 
                        IFlexUIShadowDirectionAttribute, IFlexUIShadowDistanceAttribute, IFlexUITextAlignAttribute,
                        IFlexUITextDecorationAttribute, IFlexUITextIndentAttribute, IFlexUIUpArrowDisabledSkinAttribute, 
                        IFlexUIUpArrowDownSkinAttribute, IFlexUIUpArrowOverSkinAttribute, IFlexUIUpArrowUpSkinAttribute, 
                        IFlexUIChangeAttribute, IFlexUIDataChangeAttribute {
	
}
