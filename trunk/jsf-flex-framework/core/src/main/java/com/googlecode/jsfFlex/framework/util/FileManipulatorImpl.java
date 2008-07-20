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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;

/**
 * @author Ji Hoon Kim
 */
public class FileManipulatorImpl implements _FileManipulator {
	
	private ClassLoader _loader;
	
	private static Map _fileManipulatorMap = new HashMap();
	private static FileManipulatorImpl _instance;
	
	private FileManipulatorImpl(){
		super();
	}
	
	private FileManipulatorImpl(ClassLoader loader){
		super();
		_loader = loader;
	}
	
	public static synchronized FileManipulatorImpl getInstance(String currMxml, ClassLoader loader){
		if(_fileManipulatorMap.get(currMxml) == null){
			_instance = new FileManipulatorImpl(loader);
			_fileManipulatorMap.put(currMxml, _instance);
		}else{
			_instance = (FileManipulatorImpl) _fileManipulatorMap.get(currMxml);
		}
		return _instance;
	}
	
	public synchronized String getComponentTemplate(String template) throws ComponentBuildException {
		StringBuffer fileContent = new StringBuffer();
		BufferedReader bufferRead = null;
		
		try{
			
			bufferRead = new BufferedReader(new InputStreamReader(_loader.getResourceAsStream(template)));
			char[] charBuffer = new char[2048];
			int offSet = 0;
			
			while((offSet = bufferRead.read(charBuffer, 0, 2048)) > -1){
				fileContent.append(charBuffer, 0, offSet);
			}
			
			bufferRead.close();
		}catch(FileNotFoundException fileNotFoundExcept){
			throw new ComponentBuildException(getErrorMessage("getComponentTemplate", template), fileNotFoundExcept);
		}catch(IOException ioExcept){
			throw new ComponentBuildException(getErrorMessage("getComponentTemplate", template), ioExcept);
		}
		
		return fileContent.toString();
	}
	
	public synchronized String readFileContent(String fileName) throws ComponentBuildException {
		StringBuffer fileContent = new StringBuffer();
		
		try{
			BufferedReader bufferRead = new BufferedReader(new FileReader(new File(fileName)));
			
			char[] charBuffer = new char[2048];
			int offSet = 0;
			
			while((offSet = bufferRead.read(charBuffer, 0, 2048)) > -1){
				fileContent.append(charBuffer, 0, offSet);
			}
			
			bufferRead.close();
		}catch(FileNotFoundException fileNotFoundExcept){
			throw new ComponentBuildException("Failure in finding of " + fileName, fileNotFoundExcept);
		}catch(IOException ioExcept){
			throw new ComponentBuildException("Failure in reading of " + fileName, ioExcept);
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
