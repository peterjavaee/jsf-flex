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
 * 							 name		= "dividerAffordance"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Thickness in pixels of the area where the user can click to drag a divider."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "dividerAlpha"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The alpha value that determines the transparency of the dividers."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "dividerColor"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Color of the dividers when the user presses or drags the dividers if the liveDragging property is set to false."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "dividerSkin"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The divider skin."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "dividerThickness"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Thickness in pixels of the dividers when the user presses or drags the dividers, if the liveDragging property is set to false."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "horizontalDividerCursor"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The cursor skin for a horizontal DividedBox."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "verticalDividerCursor"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The cursor skin for a vertical DividedBox."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "dividerPress"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Dispatched when the user presses any divider in this container."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "dividerDrag"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Dispatched multiple times as the user drags any divider."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "dividerRelease"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Dispatched when the user releases a divider."
 * 
 * @author Ji Hoon Kim
 */
public interface _MXMLUIDividedBoxAttributes {
	
	/**
	 * Thickness in pixels of the area where the user can click to drag a divider.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Thickness in pixels of the area where the user can click to drag a divider."
	 */
	String getDividerAffordance();

	/**
	 * The alpha value that determines the transparency of the dividers.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "The alpha value that determines the transparency of the dividers."
	 */
	String getDividerAlpha();

	/**
	 * Color of the dividers when the user presses or drags the dividers if the liveDragging property is set to false.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Color of the dividers when the user presses or drags the dividers if the liveDragging property is set to false."
	 */
	String getDividerColor();

	/**
	 * The divider skin.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "The divider skin."
	 */
	String getDividerSkin();

	/**
	 * Thickness in pixels of the dividers when the user presses or drags the dividers, if the liveDragging property is set to false.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Thickness in pixels of the dividers when the user presses or drags the dividers, if the liveDragging property is set to false."
	 */
	String getDividerThickness();

	/**
	 * The cursor skin for a horizontal DividedBox.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "The cursor skin for a horizontal DividedBox."
	 */
	String getHorizontalDividerCursor();

	/**
	 * The cursor skin for a vertical DividedBox.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "The cursor skin for a vertical DividedBox."
	 */
	String getVerticalDividerCursor();

	/**
	 * Dispatched when the user presses any divider in this container.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Dispatched when the user presses any divider in this container."
	 */
	String getDividerPress();

	/**
	 * Dispatched multiple times as the user drags any divider.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Dispatched multiple times as the user drags any divider."
	 */
	String getDividerDrag();

	/**
	 * Dispatched when the user releases a divider.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Dispatched when the user releases a divider."
	 */
	String getDividerRelease();
	
}
