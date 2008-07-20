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
package com.googlecode.jsfFlex.convert.attributes.compBase;

/**
 * @JSFJspProperties
 * 		properties	=		
 *   						@JSFJspProperty
 * 							 name		= "decimalSeparatorFrom"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Decimal separator character to use when parsing an input string."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "decimalSeparatorTo"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Decimal separator character to use when outputting formatted decimal numbers."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "precision"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Number of decimal places to include in the output String."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "rounding"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "How to round the number."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "thousandsSeparatorFrom"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Character to use as the thousands separator in the input String."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "thousandsSeparatorTo"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Character to use as the thousands separator in the output string."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "useNegativeSign"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "If true, format a negative number by preceding it with a minus "-" sign."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "useThousandsSeparator"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "If true, split the number into thousands increments by using a separator character."
 *   						
 * @author Ji Hoon Kim
 */
public interface _MXMLUINumberFormatter {
	
	/**
	 * Decimal separator character to use when parsing an input string.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Decimal separator character to use when parsing an input string."
	 */
	String getDecimalSeparatorFrom();

	/**
	 * Decimal separator character to use when outputting formatted decimal numbers.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Decimal separator character to use when outputting formatted decimal numbers."
	 */
	String getDecimalSeparatorTo();

	/**
	 * Number of decimal places to include in the output String.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Number of decimal places to include in the output String."
	 */
	String getPrecision();

	/**
	 * How to round the number.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "How to round the number."
	 */
	String getRounding();

	/**
	 * Character to use as the thousands separator in the input String.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Character to use as the thousands separator in the input String."
	 */
	String getThousandsSeparatorFrom();

	/**
	 * Character to use as the thousands separator in the output string.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Character to use as the thousands separator in the output string."
	 */
	String getThousandsSeparatorTo();

	/**
	 * If true, format a negative number by preceding it with a minus - sign.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "If true, format a negative number by preceding it with a minus - sign."
	 */
	String getUseNegativeSign();

	/**
	 * If true, split the number into thousands increments by using a separator character.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "If true, split the number into thousands increments by using a separator character."
	 */
	String getUseThousandsSeparator();
	
}
