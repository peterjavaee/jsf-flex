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
package com.googlecode.jsfFlex.shared.util;

/**
 * An attribute constant class.<br>
 * 
 * @author Ji Hoon Kim
 */
public final class MXMLAttributeConstants {
	
	public static final String SCRIPT_ELEM = "script";
	public static final String SCRIPT_TYPE_ATTR = "type";
	
	/** Standard Attributes */
	public static final String ID_ATTR = "id";
	public static final String NAME_ATTR = "name";
	public static final String VALUE_ATTR = "value";
	
	/** Style Attributes */
	public static final String HEIGHT_ATTR = "height";
	public static final String WIDTH_ATTR = "width";
	
	/** Specific Attributes that should be centralized */
	public static final String SRC_ATTR = "src";
	public static final String SCRIPT_TYPE_TEXT_JAVASCRIPT = "text/javascript";
	
	private MXMLAttributeConstants(){
		super();
	}
	
}
