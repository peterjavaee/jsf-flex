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
import com.googlecode.jsfFlex.attributes._MXMLUIBackgroundColorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIBackgroundDisabledColorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIBackgroundImageAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIBackgroundSizeAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIBarColorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIBaseAttributes;
import com.googlecode.jsfFlex.attributes._MXMLUIBorderColorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIBorderSidesAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIBorderSkinAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIBorderStyleAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIBorderThicknessAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIColorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUICornerRadiusAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIDataChangeAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIDataProviderAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIDirectionAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIDisabledColorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIDropShadowColorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIDropShadowEnabledAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIFontAntiAliasTypeAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIFontFamilyAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIFontGridFitTypeAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIFontSharpnessAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIFontSizeAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIFontStyleAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIFontThicknessAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIFontWeightAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIHorizontalAlignAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIHorizontalGapAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIHorizontalScrollPolicyAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIHorizontalScrollPositionAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIIconAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIIconFieldAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIItemClickAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUILabelAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUILabelFieldAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIPaddingBottomAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIPaddingLeftAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIPaddingRightAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIPaddingTopAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIRollOverColorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIScrollAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUISelectedIndexAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUISelectionColorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUISeparatorColorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUISeparatorSkinAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUISeparatorWidthAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIShadowDirectionAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIShadowDistanceAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUITextAlignAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUITextDecorationAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUITextIndentAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUITextRollOverColorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUITextSelectedColorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIToolTipFieldAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIVerticalAlignAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIVerticalGapAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIVerticalScrollPolicyAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIVerticalScrollPositionAttribute;
import com.googlecode.jsfFlex.component.MXMLUISimpleBase;

/**
 * @author Ji Hoon Kim
 */
@JSFComponent(
        name                =   "jf:mxmlLinkBar",
        clazz               =   "com.googlecode.jsfFlex.component.ext.MXMLUILinkBar",
        type                =   "com.googlecode.jsfFlex.MXMLUILinkBar",
        tagClass            =   "com.googlecode.jsfFlex.taglib.ext.MXMLUILinkBarTag",
        family              =   "javax.faces.MXMLSimple",
        defaultRendererType =   "com.googlecode.jsfFlex.MXMLLinkBar"
)
public abstract class AbstractMXMLUILinkBar 
						extends MXMLUISimpleBase 
						implements _MXMLUINavBarAttributes, _MXMLUIRollOverColorAttribute, _MXMLUISelectionColorAttribute, 
                        _MXMLUISeparatorColorAttribute, _MXMLUISeparatorSkinAttribute, _MXMLUISeparatorWidthAttribute, 
                        _MXMLUITextRollOverColorAttribute, _MXMLUITextSelectedColorAttribute {
	
}
