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
package com.googlecode.jsfFlex.attributes;

import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFComponent;
import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFProperty;

/**
 * @author Ji Hoon Kim
 */
@JSFComponent
public interface IFlexUIGroupNameAttribute {
    
    /**
     * Specifies the name of the group to which this RadioButton control belongs, or specifies the value of the id property of a RadioButtonGroup control if this RadioButton is part of agroup defined by a RadioButtonGroup control.
     */
    @JSFProperty(
            required    =   true,
            desc        =   "Specifies the name of the group to which this RadioButton control belongs, or specifies the value of the id property of a RadioButtonGroup control if this RadioButton is part of agroup defined by a RadioButtonGroup control."
    )
    String getGroupName();
    
}
