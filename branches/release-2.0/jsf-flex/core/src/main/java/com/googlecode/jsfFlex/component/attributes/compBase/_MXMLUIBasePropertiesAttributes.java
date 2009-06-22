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
                @JSFJspProperty(name="cachePolicy", returnType="java.lang.String", longDesc="Specifies the bitmap caching policy for this object."),
                @JSFJspProperty(name="currentState", returnType="java.lang.String", longDesc="The current view state of the component."),
                @JSFJspProperty(name="doubleClickEnabled", returnType="java.lang.String", longDesc="Specifies whether the UIComponent object receives doubleClick events."),
                @JSFJspProperty(name="enabled", returnType="java.lang.String", longDesc="Whether the component can accept user interaction."),
                @JSFJspProperty(name="explicitHeight", returnType="java.lang.String", longDesc="Number that specifies the explicit height of the component, in pixels, in the component's coordinates."),
                @JSFJspProperty(name="explicitMaxHeight", returnType="java.lang.String", longDesc="Number that specifies the maximum height of the component, in pixels, in the component's coordinates."),
                @JSFJspProperty(name="explicitMaxWidth", returnType="java.lang.String", longDesc="Number that specifies the maximum width of the component, in pixels, in the component's coordinates."),
                @JSFJspProperty(name="explicitMinHeight", returnType="java.lang.String", longDesc="Number that specifies the minimum height of the component, in pixels, in the component's coordinates."),
                @JSFJspProperty(name="explicitMinWidth", returnType="java.lang.String", longDesc="Number that specifies the minimum width of the component, in pixels, in the component's coordinates."),
                @JSFJspProperty(name="explicitWidth", returnType="java.lang.String", longDesc="Number that specifies the explicit width of the component, in pixels, in the component's coordinates."),
                @JSFJspProperty(name="focusEnabled", returnType="java.lang.String", longDesc="Indicates whether the component can receive focus when clicked on."),
                @JSFJspProperty(name="includeInLayout", returnType="java.lang.String", longDesc="Specifies whether this component is included in the layout of the parent container."),
                @JSFJspProperty(name="maxHeight", returnType="java.lang.String", longDesc="Number that specifies the maximum height of the component, in pixels, in the component's coordinates."),
                @JSFJspProperty(name="maxWidth", returnType="java.lang.String", longDesc="Number that specifies the maximum width of the component, in pixels, in the component's coordinates."),
                @JSFJspProperty(name="measuredHeight", returnType="java.lang.String", longDesc="The default height of the component, in pixels."),
                @JSFJspProperty(name="measuredMinHeight", returnType="java.lang.String", longDesc="The default minimum height of the component, in pixels."),
                @JSFJspProperty(name="measuredMinWidth", returnType="java.lang.String", longDesc="The default minimum width of the component, in pixels."),
                @JSFJspProperty(name="measuredWidth", returnType="java.lang.String", longDesc="The default width of the component, in pixels."),
                @JSFJspProperty(name="minHeight", returnType="java.lang.String", longDesc="Number that specifies the minimum height of the component, in pixels, in the component's coordinates."),
                @JSFJspProperty(name="minWidth", returnType="java.lang.String", longDesc="Number that specifies the minimum width of the component, in pixels, in the component's coordinates."),
                @JSFJspProperty(name="mouseFocusEnabled", returnType="java.lang.String", longDesc="Whether you can receive focus when clicked on."),
                @JSFJspProperty(name="percentHeight", returnType="java.lang.String", longDesc="Number that specifies the height of a component as a percentage of its parent's size."),
                @JSFJspProperty(name="percentWidth", returnType="java.lang.String", longDesc="Number that specifies the width of a component as a percentage of its parent's size."),
                @JSFJspProperty(name="scaleX", returnType="java.lang.String", longDesc="Number that specifies the horizontal scaling factor."),
                @JSFJspProperty(name="scaleY", returnType="java.lang.String", longDesc="Number that specifies the vertical scaling percentage."),
                @JSFJspProperty(name="states", returnType="java.lang.String", longDesc="The view states that are defined for this component."),
                @JSFJspProperty(name="toolTip", returnType="java.lang.String", longDesc="Text to display in the ToolTip."),
                @JSFJspProperty(name="transitions", returnType="java.lang.String", longDesc="An Array of Transition objects, where each Transition object defines a set of effects to play when a view state change occurs."),
                @JSFJspProperty(name="validationSubField", returnType="java.lang.String", longDesc="Used by a validator to associate a subfield with this component.")
        }
)
@JSFComponent
public interface _MXMLUIBasePropertiesAttributes {
	
}
