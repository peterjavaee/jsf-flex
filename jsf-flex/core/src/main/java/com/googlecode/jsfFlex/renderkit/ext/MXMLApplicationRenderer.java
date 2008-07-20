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
package com.googlecode.jsfFlex.renderkit.ext;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.apache.myfaces.shared_tomahawk.renderkit.html.HTML;

import com.googlecode.jsfFlex.framework.context.MxmlContext;
import com.googlecode.jsfFlex.framework.util.MXMLConstants;
import com.googlecode.jsfFlex.renderkit.MXMLRendererBase;
import com.googlecode.jsfFlex.util.MXMLJsfUtil;

/**
 * @JSFRenderer
 *   renderKitId = "HTML_BASIC" 
 *   family      = "javax.faces.MXMLApplication"
 *   type        = "com.googlecode.jsfFlex.MXMLApplication"  
 * 
 * @author Ji Hoon Kim
 */
public class MXMLApplicationRenderer extends MXMLRendererBase {
	
	private static final String APP_ID = "appId";
	private static final String ARRAY_OF_IDS = "arrayOfIds";
	private static final String ID = "id";
	private static final String INIT_VALUE = "initValues";
	private static final String ATTRIBUTE = "attribute";
	private static final String VALUE = "value";
	
	private static final String FLASH_APPS_NS = "com.googlecode.jsfFlex.flashApps";
	private static final String PAGE_LOAD_NS = "com.googlecode.jsfFlex.communication.pageLoad";
	
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		super.encodeEnd(context, component);
		
		MxmlContext mxmlContext = MxmlContext.getCurrentInstance();
		com.googlecode.jsfFlex.component.ext.MXMLUIApplication appComponent = 
											(com.googlecode.jsfFlex.component.ext.MXMLUIApplication) component;
		
		Map preMxmlCompMap = mxmlContext.getPreMxmlCompMap();
		preMxmlCompMap.clear();
		
		ResponseWriter writer = context.getResponseWriter();
		
		writer.startElement(HTML.SCRIPT_ELEM, component);
		writer.writeAttribute(HTML.SCRIPT_TYPE_ATTR, HTML.SCRIPT_TYPE_TEXT_JAVASCRIPT, null);
		
		//print out the JSON objects here
		StringBuffer toWrite = new StringBuffer();
		
		toWrite.append(FLASH_APPS_NS);
		toWrite.append(".push(");
		toWrite.append(getComponentIdValues());
		toWrite.append(");");
		
		toWrite.append("dojo.addOnLoad(");
		toWrite.append(PAGE_LOAD_NS);
		toWrite.append(");");
		writer.write(toWrite.toString());
		writer.endElement(HTML.SCRIPT_ELEM);
		
