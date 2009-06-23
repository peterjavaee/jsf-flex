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
import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFProperty;

/**
 * @author Ji Hoon Kim
 */
@JSFJspProperties(
        properties={
                @JSFJspProperty(name="height", returnType="java.lang.String", longDesc="Number that specifies the height of the component, in pixels, in the parent's coordinates."),
                @JSFJspProperty(name="styleName", returnType="java.lang.String", longDesc="The class style used by this component."),
                @JSFJspProperty(name="width", returnType="java.lang.String", longDesc="Number that specifies the width of the component, in pixels, in the parent's coordinates."),
                @JSFJspProperty(name="x", returnType="java.lang.String", longDesc="Number that specifies the component's horizontal position, in pixels, within its parent container."),
                @JSFJspProperty(name="y", returnType="java.lang.String", longDesc="Number that specifies the component's vertical position, in pixels, within its parent container."),
                
                @JSFJspProperty(name="bottom", returnType="java.lang.String", longDesc="The vertical distance in pixels from the lower edge of the component to the lower edge of its parent container."),
                @JSFJspProperty(name="errorColor", returnType="java.lang.String", longDesc="Color of the component highlight when validation fails."),
                @JSFJspProperty(name="left", returnType="java.lang.String", longDesc="The horizontal distance in pixels from the left edge of the component's parent container to the left edge of the component."),
                @JSFJspProperty(name="right", returnType="java.lang.String", longDesc="The horizontal distance in pixels from the right edge of the component to the right edge of its parent container."),
                @JSFJspProperty(name="themeColor", returnType="java.lang.String", longDesc="Theme color of a component."),
                @JSFJspProperty(name="top", returnType="java.lang.String", longDesc="The vertical distance in pixels from the top edge of the component's parent container to the top edge of the component."),
                
                @JSFJspProperty(name="creationCompleteEffect", returnType="java.lang.String", longDesc="Played when the component is created."),
                @JSFJspProperty(name="focusInEffect", returnType="java.lang.String", longDesc="Played when the component gains keyboard focus."),
                @JSFJspProperty(name="focusOutEffect", returnType="java.lang.String", longDesc="Played when the component loses keyboard focus."),
                @JSFJspProperty(name="mouseDownEffect", returnType="java.lang.String", longDesc="Played when the user presses the mouse button while over the component."),
                @JSFJspProperty(name="mouseUpEffect", returnType="java.lang.String", longDesc="Played when the user releases the mouse button while over the component."),
                @JSFJspProperty(name="moveEffect", returnType="java.lang.String", longDesc="Played when the component is moved."),
                
                @JSFJspProperty(name="creationComplete", returnType="java.lang.String", longDesc="Dispatched when the component has finished its construction, property processing, measuring, layout, and drawing."),
                @JSFJspProperty(name="dragComplete", returnType="java.lang.String", longDesc="Dispatched by the drag initiator (the component that is the source of the data being dragged) when the drag operation completes, either when you drop the dragged data onto a drop target or when you end the drag-and-drop operation without performing a drop."),
                @JSFJspProperty(name="dragDrop", returnType="java.lang.String", longDesc="Dispatched by the drop target when the user releases the mouse over it."),
                @JSFJspProperty(name="dragEnter", returnType="java.lang.String", longDesc="Dispatched by a component when the user moves the mouse over the component during a drag operation."),
                @JSFJspProperty(name="dragExit", returnType="java.lang.String", longDesc="Dispatched by the component when the user drags outside the component, but does not drop the data onto the target."),
                @JSFJspProperty(name="dragOver", returnType="java.lang.String", longDesc="Dispatched by a component when the user moves the mouse while over the component during a drag operation.")
        }
)
@JSFComponent
public interface _MXMLUIBaseAttributes {
	
	/**
	 * Id of the component.
	 */
    @JSFProperty(
            inheritTag  =   true,
            desc        =   "Id of the component."
    )
	String getId();
	
}
