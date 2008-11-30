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
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Ji Hoon Kim
 */
public final class AdditionalApplicationScriptContent {
	
	private final Set _actionScriptImports;
	private final Set _simpleDataProviderSetter;
	private final Map _dataGridScriptContent;
	
	public AdditionalApplicationScriptContent(){
		super();
		_actionScriptImports = new LinkedHashSet();
		_simpleDataProviderSetter = new LinkedHashSet();
		_dataGridScriptContent = new HashMap();
	}
	
	public void addActionScriptImport(String actionScriptImport){
		_actionScriptImports.add(actionScriptImport);
	}
	
	public void addSimpleDataProviderSetter(String componentId, String dataProviderContent){
		_simpleDataProviderSetter.add(new SimpleDataProviderSetter(componentId, dataProviderContent));
	}
	
	public void addDataGridScriptContent(String dataGridId, int maxDataGridColumnLength){
		_dataGridScriptContent.put(dataGridId, new DataGridScriptContent(dataGridId, maxDataGridColumnLength));
	}
	
	public void addDataGridColumnToDataGridScriptContent(String dataGridId, int maxDataGridColumnLength, String dataGridColumnId, String dataField){
		DataGridScriptContent dataGridScriptContentInstance;
		if((dataGridScriptContentInstance = (DataGridScriptContent) _dataGridScriptContent.get(dataGridId)) == null){
			dataGridScriptContentInstance = new DataGridScriptContent(dataGridId, maxDataGridColumnLength);
			_dataGridScriptContent.put(dataGridId, dataGridScriptContentInstance);
		}
		
		dataGridScriptContentInstance.addDataGridColumnContent(dataGridColumnId, dataField);
	}
	
	public void addDataGridColumnToDataGridScriptContent(String dataGridId, int maxDataGridColumnLength, Map dataGridColumnIdMap){
		DataGridScriptContent dataGridScriptContentInstance;
		if((dataGridScriptContentInstance = (DataGridScriptContent) _dataGridScriptContent.get(dataGridId)) == null){
			dataGridScriptContentInstance = new DataGridScriptContent(dataGridId, maxDataGridColumnLength);
			_dataGridScriptContent.put(dataGridId, dataGridScriptContentInstance);
		}
		
		for(Iterator iterate = dataGridColumnIdMap.keySet().iterator(); iterate.hasNext();){
			String dataGridColumnId = (String) iterate.next();
			String dataField = (String) dataGridColumnIdMap.get(dataGridColumnId);
			dataGridScriptContentInstance.addDataGridColumnContent(dataGridColumnId, dataField);
		}
	}
	
	public Set getActionScriptImports() {
		return new HashSet(_actionScriptImports);
	}
	public Set getSimpleDataProviderSetter() {
		return new HashSet(_simpleDataProviderSetter);
	}
	public Map getDataGridScriptContent() {
		return new HashMap(_dataGridScriptContent);
	}
	
}
