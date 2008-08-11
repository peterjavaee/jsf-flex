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

import java.io.File;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;
import com.googlecode.jsfFlex.framework.tasks.task.ant.DeleteTask;
import com.googlecode.jsfFlex.framework.tasks.task.ant.EchoTask;
import com.googlecode.jsfFlex.framework.tasks.task.ant.FileCopyTask;
import com.googlecode.jsfFlex.framework.tasks.task.ant.MXMLCTask;
import com.googlecode.jsfFlex.framework.tasks.task.ant.MkdirTask;
import com.googlecode.jsfFlex.framework.tasks.task.ant.RenameTask;
import com.googlecode.jsfFlex.framework.tasks.task.ant.ReplaceTextTask;
import com.googlecode.jsfFlex.framework.tasks.task.ant.SWCTask;
import com.googlecode.jsfFlex.framework.util.MXMLConstants;
import com.googlecode.jsfFlex.shared.adapter._MXMLApplicationContract;
import com.googlecode.jsfFlex.shared.adapter._MXMLContract;

/**
 * @author Ji Hoon Kim
 */
public class AntFlexTaskRunnerImpl extends TaskRunnerImpl implements _FlexTaskRunner {
	
	private final static Log _log = LogFactory.getLog(AntFlexTaskRunnerImpl.class);
	
	public AntFlexTaskRunnerImpl(){
		super();
	}
	
	public void addMakeDirectoryTask(String directoryToCreate){
		MkdirTask preMxmlDirCreator = new MkdirTask(directoryToCreate);
		addTask(preMxmlDirCreator);
	}
	
	public void addReplaceTokenWithValueTask(_MXMLContract applicationInstance, String valueToReplaceWith, String tokenReplace) throws ComponentBuildException {

		ReplaceTextTask addUIComponentTemplate = new ReplaceTextTask(applicationInstance.getAbsolutePathToPreMxmlFile());
		addUIComponentTemplate.setMultiLineReplace(true);
		addUIComponentTemplate.addTokenValue(tokenReplace, valueToReplaceWith);
		addTask(addUIComponentTemplate);
	}
	
	public void deleteResources(String deleteResource, boolean isDirectory) throws ComponentBuildException {
		DeleteTask deleteResourceTask = new DeleteTask(deleteResource, isDirectory);
		addTask(deleteResourceTask);
	}
	
	public void copyFile(String fileToCopy, String fileToCopyTo) throws ComponentBuildException {
		FileCopyTask fileCopier = new FileCopyTask(fileToCopy, fileToCopyTo);
		addTask(fileCopier);
	}
	
	public void copyFileSet(String copyDir, String copyInclude, String copyExclude, String copyTo){
		FileCopyTask fileCopier = new FileCopyTask(copyDir, copyInclude, copyExclude, copyTo);
		addTask(fileCopier);
	}
	
	public void createMXML(_MXMLContract applicationInstance, String copyTo) throws ComponentBuildException {
		//TODO : Implement this better later
		ReplaceTextTask removeEmptySpace = new ReplaceTextTask(applicationInstance.getAbsolutePathToPreMxmlFile());
		removeEmptySpace.setReplaceRegExp(true);
		removeEmptySpace.setRegMatch(ReplaceTextTask.CLEAN_REG_EXP_MATCH);
		removeEmptySpace.setRegReplace(ReplaceTextTask.CLEAN_REG_EXP_REPLACE_WITH);
		
		addTask(removeEmptySpace);
		
		String copyFrom = applicationInstance.getAbsolutePathToPreMxmlFile();
		
		copyFile(copyFrom, copyTo);
	}
	
