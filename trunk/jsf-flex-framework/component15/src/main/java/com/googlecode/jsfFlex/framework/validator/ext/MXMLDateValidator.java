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
		componentName="DateValidator",
		componentFamily="javax.faces.MXMLSimpleBase",
		rendererName="com.googlecode.jsfFlex.MXMLDateValidator",
		rendererClass="com.googlecode.jsfFlex.framework.validator.ext.MXMLDateValidator",
		componentNodeAttributes={},

		jsfFlexAttributes={
				@JsfFlexAttribute(attribute="allowedFormatChars", byMethod=false),
				@JsfFlexAttribute(attribute="dayListener", byMethod=false),
				@JsfFlexAttribute(attribute="dayProperty", byMethod=false),
				@JsfFlexAttribute(attribute="daySource", byMethod=false),
				@JsfFlexAttribute(attribute="formatError", byMethod=false),
				@JsfFlexAttribute(attribute="inputFormat", byMethod=false),
				@JsfFlexAttribute(attribute="invalidCharError", byMethod=true),
				@JsfFlexAttribute(attribute="monthListener", byMethod=false),
				@JsfFlexAttribute(attribute="monthProperty", byMethod=false),
				@JsfFlexAttribute(attribute="monthSource", byMethod=false),
				@JsfFlexAttribute(attribute="validateAsString", byMethod=false),
				@JsfFlexAttribute(attribute="wrongDayError", byMethod=false),
				@JsfFlexAttribute(attribute="wrongLengthError", byMethod=false),
				@JsfFlexAttribute(attribute="wrongMonthError", byMethod=false),
				@JsfFlexAttribute(attribute="wrongYearError", byMethod=false),
				@JsfFlexAttribute(attribute="yearListener", byMethod=false),
				@JsfFlexAttribute(attribute="yearProperty", byMethod=false),
				@JsfFlexAttribute(attribute="yearSource", byMethod=false)
		}
)
public final class MXMLDateValidator extends MXMLValidatorTemplate {
	
	public MXMLDateValidator(){
		super();
	}
	
	public void buildComponentBegin(Object componentObj) throws ComponentBuildException{
		super.buildComponentBegin(componentObj);
		
		mapFields(MXMLDateValidator.class, componentObj, null);
		
	}
	
	public void buildComponentInterlude(Object componentObj) throws ComponentBuildException {
		super.buildComponentInterlude(componentObj);
		
		_MXMLContract componentMXML = (_MXMLContract) componentObj;
		createPreMxml(componentMXML, MXMLDateValidator.class.getAnnotation(JsfFlexAttributeProperties.class).componentName(), 
								null);
		
	}

}
