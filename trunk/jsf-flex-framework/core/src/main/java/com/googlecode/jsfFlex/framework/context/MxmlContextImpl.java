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
package com.googlecode.jsfFlex.framework.context;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.googlecode.jsfFlex.framework.tasks._CommonTaskRunner;
import com.googlecode.jsfFlex.framework.tasks._FileManipulatorTaskRunner;
import com.googlecode.jsfFlex.framework.tasks._FlexTaskRunner;
import com.googlecode.jsfFlex.framework.tasks.factory._RunnerFactory;

/**
 * An implementation of MxmlContext which will instantiate and store all the needed data structures<br>
 * and instantiate and store the implementation of following interfaces :<br>
 * <ul>
 *     <li> _FileManipulatorTaskRunner
 *     <li> _FlexTaskRunner
 *     <li> _CommonTaskRunner
 * </ul>
 * Also it will set the current MxmlContextImpl to the ThreadLocal.<br>
 * 
 * @author Ji Hoon Kim
 */
public class MxmlContextImpl extends MxmlContext {
	
	private boolean _productionEnv;
	private boolean _simplySWF;
	
	private Map _preMxmlCompMap;
	private Map _applicationIdValueMap;
	private String _currMxml;
	
	private String _mxmlPath;
	private String _preMxmlPath;
	private String _swcPath;
	private String _swfPath;
	private String _swfWebPath;
	private String _swfBasePath;
	private String _flexSDKPath;
	
	private _RunnerFactory _runnerFactoryInstance;
	private _FileManipulatorTaskRunner _fileManipulatorRunner;
	private _FlexTaskRunner _flexRunner;
	private _CommonTaskRunner _commonRunner;
	
	public MxmlContextImpl(String currMxml){
		super();
		_currMxml = currMxml;
		_preMxmlCompMap = new TreeMap();
		_applicationIdValueMap = new HashMap();
		_runnerFactoryInstance = _RunnerFactory.getInstance();
		_flexRunner = _runnerFactoryInstance.getFlexTaskRunnerImpl();
		_commonRunner = _runnerFactoryInstance.getCommonTaskRunnerImpl();
		_fileManipulatorRunner = _runnerFactoryInstance.getFileManipulatorTaskRunnerImpl();
		MxmlContext.setCurrentInstance(this);
	}
	
	public boolean isProductionEnv() {
		return _productionEnv;
	}
	public void setProductionEnv(boolean productionEnv) {
		_productionEnv = productionEnv;
	}
	public boolean isSimplySWF() {
		return _simplySWF;
	}
	public void setSimplySWF(boolean simplySWF) {
		_simplySWF = simplySWF;
	}
	public Map getApplicationIdValueMap() {
		return _applicationIdValueMap;
	}
	public void setApplicationIdValueMap(Map applicationIdValueMap) {
		_applicationIdValueMap = applicationIdValueMap;
	}
	public String getCurrMxml() {
		return _currMxml;
	}
	public void setCurrMxml(String currMxml) {
		_currMxml = currMxml;
	}
	public String getFlexSDKPath() {
		return _flexSDKPath;
	}
	public void setFlexSDKPath(String flexSDKPath) {
		_flexSDKPath = flexSDKPath;
	}
	public String getMxmlPath() {
		return _mxmlPath;
	}
	public void setMxmlPath(String mxmlPath) {
		_mxmlPath = mxmlPath;
	}
	public String getPreMxmlPath() {
		return _preMxmlPath;
	}
	public void setPreMxmlPath(String preMxmlPath) {
		_preMxmlPath = preMxmlPath;
	}
	public Map getPreMxmlCompMap() {
		return _preMxmlCompMap;
	}
	public void setPreMxmlCompMap(Map preMxmlCompMap) {
		_preMxmlCompMap = preMxmlCompMap;
	}
	public String getSwfBasePath() {
		return _swfBasePath;
	}
	public void setSwfBasePath(String swfBasePath) {
		_swfBasePath = swfBasePath;
	}
	public String getSwcPath() {
		return _swcPath;
	}
	public void setSwcPath(String swcPath) {
		_swcPath = swcPath;
	}
	public String getSwfPath() {
		return _swfPath;
	}
	public void setSwfPath(String swfPath) {
		_swfPath = swfPath;
	}
	public String getSwfWebPath() {
		return _swfWebPath;
	}
	public void setSwfWebPath(String swfWebPath) {
		_swfWebPath = swfWebPath;
	}
	public _CommonTaskRunner getCommonRunner() {
		return _commonRunner;
	}
	public _FlexTaskRunner getFlexRunner() {
		return _flexRunner;
	}
	public _FileManipulatorTaskRunner getFileManipulatorRunner() {
		return _fileManipulatorRunner;
	}
	public _RunnerFactory getRunnerFactoryInstance() {
		return _runnerFactoryInstance;
	}
	
}
