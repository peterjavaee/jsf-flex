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
package com.googlecode.jsfFlex.renderkit.eventGlue;

import java.io.IOException;
import java.util.EnumSet;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.render.Renderer;

import com.googlecode.jsfFlex.shared.adapter._MXMLEvent;
import com.googlecode.jsfFlex.shared.adapter._MXMLEvent.EVENT_HANDLER_TYPE;
import com.googlecode.jsfFlex.shared.adapter._MXMLEvent.EVENT_HANDLER_TYPE.ACTION_SCRIPT_IMPORT;
import com.googlecode.jsfFlex.shared.beans.additionalScriptContent.AdditionalApplicationScriptContent;
import com.googlecode.jsfFlex.shared.context.MxmlContext;

/**
 * @author Ji Hoon Kim
 */
public abstract class MXMLAsynchronousEventGlueTemplateRenderer extends Renderer {
    
    @Override
    public void encodeBegin(FacesContext context, UIComponent componentObj) throws IOException {
        super.encodeBegin(context, componentObj);
        
        MxmlContext mxmlContext = MxmlContext.getCurrentInstance();
        
        _MXMLEvent mxmlEvent = _MXMLEvent.class.cast( componentObj );
        EVENT_HANDLER_TYPE eventHandlerType = mxmlEvent.getEventHandlerType();
        AdditionalApplicationScriptContent additionalApplicationScriptContent = mxmlContext.getAdditionalAppScriptContent();
        EnumSet<ACTION_SCRIPT_IMPORT> actionScriptImports = eventHandlerType.getActionScriptImports();
        
        for(ACTION_SCRIPT_IMPORT currASImport : actionScriptImports){
            additionalApplicationScriptContent.addActionScriptImport(currASImport.getActionScriptImport());
        }
        
        additionalApplicationScriptContent.addEventHandler(mxmlEvent.getEventHandlerSrcId(), mxmlEvent.getEventHandlerTgtId(), mxmlEvent.getEventHandlerId(),
                                                            mxmlEvent.getEventHandlerType(), mxmlEvent.getEventHandlerEventName());
        
    }
    
}
