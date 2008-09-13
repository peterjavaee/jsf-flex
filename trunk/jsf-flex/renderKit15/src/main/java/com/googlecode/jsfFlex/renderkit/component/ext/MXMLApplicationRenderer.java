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
package com.googlecode.jsfFlex.renderkit.component.ext;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFRenderer;
import org.apache.myfaces.shared_tomahawk.renderkit.html.HTML;

import com.googlecode.jsfFlex.renderkit.annotation.JsfFlexAttribute;
import com.googlecode.jsfFlex.renderkit.annotation.JsfFlexAttributeProperties;
import com.googlecode.jsfFlex.renderkit.component.MXMLContainerTemplateRenderer;
import com.googlecode.jsfFlex.renderkit.mxml.MXMLResponseWriterImpl;
import com.googlecode.jsfFlex.shared.adapter._MXMLApplicationContract;
import com.googlecode.jsfFlex.shared.adapter._MXMLContract;
import com.googlecode.jsfFlex.shared.beans.TokenValue;
import com.googlecode.jsfFlex.shared.context.MxmlContext;
import com.googlecode.jsfFlex.shared.exception.ComponentBuildException;
import com.googlecode.jsfFlex.shared.util.MXMLConstants;
import com.googlecode.jsfFlex.util.MXMLJsfUtil;

/**
 * Aside from its normal task of mapping the field to the Set and creating the preMxml file, MXMLApplicationRenderer has<br>
 * an added responsibility of :<br>
 * <ul>
 *     <li> merging preMxml file into a single preMxml file.
 *     <li> creating an application MXML file.
 *     <li> extracting the flexSDK zip file.
 *     <li> creating necessary SWC source files.
 *     <li> creating system SWC file.
 *     <li> creating necessary application SWF source files.
 *     <li> and creating application SWF file.
 * </ul>
 * Other than merging of the preMxml file into a single preMxml file, all other tasks are performed by invoking processCreateSwf.<br>
 * 
 * @author Ji Hoon Kim
 */
@JSFRenderer(
		renderKitId="MXML_BASIC",
		family="javax.faces.MXMLApplication",
		type="com.googlecode.jsfFlex.MXMLApplication"
)
@JsfFlexAttributeProperties(
		componentName="Application",
		componentNodeAttributes={},

		jsfFlexAttributes={
				@JsfFlexAttribute(attribute="controlBar", byMethod=false),
				@JsfFlexAttribute(attribute="frameRate", byMethod=false),
				@JsfFlexAttribute(attribute="layout", byMethod=false),
				@JsfFlexAttribute(attribute="pageTitle", byMethod=false),
				@JsfFlexAttribute(attribute="preloader", byMethod=false),
				@JsfFlexAttribute(attribute="resetHistory", byMethod=false),
				@JsfFlexAttribute(attribute="scriptRecursionLimit", byMethod=false),
				@JsfFlexAttribute(attribute="scriptTimeLimit", byMethod=false),
				@JsfFlexAttribute(attribute="usePreloader", byMethod=false),
				@JsfFlexAttribute(attribute="viewSourceURL", byMethod=false),
				@JsfFlexAttribute(attribute="backgroundGradientAlphas", byMethod=false),
				@JsfFlexAttribute(attribute="backgroundGradientColors", byMethod=false),
				@JsfFlexAttribute(attribute="horizontalAlign", byMethod=false),
				@JsfFlexAttribute(attribute="horizontalGap", byMethod=false),
				@JsfFlexAttribute(attribute="modalTransparency", byMethod=false),
				@JsfFlexAttribute(attribute="modalTransparencyBlur", byMethod=false),
				@JsfFlexAttribute(attribute="modalTransparencyColor", byMethod=false),
				@JsfFlexAttribute(attribute="modalTransparencyDuration", byMethod=false),
				@JsfFlexAttribute(attribute="verticalAlign", byMethod=false),
				@JsfFlexAttribute(attribute="verticalGap", byMethod=false),
				@JsfFlexAttribute(attribute="applicationComplete", byMethod=false),
				@JsfFlexAttribute(attribute="error", byMethod=false)
		}
)
public final class MXMLApplicationRenderer extends MXMLContainerTemplateRenderer {
	
