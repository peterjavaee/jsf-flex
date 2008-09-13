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
package com.googlecode.jsfFlex.shared.tasks.task.ant;

import java.io.File;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Target;
import org.apache.tools.ant.taskdefs.Copy;
import org.apache.tools.ant.types.FileSet;
import org.apache.tools.ant.types.PatternSet;

import com.googlecode.jsfFlex.shared.exception.ComponentBuildException;

/**
 * @author Ji Hoon Kim
 */
public final class FileCopyTask extends Ant_BaseTask {
	
	private static final String COPY_TARGET = "copy";
	
	private Copy _copyTask;
	private Target _copyTarget;
	
	private String _copyFile;
	
	private String _copyDir;
	private String _copyInclude;
	private String _copyExclude;
	
	private String _copyTo;
	private String _copyToFile;
	
	private FileSet _dirCopyFileSet;
	
	public FileCopyTask(){
		super();
	}
	
	public FileCopyTask(String copyFile, String copyTo){
		super();
		_copyFile = copyFile;
		_copyToFile = copyTo;
	}
	
	public FileCopyTask(String copyDir, String copyInclude, String copyExclude,
						String copyTo){
		super();
		_copyDir = copyDir;
		_copyInclude = copyInclude;
		_copyExclude = copyExclude;
		_copyTo = copyTo;
	}
	
	{
		_copyTarget = new Target();
		_copyTarget.setName(COPY_TARGET);
		_copyTarget.setProject(_taskProject);
		_taskProject.addTarget(_copyTarget);
		
		_copyTask = new Copy();
		_copyTask.setOwningTarget(_copyTarget);
		_copyTask.setProject(_taskProject);
		
		_copyTarget.addTask(_copyTask);
	}
	
	private void configureParameters(){
		
		if(getCopyFile() != null){
			//means by file copy
			_copyTask.setFile(new File(getCopyFile()));
			
		}else{
			//means by dir copy with fileset
			_dirCopyFileSet = new FileSet();
			_dirCopyFileSet.setDir(new File(getCopyDir()));
			
			if(getCopyInclude() != null){
				PatternSet.NameEntry _copyIncludeNE = _dirCopyFileSet.createInclude();
				_copyIncludeNE.setName(getCopyInclude());
			}
			
			if(getCopyExclude() != null){
				PatternSet.NameEntry _copyExcludeNE = _dirCopyFileSet.createExclude();
				_copyExcludeNE.setName(getCopyExclude());
			}
			
			_copyTask.addFileset(_dirCopyFileSet);
			
		}
		
		if(getCopyToFile() != null){
			_copyTask.setTofile(new File(getCopyToFile()));
		}else{
			_copyTask.setTodir(new File(getCopyTo()));
		}
		
		_copyTask.maybeConfigure();
	}
	
	protected void performTask() throws ComponentBuildException {
		
		configureParameters();
		
		try {
			
			buildProject(COPY_TARGET);
			
		} catch (BuildException buildException) {
			_taskProject.fireBuildFinished(buildException);
			StringBuffer errorMessage = new StringBuffer();
			errorMessage.append("Error in Copy's performTask with following fields \n");
			errorMessage.append(toString());
			throw new ComponentBuildException(errorMessage.toString(), buildException);
		}
		
	}
	
	public String toString() {
		StringBuffer content = new StringBuffer();
		content.append("copyFile [ ");
		content.append(_copyFile);
		content.append(" ] ");
		content.append("copyDir [ ");
		content.append(_copyDir);
		content.append(" ] ");
		content.append("copyInclude [ ");
		content.append(_copyInclude);
		content.append(" ] ");
		content.append("copyExclude [ ");
		content.append(_copyExclude);
		content.append(" ] ");
		content.append("copyTo [ ");
		content.append(_copyTo);
		content.append(" ] ");
		content.append("copyToFile [ ");
		content.append(_copyToFile);
		content.append(" ] ");
		
		return content.toString();
	}
	
	public String getCopyFile() {
		return _copyFile;
	}
	public void setCopyFile(String copyFile) {
		_copyFile = copyFile;
	}
	public String getCopyDir() {
		return _copyDir;
	}
	public void setCopyDir(String copyDir) {
		_copyDir = copyDir;
	}
	public String getCopyExclude() {
		return _copyExclude;
	}
	public void setCopyExclude(String copyExclude) {
		_copyExclude = copyExclude;
	}
	public String getCopyInclude() {
		return _copyInclude;
	}
	public void setCopyInclude(String copyInclude) {
		_copyInclude = copyInclude;
	}
	public String getCopyTo() {
		return _copyTo;
	}
	public void setCopyTo(String copyTo) {
		_copyTo = copyTo;
	}
	public String getCopyToFile() {
		return _copyToFile;
	}
	public void setCopyToFile(String copyToFile) {
		_copyToFile = copyToFile;
	}
	
}
