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

import com.googlecode.jsfFlex.attributes._MXMLUIAlternatingItemColorsAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIDataProviderAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIDefaultLeafIconAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIDepthColorsAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIDisclosureClosedIconAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIDisclosureOpenIconAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIDisplayDisclosureIconAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIDisplayItemsExpandedAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIEditableAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIFolderClosedIconAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIFolderOpenIconAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIGroupIconFunctionAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIGroupItemRendererAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIGroupLabelFunctionAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIGroupRowHeightAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIGroupedColumnsAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIHeaderDragOutsideAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIHeaderDropOutsideAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIHeaderHorizontalSeparatorSkinAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIIndentationAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIItemCloseAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIItemIconsAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIItemOpenAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIItemOpeningAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUILockedColumnCountAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUILockedRowCountAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIOpenDurationAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIOpenEasingFunctionAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIPaddingLeftAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIPaddingRightAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIRendererProvidersAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIRowCount;
import com.googlecode.jsfFlex.attributes._MXMLUISelectedCellsAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUISelectionDisabledColorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUISelectionEasingFunctionAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUISortExpertModeAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUISortFontSizeAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUISortFontStyleAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUISortFontWeightAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUITextRollOverColorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUITextSelectedColorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUITreeColumnAttribute;

/**
 * @author Ji Hoon Kim
 */
@JSFComponent(
        name                =   "jf:mxmlAdvancedDataGrid",
        clazz               =   "com.googlecode.jsfFlex.component.ext.MXMLUIAdvancedDataGrid",
        type                =   "com.googlecode.jsfFlex.MXMLUIAdvancedDataGrid",
        tagClass            =   "com.googlecode.jsfFlex.taglib.ext.MXMLUIAdvancedDataGridTag",
        family              =   "javax.faces.MXMLInput",
        defaultRendererType =   "com.googlecode.jsfFlex.MXMLAdvancedDataGrid"
)
public abstract class AbstractMXMLUIAdvancedDataGrid 
                            extends com.googlecode.jsfFlex.component.MXMLUISelectedIndexBase 
                            implements _MXMLUIAdvancedDataGridBaseExAttributes, _MXMLUIEditableAttribute, _MXMLUIDataProviderAttribute, 
                            _MXMLUIRowCount, _MXMLUIDisplayDisclosureIconAttribute, _MXMLUIDisplayItemsExpandedAttribute, 
                            _MXMLUIGroupedColumnsAttribute, _MXMLUIGroupIconFunctionAttribute, _MXMLUIGroupItemRendererAttribute, 
                            _MXMLUIGroupLabelFunctionAttribute, _MXMLUIGroupRowHeightAttribute, _MXMLUIItemIconsAttribute, 
                            _MXMLUILockedColumnCountAttribute, _MXMLUILockedRowCountAttribute, _MXMLUIRendererProvidersAttribute, 
                            _MXMLUISelectedCellsAttribute, _MXMLUISortExpertModeAttribute, _MXMLUITreeColumnAttribute, 
                            _MXMLUIAlternatingItemColorsAttribute, _MXMLUIDefaultLeafIconAttribute, _MXMLUIDepthColorsAttribute, 
                            _MXMLUIDisclosureClosedIconAttribute, _MXMLUIDisclosureOpenIconAttribute, _MXMLUIFolderClosedIconAttribute, 
                            _MXMLUIFolderOpenIconAttribute, _MXMLUIHeaderHorizontalSeparatorSkinAttribute, _MXMLUIIndentationAttribute, 
                            _MXMLUIOpenDurationAttribute, _MXMLUIOpenEasingFunctionAttribute, _MXMLUIPaddingLeftAttribute, 
                            _MXMLUIPaddingRightAttribute, _MXMLUISelectionDisabledColorAttribute, _MXMLUISelectionEasingFunctionAttribute, 
                            _MXMLUISortFontSizeAttribute, _MXMLUISortFontStyleAttribute, _MXMLUISortFontWeightAttribute, 
                            _MXMLUITextRollOverColorAttribute, _MXMLUITextSelectedColorAttribute, _MXMLUIHeaderDragOutsideAttribute, 
                            _MXMLUIHeaderDropOutsideAttribute, _MXMLUIItemCloseAttribute, _MXMLUIItemOpenAttribute, 
                            _MXMLUIItemOpeningAttribute {
    
}
