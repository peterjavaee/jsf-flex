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
	import flash.events.Event;
	
	import flash.net.URLLoader;
	import flash.net.URLRequest;
	
	import flash.utils.clearInterval;
	import flash.utils.setInterval;
	
	internal class AbstractLogger implements ILogger {
		
		private static const JSF_FLEX_FLASH_APPLICATION_CONFIG:String = "swf/jsfFlexFlashApplicationConfig.xml";
		private static const PRIOR_TO_LOG_MODE_SETTING_MESSAGES:Array = new Array();
		
		private static var _clearIntervalRef:uint;
		private static var _logMode:int = -1;
		private static var _loader:URLLoader;
		
		{
			_clearIntervalRef = setInterval( logPreLogModeSettingMessages, 500);
			_loader = new URLLoader();
			
			_loader.addEventListener(Event.COMPLETE, function (event:Event):void {
										_loader.removeEventListener(Event.COMPLETE, arguments.callee, false);
										var jsfFlexFlashApplicationConfig:XML = new XML(_loader.data);
										_logMode = int(jsfFlexFlashApplicationConfig.flash_to_javascript_log_level.toString());
										clearInterval(_clearIntervalRef);
										logPreLogModeSettingMessages();
									});
			
			try{
				_loader.load(new URLRequest(JSF_FLEX_FLASH_APPLICATION_CONFIG));
			}catch(loadingError:Error){
				trace("Failure in loading of the jsfFlexFlashApplicationConfig.xml file");
			}
		}
		
		public static function logPreLogModeSettingMessages():void {
			
			if(_logMode < 0){
				return;
			}
			
			for each(var messageObject:Object in PRIOR_TO_LOG_MODE_SETTING_MESSAGES){
				var currSeverity:int = messageObject.severity;
				var currFunction:Function = messageObject.method;
				if(_logMode < currSeverity){
					currFunction.call(messageObject.instanceRef, messageObject.message, (currSeverity - 1));
				}
			}
			
		}
		
		public function AbstractLogger(logClass:Class) {
			super();
		}
		
		public function log(errorMessage:String):void {
			if(_logMode == -1){
				PRIOR_TO_LOG_MODE_SETTING_MESSAGES.push({instanceRef: this, method: logMessage, message: errorMessage, severity: 2});
				return;
			}
			if(_logMode < 2){
				logMessage(errorMessage, 1);
			}
		}
		
		public function logDebug(errorMessage:String):void {
			if(_logMode == -1){
				PRIOR_TO_LOG_MODE_SETTING_MESSAGES.push({instanceRef: this, method: logMessage, message: errorMessage, severity: 3});
				return;
			}
			if(_logMode < 3){
				logMessage(errorMessage, 2);
			}
		}
		
		public function logInfo(errorMessage:String):void {
			if(_logMode == -1){
				PRIOR_TO_LOG_MODE_SETTING_MESSAGES.push({instanceRef: this, method: logMessage, message: errorMessage, severity: 4});
				return;
			}
			if(_logMode < 4){
				logMessage(errorMessage, 3);
			}
		}
		
		public function logWarn(errorMessage:String):void {
			if(_logMode == -1){
				PRIOR_TO_LOG_MODE_SETTING_MESSAGES.push({instanceRef: this, method: logMessage, message: errorMessage, severity: 5});
				return;
			}
			if(_logMode < 5){
				logMessage(errorMessage, 4);
			}
		}
		
		public function logError(errorMessage:String):void {
			if(_logMode == -1){
				PRIOR_TO_LOG_MODE_SETTING_MESSAGES.push({instanceRef: this, method: logMessage, message: errorMessage, severity: 6});
				return;
			}
			if(_logMode < 6){
				logMessage(errorMessage, 5);
			}
		}
		
		public function logMessage(message:String, severity:int):void {
			throw new IllegalOperationError("logMessage must be implemented by the sub class");
		}
		
	}
	
}