	public void createSwcSourceFiles(String _swcPath, String[] _systemSourceFiles, String jsfFlexMainSwcConfigFile) throws ComponentBuildException {
		//Echo the sourceFiles to the SWC path
		
		/*
		 * TODO : implement it better later
		 * 	Figure out a method to not create an EchoTask per _systemSourceFiles entry
		 * 	and possibly look into implementing it in an another method
		 */
		EchoTask curr;
		String[] currSplit;
		String _fileName;
		
		StringBuffer _path;
		String _pathToFile;
		for(int i=0; i < _systemSourceFiles.length; i++){
			currSplit = _systemSourceFiles[i].split("/");
			_path = new StringBuffer();
			
			/*
			 * This is a pure HACK, implement it better later
			 * The path of ActionScript files must be of com/googlecode/jsfFlex/util/frameworks/actionScript
			 */
			_pathToFile = _systemSourceFiles[i].substring(_systemSourceFiles[i].indexOf("actionScript") + 13);
			if(_pathToFile == null || _pathToFile.length() == 0){
				_log.debug("The source file [" + _systemSourceFiles[i] + "] is null or the length is zero");
				continue;
			}
			//remove the last element [name of file]
			_pathToFile = _pathToFile.substring(0, _pathToFile.lastIndexOf("/"));
			
			for(Iterator _fileSeparator = Arrays.asList(_pathToFile.split("/")).iterator(); _fileSeparator.hasNext();){
				_path.append(_fileSeparator.next().toString());
				_path.append(File.separatorChar);
			}
			addMakeDirectoryTask(_swcPath + _path.toString());
			_fileName = _swcPath + _path.toString() + currSplit[currSplit.length-1];
			curr = new EchoTask(_FileManipulatorTaskRunner.getComponentTemplate(getClass().getClassLoader(), _systemSourceFiles[i]), _fileName); 
			addTask(curr);
		}
		
		//now flush out the swc config file
		String _jsfFlexMainSwcConfigFileName = _swcPath + jsfFlexMainSwcConfigFile.substring(jsfFlexMainSwcConfigFile.lastIndexOf("/") + 1);
		curr = new EchoTask(_FileManipulatorTaskRunner.getComponentTemplate(getClass().getClassLoader(), jsfFlexMainSwcConfigFile), _jsfFlexMainSwcConfigFileName); 
		addTask(curr);
		
	}
	
	public void createSWF(_MXMLApplicationContract componentMXML, String mxmlFile, String swfPath, String flexSDKRootPath) throws ComponentBuildException {
		MXMLCTask swfCreator = new MXMLCTask(mxmlFile, swfPath, componentMXML, flexSDKRootPath);
		addTask(swfCreator);
	}
	
	public void createSwfSourceFiles(String _swfBasePath, String[] _systemSwfSourceFiles) throws ComponentBuildException {
		
		MkdirTask swfBasePathDirCreator = new MkdirTask(_swfBasePath);
		addTask(swfBasePathDirCreator);
		
		//Echo the swf sourceFiles to the swfBasepath
		
		/*
		 * TODO : implement it better later
		 * 	Figure out a method to not create an EchoTask per _systemSourceFiles entry
		 * 	and possibly look into implementing it in an another method
		 */
		EchoTask curr;
		String[] currSplit;
		String _fileName;
		
		for(int i=0; i < _systemSwfSourceFiles.length; i++){
			currSplit = _systemSwfSourceFiles[i].split("/");
			_fileName = _swfBasePath + currSplit[currSplit.length-1];
			curr = new EchoTask(_FileManipulatorTaskRunner.getComponentTemplate(getClass().getClassLoader(), _systemSwfSourceFiles[i]), _fileName); 
			addTask(curr);
		}
	}
	
	public void createSystemSWCFile(String sourcePath, String outPut, String flexSDKRootPath, String loadConfigFilePath) throws ComponentBuildException {
		SWCTask swcCreate = new SWCTask(sourcePath, outPut, flexSDKRootPath, loadConfigFilePath);
		addTask(swcCreate);
	}
	
	public void renameFile(String sourceFile, String destFile, boolean overWrite) throws ComponentBuildException {
		RenameTask rename = new RenameTask(sourceFile, destFile, overWrite);
		addTask(rename);
	}
	
	public void writeBodyContentTask(_MXMLContract componentMXML){
		
		Object stringBodyContent = componentMXML.getAttributes().get(MXMLConstants.TAG_BODY_CONTENT_ATTR);
		String stringBodyContentToReplace = stringBodyContent == null ? new String() : (String) stringBodyContent;
		ReplaceTextTask writeBodyContent = new ReplaceTextTask(componentMXML.getAbsolutePathToPreMxmlFile());
		writeBodyContent.addTokenValue(MXMLConstants.TAG_BODY_CONTENT_TOKEN, stringBodyContentToReplace);
		writeBodyContent.setMultiLineReplace(true);
		addTask(writeBodyContent);
	}
		
}
