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
package com.googlecode.jsfFlex.shared.model.event;

import com.googlecode.jsfFlex.shared.util.MXMLConstants;

/**
 * @author Ji Hoon Kim
 */
public abstract class Event {
    
    private final String _sourceComponentId;
    private final String _targetComponentId;
    
    Event(){
        super();
        
        _sourceComponentId = null;
        _targetComponentId = null;
    }
    
    public Event(String sourceComponentId, String targetComponentId){
        super();
        
        _sourceComponentId = sourceComponentId;
        _targetComponentId = targetComponentId;
    }
    
    @Override
    public boolean equals(Object instance) {
        if(!(instance instanceof Event)){
            return false;
        }
        
        Event currInstance = Event.class.cast( instance );
        boolean equals = _sourceComponentId.equals(currInstance._sourceComponentId);
        
        if(equals){
            equals = _targetComponentId.equals(currInstance._targetComponentId);
        }
        
        return equals;
    }
    
    @Override
    public int hashCode() {
        int hashCodeVal = MXMLConstants.HASH_CODE_INIT_VALUE;
        hashCodeVal = MXMLConstants.HASH_CODE_MULTIPLY_VALUE * hashCodeVal + _sourceComponentId.hashCode();
        hashCodeVal = MXMLConstants.HASH_CODE_MULTIPLY_VALUE * hashCodeVal + _targetComponentId.hashCode();
        
        return hashCodeVal;
    }
    
    public String getSourceComponentId(){
        return _sourceComponentId;
    }
    
    public String getTargetComponentId(){
        return _targetComponentId;
    }
    
}
