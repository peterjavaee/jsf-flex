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
	
	private final String _variableId;
	private final String _variableType;
	
	protected _MXMLBean(){
		super();
		_variableId = null;
		_variableType = null;
	}
	
	protected _MXMLBean(String variableId, String variableType){
		super();
		_variableId = variableId;
		_variableType = variableType;
	}
	
	public abstract String generateVariableInfoAsString();
	
	public String getVariableId() {
		return _variableId;
	}
	public String getVariableType() {
		return _variableType;
	}
	
	public boolean equals(Object _instance) {
		if(!(_instance instanceof _MXMLBean)){
			return false;
		}
		
		_MXMLBean _mxmlBeanInstance = (_MXMLBean) _instance;
		return this.getVariableId().equals(_mxmlBeanInstance.getVariableId());
	}
	
	public int hashCode() {
		return getVariableId().hashCode();
	}
	
}
