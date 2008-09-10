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
package com.googlecode.jsfFlex.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;

import com.googlecode.jsfFlex.component.attributes._MXMLUIDataProviderAttribute;
import com.googlecode.jsfFlex.framework.beans.mxml.MXMLBeanWrapper;
import com.googlecode.jsfFlex.framework.beans.mxml._MXMLBean;
import com.googlecode.jsfFlex.framework.context.MxmlContext;
import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;
import com.googlecode.jsfFlex.framework.util.MXMLConstants;
import com.googlecode.jsfFlex.shared.adapter._MXMLContract;

/**
 * This Util class will provide functionalities that are need by JSF Flex components, such as : <br>
 * <ul>
 * 	<li> escapeCharacters 		: This method will take the argument and return an encoded version in UTF-8<br>
 * 	<li> setComponentProperties : This method is responsible for setting the components preMxml properties [i.e. its major and minor numbers].<br>
 *	 							  The reason this method is held within an Utility class is because the base action classes extend from different<br>
 *								  classes [i.e. MXMLUISimpleBase extend from UIComponentBase and MXMLUIInputBase extend from UIInput].<br>
 * </ul>
 * 
 * @author Ji Hoon Kim
 */
public final class MXMLJsfUtil {
	
	private final static String WINDOWS_LINE_FEED = "\r\n";
	private final static String UNIX_LINE_FEED = "\n";
	
	private final static String LINE_FEED_ESCAPER = "LINE_FEED";
	private final static String ENCODING = "UTF-8";
	
	private final static String DATA_PROVIDER_BEAN_SUFFIX = "MxmlBean";
	private final static String DATA_PROVIDER_COLLECTION_ATTR = "dataProviderCollection";
	private final static String DATA_PROVIDER_ATTR = "dataProvider";
	private final static String INVALID_DATA_PROVIDER_DATA_BINDING_FIELD_MESSAGE = "Only type of dataBinding allowed for dataProviderCollec field is of String or Collection";
	
	private MXMLJsfUtil(){
		super();
	}
	
	public static void processDataProviderCollection(UIComponent _currComponent, _MXMLUIDataProviderAttribute _dataProviderComponent){
		
		//TODO : Implement this better later
		ValueBinding _valueBinding = _currComponent.getValueBinding(DATA_PROVIDER_COLLECTION_ATTR);
		if(_valueBinding != null){
			Object value = _valueBinding.getValue(FacesContext.getCurrentInstance());
			if(value != null){
				//ONLY other type accepted is Collection<_MXMLBean>
				if(!(value instanceof Collection)){
					throw new IllegalArgumentException(INVALID_DATA_PROVIDER_DATA_BINDING_FIELD_MESSAGE);
				}
				
				String _componentId = _currComponent.getId() + DATA_PROVIDER_BEAN_SUFFIX;
				Collection _valueCollection = (Collection) value;
				
				MXMLBeanWrapper _mxmlBeanWrapper = new MXMLBeanWrapper(_componentId, 
														(_MXMLBean) _valueCollection.iterator().next());
				
				MxmlContext _currInstance = MxmlContext.getCurrentInstance();
				_currInstance.getMxmlObjectBeanWrapperSet().add(_mxmlBeanWrapper);
				
				_dataProviderComponent.setDataProvider("{" + _componentId + "}");
			}
		}
		
	}
	
	/**
	 * This method will take the argument and return an encoded version in UTF-8. Also it will replace<br>
	 * line feeds ("\r\n", "\n") with the "LINE_FEED" string [due to how Flash interprets these two line feeds<br>
	 * differently. Then the conversion back to its non-replaced and encoded value will be made on the Flash side.<br>
	 * 
	 * @param toEscape
	 * @return Encoded version of toEscape
	 */
	public static String escapeCharacters(String toEscape) throws ComponentBuildException {
		if(toEscape == null){
			return "";
		}
		//TODO : implement this better
		try{
			/*
			 * special case for line feeds, since otherwise it is replaced with two
			 * line feeds on the flash side
			 */
			toEscape = toEscape.replaceAll(WINDOWS_LINE_FEED, LINE_FEED_ESCAPER);
			toEscape = toEscape.replaceAll(UNIX_LINE_FEED, LINE_FEED_ESCAPER);
			return java.net.URLEncoder.encode(toEscape, ENCODING);
		}catch(java.io.UnsupportedEncodingException unsupportedEncodingExcept){
			throw new ComponentBuildException("UnsupportedEncoding of " + ENCODING + ", in another words this " +
												"shouldn't happen", unsupportedEncodingExcept);
		}
		
	}
	
