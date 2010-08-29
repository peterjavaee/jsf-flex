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
 * @author Ji Hoon Kim
 */
package com.googlecode.jsfFlex.communication.event
{
	import flash.events.Event;
	import flash.external.ExternalInterface;
	import mx.core.UIComponent;
	import mx.rpc.events.ResultEvent;
	
	import com.googlecode.jsfFlex.communication.core.ComponentValueMapper;
	import com.googlecode.jsfFlex.communication.logger.ILogger;
	import com.googlecode.jsfFlex.communication.logger.LoggerFactory;
	import com.googlecode.jsfFlex.communication.services.JsfFlexHttpService;
	
	public class PropertyUpdateEventHandler extends AbstractEventHandler {
		
		private static const SOURCE_PROPERTY_CURRENT_VALUE_ATTR:String = "SOURCE_PROPERTY_CURRENT_VALUE";
		private static var _log:ILogger;
		
		private var _compValMapper:ComponentValueMapper;
		private var _refApp:UIComponent;
		private var _srcId:String;
		private var _tgtId:String;
		private var _eventHandlerId:String;
		private var _additionalArgs:Object;
		private var _sourceValueHolderObject:Object;
		private var _targetValueUpdateObject:Object;
		
		{
			_log = LoggerFactory.newJSLoggerInstance(PropertyUpdateEventHandler);
		}
		
		public function PropertyUpdateEventHandler(srcId:String, tgtId:String, eventHandlerId:String, eventName:String, additionalArgs:Object,
														compValMapper:ComponentValueMapper, refApp:UIComponent) {
			super(refApp[srcId], eventName);
			
			_compValMapper = compValMapper;
			_refApp = refApp;
			_srcId = srcId;
			_tgtId = tgtId;
			_eventHandlerId = eventHandlerId;
			_additionalArgs = additionalArgs;
			
			/*
			 * Traverse until length - 1, since one wishes to get the reference of the 
			 * Object that holds the property of which one wishes to fetch or update.
			 *
			 * Can have a function to take care of this task, since ActionScript 3 is
			 * pass by reference
			 */
			
			var sourceComponent:Object = refApp[_srcId];
			var sourcePropertyTraverseArray:Array = _additionalArgs.SOURCE_PROPERTY;
			setPropertyObjects(sourceComponent, _sourceValueHolderObject, sourcePropertyTraverseArray);
			
			var targetComponent:Object = refApp[_tgtId];
			var targetPropertyTraverseArray:Array = _additionalArgs.TARGET_PROPERTY;
			setPropertyObjects(targetComponent, _targetValueUpdateObject, targetPropertyTraverseArray);
			
			activateListener();
		}
		
		private function setPropertyObjects(component:Object, valueHolder:Object, propertyTraverseList:Array):void {
			
			if(propertyTraverseList.length == 1){
				valueHolder = component;
			}else{
				valueHolder = component[propertyTraverseList[0]];
				for(var i:uint=1, j:uint=propertyTraverseList.length-1; i < j; i++){
					valueHolder = _sourceValueHolderObject[propertyTraverseList[i]];
				}
			}
			
		}
		
		override public function handleEvent(event:Event):void {
			_log.info("Executing a data update value request for component " + _tgtId);
			
			/*
			 * Since _sourceValueHolderObject and _targetValueUpdateObject have already been
			 * set, only need to get the property and update the property by using the last 
			 * property within the list
			 */
			
			var sourcePropertyTraverseArray:Array = _additionalArgs.SOURCE_PROPERTY;
			var currPropertyValue:Object = _sourceValueHolderObject[sourcePropertyTraverseArray[sourcePropertyTraverseArray.length - 1]];
			
			var dataRequestParameters:Object = {};
			dataRequestParameters.componentId = _eventHandlerId;
			dataRequestParameters.methodToInvoke = ASYNC_PROCESS_REQUEST;
			dataRequestParameters[SOURCE_PROPERTY_CURRENT_VALUE] = currPropertyValue;
			
			var jsfFlexHttpServiceRequest:JsfFlexHttpService = new JsfFlexHttpService();
			jsfFlexHttpServiceRequest.sendHttpRequest(ASYNC_SERVICE_REQUEST_URL, this,
															function (lastResult:Object, event:ResultEvent):void {
																_log.info("Returned from : " + ASYNC_SERVICE_REQUEST_URL + " of src/target :" + _srcId + "/" + _tgtId);
																
																var updateValue:String = lastResult.PROPERTY_VALUE_ATTRIBUTE;
																
																var targetPropertyTraverseArray:Array = _additionalArgs.TARGET_PROPERTY;
																_targetValueUpdateObject[targetPropertyTraverseArray[targetPropertyTraverseArray.length - 1]] = updateValue;
																
															}, dataRequestParameters, JsfFlexHttpService.POST_METHOD, JsfFlexHttpService.OBJECT_RESULT_FORMAT, null);
			
			
		}
		
	}
	
}