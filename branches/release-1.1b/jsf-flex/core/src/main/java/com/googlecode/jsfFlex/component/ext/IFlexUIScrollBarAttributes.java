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

import com.googlecode.jsfFlex.attributes.IFlexUIBaseAttributes;
import com.googlecode.jsfFlex.attributes.IFlexUIBorderColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUICornerRadiusAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDirectionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDownArrowDisabledSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDownArrowDownSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDownArrowOverSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDownArrowUpSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFillAlphasAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFillColorsAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIHighlightAlphasAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIIconColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUILineScrollSizeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIMaxScrollPositionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIMinScrollPositionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPageScrollSizeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPageSizeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIScrollPositionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIThumbDownSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIThumbIconAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIThumbOffsetAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIThumbOverSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIThumbUpSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITrackColorsAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITrackSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIUpArrowDisabledSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIUpArrowDownSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIUpArrowOverSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIUpArrowUpSkinAttribute;

/**
 * @author Ji Hoon Kim
 */
@JSFComponent
interface IFlexUIScrollBarAttributes 
                    extends IFlexUIDirectionAttribute, IFlexUILineScrollSizeAttribute, IFlexUIMaxScrollPositionAttribute, 
                    IFlexUIMinScrollPositionAttribute, IFlexUIPageScrollSizeAttribute, IFlexUIPageSizeAttribute, 
                    IFlexUIScrollPositionAttribute, IFlexUIBorderColorAttribute, IFlexUICornerRadiusAttribute, IFlexUIDownArrowDisabledSkinAttribute, 
                    IFlexUIDownArrowDownSkinAttribute, IFlexUIDownArrowOverSkinAttribute, IFlexUIDownArrowUpSkinAttribute, 
                    IFlexUIFillAlphasAttribute, IFlexUIFillColorsAttribute, IFlexUIHighlightAlphasAttribute, IFlexUIIconColorAttribute, 
                    IFlexUIThumbDownSkinAttribute, IFlexUIThumbIconAttribute, IFlexUIThumbOffsetAttribute, IFlexUIThumbOverSkinAttribute, 
                    IFlexUIThumbUpSkinAttribute, IFlexUITrackColorsAttribute, IFlexUITrackSkinAttribute, IFlexUIUpArrowDisabledSkinAttribute, 
                    IFlexUIUpArrowDownSkinAttribute, IFlexUIUpArrowOverSkinAttribute, IFlexUIUpArrowUpSkinAttribute, 
                    IFlexUIBaseAttributes {
	
}
