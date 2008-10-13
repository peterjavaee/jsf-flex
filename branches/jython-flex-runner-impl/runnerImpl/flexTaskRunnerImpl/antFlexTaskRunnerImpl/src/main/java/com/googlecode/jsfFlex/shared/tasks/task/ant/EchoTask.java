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
import org.apache.tools.ant.taskdefs.Echo;
import org.apache.tools.ant.taskdefs.Echo.EchoLevel;

import com.googlecode.jsfFlex.shared.exception.ComponentBuildException;

/**
 * @author Ji Hoon Kim
 */
public final class EchoTask extends Ant_BaseTask {
	
	private static final String ECHO_TARGET = "echo";
	
	private Echo _echoTask;
	private Target _echoTarget;
	
	private String _message;
	private String _file;
	private String _level;
	private boolean _append;
	
	public EchoTask(){
		super();
	}
	
	public EchoTask(String message, String file){
		_message = message;
		_file = file;
	}
	
	{
		_echoTarget = new Target();
		_echoTarget.setName(ECHO_TARGET);
		_echoTarget.setProject(_taskProject);
		_taskProject.addTarget(_echoTarget);
		
		_echoTask = new Echo();
		_echoTask.setOwningTarget(_echoTarget);
		_echoTask.setProject(_taskProject);
		
		_echoTarget.addTask(_echoTask);
		
		_level = "error";
		_append = false;
	}
	
	protected void performTask() {
		
		_echoTask.addText(getMessage());
		_echoTask.setFile(new File(getFile()));
		
		EchoLevel _echoLevel = new EchoLevel();
		_echoLevel.setValue(getLevel());
		_echoTask.setLevel(_echoLevel);
		
		_echoTask.setAppend(getAppend());
		
		_echoTask.maybeConfigure();
		
		try {
			
			buildProject(ECHO_TARGET);
			
		} catch (BuildException buildException) {
			_taskProject.fireBuildFinished(buildException);
			StringBuffer errorMessage = new StringBuffer();
			errorMessage.append("Error in Echo's performTask with following fields \n");
			errorMessage.append(toString());
			throw new ComponentBuildException(errorMessage.toString(), buildException);
		}
		
	}
	
	public String toString() {
		StringBuffer content = new StringBuffer();
		content.append("message [ ");
		content.append(_message);
		content.append(" ] ");
		content.append("file [ ");
		content.append(_file);
		content.append(" ] ");
		content.append("level [ ");
		content.append(_level);
		content.append(" ] ");
		content.append(" append [ ");
		content.append(_append);
		content.append("]");
		
		return content.toString();
	}
	
	public boolean getAppend(){
		return _append;
	}
	public void setAppend(boolean append) {
		_append = append;
	}
	public String getFile(){
		return _file;
	}
	public void setFile(String file) {
		_file = file;
	}
	public String getLevel(){
		return _level;
	}
	public void setLevel(String level) {
		_level = level;
	}
	public String getMessage(){
		return _message;
	}
	public void setMessage(String message) {
		_message = message;
	}

}
