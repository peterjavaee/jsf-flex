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
package com.googlecode.jsfFlex.framework.component;

import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;
import com.googlecode.jsfFlex.shared.adapter._MXMLContract;

/**
 * @author Ji Hoon Kim
 */
public class MXMLTileTemplate extends MXMLContainerTemplate {
	
	private static final String MXML_TILE_TEMPLATE_CONTENT_TOKEN = "&tile;";
	private static final String MXML_TILE_TEMPLATE_TEMPLATE;
	private static final String MXML_TILE_TEMPLATE_REPLACE_MAPPING;
	
	static{
		//TODO : find a better method to implement the below tasks
		String packageName = MXMLTileTemplate.class.getPackage().getName();
		packageName = packageName.replace('.', '/');
		MXML_TILE_TEMPLATE_REPLACE_MAPPING = packageName + "/replaceMapping/MXMLTileTemplateReplaceMapping.xml";
		MXML_TILE_TEMPLATE_TEMPLATE = packageName + "/templates/MXMLTileTemplate.template";
	}
	
	public MXMLTileTemplate(){
		super();
	}

	public void buildComponentBegin(Object componentObj) throws ComponentBuildException {
		super.buildComponentBegin(componentObj);
		mapFields(componentObj, MXML_TILE_TEMPLATE_REPLACE_MAPPING);
		
	}
	
	public void buildComponentInterlude(Object componentObj) throws ComponentBuildException{
		//always replace the token of the subclass prior to invoking the super's
		_MXMLContract componentMXML = (_MXMLContract) componentObj;
		addInsertComponentTemplateTask(componentMXML, MXML_TILE_TEMPLATE_CONTENT_TOKEN, 
											getComponentTemplate(MXML_TILE_TEMPLATE_TEMPLATE));
		super.buildComponentInterlude(componentObj);
		
	}

}
