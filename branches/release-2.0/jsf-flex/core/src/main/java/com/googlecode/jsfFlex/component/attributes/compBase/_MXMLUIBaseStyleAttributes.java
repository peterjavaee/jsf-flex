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
                @JSFJspProperty(name="bottom", returnType="java.lang.String", longDesc="The vertical distance in pixels from the lower edge of the component to the lower edge of its parent container."),
                @JSFJspProperty(name="errorColor", returnType="java.lang.String", longDesc="Color of the component highlight when validation fails."),
                @JSFJspProperty(name="focusBlendMode", returnType="java.lang.String", longDesc="Blend mode used by the focus rectangle."),
                @JSFJspProperty(name="focusSkin", returnType="java.lang.String", longDesc="Skin used to draw the focus rectangle."),
                @JSFJspProperty(name="focusThickness", returnType="java.lang.String", longDesc="Thickness, in pixels, of the focus rectangle outline."),
                @JSFJspProperty(name="horizontalCenter", returnType="java.lang.String", longDesc="The horizontal distance in pixels from the center of the component's parent container to the center of the component."),
                @JSFJspProperty(name="left", returnType="java.lang.String", longDesc="The horizontal distance in pixels from the left edge of the component's parent container to the left edge of the component."),
                @JSFJspProperty(name="right", returnType="java.lang.String", longDesc="The horizontal distance in pixels from the right edge of the component to the right edge of its parent container."),
                @JSFJspProperty(name="themeColor", returnType="java.lang.String", longDesc="Theme color of a component."),
                @JSFJspProperty(name="top", returnType="java.lang.String", longDesc="The vertical distance in pixels from the top edge of the component's parent container to the top edge of the component."),
                @JSFJspProperty(name="verticalCenter", returnType="java.lang.String", longDesc="The vertical distance in pixels from the center of the component's parent container to the center of the component.")
        }
)
@JSFComponent
public interface _MXMLUIBaseStyleAttributes {
	
}
