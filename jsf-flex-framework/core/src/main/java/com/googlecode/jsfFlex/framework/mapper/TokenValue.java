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
 * A simple object to contain the token and value state.<br>
 * 
 * @author Ji Hoon Kim
 */
public final class TokenValue {
	
	private final String _token;
	private final Object _value;
	
	private TokenValue(){
		super();
		_token = null;
		_value = null;
	}
	
	public TokenValue(String token, Object value){
		super();
		_token = token;
		_value = value;
	}
	
	public String getToken() {
		return _token;
	}
	public Object getValue() {
		return _value;
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
