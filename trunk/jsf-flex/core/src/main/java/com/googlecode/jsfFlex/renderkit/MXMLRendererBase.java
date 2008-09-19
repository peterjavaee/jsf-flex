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
package com.googlecode.jsfFlex.renderkit;

import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.faces.render.Renderer;

import com.googlecode.jsfFlex.component.attributes._MXMLUIDataProviderAttribute;
import com.googlecode.jsfFlex.shared.adapter._MXMLContract;
import com.googlecode.jsfFlex.shared.beans.mxml.MXMLBeanWrapper;
import com.googlecode.jsfFlex.shared.beans.mxml._MXMLBean;
import com.googlecode.jsfFlex.shared.context.MxmlContext;
import com.googlecode.jsfFlex.shared.exception.ComponentBuildException;
import com.googlecode.jsfFlex.shared.util.MXMLConstants;

/**
 * @author Ji Hoon Kim
 */
public class MXMLRendererBase extends Renderer {
	
	private MXMLRendererBaseHelper _mxmlRendererBaseHelper;
	
	{
		_mxmlRendererBaseHelper = new MXMLRendererBaseHelper();
	}
	
	private static final Comparator _majorKeyComparator = new Comparator(){
		public int compare(Object obj1, Object obj2){
			_MXMLContract actObj1 = (_MXMLContract) obj1;
			_MXMLContract actObj2 = (_MXMLContract) obj2;
			double actObj1Double = Double.valueOf(actObj1.getPreMxmlIdentifier()).doubleValue();
			double actObj2Double = Double.valueOf(actObj2.getPreMxmlIdentifier()).doubleValue();
			return actObj1Double == actObj2Double ? 0 : actObj1Double < actObj2Double ? -1 : 1;
		}
	};
	
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		super.encodeBegin(context, component);
		
		UIComponent parent = component.getParent();
		
		if(parent == null){
    		//this should never happen
    		throw new NullPointerException("Component " + component.getClass().getName() + 
    											" lacks parent component");
    	}
		
		if(component instanceof _MXMLUIDataProviderAttribute){
			_mxmlRendererBaseHelper.processDataProviderCollection(component);
		}
		
		_mxmlRendererBaseHelper.createStructureForPreMxmlFiles(component);
		
	}
	
	private final class MXMLRendererBaseHelper{
		
		private final static String DATA_PROVIDER_BEAN_SUFFIX = "MxmlBean";
		private final static String DATA_PROVIDER_COLLECTION_ATTR = "dataProviderCollection";
		private final static String INVALID_DATA_PROVIDER_DATA_BINDING_FIELD_MESSAGE = "Only type of dataBinding allowed for dataProviderCollec field is of String or Collection";
		
		private MXMLRendererBaseHelper(){
			super();
		}
		
		private void processDataProviderCollection(UIComponent _currComponent){
			
			_MXMLUIDataProviderAttribute _dataProviderComponent = (_MXMLUIDataProviderAttribute) _currComponent;
			
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
		
		private void createStructureForPreMxmlFiles(UIComponent component) throws IOException {
			
			_MXMLContract mxmlUIComp = (_MXMLContract) component;
			MxmlContext mxmlContext = MxmlContext.getCurrentInstance();
			
			UIComponent parent = component.getParent();
			
			if(!(component instanceof com.googlecode.jsfFlex.component.ext.MXMLUIApplication) && mxmlUIComp.getComponentValues() != null){
		    	Map applicationIdValueMap = mxmlContext.getApplicationIdValueMap();
		    	applicationIdValueMap.put(component.getId(), mxmlUIComp.getComponentValues());
	    	}
			
			if(mxmlContext.isProductionEnv() || mxmlContext.isSimplySWF()){
				//do not need to create preMxml files
				return;
			}
			
			if(parent instanceof _MXMLContract && !(component instanceof com.googlecode.jsfFlex.component.ext.MXMLUIApplication)){
	    		_MXMLContract mxmlInstance = (_MXMLContract) parent;
	    		int tempInt = mxmlInstance.getMajorLevel();
	    		mxmlUIComp.setMajorLevel(++tempInt);
	    		
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
	        	
	        	mxmlUIComp.setMinorLevel(counter);
	        	setPreMxmlIdentifiers(mxmlInstance, mxmlUIComp);
	    		
	    	}else if(component instanceof com.googlecode.jsfFlex.component.ext.MXMLUIApplication){
	    		//means that it is not of MXML component, so set the major and minor level to 0
	    		mxmlUIComp.setMajorLevel(0);
	    		mxmlUIComp.setMinorLevel(0);
	    		setPreMxmlIdentifiers(null, mxmlUIComp);
	    		
	    	}else{
	    		throw new ComponentBuildException("Failed to meet the condition of either being a top component of " +
	    												"MXMLUIApplication or having a parent as implementation of " +
	    												"MXMLContract");
	    	}
	    	
	    	setAbsolutePathToPreMxmlFile(mxmlContext.getCurrMxml(), mxmlUIComp, mxmlContext.getPreMxmlPath());
			
			insertComponentToPreMxmlCompMap(component);
			
		}
		
		private void setPreMxmlIdentifiers(_MXMLContract parentInstance, _MXMLContract currInstance){
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
		
		private void setAbsolutePathToPreMxmlFile(String mxmlPackageName, _MXMLContract currInstance, String preMxmlPath){
			StringBuffer toReturn = new StringBuffer(preMxmlPath);
			toReturn.append(mxmlPackageName);
			toReturn.append("_");
			toReturn.append(currInstance.getPreMxmlIdentifier());
			toReturn.append(MXMLConstants.PRE_MXML_FILE_EXT);
			
			currInstance.setAbsolutePathToPreMxmlFile(toReturn.toString());
			
		}
		
		private void insertComponentToPreMxmlCompMap(UIComponent component) throws IOException {
			
			_MXMLContract mxmlUIComp = (_MXMLContract) component;
			MxmlContext mxmlContext = MxmlContext.getCurrentInstance();
			
			if(!(component instanceof com.googlecode.jsfFlex.component.ext.MXMLUIApplication)){
				/*
				 * Ignore the addition of MXMLUIApplication, because MXMLApplication is responsible
				 * for traversing through the Set and creating the mxml and swf files.
				 */
				Map preMxmlCompMap = mxmlContext.getPreMxmlCompMap();
				
				Integer majorKey = new Integer(mxmlUIComp.getMajorLevel());
				Object majorKeyEntry = preMxmlCompMap.get(majorKey);

				Set majorKeySet;
				if(majorKeyEntry != null){
					majorKeySet = (Set) majorKeyEntry;

				}else{
					
					majorKeySet = new TreeSet( _majorKeyComparator );
					preMxmlCompMap.put(majorKey, majorKeySet);

				}
				
				majorKeySet.add(mxmlUIComp);
				
			}
		}
		
	}
	
}
