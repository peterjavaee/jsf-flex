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
package com.googlecode.jsfFlex.validator.ext;

import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFComponent;
import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFJspProperties;
import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFJspProperty;

/**
 * @author Ji Hoon Kim
 */
@JSFJspProperties(
        properties={
                @JSFJspProperty(name="enabled", returnType="java.lang.String", longDesc="Setting this value to false will stop the validator from performing validation."),
                @JSFJspProperty(name="listener", returnType="java.lang.String", longDesc="Specifies the validation listener."),
                @JSFJspProperty(name="property", returnType="java.lang.String", longDesc="A String specifying the name of the property of the source object that contains the value to validate."),
                @JSFJspProperty(name="required", returnType="java.lang.String", longDesc="If true, specifies that a missing or empty value causes a validation error."),
                @JSFJspProperty(name="requiredFieldError", returnType="java.lang.String", longDesc="Error message when a value is missing and the required property is true."),
                @JSFJspProperty(name="source", returnType="java.lang.String", longDesc="Specifies the object containing the property to validate."),
                @JSFJspProperty(name="trigger", returnType="java.lang.String", longDesc="Specifies the component generating the event that triggers the validator."),
                @JSFJspProperty(name="triggerEvent", returnType="java.lang.String", longDesc="Specifies the event that triggers the validation.")
        }
)
@JSFComponent
interface _MXMLUIValidatorAttributes {
	
}
