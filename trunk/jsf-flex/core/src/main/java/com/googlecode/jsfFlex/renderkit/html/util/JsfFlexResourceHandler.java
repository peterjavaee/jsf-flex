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
package com.googlecode.jsfFlex.renderkit.html.util;

import javax.faces.context.FacesContext;

import org.apache.myfaces.renderkit.html.util.ResourceHandler;

/**
 * This code is basically the replica of the MyFaces MyFacesResourceHandler.
 * 
 * Unfortunately the validation for that class is done as a private method, so the code is 
 * duplicated here. Will create a patch later for MyFaces.
 * 
 * @author Ji Hoon Kim
 */
public class JsfFlexResourceHandler implements ResourceHandler {
	
	private Class _jsfFlexComponent;
	private String _resource;
	
	public JsfFlexResourceHandler(Class jsfFlexComponent, String resource){
		validateComponentPackage(jsfFlexComponent);
		_jsfFlexComponent = jsfFlexComponent;
		_resource = resource;
	}
	
	protected void validateComponentPackage(Class componentToValidate){
		if(!componentToValidate.getName().startsWith(JsfFlexResourceLoader.JSF_FLEX_COMP + ".")){
			throw new IllegalArgumentException("expected a jsfFlex component class in package " + 
												JsfFlexResourceLoader.JSF_FLEX_COMP);
		}
	}
	
	public Class getResourceLoaderClass() {
		return JsfFlexResourceLoader.class;
	}
	
	public String getResourceUri(FacesContext context)
    {
        String className = _jsfFlexComponent.getName();
        StringBuffer sb = new StringBuffer();
        sb.append(className.substring(
        		JsfFlexResourceLoader.JSF_FLEX_COMP.length() + 1));
        sb.append("/");
        if (_resource != null)
        {
            if (_resource.startsWith("/"))
            {
                throw new IllegalArgumentException(
                    "jsfFlex resources are always relative to the associated class." +
                    " Absolute resource paths are not allowed: " + _resource);
            }
            sb.append(_resource);
        }
        return sb.toString();
    }
	
}
