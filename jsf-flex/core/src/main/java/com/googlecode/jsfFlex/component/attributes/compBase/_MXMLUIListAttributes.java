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
 *   						@JSFJspProperty
 * 							 name		= "editorDataField"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The name of the property of the item editor that contains the new data for the list item."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "editorHeightOffset"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The height of the item editor, in pixels, relative to the size of the item renderer."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "editorUsesEnterKey"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "A flag that indicates whether the item editor uses Enter key."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "editorWidthOffset"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The width of the item editor, in pixels, relative to the size of the item renderer."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "editorXOffset"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The x location of the upper-left corner of the item editor, in pixels, relative to the upper-left corner of the item."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "editorYOffset"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The y location of the upper-left corner of the item editor, in pixels, relative to the upper-left corner of the item."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "itemEditor"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The class factory for the item editor to use for the control, if the editable property is set to true."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "rendererIsEditor"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Specifies whether the item renderer is also an item editor."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "itemEditBeginning"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Dispatched when the user releases the mouse button while over an item, tabs to the List or within the List, or in any other way attempts to edit an item."
 * 
 * @author Ji Hoon Kim
 */
public interface _MXMLUIListAttributes {
	
	/**
	 * The name of the property of the item editor that contains the new data for the list item.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "The name of the property of the item editor that contains the new data for the list item."
	 */
	String getEditorDataField();

	/**
	 * The height of the item editor, in pixels, relative to the size of the item renderer.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "The height of the item editor, in pixels, relative to the size of the item renderer."
	 */
	String getEditorHeightOffset();

	/**
	 * A flag that indicates whether the item editor uses Enter key.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "A flag that indicates whether the item editor uses Enter key."
	 */
	String getEditorUsesEnterKey();

	/**
	 * The width of the item editor, in pixels, relative to the size of the item renderer.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "The width of the item editor, in pixels, relative to the size of the item renderer."
	 */
	String getEditorWidthOffset();

	/**
	 * The x location of the upper-left corner of the item editor, in pixels, relative to the upper-left corner of the item.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "The x location of the upper-left corner of the item editor, in pixels, relative to the upper-left corner of the item."
	 */
	String getEditorXOffset();

	/**
	 * The y location of the upper-left corner of the item editor, in pixels, relative to the upper-left corner of the item.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "The y location of the upper-left corner of the item editor, in pixels, relative to the upper-left corner of the item."
	 */
	String getEditorYOffset();

	/**
	 * The class factory for the item editor to use for the control, if the editable property is set to true.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "The class factory for the item editor to use for the control, if the editable property is set to true."
	 */
	String getItemEditor();

	/**
	 * Specifies whether the item renderer is also an item editor.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Specifies whether the item renderer is also an item editor."
	 */
	String getRendererIsEditor();

	/**
	 * Dispatched when the user releases the mouse button while over an item, tabs to the List or within the List, or in any other way attempts to edit an item.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Dispatched when the user releases the mouse button while over an item, tabs to the List or within the List, or in any other way attempts to edit an item."
	 */
	String getItemEditBeginning();
	
}
