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
 * 							 name		= "editedItemPosition"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The column and row index of the item renderer for the data provider item being edited, if any."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "itemEditorInstance"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "A reference to the currently active instance of the item editor, if it exists."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "itemFocusIn"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Dispatched when an item renderer gets focus, which can occur if the user clicks on an item in the List control or navigates to the item using a keyboard."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "itemEditBegin"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Dispatched when the editedItemPosition property is set and the item can be edited."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "itemEditEnd"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Dispatched when an item editing session is ending for any reason."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "itemFocusOut"
 *   						 returnType	= "java.lang.String" 
 *   						 longDesc	= "Dispatched when an item renderer loses the focus, which can occur if the user clicks another item in the List control or outside the list, or uses the keyboard to navigate to another item in the List control or outside the List control."
 *   						
 * @author Ji Hoon Kim
 */
public interface _MXMLUIItemAttributes {
	
	/**
	 * The column and row index of the item renderer for the data provider item being edited, if any.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "The column and row index of the item renderer for the data provider item being edited, if any."
	 */
	String getEditedItemPosition();

	/**
	 * A reference to the currently active instance of the item editor, if it exists.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "A reference to the currently active instance of the item editor, if it exists."
	 */
	String getItemEditorInstance();
	
	/**
	 * Dispatched when the editedItemPosition property is set and the item can be edited.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Dispatched when the editedItemPosition property is set and the item can be edited."
	 */
	String getItemEditBegin();

	/**
	 * Dispatched when an item editing session is ending for any reason.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Dispatched when an item editing session is ending for any reason."
	 */
	String getItemEditEnd();

	/**
	 * Dispatched when an item renderer gets focus, which can occur if the user clicks on an itemin the List control or navigates to the item using a keyboard.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Dispatched when an item renderer gets focus, which can occur if the user clicks on an itemin the List control or navigates to the item using a keyboard."
	 */
	String getItemFocusIn();

	/**
	 * Dispatched when an item renderer loses the focus, which can occur if the user clicksanother item in the List control or outside the list, or uses the keyboard to navigateto another item in the List control or outside the List control.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Dispatched when an item renderer loses the focus, which can occur if the user clicks another item in the List control or outside the list, or uses the keyboard to navigate to another item in the List control or outside the List control."
	 */
	String getItemFocusOut();
	
}
