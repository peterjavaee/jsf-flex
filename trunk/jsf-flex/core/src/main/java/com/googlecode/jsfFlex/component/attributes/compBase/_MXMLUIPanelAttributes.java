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
 * 							 name		= "status"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Text in the status area of the title bar."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "titleIcon"
 *   						 returnType	= "java.lang.String" 
 *   						 longDesc	= "The icon displayed in the title bar."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "borderAlpha"
 *   						 returnType	= "java.lang.String" 
 *   						 longDesc	= "Alpha of the title bar, control bar and sides of the Panel. The default value is 0.4."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "borderThicknessBottom"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Thickness of the bottom border of the Panel control."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "borderThicknessLeft"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Thickness of the left border of the Panel."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "borderThicknessRight"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Thickness of the right border of the Panel."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "borderThicknessTop"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Thickness of the top border of the Panel."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "closeButtonDisabledSkin"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The close button disabled skin."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "closeButtonDownSkin"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The close button down skin."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "closeButtonOverSkin"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The close button over skin."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "closeButtonUpSkin"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The close button up skin."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "controlBarStyleName"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Name of the CSS style declaration that specifies styles to apply to any control bar child subcontrol."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "footerColors"
 *   						 returnType	= "java.lang.String" 
 *   						 longDesc	= "Array of two colors used to draw the footer background."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "roundedBottomCorners"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Flag to enable rounding for the bottom two corners of the container."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "statusStyleName"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Style declaration name for the status in the title bar."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "titleBackgroundSkin"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The title background skin."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "titleStyleName"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Style declaration name for the text in the title bar."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "resizeEndEffect"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Specifies the effect to play after a Resize effect finishes playing."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "resizeStartEffect"
 *   						 returnType	= "java.lang.String" 
 *   						 longDesc	= "Specifies the effect to play before a Resize effect begins playing."
 * 
 * @author Ji Hoon Kim
 */
public interface _MXMLUIPanelAttributes {
	
	/**
	 * Text in the status area of the title bar.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Text in the status area of the title bar."
	 */
	String getStatus();

	/**
	 * The icon displayed in the title bar.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "The icon displayed in the title bar."
	 */
	String getTitleIcon();

	/**
	 * Alpha of the title bar, control bar and sides of the Panel. The default value is 0.4.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Alpha of the title bar, control bar and sides of the Panel. The default value is 0.4."
	 */
	String getBorderAlpha();

	/**
	 * Thickness of the bottom border of the Panel control.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Thickness of the bottom border of the Panel control."
	 */
	String getBorderThicknessBottom();

	/**
	 * Thickness of the left border of the Panel.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Thickness of the left border of the Panel."
	 */
	String getBorderThicknessLeft();

	/**
	 * Thickness of the right border of the Panel.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Thickness of the right border of the Panel."
	 */
	String getBorderThicknessRight();

	/**
	 * Thickness of the top border of the Panel.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Thickness of the top border of the Panel."
	 */
	String getBorderThicknessTop();

	/**
	 * The close button disabled skin.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "The close button disabled skin."
	 */
	String getCloseButtonDisabledSkin();

	/**
	 * The close button down skin.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "The close button down skin."
	 */
	String getCloseButtonDownSkin();

	/**
	 * The close button over skin.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "The close button over skin."
	 */
	String getCloseButtonOverSkin();

	/**
	 * The close button up skin.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "The close button up skin."
	 */
	String getCloseButtonUpSkin();

	/**
	 * Name of the CSS style declaration that specifies styles to apply to any control bar child subcontrol.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Name of the CSS style declaration that specifies styles to apply to any control bar child subcontrol."
	 */
	String getControlBarStyleName();

	/**
	 * Array of two colors used to draw the footer background.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Array of two colors used to draw the footer background."
	 */
	String getFooterColors();

	/**
	 * Flag to enable rounding for the bottom two corners of the container.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Flag to enable rounding for the bottom two corners of the container."
	 */
	String getRoundedBottomCorners();

	/**
	 * Style declaration name for the status in the title bar.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Style declaration name for the status in the title bar."
	 */
	String getStatusStyleName();

	/**
	 * The title background skin.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "The title background skin."
	 */
	String getTitleBackgroundSkin();

	/**
	 * Style declaration name for the text in the title bar.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Style declaration name for the text in the title bar."
	 */
	String getTitleStyleName();

	/**
	 * Specifies the effect to play after a Resize effect finishes playing.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Specifies the effect to play after a Resize effect finishes playing."
	 */
	String getResizeEndEffect();

	/**
	 * Specifies the effect to play before a Resize effect begins playing.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Specifies the effect to play before a Resize effect begins playing."
	 */
	String getResizeStartEffect();
	
}
