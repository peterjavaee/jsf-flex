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
package com.googlecode.jsfFlex.component;

import java.io.IOException;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.googlecode.jsfFlex.renderkit.annotationDocletParser._AnnotationDocletParser;
import com.googlecode.jsfFlex.shared.adapter._MXMLContract;
import com.googlecode.jsfFlex.shared.context.MxmlContext;
import com.googlecode.jsfFlex.shared.tasks._RunnerFactory;
import com.googlecode.jsfFlex.shared.util.MXMLAttributeConstants;

/**
 * This class will process the needed actions of creating JSONObject and JSONArray needed<br>
 * by subclasses to preserve the state of beans during the post back phase.<br>
 * 
 * @author Ji Hoon Kim
 */
public abstract class MXMLUIInputBase extends UIInput implements _MXMLContract {
	
	private final static Log _log = LogFactory.getLog(MXMLUIInputBase.class);
	
	protected static final String ATTRIBUTE = "attribute";
	protected static final String VALUE = "value";
	
	private static final String INIT_VALUES = "initValues";
	
	protected JSONArray _initValues;
	
	private JSONObject _componentInitValueObject;
	
	private _AnnotationDocletParser _annotationDocletParserInstance;
	
	private String _absolutePathToPreMxmlFile;
	private String _preMxmlIdentifier;
    private String _parentPreMxmlIdentifier;
    
	/*
	 * below two variables dictate the depth and the height of this component
	 * in reference to the top component which should be of MXMLApplication. 
	 */
	private int _majorLevel = -1;
	private int _minorLevel = -1;
	
	public MXMLUIInputBase(){
		super();
	}
	
	{
		try{
			_componentInitValueObject = new JSONObject();
			_initValues = new JSONArray();
			
			_componentInitValueObject.put(INIT_VALUES, _initValues);
			
		}catch(JSONException jsonException){
			_log.info("Error while formatting to JSON content", jsonException);
		}
	}
	
	public JSONObject getComponentInitValues(){
		return _componentInitValueObject;
    }
	
	public void encodeBegin(FacesContext context) throws IOException {
		super.encodeBegin(context);
		
		try{
			_componentInitValueObject.put(MXMLAttributeConstants.ID_ATTR, getId());
		}catch(JSONException jsonException){
			_log.info("Error while formatting to JSON content", jsonException);
		}
		
		populateComponentInitValues();
		
		MxmlContext mxmlContext = MxmlContext.getCurrentInstance();
		List applicationInitValueList = mxmlContext.getApplicationInitValueList();
    	applicationInitValueList.add(getComponentInitValues());
		
	}
	
	public _AnnotationDocletParser getAnnotationDocletParserInstance(){
		
		if(_annotationDocletParserInstance == null){
			MxmlContext mxmlContext = MxmlContext.getCurrentInstance();
			_RunnerFactory _runnerFactoryInstance = mxmlContext.getRunnerFactoryInstance();
			_annotationDocletParserInstance = _runnerFactoryInstance.getAnnotationDocletParserImpl();
		}
		
		return _annotationDocletParserInstance;
	}
	
	protected abstract void populateComponentInitValues();

	public String getAbsolutePathToPreMxmlFile() {
		return _absolutePathToPreMxmlFile;
	}
	public void setAbsolutePathToPreMxmlFile(String absolutePathToPreMxmlFile) {
		_absolutePathToPreMxmlFile = absolutePathToPreMxmlFile;
	}
	public int getMajorLevel() {
		return _majorLevel;
	}
	public void setMajorLevel(int majorLevel) {
		_majorLevel = majorLevel;
	}
	public int getMinorLevel() {
		return _minorLevel;
	}
	public void setMinorLevel(int minorLevel) {
		_minorLevel = minorLevel;
	}
	public String getParentPreMxmlIdentifier() {
		return _parentPreMxmlIdentifier;
	}
	public void setParentPreMxmlIdentifier(String parentPreMxmlIdentifier) {
		_parentPreMxmlIdentifier = parentPreMxmlIdentifier;
	}
	public String getPreMxmlIdentifier() {
		return _preMxmlIdentifier;
	}
	public void setPreMxmlIdentifier(String preMxmlIdentifier) {
		_preMxmlIdentifier = preMxmlIdentifier;
	}
	
}