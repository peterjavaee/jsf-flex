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
package com.googlecode.jsfFlex.component.attributes;

/**
 * @JSFJspProperties
 * 		properties	=		
 *   						@JSFJspProperty
 * 							 name		= "downArrowDisabledSkin"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Name of the class to use as the skin for the Up arrow when the arrow is disabled."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "downArrowDownSkin"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Name of the class to use as the skin for the up arrow when the arrow is enabled and a user presses the mouse button over the arrow."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "downArrowUpSkin"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Name of the class to use as the skin for the Up arrow when the arrow is enabled and the mouse pointer is not on the arrow."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "upArrowOverSkin"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Name of the class to use as the skin for the Up arrow when the arrow is enabled and the mouse pointer is over the arrow."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "upArrowDownSkin"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Name of the class to use as the skin for the Up arrow when the arrow is enabled and a user presses the mouse button over the arrow."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "upArrowDisabledSkin"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Name of the class to use as the skin for the Up arrow when the arrow is disabled."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "downArrowOverSkin"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Name of the class to use as the skin for the Up arrow when the arrow is enabled and the mouse pointer is over the arrow."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "upArrowUpSkin"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Name of the class to use as the skin for the Up arrow when the arrow is enabled and the mouse pointer is not on the arrow."
 *   						
 * @author Ji Hoon Kim
 */
public interface _MXMLUIArrowAttributes {
	
	/**
	 * Name of the class to use as the skin for the Up arrow when the arrow is disabled.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Name of the class to use as the skin for the Up arrow when the arrow is disabled."
	 */
	String getDownArrowDisabledSkin();

	/**
	 * Name of the class to use as the skin for the up arrow when the arrow is enabled and a user presses the mouse button over the arrow.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Name of the class to use as the skin for the up arrow when the arrow is enabled and a user presses the mouse button over the arrow."
	 */
	String getDownArrowDownSkin();

	/**
	 * Name of the class to use as the skin for the Up arrow when the arrow is enabled and the mouse pointer is not on the arrow.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Name of the class to use as the skin for the Up arrow when the arrow is enabled and the mouse pointer is not on the arrow."
	 */
	String getDownArrowUpSkin();

	/**
	 * Name of the class to use as the skin for the Up arrow when the arrow is enabled and the mouse pointer is over the arrow.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Name of the class to use as the skin for the Up arrow when the arrow is enabled and the mouse pointer is over the arrow."
	 */
	String getUpArrowOverSkin();

	/**
	 * Name of the class to use as the skin for the Up arrow when the arrow is enabled and a user presses the mouse button over the arrow.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Name of the class to use as the skin for the Up arrow when the arrow is enabled and a user presses the mouse button over the arrow."
	 */
	String getUpArrowDownSkin();

	/**
	 * Name of the class to use as the skin for the Up arrow when the arrow is disabled.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Name of the class to use as the skin for the Up arrow when the arrow is disabled."
	 */
	String getUpArrowDisabledSkin();

	/**
	 * Name of the class to use as the skin for the Up arrow when the arrow is enabled and the mouse pointer is over the arrow.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Name of the class to use as the skin for the Up arrow when the arrow is enabled and the mouse pointer is over the arrow."
	 */
	String getDownArrowOverSkin();

	/**
	 * Name of the class to use as the skin for the Up arrow when the arrow is enabled and the mouse pointer is not on the arrow.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Name of the class to use as the skin for the Up arrow when the arrow is enabled and the mouse pointer is not on the arrow."
	 */
	String getUpArrowUpSkin();
	
}
