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
package com.googlecode.jsfFlex.framework.validator.ext;

import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;
import com.googlecode.jsfFlex.framework.validator.MXMLValidatorTemplate;
import com.googlecode.jsfFlex.shared.adapter._MXMLContract;

/**
 * @JsfFlexAttributes
 * 	allowedFormatChars=false
 * 	dayListener=false
 * 	dayProperty=false
 * 	daySource=false
 * 	formatError=false
 * 	inputFormat=false
 * 	invalidCharError=true
 * 	monthListener=false
 * 	monthProperty=false
 * 	monthSource=false
 * 	validateAsString=false
 * 	wrongDayError=false
 * 	wrongLengthError=false
 * 	wrongMonthError=false
 * 	wrongYearError=false
 * 	yearListener=false
 * 	yearProperty=false
 * 	yearSource=false
 * 
 * @JsfFlexRenderKitAttribute
 *  componentFamily=javax.faces.MXMLSimpleBase
 *  rendererName=com.googlecode.jsfFlex.MXMLDateValidator
 *  rendererClass=com.googlecode.jsfFlex.framework.validator.ext.MXMLDateValidator
 * 
 * @author Ji Hoon Kim
 */
public class MXMLDateValidator extends MXMLValidatorTemplate {
	
	private static final String MXML_DATE_VALIDATOR_REPLACE_MAPPING;
	private static final String MXML_COMPONENT_NAME = "DateValidator";
	
	static{
		//TODO : find a better method to implement the below tasks
		String packageName = MXMLDateValidator.class.getPackage().getName();
		packageName = packageName.replace('.', '/');
		MXML_DATE_VALIDATOR_REPLACE_MAPPING = packageName + "/replaceMapping/MXMLDateValidatorReplaceMapping.xml";
	}
	
	public MXMLDateValidator(){
		super();
	}
	
	public void buildComponentBegin(Object componentObj) throws ComponentBuildException{
		super.buildComponentBegin(componentObj);
		
		mapFields(MXMLDateValidator.class, componentObj, MXML_DATE_VALIDATOR_REPLACE_MAPPING);
		
	}
	
	public void buildComponentInterlude(Object componentObj) throws ComponentBuildException {
		super.buildComponentInterlude(componentObj);
		
		_MXMLContract componentMXML = (_MXMLContract) componentObj;
		addCreatePreMxmlTask(componentMXML, MXML_COMPONENT_NAME, null);
		
	}

}
