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
dojo.require("dojox.collections.Dictionary");

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
	addFlashApp: function(_flashApp){
					var _namingContainerPrefixList = com.googlecode.jsfFlex.flashAppsKeyNamingContainer.item(_flashApp.namingContainerPrefix);
					if(_namingContainerPrefixList == null){
						_namingContainerPrefixList = new Array();
						com.googlecode.jsfFlex.flashAppsKeyNamingContainer.add( _flashApp.namingContainerPrefix, _namingContainerPrefixList );
					}
					com.googlecode.jsfFlex.flashAppsKeyAppId.add( _flashApp.appId, _flashApp );
					_namingContainerPrefixList.push(_flashApp);
				 },
	flashAppsKeyNamingContainer: new dojox.collections.Dictionary(),
	flashAppsKeyAppId: new dojox.collections.Dictionary(),
	
	getApplication:	function(_appId){
						if (navigator.appName.indexOf("Microsoft") != -1) {
							return document.getElementById(_appId);
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
    var flashAppsToUpdateCount = 0;
	var currUnloaded = 0;
	
	function amReady(_readyAmI){
		var _flashApp = com.googlecode.jsfFlex.flashAppsKeyAppId.item( _readyAmI );
		if(_flashApp){
			if(_flashApp.arrayOfIds){
				return _flashApp;
			}
		}else{
			/* Must not have been added yet, so simply connect a function to com.googlecode.jsfFlex.addFlashApp */
			var _handle = dojo.connect(com.googlecode.jsfFlex, "addFlashApp", function(){
											var _flashApp = com.googlecode.jsfFlex.flashAppsKeyAppId.item( _readyAmI );
											if(_flashApp){
												if(_flashApp.arrayOfIds){
													var _access = com.googlecode.jsfFlex.getApplication( _readyAmI );
													_access.populateInitValues( _flashApp );
												}
												dojo.disconnect(_handle);
											}
										});
						
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
		if(flashAppsToUpdateCount == currUnloaded){
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
		/*
		 * For simplicity, currently is supported for FireFox:FireBug only
		 * TODO: Consider supporting other browsers in the future
		 */
		switch(_severity){
			case 1 :	if(console) console.log(_logMessage); return;
			case 2 :	if(console) console.debug(_logMessage); return;
			case 3 :	if(console) console.info(_logMessage); return;
			case 4 :	if(console) console.warn(_logMessage); return;
			case 5 :	if(console) console.error(_logMessage); return;
		}
		
	}
	
	function pageLoad(){
		for(var i=0; i < document.forms.length; i++){
			dojo.connect(document.forms[i], "onsubmit", pageUnload);
		}
	}
	
	function pageUnload(_event){
		/*
		 * during the page creation :
		 * 	JSON with =>
		 *	  appId 					: applicationId specifying the flash app
		 *    namingContainerPrefix		: namingContainerPrefix [i.e. form that this flashApp is affiliated with]
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
		
		var _namingContainerPrefixList = com.googlecode.jsfFlex.flashAppsKeyNamingContainer.item(_src.id);
		flashAppsToUpdateCount = _namingContainerPrefixList.length;
		var _access;
		for(var i=0; i < _namingContainerPrefixList.length; i++){
			/** If there does not exist any value to retrieve of, simply continue */
			if(!_namingContainerPrefixList[i].arrayOfIds){
				currUnloaded++;
				continue;
			}
			_access = com.googlecode.jsfFlex.getApplication(_namingContainerPrefixList[i].appId);
			try{
				_access.pageUnloading(_namingContainerPrefixList[i]);
			}catch(error){
				throw new Error("During the pageUnloading process, an error occurred while invoking pageUnloading for appId [" + 
									_namingContainerPrefixList[i].appId + "]");
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
