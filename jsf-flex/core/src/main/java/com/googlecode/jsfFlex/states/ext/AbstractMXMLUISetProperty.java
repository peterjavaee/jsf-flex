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
package com.googlecode.jsfFlex.states.ext;

import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFComponent;
import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFProperty;

import com.googlecode.jsfFlex.attributes._MXMLUINameAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUITargetAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIValueAttribute;
import com.googlecode.jsfFlex.component.MXMLUISimpleBase;

/**
 * @author Ji Hoon Kim
 */
@JSFComponent(
        name                =   "jf:mxmlSetProperty",
        clazz               =   "com.googlecode.jsfFlex.states.ext.MXMLUISetProperty",
        type                =   "com.googlecode.jsfFlex.MXMLUISetProperty",
        tagClass            =   "com.googlecode.jsfFlex.taglib.states.ext.MXMLUISetPropertyTag",
        family              =   "javax.faces.MXMLSimple",
        defaultRendererType =   "com.googlecode.jsfFlex.MXMLSetProperty"
)
public abstract class AbstractMXMLUISetProperty 
						extends MXMLUISimpleBase 
                        implements _MXMLUINameAttribute, _MXMLUITargetAttribute, _MXMLUIValueAttribute {
	
	/**
	 * Id of the component.
	 */
    @JSFProperty(
            inheritTag  =   true,
            desc        =   "Id of the component."
    )
	public String getId(){
		return super.getId();
	}
	
}