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
                @JSFJspProperty(name="lineScrollSize", returnType="java.lang.String", longDesc="Amount to scroll when an arrow button is pressed, in pixels."),
                @JSFJspProperty(name="maxScrollPosition", returnType="java.lang.String", longDesc="Number which represents the maximum scroll position."),
                @JSFJspProperty(name="minScrollPosition", returnType="java.lang.String", longDesc="Number that represents the minimum scroll position."),
                @JSFJspProperty(name="pageScrollSize", returnType="java.lang.String", longDesc="Amount to move the scroll thumb when the scroll bar track is pressed, in pixels."),
                @JSFJspProperty(name="pageSize", returnType="java.lang.String", longDesc="The number of lines equivalent to one page."),
                @JSFJspProperty(name="scrollPosition", returnType="java.lang.String", longDesc="Number that represents the current scroll position."),
                @JSFJspProperty(name="thumbIcon", returnType="java.lang.String", longDesc="Name of the class to use as the icon for the thumb of the scroll bar.")
        }
)
@JSFComponent
public interface _MXMLUIScrollBarAttributes {
	
}
