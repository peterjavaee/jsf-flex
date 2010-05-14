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

import com.googlecode.jsfFlex.attributes.IFlexUIBackgroundDisabledColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIEditedItemPositionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIEditorDataFieldAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIEditorHeightOffsetAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIEditorUsesEnterKeyAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIEditorWidthOffsetAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIEditorXOffsetAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIEditorYOffsetAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIImeModeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIItemEditBeginAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIItemEditBeginningAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIItemEditEndAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIItemEditorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIItemEditorInstanceAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIItemFocusInAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIItemFocusOutAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIRendererIsEditorAttribute;

/**
 * @author Ji Hoon Kim
 */
@JSFComponent
interface IFlexUIListAttributes 
                    extends IFlexUIEditedItemPositionAttribute, IFlexUIEditorDataFieldAttribute, IFlexUIEditorHeightOffsetAttribute, 
                    IFlexUIEditorUsesEnterKeyAttribute, IFlexUIEditorWidthOffsetAttribute, IFlexUIEditorXOffsetAttribute, 
                    IFlexUIEditorYOffsetAttribute, IFlexUIImeModeAttribute, IFlexUIItemEditorAttribute, IFlexUIItemEditorInstanceAttribute, 
                    IFlexUIRendererIsEditorAttribute, IFlexUIBackgroundDisabledColorAttribute, IFlexUIItemEditBeginAttribute, 
                    IFlexUIItemEditEndAttribute, IFlexUIItemEditBeginningAttribute, IFlexUIItemFocusInAttribute, 
                    IFlexUIItemFocusOutAttribute, IFlexUIListBaseAttributes {
    
    String getEditable();
    
}
