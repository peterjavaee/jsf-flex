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
package com.googlecode.jsfFlex.attributes;

import java.io.IOException;
import java.util.Set;

import javax.faces.component.UIComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;

import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFComponent;

import com.googlecode.jsfFlex.shared.adapter.IFlexContract;
import com.googlecode.jsfFlex.shared.beans.templates.TokenValue;
import com.googlecode.jsfFlex.shared.context.AbstractFlexContext;

/**
 * In order to simplify development and focus in bridging of JSF and Flex, all attributes 
 * of a component that is not specific to the JSF Flex project and not boundable to a bean will be 
 * provided as a sub-tag of the component. Meaning one can consider the component to be an XML Element  
 * node and this tag/component to be an Attribute node.
 * 
 * @author Ji Hoon Kim
 */
@JSFComponent(
        type    =   "com.googlecode.jsfFlex.FlexAttributeNode",
        family  =   "javax.faces.FlexUIAttributeNode",
        desc    =   "Attribute Node component"
)
public abstract class AbstractFlexUIAttributeNode 
                        extends UIComponentBase 
                        implements IFlexUINameAttribute, IFlexUIValueAttribute {
    
    /* 
     * Only job for this Renderer is to create a TokenValue object and add it to its
     * parent's collection
     */
    @Override
    public void encodeBegin(FacesContext context) throws IOException {
        super.encodeBegin(context);
        
        /*
         * Only job of this Renderer/Component is to 
         */
        
        AbstractFlexContext flexContext = AbstractFlexContext.getCurrentInstance();
        
        if(flexContext.isProductionEnv()){
            return;
        }
        
        UIComponent parent = getParent();
        
        if(parent == null){
            //this should never happen
            throw new NullPointerException("Component " + getClass().getName() + 
                                                " lacks parent component");
        }
        
        if(parent instanceof IFlexContract){
            IFlexContract flexUIComp = IFlexContract.class.cast( parent );
            Set<TokenValue> tokenValueSet = flexUIComp.getAnnotationDocletParserInstance().getTokenValueSet(); 
            
            tokenValueSet.add(new TokenValue(getName(), getValue()));
        }
        
    }
    
    public abstract String getName();
    
    public abstract String getValue();
    
}
