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
 * @author Ji Hoon Kim
 */
package com.googlecode.jsfFlex.communication.component
{
	import flash.utils.clearInterval;
	import flash.utils.setInterval;
	
	import mx.collections.ArrayCollection;
	import mx.rpc.events.ResultEvent;
	
	import com.googlecode.jsfFlex.communication.logger.ILogger;
	import com.googlecode.jsfFlex.communication.logger.LoggerFactory
	import com.googlecode.jsfFlex.communication.services.JsfFlexHttpService;
	
	internal class DataGridColumnServiceRequest {
		
		private static const GET_FORMATED_COLUMN_DATA_SERVICE_REQUEST_URL:String = "jsfFlexHttpServiceRequestListener/getFormatedColumnDataServiceRequest";
		private static const UPDATE_MODIFIED_DATA_FIELD_SERVICE_REQUEST_URL:String = "jsfFlexHttpServiceRequestListener/updateModifiedDataFieldServiceRequest";
		private static const GET_FORMATED_COLUMN_DATA:String = "getFormatedColumnData";
		private static const UPDATE_MODIFIED_DATA_FIELD:String = "updateModifiedDataField";
		
		private static var _log:ILogger;
		
		private var _clearIntervalRef:uint;
		
		private var _columnId:String;
		private var _dataField:String;
		
		private var _modifiedDataFieldObjectArray:Array;
		private var _dataGridServiceRequest:DataGridServiceRequest;
		private var _jsfFlexHttpServiceRequest:JsfFlexHttpService;
		
		{
			_log = LoggerFactory.newJSLoggerInstance(DataGridColumnServiceRequest);
		}
		
		public function DataGridColumnServiceRequest(columnId:String, dataField:String, dataGridServiceRequest:DataGridServiceRequest) {
			super();
			_columnId = columnId;
			_dataField = dataField;
			_modifiedDataFieldObjectArray = new Array();
			_dataGridServiceRequest = dataGridServiceRequest;
			_jsfFlexHttpServiceRequest = new JsfFlexHttpService();
			
			_clearIntervalRef = setInterval( requestCacheChangeFlush, 8000);
		}
		
		internal function getDataColumnInfo():void {
			var dataRequestParameters:Object = new Object();
			dataRequestParameters.componentId = _columnId;
			dataRequestParameters.methodToInvoke = GET_FORMATED_COLUMN_DATA;
			
			_jsfFlexHttpServiceRequest.sendHttpRequest(GET_FORMATED_COLUMN_DATA_SERVICE_REQUEST_URL, this,
															function (lastResult:Object, event:ResultEvent):void {
																_log.logInfo("Returned from service request : " + GET_FORMATED_COLUMN_DATA_SERVICE_REQUEST_URL);
																_log.logInfo("Data returned from servlet : " + lastResult);
																var columnEntries:XMLList = new XMLList(lastResult).VALUE;
																var dataGridDataProvider:ArrayCollection = _dataGridServiceRequest.dataGridDataProvider;
																
																var loopCount:int = 0;
																for each(var currValue:XML in columnEntries){
																	var currObject:Object = dataGridDataProvider.getItemAt(loopCount++);
																	currObject[_dataField] = currValue.toString();
																}
																
															}, dataRequestParameters, JsfFlexHttpService.GET_METHOD, JsfFlexHttpService.E4X_RESULT_FORMAT, null);
			
		}
		
		internal function flushCacheChanges():void {
			_log.logInfo("Was informed to flushCacheChanges explicitly with unflushed cache changes of length : " + _modifiedDataFieldObjectArray.length);
			clearInterval(_clearIntervalRef);
			requestCacheChangeFlush();
		}
		
		internal function addModifiedDataField(modifiedDataFieldObject:Object):void {
			_modifiedDataFieldObjectArray.push(modifiedDataFieldObject);
		}
		
		internal function get columnId():String {
			return _columnId;
		}
		
		private function requestCacheChangeFlush():void {
			if(_modifiedDataFieldObjectArray.length == 0){
				return;
			}
			_log.logInfo("Implicit timed flushCacheChanges invocation with unflushed cache changes of length : " + _modifiedDataFieldObjectArray.length);
			var dataRequestParameters:Object = new Object();
			dataRequestParameters.componentId = _columnId;
			dataRequestParameters.methodToInvoke = UPDATE_MODIFIED_DATA_FIELD;
			
			var requestKeys:String = "";
			while(_modifiedDataFieldObjectArray.length > 0){
				var currModifiedDataFieldObject:Object = _modifiedDataFieldObjectArray.pop();
				requestKeys += currModifiedDataFieldObject.originalRowIndex + ",";
				dataRequestParameters[String(currModifiedDataFieldObject.originalRowIndex)] = currModifiedDataFieldObject.modifiedValue;
			}
			dataRequestParameters.requestKeys = requestKeys;
			
			_jsfFlexHttpServiceRequest.sendHttpRequest(UPDATE_MODIFIED_DATA_FIELD_SERVICE_REQUEST_URL, this,
															function (lastResult:Object, event:ResultEvent):void {
																_log.logInfo("Returned from service request : " + UPDATE_MODIFIED_DATA_FIELD_SERVICE_REQUEST_URL);
																var resultCode:String = lastResult.resultCode;
																_log.logInfo("Result Code for " + UPDATE_MODIFIED_DATA_FIELD + " is : " + resultCode);
															}, dataRequestParameters, JsfFlexHttpService.POST_METHOD, JsfFlexHttpService.FLASH_VARS_RESULT_FORMAT, null);
		}
		
	}
	
}