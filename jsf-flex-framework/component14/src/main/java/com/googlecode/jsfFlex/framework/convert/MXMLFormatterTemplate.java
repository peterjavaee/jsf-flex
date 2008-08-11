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
package com.googlecode.jsfFlex.framework.convert;

import com.googlecode.jsfFlex.framework.component.MXMLComponentBaseActions;
import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;

/**
 * @JsfFlexAttributes
 * 	id=true
 * 	error=true
 * 
 * @author Ji Hoon Kim
 */
public abstract class MXMLFormatterTemplate extends MXMLComponentBaseActions {
	
	private static final String MXML_FORMATTER_TEMPLATE_REPLACE_MAPPING;
	
	static{
		//TODO : find a better method to implement the below tasks
		String packageName = MXMLFormatterTemplate.class.getPackage().getName();
		packageName = packageName.replace('.', '/');
		MXML_FORMATTER_TEMPLATE_REPLACE_MAPPING = packageName + "/replaceMapping/MXMLFormatterTemplateReplaceMapping.xml";
	}
	
	public MXMLFormatterTemplate(){
		super();
	}

	public void buildComponentBegin(Object componentObj) throws ComponentBuildException {
		super.buildComponentBegin(componentObj);
		
		mapFields(MXMLFormatterTemplate.class, componentObj, MXML_FORMATTER_TEMPLATE_REPLACE_MAPPING);
		
	}
	
}
