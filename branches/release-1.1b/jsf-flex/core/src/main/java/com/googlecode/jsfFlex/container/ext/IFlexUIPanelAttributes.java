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

import com.googlecode.jsfFlex.attributes.IFlexUIBorderAlphaAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBorderThicknessBottomAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBorderThicknessLeftAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBorderThicknessRightAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBorderThicknessTopAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUICloseAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUICloseButtonDisabledSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUICloseButtonDownSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUICloseButtonOverSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUICloseButtonUpSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIControlBarStyleNameAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFooterColorsAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIHeaderColorsAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIHeaderHeightAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIHighlightAlphasAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIHorizontalAlignAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIHorizontalGapAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUILayoutAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIModalTransparencyAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIModalTransparencyBlurAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIModalTransparencyColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIModalTransparencyDurationAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIResizeEndEffectAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIResizeStartEffectAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIRoundedBottomCornersAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIStatusAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIStatusStyleNameAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITitleBackgroundSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITitleIconAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITitleStyleNameAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIVerticalAlignAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIVerticalGapAttribute;

/**
 * @author Ji Hoon Kim
 */
@JSFComponent
public interface IFlexUIPanelAttributes 
                extends IFlexUILayoutAttribute, IFlexUIStatusAttribute, IFlexUITitleIconAttribute, IFlexUIBorderAlphaAttribute, 
                IFlexUIBorderThicknessBottomAttribute, IFlexUIBorderThicknessLeftAttribute, IFlexUIBorderThicknessRightAttribute, 
                IFlexUIBorderThicknessTopAttribute, IFlexUICloseButtonDisabledSkinAttribute, IFlexUICloseButtonDownSkinAttribute, 
                IFlexUICloseButtonOverSkinAttribute, IFlexUICloseButtonUpSkinAttribute, IFlexUIControlBarStyleNameAttribute, 
                IFlexUIFooterColorsAttribute, IFlexUIHeaderColorsAttribute, IFlexUIHeaderHeightAttribute, IFlexUIHighlightAlphasAttribute, 
                IFlexUIHorizontalAlignAttribute, IFlexUIHorizontalGapAttribute, IFlexUIModalTransparencyAttribute, 
                IFlexUIModalTransparencyBlurAttribute, IFlexUIModalTransparencyColorAttribute, IFlexUIModalTransparencyDurationAttribute, 
                IFlexUIRoundedBottomCornersAttribute, IFlexUIStatusStyleNameAttribute, IFlexUITitleBackgroundSkinAttribute, 
                IFlexUITitleStyleNameAttribute, IFlexUIVerticalAlignAttribute, IFlexUIVerticalGapAttribute, IFlexUIResizeEndEffectAttribute, 
                IFlexUIResizeStartEffectAttribute, IFlexUICloseAttribute, IFlexUIContainerAttributes {
    
    String getTitle();
    
}
