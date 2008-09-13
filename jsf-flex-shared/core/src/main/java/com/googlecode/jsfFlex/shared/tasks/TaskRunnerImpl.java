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

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.googlecode.jsfFlex.shared.exception.ComponentBuildException;

/**
 * Previously TaskRunnerImpl was designed to allow lazy execution<br>
 * of the _Tasks within the List; however due to separation of implementation<br>
 * of the various _.+Runner interfaces, it was decided to execute the _Tasks<br>
 * upon addition.
 * 
 * @author Ji Hoon Kim
 */
public class TaskRunnerImpl implements _TaskRunner {
	
	private List _tasks;
	
	public TaskRunnerImpl(){
		super();
		_tasks = new LinkedList();
	}
	
	public TaskRunnerImpl(LinkedList tasks){
		_tasks.addAll(tasks);
	}

	public synchronized void addTask(_Task toAdd) throws ComponentBuildException {
		_tasks.add(toAdd);
		execute();
	}
	
	public synchronized void addTasks(Collection _tasksToAdd) throws ComponentBuildException {
		_tasks.addAll(_tasksToAdd);
		execute();
	}
	
	public synchronized void execute() throws ComponentBuildException{
		
		_Task current;
		for(Iterator iterate = _tasks.iterator(); iterate.hasNext();){
			current = (_Task) iterate.next();
			current.performTask();
		}
		clearAllTask();
	}
	
	private void clearAllTask(){
		_tasks.clear();
	}
	
}
