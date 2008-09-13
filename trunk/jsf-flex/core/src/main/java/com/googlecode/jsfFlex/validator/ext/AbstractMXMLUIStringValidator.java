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
 *   name     = "jf:mxmlStringValidator"
 *   class    = "com.googlecode.jsfFlex.validator.ext.MXMLUIStringValidator"
 *   type     = "com.googlecode.jsfFlex.MXMLUIStringValidator"
 *   tagClass = "com.googlecode.jsfFlex.taglib.ext.MXMLUIStringValidatorTag"
 *   family   = "javax.faces.MXMLSimpleBase"
 *   defaultRendererType= "com.googlecode.jsfFlex.MXMLStringValidator"
 *   
 * @JSFJspProperties
 * 		properties	=		
 *   						@JSFJspProperty
 * 							 name		= "maxLength"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Maximum length for a valid String."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "minLength"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Minimum length for a valid String."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "tooLongError"
 *   						 returnType	= "java.lang.String" 
 *   						 longDesc	= "Error message when the String is longer than the maxLength property."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "tooShortError"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Error message when the string is shorter than the minLength property."
 * 
 * One thing to note about MXML Formatter and Validator is that they are not actually converters or validators<br>
 * respectively but actually are components. This is so because they perform the formatting and validation<br>
 * as Flex components on the client side and not on the server side.<br>
 * 			
 * @author Ji Hoon Kim
 */
public abstract class AbstractMXMLUIStringValidator 
						extends MXMLUISimpleBase 
						implements _MXMLUIValidatorAttributes {
	
}
