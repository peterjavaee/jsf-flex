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
package com.googlecode.jsfFlex.component.ext;

import javax.faces.context.FacesContext;

import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFComponent;

import com.googlecode.jsfFlex.component.MXMLUICommandBase;
import com.googlecode.jsfFlex.shared.adapter._MXMLEvent;
import com.googlecode.jsfFlex.shared.util.MXMLJsfUtil;

/**
 * @author Ji Hoon Kim
 */
@JSFComponent(
        name                =   "jf:mxmlLinkButton",
        clazz               =   "com.googlecode.jsfFlex.component.ext.MXMLUILinkButton",
        type                =   "com.googlecode.jsfFlex.MXMLUILinkButton",
        tagClass            =   "com.googlecode.jsfFlex.taglib.component.ext.MXMLUILinkButtonTag",
        family              =   "javax.faces.MXMLCommandBase",
        defaultRendererType =   "com.googlecode.jsfFlex.MXMLLinkButton"
)
public abstract class AbstractMXMLUILinkButton 
						extends MXMLUICommandBase 
						implements _MXMLUIButtonAttributes {

    private static final String EVENT_HANDLER_EVENT_NAME = "buttonDown";
    
    public String getEventHandlerSrcId() {
        return getId();
    }
    
    public String getEventHandlerTgtId() {
        FacesContext currInstance = FacesContext.getCurrentInstance();
        return MXMLJsfUtil.retrieveFormId(getClientId(currInstance));
    }
    
    public _MXMLEvent.EVENT_HANDLER_TYPE getEventHandlerType() {
        return _MXMLEvent.EVENT_HANDLER_TYPE.SUBMIT_FORM_EVENT_HANDLER;
    }
    
    public String getEventHandlerEventName() {
        return EVENT_HANDLER_EVENT_NAME;
    }
    
}