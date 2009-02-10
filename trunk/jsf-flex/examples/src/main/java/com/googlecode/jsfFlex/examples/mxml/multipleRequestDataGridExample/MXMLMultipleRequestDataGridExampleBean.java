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
package com.googlecode.jsfFlex.examples.mxml.multipleRequestDataGridExample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.googlecode.jsfFlex.shared.util.MXMLConstants;

/**
 * @author Ji Hoon Kim
 */
public final class MXMLMultipleRequestDataGridExampleBean implements Serializable {
	
	private static final long serialVersionUID = 1501524398537830947L;

	private static final String LARGE_DATA_STRING_DISPLAY_MESSAGE = "Displaying column data for ";
	
	private List _largeDataEntries;
	
	public MXMLMultipleRequestDataGridExampleBean(){
		super();
		
		_largeDataEntries = new ArrayList();
		
		for(int i=0; i < 500; i++){
			_largeDataEntries.add(new LargeDataEntry(LARGE_DATA_STRING_DISPLAY_MESSAGE + i, Integer.valueOf(i)));
		}
	}
	
	public List getLargeDataEntries() {
		return _largeDataEntries;
	}
	public void setLargeDataEntries(List largeDataEntries) {
		_largeDataEntries = largeDataEntries;
	}
	
	public final static class LargeDataEntry implements Serializable {
		
		private static final long serialVersionUID = 8426305474249836025L;
		
		private String _firstColumnEntry;
		private Integer _secondColumnEntry;
		
		private LargeDataEntry(String firstColumnEntry, Integer secondColumnEntry){
			super();
			_firstColumnEntry = firstColumnEntry;
			_secondColumnEntry = secondColumnEntry;
		}

		public String getFirstColumnEntry() {
			return _firstColumnEntry;
		}
		public void setFirstColumnEntry(String firstColumnEntry) {
			_firstColumnEntry = firstColumnEntry;
		}
		public Integer getSecondColumnEntry() {
			return _secondColumnEntry;
		}
		public void setSecondColumnEntry(Integer secondColumnEntry) {
			_secondColumnEntry = secondColumnEntry;
		}
		
		public boolean equals(Object instance) {
			if(!(instance instanceof LargeDataEntry)){
				return false;
			}
			
			LargeDataEntry largeDataEntryInstance = (LargeDataEntry) instance;
			return _firstColumnEntry.equals(largeDataEntryInstance._firstColumnEntry) 
						&& _secondColumnEntry.equals(largeDataEntryInstance._secondColumnEntry);
		}
		public int hashCode() {
			int hashCodeVal = MXMLConstants.HASH_CODE_INIT_VALUE;
			hashCodeVal = MXMLConstants.HASH_CODE_MULTIPLY_VALUE * hashCodeVal + _firstColumnEntry.hashCode();
			hashCodeVal = MXMLConstants.HASH_CODE_MULTIPLY_VALUE * hashCodeVal + _secondColumnEntry.hashCode();
			return hashCodeVal;
		}
		
	}
	
}
