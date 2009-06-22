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
                @JSFJspProperty(name="creationComplete", returnType="java.lang.String", longDesc="Dispatched when the component has finished its construction, property processing, measuring, layout, and drawing.")
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
