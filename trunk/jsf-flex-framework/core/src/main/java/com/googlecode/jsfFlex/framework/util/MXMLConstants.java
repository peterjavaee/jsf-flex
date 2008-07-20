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
import java.util.LinkedList;
import java.util.List;
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
public class MXMLConstants {
	
	public static final String STRING_QUOTE = "\"";
	
	public static final String FLEX_SDK_ZIP = "flexSDK.zip";
	public static final String JSF_FLEX_COMMUNICATOR_JS = "jsfFlexCommunicator.js";
	
	public static final String PRE_MXML_FILE_EXT = ".pre_mxml";
	public static final String MXML_FILE_EXT = ".mxml";
	public static final String SWF_FILE_EXT = ".swf";
	public static final String XML_FILE_EXT = ".xml";
	public static final String MXMLCONSTANTS_XML = "mxmlConstants.xml";
	
	public static final String CHILD_REPLACE_TOKEN = "<!-- Child Component -->";
	public static final String SIBLING_REPLACE_TOKEN = "<!-- Sibling Component -->";
	
	public static final String CHILD_REPLACE_TOKEN_PREMXML_IDENTIFIER_PRE = "<!-- Child Component ";
	public static final String CHILD_REPLACE_TOKEN_PREMXML_IDENTIFIER_SUFF = " -->";
	public static final String SIBLING_REPLACE_TOKEN_PREMXML_IDENTIFIER_PRE = "<!-- Sibling Component ";
	public static final String SIBLING_REPLACE_TOKEN_PREMXML_IDENTIFIER_SUFF = " -->";
	
	public static final String TAG_BODY_CONTENT_ATTR = "tagBodyContent";
	public static final String TAG_BODY_CONTENT_TOKEN = "${tagBodyContent}";
	
	public static final String MXML_DIRECTORY_NAME = "mxml";
	public static final String SWF_DIRECTORY_NAME = "swf";
	public static final String PREMXML_DIRECTORY_NAME = "preMxml";
	public static final String FLEX_SDK_DIRECTORY_NAME = "flexSDK";
	
	public static final boolean WINDOWS_SYSTEM;
	
	public static final String CLASS_ID;
	public static final String CODE_BASE;
	public static final String PLUGINS_PAGE;
	
	private static final List _mxmlcSourceFiles;
	private static final List _swfSourceFiles;
	
	private static Map _tempParseMap;
	
	private MXMLConstants(){
		super();
	}
	
	static{
		
		WINDOWS_SYSTEM = (System.getProperty("line.separator").equals("\r\n"));
		_tempParseMap = new HashMap();
		
		_mxmlcSourceFiles = new LinkedList();
		_swfSourceFiles = new LinkedList();
		
		try{
			parseSetProperties();
		}catch(Exception rendererListException){
			throw new ComponentBuildException("Failure in parsing of " + MXMLCONSTANTS_XML, rendererListException);
		}
		
		CLASS_ID = (String) _tempParseMap.get("CLASS_ID");
		CODE_BASE = (String) _tempParseMap.get("CODE_BASE");
		PLUGINS_PAGE = (String) _tempParseMap.get("PLUGINS_PAGE");
		
		_tempParseMap = null;
	}
	
	private static void parseSetProperties() throws IOException, ParserConfigurationException, SAXException{
		
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		parser.parse(MXMLConstants.class.getResourceAsStream(MXMLCONSTANTS_XML), new DefaultHandler(){
			
			private boolean settings = true;
			private boolean windows = false;
			private boolean non_windows = false;
			private boolean system_independent = false;
			
			private boolean swf_html_attribute = false;
			private boolean class_id = false;
			private boolean code_base = false;
			private boolean plugins_page = false;
			private boolean mxml_source_files = false;
			private boolean swf_source_files = false;
			private boolean source_file = false;
			
			private StringBuffer nodeValue;
			
			public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
				super.startElement(uri, localName, qName, attributes);
				
				if(qName.equals("settings")){
					//Container so return after set
					settings = true;
					return;
				}else if(qName.equals("windows")){
					settings = false;
					windows = true;
				}else if(qName.equals("non-windows")){
					windows = false;
					non_windows = true;
				}else if(qName.equals("system-independent")){
					non_windows = false;
					system_independent = true;
				}else if(qName.equals("swf-html-attibute")){
					swf_html_attribute = true;
				}else if(qName.equals("class-id")){
					class_id = true;
				}else if(qName.equals("code-base")){
					code_base = true;
				}else if(qName.equals("plugins-page")){
					plugins_page = true;
				}else if(qName.equals("mxml-source-files")){
					mxml_source_files = true;
				}else if(qName.equals("swf-source-files")){
					swf_source_files = true;
				}else if(qName.equals("source-file")){
					source_file = true;
				}
				
				nodeValue = new StringBuffer();
			}
			
			
			public void endElement(String uri, String localName, String qName) throws SAXException {
				super.endElement(uri, localName, qName);
				
				String currValue = null;
				if(nodeValue != null){
					currValue = nodeValue.toString().trim();
				}
				
				if(code_base){
					_tempParseMap.put("CODE_BASE", currValue);
					code_base = false;
				}else if(class_id){
					_tempParseMap.put("CLASS_ID", currValue);
					class_id = false;
				}else if(plugins_page){
					_tempParseMap.put("PLUGINS_PAGE", currValue);
					plugins_page = false;
				}else if(swf_html_attribute){
					swf_html_attribute = false;
				}else if(source_file){
					if(mxml_source_files){
						_mxmlcSourceFiles.add(currValue);
					}else if(swf_source_files){
						_swfSourceFiles.add(currValue);
					}
					source_file = false;
				}else if(mxml_source_files){
					mxml_source_files = false;
				}else if(swf_source_files){
					swf_source_files = false;
				}else if(system_independent){
					system_independent = false;
				}
			}
			
			public void characters(char[] ch, int start, int length) throws SAXException {
				super.characters(ch, start, length);
				if(settings){
					return;
				}
				nodeValue.append(new String(ch, start, length));
			}
			
		});
		
	}
	
	public static String[] getMxmlcSourceFiles(){
		/*
		 * To disallow removing elements within mxmlcSourceFiles 
		 */
		return (String []) _mxmlcSourceFiles.toArray(new String[0]);
	}
	
	public static void addMxmlcSourceFiles(String sourceToAdd){
		if(sourceToAdd != null){
			_mxmlcSourceFiles.add(sourceToAdd);
		}
	}
	
	public static String[] getSwfSourceFiles(){
		/*
		 * To disallow removing elements within swfSourceFiles 
		 */
		return (String[]) _swfSourceFiles.toArray(new String[0]);
	}
	
	public static void addSwfSourceFiles(String sourceToAdd){
		if(sourceToAdd != null){
			_swfSourceFiles.add(sourceToAdd);
		}
	}
	
}
