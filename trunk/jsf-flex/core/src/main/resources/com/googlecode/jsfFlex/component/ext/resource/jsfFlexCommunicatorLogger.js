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

if(!com.googlecode.jsfFlex){
    com.googlecode.jsfFlex = {};
}else if(typeof com.googlecode.jsfFlex != "object"){
	throw new Error("com.googlecode.jsfFlex exists but is not of type object");
}

if(!com.googlecode.jsfFlex.communication){
    com.googlecode.jsfFlex.communication = {};
}else if(typeof com.googlecode.jsfFlex.communication != "object"){
	throw new Error("com.googlecode.jsfFlex.communication exists but is not of type object");
}

if(!com.googlecode.jsfFlex.communication.logger){
    com.googlecode.jsfFlex.communication.logger = {};
}else if(typeof com.googlecode.jsfFlex.communication.logger != "object"){
	throw new Error("com.googlecode.jsfFlex.communication.logger exists but is not of type object");
}

//private namespace
(function() {
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
	
	//callers
	com.googlecode.jsfFlex.communication.logger.logFlashMessage = logFlashMessage;
})();
