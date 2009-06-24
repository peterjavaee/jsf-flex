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

import com.googlecode.jsfFlex.component.attributes._MXMLUIAddAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUICurrentStateChangeAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUICurrentStateChangingAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIEffectEndAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIEffectStartAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIEnterStateAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIExitStateAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIHideAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIInitializeAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIInvalidAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIMouseDownOutsideAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIMouseWheelOutsideAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIMoveAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIPreinitializeAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIRecordAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIRemoveAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIResizeAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIShowAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIToolTipCreateAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIToolTipEndAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIToolTipHideAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIToolTipShowAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIToolTipShownAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIToolTipStartAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIUpdateCompleteAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIValidAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIValueCommitAttribute;

/**
 * @author Ji Hoon Kim
 */
@JSFComponent
public interface _MXMLUIBaseEventsAttributes 
                    extends _MXMLUIAddAttribute, _MXMLUICurrentStateChangeAttribute, _MXMLUICurrentStateChangingAttribute,
                    _MXMLUIEffectEndAttribute, _MXMLUIEffectStartAttribute, _MXMLUIEnterStateAttribute,
                    _MXMLUIExitStateAttribute, _MXMLUIHideAttribute, _MXMLUIInitializeAttribute, _MXMLUIInvalidAttribute,
                    _MXMLUIMouseDownOutsideAttribute, _MXMLUIMouseWheelOutsideAttribute, _MXMLUIMoveAttribute,
                    _MXMLUIPreinitializeAttribute, _MXMLUIRecordAttribute, _MXMLUIRemoveAttribute, _MXMLUIShowAttribute,
                    _MXMLUIResizeAttribute, _MXMLUIToolTipCreateAttribute, _MXMLUIToolTipEndAttribute, 
                    _MXMLUIToolTipHideAttribute, _MXMLUIToolTipShowAttribute, _MXMLUIToolTipShownAttribute,
                    _MXMLUIToolTipStartAttribute, _MXMLUIUpdateCompleteAttribute, _MXMLUIValidAttribute,
                    _MXMLUIValueCommitAttribute {
	
}
