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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.googlecode.jsfFlex.shared.exception.ComponentBuildException;

/**
 * @author Ji Hoon Kim
 */
public abstract class _FileManipulatorTaskRunner extends TaskRunnerImpl {
	
	private final static Log _log = LogFactory.getLog(_FileManipulatorTaskRunner.class);
	
	public abstract void createFileContent(String _filePath, String _templateFile, Properties _initProperties, Map _tokenMap);
	
	public abstract void createPreMxmlFile(String _preMxmlFilePath, Properties _initProperties, Set _tokenList, String _mxmlComponentName, 
												String _bodyContent, String _childIdentifier, String _siblingIdentifier);
	
	public synchronized String getComponentTemplate(ClassLoader _loader, String template) {
		StringBuffer fileContent = new StringBuffer();
		BufferedReader bufferRead = null;
		
		try{
			
			bufferRead = new BufferedReader(new InputStreamReader(_loader.getResourceAsStream(template)));
			char[] charBuffer = new char[2048];
			int offSet = 0;
			
			while((offSet = bufferRead.read(charBuffer, 0, 2048)) > -1){
				fileContent.append(charBuffer, 0, offSet);
			}
			
		}catch(FileNotFoundException fileNotFoundExcept){
			throw new ComponentBuildException(getErrorMessage("getComponentTemplate", template), fileNotFoundExcept);
		}catch(IOException ioExcept){
			throw new ComponentBuildException(getErrorMessage("getComponentTemplate", template), ioExcept);
		}finally{
			
			if(bufferRead != null){
				try{
					bufferRead.close();
				}catch(IOException closerException){
					_log.debug("Error while closing the writer within getComponentTemplate", closerException);
				}
			}
			
		}
		
		return fileContent.toString();
	}
	
	public synchronized String readFileContent(String fileName) {
		StringBuffer fileContent = new StringBuffer();
		BufferedReader bufferRead = null;
		
		try{
			bufferRead = new BufferedReader(new FileReader(new File(fileName)));
			
			char[] charBuffer = new char[2048];
			int offSet = 0;
			
			while((offSet = bufferRead.read(charBuffer, 0, 2048)) > -1){
				fileContent.append(charBuffer, 0, offSet);
			}
			
		}catch(FileNotFoundException fileNotFoundExcept){
			throw new ComponentBuildException("Failure in finding of " + fileName, fileNotFoundExcept);
		}catch(IOException ioExcept){
			throw new ComponentBuildException("Failure in reading of " + fileName, ioExcept);
		}finally{
			
			if(bufferRead != null){
				try{
					bufferRead.close();
				}catch(IOException closerException){
					_log.debug("Error while closing the writer within readFileContent", closerException);
				}
			}
			
		}
		
		return fileContent.toString();
	}
	
	private String getErrorMessage(String caller, String parameter){
		StringBuffer errorMessage = new StringBuffer();
		errorMessage.append("Exception when ");
		errorMessage.append(caller);
		errorMessage.append(" with parameter(s) [ ");
		errorMessage.append(parameter);
		errorMessage.append(" ] ");
		return errorMessage.toString();
	}
	
}