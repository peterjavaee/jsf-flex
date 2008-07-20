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
package com.googlecode.jsfFlex.framework;

import javax.faces.component.UIComponent;

import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;
import com.googlecode.jsfFlex.framework.util.MXMLRendererKit;

/**
 * @author Ji Hoon Kim
 */
public class MXMLComponentBuilder {
	
	private UIComponent _jsfComponent;
	private String _compFamily;
	private String _rendererClass;
	private _Component _component;
	
	private MXMLComponentBuilder(){
		super();
	}
	
	public MXMLComponentBuilder(UIComponent jsfComponent, String compFamily, String rendererClass){
		_jsfComponent = jsfComponent;
		_compFamily = compFamily;
		_rendererClass = MXMLRendererKit.getRendererClass(_compFamily, rendererClass);
	}
	
	public void loadClass() throws ComponentBuildException {
		
		if(_component == null){
			try{
				_component = (_Component) MXMLComponentBuilder.class.getClassLoader().loadClass(_rendererClass).newInstance();
			}catch(InstantiationException instantiationExcept){
				throw new ComponentBuildException("Error in creating an instance of " + _rendererClass, instantiationExcept);
			}catch(IllegalAccessException illegalAccessExcept){
				throw new ComponentBuildException("Error in creating an instance of " + _rendererClass, illegalAccessExcept);
			}catch(ClassNotFoundException classNotFoundExcept){
				throw new ComponentBuildException("Error in creating an instance of " + _rendererClass, classNotFoundExcept);
			}
		}
		
	}
	
	public void buildComponentBegin() throws ComponentBuildException{
		_component.buildComponentBegin(_jsfComponent);
	}
	
	public void buildComponentInterlude() throws ComponentBuildException{
		
		_component.buildComponentInterlude(_jsfComponent);
	}
	
	public void buildComponentChildren() throws ComponentBuildException{
		_component.buildComponentChildren(_jsfComponent);
	}
	
	public void buildComponentEnd() throws ComponentBuildException{
		_component.buildComponentEnd(_jsfComponent);
	}
	
	public String getCompFamily() {
		return _compFamily;
	}

	public void setCompFamily(String compFamily) {
		_compFamily = compFamily;
	}

	public UIComponent getJsfComponent() {
		return _jsfComponent;
	}

	public void setJsfComponent(UIComponent jsfComponent) {
		_jsfComponent = jsfComponent;
	}

	public String getRendererClass() {
		return _rendererClass;
	}

	public void setRendererClass(String rendererClass) {
		_rendererClass = rendererClass;
	}

	public _Component getComponent() {
		return _component;
	}

	public void setComponent(_Component component) {
		_component = component;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof MXMLComponentBuilder)){
			return false;
		}
		
		MXMLComponentBuilder compBuilder = (MXMLComponentBuilder) obj;
		return (this.getCompFamily().equals(compBuilder.getCompFamily()) && this.getRendererClass().equals(compBuilder.getRendererClass()));
	}
	
	public int hashCode() {
		
		return (getCompFamily() + getRendererClass()).hashCode();
	}
	
}
