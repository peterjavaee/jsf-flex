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
import com.googlecode.jsfFlex.component.attributes._MXMLUICompleteEffectAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIHorizontalAlignAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUILoadAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIMaintainAspectRatioAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIOpenAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIVerticalAlignAttribute;
import com.googlecode.jsfFlex.component.attributes.compBase._MXMLUIBaseAttributes;
import com.googlecode.jsfFlex.component.attributes.compBase._MXMLUISwfLoaderAttributes;

/**
 * @JSFComponent
 *   name     = "jf:mxmlSwfLoader"
 *   class    = "com.googlecode.jsfFlex.component.ext.MXMLUISwfLoader"
 *   type     = "com.googlecode.jsfFlex.MXMLUISwfLoader"
 *   tagClass = "com.googlecode.jsfFlex.taglib.ext.MXMLUISwfLoaderTag"
 *   family   = "javax.faces.MXMLSimpleBase"
 *   tagSuperclass = "org.apache.myfaces.shared_impl.taglib.UIComponentTagBase"
 *   defaultRendererType= "com.googlecode.jsfFlex.MXMLSimpleBase"
 *   
 * @author Ji Hoon Kim
 */
public abstract class AbstractMXMLUISwfLoader 
						extends MXMLUISimpleBase 
						implements _MXMLUISwfLoaderAttributes, _MXMLUIBaseAttributes, _MXMLUICompleteEffectAttribute, 
						_MXMLUIHorizontalAlignAttribute, _MXMLUILoadAttributes, _MXMLUIMaintainAspectRatioAttribute, 
						_MXMLUIOpenAttribute, _MXMLUIVerticalAlignAttribute {

	private static final String MXML_COMPONENT_RENDERER = "com.googlecode.jsfFlex.MXMLSwfLoader";
	
	public String getMXMLComponentRenderer() {
		return MXML_COMPONENT_RENDERER;
	}
	
}
