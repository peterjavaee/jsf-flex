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

import java.io.File;
import java.io.InputStream;
import java.util.Set;

import com.googlecode.jsfFlex.framework._Component;
import com.googlecode.jsfFlex.framework.context.MxmlContext;
import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;
import com.googlecode.jsfFlex.framework.tasks._AnnotationDocletParser;
import com.googlecode.jsfFlex.framework.tasks._CommonTaskRunner;
import com.googlecode.jsfFlex.framework.tasks._FileManipulatorTaskRunner;
import com.googlecode.jsfFlex.framework.tasks._FlexTaskRunner;
import com.googlecode.jsfFlex.framework.tasks.factory._RunnerFactory;
import com.googlecode.jsfFlex.framework.util.MXMLConstants;
import com.googlecode.jsfFlex.shared.adapter._MXMLApplicationContract;
import com.googlecode.jsfFlex.shared.adapter._MXMLContract;

/**
 * @author Ji Hoon Kim
 */
public abstract class MXMLComponentBaseActions implements _Component {
	
	private _AnnotationDocletParser _annotationDocletParserInstance;
	
	protected MXMLComponentBaseActions(){
		super();
		MxmlContext mxmlContext = MxmlContext.getCurrentInstance();
		_RunnerFactory _runnerFactoryInstance = mxmlContext.getRunnerFactoryInstance();
		_annotationDocletParserInstance = _runnerFactoryInstance.getAnnotationDocletParserImpl();
	}
	
	protected Set getTokenValueSet(){
		return _annotationDocletParserInstance.getTokenValueSet();
	}
	
	public void buildComponentBegin(Object componentObj) throws ComponentBuildException{
		
	}
	
	public void buildComponentInterlude(Object componentObj) throws ComponentBuildException{
		
	}
	
	public void buildComponentChildren(Object componentObj) throws ComponentBuildException {
		
	}
	
	public void buildComponentEnd(Object componentObj) throws ComponentBuildException{
		
		MxmlContext mxmlContext = MxmlContext.getCurrentInstance();
		if(mxmlContext.isSimplySWF() || mxmlContext.isProductionEnv()){
			return;
		}
		
		_MXMLContract componentMXML = (_MXMLContract) componentObj;
		getFlexTaskRunner().writeBodyContentTask(componentMXML);
		
	}
	
	protected void execute() throws ComponentBuildException {
		getCommonTaskRunner().execute();
		getFlexTaskRunner().execute();
	}
	
	protected void processCreateSwf(_MXMLApplicationContract componentMXML, String mxmlFile) throws ComponentBuildException {
		
		MxmlContext mxmlContext = MxmlContext.getCurrentInstance();
		String copyTo = mxmlContext.getMxmlPath() + mxmlContext.getCurrMxml() + MXMLConstants.MXML_FILE_EXT;
		//now create the MXML file
		createMXML(componentMXML, copyTo);
		
		if(!new File(mxmlContext.getFlexSDKPath()).exists()){
			addMakeDirectoryTask(mxmlContext.getFlexSDKPath());
			unZipArchiveRelative(MXMLConstants.FLEX_SDK_ZIP, mxmlContext.getFlexSDKPath());
			
			//copy the necessary ActionScript files over for SWF generation 
			createSwcSourceFiles(mxmlContext.getSwcPath(), MXMLConstants.getSwcSourceFiles(), 
										MXMLConstants.JSF_FLEX_MAIN_SWC_CONFIG_FILE);
			
			//create the SWC file
			String _loadConfigAbsolutePath = mxmlContext.getSwcPath() + MXMLConstants.JSF_FLEX_MAIN_SWC_CONFIGURATIONFILE;
			String _swcFileLocationPath = mxmlContext.getSwcPath() + MXMLConstants.JSF_FLEX_MAIN_SWC_ARCHIVE_NAME + MXMLConstants.SWC_FILE_EXT;
			createSystemSWCFile(mxmlContext.getSwcPath(), _swcFileLocationPath, mxmlContext.getFlexSDKPath(), _loadConfigAbsolutePath);
			
			/*
			 * 	copy the necessary swf source files to swfBasePath
			 * 	these are files such as xml[s] which are used by the system's/above ActionScripts
			 */
			createSwfSourceFiles(mxmlContext.getSwfBasePath(), MXMLConstants.getSwfSourceFiles());
			
			/*
			 * unzip the swc's library.swf file and copy it to the swf file for linking with the swf file
			 */
			unZipArchiveAbsolute(new File(_swcFileLocationPath), mxmlContext.getSwcPath());
			
			//copy the library.swf file to swc directory
			copyFileSet(mxmlContext.getSwcPath(), "**/*.swf", null, mxmlContext.getSwfBasePath());
			
			//rename the file from library.swf to jsfFlexMainSwc.swf file
			String sourceFile = mxmlContext.getSwcPath() + MXMLConstants.DEFAULT_SWC_LIBRARY_SWF_NAME;
			String destFile = mxmlContext.getSwfBasePath() + MXMLConstants.JSF_FLEX_MAIN_SWC_ARCHIVE_NAME + MXMLConstants.SWF_FILE_EXT;
			
			renameFile(sourceFile, destFile, true);
			
			deleteResources(sourceFile, false);
		}
		
		//finally the SWF file
		createSWF(componentMXML, mxmlFile, mxmlContext.getSwfPath(), mxmlContext.getFlexSDKPath());
		
	}
	
