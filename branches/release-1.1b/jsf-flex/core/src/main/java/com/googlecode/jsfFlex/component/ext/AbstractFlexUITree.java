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

import com.googlecode.jsfFlex.attributes.IFlexUIDataDescriptorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDataProviderAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDefaultLeafIconAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDepthColorsAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDisclosureClosedIconAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDisclosureOpenIconAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIEditableAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFirstVisibleItemAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFolderClosedIconAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFolderOpenIconAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIIndentationAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIItemCloseAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIItemIconsAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIItemOpenAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIItemOpeningAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIOpenDurationAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIOpenEasingFunctionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIOpenItemsAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIRowCountAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIShowRootAttribute;

/**
 * @author Ji Hoon Kim
 */
@JSFComponent(
        name                =   "jf:flexTree",
        clazz               =   "com.googlecode.jsfFlex.component.ext.FlexUITree",
        type                =   "com.googlecode.jsfFlex.FlexUITree",
        tagClass            =   "com.googlecode.jsfFlex.taglib.component.ext.FlexUITreeTag",
        family              =   "javax.faces.FlexInput",
        defaultRendererType =   "com.googlecode.jsfFlex.FlexTree",
        tagSuperclass       =   "com.googlecode.jsfFlex.taglib.AbstractFlexUIInputTagBase"
)
public abstract class AbstractFlexUITree 
						extends com.googlecode.jsfFlex.component.FlexUISelectedIndexBase
						implements IFlexUIListAttributes, IFlexUIDataDescriptorAttribute, IFlexUIFirstVisibleItemAttribute, 
                        IFlexUIItemIconsAttribute, IFlexUIOpenItemsAttribute, IFlexUIShowRootAttribute, IFlexUIDefaultLeafIconAttribute,
                        IFlexUIDepthColorsAttribute, IFlexUIDisclosureClosedIconAttribute, IFlexUIDisclosureOpenIconAttribute, 
                        IFlexUIFolderClosedIconAttribute, IFlexUIFolderOpenIconAttribute, IFlexUIIndentationAttribute, 
                        IFlexUIOpenDurationAttribute, IFlexUIOpenEasingFunctionAttribute, IFlexUIItemCloseAttribute, 
                        IFlexUIItemOpenAttribute, IFlexUIItemOpeningAttribute, IFlexUIEditableAttribute, 
                        IFlexUIDataProviderAttribute, IFlexUIRowCountAttribute {
	
}
