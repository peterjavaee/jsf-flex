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

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.googlecode.jsfFlex.framework.util.MXMLConstants;

/**
 * @author Ji Hoon Kim
 */
public final class MXMLObjectBean extends _MXMLBean {
	
	private static final String LEFT_OBJECT_ENCLOSURE = "{";
	private static final String RIGHT_OBJECT_ENCLOSURE = "}";
	
	private final Set _objectDataSet;
	
	private MXMLObjectBean(){
		super();
		_objectDataSet = null;
	}
	
	public MXMLObjectBean(String variableId, String variableType){
		super(variableId, variableType);
		_objectDataSet = new HashSet();
	}
	
	public void addData(String data, String label){
		_objectDataSet.add(new MXMLObjectData(data, label));
	}
	
	public String generateVariableInfoAsString(){
		StringBuffer generatedString = new StringBuffer(LEFT_OBJECT_ENCLOSURE);
		
		_MXMLBean _mxmlBean;
		for(Iterator iterator = _objectDataSet.iterator(); iterator.hasNext();){
			_mxmlBean = (_MXMLBean) iterator.next();
			generatedString.append(_mxmlBean.generateVariableInfoAsString());
			if(iterator.hasNext()){
				generatedString.append(",");
			}
		}
		
		generatedString.append(RIGHT_OBJECT_ENCLOSURE);
		
		return generatedString.toString();
	}
	
	private final class MXMLObjectData {
		
		private final int HASH_CODE_VAL;
		
		private final String _data;
		private final String _label;
		
		private MXMLObjectData(){
			super();
			_data = null;
			_label = null;
			HASH_CODE_VAL = -1;
		}
		
		private MXMLObjectData(String data, String label){
			super();
			_data = data;
			_label = label;
			int hashCodeVal = MXMLConstants.HASH_CODE_INIT_VALUE;
			hashCodeVal = MXMLConstants.HASH_CODE_MULTIPLY_VALUE * hashCodeVal + _data.hashCode();
			hashCodeVal = MXMLConstants.HASH_CODE_MULTIPLY_VALUE * hashCodeVal + _label.hashCode();
			HASH_CODE_VAL = hashCodeVal;
		}
		
		private String getData() {
			return _data;
		}
		private String getLabel() {
			return _label;
		}
		
		public String generateVariableInfoAsString(){
			return _label + " : " + MXMLConstants.STRING_QUOTE + _data + MXMLConstants.STRING_QUOTE;
		}
		
		public boolean equals(Object _instance) {
			if(!(_instance instanceof MXMLObjectData)){
				return false;
			}
			
			MXMLObjectData _mxmlObjectDataInstance = (MXMLObjectData) _instance;
			return this.getData().equals(_mxmlObjectDataInstance.getData()) && this.getLabel().equals(_mxmlObjectDataInstance.getLabel());
		}
		
		public int hashCode() {
			return HASH_CODE_VAL;
		}
		
	}
	
}
