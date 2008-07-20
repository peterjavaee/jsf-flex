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
 * 							 name		= "repeatDelay"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Number of milliseconds to wait."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "repeatInterval"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Number of milliseconds in the actions."
 *   						
 * @author Ji Hoon Kim
 */
public interface _MXMLUIRepeatAttributes {
	
	/**
	 * Number of milliseconds to wait.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Number of milliseconds to wait."
	 */
	String getRepeatDelay();

	/**
	 * Number of milliseconds in the actions.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Number of milliseconds in the actions."
	 */
	String getRepeatInterval();
	
}
