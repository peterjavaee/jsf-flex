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
import com.googlecode.jsfFlex.attributes.IFlexUIBorderAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBorderColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBorderSidesAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBorderSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBorderStyleAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBorderThicknessAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUICornerRadiusAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDisabledColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDropShadowColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDropShadowEnabledAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontFamilyAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontSizeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontStyleAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontWeightAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIHorizontalScrollBarStyleNameAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIHorizontalScrollPolicyAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIHorizontalScrollPositionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUILeadingAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUILiveScrollingAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIMaxHorizontalScrollPositionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIMaxVerticalScrollPositionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIRepeatDelayAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIRepeatIntervalAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIScrollAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIScrollTipFunctionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIShadowDirectionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIShadowDistanceAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIShowScrollTipsAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextAlignAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextDecorationAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextIndentAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIVerticalScrollBarStyleNameAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIVerticalScrollPolicyAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIVerticalScrollPositionAttribute;

/**
 * @author Ji Hoon Kim
 */
@JSFComponent
interface IFlexUIScrollControlAttributes 
                    extends IFlexUIBorderAttribute, IFlexUIHorizontalScrollPolicyAttribute, IFlexUIHorizontalScrollPositionAttribute, 
                    IFlexUILiveScrollingAttribute, IFlexUIMaxHorizontalScrollPositionAttribute, IFlexUIMaxVerticalScrollPositionAttribute, 
                    IFlexUIScrollTipFunctionAttribute, IFlexUIShowScrollTipsAttribute, IFlexUIVerticalScrollPolicyAttribute, 
                    IFlexUIVerticalScrollPositionAttribute, IFlexUIBackgroundAlphaAttribute, IFlexUIBackgroundColorAttribute, 
                    IFlexUIBackgroundImageAttribute, IFlexUIBackgroundSizeAttribute, IFlexUIBorderColorAttribute, 
                    IFlexUIBorderSidesAttribute, IFlexUIBorderSkinAttribute, IFlexUIBorderStyleAttribute, IFlexUIBorderThicknessAttribute, 
                    IFlexUIColorAttribute, IFlexUICornerRadiusAttribute, IFlexUIDisabledColorAttribute, IFlexUIDropShadowColorAttribute, 
                    IFlexUIDropShadowEnabledAttribute, IFlexUIFontFamilyAttribute, IFlexUIFontSizeAttribute, IFlexUIFontStyleAttribute, 
                    IFlexUIFontWeightAttribute, IFlexUIHorizontalScrollBarStyleNameAttribute, IFlexUILeadingAttribute, 
                    IFlexUIRepeatDelayAttribute, IFlexUIRepeatIntervalAttribute, IFlexUIShadowDirectionAttribute, IFlexUIShadowDistanceAttribute, 
                    IFlexUITextAlignAttribute, IFlexUITextDecorationAttribute, IFlexUITextIndentAttribute, IFlexUIVerticalScrollBarStyleNameAttribute, 
                    IFlexUIScrollAttribute, IFlexUIBaseAttributes {
	
}
