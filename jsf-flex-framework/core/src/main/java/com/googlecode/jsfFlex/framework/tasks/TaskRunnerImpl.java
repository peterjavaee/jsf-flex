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

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;
import com.googlecode.jsfFlex.framework.tasks.task._Task;

/**
 * @author Ji Hoon Kim
 */
public class TaskRunnerImpl implements _TaskRunner {
	
	private boolean _executePerTask;
	
	protected List _tasks;
	
	public TaskRunnerImpl(){
		super();
		_tasks = new LinkedList();
	}
	
	public TaskRunnerImpl(boolean executePerTask){
		super();
		_tasks = new LinkedList();
		_executePerTask = executePerTask;
	}
	
	public TaskRunnerImpl(LinkedList tasks){
		_tasks.addAll(tasks);
	}

	public synchronized void addTask(_Task toAdd){
		_tasks.add(toAdd);
		if(isExecutePerTask()){
			execute();
		}
	}
	
	public synchronized void removeTask(_Task deleteTask){
		_tasks.remove(deleteTask);		
	}

	public synchronized void clearAllTask(){
		_tasks.clear();
	}
	
	public boolean isExecutePerTask() {
		return _executePerTask;
	}

	public void setExecutePerTask(boolean executePerTask) {
		_executePerTask = executePerTask;
	}

	public synchronized void execute() throws ComponentBuildException{
		Iterator iterate = _tasks.iterator();
		_Task current;
		while(iterate.hasNext()){
			current = (_Task) iterate.next();
			current.performTask();
		}
		clearAllTask();
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof TaskRunnerImpl)){
			return false;
		}
		
		TaskRunnerImpl taskRunnerInst = (TaskRunnerImpl) obj;
		return (_tasks.size() == taskRunnerInst._tasks.size());
	}
	
	public int hashCode() {
		
		return _tasks.size();
	}

}
