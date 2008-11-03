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

import javax.faces.context.FacesContext;
import javax.faces.convert.BooleanConverter;
import javax.faces.el.ValueBinding;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class will process the needed actions of setting and retrieving of "selected" attribute<br>
 * within the Flex components.<br>
 * 
 * @author Ji Hoon Kim
 */
public abstract class MXMLUISelectedBase extends MXMLUIInputBase {
	
	private final static Log _log = LogFactory.getLog(MXMLUISelectedBase.class);
	
	private static final BooleanConverter BOOLEAN_CONVERTER = new BooleanConverter();
	
	private static final String SELECTED_ID_APPENDED = "_selected";
	private static final String SELECTED_ATTR = "selected";
	
	private JSONObject initValue;
	
	{
		try{
			initValue = new JSONObject();
			initValue.put(ATTRIBUTE, SELECTED_ATTR);
			
			_initValues.put(initValue);
			
		}catch(JSONException jsonException){
			_log.info("Error while formatting to JSON content", jsonException);
		}
	}
	
	protected void populateComponentInitValues(){
		try{
			if(getSelected() != null){
				initValue.put(VALUE, getSelected());
			}
		}catch(JSONException jsonException){
			_log.info("Error while formatting to JSON content", jsonException);
		}
	}
	
	public void decode(FacesContext context) {
    	super.decode(context);
    	
    	HttpServletRequest httpRequest = (HttpServletRequest) context.getExternalContext().getRequest();
    	
    	String selectedId = getId() + SELECTED_ID_APPENDED;
    	String selectedUpdateVal = httpRequest.getParameter(selectedId);
    	
    	if(selectedUpdateVal != null){
    		setSelected(Boolean.valueOf(selectedUpdateVal));
    		setSubmittedValue(selectedUpdateVal);
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
	
	protected Object getConvertedValue(FacesContext context, Object submittedValue) {
		if(!(submittedValue instanceof String)){
			return submittedValue;
		}
		
		return BOOLEAN_CONVERTER.getAsObject(context, this, (String) submittedValue);
	}
	
	public abstract Boolean getSelected();
	
	public abstract void setSelected(Boolean selected);
	
}
