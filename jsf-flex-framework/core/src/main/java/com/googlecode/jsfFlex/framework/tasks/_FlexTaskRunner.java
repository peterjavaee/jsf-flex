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
package com.googlecode.jsfFlex.framework.tasks;

import java.util.Map;

import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;
import com.googlecode.jsfFlex.shared.adapter._MXMLApplicationContract;
import com.googlecode.jsfFlex.shared.adapter._MXMLContract;

/**
 * @author Ji Hoon Kim
 */
public interface _FlexTaskRunner extends _TaskRunner {
	
	void addCreatePreMxmlTask(_MXMLContract comp, String mxmlInputTemplatePath, String templateContent);
	
	void addInsertComponentTemplateTask(_MXMLContract comp, String contentToken, String contentTemplate);
	
	void addMakeDirectoryTask(String directoryToCreate);
	
	void addReplaceTokenTask(_MXMLContract comp, Map replaceTextList);
	
	void deleteResources(String resourceToDelete, boolean isDirectory);
	
	void writeBodyContentTask(_MXMLContract componentMXML);
	
	void addReplaceTokenWithValueTask(_MXMLContract applicationInstance, String valueToReplaceWith, String tokenReplace) throws ComponentBuildException;
	
	void createMXML(_MXMLContract applicationInstance, String copyTo) throws ComponentBuildException;
	
	void createMxmlcSourceFiles(String _mxmlPath, String[] _systemSourceFiles) throws ComponentBuildException;
	
	void createSWF(_MXMLApplicationContract componentMXML, String mxmlFile, String swfPath, String flexSDKRootPath) throws ComponentBuildException;
	
	void createSwfSourceFiles(String _swfBasePath, String[] _systemSwfSourceFiles) throws ComponentBuildException;
	
	void createSystemSWCFile(String _mxmlPath) throws ComponentBuildException;
	
	void replaceChildSiblingWithPreMxmlIdentifier(_MXMLContract currInstance) throws ComponentBuildException;
	
}
