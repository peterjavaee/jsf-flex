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
package com.googlecode.jsfFlex.framework.mapper;

/**
 * @author Ji Hoon Kim
 */
public class TokenValue {
	
	private String _token;
	private Object _value;
	
	public TokenValue(){
		super();
	}
	
	public TokenValue(String token, Object value){
		super();
		_token = token;
		_value = value;
	}
	
	public String getToken() {
		return _token;
	}
	public void setToken(String token) {
		_token = token;
	}
	public Object getValue() {
		return _value;
	}
	public void setValue(Object value) {
		_value = value;
	}
	
	public String toString(){
		StringBuffer _content = new StringBuffer();
		
		_content.append("token [ ");
		_content.append(_token);
		_content.append(" ] ");
		
		_content.append("value [ ");
		_content.append(_value);
		_content.append(" ] ");
		
		return _content.toString();
	}
	
	public String toTokenValueSyntax(){
		StringBuffer _tokenValue = new StringBuffer();
		_tokenValue.append(_token);
		_tokenValue.append("=");
		_tokenValue.append("\"");
		_tokenValue.append(_value);
		_tokenValue.append("\" ");
		return _tokenValue.toString();
	}
	
}
