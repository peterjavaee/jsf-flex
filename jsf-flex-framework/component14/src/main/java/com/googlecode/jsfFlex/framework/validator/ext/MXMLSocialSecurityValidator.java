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
 * 	invalidCharError=false
 * 	wrongFormatError=false
 * 	zeroStartError=false
 * 
 * @JsfFlexRenderKitAttribute
 *  componentFamily=javax.faces.MXMLSimpleBase
 *  rendererName=com.googlecode.jsfFlex.MXMLSocialSecurityValidator
 *  rendererClass=com.googlecode.jsfFlex.framework.validator.ext.MXMLSocialSecurityValidator
 * 
 * @author Ji Hoon Kim
 */
public final class MXMLSocialSecurityValidator extends MXMLValidatorTemplate {
	
	private static final String MXML_SOCIAL_SECURITY_VALIDATOR_REPLACE_MAPPING;
	private static final String MXML_COMPONENT_NAME = "SocialSecurityValidator";
	
	static{
		//TODO : find a better method to implement the below tasks
		String packageName = MXMLSocialSecurityValidator.class.getPackage().getName();
		packageName = packageName.replace('.', '/');
		MXML_SOCIAL_SECURITY_VALIDATOR_REPLACE_MAPPING = packageName + "/replaceMapping/MXMLSocialSecurityValidatorReplaceMapping.xml";
	}
	
	public MXMLSocialSecurityValidator(){
		super();
	}
	
	public void buildComponentBegin(Object componentObj) throws ComponentBuildException{
		super.buildComponentBegin(componentObj);
		
		mapFields(MXMLSocialSecurityValidator.class, componentObj, MXML_SOCIAL_SECURITY_VALIDATOR_REPLACE_MAPPING);
		
	}
	
	public void buildComponentInterlude(Object componentObj) throws ComponentBuildException {
		super.buildComponentInterlude(componentObj);
		
		_MXMLContract componentMXML = (_MXMLContract) componentObj;
		addCreatePreMxmlTask(componentMXML, MXML_COMPONENT_NAME, null);

	}

}
