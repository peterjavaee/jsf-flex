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
 * 							 name		= "shadowColor",
 *   						 returnType	= "java.lang.String",
 *   						 longDesc	= "The shadow color of the line."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "strokeWidth",
 *   						 returnType	= "java.lang.String",
 *   						 longDesc	= "The thickness of the rule in pixels."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "strokeColor",
 *   						 returnType	= "java.lang.String", 
 *   						 longDesc	= "The color of the line."
 *   						
 * @author Ji Hoon Kim
 */
public interface _MXMLUIRuleAttributes {
	
	/**
	 * The shadow color of the line.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "The shadow color of the line."
	 */
	String getShadowColor();

	/**
	 * The thickness of the rule in pixels.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "The thickness of the rule in pixels."
	 */
	String getStrokeWidth();

	/**
	 * The color of the line.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "The color of the line."
	 */
	String getStrokeColor();
	
}
