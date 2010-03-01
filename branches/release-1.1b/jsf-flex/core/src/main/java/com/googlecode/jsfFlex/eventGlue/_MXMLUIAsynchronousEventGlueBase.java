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
package com.googlecode.jsfFlex.eventGlue;

import java.io.IOException;
import java.util.EnumSet;

import javax.faces.context.FacesContext;

import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFComponent;
import org.json.JSONException;
import org.json.JSONObject;

import com.googlecode.jsfFlex.attributes._MXMLUIAsynchronousEventGlueHandler;
import com.googlecode.jsfFlex.attributes._MXMLUIEventListener;
import com.googlecode.jsfFlex.attributes._MXMLUITargetComponentId;
import com.googlecode.jsfFlex.component.MXMLUISimpleBase;
import com.googlecode.jsfFlex.renderkit.html.util.JsfFlexResource;
import com.googlecode.jsfFlex.shared.adapter._MXMLEvent;
import com.googlecode.jsfFlex.shared.adapter._MXMLEvent.EVENT_HANDLER_TYPE.JAVA_SCRIPT_IMPORT;
import com.googlecode.jsfFlex.shared.context.MxmlContext;
import com.googlecode.jsfFlex.shared.util.MXMLJsfUtil;

/**
 * @author Ji Hoon Kim
 */
@JSFComponent(
        type    =   "com.googlecode.jsfFlex.MXMLUIAsynchronousEventGlueBase",
        family  =   "javax.faces.MXMLUIAsynchronousEventGlueBase",
        desc    =   "Base component for MXMLAsynchronousEventGlue components."
)
public abstract class _MXMLUIAsynchronousEventGlueBase 
                            extends MXMLUISimpleBase 
                            implements _MXMLEvent, _MXMLUIAsynchronousEventGlueHandler, _MXMLUIEventListener, 
                            _MXMLUITargetComponentId {
    
    public abstract JSONObject processRequest() throws JSONException;
    
    public void encodeBegin(FacesContext context) throws IOException {
        
        MxmlContext mxmlContext = MxmlContext.getCurrentInstance();
        
        if(mxmlContext.isProductionEnv()){
            //means no need to create preMxml files
            setRendered(false);
        }
        
        if(getAsynchronousEventGlueHandler() != null){
            EVENT_HANDLER_TYPE eventHandlerType = getEventHandlerType();
            JsfFlexResource jsfFlexResource = JsfFlexResource.getInstance();
            EnumSet<JAVA_SCRIPT_IMPORT> javaScriptImports = eventHandlerType.getJavaScriptImports();
            
            for(JAVA_SCRIPT_IMPORT currJSImport : javaScriptImports){
                jsfFlexResource.addResource(getClass(), currJSImport.getJavaScriptImport());
            }
        }
        
        super.encodeBegin(context);
    }
    
    public String getEventHandlerSrcId() {
        return getId();
    }
    
    public String getEventHandlerTgtId() {
        FacesContext currInstance = FacesContext.getCurrentInstance();
        return MXMLJsfUtil.retrieveFormId(getClientId(currInstance));
    }
    
}
