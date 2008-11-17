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
 * This class is a simple wrapper to HTTPService using JSON.
 * In future it is considered to improve the implementation by adding caching and etcetera.
 * @author Ji Hoon Kim
 */
package com.googlecode.jsfFlex.communication.services
{
	import mx.rpc.events.ResultEvent;
	import mx.rpc.http.HTTPService;
	
	import com.googlecode.jsfFlex.communication.logger.ILogger;
	import com.googlecode.jsfFlex.communication.logger.LoggerFactory
	
	public class JSONHttpService {
		
		private static const DELETE_METHOD:String = "DELETE";
		private static const GET_METHOD:String = "GET";
		private static const POST_METHOD:String = "POST";
		private static const PUT_METHOD:String = "PUT";
		
		private static var _log:ILogger;
		
		{
			_log = LoggerFactory.newJSLoggerInstance(JSONHttpService);
		}
		
		public function JSONHttpService(){
			super();
		}
		
		public function sendHttpRequest(serviceUrl:String, parameters:Object, rootUrl:String, thisObject:Object, callBack:Function):void{
			//NOTE : rootUrl is only to specify absolute URL, if not specified the path to SWF is used
			var httpRequest:HTTPService = rootUrl == null ? new HTTPService() : new HTTPService(rootUrl);
			httpRequest.url = serviceUrl;
			httpRequest.method = POST_METHOD;
			httpRequest.addEventListener(ResultEvent.RESULT, function(event:ResultEvent):void{
																			callBack.call(thisObject, event.result);
																		}, false, 0, false);
			
			httpRequest.send(parameters);
			_log.logInfo("Sent JSONHttpService request to : " + serviceUrl + " with : " + (parameters == null ? "" : parameters.toString()));
		}
		
	}
	
}