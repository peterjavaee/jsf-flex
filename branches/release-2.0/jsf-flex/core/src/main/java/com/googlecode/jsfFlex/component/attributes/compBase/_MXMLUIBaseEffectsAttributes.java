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
                @JSFJspProperty(name="addedEffect", returnType="java.lang.String", longDesc="Played when the component is added as a child to a Container."),
                @JSFJspProperty(name="hideEffect", returnType="java.lang.String", longDesc="Played when the component becomes invisible."),
                @JSFJspProperty(name="removedEffect", returnType="java.lang.String", longDesc="Played when the component is removed from a Container."),
                @JSFJspProperty(name="resizeEffect", returnType="java.lang.String", longDesc="Played when the component is resized."),
                @JSFJspProperty(name="rollOutEffect", returnType="java.lang.String", longDesc="Played when the user rolls the mouse so it is no longer over the component."),
                @JSFJspProperty(name="rollOverEffect", returnType="java.lang.String", longDesc="Played when the user rolls the mouse over the component."),
                @JSFJspProperty(name="showEffect", returnType="java.lang.String", longDesc="Played when the component becomes visible.")
        }
)
@JSFComponent
public interface _MXMLUIBaseEffectsAttributes {
	
}
