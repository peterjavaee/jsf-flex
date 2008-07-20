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

var com;

if(!com){
    com = {};
}else if(typeof com != "object"){
	throw new Error("com exists but is not of type object");
}

if(!com.googlecode){
    com.googlecode = {};
}else if(typeof com.googlecode != "object"){
	throw new Error("com.googlecode exists but is not of type object");
}

if(com.googlecode.jsfFlex){
    throw new Error("com.googlecode.jsfFlex namespace already exists");
}

com.googlecode.jsfFlex = {
	flashApps: new Array(),
	
	getApplication:	function(_appId){
						if (navigator.appName.indexOf("Microsoft") != -1) {
							return window[_appId] ? window[_appId] : document.getElementById(_appId).object;
						}else{
							return document[_appId];
						}
					}
};

if(com.googlecode.jsfFlex.communication){
    throw new Error("com.googlecode.jsfFlex.communication namespace already exists");
}

com.googlecode.jsfFlex.communication = {
	
	getCompValue:	function(_appId, _objectId){
						var _access = com.googlecode.jsfFlex.getApplication(_appId);
						if(_access == null){
							throw new Error("appId [" + _appId + "] returned a null value during lookup");
						}
						var _value;
						
						try{
							_value = _access.getCompValue(_objectId);
						}catch(error){
							throw new Error("Error while invoking getCompValue for appId, objectId [" + _appId + ", " + _objectId + "]");
						}
						return _value;
					}
	
};

//private namespace
(function() {
	var checkInterval = null;
    var formSubmit = null;
	var currUnloaded = 0;
	
	function amReady(_readyAmI){
		for(var i=0; i < com.googlecode.jsfFlex.flashApps.length; i++){
			if(_readyAmI == com.googlecode.jsfFlex.flashApps[i].appId){
				return com.googlecode.jsfFlex.flashApps[i];
			}
		}
	}
	
	function appendElement(_jsonNodes){
		
		var _htmlType;
		var _attributeArray;
		var _ele;
		var _attr;
		for(var i=0; i < _jsonNodes.length; i++){
			_htmlType = _jsonNodes[i].htmlType;
			_attributeArray = _jsonNodes[i].attributeArray;
			if(_htmlType != null && _htmlType != "null"){
				_ele = document.createElement(_htmlType);
				for(var j=0; j < _attributeArray.length; j++){
					_attr = document.createAttribute(_attributeArray[j].attribute);
					_attr.nodeValue = _attributeArray[j].value;
					_ele.setAttributeNode(_attr);
				}
				formSubmit.appendChild(_ele);
			}
		}
		
	}
	
	function checkUnLoadStatus(){
		if(com.googlecode.jsfFlex.flashApps.length == currUnloaded){
			window.clearInterval(checkInterval);
			formSubmit.submit();
		}
	}
	
	function getEvent(_event){
		return (window.event) ? window.event : _event;
	}
	
	function getSrcElement(_event){
		return (_event.target) ? _event.target : _event.srcElement;
	}
	
	function logFlashMessage(_logMessage, _severity){
		var methods = new Array();
		switch(_severity){
			case _severity < 1 :	if(console) methods.push(console.log);
			case _severity < 2 :	if(console) methods.push(console.debug);
			case _severity < 3 :	if(console) methods.push(console.info);
			case _severity < 4 :	if(console) methods.push(console.warn);
			case _severity < 5 :	if(console) methods.push(console.error);
		}
		
		if(methods.length > 0){
			for(var method in methods){
				method(_logMessage);
			}
		}else{
			if(_severity != 5){
				alert(_logMessage);
			}else{
				throw new Error(_logMessage);
			}
		}
	}
	
	function pageLoad(){
		for(var i=0; i < document.forms.length; i++){
			dojo.event.connect(document.forms[i], "onsubmit", pageUnload);
		}
	}
	
	function pageUnload(_event){
		/* during the page creation :
		 * 	JSON with =>
		 *	  appId 					: applicationId specifying the flash app
		 *	  arrayOfIds 				: an array of...
		 *									id			:	id of the component
		 *									initValues	:	an array of...
		 *													attribute	:	attribute to set for the initValue
		 *													value		:	value to set as the initValue
		 *	  
		 *  will be created
		 */
		var _src = getSrcElement( getEvent(_event) );
		formSubmit = dojo.byId(_src.id);
		var _access;
		for(var i=0; i < com.googlecode.jsfFlex.flashApps.length; i++){
			_access = com.googlecode.jsfFlex.getApplication(com.googlecode.jsfFlex.flashApps[i].appId);
			try{
				_access.pageUnloading(com.googlecode.jsfFlex.flashApps[i]);
			}catch(error){
				throw new Error("During the pageUnloading process, an error occurred while invoking pageUnloading for appId [" + 
									com.googlecode.jsfFlex.flashApps[i].appId + "]");
			}
		}
		checkInterval = window.setInterval(checkUnLoadStatus, 1000);
		return false;
	}
	
	function updateValues(_jsonObjects){
		/*
		 * will have an array of array =>
		 *	 array	: that will contain array as elements
		 *		arrayElement :	will contain htmlType to create and an array of attributes
		 *			htmlType		:	htmlType to create of [node]
		 *			attributeArray	:	an array of attributes
		 *				attribute	:	attribute to create of
		 *				value		:	value to set to
		 *	
		 */
		for(var i=0; i < _jsonObjects.length; i++){
			appendElement(_jsonObjects[i]);
		}
		currUnloaded++;
	}
	
	//callers
	com.googlecode.jsfFlex.communication.amReady = amReady;
	com.googlecode.jsfFlex.communication.logFlashMessage = logFlashMessage;
	com.googlecode.jsfFlex.communication.pageLoad = pageLoad;
    com.googlecode.jsfFlex.communication.updateValues = updateValues;
    
})();
