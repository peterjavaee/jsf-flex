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
 * @author Ji Hoon Kim
 */
public class MXMLPhoneNumberValidator extends MXMLValidatorTemplate {
	
	private static final String MXML_PHONE_NUMBER_VALIDATOR_TEMPLATE;
	private static final String MXML_PHONE_NUMBER_VALIDATOR_REPLACE_MAPPING;
	
	static{
		//TODO : find a better method to implement the below tasks
		String packageName = MXMLPhoneNumberValidator.class.getPackage().getName();
		packageName = packageName.replace('.', '/');
		MXML_PHONE_NUMBER_VALIDATOR_REPLACE_MAPPING = packageName + "/replaceMapping/MXMLPhoneNumberValidatorReplaceMapping.xml";
		MXML_PHONE_NUMBER_VALIDATOR_TEMPLATE = packageName + "/templates/MXMLPhoneNumberValidator.template";
	}
	
	public MXMLPhoneNumberValidator(){
		super();
	}
	
	public void buildComponentBegin(Object componentObj) throws ComponentBuildException{
		super.buildComponentBegin(componentObj);
		
		_MXMLContract componentMXML = (_MXMLContract) componentObj;
		mapFields(componentObj, MXML_PHONE_NUMBER_VALIDATOR_REPLACE_MAPPING);
		addCreatePreMxmlTask(componentMXML, MXML_PHONE_NUMBER_VALIDATOR_TEMPLATE);
		
	}

}
