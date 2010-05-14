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

import com.googlecode.jsfFlex.attributes.IFlexUIAllowDragSelectionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIAllowMultipleSelectionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIAlternatingItemColorsAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIChangeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIColumnCountAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIColumnWidthAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDataChangeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDataTipFieldAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDataTipFunctionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDragEnabledAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDragMoveEnabledAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDropEnabledAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDropIndicatorSkinAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFocusAlphaAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFocusRoundedCornersAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIIconFieldAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIIconFunctionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIItemClickAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIItemDoubleClickAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIItemRendererAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIItemRollOutAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIItemRollOverAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUILabelFieldAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUILabelFunctionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUILockedColumnCountAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUILockedRowCountAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIMenuSelectionModeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIOffscreenExtraRowsOrColumnsAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPaddingBottomAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPaddingLeftAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPaddingRightAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPaddingTopAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIRollOverColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIRowHeightAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISelectableAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISelectedIndicesAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISelectedItemAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISelectedItemsAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISelectionColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISelectionDisabledColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISelectionDurationAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISelectionEasingFunctionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIShowDataTipsAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextRollOverColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextSelectedColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIUseRollOverAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIVariableRowHeightAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIVerticalAlignAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIWordWrapAttribute;

/**
 * @author Ji Hoon Kim
 */
@JSFComponent
interface IFlexUIListBaseAttributes 
                    extends IFlexUIAllowDragSelectionAttribute, IFlexUIAllowMultipleSelectionAttribute, IFlexUIColumnCountAttribute, 
                    IFlexUIColumnWidthAttribute, IFlexUIDataTipFieldAttribute, IFlexUIDataTipFunctionAttribute, 
                    IFlexUIDragEnabledAttribute, IFlexUIDragMoveEnabledAttribute, IFlexUIDropEnabledAttribute, 
                    IFlexUIIconFieldAttribute, IFlexUIIconFunctionAttribute, IFlexUIItemRendererAttribute, IFlexUILabelFieldAttribute, 
                    IFlexUILabelFunctionAttribute, IFlexUILockedColumnCountAttribute, IFlexUILockedRowCountAttribute, 
                    IFlexUIMenuSelectionModeAttribute, IFlexUIRowHeightAttribute, IFlexUISelectableAttribute, IFlexUISelectedIndicesAttribute, 
                    IFlexUISelectedItemAttribute, IFlexUISelectedItemsAttribute, IFlexUIShowDataTipsAttribute, 
                    IFlexUIVariableRowHeightAttribute, IFlexUIWordWrapAttribute, IFlexUIAlternatingItemColorsAttribute, 
                    IFlexUIDropIndicatorSkinAttribute, IFlexUIFocusAlphaAttribute, IFlexUIFocusRoundedCornersAttribute, 
                    IFlexUIPaddingBottomAttribute, IFlexUIPaddingLeftAttribute, IFlexUIPaddingRightAttribute, IFlexUIPaddingTopAttribute, 
                    IFlexUIRollOverColorAttribute, IFlexUISelectionColorAttribute, IFlexUISelectionDisabledColorAttribute, 
                    IFlexUISelectionDurationAttribute, IFlexUISelectionEasingFunctionAttribute, IFlexUITextRollOverColorAttribute, 
                    IFlexUITextSelectedColorAttribute, IFlexUIUseRollOverAttribute, IFlexUIVerticalAlignAttribute, 
                    IFlexUIChangeAttribute, IFlexUIDataChangeAttribute, IFlexUIItemDoubleClickAttribute, 
                    IFlexUIItemRollOutAttribute, IFlexUIItemRollOverAttribute, IFlexUIItemClickAttribute, 
                    IFlexUIOffscreenExtraRowsOrColumnsAttribute, IFlexUIScrollControlAttributes {
    
    String getDataProvider();
    
    void setDataProvider(String dataProvider);
    
    String getRowCount();
    
    Integer getSelectedIndex();
    
    void setSelectedIndex(Integer selectedIndex);
    
}
