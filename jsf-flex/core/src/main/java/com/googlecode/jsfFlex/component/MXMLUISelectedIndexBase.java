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

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;
import javax.faces.convert.IntegerConverter;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class will process the needed actions of setting and retrieving of "selectedIndex" attribute<br>
 * within the Flex components.<br>
 * 
 * @author Ji Hoon Kim
 */
public abstract class MXMLUISelectedIndexBase extends MXMLUIInputBase {
	
	private final static Log _log = LogFactory.getLog(MXMLUISelectedIndexBase.class);
	
	private static final IntegerConverter INTEGER_CONVERTER = new IntegerConverter();
	
	private static final String SELECTED_INDEX_ID_APPENDED = "_selectedIndex";
	private static final String SELECTED_INDEX_ATTR = "selectedIndex";
	
	private JSONObject initValue;
	
	{
		try{
			initValue = new JSONObject();
			initValue.put(ATTRIBUTE, SELECTED_INDEX_ATTR);
			
			_initValues.put(initValue);
			
		}catch(JSONException jsonException){
			_log.info("Error while formatting to JSON content", jsonException);
		}
	}
	
	protected void populateComponentInitValues(){
		try{
			if(getSelectedIndex() != null){
				initValue.put(VALUE, getSelectedIndex());
			}
		}catch(JSONException jsonException){
			_log.info("Error while formatting to JSON content", jsonException);
		}
	}
	
	public void decode(FacesContext context) {
    	super.decode(context);
    	
    	HttpServletRequest httpRequest = (HttpServletRequest) context.getExternalContext().getRequest();
    	
    	String selectedIndexId = getId() + SELECTED_INDEX_ID_APPENDED;
    	String selectedIndexUpdateVal = httpRequest.getParameter(selectedIndexId);
    	
    	if(selectedIndexUpdateVal != null){
    		setSelectedIndex(Integer.valueOf(selectedIndexUpdateVal));
    		setSubmittedValue(selectedIndexUpdateVal);
    	}

    }
	
	public void processUpdates(FacesContext context) {
    	super.processUpdates(context);
    	
    	if (!isRendered() || !isValid()){
    		return;
    	}
    	
    	ValueExpression ve = getValueExpression(SELECTED_INDEX_ATTR);
    	
    	if(ve != null && !ve.isReadOnly(context.getELContext())){
    		ve.setValue(context.getELContext(), getSelectedIndex());
    		setSelectedIndex(null);
    	}
    	
    }
	
	protected Object getConvertedValue(FacesContext context, Object submittedValue) {
		if(!(submittedValue instanceof String)){
			return submittedValue;
		}
		
		return INTEGER_CONVERTER.getAsObject(context, this, (String) submittedValue);
	}
	
	public abstract Integer getSelectedIndex();
	
	public abstract void setSelectedIndex(Integer selectedIndex);
	
}