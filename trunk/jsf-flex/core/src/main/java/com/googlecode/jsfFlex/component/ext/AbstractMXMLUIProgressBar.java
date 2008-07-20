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
package com.googlecode.jsfFlex.component.ext;

import com.googlecode.jsfFlex.component.MXMLUISimpleBase;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBarColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBorderColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUICompleteEffectAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDirectionAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDisabledColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFontFamilyAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFontGeneralAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFontSpecificAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIGapAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIHideAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUILabelAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUILabelPlacementAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUILeadingAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUILoadAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIMinMaxAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIPaddingHorizontalAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIShowAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUITextStyleAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUITrackAttributes;
import com.googlecode.jsfFlex.component.attributes.compBase._MXMLUIBaseAttributes;

/**
 * @JSFComponent
 *   name     = "jf:mxmlProgressBar"
 *   class    = "com.googlecode.jsfFlex.component.ext.MXMLUIProgressBar"
 *   type     = "com.googlecode.jsfFlex.MXMLUIProgressBar"
 *   tagClass = "com.googlecode.jsfFlex.taglib.ext.MXMLUIProgressBarTag"
 *   family   = "javax.faces.MXMLSimpleBase"
 *   tagSuperclass = "org.apache.myfaces.shared_impl.taglib.UIComponentTagBase"
 *   defaultRendererType= "com.googlecode.jsfFlex.MXMLSimpleBase"
 *   
 * @JSFJspProperties
 * 		properties	=		
 *   						@JSFJspProperty
 * 							 name		= "conversion"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Number used to convert incoming current bytes loaded value and the total bytes loaded values."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "indeterminate"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Whether the ProgressBar control has a determinate or indeterminate appearance."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "mode"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Specifies the method used to update the bar."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "barSkin"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Skin style for a determinate progress bar."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "indeterminateSkin"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Skin style for an indeterminate progress bar."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "labelWidth"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The width of the label in pixels."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "trackHeight"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The height of the track in pixels."
 *   						
 * @author Ji Hoon Kim
 */
public abstract class AbstractMXMLUIProgressBar 
						extends MXMLUISimpleBase 
						implements _MXMLUIBaseAttributes, _MXMLUIBarColorAttribute, _MXMLUIBorderColorAttribute, 
						_MXMLUIColorAttribute, _MXMLUICompleteEffectAttribute, _MXMLUIDirectionAttribute, 
						_MXMLUIDisabledColorAttribute, _MXMLUIFontFamilyAttribute, _MXMLUIFontGeneralAttributes, 
						_MXMLUIFontSpecificAttributes, _MXMLUIGapAttributes, _MXMLUILabelAttribute, 
						_MXMLUILabelPlacementAttribute, _MXMLUILeadingAttribute, _MXMLUILoadAttributes, 
						_MXMLUIMinMaxAttributes, _MXMLUIPaddingHorizontalAttributes, _MXMLUITextStyleAttributes, 
						_MXMLUITrackAttributes, _MXMLUIHideAttribute, _MXMLUIShowAttribute {
	
	private static final String MXML_COMPONENT_RENDERER = "com.googlecode.jsfFlex.MXMLProgressBar";
	
	public String getMXMLComponentRenderer() {
		return MXML_COMPONENT_RENDERER;
	}
	
}
