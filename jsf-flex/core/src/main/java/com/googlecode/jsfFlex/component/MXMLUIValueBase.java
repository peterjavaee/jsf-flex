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
package com.googlecode.jsfFlex.component;

import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Ji Hoon Kim
 */ 
public abstract class MXMLUIValueBase 
				extends MXMLUIInputBase {
	
	private static final String VALUE_ID_APPENDED = "_value";
	
	public Map getComponentValues() {
		_componentValues.put("value", getValue() == null ? null : (String) getValue());
		return super.getComponentValues();
	}
	
	public void decode(FacesContext context) {
    	super.decode(context);
    	
    	HttpServletRequest httpRequest = (HttpServletRequest) context.getExternalContext().getRequest();
    	
    	String valueId = getId() + VALUE_ID_APPENDED;
    	String valueUpdateVal = httpRequest.getParameter(valueId);
    	
    	if(valueUpdateVal != null){
    		setValue(valueUpdateVal);
    		setSubmittedValue(valueUpdateVal);
    	}
    	
    }
	
}
