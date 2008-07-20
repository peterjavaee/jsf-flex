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
 * 							 name		= "autoRepeat"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Specifies whether to dispatch repeated buttonDown  events if the user holds down the mouse button."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "emphasized"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Draws a thick border around the Button control when the control is in its upstate if emphasized  is set to true."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "selectedField"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The name of the field in the data property which specifies the value of the Button control's selected property."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "stickyHighlighting"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "If false, the Button displays its down skin when the user presses it but changes to its over skin when the user drags the mouse off of it. If true,the Button displays its down skin when the user presses it, and continues todisplay this skin when the user drags the mouse off of it."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "toggle"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Controls whether a Button is in a toggle state or not."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "disabledIcon"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Name of the class to use as the icon when the button is not disabled."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "downIcon"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Name of the class to use as the icon when the button is not selected and the mouse button is down."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "overIcon"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Name of the class to use as the icon when the button is not selected and the mouse is over the control."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "selectedDisabledIcon"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Name of the class to use as the icon when the button is selected and disabled."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "selectedDisabledSkin"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Name of the class to use as the skin for the background and border when a toggle button is selected and disabled."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "selectedDownIcon"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Name of the class to use as the icon when the button is selected and the mouse button is down."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "selectedDownSkin"
 *   						 returnType	= "java.lang.String" 
 *   						 longDesc	= "Name of the class to use as the skin for the background and border when a toggle button is selected and the mouse button is down."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "selectedOverIcon"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Name of the class to use as the icon when the button is selected and the mouse is over the control."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "selectedOverSkin"
 *   						 returnType	= "java.lang.String" 
 *   						 longDesc	= "Name of the class to use as the skin for the background and border when a toggle button is selected and the mouse is over the control."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "selectedUpIcon"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Name of the class to use as the icon when the button is selected and the mouse button is up."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "selectedUpSkin"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Name of the class to use as the skin for the background and border when a toggle button is selected and the mouse is not over the control."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "upIcon"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Name of the class to use as the icon when a toggle button is not selected and the mouse is not over the button."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "buttonDown"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Dispatched when the user presses the Button control."
 *   						
 * @author Ji Hoon Kim
 */
public interface _MXMLUIButtonAttributes {
	
	/**
	 * Indicates whether a toggle button is toggled on (true) or off (false).
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = true
	 *    desc            = "Indicates whether a toggle button is toggled on (true) or off (false)."
	 */
	Boolean getSelected();
	
	void setSelected(Boolean selected);
	
	/**
	 * Specifies whether to dispatch repeated buttonDown  events if the user holds down the mouse button.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Specifies whether to dispatch repeated buttonDown  events if the user holds down the mouse button."
	 */
	String getAutoRepeat();

	/**
	 * Draws a thick border around the Button control when the control is in its upstate if emphasized is set to true.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Draws a thick border around the Button control when the control is in its upstate if emphasized is set to true."
	 */
	String getEmphasized();

	/**
	 * The name of the field in the data property which specifies the value ofthe Button control's selected property.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "The name of the field in the data property which specifies the value ofthe Button control's selected property."
	 */
	String getSelectedField();

	/**
	 * If false, the Button displays its down skin when the user presses it but changes to its over skin when the user drags the mouse off of it. If true,the Button displays its down skin when the user presses it, and continues todisplay this skin when the user drags the mouse off of it.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "If false, the Button displays its down skin when the user presses it but changes to its over skin when the user drags the mouse off of it. If true,the Button displays its down skin when the user presses it, and continues todisplay this skin when the user drags the mouse off of it."
	 */
	String getStickyHighlighting();

	/**
	 * Controls whether a Button is in a toggle state or not.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Controls whether a Button is in a toggle state or not."
	 */
	String getToggle();

	/**
	 * Name of the class to use as the icon when the button is not disabled.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Name of the class to use as the icon when the button is not disabled."
	 */
	String getDisabledIcon();

	/**
	 * Name of the class to use as the icon when the button is not selected and the mouse button is down.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Name of the class to use as the icon when the button is not selected and the mouse button is down."
	 */
	String getDownIcon();

	/**
	 * Name of the class to use as the icon when the button is not selected and the mouse is over the control.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Name of the class to use as the icon when the button is not selected and the mouse is over the control."
	 */
	String getOverIcon();

	/**
	 * Name of the class to use as the icon when the button is selected and disabled.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Name of the class to use as the icon when the button is selected and disabled."
	 */
	String getSelectedDisabledIcon();

	/**
	 * Name of the class to use as the skin for the background and border when a toggle button is selected and disabled.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Name of the class to use as the skin for the background and border when a toggle button is selected and disabled."
	 */
	String getSelectedDisabledSkin();

	/**
	 * Name of the class to use as the icon when the button is selected and the mouse button is down.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Name of the class to use as the icon when the button is selected and the mouse button is down."
	 */
	String getSelectedDownIcon();

	/**
	 * Name of the class to use as the skin for the background and border when a toggle button is selected and the mouse button is down.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Name of the class to use as the skin for the background and border when a toggle button is selected and the mouse button is down."
	 */
	String getSelectedDownSkin();

	/**
	 * Name of the class to use as the icon when the button is selected and the mouse is over the control.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Name of the class to use as the icon when the button is selected and the mouse is over the control."
	 */
	String getSelectedOverIcon();

	/**
	 * Name of the class to use as the skin for the background and border when a toggle button is selected and the mouse is over the control.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Name of the class to use as the skin for the background and border when a toggle button is selected and the mouse is over the control."
	 */
	String getSelectedOverSkin();

	/**
	 * Name of the class to use as the icon when the button is selected and the mouse button is up.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Name of the class to use as the icon when the button is selected and the mouse button is up."
	 */
	String getSelectedUpIcon();

	/**
	 * Name of the class to use as the skin for the background and border when a toggle button is selected and the mouse is not over the control.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Name of the class to use as the skin for the background and border when a toggle button is selected and the mouse is not over the control."
	 */
	String getSelectedUpSkin();

	/**
	 * Name of the class to use as the icon when a toggle button is not selected and the mouse is not over the button.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Name of the class to use as the icon when a toggle button is not selected and the mouse is not over the button."
	 */
	String getUpIcon();

	/**
	 * Dispatched when the user presses the Button control.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Dispatched when the user presses the Button control."
	 */
	String getButtonDown();
	
}
