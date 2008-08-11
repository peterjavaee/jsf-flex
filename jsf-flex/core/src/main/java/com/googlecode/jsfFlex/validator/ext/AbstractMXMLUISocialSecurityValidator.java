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
 *   name     = "jf:mxmlSocialSecurityValidator"
 *   class    = "com.googlecode.jsfFlex.validator.ext.MXMLUISocialSecurityValidator"
 *   type     = "com.googlecode.jsfFlex.MXMLUISocialSecurityValidator"
 *   tagClass = "com.googlecode.jsfFlex.taglib.ext.MXMLUISocialSecurityValidatorTag"
 *   family   = "javax.faces.MXMLSimpleBase"
 *   tagSuperclass = "org.apache.myfaces.shared_impl.taglib.UIComponentTagBase"
 *   defaultRendererType= "com.googlecode.jsfFlex.MXMLSimpleBase"
 *   
 * @JSFJspProperties
 * 		properties	=		
 *   						@JSFJspProperty
 * 							 name		= "wrongFormatError"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Error message when the value is incorrectly formatted."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "zeroStartError"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Error message when the value contains an invalid Social Security number."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "allowedFormatChars"
 *  						 returnType = "java.lang.String"
 *  						 longDesc	= "The set of formatting characters allowed."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "invalidCharError"
 *  						 returnType = "java.lang.String"
 *  						 longDesc	= "Error message when the value contains invalid characters."
 *   						
 * @author Ji Hoon Kim
 */
public abstract class AbstractMXMLUISocialSecurityValidator 
						extends MXMLUISimpleBase 
						implements _MXMLUIValidatorAttributes {
	
	private static final String MXML_COMPONENT_RENDERER = "com.googlecode.jsfFlex.MXMLSocialSecurityValidator";
	
	public String getMXMLComponentRenderer() {
		return MXML_COMPONENT_RENDERER;
	}
	
}
