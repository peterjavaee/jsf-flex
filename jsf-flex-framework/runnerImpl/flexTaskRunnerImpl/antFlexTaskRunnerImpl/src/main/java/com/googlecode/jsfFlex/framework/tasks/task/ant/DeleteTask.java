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
import org.apache.tools.ant.taskdefs.Delete;

import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;
import com.googlecode.jsfFlex.framework.tasks.task._Task;

/**
 * @author Ji Hoon Kim
 */
public class DeleteTask extends Ant_BaseTask implements _Task {
	
	private static final String DELETE_TARGET = "delete";
	
	private Delete _deleteTask;
	private Target _deleteTarget;
	
	private String _deleteResource;
	private boolean _isDirectory;
	
	public DeleteTask(){
		super();
	}
	
	public DeleteTask(String deleteResource, boolean isDirectory){
		super();
		_deleteResource = deleteResource;
		_isDirectory = isDirectory;
	}
	
	{
		_deleteTarget = new Target();
		_deleteTarget.setName(DELETE_TARGET);
		_deleteTarget.setProject(_taskProject);
		_taskProject.addTarget(_deleteTarget);
		
		_deleteTask = new Delete();
		_deleteTask.setOwningTarget(_deleteTarget);
		_deleteTask.setProject(_taskProject);
		
		_deleteTarget.addTask(_deleteTask);
	}
	
	
	public void performTask() throws ComponentBuildException {
		
		if(isDirectory()){
			_deleteTask.setDir(new File(getDeleteResource()));
		}else{
			_deleteTask.setFile(new File(getDeleteResource()));
		}
		
		_deleteTask.maybeConfigure();
		
		try {
			
			buildProject(DELETE_TARGET);
			
		} catch (BuildException buildException) {
			_taskProject.fireBuildFinished(buildException);
			StringBuffer errorMessage = new StringBuffer();
			errorMessage.append("Error in Delete's performTask with following fields \n");
			errorMessage.append(toString());
			throw new ComponentBuildException(errorMessage.toString(), buildException);
		}
		
	}
	
	public String toString() {
		StringBuffer content = new StringBuffer();
		content.append("deleteResource [ ");
		content.append(_deleteResource);
		content.append(" ] ");
		content.append("isDirectory [ ");
		content.append(_isDirectory);
		content.append(" ] ");
		
		return content.toString();
	}
	
	public String getDeleteResource() {
		return _deleteResource;
	}
	public void setDeleteResource(String deleteResource) {
		_deleteResource = deleteResource;
	}
	public boolean isDirectory() {
		return _isDirectory;
	}
	public void setDirectory(boolean isDirectory) {
		_isDirectory = isDirectory;
	}
	
}
