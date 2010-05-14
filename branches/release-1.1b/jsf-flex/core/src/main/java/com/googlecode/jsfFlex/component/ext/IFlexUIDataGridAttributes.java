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
import com.googlecode.jsfFlex.attributes.IFlexUIColumnDropIndicatorSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIColumnResizeSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIColumnStretchAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIColumnsAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDraggableColumnsAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIEditedItemPositionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIHeaderColorsAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIHeaderDragProxyStyleNameAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIHeaderReleaseAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIHeaderSeparatorSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIHeaderShiftAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIHeaderStyleNameAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIHorizontalGridLineColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIHorizontalGridLinesAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIHorizontalLockedSeparatorSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIHorizontalScrollPositionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIHorizontalSeparatorSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIIconColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIImeModeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIItemEditBeginAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIItemEditBeginningAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIItemEditEndAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIItemEditorInstanceAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIItemFocusInAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIItemFocusOutAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIMinColumnWidthAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIResizableColumnsAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIRollOverColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISelectionColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISortArrowSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISortableColumnsAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIStretchCursorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIVerticalGridLineColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIVerticalGridLinesAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIVerticalLockedSeparatorSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIVerticalSeparatorSkinAttribute;

/**
 * @author Ji Hoon Kim
 */
@JSFComponent
interface IFlexUIDataGridAttributes 
            extends IFlexUIColumnsAttribute, IFlexUIDraggableColumnsAttribute, IFlexUIEditedItemPositionAttribute, 
            IFlexUIHorizontalScrollPositionAttribute, IFlexUIImeModeAttribute, IFlexUIItemEditorInstanceAttribute, 
            IFlexUIMinColumnWidthAttribute, IFlexUIResizableColumnsAttribute, IFlexUISortableColumnsAttribute, 
            IFlexUIBackgroundDisabledColorAttribute, IFlexUIColumnDropIndicatorSkinAttribute, IFlexUIColumnResizeSkinAttribute, 
            IFlexUIHeaderColorsAttribute, IFlexUIHeaderDragProxyStyleNameAttribute, IFlexUIHeaderSeparatorSkinAttribute, 
            IFlexUIHeaderStyleNameAttribute, IFlexUIHorizontalGridLineColorAttribute, IFlexUIHorizontalGridLinesAttribute, 
            IFlexUIRollOverColorAttribute, IFlexUISelectionColorAttribute, IFlexUISortArrowSkinAttribute, IFlexUIStretchCursorAttribute, 
            IFlexUIVerticalGridLineColorAttribute, IFlexUIVerticalGridLinesAttribute, IFlexUIColumnStretchAttribute, 
            IFlexUIHeaderReleaseAttribute, IFlexUIHeaderShiftAttribute, IFlexUIItemEditBeginAttribute, IFlexUIItemEditEndAttribute, 
            IFlexUIItemFocusInAttribute, IFlexUIItemFocusOutAttribute, IFlexUIHorizontalLockedSeparatorSkinAttribute, 
            IFlexUIHorizontalSeparatorSkinAttribute, IFlexUIIconColorAttribute, IFlexUIVerticalLockedSeparatorSkinAttribute, 
            IFlexUIVerticalSeparatorSkinAttribute, IFlexUIItemEditBeginningAttribute, IFlexUIDataGridBaseAttributes {

    String getEditable();
    
}
