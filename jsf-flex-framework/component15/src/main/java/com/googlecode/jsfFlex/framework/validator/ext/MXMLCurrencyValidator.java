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
		componentName="CurrencyValidator",
		
		jsfFlexAttributes={
			@JsfFlexAttribute(attribute="alignSymbol", byMethod=false),
			@JsfFlexAttribute(attribute="allowNegative", byMethod=false),
			@JsfFlexAttribute(attribute="currencySymbol", byMethod=false),
			@JsfFlexAttribute(attribute="currencySymbolError", byMethod=false),
			@JsfFlexAttribute(attribute="decimalPointCountError", byMethod=false),
			@JsfFlexAttribute(attribute="decimalSeparator", byMethod=false),
			@JsfFlexAttribute(attribute="exceedsMaxError", byMethod=false),
			@JsfFlexAttribute(attribute="invalidCharError", byMethod=false),
			@JsfFlexAttribute(attribute="invalidFormatCharsError", byMethod=false),
			@JsfFlexAttribute(attribute="lowerThanMinError", byMethod=false),
			@JsfFlexAttribute(attribute="maxValue", byMethod=false),
			@JsfFlexAttribute(attribute="minValue", byMethod=false),
			@JsfFlexAttribute(attribute="negativeError", byMethod=false),
			@JsfFlexAttribute(attribute="precision", byMethod=false),
			@JsfFlexAttribute(attribute="precisionError", byMethod=false),
			@JsfFlexAttribute(attribute="separationError", byMethod=false),
			@JsfFlexAttribute(attribute="thousandsSeparator", byMethod=false)
		}
	)
public class MXMLCurrencyValidator extends MXMLValidatorTemplate {
	
	public MXMLCurrencyValidator(){
		super();
	}
	
	public void buildComponentBegin(Object componentObj) throws ComponentBuildException{
		super.buildComponentBegin(componentObj);
		
		mapFields(MXMLCurrencyValidator.class, componentObj, null);
		
	}
	
	public void buildComponentInterlude(Object componentObj) throws ComponentBuildException {
		super.buildComponentInterlude(componentObj);
		
		_MXMLContract componentMXML = (_MXMLContract) componentObj;
		addCreatePreMxmlTask(componentMXML, MXMLCurrencyValidator.class.getAnnotation(JsfFlexAttributeProperties.class).componentName(), 
								null);
		
	}

}
