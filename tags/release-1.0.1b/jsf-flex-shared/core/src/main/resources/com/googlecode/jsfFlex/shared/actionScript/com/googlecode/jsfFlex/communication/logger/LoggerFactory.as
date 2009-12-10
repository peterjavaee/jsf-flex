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
 * This class is a factory for creating different impl of Loggers
 * [i.e. JavaScriptLogger for communicating log messages FireFox:FireBug]
 * @author Ji Hoon Kim
 */
package com.googlecode.jsfFlex.communication.logger
{
	import flash.errors.IllegalOperationError;
	
	public class LoggerFactory {
		
		public function LoggerFactory(){
			throw new IllegalOperationError("LoggerFactory should be used as a factory");
		}
		
		public static function newJSLoggerInstance(actionScriptClass:Class):ILogger {
			var log:JavaScriptLogger = new JavaScriptLogger(actionScriptClass);
			return log;
		}
		
	}
	
}