	protected void addCreatePreMxmlTask(_MXMLContract comp, String mxmlComponentName, String bodyContent) throws ComponentBuildException {
		
		String fileDirectory = comp.getAbsolutePathToPreMxmlFile().substring(0, comp.getAbsolutePathToPreMxmlFile().lastIndexOf(File.separatorChar));
		getFlexTaskRunner().addMakeDirectoryTask(fileDirectory);
		
		getFileManipulatorTaskRunner().createPreMxmlFileTask(comp.getAbsolutePathToPreMxmlFile(), null, _annotationDocletParserInstance.getTokenValueSet(), mxmlComponentName, 
																bodyContent, childPreMxmlComponentIdentifier(comp), siblingPreMxmlComponentIdentifier(comp));
		
	}
	
	protected void addMakeDirectoryTask(String directoryToCreate) throws ComponentBuildException {
		getFlexTaskRunner().addMakeDirectoryTask(directoryToCreate);
	}
	
	protected void addReplaceTokenWithValueTask(_MXMLContract applicationInstance, String valueToReplaceWith, String tokenReplace) throws ComponentBuildException {
		getFlexTaskRunner().addReplaceTokenWithValueTask(applicationInstance, valueToReplaceWith, tokenReplace);
	}
	
	protected void createMXML(_MXMLContract applicationInstance, String copyTo) throws ComponentBuildException {
		getFlexTaskRunner().createMXML(applicationInstance, copyTo);
	}
	
	protected void createSwcSourceFiles(String _swcPath, String[] _systemSourceFiles, String jsfFlexMainSwcConfigFile) throws ComponentBuildException {
		getFlexTaskRunner().createSwcSourceFiles(_swcPath, _systemSourceFiles, jsfFlexMainSwcConfigFile);
	}
	
	protected void createSystemSWCFile(String sourcePath, String outPut, String flexSDKRootPath, String loadConfigFilePath) 
											throws ComponentBuildException {
		getFlexTaskRunner().createSystemSWCFile(sourcePath, outPut, flexSDKRootPath, loadConfigFilePath);
	}
	
	protected void createSWF(_MXMLApplicationContract componentMXML, String mxmlFile, 
									String swfPath, String flexSDKRootPath) throws ComponentBuildException {
		getFlexTaskRunner().createSWF(componentMXML, mxmlFile, swfPath, flexSDKRootPath);
	}
	
	protected void createSwfSourceFiles(String _swfBasePath, String[] _systemSwfSourceFiles) throws ComponentBuildException {
		getFlexTaskRunner().createSwfSourceFiles(_swfBasePath, _systemSwfSourceFiles);
	}
	
	public void deleteResources(String deleteResource, boolean isDirectory) throws ComponentBuildException {
		getFlexTaskRunner().deleteResources(deleteResource, isDirectory);
	}
	
	protected void copyFile(String fileToCopy, String fileToCopyTo) throws ComponentBuildException {
		getFlexTaskRunner().copyFile(fileToCopy, fileToCopyTo);
	}
	
	protected void copyFileSet(String copyDir, String copyInclude, String copyExclude, String copyTo) throws ComponentBuildException {
		getFlexTaskRunner().copyFileSet(copyDir, copyInclude, copyExclude, copyTo);
	}
	
	protected void renameFile(String sourceFile, String destFile, boolean overWrite) throws ComponentBuildException {
		getFlexTaskRunner().renameFile(sourceFile, destFile, overWrite);
	}
	
