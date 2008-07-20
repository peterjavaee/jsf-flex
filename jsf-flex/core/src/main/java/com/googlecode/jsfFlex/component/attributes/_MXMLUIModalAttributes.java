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
 * 							 name		= "modalTransparencyDuration"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Duration, in milliseconds, of the modal transparency effect that plays when a modal window opens or closes. The default value is 100."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "modalTransparency"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Modality of components launched by the PopUp Manager is simulated by creating a large translucent overlay underneath the component. Because of the way translucent objects are rendered, you may notice a slight dimming of the objects under the overlay. The effective transparency can be set by changing the modalTransparency value from 0.0 (fully transparent) to 1.0 (fully opaque). You can also set the color of the overlay by changing the modalTransparencyColor style. The default value is 0.5."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "modalTransparencyColor"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Color of the modal overlay layer. This style is used in conjunction with the modalTransparency style to determine the colorization applied to the application when a modal window is open. The default value is #DDDDDD."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "modalTransparencyBlur"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The blur applied to the application while a modal window is open. A Blur effects oftens the details of an image. The default value is 3."
 *   						
 * @author Ji Hoon Kim
 */
public interface _MXMLUIModalAttributes {
	
	/**
	 * Duration, in milliseconds, of the modal transparency effect that plays when a modal window opens or closes. The default value is 100.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Duration, in milliseconds, of the modal transparency effect that plays when a modal window opens or closes. The default value is 100."
	 */
	String getModalTransparencyDuration();

	/**
	 * Modality of components launched by the PopUp Manager is simulated by creating a large translucent overlay underneath the component. Because of the way translucent objects are rendered, you may notice a slight dimming of the objects under the overlay. The effective transparency can be set by changing the modalTransparency value from 0.0 (fully transparent)to 1.0 (fully opaque). You can also set the color of the overlay by changing the modalTransparencyColor style. The default value is 0.5.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Modality of components launched by the PopUp Manager is simulated by creating a large translucent overlay underneath the component. Because of the way translucent objects are rendered, you may notice a slight dimming of the objects under the overlay. The effective transparency can be set by changing the modalTransparency value from 0.0 (fully transparent)to 1.0 (fully opaque). You can also set the color of the overlay by changing the modalTransparencyColor style. The default value is 0.5."
	 */
	String getModalTransparency();

	/**
	 * Color of the modal overlay layer. This style is used in conjunction with the modalTransparencystyle to determine the colorization applied to the application when a modal window is open.The default value is #DDDDDD.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Color of the modal overlay layer. This style is used in conjunction with the modalTransparencystyle to determine the colorization applied to the application when a modal window is open.The default value is #DDDDDD."
	 */
	String getModalTransparencyColor();

	/**
	 * The blur applied to the application while a modal window is open. A Blur effects oftens the details of an image. The default value is 3.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "The blur applied to the application while a modal window is open. A Blur effects oftens the details of an image. The default value is 3."
	 */
	String getModalTransparencyBlur();
	
}
