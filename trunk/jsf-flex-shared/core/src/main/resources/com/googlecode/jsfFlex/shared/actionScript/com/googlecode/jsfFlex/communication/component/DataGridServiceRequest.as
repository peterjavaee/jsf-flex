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
	import mx.controls.dataGridClasses.DataGridColumn;
	import mx.core.UIComponent;
	import mx.events.DataGridEvent;
	
	import com.googlecode.jsfFlex.communication.event.helper.ScrollEventHelper;
	import com.googlecode.jsfFlex.communication.logger.ILogger;
	import com.googlecode.jsfFlex.communication.logger.LoggerFactory;
	
	public class DataGridServiceRequest {
		
		private static var _log:ILogger;
		
		private var _scrollEventHelper:ScrollEventHelper;
		private var _checkingScrollState:Boolean;
		
		/*
		 * Fields for data partitioning
		 */
		private var _batchColumnDataRetrievalSize:uint;
		private var _cacheSize:uint;
		private var _currentInitialHalfDataPartitionIndex:uint;
		private var _dataPartitioned:Boolean;
		private var _maxDataPartitionIndex:uint;
		
		/*
		 * Flag if > 0 means waiting for data from the server
		 */
		private var _numberOfWaitingColumnDataInfo:uint;
		
		private var _currDataFieldWithFocus:String;
		
		private var _dataFieldToDataGridColumnEntriesDictionary:Dictionary;
		private var _dataGridComp:DataGrid;
		private var _dataGridCompEditable:Boolean;
		private var _dataGridDataProvider:ArrayCollection;
		
		{
			_log = LoggerFactory.newJSLoggerInstance(DataGridServiceRequest);
		}
		
		public function DataGridServiceRequest(dataGridId:String, batchColumnDataRetrievalSize:uint, 
												maxDataPartitionIndex:uint, refApp:UIComponent) {
			super();
			_dataGridComp = refApp[dataGridId];
			_batchColumnDataRetrievalSize = batchColumnDataRetrievalSize;
			_maxDataPartitionIndex = maxDataPartitionIndex;
			_dataGridCompEditable = _dataGridComp.editable;
			
			/*
			 * Internal setting of the fields for possible dataPartitioning 
			 */
			_dataPartitioned = (_maxDataPartitionIndex > 1);
			_cacheSize = _dataPartitioned ? (_batchColumnDataRetrievalSize * 2) : _batchColumnDataRetrievalSize;
			_dataGridComp.variableRowHeight = true;
			
			/*
			 * Internal properties needed by DataGridServiceRequest
			 */
			
			_dataFieldToDataGridColumnEntriesDictionary = new Dictionary();
			_dataGridDataProvider = new ArrayCollection();
			
			for(var i:uint = 0; i < _cacheSize; i++){
				_dataGridDataProvider.addItem({_hiddenOriginalRowIndex : i});
			}
			_dataGridComp.dataProvider = _dataGridDataProvider;
			
		}
		
		/*
		 * This method will be invoked after the constructor has been created and all DataGridColumnServiceRequest
		 * objects have been added to the current instance. Main purpose is to have a single loop to set the reference
		 * to DataGridColumn component and to start off ScrollEventHelper if data has been partitioned
		 */
		public function initialize():void {
			
			for each(var dataGridColumn:DataGridColumn in _dataGridComp.columns){
				var currDataGridColumnEntry:Object = _dataFieldToDataGridColumnEntriesDictionary[dataGridColumn.dataField];
				currDataGridColumnEntry.dataGridColumn = dataGridColumn;
			}
			
			getDataGridColumnInfo(0, 0);
			
			if(_dataPartitioned){
				
				//get the second half as well
				getDataGridColumnInfo(1, _batchColumnDataRetrievalSize);
				
				_scrollEventHelper = new ScrollEventHelper(_dataGridComp, this, scrollAdditionalDataRetrievalCheck);
				_scrollEventHelper.activateListener();
				_scrollEventHelper.lockScrollParameters();
				
			}
		}
		
		public function addDataGridColumServiceRequest(dataGridColumnId:String, dataField:String, columnEditable:Boolean):void {
			//provide whether column is editable or not
			var dataGridColumnEditable:Boolean = columnEditable ? true : _dataGridCompEditable;
			var dataGridColumnServiceRequest:DataGridColumnServiceRequest = new DataGridColumnServiceRequest(dataGridColumnId, dataField, 
																					dataGridColumnEditable, this);
			
			_dataFieldToDataGridColumnEntriesDictionary[dataField] = {dataGridColumnServiceRequest: dataGridColumnServiceRequest, dataGridColumn: null };
		}
		
		public function getDataGridColumnInfo(dataFetchPartitionIndex:uint, populateCacheStartIndex:uint):void {
			
			/*
			 * below set is for getDataGridColumnInfo method call. When
			 * data is returned by each DataGridColumnServiceRequest, this field will be
			 * decremented and when it reaches 0 the instance will start listening for 
			 * possible modification and possible scrolling for additional data.
			 */
			
			_numberOfWaitingColumnDataInfo += _dataGridComp.columns.length;
			
			var dataStartIndex:uint = dataFetchPartitionIndex * _batchColumnDataRetrievalSize;
			var dataEndIndex:uint = dataStartIndex + _batchColumnDataRetrievalSize;
			
			for each(var dataGridColumnEntry:Object in _dataFieldToDataGridColumnEntriesDictionary){
				//disable editing for DataGridColumn component
				dataGridColumnEntry.dataGridColumn.editable = false;
				dataGridColumnEntry.dataGridColumnServiceRequest.getDataColumnInfo(dataStartIndex, dataEndIndex, populateCacheStartIndex);
			}
		}
		
		public function flushCacheChanges():void {
			deActivateListener();
			
			for each(var dataGridColumnEntry:Object in _dataFieldToDataGridColumnEntriesDictionary){
				dataGridColumnEntry.dataGridColumnServiceRequest.flushCacheChanges();
			}
		}
		
		public function scrollAdditionalDataRetrievalCheck():void {
			
			_scrollEventHelper.lockScrollParameters();
			
			if(_numberOfWaitingColumnDataInfo > 0 || _checkingScrollState){
				//_scrollEventHelper.resetState(_dataGridComp.verticalScrollPosition);
				_scrollEventHelper.unLockScrollParameters();
				return;
			}
			
			_checkingScrollState = true;
			
			var fetchData:Boolean;
			var dataFetchPartitionIndex:uint;
			var viewScrollPosition:int;
			
			var cacheIndex:uint = Math.floor( (_scrollEventHelper.verticalScrollPosition / _batchColumnDataRetrievalSize) );
			var currentDataPartitionIndex:uint = cacheIndex + _currentInitialHalfDataPartitionIndex;
			if(_scrollEventHelper.scrolledDown){
				if(cacheIndex == 1 && ((_batchColumnDataRetrievalSize - (_scrollEventHelper.verticalScrollPosition % _batchColumnDataRetrievalSize)) 
						< _dataGridComp.rowCount) && ((currentDataPartitionIndex + 1) < _maxDataPartitionIndex)){
					/*
					 * increment _currentInitialHalfDataPartitionIndex and fetch the data
					 */
					
					_currentInitialHalfDataPartitionIndex++;
					dataFetchPartitionIndex = currentDataPartitionIndex + 1;
					
					viewScrollPosition = _dataGridComp.verticalScrollPosition - _batchColumnDataRetrievalSize;
					fetchData = true;
				}
			}else{
				if(cacheIndex == 0 && ((_scrollEventHelper.verticalScrollPosition % _batchColumnDataRetrievalSize) < _dataGridComp.rowCount)
						&& currentDataPartitionIndex > 0){
					/*
					 * decrement _currentInitialHalfDataPartitionIndex and fetch the data
					 */
					
					_currentInitialHalfDataPartitionIndex--;
					dataFetchPartitionIndex = currentDataPartitionIndex - 1;
					
					viewScrollPosition = _dataGridComp.verticalScrollPosition + _batchColumnDataRetrievalSize;
					fetchData = true;
				}
			}
			
			if(fetchData){
				/*
				 * Need to fetch additional data, note that .5 cacheSize will 
				 * be fetched with the other .5 remaining for better user experience
				 */
				alterPropertiesForServiceRequest(dataFetchPartitionIndex, viewScrollPosition);
				var populateCacheStartIndex:uint = !_scrollEventHelper.scrolledDown ? 0 : _batchColumnDataRetrievalSize;
				getDataGridColumnInfo(dataFetchPartitionIndex, populateCacheStartIndex);
			}else{
				_scrollEventHelper.unLockScrollParameters();
			}
			
			_checkingScrollState = false;
			
		}
		
		internal function get batchColumnDataRetrievalSize():uint {
			return _batchColumnDataRetrievalSize;
		}
		
		internal function get dataGridDataProvider():ArrayCollection {
		    return _dataGridDataProvider;
		}
		
		internal function notifyRetrievalOfColumnData():void {
			
			_numberOfWaitingColumnDataInfo--;
			
			if(_numberOfWaitingColumnDataInfo == 0){
				//start listening for changes if editable
				
				if(_dataPartitioned){
					_scrollEventHelper.resetState(_dataGridComp.verticalScrollPosition);
				}
				
				activateListener();
				
				_dataGridComp.editable = _dataGridCompEditable;
				for each(var dataGridColumnEntry:Object in _dataFieldToDataGridColumnEntriesDictionary){
					//set the editable field for DataGridColumn component
					dataGridColumnEntry.dataGridColumn.editable = dataGridColumnEntry.dataGridColumnServiceRequest.dataGridColumnEditable;
				}
				
				_dataGridComp.invalidateList();
				var dataHeightStartIndex:uint = _dataGridComp.verticalScrollPosition;
				_dataGridComp.height = _dataGridComp.measureHeightOfItems(dataHeightStartIndex, (_dataGridComp.rowCount - 1)) + _dataGridComp.headerHeight;
			}
			
		}
		
		private function activateListener():void {
			
			if(_dataPartitioned){
				_scrollEventHelper.unLockScrollParameters();
				_scrollEventHelper.activateListener();
			}
			
			_dataGridComp.addEventListener(DataGridEvent.ITEM_EDIT_END, initialValueListener);
			_dataGridComp.addEventListener(DataGridEvent.ITEM_EDIT_END, possiblyModifiedValueListener, false, -60);
			
		}
		
		private function deActivateListener():void {
			
			if(_dataPartitioned){
				_scrollEventHelper.deActivateListener();
			}
			
			_dataGridComp.removeEventListener(DataGridEvent.ITEM_EDIT_END, initialValueListener);
			_dataGridComp.removeEventListener(DataGridEvent.ITEM_EDIT_END, possiblyModifiedValueListener);
			
		}
		
		private function alterPropertiesForServiceRequest(dataFetchPartitionIndex:uint, viewScrollPosition:int):void {
			deActivateListener();
			
			//disable editing for the DataGrid component
			_dataGridComp.editable = false;
			
			var removeStartIndex:int;
			var removeEndIndex:int;
			var addStartIndex:uint;
			var addEndIndex:uint;
			if(_scrollEventHelper.scrolledDown){
				removeStartIndex = (_batchColumnDataRetrievalSize - 1);
				removeEndIndex = -1;
				
				addStartIndex = _batchColumnDataRetrievalSize;
				addEndIndex = _cacheSize;
			}else{
				removeStartIndex = (_cacheSize - 1);
				removeEndIndex = _batchColumnDataRetrievalSize - 1;
				
				addStartIndex = 0;
				addEndIndex = _batchColumnDataRetrievalSize;
			}
			
			/*
			 * First remove the elements
			 */
			for(; removeStartIndex > removeEndIndex; removeStartIndex--){
				_dataGridDataProvider.removeItemAt(removeStartIndex);
			}
			
			var cacheIndex:uint = dataFetchPartitionIndex * _batchColumnDataRetrievalSize;
			
			for(; addStartIndex < addEndIndex; addStartIndex++, cacheIndex++){
				/*
			     * _hiddenOriginalRowIndex will be used when sending changed values
			     * to the server side, since user can sort the data.
			     */
			    _dataGridDataProvider.addItemAt({_hiddenOriginalRowIndex : cacheIndex}, addStartIndex);
			}
			
			viewScrollPosition = viewScrollPosition < 0 ? 0 : viewScrollPosition;
			
			_dataGridComp.scrollToIndex(viewScrollPosition);
			_scrollEventHelper.resetState(viewScrollPosition);
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
			
			var dataGridColumnServiceRequest:DataGridColumnServiceRequest = _dataFieldToDataGridColumnEntriesDictionary[currDataField].dataGridColumnServiceRequest;
			var hiddenOriginalRowIndex:uint = _dataGridDataProvider.getItemAt(event.rowIndex)._hiddenOriginalRowIndex;
			
			dataGridColumnServiceRequest.addModifiedDataField({originalRowIndex: hiddenOriginalRowIndex, modifiedValue: possiblyUpdatedValue});
			_log.logInfo("Added the modified dataField " + possiblyUpdatedValue + " to " + dataGridColumnServiceRequest.columnId);
		}
		
	}
	
}