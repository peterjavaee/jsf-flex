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

import com.googlecode.jsfFlex.attributes.IFlexUIBarColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBarSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBaseAttributes;
import com.googlecode.jsfFlex.attributes.IFlexUIBorderColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUICompleteAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUICompleteEffectAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIConversionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDisabledColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontAntiAliasTypeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontFamilyAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontGridFitTypeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontSharpnessAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontSizeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontStyleAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontThicknessAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontWeightAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIHideAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIHorizontalGapAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIIndeterminateAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIIndeterminateMoveIntervalAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIIndeterminateSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUILabelAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUILabelPlacementAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUILabelWidthAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUILeadingAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIMaskSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIMaximumAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIMinimumAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIModeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPaddingLeftAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPaddingRightAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIProgressAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIShowAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISourceAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextAlignAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextDecorationAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextIndentAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIThemeColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITrackColorsAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITrackHeightAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITrackSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIVerticalGapAttribute;
import com.googlecode.jsfFlex.component.AbstractFlexUIValueBase;

/**
 * Note though FlexUIProgressBar extends AbstractFlexUIValueBase, it will simply retrieve the value during the post-back phase<br>
 * and NOT set the field of the Flex component as this field is read only.<br>
 * 
 * @author Ji Hoon Kim
 */
@JSFComponent(
        name                =   "jf:flexProgressBar",
        clazz               =   "com.googlecode.jsfFlex.component.ext.FlexUIProgressBar",
        type                =   "com.googlecode.jsfFlex.FlexUIProgressBar",
        tagClass            =   "com.googlecode.jsfFlex.taglib.component.ext.FlexUIProgressBarTag",
        family              =   "javax.faces.FlexInput",
        defaultRendererType =   "com.googlecode.jsfFlex.FlexProgressBar",
        tagSuperclass       =   "com.googlecode.jsfFlex.taglib.FlexUIInputTagBase"
)
public abstract class AbstractFlexUIProgressBar 
						extends AbstractFlexUIValueBase 
						implements IFlexUIBaseAttributes, IFlexUIConversionAttribute, IFlexUIIndeterminateAttribute, 
                        IFlexUILabelAttribute, IFlexUILabelPlacementAttribute, IFlexUIMaximumAttribute, IFlexUIMinimumAttribute, 
                        IFlexUIModeAttribute, IFlexUISourceAttribute, IFlexUIBarColorAttribute, IFlexUIBarSkinAttribute, 
                        IFlexUIBorderColorAttribute, IFlexUIColorAttribute, IFlexUIDisabledColorAttribute, IFlexUIFontAntiAliasTypeAttribute, 
                        IFlexUIFontFamilyAttribute, IFlexUIFontGridFitTypeAttribute, IFlexUIFontSharpnessAttribute, 
                        IFlexUIFontSizeAttribute, IFlexUIFontThicknessAttribute, IFlexUIFontStyleAttribute, IFlexUIFontWeightAttribute, 
                        IFlexUIHorizontalGapAttribute, IFlexUIIndeterminateMoveIntervalAttribute, IFlexUIIndeterminateSkinAttribute, 
                        IFlexUILabelWidthAttribute, IFlexUILeadingAttribute, IFlexUIMaskSkinAttribute, IFlexUIPaddingLeftAttribute, 
                        IFlexUIPaddingRightAttribute, IFlexUITextAlignAttribute, IFlexUITextDecorationAttribute, 
                        IFlexUITextIndentAttribute, IFlexUIThemeColorAttribute, IFlexUITrackColorsAttribute, IFlexUITrackHeightAttribute, 
                        IFlexUITrackSkinAttribute, IFlexUIVerticalGapAttribute, IFlexUICompleteAttribute, IFlexUIHideAttribute, 
                        IFlexUIProgressAttribute, IFlexUIShowAttribute, IFlexUICompleteEffectAttribute {
	
	protected void populateComponentInitValues(){
		
	}
	
}
