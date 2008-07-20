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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.googlecode.jsfFlex.framework.context.MxmlContext;
import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;
import com.googlecode.jsfFlex.framework.tasks.task.ant.DeleteTask;
import com.googlecode.jsfFlex.framework.tasks.task.ant.EchoTask;
import com.googlecode.jsfFlex.framework.tasks.task.ant.FileCopy;
import com.googlecode.jsfFlex.framework.tasks.task.ant.MXMLC;
import com.googlecode.jsfFlex.framework.tasks.task.ant.MkdirTask;
import com.googlecode.jsfFlex.framework.tasks.task.ant.ReplaceText;
import com.googlecode.jsfFlex.framework.util.MXMLConstants;
import com.googlecode.jsfFlex.framework.util._FileManipulator;
import com.googlecode.jsfFlex.shared.adapter._MXMLApplicationContract;
import com.googlecode.jsfFlex.shared.adapter._MXMLContract;

/**
 * @author Ji Hoon Kim
 */
public class AntFlexTaskRunnerImpl extends TaskRunnerImpl implements _FlexTaskRunner {
	
	private final static Log _log = LogFactory.getLog(AntFlexTaskRunnerImpl.class);
	
	private static Map _antFlexTaskRunnerMap = new HashMap();
	private static AntFlexTaskRunnerImpl _instance;
	
	private AntFlexTaskRunnerImpl(){
		super();
	}
	
	private AntFlexTaskRunnerImpl(boolean executePerTask){
		super(executePerTask);
	}
	
	public static synchronized AntFlexTaskRunnerImpl getInstance(boolean executePerTask, String mxmlPackage){
		if(_antFlexTaskRunnerMap.get(mxmlPackage) == null){
			_instance = new AntFlexTaskRunnerImpl(executePerTask);
			_antFlexTaskRunnerMap.put(mxmlPackage, _instance);
		}else{
			_instance = (AntFlexTaskRunnerImpl) _antFlexTaskRunnerMap.get(mxmlPackage);
		}
		return _instance;
	}
	
	public void addCreatePreMxmlTask(_MXMLContract comp, String mxmlInputTemplatePath, String templateContent){
		//TODO : Implement it better later using different technology or different method
		String fileDirectory = comp.getAbsolutePathToPreMxmlFile().substring(0, comp.getAbsolutePathToPreMxmlFile().lastIndexOf(File.separatorChar));
		MkdirTask preMxmlDirCreator = new MkdirTask(fileDirectory);
		addTask(preMxmlDirCreator);
		
		EchoTask preMxmlCreator = new EchoTask(templateContent, comp.getAbsolutePathToPreMxmlFile());
		addTask(preMxmlCreator);
	}
	
	public void addInsertComponentTemplateTask(_MXMLContract comp, String contentToken, String contentTemplate){
		
		ReplaceText addUIComponentTemplate = new ReplaceText(comp.getAbsolutePathToPreMxmlFile());
		addUIComponentTemplate.setMultiLineReplace(true);
		addUIComponentTemplate.addTokenValue(contentToken, contentTemplate);
		addTask(addUIComponentTemplate);
	}
	
	public void addMakeDirectoryTask(String directoryToCreate){
		MkdirTask preMxmlDirCreator = new MkdirTask(directoryToCreate);
		addTask(preMxmlDirCreator);
	}
	
	public void addReplaceTokenTask(_MXMLContract comp, Map replaceTextList){
		
		ReplaceText replaceTokens = new ReplaceText(comp.getAbsolutePathToPreMxmlFile());
		replaceTokens.setMultiLineReplace(true);
		replaceTokens.setReplaceList(replaceTextList);
		addTask(replaceTokens);
	}
	
	public void addReplaceTokenWithValueTask(_MXMLContract applicationInstance, String valueToReplaceWith, String tokenReplace) throws ComponentBuildException {

		ReplaceText addUIComponentTemplate = new ReplaceText(applicationInstance.getAbsolutePathToPreMxmlFile());
		addUIComponentTemplate.setMultiLineReplace(true);
		
		addUIComponentTemplate.addTokenValue(tokenReplace, valueToReplaceWith);
		addTask(addUIComponentTemplate);
	}
	
	public void deleteResources(String deleteResource, boolean isDirectory) throws ComponentBuildException {
		
		DeleteTask deleteResourceTask = new DeleteTask(deleteResource, isDirectory);
		addTask(deleteResourceTask);
	}
	
	public void writeBodyContentTask(_MXMLContract componentMXML){
		
		Object stringBodyContent = componentMXML.getAttributes().get(MXMLConstants.TAG_BODY_CONTENT_ATTR);
		String stringBodyContentToReplace = stringBodyContent == null ? new String() : (String) stringBodyContent;
		ReplaceText writeBodyContent = new ReplaceText(componentMXML.getAbsolutePathToPreMxmlFile());
		writeBodyContent.addTokenValue(MXMLConstants.TAG_BODY_CONTENT_TOKEN, stringBodyContentToReplace);
		writeBodyContent.setMultiLineReplace(true);
		addTask(writeBodyContent);
	}
	
