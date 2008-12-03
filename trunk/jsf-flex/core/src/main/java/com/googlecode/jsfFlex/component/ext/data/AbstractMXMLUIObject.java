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
package com.googlecode.jsfFlex.component.ext.data;

import com.googlecode.jsfFlex.component.MXMLUISimpleBase;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDataAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUILabelAttribute;

/**
 * @JSFComponent
 *   name     = "jf:mxmlObject"
 *   class    = "com.googlecode.jsfFlex.component.ext.data.MXMLUIObject"
 *   type     = "com.googlecode.jsfFlex.MXMLUIObject"
 *   tagClass = "com.googlecode.jsfFlex.taglib.ext.data.MXMLUIObjectTag"
 *   family   = "javax.faces.MXMLSimple"
 *   defaultRendererType= "com.googlecode.jsfFlex.MXMLObject"
 * 
 * @author Ji Hoon Kim
 */
public abstract class AbstractMXMLUIObject 
						extends MXMLUISimpleBase
						implements _MXMLUIDataAttribute, _MXMLUILabelAttribute {
	
}