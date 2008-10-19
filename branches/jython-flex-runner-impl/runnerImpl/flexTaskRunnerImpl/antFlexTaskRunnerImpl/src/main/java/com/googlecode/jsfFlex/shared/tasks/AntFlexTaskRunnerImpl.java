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

import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.googlecode.jsfFlex.shared.adapter._MXMLApplicationContract;
import com.googlecode.jsfFlex.shared.adapter._MXMLContract;
import com.googlecode.jsfFlex.shared.context.MxmlContext;
import com.googlecode.jsfFlex.shared.tasks.task.ant.DeleteTask;
import com.googlecode.jsfFlex.shared.tasks.task.ant.EchoTask;
import com.googlecode.jsfFlex.shared.tasks.task.ant.FileCopyTask;
import com.googlecode.jsfFlex.shared.tasks.task.ant.MXMLCTask;
import com.googlecode.jsfFlex.shared.tasks.task.ant.MkdirTask;
import com.googlecode.jsfFlex.shared.tasks.task.ant.RenameTask;
import com.googlecode.jsfFlex.shared.tasks.task.ant.ReplaceTextTask;
import com.googlecode.jsfFlex.shared.tasks.task.ant.SWCTask;
import com.googlecode.jsfFlex.shared.util.MXMLConstants;

/**
 * An implementation of _FlexTaskRunner using ANT.<br>
 * 
 * @author Ji Hoon Kim
 */
final class AntFlexTaskRunnerImpl extends TaskRunnerImpl implements _FlexTaskRunner {
	
	private final static Log _log = LogFactory.getLog(AntFlexTaskRunnerImpl.class);
	
	AntFlexTaskRunnerImpl(){
		super();
	}
	
	public void copyFile(String fileToCopy, String fileToCopyTo) {
		FileCopyTask fileCopier = new FileCopyTask(fileToCopy, fileToCopyTo);
		addTask(fileCopier);
	}
	
	public void copyFileSet(String copyDir, String copyInclude, String copyExclude, String copyTo) {
		List copyIncludeList = copyInclude == null ? new LinkedList() : Arrays.asList(copyInclude.split(" "));
		List copyExcludeList = copyExclude == null ? new LinkedList() : Arrays.asList(copyExclude.split(" "));
		FileCopyTask fileCopier = new FileCopyTask(copyDir, copyIncludeList, copyExcludeList, copyTo);
		addTask(fileCopier);
	}
	
	public void createMXML(_MXMLContract applicationInstance, String copyTo) {
		//TODO : Implement this better later
		ReplaceTextTask removeEmptySpace = new ReplaceTextTask(applicationInstance.getAbsolutePathToPreMxmlFile());
		removeEmptySpace.replaceRegExp(true);
		removeEmptySpace.regMatch(ReplaceTextTask.CLEAN_REG_EXP_MATCH);
		removeEmptySpace.regReplace(ReplaceTextTask.CLEAN_REG_EXP_REPLACE_WITH);
		
		addTask(removeEmptySpace);
		
		String copyFrom = applicationInstance.getAbsolutePathToPreMxmlFile();
		
		copyFile(copyFrom, copyTo);
	}
	
	public void createSWF(_MXMLApplicationContract componentMXML, String mxmlFile, String swfPath, String flexSDKRootPath) {
		MXMLCTask swfCreator = new MXMLCTask(mxmlFile, swfPath, componentMXML, flexSDKRootPath);
		addTask(swfCreator);
	}
	
