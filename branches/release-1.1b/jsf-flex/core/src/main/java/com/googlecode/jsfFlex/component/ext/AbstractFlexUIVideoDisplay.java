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

import com.googlecode.jsfFlex.attributes.IFlexUIAutoBandWidthDetectionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIAutoPlayAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIAutoRewindAttribute;
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
import com.googlecode.jsfFlex.attributes.IFlexUIBufferTimeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUICloseAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUICompleteAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUICornerRadiusAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUICuePointAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUICuePointManagerClassAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUICuePointsAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDropShadowColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDropShadowEnabledAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIIdleTimeoutAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUILiveAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIMaintainAspectRatioAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPlayheadTimeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPlayheadUpdateAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPlayheadUpdateIntervalAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIProgressAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIProgressIntervalAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIReadyAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIRewindAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIShadowDirectionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIShadowDistanceAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISourceAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIStateChangeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITotalTimeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIVolumeAttribute;
import com.googlecode.jsfFlex.component.AbstractFlexUISimpleBase;

/**
 * @author Ji Hoon Kim
 */
@JSFComponent(
        name                =   "jf:flexVideoDisplay",
        clazz               =   "com.googlecode.jsfFlex.component.ext.FlexUIVideoDisplay",
        type                =   "com.googlecode.jsfFlex.FlexUIVideoDisplay",
        tagClass            =   "com.googlecode.jsfFlex.taglib.component.ext.FlexUIVideoDisplayTag",
        family              =   "javax.faces.FlexSimple",
        defaultRendererType =   "com.googlecode.jsfFlex.FlexVideoDisplay"
)
public abstract class AbstractFlexUIVideoDisplay 
						extends AbstractFlexUISimpleBase 
						implements IFlexUIBaseAttributes, IFlexUIAutoBandWidthDetectionAttribute, IFlexUIAutoPlayAttribute, 
                        IFlexUIAutoRewindAttribute, IFlexUIBufferTimeAttribute, IFlexUICuePointManagerClassAttribute, 
                        IFlexUICuePointsAttribute, IFlexUIIdleTimeoutAttribute, IFlexUILiveAttribute, IFlexUIMaintainAspectRatioAttribute, 
                        IFlexUIPlayheadTimeAttribute, IFlexUIPlayheadUpdateIntervalAttribute, IFlexUIProgressIntervalAttribute, 
                        IFlexUISourceAttribute, IFlexUITotalTimeAttribute, IFlexUIVolumeAttribute, IFlexUIBackgroundAlphaAttribute, 
                        IFlexUIBackgroundColorAttribute, IFlexUIBackgroundImageAttribute, IFlexUIBackgroundSizeAttribute, 
                        IFlexUIBorderColorAttribute, IFlexUIBorderSidesAttribute, IFlexUIBorderSkinAttribute, 
                        IFlexUIBorderStyleAttribute, IFlexUIBorderThicknessAttribute, IFlexUICornerRadiusAttribute, 
                        IFlexUIDropShadowColorAttribute, IFlexUIDropShadowEnabledAttribute, IFlexUIShadowDirectionAttribute, 
                        IFlexUIShadowDistanceAttribute, IFlexUICloseAttribute, IFlexUICompleteAttribute, 
                        IFlexUICuePointAttribute, IFlexUIPlayheadUpdateAttribute, IFlexUIProgressAttribute, 
                        IFlexUIReadyAttribute, IFlexUIRewindAttribute, IFlexUIStateChangeAttribute {
	
}