		writeHTMLSWF(writer, appComponent, mxmlContext.getSwfWebPath());
		
	}
	
	private void writeHTMLSWF(ResponseWriter writer, com.googlecode.jsfFlex.component.ext.MXMLUIApplication appComponent, 
										String swfPath) throws IOException{
		Object heightO = appComponent.getAttributes().get(HTML.HEIGHT_ATTR);
		Object widthO = appComponent.getAttributes().get(HTML.WIDTH_ATTR);
		
		String height = (heightO == null) ? "100%" : (String) heightO;
		String width = (widthO == null) ? "100%" : (String) widthO;
		String swfFile = swfPath + appComponent.getMxmlPackageName() + MXMLConstants.SWF_FILE_EXT;
		
		writer.startElement("object", appComponent);
		
		writer.writeAttribute(HTML.ID_ATTR, appComponent.getMxmlPackageName(), null);
		writer.writeAttribute("classid", MXMLConstants.CLASS_ID, null);
		writer.writeAttribute("codebase", MXMLConstants.CODE_BASE, null);
		writer.writeAttribute(HTML.HEIGHT_ATTR, height, null);
		writer.writeAttribute(HTML.WIDTH_ATTR, width, null);
		
		writer.startElement("param", appComponent);
		writer.writeAttribute(HTML.NAME_ATTR, "src", null);
		writer.writeAttribute(HTML.VALUE_ATTR, swfFile, null);
		writer.endElement("param");
		
		writer.startElement("param", appComponent);
		writer.writeAttribute(HTML.NAME_ATTR, "allowScriptAccess", null);
		writer.writeAttribute(HTML.VALUE_ATTR, "sameDomain", null);
		writer.endElement("param");
		
		writer.startElement("embed", appComponent);
		writer.writeAttribute(HTML.NAME_ATTR, appComponent.getMxmlPackageName(), null);
		writer.writeAttribute("allowScriptAccess", "sameDomain", null);
		writer.writeAttribute("pluginspage", MXMLConstants.PLUGINS_PAGE, null);
		writer.writeAttribute(HTML.SRC_ATTR, swfFile, null);
		writer.writeAttribute(HTML.HEIGHT_ATTR, height, null);
		writer.writeAttribute(HTML.WIDTH_ATTR, width, null);
		writer.endElement("embed");
		
		writer.endElement("object");
		
	}
	
	private String getComponentIdValues(){
		StringBuffer toReturn = new StringBuffer();
		MxmlContext mxmlContext = MxmlContext.getCurrentInstance();
		Map applicationIdValueMap = mxmlContext.getApplicationIdValueMap();
		
		if(applicationIdValueMap.size() > 0){
			toReturn.append("{");
			toReturn.append(APP_ID);
			toReturn.append(": ");
			toReturn.append(MXMLConstants.STRING_QUOTE);
			toReturn.append(mxmlContext.getCurrMxml());
			toReturn.append(MXMLConstants.STRING_QUOTE);
			toReturn.append(", ");
			toReturn.append(ARRAY_OF_IDS);
			toReturn.append(": [");
			
			Iterator iterate = applicationIdValueMap.keySet().iterator();
			String currItem;
			
			Object initValue;
			Map initValueMap;
			Iterator iterateInitValue;
			String attribute;
			Object value;
			
			while(iterate.hasNext()){
				
				currItem = (String) iterate.next();
				
				toReturn.append("{");
				toReturn.append(ID);
				toReturn.append(": ");
				toReturn.append(MXMLConstants.STRING_QUOTE);
				toReturn.append(currItem);
				toReturn.append(MXMLConstants.STRING_QUOTE);
				toReturn.append(", ");
				toReturn.append(INIT_VALUE);
				toReturn.append(": ");
				
				if((initValue = applicationIdValueMap.get(currItem)) != null){
					toReturn.append("[ ");
					
					initValueMap = (Map) initValue;
					iterateInitValue = initValueMap.keySet().iterator();
					while(iterateInitValue.hasNext()){
						attribute = (String) iterateInitValue.next();
						value = initValueMap.get(attribute);
						
						toReturn.append("{");
						toReturn.append(ATTRIBUTE);
						toReturn.append(": ");
						toReturn.append(MXMLConstants.STRING_QUOTE);
						toReturn.append(attribute);
						toReturn.append(MXMLConstants.STRING_QUOTE);
						toReturn.append(", ");
						
						toReturn.append(VALUE);
						toReturn.append(": ");
						
						if(value instanceof String){
							toReturn.append(MXMLConstants.STRING_QUOTE);
							toReturn.append(MXMLJsfUtil.escapeCharacters((String) value));
							toReturn.append(MXMLConstants.STRING_QUOTE);
						}else{
							toReturn.append(value);
						}
						
						toReturn.append("}");
						
						if(iterateInitValue.hasNext()){
							toReturn.append(", ");
						}
					}
					
					toReturn.append(" ]");
				}else{
					toReturn.append("null");
				}
				
				toReturn.append("}");
				if(iterate.hasNext()){
					toReturn.append(", ");
				}
			}
			toReturn.append("]}");
		}
		return toReturn.toString();
	}
	
}
