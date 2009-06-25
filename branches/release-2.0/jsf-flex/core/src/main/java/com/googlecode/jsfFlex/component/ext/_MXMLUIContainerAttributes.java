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

import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFComponent;
import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFProperty;

import com.googlecode.jsfFlex.attributes._MXMLUIAutoLayoutAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIBackgroundAttachmentAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIChildAddAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIChildIndexChangeAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIChildRemoveAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIClipContentAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUICreationIndexAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIDefaultButtonAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIDisabledOverlayAlphaAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIHorizontalLineScrollSizeAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIHorizontalPageScrollSizeAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIHorizontalScrollBarAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIVerticalLineScrollSizeAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIVerticalPageScrollSizeAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIVerticalScrollBarAttribute;

/**
 * @author Ji Hoon Kim
 */
@JSFComponent
interface _MXMLUIContainerAttributes 
                    extends _MXMLUIAutoLayoutAttribute, _MXMLUIClipContentAttribute, _MXMLUICreationIndexAttribute,
                    _MXMLUIDefaultButtonAttribute, _MXMLUIHorizontalLineScrollSizeAttribute, _MXMLUIHorizontalPageScrollSizeAttribute,
                    _MXMLUIHorizontalScrollBarAttribute, _MXMLUIVerticalLineScrollSizeAttribute, _MXMLUIVerticalPageScrollSizeAttribute,
                    _MXMLUIVerticalScrollBarAttribute, _MXMLUIBackgroundAttachmentAttribute, _MXMLUIDisabledOverlayAlphaAttribute,
                    _MXMLUIChildAddAttribute, _MXMLUIChildIndexChangeAttribute, _MXMLUIChildRemoveAttribute {
	
    /**
     * The child creation policy for this Container.
     */
    @JSFProperty(
            required        =   false,
            rtexprvalue     =   false,
            desc            =   "The child creation policy for this Container."
    )
    String getCreationPolicy();
    
    void setCreationPolicy(String creationPolicy);
    
}
