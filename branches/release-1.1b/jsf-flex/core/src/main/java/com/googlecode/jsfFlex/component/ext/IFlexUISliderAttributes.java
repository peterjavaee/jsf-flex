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

import com.googlecode.jsfFlex.attributes.IFlexUIAllowThumbOverlapAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIAllowTrackClickAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBaseAttributes;
import com.googlecode.jsfFlex.attributes.IFlexUIBorderColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIChangeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDataTipFormatFunctionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDataTipOffsetAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDataTipPrecisionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDataTipStyleNameAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDirectionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFillAlphasAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFillColorsAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUILabelOffsetAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUILabelStyleNameAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUILabelsAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUILiveDraggingAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIMaximumAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIMinimumAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIShowDataTipAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIShowTrackHighlightAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISlideDurationAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISlideEasingFunctionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISliderDataTipClassAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISliderThumbClassAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISnapIntervalAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIThumbCountAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIThumbDisabledSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIThumbDownSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIThumbDragAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIThumbOffsetAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIThumbOverSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIThumbPressAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIThumbReleaseAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIThumbUpSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITickColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITickIntervalAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITickLengthAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITickOffsetAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITickThicknessAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITickValuesAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITrackColorsAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITrackHighlightSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITrackMarginAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITrackSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIValueAttribute;

/**
 * @author Ji Hoon Kim
 */
@JSFComponent
interface IFlexUISliderAttributes 
                    extends IFlexUIAllowThumbOverlapAttribute, IFlexUIAllowTrackClickAttribute, IFlexUIDataTipFormatFunctionAttribute,
                    IFlexUIDirectionAttribute, IFlexUILabelsAttribute, IFlexUILiveDraggingAttribute, IFlexUIMaximumAttribute, 
                    IFlexUIMinimumAttribute, IFlexUIShowDataTipAttribute, IFlexUISliderDataTipClassAttribute, 
                    IFlexUISliderThumbClassAttribute, IFlexUISnapIntervalAttribute, IFlexUIThumbCountAttribute, 
                    IFlexUITickIntervalAttribute, IFlexUITickValuesAttribute, IFlexUIValueAttribute, IFlexUIBorderColorAttribute, 
                    IFlexUIDataTipOffsetAttribute, IFlexUIDataTipPrecisionAttribute, IFlexUIDataTipStyleNameAttribute, 
                    IFlexUIFillAlphasAttribute, IFlexUIFillColorsAttribute, IFlexUILabelOffsetAttribute, IFlexUILabelStyleNameAttribute, 
                    IFlexUIShowTrackHighlightAttribute, IFlexUISlideDurationAttribute, IFlexUISlideEasingFunctionAttribute, 
                    IFlexUIThumbDisabledSkinAttribute, IFlexUIThumbDownSkinAttribute, IFlexUIThumbOffsetAttribute, 
                    IFlexUIThumbOverSkinAttribute, IFlexUIThumbUpSkinAttribute, IFlexUITickColorAttribute, IFlexUITickLengthAttribute, 
                    IFlexUITickOffsetAttribute, IFlexUITickThicknessAttribute, IFlexUITrackColorsAttribute, IFlexUITrackHighlightSkinAttribute, 
                    IFlexUITrackMarginAttribute, IFlexUITrackSkinAttribute, IFlexUIChangeAttribute, IFlexUIThumbDragAttribute, 
                    IFlexUIThumbPressAttribute, IFlexUIThumbReleaseAttribute, IFlexUIBaseAttributes {
	
}
