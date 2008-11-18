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

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Ji Hoon Kim
 */
public final class AdditionalApplicationScriptContent {
	
	private final Set _actionScriptImports;
	private final Map _dataGridScriptContent;
	
	public AdditionalApplicationScriptContent(){
		super();
		_actionScriptImports = new LinkedHashSet();
		_dataGridScriptContent = new HashMap();
	}
	
	public void addActionScriptImport(String actionScriptImport){
		_actionScriptImports.add(actionScriptImport);
	}
	
	public Set getActionScriptImports() {
		return _actionScriptImports;
	}
	public Map getDataGridScriptContent() {
		return _dataGridScriptContent;
	}

	public void addDataGridScriptContent(String dataGridId){
		_dataGridScriptContent.put(dataGridId, new DataGridScriptContent(dataGridId));
	}
	
	public void addDataGridColumnToDataGridScriptContent(String dataGridId, String dataGridColumnId){
		DataGridScriptContent dataGridScriptContentInstance;
		if((dataGridScriptContentInstance = (DataGridScriptContent) _dataGridScriptContent.get(dataGridId)) == null){
			dataGridScriptContentInstance = new DataGridScriptContent(dataGridId);
			_dataGridScriptContent.put(dataGridId, dataGridScriptContentInstance);
		}
		
		dataGridScriptContentInstance.addDataGridColumnContent(dataGridColumnId);
	}
	
	public void addDataGridColumnToDataGridScriptContent(String dataGridId, List dataGridColumnIdList){
		DataGridScriptContent dataGridScriptContentInstance;
		if((dataGridScriptContentInstance = (DataGridScriptContent) _dataGridScriptContent.get(dataGridId)) == null){
			dataGridScriptContentInstance = new DataGridScriptContent(dataGridId);
			_dataGridScriptContent.put(dataGridId, dataGridScriptContentInstance);
		}
		
		dataGridScriptContentInstance.addDataGridColumnContent(dataGridColumnIdList);
	}
	
	public static final class DataGridScriptContent {
		
		private final String _dataGridId;
		private final List _dataGridColumns;
		
		private DataGridScriptContent(String dataGridId){
			super();
			_dataGridId = dataGridId;
			_dataGridColumns = new LinkedList();
		}
		
		private void addDataGridColumnContent(String dataGridColumnId){
			_dataGridColumns.add(dataGridColumnId);
		}
		
		private void addDataGridColumnContent(List dataGridColumnIdList){
			_dataGridColumns.addAll(dataGridColumnIdList);
		}
		
		public String getDataGridId() {
			return _dataGridId;
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
		
	}
	
}