	private final static Log _log = LogFactory.getLog(MXMLApplicationRenderer.class);
	
	private static final String MXML_OBJECT_SET_TOKEN = "${mxmlObjectBean}";
	private static final String MXML_APPLICATION_BODY_TEMPLATE;
	private static final String MX_KEY = "xmlns:mx";
	
	static{
		//TODO : find a better method to implement the below tasks
		String packageName = MXMLApplicationRenderer.class.getPackage().getName();
		packageName = packageName.replace('.', '/');
		MXML_APPLICATION_BODY_TEMPLATE = packageName + "/templates/MXMLApplicationBody.template";
	}
	
	private MXMLApplicationHTMLRenderer _mxmlApplicationHtmlRenderer;
	
	{
		_mxmlApplicationHtmlRenderer = new MXMLApplicationHTMLRenderer();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public void encodeBegin(FacesContext context, UIComponent componentObj) throws IOException {
		super.encodeBegin(context, componentObj);
		
		MXMLResponseWriterImpl writer = (MXMLResponseWriterImpl) context.getResponseWriter();
		_MXMLApplicationContract componentMXML = (_MXMLApplicationContract) componentObj;
		
		/*
		 * special case for MXMLApplication to filter out attribute "id"
		 * In Flex, id attribute is not allowed on the root tag of a component
		 */
		
		componentMXML.getAnnotationDocletParserInstance().getTokenValueSet().remove(new TokenValue("id", null));
		writer.mapFields(MXMLApplicationRenderer.class, componentObj, null);
		
		/*
		 * HACK
		 * Because of the colon, the detection of qdox is giving issues. So for the time
		 * being until a better solution is found, manually pull and push the info.
		 */
		componentMXML.getAnnotationDocletParserInstance().getTokenValueSet().add(new TokenValue(MX_KEY, componentMXML.getAttributes().get(MX_KEY).toString()));
		
		String _bodyContent = writer.getComponentTemplate(MXMLApplicationRenderer.class.getClassLoader(), 
									MXML_APPLICATION_BODY_TEMPLATE);
		
		writer.createPreMxml(writer, componentMXML, MXMLApplicationRenderer.class.getAnnotation(JsfFlexAttributeProperties.class).componentName(), 
				_bodyContent);
		
	}
	
	@Override
	public void encodeEnd(FacesContext context, UIComponent componentObj) throws IOException {
		super.encodeEnd(context, componentObj);
		
		_MXMLApplicationContract componentMXML = (_MXMLApplicationContract) componentObj;
		MXMLResponseWriterImpl writer = (MXMLResponseWriterImpl) context.getResponseWriter();
		
		String mxmlObjectBeanContent = writer.generateMXMLObjectBeanContent();
		writer.replaceTokenWithValue(componentMXML, mxmlObjectBeanContent, MXML_OBJECT_SET_TOKEN);
		
		/*
		 * Now must go through the Set and place the component's within the main preMxml file
		 * 		DataStructure is as follows within the Session Map :
		 * 			Key being the current mxmlPackage_count and value being a HashMap implementation that contains =>
		 * 				Key being the major number and value being a TreeSet with absolutePathToPreMxmlFile
		 * Afterwards will create it as a MXML file and will create the SWF file 
		 */
		MxmlContext mxmlContext = MxmlContext.getCurrentInstance();
		String mxmlFile = mxmlContext.getMxmlPath() + mxmlContext.getCurrMxml() + MXMLConstants.MXML_FILE_EXT;;
		
		//check if simplySWF boolean flag is set and if so, create the SWF file and exit
		if(mxmlContext.isSimplySWF()){
			if(!new File(mxmlContext.getFlexSDKPath()).exists()){
				writer.makeDirectory(mxmlContext.getFlexSDKPath());
				writer.unZipArchiveRelative(MXMLConstants.FLEX_SDK_ZIP, mxmlContext.getFlexSDKPath());
			}
			writer.createSWF(componentMXML, mxmlFile, mxmlContext.getSwfPath(), mxmlContext.getFlexSDKPath());
		}else{
		
			Map _preMxmlMap = mxmlContext.getPreMxmlCompMap();
			Integer currMajor;
			
			Set siblingSet;
			_MXMLContract currComp;
			if(_preMxmlMap.keySet().size() > 0){
				
				//Application must be a top component with others as children component
				for(Iterator majorIterator = _preMxmlMap.keySet().iterator(); majorIterator.hasNext();){
					
					currMajor = (Integer) majorIterator.next();
					siblingSet = (Set) _preMxmlMap.get(currMajor);
					
					for(Iterator siblingIterator = siblingSet.iterator(); siblingIterator.hasNext();){
					
						currComp = (_MXMLContract) siblingIterator.next();
						
						if(currComp.getMinorLevel() == 0){
							writer.replaceTokenWithValue((_MXMLContract) componentMXML, writer.readFileContent(currComp.getAbsolutePathToPreMxmlFile()), 
									writer.childReplaceTokenWithPreMxmlIdentifier(currComp));
							
							_log.debug("Replacing token with value as a child for " + currComp.getAbsolutePathToPreMxmlFile());
						}else{
							writer.replaceTokenWithValue((_MXMLContract) componentMXML, writer.readFileContent(currComp.getAbsolutePathToPreMxmlFile()), 
									writer.siblingReplaceTokenWithPreMxmlIdentifier(currComp));
							_log.debug("Replacing token with value as a sibling for " + currComp.getAbsolutePathToPreMxmlFile());
						}
						
					}
					
				}
				
				writer.processCreateSwf(componentMXML, mxmlFile);
				
			}
		
		}
		
		_mxmlApplicationHtmlRenderer.renderHtmlContent(context, componentObj);
		
	}
	
	private class MXMLApplicationHTMLRenderer {
		
		private static final String APP_ID = "appId";
		private static final String ARRAY_OF_IDS = "arrayOfIds";
		private static final String ID = "id";
		private static final String INIT_VALUE = "initValues";
		private static final String ATTRIBUTE = "attribute";
		private static final String VALUE = "value";
		
		private static final String FLASH_APPS_NS = "com.googlecode.jsfFlex.flashApps";
		private static final String PAGE_LOAD_NS = "com.googlecode.jsfFlex.communication.pageLoad";
		
		private void renderHtmlContent(FacesContext context, UIComponent component) throws IOException {
			
			MxmlContext mxmlContext = MxmlContext.getCurrentInstance();
			com.googlecode.jsfFlex.component.ext.MXMLUIApplication appComponent = 
												(com.googlecode.jsfFlex.component.ext.MXMLUIApplication) component;
			
			Map preMxmlCompMap = mxmlContext.getPreMxmlCompMap();
			preMxmlCompMap.clear();
			
			ResponseWriter writer = context.getResponseWriter();
			
			writer.startElement(HTML.SCRIPT_ELEM, component);
			writer.writeAttribute(HTML.SCRIPT_TYPE_ATTR, HTML.SCRIPT_TYPE_TEXT_JAVASCRIPT, null);
			
			//print out the JSON objects here
			StringBuilder toWrite = new StringBuilder();
			
			toWrite.append(FLASH_APPS_NS);
			toWrite.append(".push(");
			
			try{
				toWrite.append(getComponentIdValues());
			}catch(ComponentBuildException _componentBuildException){
				throw new IOException(_componentBuildException.getMessage());
			}
			
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
	
		private String getComponentIdValues() throws ComponentBuildException {
			
			StringBuilder toReturn = new StringBuilder();
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
				
				String currItem;
				
				Object initValue;
				Map initValueMap;
				String attribute;
				Object value;
				
				for(Iterator iterate = applicationIdValueMap.keySet().iterator(); iterate.hasNext();){
					
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
						for(Iterator iterateInitValue = initValueMap.keySet().iterator(); iterateInitValue.hasNext();){
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
	
}