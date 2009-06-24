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

import com.googlecode.jsfFlex.component.attributes._MXMLUIBottomAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUICreationCompleteAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUICreationCompleteEffectAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDragCompleteAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDragDropAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDragEnterAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDragExitAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDragOverAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIErrorColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFocusInEffectAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFocusOutEffectAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIHeightAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUILeftAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIMouseDownEffectAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIMouseUpEffectAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIMoveEffectAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIRightAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIStyleNameAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIThemeColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUITopAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIWidthAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIXAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIYAttribute;

/**
 * @author Ji Hoon Kim
 */
@JSFComponent
public interface _MXMLUIBaseAttributes
                    extends _MXMLUIHeightAttribute, _MXMLUIStyleNameAttribute, _MXMLUIWidthAttribute,
                    _MXMLUIXAttribute, _MXMLUIYAttribute, _MXMLUIBottomAttribute, _MXMLUIErrorColorAttribute,
                    _MXMLUILeftAttribute, _MXMLUIRightAttribute, _MXMLUIThemeColorAttribute, _MXMLUITopAttribute,
                    _MXMLUICreationCompleteEffectAttribute, _MXMLUIFocusInEffectAttribute, _MXMLUIFocusOutEffectAttribute,
                    _MXMLUIMouseDownEffectAttribute, _MXMLUIMouseUpEffectAttribute, _MXMLUIMoveEffectAttribute,
                    _MXMLUICreationCompleteAttribute, _MXMLUIDragCompleteAttribute, _MXMLUIDragDropAttribute,
                    _MXMLUIDragEnterAttribute, _MXMLUIDragExitAttribute, _MXMLUIDragOverAttribute {
	
}
