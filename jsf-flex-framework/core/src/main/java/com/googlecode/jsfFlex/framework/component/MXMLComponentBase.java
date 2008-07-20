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
package com.googlecode.jsfFlex.framework.component;

import com.googlecode.jsfFlex.framework.context.MxmlContext;
import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;
import com.googlecode.jsfFlex.shared.adapter._MXMLContract;

/**
 * @author Ji Hoon Kim
 */
public abstract class MXMLComponentBase extends MXMLComponentBaseActions {
	
	private static final String COMPONENT_BASE_CONTENT_TOKEN = "&base;";
	private static final String MXML_COMPONENT_BASE_REPLACE_MAPPING;
	private static final String MXML_COMPONENT_BASE_TEMPLATE;
	
	protected MXMLComponentBase(){
		super();
	}
	
	static{
		//TODO : find a better method to implement the below tasks
		String packageName = MXMLComponentBase.class.getPackage().getName();
		packageName = packageName.replace('.', '/');
		MXML_COMPONENT_BASE_REPLACE_MAPPING = packageName + "/replaceMapping/MXMLComponentBaseReplaceMapping.xml";
		MXML_COMPONENT_BASE_TEMPLATE = packageName + "/templates/MXMLComponentBase.template";
	}
	
	public void buildComponentBegin(Object componentObj) throws ComponentBuildException{
		
		mapFields(componentObj, MXML_COMPONENT_BASE_REPLACE_MAPPING);	
	}
	
	public void buildComponentInterlude(Object componentObj) throws ComponentBuildException{
		_MXMLContract componentMXML = (_MXMLContract) componentObj;
		addInsertComponentTemplateTask(componentMXML, COMPONENT_BASE_CONTENT_TOKEN, 
												getComponentTemplate(MXML_COMPONENT_BASE_TEMPLATE));
		
		/*
		 * By this point :
		 * 		(1)	a task for creating preMxml file has been queued
		 * 		(2) a task for appending subcomponents attributes has been queued
		 * 		
		 * Now queue the task of replacing the attributes with their respective values
		 */
		addReplaceTokenTask(componentMXML);
		//TODO : implement it better later
		getFlexTaskRunner().replaceChildSiblingWithPreMxmlIdentifier(componentMXML);
	}
	
	public void buildComponentChildren(Object componentObj) throws ComponentBuildException {
		
	}
	
	public void buildComponentEnd(Object componentObj) throws ComponentBuildException{
		
		MxmlContext mxmlContext = MxmlContext.getCurrentInstance();
		if(mxmlContext.isSimplySWF() || mxmlContext.isProductionEnv()){
			return;
		}
		
		_MXMLContract componentMXML = (_MXMLContract) componentObj;
		
		getFlexTaskRunner().replaceChildSiblingWithPreMxmlIdentifier(componentMXML);
		getFlexTaskRunner().writeBodyContentTask(componentMXML);
		
	}
	
}
