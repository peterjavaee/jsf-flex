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
package com.googlecode.jsfFlex.framework.beans.mxml;

/**
 * @author Ji Hoon Kim
 */
public abstract class _MXMLBean {
	
	private final String _variableType;
	private final String _packageName;
	private final Boolean _bindable;
	
	protected _MXMLBean(){
		super();
		_variableType = null;
		_packageName = null;
		_bindable = null;
	}
	
	protected _MXMLBean(String variableType, Boolean bindable){
		super();
		_variableType = variableType;
		_bindable = bindable;
		_packageName = null;
	}
	
	protected _MXMLBean(String variableType, Boolean bindable, String packageName){
		super();
		_variableType = variableType;
		_bindable = bindable;
		_packageName = packageName;
	}
	
	public abstract String generateVariableInfoAsString();
	
	public String getPackageName() {
		return _packageName;
	}
	public String getVariableType() {
		return _variableType;
	}
	public Boolean isBindable(){
		return _bindable;
	}
	
}
