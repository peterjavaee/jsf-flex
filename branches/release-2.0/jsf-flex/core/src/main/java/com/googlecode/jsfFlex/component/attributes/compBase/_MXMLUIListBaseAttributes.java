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
import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFJspProperties;
import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFJspProperty;

/**
 * @author Ji Hoon Kim
 */
@JSFJspProperties(
        properties={
                @JSFJspProperty(name="allowDragSelection", returnType="java.lang.String", longDesc="A flag that indicates whether drag-selection is enabled."),
                @JSFJspProperty(name="columnWidth", returnType="java.lang.String", longDesc="The width of the control's columns."),
                @JSFJspProperty(name="dataTipField", returnType="java.lang.String", longDesc="Name of the field in the data provider items to display as the data tip."),
                @JSFJspProperty(name="dataTipFunction", returnType="java.lang.String", longDesc="User-supplied function to run on each item to determine its dataTip."),
                @JSFJspProperty(name="dragEnabled", returnType="java.lang.String", longDesc="A flag that indicates whether you can dragitems out of this control and drop them on other controls."),
                @JSFJspProperty(name="dropEnabled", returnType="java.lang.String", longDesc="A flag that indicates whether dragged items can be dropped onto the control."),
                @JSFJspProperty(name="iconFunction", returnType="java.lang.String", longDesc="A user-supplied function to run on each item to determine its icon."),
                @JSFJspProperty(name="lockedColumnCount", returnType="java.lang.String", longDesc="The index of the first column in the control that scrolls."),
                @JSFJspProperty(name="lockedRowCount", returnType="java.lang.String", longDesc="The index of the first row in the control that scrolls."),
                @JSFJspProperty(name="menuSelectionMode", returnType="java.lang.String", longDesc="A flag that indicates whether menu-style selection should be used."),
                @JSFJspProperty(name="selectedIndices", returnType="java.lang.String", longDesc="An array of indices in the data provider of the selected items."),
                @JSFJspProperty(name="selectedItems", returnType="java.lang.String", longDesc="An array of references to the selected items in the data provider."),
                @JSFJspProperty(name="showDataTips", returnType="java.lang.String", longDesc="A flag that indicates whether dataTips are displayed for text in the rows."),
                @JSFJspProperty(name="variableRowHeight", returnType="java.lang.String", longDesc="A flag that indicates whether the individual rows can have different height."),
                @JSFJspProperty(name="dropIndicatorSkin", returnType="java.lang.String", longDesc="The skin to use to indicate where a dragged item can be dropped."),
                @JSFJspProperty(name="useRollOver", returnType="java.lang.String", longDesc="A flag that controls whether items are highlighted as the mouse rolls over them."),
                @JSFJspProperty(name="itemDoubleClick", returnType="java.lang.String", longDesc="Dispatched when the user double-clicks on an item in the control."),
                @JSFJspProperty(name="rowHeight", returnType="java.lang.String", longDesc="The height of the rows in pixels.")
        }
)
@JSFComponent
public interface _MXMLUIListBaseAttributes {
	
}
