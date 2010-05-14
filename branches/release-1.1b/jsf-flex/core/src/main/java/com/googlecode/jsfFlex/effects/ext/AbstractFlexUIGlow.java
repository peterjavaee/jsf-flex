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
package com.googlecode.jsfFlex.effects.ext;

import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFComponent;
import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFProperty;

import com.googlecode.jsfFlex.attributes.IFlexUIAlphaFromAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIAlphaToAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBlurXFromAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBlurXToAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBlurYFromAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBlurYToAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIInnerAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIKnockoutAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIStrengthAttribute;
import com.googlecode.jsfFlex.component.AbstractFlexUISimpleBase;

/**
 * @author Ji Hoon Kim
 */
@JSFComponent(
        name                =   "jf:flexGlow",
        clazz               =   "com.googlecode.jsfFlex.effects.ext.FlexUIGlow",
        type                =   "com.googlecode.jsfFlex.FlexUIGlow",
        tagClass            =   "com.googlecode.jsfFlex.taglib.effects.ext.FlexUIGlowTag",
        family              =   "javax.faces.FlexSimple",
        defaultRendererType =   "com.googlecode.jsfFlex.FlexGlow"
)
public abstract class AbstractFlexUIGlow 
                                extends AbstractFlexUISimpleBase 
                                implements IFlexUITweenEffectAttributes, IFlexUIAlphaFromAttribute, IFlexUIAlphaToAttribute, 
                                IFlexUIBlurXFromAttribute, IFlexUIBlurXToAttribute, IFlexUIBlurYFromAttribute, IFlexUIBlurYToAttribute, 
                                IFlexUIColorAttribute, IFlexUIInnerAttribute, IFlexUIKnockoutAttribute, IFlexUIStrengthAttribute {

    /**
     * Id of the component.
     */
    @JSFProperty(
            inheritTag  =   true,
            rtexprvalue =   true,
            literalOnly =   true,
            desc        =   "Id of the component."
    )
    public String getId(){
        return super.getId();
    }
    
}
