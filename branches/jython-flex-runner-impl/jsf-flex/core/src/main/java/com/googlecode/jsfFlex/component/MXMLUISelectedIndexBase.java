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
import javax.faces.convert.IntegerConverter;
import javax.faces.el.ValueBinding;
import javax.servlet.http.HttpServletRequest;

/**
 * This class will process the needed actions of setting and retrieving of "selectedIndex" attribute<br>
 * within the Flex components. Note that since this class invokes the super method of getComponentValues<br>
 * it will also set and retrieve values of "text" attribute of the component [if it exists].<br>
 * 
 * @author Ji Hoon Kim
 */
public abstract class MXMLUISelectedIndexBase 
						extends MXMLUIInputBase {
	
	private static final IntegerConverter INTEGER_CONVERTER = new IntegerConverter();
	
	private static final String SELECTED_INDEX_ID_APPENDED = "_selectedIndex";
	private static final String SELECTED_INDEX_ATTR = "selectedIndex";
	
	public Map getComponentValues(){
		super.getComponentValues();
		_componentValues.put(SELECTED_INDEX_ATTR, getSelectedIndex());
		return _componentValues;
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
    	
    	ValueBinding vb = getValueBinding(SELECTED_INDEX_ATTR);
		if(vb != null && !vb.isReadOnly(getFacesContext())){
			vb.setValue(getFacesContext(), getSelectedIndex());
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