	/**
	 * This method should be used for files that are relative to the UnzipTask
	 * 
	 * @param _unZipFile
	 * @param _unZipDest
	 * @throws ComponentBuildException
	 */
	protected void unZipArchiveRelative(String _unZipFile, String _unZipDest) throws ComponentBuildException {
		getCommonTaskRunner().unZipArchiveRelative(_unZipFile, _unZipDest);
	}
	
	/**
	 * This method should be used for files that are absolute
	 * @param _unZipFile
	 * @param _unZipDest
	 * @throws ComponentBuildException
	 */
	protected void unZipArchiveAbsolute(File _unZipFile, String _unZipDest) throws ComponentBuildException {
		
		getCommonTaskRunner().unZipArchiveAbsolute(_unZipFile, _unZipDest);
	}
	
	/**
	 * This method should be used for files that are absolute
	 * @param _unZipFile
	 * @param _unZipDest
	 * @throws ComponentBuildException
	 */
	protected void unZipArchiveAbsolute(InputStream _unZipFile, String _unZipDest) throws ComponentBuildException {
		
		getCommonTaskRunner().unZipArchiveAbsolute(_unZipFile, _unZipDest);
	}
	
	protected void mapFields(Class mapClass, Object componentObj, String mappingFile) throws ComponentBuildException {
		_annotationDocletParserInstance.mapComponentFields(mapClass, getClass().getClassLoader(), componentObj, mappingFile);
	}
	
	public String getComponentTemplate(String template) throws ComponentBuildException {
		
		return _FileManipulatorTaskRunner.getComponentTemplate(getClass().getClassLoader(), template);
	}
	
	protected String readFileContent(String fileName) throws ComponentBuildException {
		
		return _FileManipulatorTaskRunner.readFileContent(fileName);
	}
	
	protected String childPreMxmlComponentIdentifier(_MXMLContract currInstance){
		StringBuffer toReturn = new StringBuffer();
		
		toReturn.append(currInstance.getPreMxmlIdentifier());
		toReturn.append(currInstance.getMajorLevel()+1);
		toReturn.append(0);
		
		return toReturn.toString();
	}
	
	protected String siblingPreMxmlComponentIdentifier(_MXMLContract currInstance){
		StringBuffer toReturn = new StringBuffer();
		
		toReturn.append(currInstance.getParentPreMxmlIdentifier());
		toReturn.append(currInstance.getMajorLevel());
		toReturn.append(currInstance.getMinorLevel()+1);
		
		return toReturn.toString();
	}
	
	protected String childReplaceTokenWithPreMxmlIdentifier(_MXMLContract currInstance){
		StringBuffer toReturn = new StringBuffer();
		
		toReturn.append(MXMLConstants.CHILD_REPLACE_TOKEN_PREMXML_IDENTIFIER_PRE);
		toReturn.append(currInstance.getPreMxmlIdentifier());
		toReturn.append(MXMLConstants.CHILD_REPLACE_TOKEN_PREMXML_IDENTIFIER_SUFF);
		
		return toReturn.toString();
	}
	
	protected String siblingReplaceTokenWithPreMxmlIdentifier(_MXMLContract currInstance){
		StringBuffer toReturn = new StringBuffer();
		
		toReturn.append(MXMLConstants.SIBLING_REPLACE_TOKEN_PREMXML_IDENTIFIER_PRE);
		toReturn.append(currInstance.getPreMxmlIdentifier());
		toReturn.append(MXMLConstants.SIBLING_REPLACE_TOKEN_PREMXML_IDENTIFIER_SUFF);
		
		return toReturn.toString();
	}
	
	private _CommonTaskRunner getCommonTaskRunner(){
		MxmlContext mxmlContext = MxmlContext.getCurrentInstance();
		return mxmlContext.getCommonRunner();
	}
		
	private _FileManipulatorTaskRunner getFileManipulatorTaskRunner(){
		MxmlContext mxmlContext = MxmlContext.getCurrentInstance();
		return mxmlContext.getFileManipulatorRunner();
	}
	
	protected _FlexTaskRunner getFlexTaskRunner(){
		MxmlContext mxmlContext = MxmlContext.getCurrentInstance();
		return mxmlContext.getFlexRunner();
	}
	
	protected void addMapperFilterString(String toBlankOut){
		_annotationDocletParserInstance.getFilterOutAttributes().add(toBlankOut);
	}
	
}
