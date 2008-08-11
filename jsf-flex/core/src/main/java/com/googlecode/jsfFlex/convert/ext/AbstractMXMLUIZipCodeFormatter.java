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
package com.googlecode.jsfFlex.convert.ext;

import com.googlecode.jsfFlex.component.MXMLUISimpleBase;
import com.googlecode.jsfFlex.convert.attributes.compBase._MXMLUIFormatter;

/**
 * @JSFComponent
 *   name     = "jf:mxmlZipCodeFormatter"
 *   class    = "com.googlecode.jsfFlex.convert.ext.MXMLUIZipCodeFormatter"
 *   type     = "com.googlecode.jsfFlex.MXMLUIZipCodeFormatter"
 *   tagClass = "com.googlecode.jsfFlex.taglib.ext.MXMLUIZipCodeFormatterTag"
 *   family   = "javax.faces.MXMLSimpleBase"
 *   tagSuperclass = "org.apache.myfaces.shared_impl.taglib.UIComponentTagBase"
 *   defaultRendererType= "com.googlecode.jsfFlex.MXMLSimpleBase"
 * 
 * @JSFJspProperty
 *   name		= "formatString"
 *   returnType = "java.lang.String"
 *   longDesc	= "The mask pattern."
 * 
 * @author Ji Hoon Kim
 */
public abstract class AbstractMXMLUIZipCodeFormatter 
						extends MXMLUISimpleBase 
						implements _MXMLUIFormatter {

	private static final String MXML_COMPONENT_RENDERER = "com.googlecode.jsfFlex.MXMLZipCodeFormatter";
	
	public String getMXMLComponentRenderer() {
		return MXML_COMPONENT_RENDERER;
	}
	
}
