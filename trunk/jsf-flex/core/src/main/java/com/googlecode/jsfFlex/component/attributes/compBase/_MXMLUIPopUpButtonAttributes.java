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
 *  						 name		= "openAlways"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "If true, specifies to pop up the popUp when you click the main button."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "popUp"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Specifies the UIComponent object, or object defined by a subclass of UIComponent, to pop up."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "popUpDownSkin"
 *   						 returnType	= "java.lang.String" 
 *   						 longDesc	= "Skin class for the popUpDown state (when arrowButton is in down state) of the background and border."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "popUpGap"
 *   						 returnType	= "java.lang.String" 
 *   						 longDesc	= "Number of vertical pixels between the PopUpButton and the specified popup UIComponent."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "popUpIcon"
 *   						 returnType	= "java.lang.String" 
 *   						 longDesc	= "The icon used for the right button of PopUpButton."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "popUpOverSkin"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Skin class for the popUpOver state (over arrowButton) of the background and border."
 * 
 * @author Ji Hoon Kim
 */
public interface _MXMLUIPopUpButtonAttributes {
	
	/**
	 * If true, specifies to pop up the popUp when you click the main button.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "If true, specifies to pop up the popUp when you click the main button."
	 */
	String getOpenAlways();

	/**
	 * Specifies the UIComponent object, or object defined by a subclass of UIComponent, to pop up.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Specifies the UIComponent object, or object defined by a subclass of UIComponent, to pop up."
	 */
	String getPopUp();

	/**
	 * Skin class for the popUpDown state (when arrowButton is in down state) of the background and border.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Skin class for the popUpDown state (when arrowButton is in down state) of the background and border."
	 */
	String getPopUpDownSkin();

	/**
	 * Number of vertical pixels between the PopUpButton and the specified popup UIComponent.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Number of vertical pixels between the PopUpButton and the specified popup UIComponent."
	 */
	String getPopUpGap();

	/**
	 * The icon used for the right button of PopUpButton.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "The icon used for the right button of PopUpButton."
	 */
	String getPopUpIcon();

	/**
	 * Skin class for the popUpOver state (over arrowButton) of the background and border.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Skin class for the popUpOver state (over arrowButton) of the background and border."
	 */
	String getPopUpOverSkin();
	
}
