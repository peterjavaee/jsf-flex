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
package com.googlecode.jsfFlex.component.ext.data.ext.properties.ext;

import javax.faces.component.UIComponentBase;

/**
 * @JSFComponent
 *   name     = "jf:mxmlXMLAttribute"
 *   class    = "com.googlecode.jsfFlex.component.ext.data.ext.properties.ext.MXMLUIXMLAttribute"
 *   type     = "com.googlecode.jsfFlex.MXMLUIXMLAttribute"
 *   tagClass = "com.googlecode.jsfFlex.taglib.ext.data.properties.MXMLUIXMLAttributeTag"
 *   family   = "javax.faces.MXMLSimple"
 *   
 * @author Ji Hoon Kim
 */
public abstract class AbstractMXMLUIXMLAttribute 
						extends UIComponentBase {
	
	/**
	 * Attribute of the node. This will allow fetching of the attribute name and value dynamically [attribute provided as a static string representing the attribute name and its value being the reflected value of this static string].
	 * 
	 *@JSFProperty
	 *    required        = true
	 *    rtexprvalue     = false
	 *    desc            = "Attribute of the node. This will allow fetching of the attribute name and value dynamically [attribute provided as a static string representing the attribute name and its value being the reflected value of this static string]."
	 */
	public abstract String getAttribute();
	
	public synchronized String getAttributeMethodName(){
		final String GET_ATTRIBUTE_METHOD_NAME = "get" + getAttribute().substring(0, 1).toUpperCase() + getAttribute().substring(1);
		
		return GET_ATTRIBUTE_METHOD_NAME;
	}
	
}
