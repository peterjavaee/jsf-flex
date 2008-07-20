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
import com.googlecode.jsfFlex.validator.attributes._MXMLUIDomainAttribute;
import com.googlecode.jsfFlex.validator.attributes._MXMLUIInvalidCharErrorAttribute;
import com.googlecode.jsfFlex.validator.attributes._MXMLUINumberValidatorAttributes;
import com.googlecode.jsfFlex.validator.attributes._MXMLUIPrecisionAttribute;
import com.googlecode.jsfFlex.validator.attributes.compBase._MXMLUIValidatorAttributes;

/**
 * @JSFComponent
 *   name     = "jf:mxmlNumberValidator"
 *   class    = "com.googlecode.jsfFlex.validator.ext.MXMLUINumberValidator"
 *   type     = "com.googlecode.jsfFlex.MXMLUINumberValidator"
 *   tagClass = "com.googlecode.jsfFlex.taglib.ext.MXMLUINumberValidatorTag"
 *   family   = "javax.faces.MXMLSimpleBase"
 *   tagSuperclass = "org.apache.myfaces.shared_impl.taglib.UIComponentTagBase"
 *   defaultRendererType= "com.googlecode.jsfFlex.MXMLSimpleBase"
 *   
 * @JSFJspProperty
 *   name		= "integerError"
 *   returnType = "java.lang.String"
 *   longDesc	= "Error message when the number must be an integer, as defined by the domain property."
 * 
 * @author Ji Hoon Kim
 */
public abstract class AbstractMXMLUINumberValidator 
						extends MXMLUISimpleBase 
						implements _MXMLUIValidatorAttributes, _MXMLUIDomainAttribute, _MXMLUIInvalidCharErrorAttribute,  
						_MXMLUINumberValidatorAttributes, _MXMLUIPrecisionAttribute {
	
	private static final String MXML_COMPONENT_RENDERER = "com.googlecode.jsfFlex.MXMLNumberValidator";
	
	public String getMXMLComponentRenderer() {
		return MXML_COMPONENT_RENDERER;
	}
	
}
