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
import com.googlecode.jsfFlex.component.attributes._MXMLUIDataProviderAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDirectionAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDropDownEventColorAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIGapAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIHorizontalAlignAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIIconFieldAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIItemClickAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUILabelFieldAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUISelectedIndexAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUITextEventColorAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIToolTipFieldAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIVerticalAlignAttribute;
import com.googlecode.jsfFlex.component.attributes.compBase._MXMLUIBaseAttributes;

/**
 * @JSFComponent
 *   name     = "jf:mxmlLinkBar"
 *   class    = "com.googlecode.jsfFlex.component.ext.MXMLUILinkBar"
 *   type     = "com.googlecode.jsfFlex.MXMLUILinkBar"
 *   tagClass = "com.googlecode.jsfFlex.taglib.ext.MXMLUILinkBarTag"
 *   family   = "javax.faces.MXMLSimpleBase"
 *   tagSuperclass = "org.apache.myfaces.shared_impl.taglib.UIComponentTagBase"
 *   defaultRendererType= "com.googlecode.jsfFlex.MXMLSimpleBase"
 *   
 * @JSFJspProperties
 * 		properties	=		
 *   						@JSFJspProperty
 * 							 name		= "separatorColor"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Separator color used by the default separator skin."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "separatorSkin"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Seperator symbol between LinkButton controls in the LinkBar."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "separatorWidth"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Separator pixel width, in pixels."
 *   						
 * @author Ji Hoon Kim
 */
public abstract class AbstractMXMLUILinkBar 
						extends MXMLUISimpleBase 
						implements _MXMLUIToolTipFieldAttribute, _MXMLUIVerticalAlignAttribute, _MXMLUIBaseAttributes, 
						_MXMLUIDataProviderAttribute, _MXMLUIDirectionAttribute, _MXMLUIDropDownEventColorAttributes, 
						_MXMLUIGapAttributes, _MXMLUIHorizontalAlignAttribute, _MXMLUIIconFieldAttribute, 
						_MXMLUIItemClickAttribute, _MXMLUILabelFieldAttribute, _MXMLUISelectedIndexAttribute, 
						_MXMLUITextEventColorAttributes {

	private static final String MXML_COMPONENT_RENDERER = "com.googlecode.jsfFlex.MXMLLinkBar";
	
	public String getMXMLComponentRenderer() {
		return MXML_COMPONENT_RENDERER;
	}
	
}
