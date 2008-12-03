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
package com.googlecode.jsfFlex.taglib;

import javax.faces.component.UICommand;
import javax.faces.component.UIComponent;
import javax.faces.component.UIGraphic;
import javax.faces.component.UIParameter;
import javax.faces.component.UISelectBoolean;
import javax.faces.component.ValueHolder;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.el.ValueBinding;
import javax.faces.webapp.UIComponentTag;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Implementation of setting UIComponent attributes has been taken from MyFaces. Much Thanks!
 * 
 * @author Ji Hoon Kim
 */
public abstract class MXMLUIComponentTagBase extends UIComponentTag {
	
	private final static Log _log = LogFactory.getLog(MXMLUIComponentTagBase.class);
	
	private static final String CONVERTER_ATTR = "converter";
	private static final String VALUE_ATTR = "value";
	
	//Special UIComponent attributes (ValueHolder, ConvertibleValueHolder)
    private String _value;
    private String _converter;
	
    public void release() {
        super.release();
        _value=null;
        _converter=null;
    }

    protected void setProperties(UIComponent component){
        super.setProperties(component);
        
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(_value != null){
        	if(isValueReference(_value)){
        		ValueBinding vb = context.getApplication().createValueBinding(_value);
        		component.setValueBinding(VALUE_ATTR, vb);
        	}else if (component instanceof UICommand){
        		((UICommand)component).setValue(_value);
        	}else if (component instanceof UIParameter){
        		((UIParameter)component).setValue(_value);
        	}else if (component instanceof UISelectBoolean){
        		((UISelectBoolean)component).setValue(Boolean.valueOf(_value));
        	}else if (component instanceof UIGraphic){
        		((UIGraphic)component).setValue(_value);
        	}else if (component instanceof ValueHolder){
        		((ValueHolder)component).setValue(_value);
        	}else{
        		_log.error("Component " + component.getClass().getName() + " is no ValueHolder, cannot set value.");
        	}
        }
        
        if(_converter != null){
        	if(component instanceof ValueHolder){
        		if(isValueReference(_converter)){
        			ValueBinding vb = context.getApplication().createValueBinding(_converter);
        			component.setValueBinding(CONVERTER_ATTR, vb);
        		}else{
        			Converter converter = context.getApplication().createConverter(_converter);
        			((ValueHolder)component).setConverter(converter);
        		}
        	}else{
        		_log.error("Component " + component.getClass().getName() + " is no ValueHolder, cannot set value.");
        	}
        }
        
    }
    
    protected void setBooleanProperty(FacesContext context, UIComponent component, String propName, String value) {
    	
    	if(value != null){
    		if(isValueReference(value)){
    			ValueBinding vb = context.getApplication().createValueBinding(value);
    			component.setValueBinding(propName, vb);
    		}else{
    			component.getAttributes().put(propName, Boolean.valueOf(value));
    		}
    	}
    }
    
    protected void setIntegerProperty(FacesContext context, UIComponent component, String propName, String value) {
    	
    	if(value != null){
    		if(isValueReference(value)){
    			ValueBinding vb = context.getApplication().createValueBinding(value);
    			component.setValueBinding(propName, vb);
    		}else{
    			component.getAttributes().put(propName, Integer.valueOf(value));
    		}
    	}
    }
    
    protected void setLongProperty(FacesContext context, UIComponent component, String propName, String value) {
    	
    	if(value != null){
    		if(isValueReference(value)){
    			ValueBinding vb = context.getApplication().createValueBinding(value);
    			component.setValueBinding(propName, vb);
    		}else{
    			component.getAttributes().put(propName, Long.valueOf(value));
    		}
    	}
    }
    
    protected void setStringProperty(FacesContext context, UIComponent component, String propName, String value) {
    	
    	if(value != null){
    		if(isValueReference(value)){
    			ValueBinding vb = context.getApplication().createValueBinding(value);
    			component.setValueBinding(propName, vb);
    		}else{
    			component.getAttributes().put(propName, value);
    		}
    	}
    }
    
    public void setConverter(String converter){
        _converter = converter;
    }
    public void setValue(String value){
        _value = value;
    }
    
}