	public void createMXML(_MXMLContract applicationInstance, String copyTo) throws ComponentBuildException {
		//TODO : Implement this better later
		ReplaceText removeEmptySpace = new ReplaceText(applicationInstance.getAbsolutePathToPreMxmlFile());
		removeEmptySpace.setReplaceRegExp(true);
		removeEmptySpace.setRegMatch(ReplaceText.CLEAN_REG_EXP_MATCH);
		removeEmptySpace.setRegReplace(ReplaceText.CLEAN_REG_EXP_REPLACE_WITH);
		
		addTask(removeEmptySpace);
		
		String copyFrom = applicationInstance.getAbsolutePathToPreMxmlFile();
		
		FileCopy mxmlCreator = new FileCopy(copyFrom, copyTo);
		addTask(mxmlCreator);
	}
	
	
	/*
	 * This will be removed later and will be replaced with a plugin that will create a swf file that will connect with
	 * the application's swf file 
	 * @deprecated	
	 */
	public void createMxmlcSourceFiles(String _mxmlPath, String[] _systemSourceFiles) throws ComponentBuildException {
		//Echo the sourceFiles to the MXML path
		
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
			addMakeDirectoryTask(_mxmlPath + _path.toString());
			_fileName = _mxmlPath + _path.toString() + currSplit[currSplit.length-1];
			curr = new EchoTask(getCurrFileManipulator().getComponentTemplate(_systemSourceFiles[i]), _fileName); 
			addTask(curr);
		}
	}
	
	public void createSystemSWCFile(String _mxmlPath) throws ComponentBuildException {
		
	}
	
	public void createSWF(_MXMLApplicationContract componentMXML, String mxmlFile, String swfPath, String flexSDKRootPath) 
													throws ComponentBuildException {
		MXMLC swfCreator = new MXMLC(mxmlFile, swfPath, componentMXML, flexSDKRootPath);
		addTask(swfCreator);
	}
	
	public void createSwfSourceFiles(String _swfBasePath, String[] _systemSwfSourceFiles) throws ComponentBuildException {
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
			curr = new EchoTask(getCurrFileManipulator().getComponentTemplate(_systemSwfSourceFiles[i]), _fileName); 
			addTask(curr);
		}
	}
	
	public void replaceChildSiblingWithPreMxmlIdentifier(_MXMLContract currInstance) throws ComponentBuildException {
		ReplaceText replaceChildSibling = new ReplaceText(currInstance.getAbsolutePathToPreMxmlFile());
		replaceChildSibling.setMultiLineReplace(true);
		
		replaceChildSibling.addTokenValue(MXMLConstants.CHILD_REPLACE_TOKEN, childToCreateReplaceTokenWithPreMxmlIdentifier(currInstance));
		replaceChildSibling.addTokenValue(MXMLConstants.SIBLING_REPLACE_TOKEN, siblingToCreateReplaceTokenWithPreMxmlIdentifier(currInstance));
		addTask(replaceChildSibling);
	}
	
	private String childToCreateReplaceTokenWithPreMxmlIdentifier(_MXMLContract currInstance){
		StringBuffer toReturn = new StringBuffer();
		
		toReturn.append(MXMLConstants.CHILD_REPLACE_TOKEN_PREMXML_IDENTIFIER_PRE);
		toReturn.append(currInstance.getPreMxmlIdentifier());
		toReturn.append(currInstance.getMajorLevel()+1);
		toReturn.append(0);
		toReturn.append(MXMLConstants.CHILD_REPLACE_TOKEN_PREMXML_IDENTIFIER_SUFF);
		
		return toReturn.toString();
	}
	
	private String siblingToCreateReplaceTokenWithPreMxmlIdentifier(_MXMLContract currInstance){
		StringBuffer toReturn = new StringBuffer();
		
		toReturn.append(MXMLConstants.SIBLING_REPLACE_TOKEN_PREMXML_IDENTIFIER_PRE);
		toReturn.append(currInstance.getParentPreMxmlIdentifier());
		toReturn.append(currInstance.getMajorLevel());
		toReturn.append(currInstance.getMinorLevel()+1);
		toReturn.append(MXMLConstants.SIBLING_REPLACE_TOKEN_PREMXML_IDENTIFIER_SUFF);
		
		return toReturn.toString();
	}
	
	private _FileManipulator getCurrFileManipulator(){
		MxmlContext mxmlContext = MxmlContext.getCurrentInstance();
		return mxmlContext.getFileManipulator();
	}
		
}
