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
package com.googlecode.jsfFlex.shared.adapter;

import java.util.EnumSet;

/**
 * @author Ji Hoon Kim
 */
public interface IFlexEvent {
    
    public enum EVENT_HANDLER_TYPE {
        SUBMIT_FORM_EVENT_HANDLER("SubmitFormEventHandler", EnumSet.of(ACTION_SCRIPT_IMPORT.SUBMIT_FORM_EVENT_HANDLER_AS, 
                ACTION_SCRIPT_IMPORT.ABSTRACT_EVENT_HANDLER_AS), EnumSet.of(JAVA_SCRIPT_IMPORT.JSF_FLEX_COMMUNICATOR_EVENT_JS)),
        DATA_UPDATE_EVENT_HANDLER("DataUpdateEventHandler", EnumSet.of(ACTION_SCRIPT_IMPORT.DATA_UPDATE_EVENT_HANDLER_AS, 
                ACTION_SCRIPT_IMPORT.ABSTRACT_EVENT_HANDLER_AS), EnumSet.noneOf(JAVA_SCRIPT_IMPORT.class));
        
        private final String _actionScriptConstructor;
        private final EnumSet<ACTION_SCRIPT_IMPORT> _actionScriptImports;
        private final EnumSet<JAVA_SCRIPT_IMPORT> _javaScriptImports;
        
        private EVENT_HANDLER_TYPE(String actionScriptConstructor, EnumSet<ACTION_SCRIPT_IMPORT> actionScriptImports,
                                        EnumSet<JAVA_SCRIPT_IMPORT> javaScriptImports){
            _actionScriptConstructor = actionScriptConstructor;
            _actionScriptImports = actionScriptImports;
            _javaScriptImports = javaScriptImports;
        }
        
        public String getActionScriptConstructor(){
            return _actionScriptConstructor;
        }
        
        public EnumSet<ACTION_SCRIPT_IMPORT> getActionScriptImports(){
            return _actionScriptImports;
        }
        
        public EnumSet<JAVA_SCRIPT_IMPORT> getJavaScriptImports(){
            return _javaScriptImports;
        }
        
        public enum ACTION_SCRIPT_IMPORT {
            
            ABSTRACT_EVENT_HANDLER_AS("com.googlecode.jsfFlex.communication.event.AbstractEventHandler"),
            DATA_UPDATE_EVENT_HANDLER_AS("com.googlecode.jsfFlex.communication.event.DataUpdateEventHandler"),
            SUBMIT_FORM_EVENT_HANDLER_AS("com.googlecode.jsfFlex.communication.event.SubmitFormEventHandler");
            
            private final String _actionScriptImport;
            
            private ACTION_SCRIPT_IMPORT(String actionScriptImport){
                _actionScriptImport = actionScriptImport;
            }
            
            public String getActionScriptImport(){
                return _actionScriptImport;
            }
        }
        
        public enum JAVA_SCRIPT_IMPORT {
            
            JSF_FLEX_COMMUNICATOR_EVENT_JS("jsfFlexCommunicatorEvent.js");
            
            private final String _javaScriptImport;
            
            private JAVA_SCRIPT_IMPORT(String javaScriptImport){
                _javaScriptImport = javaScriptImport;
            }
            
            public String getJavaScriptImport(){
                return _javaScriptImport;
            }
            
        }
    }
    
    String getEventHandlerSrcId();
    
    String getEventHandlerTgtId();
    
    String getEventHandlerId();
    
    EVENT_HANDLER_TYPE getEventHandlerType();
    
    String getEventHandlerEventName();
    
}
