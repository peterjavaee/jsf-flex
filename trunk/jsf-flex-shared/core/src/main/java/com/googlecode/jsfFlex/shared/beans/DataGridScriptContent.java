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
package com.googlecode.jsfFlex.shared.beans;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Ji Hoon Kim
 */
public final class DataGridScriptContent {
	
	private final String _dataGridId;
	private final Integer _maxDataGridColumnLength;
	private final List _dataGridColumns;
	
	DataGridScriptContent(String dataGridId, int maxDataGridColumnLength){
		super();
		_dataGridId = dataGridId;
		_maxDataGridColumnLength = Integer.valueOf(maxDataGridColumnLength);
		_dataGridColumns = new LinkedList();
	}
	
	void addDataGridColumnContent(String dataGridColumnId, String dataField){
		_dataGridColumns.add(new DataGridColumnScriptContent(dataGridColumnId, dataField));
	}
	
	public String getDataGridId() {
		return _dataGridId;
	}
	public Integer getMaxDataGridColumnLength() {
		return _maxDataGridColumnLength;
	}
	public List getDataGridColumns() {
		return _dataGridColumns;
	}
	
	public boolean equals(Object instance) {
		if(!(instance instanceof DataGridScriptContent)){
			return false;
		}
		
		DataGridScriptContent dataGridScriptContentInstance = (DataGridScriptContent) instance; 
		return this._dataGridId.equals(dataGridScriptContentInstance._dataGridId);
	}
	public int hashCode() {
		return _dataGridId.hashCode();
	}
	
	public final class DataGridColumnScriptContent {
		
		private final String _dataGridColumnId;
		private final String _dataField;
		
		private DataGridColumnScriptContent(String dataGridColumnId, String dataField){
			super();
			_dataGridColumnId = dataGridColumnId;
			_dataField = dataField;
		}
		
		public String getDataGridColumnId() {
			return _dataGridColumnId;
		}
		public String getDataField() {
			return _dataField;
		}
		
		public boolean equals(Object instance) {
			if(!(instance instanceof DataGridColumnScriptContent)){
				return false;
			}
			
			DataGridColumnScriptContent dataGridColumnScriptContentInstance = (DataGridColumnScriptContent) instance;
			return this._dataGridColumnId.equals(dataGridColumnScriptContentInstance._dataGridColumnId);
		}
		public int hashCode() {
			return _dataGridColumnId.hashCode();
		}
		
	}
	
}
