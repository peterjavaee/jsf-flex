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
package com.googlecode.jsfFlex.validator.attributes;

/**
 * @JSFJspProperties
 * 		properties	=		
 *   						@JSFJspProperty
 * 							 name		= "allowNegative"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Specifies whether negative numbers are permitted."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "decimalPointCountError"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Error message when the decimal separator character occurs more than once."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "decimalSeparator"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The character used to separate the whole from the fractional part of the number."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "exceedsMaxError"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Error message when the value exceeds the maxValue property."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "invalidFormatCharsError"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Error message when the value contains invalid format characters, which means that it contains a digit or minus sign (-) as a separator character, or it contains two or more consecutive separator characters."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "lowerThanMinError"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Error message when the value is less than minValue."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "maxValue"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Maximum value for a valid number."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "minValue"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Minimum value for a valid number."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "negativeError"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Error message when the value is negative and the allowNegative property is false."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "precisionError"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Error message when the value has a precision that exceeds the value defined by the precision property."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "separationError"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Error message when the thousands separator is in the wrong location."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "thousandsSeparator"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The character used to separate thousands in the whole part of the number."
 *   						
 * @author Ji Hoon Kim
 */
public interface _MXMLUINumberValidatorAttributes {
	
	/**
	 * Specifies whether negative numbers are permitted.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Specifies whether negative numbers are permitted."
	 */
	String getAllowNegative();

	/**
	 * Error message when the decimal separator character occurs more than once.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Error message when the decimal separator character occurs more than once."
	 */
	String getDecimalPointCountError();

	/**
	 * The character used to separate the whole from the fractional part of the number.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "The character used to separate the whole from the fractional part of the number."
	 */
	String getDecimalSeparator();

	/**
	 * Error message when the value exceeds the maxValue property.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Error message when the value exceeds the maxValue property."
	 */
	String getExceedsMaxError();

	/**
	 * Error message when the value contains invalid format characters, which means that it contains a digit or minus sign (-) as a separator character, or it contains two or more consecutive separator characters.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Error message when the value contains invalid format characters, which means that it contains a digit or minus sign (-) as a separator character, or it contains two or more consecutive separator characters."
	 */
	String getInvalidFormatCharsError();

	/**
	 * Error message when the value is less than minValue.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Error message when the value is less than minValue."
	 */
	String getLowerThanMinError();

	/**
	 * Maximum value for a valid number.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Maximum value for a valid number."
	 */
	String getMaxValue();

	/**
	 * Minimum value for a valid number.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Minimum value for a valid number."
	 */
	String getMinValue();

	/**
	 * Error message when the value is negative and the allowNegative property is false.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Error message when the value is negative and the allowNegative property is false."
	 */
	String getNegativeError();

	/**
	 * Error message when the value has a precision that exceeds the value defined by the precision property.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Error message when the value has a precision that exceeds the value defined by the precision property."
	 */
	String getPrecisionError();

	/**
	 * Error message when the thousands separator is in the wrong location.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Error message when the thousands separator is in the wrong location."
	 */
	String getSeparationError();

	/**
	 * The character used to separate thousands in the whole part of the number.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "The character used to separate thousands in the whole part of the number."
	 */
	String getThousandsSeparator();
	
}
