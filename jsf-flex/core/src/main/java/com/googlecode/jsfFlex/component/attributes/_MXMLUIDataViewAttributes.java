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
 * 
 * @JSFJspProperties
 * 		properties	=		
 *   						@JSFJspProperty
 * 							 name = "showRoot"
 *   						 returnType = "java.lang.String"
 *   						 longDesc = "A Boolean flag that specifies whether to display the data provider's root node."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name = "dataDescriptor"
 *   						 returnType = "java.lang.String"
 *   						 longDesc = "The object that accesses and manipulates data in the data provider."
 *   						
 * @author Ji Hoon Kim
 */
public interface _MXMLUIDataViewAttributes {
	
	/**
	 * A Boolean flag that specifies whether to display the data provider's root node.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "A Boolean flag that specifies whether to display the data provider's root node."
	 */
	String getShowRoot();
	
	/**
	 * The object that accesses and manipulates data in the data provider.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "The object that accesses and manipulates data in the data provider."
	 */
	String getDataDescriptor();
	
}
