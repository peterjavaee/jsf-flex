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
 * 							 name		= "buttonHeight"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Height of each button, in pixels."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "buttonStyleName"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Name of CSS style declaration that specifies styles for the buttons."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "buttonWidth"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Width of each button, in pixels."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "firstButtonStyleName"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Name of CSS style declaration that specifies styles for the first button."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "lastButtonStyleName"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Name of CSS style declaration that specifies styles for the last button."
 *   						
 * @author Ji Hoon Kim
 */
public interface _MXMLUIButtonBarAttributes {
	
	/**
	 * Height of each button, in pixels.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Height of each button, in pixels."
	 */
	String getButtonHeight();

	/**
	 * Name of CSS style declaration that specifies styles for the buttons.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Name of CSS style declaration that specifies styles for the buttons."
	 */
	String getButtonStyleName();

	/**
	 * Width of each button, in pixels.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Width of each button, in pixels."
	 */
	String getButtonWidth();

	/**
	 * Name of CSS style declaration that specifies styles for the first button.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Name of CSS style declaration that specifies styles for the first button."
	 */
	String getFirstButtonStyleName();

	/**
	 * Name of CSS style declaration that specifies styles for the last button.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Name of CSS style declaration that specifies styles for the last button."
	 */
	String getLastButtonStyleName();
	
}
