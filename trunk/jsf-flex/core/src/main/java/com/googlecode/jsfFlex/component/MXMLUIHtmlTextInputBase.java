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
import javax.faces.el.ValueBinding;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.json.JSONObject;

import com.googlecode.jsfFlex.util.MXMLJsfUtil;

/**
 * This class will process the needed actions of setting and retrieving of "htmlText" attribute<br>
 * within the Flex components. Note that since this class invokes the super method of populateComponentInitValues<br>
 * it will also set and retrieve values of "text" attribute of the component [if it exists].<br>
 * 
 * @author Ji Hoon Kim
 */ 
public abstract class MXMLUIHtmlTextInputBase extends MXMLUITextInputBase {
	
	private final static Log _log = LogFactory.getLog(MXMLUIHtmlTextInputBase.class);
	
	private static final String HTML_TEXT_ATTR = "htmlText";
	private static final String HTML_TEXT_ID_APPENDED = "_htmlText";
	
	private JSONObject initValue;
	
	{
		try{
			initValue = new JSONObject();
			initValue.put(ATTRIBUTE, HTML_TEXT_ATTR);
			
			_initValues.put(initValue);
			
		}catch(JSONException jsonException){
			_log.info("Error while formatting to JSON content", jsonException);
		}
	}
	
	protected void populateComponentInitValues(){
		super.populateComponentInitValues();
		
		try{
			if(getTextBinding().equals(HTML_TEXT_ATTR) && getHtmlText() != null){
				initValue.put(VALUE, MXMLJsfUtil.escapeCharacters( getHtmlText() ));
			}
		}catch(JSONException jsonException){
			_log.info("Error while formatting to JSON content", jsonException);
		}
	}
    
    public void decode(FacesContext context) {
    	super.decode(context);
    	
    	HttpServletRequest httpRequest = (HttpServletRequest) context.getExternalContext().getRequest();
    	/*
    	 * since there exists two possible returned values [text and htmlText],
    	 * the attribute will be appended to the id [i.e. id_text and id_htmlText]
    	 */
    	
    	String htmlTextId = getId() + HTML_TEXT_ID_APPENDED;
    	String htmlTextUpdateVal = httpRequest.getParameter(htmlTextId);
    	
    	if(htmlTextUpdateVal != null){
    		setHtmlText(htmlTextUpdateVal);
    	}
    	
    	if(getTextBinding().equals(HTML_TEXT_ATTR)){
    		setSubmittedValue(getHtmlText());
    	}
    	
    }
    
    public void processUpdates(FacesContext context) {
    	super.processUpdates(context);
    	
    	if (!isRendered() || !isValid()){
    		return;
    	}
    	
    	ValueBinding vb = getValueBinding(HTML_TEXT_ATTR);
		if(vb != null && !vb.isReadOnly(getFacesContext())){
			vb.setValue(getFacesContext(), getHtmlText());
			setHtmlText(null);
		}
    	
    }
	
	public abstract String getHtmlText();
    
	public abstract void setHtmlText(String htmlText);
    
	public abstract String getTextBinding();
	
}
