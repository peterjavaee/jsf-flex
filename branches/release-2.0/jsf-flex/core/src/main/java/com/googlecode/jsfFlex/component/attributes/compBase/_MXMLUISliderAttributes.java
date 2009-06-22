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
                @JSFJspProperty(name="allowThumbOverlap", returnType="java.lang.String", longDesc="If set to false, then each thumb can only be moved to the edge of the adjacent thumb."),
                @JSFJspProperty(name="allowTrackClick", returnType="java.lang.String", longDesc="Specifies whether clicking on the track will move the slider thumb."),
                @JSFJspProperty(name="dataTipFormatFunction", returnType="java.lang.String", longDesc="Callback function that formats the data tip text."),
                @JSFJspProperty(name="labels", returnType="java.lang.String", longDesc="An array of strings used for the slider labels."),
                @JSFJspProperty(name="showDataTip", returnType="java.lang.String", longDesc="If set to true, show a data tip during user interaction containing the current value of the slider."),
                @JSFJspProperty(name="sliderDataTipClass", returnType="java.lang.String", longDesc="A reference to the class to use for the data tip."),
                @JSFJspProperty(name="sliderThumbClass", returnType="java.lang.String", longDesc="A reference to the class to use for each thumb."),
                @JSFJspProperty(name="snapInterval", returnType="java.lang.String", longDesc="Specifies the increment value of the slider thumb as the user moves the thumb."),
                @JSFJspProperty(name="thumbCount", returnType="java.lang.String", longDesc="The number of thumbs allowed on the slider."),
                @JSFJspProperty(name="tickInterval", returnType="java.lang.String", longDesc="The spacing of the tick marks relative to the maximum value of the control."),
                @JSFJspProperty(name="dataTipOffset", returnType="java.lang.String", longDesc="The offset, in pixels, of the data tip relative to the thumb."),
                @JSFJspProperty(name="dataTipPrecision", returnType="java.lang.String", longDesc="Number of decimal places to use for the data tip text."),
                @JSFJspProperty(name="dataTipStyleName", returnType="java.lang.String", longDesc="The name of the style declaration to use for the data tip."),
                @JSFJspProperty(name="labelOffset", returnType="java.lang.String", longDesc="The y-position offset (if direction is horizontal) or x-position offset (if direction is vertical) of the labels relative to the track."),
                @JSFJspProperty(name="labelStyleName", returnType="java.lang.String", longDesc="The name of the style to use for the slider label."),
                @JSFJspProperty(name="showTrackHighlight", returnType="java.lang.String", longDesc="Specifies whether to enable track highlighting between thumbs (or a single thumb and the beginning of the track)."),
                @JSFJspProperty(name="slideDuration", returnType="java.lang.String", longDesc="Duration in milliseconds for the sliding animation when you click on the track to move a thumb."),
                @JSFJspProperty(name="slideEasingFunction", returnType="java.lang.String", longDesc="Tweening function used by the sliding animation when you click on the track to move a thumb."),
                @JSFJspProperty(name="thumbDisabledSkin", returnType="java.lang.String", longDesc="The skin for the slider thumb disabled state."),
                @JSFJspProperty(name="thumbOffset", returnType="java.lang.String", longDesc="The y-position offset (if direction is horizontal) or x-position offset (if direction is vertical) of the thumb relative to the track."),
                @JSFJspProperty(name="tickColor", returnType="java.lang.String", longDesc="The color of the tick marks."),
                @JSFJspProperty(name="tickLength", returnType="java.lang.String", longDesc="The length in pixels of the tick marks."),
                @JSFJspProperty(name="tickOffset", returnType="java.lang.String", longDesc="The y-position offset (if direction is horizontal) or x-position offset (if direction is vertical) of the tick marks relative to the track."),
                @JSFJspProperty(name="tickThickness", returnType="java.lang.String", longDesc="The thickness in pixels of the tick marks."),
                @JSFJspProperty(name="trackHighlightSkin", returnType="java.lang.String", longDesc="The skin for the slider track when it is selected."),
                @JSFJspProperty(name="trackMargin", returnType="java.lang.String", longDesc="The size of the track margins, in pixels."),
                @JSFJspProperty(name="thumbDrag", returnType="java.lang.String", longDesc="Dispatched when the slider's thumb is pressed and then moved by the mouse."),
                @JSFJspProperty(name="thumbPress", returnType="java.lang.String", longDesc="Dispatched when the slider's thumb is pressed, meaning the user presses the mouse button over the thumb."),
                @JSFJspProperty(name="thumbRelease", returnType="java.lang.String", longDesc="Dispatched when the slider's thumb is released, meaning the user releases the mouse button after a thumbPress event.")
        }
)
@JSFComponent
public interface _MXMLUISliderAttributes {
	
}
