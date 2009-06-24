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
package com.googlecode.jsfFlex.component.attributes.compBase;

import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFComponent;

import com.googlecode.jsfFlex.component.attributes._MXMLUIControlSkinAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIEditableDisabledSkinAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIEditableDownSkinAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIEditableOverSkinAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIEditableUpSkinAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIImeModeAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIRestrictAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUISelectedItemAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUITextInputStyleNameAttribute;

/**
 * @author Ji Hoon Kim
 */
@JSFComponent
public interface _MXMLUIComboBaseAttributes 
                        extends _MXMLUIImeModeAttribute, _MXMLUIEditableOverSkinAttribute, _MXMLUIEditableDownSkinAttribute,
                        _MXMLUIRestrictAttribute, _MXMLUISelectedItemAttribute, _MXMLUIEditableUpSkinAttribute,
                        _MXMLUIControlSkinAttributes, _MXMLUIBaseAttributes, _MXMLUITextInputStyleNameAttribute,
                        _MXMLUIEditableDisabledSkinAttribute {
	
}
