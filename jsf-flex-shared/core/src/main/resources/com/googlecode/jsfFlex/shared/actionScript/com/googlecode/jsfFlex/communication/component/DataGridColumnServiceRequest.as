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
	import mx.rpc.events.ResultEvent;
	
	import com.googlecode.jsfFlex.communication.logger.ILogger;
	import com.googlecode.jsfFlex.communication.logger.LoggerFactory
	
	import com.googlecode.jsfFlex.communication.services.JsfFlexHttpService;
	
	internal class DataGridColumnServiceRequest {
		
		private static const JSF_FLEX_HTTP_SERVICE_REQUEST_URL:String = "jsfFlexHttpServiceRequest.service";
		private static const GET_COLUMN_INFO:String = "getColumnInfo";
		
		private static var _log:ILogger;
		
		private var _columnId:String;
		private var _columnEntries:XMLList;
		
		private var _dataGridServiceRequest:DataGridServiceRequest;
		private var _jsfFlexHttpServiceRequest:JsfFlexHttpService;
		
		{
			_log = LoggerFactory.newJSLoggerInstance(DataGridColumnServiceRequest);
		}
		
		public function DataGridColumnServiceRequest(columnId:String, dataGridServiceRequest:DataGridServiceRequest) {
			super();
			_columnId = columnId;
			_dataGridServiceRequest = dataGridServiceRequest;
			_jsfFlexHttpServiceRequest = new JsfFlexHttpService();
		}
		
		public function getDataColumnInfo():void {
			var dataRequestParameters:Object = new Object();
			dataRequestParameters.componentId = _columnId;
			dataRequestParameters.methodToInvoke = GET_COLUMN_INFO;
			
			_jsfFlexHttpServiceRequest.sendHttpRequest(JSF_FLEX_HTTP_SERVICE_REQUEST_URL, dataRequestParameters, 
														this, function(lastResult:Object, event:ResultEvent):void {
																_log.logInfo("Returned from service request : " + JSF_FLEX_HTTP_SERVICE_REQUEST_URL);
																_log.logInfo("Data returned from servlet : " + lastResult);
																
														}, JsfFlexHttpService.GET_METHOD, JsfFlexHttpService.OBJECT_RESULT_FORMAT, null);
			
		}
		
		public function get columnId():String {
			return _columnId;
		}
		
	}
	
}