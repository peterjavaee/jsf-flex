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
package com.googlecode.jsfFlex.component.ext.data.ext.properties;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;

import com.googlecode.jsfFlex.component.ext.data.MXMLUIXMLContainerBase;
import com.googlecode.jsfFlex.component.ext.data.ext.properties.ext.AbstractMXMLUIXMLAttribute;
import com.googlecode.jsfFlex.component.ext.data.ext.properties.ext.AbstractMXMLUIXMLStaticAttribute;
import com.googlecode.jsfFlex.shared.context.MxmlContext;
import com.googlecode.jsfFlex.shared.exception.ComponentBuildException;
import com.googlecode.jsfFlex.util.ReflectionHelperUtil;

/**
 * @author Ji Hoon Kim
 */
public abstract class MXMLUIXMLElementBase 
						extends UIComponentBase {
	
	protected String _xmlElementEndTag;
	
	private Object _currBeanRef;
	private List _temporaryMXMLUIXMLAttributeList;
	
	public void encodeChildren(FacesContext context) throws IOException {
		
		for(Iterator iterate = getChildren().iterator(); iterate.hasNext();){
			UIComponent currChild = (UIComponent) iterate.next();
			
			if(!(currChild instanceof AbstractMXMLUIXMLAttribute || 
					currChild instanceof AbstractMXMLUIXMLStaticAttribute)){
				currChild.encodeBegin(context);
				currChild.encodeChildren(context);
				currChild.encodeEnd(context);
			}
			
		}
		
	}
	
	public void encodeEnd(FacesContext context) throws IOException {
		super.encodeEnd(context);
		
		MxmlContext mxmlContext = MxmlContext.getCurrentInstance();
		Map temporaryResourceMap = mxmlContext.getTemporaryResourceMap();
		MXMLUIXMLContainerBase currXMLContainerRef = (MXMLUIXMLContainerBase) temporaryResourceMap.get(MXMLUIXMLContainerBase.CURR_MXML_UI_XML_CONTAINER_KEY);
		
		currXMLContainerRef.getCurrBodyContentBufferedWriter().write(_xmlElementEndTag);
		
	}
	
	public boolean getRendersChildren() {
		return true;
	}
	
	protected String processXMLTagAttributes(){
		
		StringBuffer attributes = new StringBuffer();
		List mxmlUIXMLAttributeList = getTemporaryMXMLUIXMLAttributeList();
		
		if(mxmlUIXMLAttributeList != null){
			for(Iterator iterate = mxmlUIXMLAttributeList.iterator(); iterate.hasNext();){
				
				Object currAttributeObject = iterate.next();
				attributes.append(processXMLTagAttribute(currAttributeObject));
				
			}
		}
		
		return attributes.toString();
	}
	
	private String processXMLTagAttribute(Object currAttributeObject){
		
		StringBuffer attribute = new StringBuffer();
		
		if(currAttributeObject instanceof AbstractMXMLUIXMLAttribute){
			AbstractMXMLUIXMLAttribute currXMLAttribute = (AbstractMXMLUIXMLAttribute) currAttributeObject;
			
			String attributeName = currXMLAttribute.getAttribute();
			String attributeMethodName = currXMLAttribute.getAttributeMethodName();
			
			try{
				String attributeValue = ReflectionHelperUtil.getValue(_currBeanRef, attributeMethodName).toString();
				
				attribute.append(" ");
				attribute.append(attributeName);
				attribute.append("='");
				attribute.append(attributeValue);
				attribute.append("'");
				
			}catch(Exception reflectionException){
				throw new ComponentBuildException("Exception was triggered while invoking " + attributeMethodName, reflectionException);
			}
			
		}else if(currAttributeObject instanceof AbstractMXMLUIXMLStaticAttribute){
			AbstractMXMLUIXMLStaticAttribute currXMLStaticAttribute = (AbstractMXMLUIXMLStaticAttribute) currAttributeObject;
			
			attribute.append(" ");
			attribute.append(currXMLStaticAttribute.getStaticAttributeName());
			attribute.append("='");
			attribute.append(currXMLStaticAttribute.getStaticAttributeValue());
			attribute.append("'");
			
		}
		
		return attribute.toString();
	}
	
	private synchronized List getTemporaryMXMLUIXMLAttributeList() {
		if(_temporaryMXMLUIXMLAttributeList == null){
			_temporaryMXMLUIXMLAttributeList = new LinkedList();
			
			for(Iterator iterate = getChildren().iterator(); iterate.hasNext();){
				Object currInstance = iterate.next();
				if(currInstance instanceof AbstractMXMLUIXMLAttribute || 
						currInstance instanceof AbstractMXMLUIXMLStaticAttribute){
					_temporaryMXMLUIXMLAttributeList.add(currInstance);
				}
			}
			
		}
		
		return _temporaryMXMLUIXMLAttributeList;
	}
	
	public Object getCurrBeanRef() {
		return _currBeanRef;
	}
	public void setCurrBeanRef(Object currBeanRef) {
		_currBeanRef = currBeanRef;
	}
	
}
