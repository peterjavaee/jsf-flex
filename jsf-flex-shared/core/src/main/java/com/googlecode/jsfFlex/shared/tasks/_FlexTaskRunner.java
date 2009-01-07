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
package com.googlecode.jsfFlex.shared.tasks;

import java.util.List;

import com.googlecode.jsfFlex.shared.adapter._MXMLApplicationContract;
import com.googlecode.jsfFlex.shared.adapter._MXMLContract;

/**
 * @author Ji Hoon Kim
 */
public interface _FlexTaskRunner extends _TaskRunner {
	
	void makeDirectory(String directoryToCreate);
	
	void deleteResources(String resourceToDelete, boolean isDirectory);
	
	void writeBodyContent(_MXMLContract componentMXML);
	
	void replaceTokenWithValue(String targetAbsolutePath, String valueToReplaceWith, String tokenReplace);
	
	void copyFile(String fileToCopy, String fileToCopyTo);
	
	void copyFileSet(String copyDir, String copyInclude, String copyExclude, String copyTo);
	
	void createMXML(String targetAbsolutePath, String copyTo);
	
	void createSwcSourceFiles(String swcPath, List systemSourceFiles, String jsfFlexMainSwcConfigFile, String webContextPath);
	
	void createSystemSWCFile(String sourcePath, String outPut, String flexSDKRootPath, String loadConfigFilePath);
	
	void createSWF(_MXMLApplicationContract componentMXML, String mxmlFile, String swfPath, String flexSDKRootPath);
	
	void createSwfSourceFiles(String swfBasePath, List systemSwfSourceFiles);
	
	void renameFile(String sourceFile, String destFile, boolean overWrite);
	
}
