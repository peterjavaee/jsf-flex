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
 * Unfortunately ActionScript doesn't currently implement inner classes, so currently implemented so
 * @author Ji Hoon Kim
 */
package com.googlecode.jsfFlex.communication.component
{
	import mx.core.UIComponent;
	
	import com.googlecode.jsfFlex.communication.logger.ILogger;
	import com.googlecode.jsfFlex.communication.logger.LoggerFactory
	
	public class DataGridServiceRequest {
		
		private static var _log:ILogger;
		
		private var _refApp:UIComponent;
		
		private var _dataGridId:String;
		private var _dataGridColumnRequests:Array;
		
		{
			_log = LoggerFactory.newJSLoggerInstance(DataGridServiceRequest);
		}
		
		public function DataGridServiceRequest(dataGridId:String, refApp:UIComponent) {
			super();
			_dataGridId = dataGridId;
			_dataGridColumnRequests = new Array();
			_refApp = refApp;
		}
		
		public function addDataGridColumServiceRequest(dataGridStringId:String):void {
			_dataGridColumnRequests.push(new DataGridColumnServiceRequest(dataGridStringId, this));
		}
		
		public function getDataGridColumnInfo():void {
			
			for each(var dataGridColumnRequest:DataGridColumnServiceRequest in _dataGridColumnRequests){
				dataGridColumnRequest.getDataColumnInfo();
				_log.logInfo("Sent message to " + dataGridColumnRequest.columnId);
			}
			
		}
		
		public function get dataGridId():String {
			return _dataGridId;
		}
		public function get refApp():UIComponent {
			return _refApp;
		}
		
	}
	
}