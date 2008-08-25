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
import javax.faces.el.ValueBinding;
import javax.servlet.http.HttpServletRequest;

/**
 * This class will process the needed actions of setting and retrieving of "selected" attribute<br>
 * within the Flex components. Note that since this class invokes the super method of getComponentValues<br>
 * it will also set and retrieve values of "text" attribute of the component [if it exists].<br>
 * 
 * @author Ji Hoon Kim
 */ 
public abstract class MXMLUIButtonBase 
							extends MXMLUIInputBase {
	
	private static final String SELECTED_ID_APPENDED = "_selected";
	private static final String SELECTED_ATTR = "selected";
	
	public Map getComponentValues(){
		super.getComponentValues();
		_componentValues.put(SELECTED_ATTR, getSelected());
		return _componentValues;
    }
	
	public void decode(FacesContext context) {
    	super.decode(context);
    	
    	HttpServletRequest httpRequest = (HttpServletRequest) context.getExternalContext().getRequest();
    	
    	String selectedId = getId() + SELECTED_ID_APPENDED;
    	String selectedUpdateVal = httpRequest.getParameter(selectedId);
    	
    	if(selectedUpdateVal != null){
    		setSelected(Boolean.valueOf(selectedUpdateVal));
    		setSubmittedValue(Boolean.valueOf(selectedUpdateVal));
    	}
    	
    }
	
	public void processUpdates(FacesContext context) {
    	super.processUpdates(context);
    	
    	if (!isRendered() || !isValid()){
    		return;
    	}
    	
    	ValueBinding vb = getValueBinding(SELECTED_ATTR);
		if(vb != null && !vb.isReadOnly(getFacesContext())){
			vb.setValue(getFacesContext(), getSelected());
			setSelected(null);
		}
    	
    }
	
	public abstract Boolean getSelected();
	
	public abstract void setSelected(Boolean selected);
	
}