	/**
	 * This method is responsible for setting the components preMxml properties [i.e. its major and minor numbers].<br>
	 * The reason this method is held within an Utility class is because the base action classes extend from different<br>
	 * classes [i.e. MXMLUISimpleBase extend from UIComponentBase and MXMLUIInputBase extend from UIInput].<br>
	 * 
	 * @param component
	 * @param context
	 */
	public static void setComponentProperties(UIComponent component, FacesContext context) throws ComponentBuildException {
    	//set the major level, minor level, and absolutePathToPreMxmlFile
    	UIComponent parent = component.getParent();
    	_MXMLContract currMXMLComp = (_MXMLContract) component;
    	
    	if(parent == null){
    		//this should never happen
    		throw new NullPointerException("Component " + component.getClass().getName() + 
    											" lacks parent component");
    	}
    	//set the name for absolutePathToPreMxmlFile
    	MxmlContext mxmlContext = MxmlContext.getCurrentInstance();
    	
    	if(!(component instanceof com.googlecode.jsfFlex.component.ext.MXMLUIApplication) && currMXMLComp.getComponentValues() != null){
	    	Map applicationIdValueMap = mxmlContext.getApplicationIdValueMap();
	    	applicationIdValueMap.put(component.getId(), currMXMLComp.getComponentValues());
    	}
    	
    	if(mxmlContext.isProductionEnv() || mxmlContext.isSimplySWF()){
    		//do not need to create preMXML files
    		return;
    	}
    	
    	if(parent instanceof _MXMLContract && !(component instanceof com.googlecode.jsfFlex.component.ext.MXMLUIApplication)){
    		_MXMLContract mxmlInstance = (_MXMLContract) parent;
    		int tempInt = mxmlInstance.getMajorLevel();
    		currMXMLComp.setMajorLevel(++tempInt);
    		
			//now set the minor level
        	List childrenList = parent.getChildren();
        	UIComponent currComp;
        	int counter = 0;
        	
        	for(Iterator iterate = childrenList.iterator(); iterate.hasNext();){
        		//get the component's position within structure
        		currComp = (UIComponent) iterate.next();
        		if(currComp == component){
        			//got the component's position
        			break;
        		}
        		if(currComp instanceof _MXMLContract){
        			counter++;
        		}
        	}
        	
        	currMXMLComp.setMinorLevel(counter);
        	setPreMxmlIdentifiers(mxmlInstance, currMXMLComp);
    		
    	}else if(component instanceof com.googlecode.jsfFlex.component.ext.MXMLUIApplication){
    		//means that it is not of MXML component, so set the major and minor level to 0
    		currMXMLComp.setMajorLevel(0);
    		currMXMLComp.setMinorLevel(0);
    		setPreMxmlIdentifiers(null, currMXMLComp);
    		
    	}else{
    		throw new ComponentBuildException("Failed to meet the condition of either being a top component of " +
    												"MXMLUIApplication or having a parent as implementation of " +
    												"MXMLContract");
    	}
    	
    	setAbsolutePathToPreMxmlFile(mxmlContext.getCurrMxml(), currMXMLComp, mxmlContext.getPreMxmlPath());
    	
    }
	
	private static void setPreMxmlIdentifiers(_MXMLContract parentInstance, _MXMLContract currInstance){
		//TODO : implement this whole process better later
		StringBuffer parentPreMxmlIdentifier = new StringBuffer();
		StringBuffer preMxmlIdentifier = new StringBuffer();
		
		if(parentInstance != null){
			parentPreMxmlIdentifier.append(parentInstance.getPreMxmlIdentifier());
			
			preMxmlIdentifier.append(parentInstance.getPreMxmlIdentifier());
			preMxmlIdentifier.append(currInstance.getMajorLevel());
			preMxmlIdentifier.append(currInstance.getMinorLevel());
		}else{
			//currInstance is an instance of MXMLUIApplication
			preMxmlIdentifier.append(currInstance.getMajorLevel());
			preMxmlIdentifier.append(currInstance.getMinorLevel());
		}
		
		currInstance.setParentPreMxmlIdentifier(parentPreMxmlIdentifier.toString());
		currInstance.setPreMxmlIdentifier(preMxmlIdentifier.toString());
	}
	
	private static void setAbsolutePathToPreMxmlFile(String mxmlPackageName, _MXMLContract currInstance, String preMxmlPath){
		StringBuffer toReturn = new StringBuffer(preMxmlPath);
		toReturn.append(mxmlPackageName);
		toReturn.append("_");
		toReturn.append(currInstance.getPreMxmlIdentifier());
		toReturn.append(MXMLConstants.PRE_MXML_FILE_EXT);
		
		currInstance.setAbsolutePathToPreMxmlFile(toReturn.toString());
		
	}
	
}
