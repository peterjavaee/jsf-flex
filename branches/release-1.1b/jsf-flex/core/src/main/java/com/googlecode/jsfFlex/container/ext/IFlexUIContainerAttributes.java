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
package com.googlecode.jsfFlex.container.ext;

import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFComponent;

import com.googlecode.jsfFlex.attributes.IFlexUIAutoLayoutAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBackgroundAlphaAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBackgroundAttachmentAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBackgroundColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBackgroundDisabledColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBackgroundImageAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBackgroundSizeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBarColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBaseAttributes;
import com.googlecode.jsfFlex.attributes.IFlexUIBorderColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBorderSidesAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBorderSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBorderStyleAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBorderThicknessAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIChildAddAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIChildIndexChangeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIChildRemoveAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIClipContentAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUICornerRadiusAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUICreationIndexAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUICreationPolicyAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDataChangeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDefaultButtonAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDisabledColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDisabledOverlayAlphaAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDropShadowColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDropShadowEnabledAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontAntiAliasTypeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontFamilyAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontGridFitTypeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontSharpnessAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontSizeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontStyleAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontThicknessAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontWeightAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIHorizontalLineScrollSizeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIHorizontalPageScrollSizeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIHorizontalScrollBarAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIHorizontalScrollBarStyleNameAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIHorizontalScrollPolicyAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIHorizontalScrollPositionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIIconAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUILabelAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPaddingBottomAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPaddingLeftAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPaddingRightAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPaddingTopAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIScrollAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIShadowDirectionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIShadowDistanceAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextAlignAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextDecorationAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextIndentAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIVerticalLineScrollSizeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIVerticalPageScrollSizeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIVerticalScrollBarAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIVerticalScrollBarStyleNameAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIVerticalScrollPolicyAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIVerticalScrollPositionAttribute;

/**
 * @author Ji Hoon Kim
 */
@JSFComponent
public interface IFlexUIContainerAttributes 
                    extends IFlexUIAutoLayoutAttribute, IFlexUIClipContentAttribute, IFlexUICreationIndexAttribute, 
                    IFlexUICreationPolicyAttribute, IFlexUIDefaultButtonAttribute, IFlexUIHorizontalLineScrollSizeAttribute, 
                    IFlexUIHorizontalPageScrollSizeAttribute, IFlexUIHorizontalScrollBarAttribute, IFlexUIHorizontalScrollPolicyAttribute, 
                    IFlexUIHorizontalScrollPositionAttribute, IFlexUIIconAttribute, IFlexUILabelAttribute, IFlexUIVerticalLineScrollSizeAttribute, 
                    IFlexUIVerticalPageScrollSizeAttribute, IFlexUIVerticalScrollBarAttribute, IFlexUIVerticalScrollPolicyAttribute, 
                    IFlexUIVerticalScrollPositionAttribute, IFlexUIBackgroundAlphaAttribute, IFlexUIBackgroundAttachmentAttribute, 
                    IFlexUIBackgroundColorAttribute, IFlexUIBackgroundDisabledColorAttribute, IFlexUIBackgroundImageAttribute, 
                    IFlexUIBackgroundSizeAttribute, IFlexUIBarColorAttribute, IFlexUIBorderColorAttribute, IFlexUIBorderSidesAttribute,
                    IFlexUIBorderSkinAttribute, IFlexUIBorderStyleAttribute, IFlexUIBorderThicknessAttribute, IFlexUIColorAttribute, 
                    IFlexUICornerRadiusAttribute, IFlexUIDisabledColorAttribute, IFlexUIDisabledOverlayAlphaAttribute, 
                    IFlexUIDropShadowColorAttribute, IFlexUIDropShadowEnabledAttribute, IFlexUIFontAntiAliasTypeAttribute, 
                    IFlexUIFontFamilyAttribute, IFlexUIFontGridFitTypeAttribute, IFlexUIFontSharpnessAttribute, 
                    IFlexUIFontSizeAttribute, IFlexUIFontStyleAttribute, IFlexUIFontThicknessAttribute, IFlexUIFontWeightAttribute, 
                    IFlexUIHorizontalScrollBarStyleNameAttribute, IFlexUIPaddingBottomAttribute, IFlexUIPaddingLeftAttribute, 
                    IFlexUIPaddingRightAttribute, IFlexUIPaddingTopAttribute, IFlexUIShadowDirectionAttribute, IFlexUIShadowDistanceAttribute,
                    IFlexUITextAlignAttribute, IFlexUITextDecorationAttribute, IFlexUITextIndentAttribute, 
                    IFlexUIVerticalScrollBarStyleNameAttribute, IFlexUIChildAddAttribute, IFlexUIChildIndexChangeAttribute, 
                    IFlexUIChildRemoveAttribute, IFlexUIDataChangeAttribute, IFlexUIScrollAttribute, IFlexUIBaseAttributes {
	
}
