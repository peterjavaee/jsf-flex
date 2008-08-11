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
package com.googlecode.jsfFlex.validator.ext;

import com.googlecode.jsfFlex.component.MXMLUISimpleBase;
import com.googlecode.jsfFlex.validator.attributes.compBase._MXMLUIValidatorAttributes;

/**
 * @JSFComponent
 *   name     = "jf:mxmlZipCodeValidator"
 *   class    = "com.googlecode.jsfFlex.validator.ext.MXMLUIZipCodeValidator"
 *   type     = "com.googlecode.jsfFlex.MXMLUIZipCodeValidator"
 *   tagClass = "com.googlecode.jsfFlex.taglib.ext.MXMLUIZipCodeValidatorTag"
 *   family   = "javax.faces.MXMLSimpleBase"
 *   tagSuperclass = "org.apache.myfaces.shared_impl.taglib.UIComponentTagBase"
 *   defaultRendererType= "com.googlecode.jsfFlex.MXMLSimpleBase"
 *   
 * @JSFJspProperties
 * 		properties	=		
 *   						@JSFJspProperty
 * 							 name		= "wrongCAFormatError"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Error message for an invalid Canadian postal code."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "wrongUSFormatError"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Error message for an incorrectly formatted ZIP code."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "allowedFormatChars"
 *  						 returnType = "java.lang.String"
 *   						 longDesc	= "The set of formatting characters allowed."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "domain"
 *  						 returnType = "java.lang.String"
 *  						 longDesc	= "Type to be validated."
 *   						,
 *   
 *							@JSFJspProperty
 *   						 name		= "invalidCharError"
 *  						 returnType = "java.lang.String"
 *  						 longDesc	= "Error message when the value contains invalid characters."
 *   						,
 *   						
 *							@JSFJspProperty
 *   						 name		= "invalidDomainError"
 *  						 returnType = "java.lang.String"
 *  						 longDesc	= "Error message when the domain property contains an invalid value."
 *   						,
 *   
 *							@JSFJspProperty
 *   						 name		= "wrongLengthError"
 *  						 returnType = "java.lang.String"
 *  						 longDesc	= "Error message when the field contains the wrong number of digits for the specified type."
 *   						
 * @author Ji Hoon Kim
 */
public abstract class AbstractMXMLUIZipCodeValidator 
						extends MXMLUISimpleBase 
						implements _MXMLUIValidatorAttributes {
	
	private static final String MXML_COMPONENT_RENDERER = "com.googlecode.jsfFlex.MXMLZipCodeValidator";
	
	public String getMXMLComponentRenderer() {
		return MXML_COMPONENT_RENDERER;
	}
	
}
