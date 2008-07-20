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
package com.googlecode.jsfFlex.component.attributes.compBase;

/**
 * @JSFJspProperties
 * 		properties	=	
 * 							@JSFJspProperty
 * 							 name		= "editableDisabledSkin"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Name of the class to use as the skin for the background and border when the control is disabled, and the editable property is true."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "editableDownSkin"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Name of the class to use as the skin for the background and border when the user holds down the mouse button, and the editable property is true."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "editableOverSkin"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Name of the class to use as the skin for the background and border when the mouse is over the control, and the editable property is true."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "editableUpSkin"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Name of the class to use as the skin for the background and border when the mouse is not over the control, and the editable property is true."
 *   						
 * @author Ji Hoon Kim
 */
public interface _MXMLUIComboBaseAttributes {
	
	/**
	 * Name of the class to use as the skin for the background and border when the control is disabled, and the editable property is true.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Name of the class to use as the skin for the background and border when the control is disabled, and the editable property is true."
	 */
	String getEditableDisabledSkin();

	/**
	 * Name of the class to use as the skin for the background and border when the user holds down the mouse button, and the editable property is true.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Name of the class to use as the skin for the background and border when the user holds down the mouse button, and the editable property is true."
	 */
	String getEditableDownSkin();

	/**
	 * Name of the class to use as the skin for the background and border when the mouse is over the control, and the editable property is true.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Name of the class to use as the skin for the background and border when the mouse is over the control, and the editable property is true."
	 */
	String getEditableOverSkin();

	/**
	 * Name of the class to use as the skin for the background and border when the mouse is not over the control, and the editable property is true.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Name of the class to use as the skin for the background and border when the mouse is not over the control, and the editable property is true."
	 */
	String getEditableUpSkin();
	
}
