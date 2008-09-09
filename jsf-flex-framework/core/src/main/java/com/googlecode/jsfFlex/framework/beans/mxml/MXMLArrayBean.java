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

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ji Hoon Kim
 */
public final class MXMLArrayBean extends _MXMLBean {
	
	private static final String LEFT_ARRAY_CLOSURE = "[";
	private static final String RIGHT_ARRAY_CLOSURE = "]";
	
	private final List _beanArrayList;
	
	private MXMLArrayBean(){
		super();
		_beanArrayList = null;
	}
	
	public MXMLArrayBean(String variableId, String variableType){
		super(variableId, variableType);
		_beanArrayList = new LinkedList();
	}
	
	public void addBean(_MXMLBean _bean){
		_beanArrayList.add(_bean);
	}
	
	public String generateVariableInfoAsString() {
		
		StringBuffer generatedString = new StringBuffer(LEFT_ARRAY_CLOSURE);
		
		_MXMLBean _objectBean;
		for(Iterator iterator = _beanArrayList.iterator(); iterator.hasNext();){
			_objectBean = (_MXMLBean) iterator.next();
			generatedString.append(_objectBean.generateVariableInfoAsString());
		}
		
		generatedString.append(RIGHT_ARRAY_CLOSURE);
		return generatedString.toString();
	}

}
