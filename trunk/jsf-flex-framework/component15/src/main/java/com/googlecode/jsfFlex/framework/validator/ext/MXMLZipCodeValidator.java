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

import com.googlecode.jsfFlex.framework.annotation.JsfFlexAttribute;
import com.googlecode.jsfFlex.framework.annotation.JsfFlexAttributeProperties;
import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;
import com.googlecode.jsfFlex.framework.validator.MXMLValidatorTemplate;
import com.googlecode.jsfFlex.shared.adapter._MXMLContract;

/**
 * @author Ji Hoon Kim
 */
@JsfFlexAttributeProperties(
		componentName="ZipCodeValidator",
		componentFamily="javax.faces.MXMLSimpleBase",
		rendererName="com.googlecode.jsfFlex.MXMLZipCodeValidator",
		rendererClass="com.googlecode.jsfFlex.framework.validator.ext.MXMLZipCodeValidator",
		componentNodeAttributes={},

		jsfFlexAttributes={
				@JsfFlexAttribute(attribute="allowedFormatChars", byMethod=false),
				@JsfFlexAttribute(attribute="domain", byMethod=false),
				@JsfFlexAttribute(attribute="invalidCharError", byMethod=false),
				@JsfFlexAttribute(attribute="invalidDomainError", byMethod=false),
				@JsfFlexAttribute(attribute="wrongCAFormatError", byMethod=false),
				@JsfFlexAttribute(attribute="wrongLengthError", byMethod=false),
				@JsfFlexAttribute(attribute="wrongUSFormatError", byMethod=false)
		}
)
public final class MXMLZipCodeValidator extends MXMLValidatorTemplate {
	
	public MXMLZipCodeValidator(){
		super();
	}
	
	public void buildComponentBegin(Object componentObj) throws ComponentBuildException{
		super.buildComponentBegin(componentObj);
		
		mapFields(MXMLZipCodeValidator.class, componentObj, null);
		
	}
	
	public void buildComponentInterlude(Object componentObj) throws ComponentBuildException {
		super.buildComponentInterlude(componentObj);
		
		_MXMLContract componentMXML = (_MXMLContract) componentObj;
		addCreatePreMxmlTask(componentMXML, 
					MXMLZipCodeValidator.class.getAnnotation(JsfFlexAttributeProperties.class).componentName(), 
					null);
		
	}

}
