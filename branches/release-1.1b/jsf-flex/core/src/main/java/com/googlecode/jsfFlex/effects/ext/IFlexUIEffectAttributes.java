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
package com.googlecode.jsfFlex.effects.ext;

import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFComponent;

import com.googlecode.jsfFlex.attributes.IFlexUICustomFilterAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDurationAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIEffectEndAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIEffectStartAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFilterAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIHideFocusRingAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPerElementOffsetAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIRepeatCountAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIRepeatDelayAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIStartDelayAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISuspendBackgroundProcessingAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITargetAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITargetsAttribute;

/**
 * @author Ji Hoon Kim
 */
@JSFComponent
interface IFlexUIEffectAttributes extends 
                    IFlexUICustomFilterAttribute, IFlexUIDurationAttribute, IFlexUIFilterAttribute,IFlexUIHideFocusRingAttribute, 
                    IFlexUIPerElementOffsetAttribute, IFlexUIRepeatCountAttribute, IFlexUIRepeatDelayAttribute, IFlexUIStartDelayAttribute, 
                    IFlexUISuspendBackgroundProcessingAttribute, IFlexUITargetAttribute, IFlexUITargetsAttribute, IFlexUIEffectEndAttribute, 
                    IFlexUIEffectStartAttribute {
    
}
