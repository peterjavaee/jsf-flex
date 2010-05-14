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

import com.googlecode.jsfFlex.attributes.IFlexUIArrowButtonWidthAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUICloseAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUICloseDurationAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUICloseEasingFunctionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDisabledIconColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIIconColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIOpenAlwaysAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIOpenAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIOpenDurationAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIOpenEasingFunctionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPopUpAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPopUpDownSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPopUpGapAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPopUpIconAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPopUpOverSkinAttribute;

/**
 * @author Ji Hoon Kim
 */
@JSFComponent
interface IFlexUIPopUpButtonAttributes 
                extends IFlexUIOpenAlwaysAttribute, IFlexUIPopUpAttribute, IFlexUIArrowButtonWidthAttribute, 
                IFlexUICloseDurationAttribute, IFlexUICloseEasingFunctionAttribute, IFlexUIDisabledIconColorAttribute, 
                IFlexUIIconColorAttribute, IFlexUIOpenDurationAttribute, IFlexUIOpenEasingFunctionAttribute, IFlexUIPopUpDownSkinAttribute, 
                IFlexUIPopUpGapAttribute, IFlexUIPopUpIconAttribute, IFlexUIPopUpOverSkinAttribute, IFlexUICloseAttribute, 
                IFlexUIOpenAttribute, IFlexUIButtonAttributes {
    
}
