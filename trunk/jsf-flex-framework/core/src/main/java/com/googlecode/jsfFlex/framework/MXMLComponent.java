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
 * This class is responsible for instantiating correct MXML[NameOfComponent]Component for the JSF component<br>
 * and invoking the correct methods of the MXML[NameOfComponent]Component to integrate JSF Flex Framework's lifecycle to JSF<br>
 * lifecycle. Following is a mapping of the methods invoked within JSF lifecycle to methods invoked within<br>
 * JSF Flex Framework's lifecycle : <br>
 * <ul>
 * 	<li> encodeBegin 	: buildComponentBegin, buildComponentInterlude
 * 	<li> encodeChildren : buildComponentChildren [currently serves no purpose]
 *  <li> encodeEnd		: buildComponentEnd 
 * </ul>
 * 
 * @author Ji Hoon Kim
 */
public final class MXMLComponent {
	
	private final UIComponent _jsfComponent;
	private final _Component _component;
	
	private MXMLComponent(UIComponent jsfComponent, _Component component){
		_jsfComponent = jsfComponent;
		_component = component;
	}
	
	public final static class Builder {
		
		private UIComponent _jsfComponent;
		private String _compFamily;
		private String _rendererClass;
		
		private Builder(){
			super();
		}
		
		public Builder(UIComponent jsfComponent, String compFamily, String rendererClass){
			_jsfComponent = jsfComponent;
			_compFamily = compFamily;
			_rendererClass = MXMLRendererKit.getRendererClass(_compFamily, rendererClass);
		}
		
		public MXMLComponent build(){
			
			_Component _component;
			
			try{
				_component = (_Component) MXMLComponent.class.getClassLoader().loadClass(_rendererClass).newInstance();
			}catch(InstantiationException instantiationExcept){
				throw new ComponentBuildException("Error in creating an instance of " + _rendererClass, instantiationExcept);
			}catch(IllegalAccessException illegalAccessExcept){
				throw new ComponentBuildException("Error in creating an instance of " + _rendererClass, illegalAccessExcept);
			}catch(ClassNotFoundException classNotFoundExcept){
				throw new ComponentBuildException("Error in creating an instance of " + _rendererClass, classNotFoundExcept);
			}
			
			return new MXMLComponent(_jsfComponent, _component);
		}
		
		public Builder compFamily(String compFamily) {
			_compFamily = compFamily;
			return this;
		}
		public Builder jsfComponent(UIComponent jsfComponent) {
			_jsfComponent = jsfComponent;
			return this;
		}
		public Builder rendererClass(String rendererClass) {
			_rendererClass = rendererClass;
			return this;
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
		
}