	public void createSwcSourceFiles(String _swcPath, List _systemSourceFiles, String jsfFlexMainSwcConfigFile) {
		//Echo the sourceFiles to the SWC path
		
		/*
		 * TODO : implement it better later
		 * 	Figure out a method to not create an EchoTask per _systemSourceFiles entry
		 * 	and possibly look into implementing it in an another method
		 */
		for(Iterator _systemSourceFilesIterator = _systemSourceFiles.iterator(); _systemSourceFilesIterator.hasNext();){
			String _currSystemSource = (String) _systemSourceFilesIterator.next();
			String[] currSplit = _currSystemSource.split("/");
			StringBuffer _path = new StringBuffer();
			
			/*
			 * This is a pure HACK, implement it better later
			 * The path of ActionScript files must be of com/googlecode/jsfFlex/util/shared/actionScript
			 */
			String _pathToFile = _currSystemSource.substring(_currSystemSource.indexOf("actionScript") + 13);
			if(_pathToFile == null || _pathToFile.length() == 0){
				_log.debug("The source file [" + _currSystemSource + "] is null or the length is zero");
				continue;
			}
			//remove the last element [name of file]
			_pathToFile = _pathToFile.substring(0, _pathToFile.lastIndexOf("/"));
			
			for(Iterator _fileSeparator = Arrays.asList(_pathToFile.split("/")).iterator(); _fileSeparator.hasNext();){
				_path.append(_fileSeparator.next().toString());
				_path.append(File.separatorChar);
			}
			makeDirectory(_swcPath + _path.toString());
			String _fileName = _swcPath + _path.toString() + currSplit[currSplit.length-1];
			EchoTask curr = new EchoTask(getFileManipulatorTaskRunner().getComponentTemplate(getClass().getClassLoader(), _currSystemSource), _fileName); 
			addTask(curr);
		}
		
		//now flush out the swc config file
		String _jsfFlexMainSwcConfigFileName = _swcPath + jsfFlexMainSwcConfigFile.substring(jsfFlexMainSwcConfigFile.lastIndexOf("/") + 1);
		EchoTask curr = new EchoTask(getFileManipulatorTaskRunner().getComponentTemplate(getClass().getClassLoader(), jsfFlexMainSwcConfigFile), _jsfFlexMainSwcConfigFileName); 
		addTask(curr);
		
	}
	
	public void createSwfSourceFiles(String _swfBasePath, List _systemSwfSourceFiles) {
		
		MkdirTask swfBasePathDirCreator = new MkdirTask(_swfBasePath);
		addTask(swfBasePathDirCreator);
		
		//Echo the swf sourceFiles to the swfBasepath
		
		/*
		 * TODO : implement it better later
		 * 	Figure out a method to not create an EchoTask per _systemSourceFiles entry
		 * 	and possibly look into implementing it in an another method
		 */
		for(Iterator _systemSwfSourceFilesIterator = _systemSwfSourceFiles.iterator(); _systemSwfSourceFilesIterator.hasNext();){
			String _currSystemSwfSourceFile = (String) _systemSwfSourceFilesIterator.next();
			String[] currSplit = _currSystemSwfSourceFile.split("/");
			String _fileName = _swfBasePath + currSplit[currSplit.length-1];
			EchoTask curr = new EchoTask(getFileManipulatorTaskRunner().getComponentTemplate(getClass().getClassLoader(), _currSystemSwfSourceFile), _fileName); 
			addTask(curr);
		}
	}
	
	public void createSystemSWCFile(String sourcePath, String outPut, String flexSDKRootPath, String loadConfigFilePath) {
		SWCTask swcCreate = new SWCTask(sourcePath, outPut, flexSDKRootPath, loadConfigFilePath);
		addTask(swcCreate);
	}
	
	public void deleteResources(String deleteResource, boolean isDirectory) {
		DeleteTask deleteResourceTask = new DeleteTask(deleteResource, isDirectory);
		addTask(deleteResourceTask);
	}
	
	public void makeDirectory(String directoryToCreate) {
		MkdirTask preMxmlDirCreator = new MkdirTask(directoryToCreate);
		addTask(preMxmlDirCreator);
	}
	
	public void renameFile(String sourceFile, String destFile, boolean overWrite) {
		RenameTask rename = new RenameTask(sourceFile, destFile, overWrite);
		addTask(rename);
	}
	
	public void replaceTokenWithValue(_MXMLContract applicationInstance, String valueToReplaceWith, String tokenReplace) {

		ReplaceTextTask addUIComponentTemplate = new ReplaceTextTask(applicationInstance.getAbsolutePathToPreMxmlFile());
		addUIComponentTemplate.multiLineReplace(true);
		addUIComponentTemplate.addTokenValue(tokenReplace, valueToReplaceWith);
		addTask(addUIComponentTemplate);
	}
	
	public void writeBodyContent(_MXMLContract componentMXML) {
		
		Object stringBodyContent = componentMXML.getAttributes().get(MXMLConstants.TAG_BODY_CONTENT_ATTR);
		String stringBodyContentToReplace = stringBodyContent == null ? "" : (String) stringBodyContent;
		ReplaceTextTask writeBodyContent = new ReplaceTextTask(componentMXML.getAbsolutePathToPreMxmlFile());
		writeBodyContent.addTokenValue(MXMLConstants.TAG_BODY_CONTENT_TOKEN, stringBodyContentToReplace);
		writeBodyContent.multiLineReplace(true);
		addTask(writeBodyContent);
	}
	
	public final _FileManipulatorTaskRunner getFileManipulatorTaskRunner(){
		MxmlContext mxmlContext = MxmlContext.getCurrentInstance();
		return mxmlContext.getFileManipulatorRunner();
	}
		
}
