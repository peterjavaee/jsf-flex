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
package com.googlecode.jsfFlex.renderkit.mxml;

import java.io.IOException;

import javax.faces.application.StateManager.SerializedView;
import javax.faces.context.FacesContext;
import javax.faces.render.ResponseStateManager;

/**
 * @author Ji Hoon Kim
 */
class MXMLResponseStateManagerImpl extends AbstractMXMLResponseStateManager {
    
    private static final String MXML_RESPONSE_STATE_MANAGER_BASE_IMPL = "org.apache.myfaces.renderkit.html.HtmlResponseStateManager";
    private static final Class MXML_RESPONSE_STATE_MANAGER_BASE_IMPLEMENTOR_CLASS;
    
    private final ResponseStateManager _mxmlResponseStateManagerBaseImplementor;
    
    static{
        try{
            MXML_RESPONSE_STATE_MANAGER_BASE_IMPLEMENTOR_CLASS = Class.forName(MXML_RESPONSE_STATE_MANAGER_BASE_IMPL, false, Thread.currentThread().getContextClassLoader());
        }catch(ClassNotFoundException classNotFound){
            throw new RuntimeException("Failure in retrieving the class for " + MXML_RESPONSE_STATE_MANAGER_BASE_IMPL, classNotFound);
        }
    }
    
    MXMLResponseStateManagerImpl(){
        super();
        
        try{
            _mxmlResponseStateManagerBaseImplementor = (ResponseStateManager) MXML_RESPONSE_STATE_MANAGER_BASE_IMPLEMENTOR_CLASS.newInstance();
        }catch(Exception instantiatingException){
            throw new RuntimeException("Failure in instantiating a class for " + MXML_RESPONSE_STATE_MANAGER_BASE_IMPL, instantiatingException);
        }
        
    }
    
    public Object getComponentStateToRestore(FacesContext context) {
        return _mxmlResponseStateManagerBaseImplementor.getComponentStateToRestore(context);
    }
    
    public Object getState(FacesContext context, String viewId) {
        return _mxmlResponseStateManagerBaseImplementor.getState(context, viewId);
    }
    
    public Object getTreeStructureToRestore(FacesContext context, String viewId) {
        return _mxmlResponseStateManagerBaseImplementor.getTreeStructureToRestore(context, viewId);
    }
    
    public boolean isPostback(FacesContext context) {
        return _mxmlResponseStateManagerBaseImplementor.isPostback(context);
    }
    
    public void writeState(FacesContext context, Object state) throws IOException {
        _mxmlResponseStateManagerBaseImplementor.writeState(context, state);
    }
    
    public void writeState(FacesContext context, SerializedView serializedView) throws IOException {
        _mxmlResponseStateManagerBaseImplementor.writeState(context, serializedView);
    }
    
}
