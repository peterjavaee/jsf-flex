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
                @JSFJspProperty(name="autoLayout", returnType="java.lang.String", longDesc="If true, measurement and layout are done when the position or size of a child is changed."),
                @JSFJspProperty(name="clipContent", returnType="java.lang.String", longDesc="Whether to apply a clip mask if the positions and/or sizes of this container's children extend outside the borders of this container."),
                @JSFJspProperty(name="creationIndex", returnType="java.lang.String", longDesc="Specifies the order to instantiate and draw the children of the container."),
                @JSFJspProperty(name="defaultButton", returnType="java.lang.String", longDesc="The Button control designated as the default button for the container."),
                @JSFJspProperty(name="horizontalLineScrollSize", returnType="java.lang.String", longDesc="Number of pixels to move when the left- or right-arrow button in the horizontalscroll bar is pressed."),
                @JSFJspProperty(name="horizontalPageScrollSize", returnType="java.lang.String", longDesc="Number of pixels to move when the track in the horizontal scroll bar is pressed."),
                @JSFJspProperty(name="horizontalScrollBar", returnType="java.lang.String", longDesc="The horizontal scrollbar used in this container."),
                @JSFJspProperty(name="verticalLineScrollSize", returnType="java.lang.String", longDesc="Number of pixels to scroll when the up- or down-arrow button in the verticalscroll bar is pressed."),
                @JSFJspProperty(name="verticalPageScrollSize", returnType="java.lang.String", longDesc="Number of pixels to scroll when the track in the vertical scroll bar is pressed."),
                @JSFJspProperty(name="verticalScrollBar", returnType="java.lang.String", longDesc="The vertical scrollbar used in this container."),
                @JSFJspProperty(name="backgroundAttachment", returnType="java.lang.String", longDesc="If a background image is specified, this style specifies whether it is fixed with regard to the viewport (fixed) or scrolls along with the content (scroll).The default value is scroll."),
                @JSFJspProperty(name="disabledOverlayAlpha", returnType="java.lang.String", longDesc="The alpha value for the overlay that is placed on top of the container when it is disabled."),
                @JSFJspProperty(name="childAdd", returnType="java.lang.String", longDesc="Dispatched after a child has been added to a container."),
                @JSFJspProperty(name="childIndexChange", returnType="java.lang.String", longDesc="Dispatched after the index (among the container children) of a container child changes."),
                @JSFJspProperty(name="childRemove", returnType="java.lang.String", longDesc="Dispatched before a child of a container is removed.")
        }
)
@JSFComponent
public interface _MXMLUIContainerAttributes {
	
    /**
     * The child creation policy for this Container.
     */
    @JSFProperty(
            required        =   false,
            rtexprvalue     =   false,
            desc            =   "The child creation policy for this Container."
    )
    String getCreationPolicy();
    
    void setCreationPolicy(String creationPolicy);
    
}
