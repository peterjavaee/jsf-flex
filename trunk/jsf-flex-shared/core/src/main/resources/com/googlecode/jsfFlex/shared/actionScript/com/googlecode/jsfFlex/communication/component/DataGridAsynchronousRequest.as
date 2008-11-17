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
	
	import com.googlecode.jsfFlex.communication.logger.ILogger;
	import com.googlecode.jsfFlex.communication.logger.LoggerFactory
	
	import com.googlecode.jsfFlex.communication.services.JSONHttpService;
	
	public class DataGridAsynchronousRequest {
		
		private static var _log:ILogger;
		
		private var _dataGridARId:String;
		private var _dataGridColumnList:Array;
		
		{
			_log = LoggerFactory.newJSLoggerInstance(DataGridAsynchronousRequest);
		}
		
		public function DataGridAsynchronousRequest(dataGridARId:String){
			super();
			_dataGridARId = dataGridARId;
			_dataGridColumnList = new Array();
		}
		
		public function addDataGridColumBean(dataGridStringId:String):void {
			_dataGridColumnList.push(new DataGridColumnBean(dataGridStringId));
		}
		
	}
	
}