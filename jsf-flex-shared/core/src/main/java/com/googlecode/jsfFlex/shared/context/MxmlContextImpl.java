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
package com.googlecode.jsfFlex.shared.context;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.googlecode.jsfFlex.shared.adapter._MXMLApplicationContract;
import com.googlecode.jsfFlex.shared.beans.additionalScriptContent.AdditionalApplicationScriptContent;
import com.googlecode.jsfFlex.shared.tasks._CommonTaskRunner;
import com.googlecode.jsfFlex.shared.tasks._FileManipulatorTaskRunner;
import com.googlecode.jsfFlex.shared.tasks._FlexTaskRunner;
import com.googlecode.jsfFlex.shared.tasks._RunnerFactory;

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
	
	private final Map _preMxmlCompMap;
	private final AdditionalApplicationScriptContent _additionalAppScriptContent;
	private final List _applicationInitValueList;
	
	private final String _currMxml;
	
	private final _RunnerFactory _runnerFactoryInstance;
	private final _FileManipulatorTaskRunner _fileManipulatorRunner;
	private final _FlexTaskRunner _flexRunner;
	private final _CommonTaskRunner _commonRunner;
	
	private boolean _productionEnv;
	private boolean _simplySWF;
	
	private String _mxmlPath;
	private String _preMxmlPath;
	private String _swcPath;
	private String _swfPath;
	private String _swfWebPath;
	private String _swfBasePath;
	private String _flexSDKPath;
	
	public MxmlContextImpl(String currMxml, _MXMLApplicationContract currApplicationContract){
		super();
		_currMxml = currMxml;
		_preMxmlCompMap = new TreeMap();
		_additionalAppScriptContent = new AdditionalApplicationScriptContent(_currMxml, currApplicationContract);
		_applicationInitValueList = new LinkedList();
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
	public AdditionalApplicationScriptContent getAdditionalAppScriptContent() {
		return _additionalAppScriptContent;
	}
	public List getApplicationInitValueList() {
		return _applicationInitValueList;
	}
	public String getCurrMxml() {
		return _currMxml;
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
