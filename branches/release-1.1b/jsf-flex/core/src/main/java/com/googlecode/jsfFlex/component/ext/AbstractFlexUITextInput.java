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
import com.googlecode.jsfFlex.attributes.IFlexUIBorderColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBorderSidesAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBorderSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBorderStyleAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBorderThicknessAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIChangeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUICondenseWhiteAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUICornerRadiusAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDataAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDataChangeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDisabledColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDisplayAsPasswordAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDropShadowColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDropShadowEnabledAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIEditableAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIEnterAttribute;
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
import com.googlecode.jsfFlex.attributes.IFlexUIHorizontalScrollPositionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIImeModeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIListDataAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIMaxCharsAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPaddingLeftAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPaddingRightAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIRestrictAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISelectionBeginIndexAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISelectionEndIndexAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIShadowDirectionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIShadowDistanceAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextAlignAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextDecorationAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextIndentAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextInputAttribute;

/**
 * @author Ji Hoon Kim
 */
@JSFComponent(
        name                =   "jf:flexTextInput",
        clazz               =   "com.googlecode.jsfFlex.component.ext.FlexUITextInput",
        type                =   "com.googlecode.jsfFlex.FlexUITextInput",
        tagClass            =   "com.googlecode.jsfFlex.taglib.component.ext.FlexUITextInputTag",
        family              =   "javax.faces.FlexInput",
        defaultRendererType =   "com.googlecode.jsfFlex.FlexTextInput",
        tagSuperclass       =   "com.googlecode.jsfFlex.taglib.FlexUIInputTagBase"
)
public abstract class AbstractFlexUITextInput 
						extends com.googlecode.jsfFlex.component.FlexUIHtmlTextInputBase
						implements IFlexUIBaseAttributes, IFlexUICondenseWhiteAttribute, IFlexUIDataAttribute, 
                        IFlexUIDisplayAsPasswordAttribute, IFlexUIEditableAttribute, IFlexUIHorizontalScrollPositionAttribute, 
                        IFlexUIImeModeAttribute, IFlexUIListDataAttribute, IFlexUIMaxCharsAttribute, IFlexUIRestrictAttribute, 
                        IFlexUISelectionBeginIndexAttribute, IFlexUISelectionEndIndexAttribute, IFlexUIBackgroundAlphaAttribute, 
                        IFlexUIBackgroundColorAttribute, IFlexUIBackgroundImageAttribute, IFlexUIBackgroundSizeAttribute, 
                        IFlexUIBorderColorAttribute, IFlexUIBorderSidesAttribute, IFlexUIBorderSkinAttribute, 
                        IFlexUIBorderStyleAttribute, IFlexUIBorderThicknessAttribute, IFlexUIColorAttribute, 
                        IFlexUICornerRadiusAttribute, IFlexUIDisabledColorAttribute, IFlexUIDropShadowColorAttribute, 
                        IFlexUIDropShadowEnabledAttribute, IFlexUIFocusAlphaAttribute, IFlexUIFocusRoundedCornersAttribute, 
                        IFlexUIFontAntiAliasTypeAttribute, IFlexUIFontFamilyAttribute, IFlexUIFontGridFitTypeAttribute, 
                        IFlexUIFontSharpnessAttribute, IFlexUIFontSizeAttribute, IFlexUIFontStyleAttribute, 
                        IFlexUIFontThicknessAttribute, IFlexUIFontWeightAttribute, IFlexUIPaddingLeftAttribute, 
                        IFlexUIPaddingRightAttribute, IFlexUIShadowDirectionAttribute, IFlexUIShadowDistanceAttribute, 
                        IFlexUITextAlignAttribute, IFlexUITextDecorationAttribute, IFlexUITextIndentAttribute, 
                        IFlexUIChangeAttribute, IFlexUIDataChangeAttribute, IFlexUIEnterAttribute, 
                        IFlexUITextInputAttribute {
	
}
