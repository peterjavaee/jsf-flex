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
import java.util.Map;

import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;

import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;
import com.googlecode.jsfFlex.shared.adapter._MXMLContract;
import com.googlecode.jsfFlex.util.MXMLJsfUtil;

/**
 * This component should be used as the base action of the component if the component<br>
 * does not require any preservation of values during the post-back phase [i.e. AbstractMXMLUIVideoDisplay].<br>
 * 
 * @author Ji Hoon Kim
 */
public abstract class MXMLUISimpleBase extends UIComponentBase implements _MXMLContract {
	
	private String _absolutePathToPreMxmlFile;
	
	private String _preMxmlIdentifier;
	private String _parentPreMxmlIdentifier;
	/*
	 * below two variables dictate the depth and the height of this component
	 * in reference to the top component which should be of MXMLApplication. 
	 */
	private int _majorLevel = -1;
	private int _minorLevel = -1;

	public MXMLUISimpleBase(){
		super();
	}
	
	public String getMXMLComponentRenderer(){
		return null;
	}
	
	public Map getComponentValues(){
    	return null;
    }

	public void encodeBegin(FacesContext context) throws IOException {
		try{
			MXMLJsfUtil.setComponentProperties(this, context);
		}catch(ComponentBuildException _componentBuildException){
			throw new IOException(_componentBuildException.getMessage());
		}
		
		super.encodeBegin(context);
	}

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
