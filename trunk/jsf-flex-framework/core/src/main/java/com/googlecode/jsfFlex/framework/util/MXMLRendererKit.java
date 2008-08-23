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
package com.googlecode.jsfFlex.framework.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;

/**
 * @author Ji Hoon Kim
 */
public class MXMLRendererKit {
	
	private final static String RENDERER_KIT_XML = "mxmlRenderKit.xml";
	
	private final static Map _rendererKit;
	
	private MXMLRendererKit(){
		super();
	}
	
	static{
		
		_rendererKit = new HashMap();
		try{
			parseSetProperties();
		}catch(Exception rendererListException){
			throw new ComponentBuildException("Failure in parsing of " + RENDERER_KIT_XML, rendererListException);
		}
	}
	
	public static String getRendererClass(String componentName, String rendererName){
		MXMLComponent comp = (MXMLComponent) _rendererKit.get(componentName);
		Object toReturn = comp.getMxmlRenderer().get(rendererName);
		return (toReturn != null) ? (String) toReturn : null;
	}
	
	private static void parseSetProperties() throws IOException, ParserConfigurationException, SAXException{
		
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		parser.parse(MXMLRendererKit.class.getResourceAsStream(RENDERER_KIT_XML), new DefaultHandler(){
			
			private boolean render_kit = true;
			private boolean renderer = false;
			private boolean component_family = false;
			private boolean renderer_list = false;
			private boolean renderer_info = false;
			private boolean renderer_name = false;
			private boolean renderer_class = false;
			
			private MXMLComponent currComponent;
			private String rendererNameValue;
			private StringBuffer nodeValue;
			
			public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
				super.startElement(uri, localName, qName, attributes);
				
				if(qName.trim().equals("render-kit")){
					//Container so return after set
					render_kit = true;
					return;
				}else if(qName.trim().equals("renderer")){
					render_kit = false;
				}else if(qName.trim().equals("component-family")){
					component_family = true;
				}else if(qName.trim().equals("renderer-list")){
					renderer_list = true;
				}else if(qName.trim().equals("renderer-info")){
					renderer_info = true;
				}else if(qName.trim().equals("renderer-name")){
					renderer_name = true;
				}else if(qName.trim().equals("renderer-class")){
					renderer_class = true;
				}
				
				nodeValue = new StringBuffer();
			}
			
			public void endElement(String uri, String localName, String qName) throws SAXException {
				super.endElement(uri, localName, qName);
				
				String currValue = null;
				if(nodeValue != null){
					currValue = nodeValue.toString().trim();
				}
				
				if(component_family){
					//there should be a single entry for each component-family, thought to implement in HashSet, but waste to do so
					currComponent = new MXMLComponent();
					MXMLRendererKit._rendererKit.put(currValue, currComponent);
					component_family = false;
				}else if(renderer_name){
					rendererNameValue = currValue;
					renderer_name = false;
				}else if(renderer_class){
					currComponent.getMxmlRenderer().put(rendererNameValue, currValue);
					renderer_class = false;
				}else if(renderer_list){
					renderer_list = false;
				}else if(renderer){
					renderer = false;
				}else if(renderer_info){
					renderer_info = false;
				}
				
			}
			
			public void characters(char[] ch, int start, int length) throws SAXException {
				super.characters(ch, start, length);
				if(render_kit){
					return;
				}
				nodeValue.append(new String(ch, start, length));
			}
			
		});
		
	}
	
	private static class MXMLComponent{
		//in the componentList HashMap, the key will be a jsfComponent name and values would be possible MXML renderers
		private Map _mxmlRenderer;
		
		private MXMLComponent(){
			super();
			_mxmlRenderer = new HashMap();
		}
		
		private Map getMxmlRenderer() {
			return _mxmlRenderer;
		}
		
	}
		
}
