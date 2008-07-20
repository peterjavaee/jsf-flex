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
import com.googlecode.jsfFlex.component.attributes._MXMLUIArrowAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBorderColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUICornerRadiusAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDirectionAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFillAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIHighlightAlphaAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIRepeatAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIScrollAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIThumbSkinAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUITrackAttributes;
import com.googlecode.jsfFlex.component.attributes.compBase._MXMLUIBaseAttributes;
import com.googlecode.jsfFlex.component.attributes.compBase._MXMLUIScrollBarAttributes;

/**
 * @JSFComponent
 *   name     = "jf:mxmlHScrollBar"
 *   class    = "com.googlecode.jsfFlex.component.ext.MXMLUIHScrollBar"
 *   type     = "com.googlecode.jsfFlex.MXMLUIHScrollBar"
 *   tagClass = "com.googlecode.jsfFlex.taglib.ext.MXMLUIHScrollBarTag"
 *   family   = "javax.faces.MXMLSimpleBase"
 *   tagSuperclass = "org.apache.myfaces.shared_impl.taglib.UIComponentTagBase"
 *   defaultRendererType= "com.googlecode.jsfFlex.MXMLSimpleBase"
 *   
 * @author Ji Hoon Kim
 */
public abstract class AbstractMXMLUIHScrollBar 
						extends MXMLUISimpleBase 
						implements _MXMLUIScrollBarAttributes, _MXMLUIBaseAttributes, _MXMLUIArrowAttributes, 
						_MXMLUIBorderColorAttribute, _MXMLUICornerRadiusAttribute, _MXMLUIDirectionAttribute, 
						_MXMLUIFillAttributes, _MXMLUIHighlightAlphaAttribute, _MXMLUIRepeatAttributes, 
						_MXMLUIScrollAttribute, _MXMLUIThumbSkinAttributes, _MXMLUITrackAttributes {

	private static final String MXML_COMPONENT_RENDERER = "com.googlecode.jsfFlex.MXMLHScrollBar";
	
	public String getMXMLComponentRenderer() {
		return MXML_COMPONENT_RENDERER;
	}
	
}
