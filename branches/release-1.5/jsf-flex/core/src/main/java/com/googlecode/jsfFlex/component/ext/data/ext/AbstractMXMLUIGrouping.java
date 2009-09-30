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
package com.googlecode.jsfFlex.component.ext.data.ext;

import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFComponent;
import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFProperty;

import com.googlecode.jsfFlex.attributes._MXMLUICompareFunctionAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIFieldsAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIGroupingObjectFunctionAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUILabelAttribute;
import com.googlecode.jsfFlex.component.MXMLUISimpleBase;

/**
 * @author Ji Hoon Kim
 */
@JSFComponent(
        name                =   "jf:mxmlGrouping",
        clazz               =   "com.googlecode.jsfFlex.component.ext.data.ext.MXMLUIGrouping",
        type                =   "com.googlecode.jsfFlex.MXMLUIGrouping",
        tagClass            =   "com.googlecode.jsfFlex.taglib.ext.data.MXMLUIGroupingTag",
        family              =   "javax.faces.MXMLSimple",
        defaultRendererType =   "com.googlecode.jsfFlex.MXMLGrouping"
)
public abstract class AbstractMXMLUIGrouping 
                            extends MXMLUISimpleBase 
                            implements _MXMLUICompareFunctionAttribute, _MXMLUIFieldsAttribute, _MXMLUIGroupingObjectFunctionAttribute, 
                            _MXMLUILabelAttribute {
    
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
