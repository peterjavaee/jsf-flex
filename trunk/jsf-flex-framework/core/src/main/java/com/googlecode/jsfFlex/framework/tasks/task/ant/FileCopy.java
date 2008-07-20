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
package com.googlecode.jsfFlex.framework.tasks.task.ant;

import java.io.File;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Target;
import org.apache.tools.ant.taskdefs.Copy;

import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;
import com.googlecode.jsfFlex.framework.tasks.task._Task;

/**
 * @author Ji Hoon Kim
 */
public class FileCopy extends Ant_Base implements _Task {
	
	private static final String COPY_TARGET = "cp_file";
	
	private String _cp_from;
	private String _cp_to;
	private boolean _overwrite;
	
	private Copy _copyTask;
	private Target _copyTarget;
	
	public FileCopy(){
		super();
	}
	
	public FileCopy(String cp_from, String cp_to){
		_cp_from = cp_from;
		_cp_to = cp_to;
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
		
		_overwrite = true;
	}
	
	public synchronized void performTask() throws ComponentBuildException {
		
		_copyTask.setFile(new File(getCp_from()));
		_copyTask.setTofile(new File(getCp_to()));
		_copyTask.setOverwrite(isOverwrite());
		
		_copyTask.maybeConfigure();
		
		try {
			
			buildProject(COPY_TARGET);
			
		} catch (BuildException buildException) {
			_taskProject.fireBuildFinished(buildException);
			StringBuffer errorMessage = new StringBuffer();
			errorMessage.append("Error in FileCopy's performTask with following fields \n");
			errorMessage.append(toString());
			throw new ComponentBuildException(errorMessage.toString(), buildException);
		}
		
	}
	
	public String toString() {
		StringBuffer content = new StringBuffer();
		content.append("cp_from [ ");
		content.append(_cp_from);
		content.append(" ] ");
		content.append("cp_to [ ");
		content.append(_cp_to);
		content.append(" ] ");
		content.append("overwrite [ ");
		content.append(_overwrite);
		content.append(" ]");
		
		return content.toString();
	}

	public String getCp_from() {
		return _cp_from;
	}
	public synchronized void setCp_from(String cp_from) {
		_cp_from = cp_from;
	}
	public String getCp_to() {
		return _cp_to;
	}
	public synchronized void setCp_to(String cp_to) {
		_cp_to = cp_to;
	}
	public boolean isOverwrite() {
		return _overwrite;
	}
	public void setOverwrite(boolean overwrite) {
		_overwrite = overwrite;
	}

	public boolean equals(Object obj) {
		if(!(obj instanceof FileCopy)){
			return false;
		}
		
		FileCopy fileCopyInstance = (FileCopy) obj;
		return (this.getCp_from().equals(fileCopyInstance.getCp_from()) && this.getCp_to().equals(fileCopyInstance.getCp_to()));
	}
	
	public int hashCode() {
		
		return (getCp_from() + getCp_to()).hashCode();
	}

}
