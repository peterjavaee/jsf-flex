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
 * TODO : implement it better later
 * This class will be used for browser logging
 * @author Ji Hoon Kim
 */
package com.googlecode.jsfFlex.communication.logger
{
	import flash.errors.IllegalOperationError;
	
	internal class AbstractLogger implements ILogger {
		
		private static const LOG_MODE:int = logModeToken;
		
		public function AbstractLogger(logClass:Class) {
			super();
		}
		
		public function log(errorMessage:String):void {
			if(LOG_MODE < 2){
				logMessage(errorMessage, 1);
			}
		}
		
		public function logDebug(errorMessage:String):void {
			if(LOG_MODE < 3){
				logMessage(errorMessage, 2);
			}
		}
		
		public function logInfo(errorMessage:String):void {
			if(LOG_MODE < 4){
				logMessage(errorMessage, 3);
			}
		}
		
		public function logWarn(errorMessage:String):void {
			if(LOG_MODE < 5){
				logMessage(errorMessage, 4);
			}
		}
		
		public function logError(errorMessage:String):void {
			if(LOG_MODE < 6){
				logMessage(errorMessage, 5);
			}
		}
		
		public function logMessage(message:String, severity:int):void {
			throw new IllegalOperationError("logMessage must be implemented by the sub class");
		}
		
	}
	
}