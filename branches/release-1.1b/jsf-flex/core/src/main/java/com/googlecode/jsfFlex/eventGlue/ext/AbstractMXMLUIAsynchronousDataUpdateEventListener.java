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
package com.googlecode.jsfFlex.eventGlue.ext;

import javax.faces.context.FacesContext;

import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFComponent;
import org.json.JSONException;
import org.json.JSONObject;

import com.googlecode.jsfFlex.attributes._MXMLUIAsynchronousEventGlueHandler;
import com.googlecode.jsfFlex.attributes._MXMLUIEventListener;
import com.googlecode.jsfFlex.attributes._MXMLUITargetComponentId;
import com.googlecode.jsfFlex.eventGlue._MXMLUIAsynchronousEventGlueBase;
import com.googlecode.jsfFlex.shared.adapter._MXMLEvent;
import com.googlecode.jsfFlex.shared.model.AsynchronousDataUpdateEventBean;

/**
 * @author Ji Hoon Kim
 */
@JSFComponent(
        name                =   "jf:mxmlAsynchronousDataUpdateEventListener",
        clazz               =   "com.googlecode.jsfFlex.eventGlue.ext.MXMLUIAsynchronousDataUpdateEventListener",
        type                =   "com.googlecode.jsfFlex.MXMLUIAsynchronousDataUpdateEventListener",
        tagClass            =   "com.googlecode.jsfFlex.taglib.eventGlue.ext.MXMLUIAsynchronousDataUpdateEventListenerTag",
        family              =   "javax.faces.MXMLEventListener",
        defaultRendererType =   "com.googlecode.jsfFlex.MXMLAsynchronousDataUpdateEventListener"
)
public abstract class AbstractMXMLUIAsynchronousDataUpdateEventListener 
                            extends _MXMLUIAsynchronousEventGlueBase 
                            implements _MXMLUIAsynchronousEventGlueHandler, _MXMLUIEventListener, _MXMLUITargetComponentId {
    
    private static final String DATA_UPDATE_VALUE_ATTR = "DATA_UPDATE_VALUE";
    
    public JSONObject processRequest() throws JSONException {
        
        FacesContext currContext = FacesContext.getCurrentInstance();
        javax.el.ELContext elContext = currContext.getELContext();
        String alteredValue = currContext.getExternalContext().getRequestParameterMap().get(DATA_UPDATE_VALUE_ATTR);
        
        Object[] arguments = new Object[]{getTargetComponentId(), alteredValue};
        Object methodResult = getAsynchronousEventGlueHandler().invoke(elContext, arguments);
        AsynchronousDataUpdateEventBean result = null;
        if(!(methodResult instanceof AsynchronousDataUpdateEventBean)){
            result = new AsynchronousDataUpdateEventBean(getId(), getTargetComponentId(), methodResult.toString());
        }else{
            result = AsynchronousDataUpdateEventBean.class.cast( methodResult );
        }
        
        return result.formatResponseToJSON();
    }
        
    public _MXMLEvent.EVENT_HANDLER_TYPE getEventHandlerType() {
        return _MXMLEvent.EVENT_HANDLER_TYPE.DATA_UPDATE_EVENT_HANDLER;
    }
    
    public String getEventHandlerEventName() {
        return getEventListener();
    }
    
}
