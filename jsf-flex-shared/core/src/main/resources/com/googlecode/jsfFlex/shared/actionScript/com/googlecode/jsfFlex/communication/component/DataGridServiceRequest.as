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
 
/**
 * TODO : Implement better later
 * Unfortunately ActionScript currently doesn't implement inner classes, so implemented so
 * @author Ji Hoon Kim
 */
package com.googlecode.jsfFlex.communication.component
{
	import flash.utils.Dictionary;
	
	import mx.collections.ArrayCollection;
	import mx.controls.DataGrid;
	import mx.core.UIComponent;
	import mx.events.DataGridEvent;
	
	import com.googlecode.jsfFlex.communication.logger.ILogger;
	import com.googlecode.jsfFlex.communication.logger.LoggerFactory
	
	public class DataGridServiceRequest {
		
		private static var _log:ILogger;
		
		private var _dataFieldToDataGridColumnServiceRequestDictionary:Dictionary;
		private var _dataGridColumnRequests:Array;
		private var _dataGridComp:DataGrid;
		private var _dataGridDataProvider:ArrayCollection;
		
		private var _currDataFieldWithFocus:String;
		
		{
			_log = LoggerFactory.newJSLoggerInstance(DataGridServiceRequest);
		}
		
		public function DataGridServiceRequest(dataGridId:String, maxDataGridColumnLength:int, refApp:UIComponent) {
			super();
			_dataFieldToDataGridColumnServiceRequestDictionary = new Dictionary();
			_dataGridColumnRequests = new Array();
			_dataGridComp = refApp[dataGridId];
			_dataGridDataProvider = new ArrayCollection();
			
			for(var k:uint=0; k < maxDataGridColumnLength; k++){
				/*
			     * _hiddenOriginalRowIndex will be used when sending changed values
			     * to the server side, since user can sort the data.
			     */
				_dataGridDataProvider.addItem({_hiddenOriginalRowIndex: k});
			}
			
			_dataGridComp.dataProvider = _dataGridDataProvider;
			_dataGridComp.addEventListener(DataGridEvent.ITEM_EDIT_END, initialValueListener);
			_dataGridComp.addEventListener(DataGridEvent.ITEM_EDIT_END, possiblyModifiedValueListener, false, -60);
		}
		
		public function addDataGridColumServiceRequest(dataGridColumnId:String, dataField:String):void {
			var dataGridColumnServiceRequest:DataGridColumnServiceRequest = new DataGridColumnServiceRequest(dataGridColumnId, dataField, this);
			_dataGridColumnRequests.push(dataGridColumnServiceRequest);
			_dataFieldToDataGridColumnServiceRequestDictionary[dataField] = dataGridColumnServiceRequest;
		}
		
		public function getDataGridColumnInfo():void {
			for each(var dataGridColumnRequest:DataGridColumnServiceRequest in _dataGridColumnRequests){
				dataGridColumnRequest.getDataColumnInfo();
			}
		}
		
		public function flushCacheChanges():void {
			_dataGridComp.removeEventListener(DataGridEvent.ITEM_EDIT_END, initialValueListener);
			_dataGridComp.removeEventListener(DataGridEvent.ITEM_EDIT_END, possiblyModifiedValueListener);
			for each(var dataGridColumnRequest:DataGridColumnServiceRequest in _dataGridColumnRequests){
				dataGridColumnRequest.flushCacheChanges();
			}
		}
		
		internal function get dataGridDataProvider():ArrayCollection {
			return _dataGridDataProvider;
		}
		
		private function initialValueListener(event:DataGridEvent):void{
			_currDataFieldWithFocus = _dataGridComp.selectedItem[event.dataField];
		}
		
		private function possiblyModifiedValueListener(event:DataGridEvent):void {
			var currDataField:String = event.dataField;
			var possiblyUpdatedValue:String = _dataGridComp.selectedItem[currDataField];
			if(possiblyUpdatedValue == _currDataFieldWithFocus){
				return;
			}
			
			var dataGridColumnServiceRequest:DataGridColumnServiceRequest = _dataFieldToDataGridColumnServiceRequestDictionary[currDataField];
			var hiddenOriginalRowIndex:uint = _dataGridComp.dataProvider.getItemAt(event.rowIndex)._hiddenOriginalRowIndex;
			
			dataGridColumnServiceRequest.addModifiedDataField({originalRowIndex: hiddenOriginalRowIndex, modifiedValue: possiblyUpdatedValue});
			_log.logInfo("Added the modified dataField " + possiblyUpdatedValue + " to " + dataGridColumnServiceRequest.columnId);
		}
		
	}
	
}