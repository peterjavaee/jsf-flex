"""
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

/**
 * A very simple implementation of command execution
 * TODO: Implement it better later
 *
 * @author Ji Hoon Kim
 */
"""

from com.googlecode.jsfFlex.shared.tasks.jython import _JythonTaskPerformer

from threading import Thread
from subprocess import Popen

import time

class CommandExecuteTask(_JythonTaskPerformer):
	def __init__(self, command, arguments):
		self.commandExecute = arguments if arguments else []
		self.commandExecute.insert(0, command)
		
	def performTask(self):
		execute = Popen(self.commandExecute)
		executeThread = Thread(target=CommandExecuteTask.tillCompletion, args=(execute,))
		executeThread.start()
		executeThread.join()
		
	def tillCompletion(*arguments):
		executionProcess = arguments[0]
		while executionProcess.poll() == None:
			time.sleep(300)
	
	def __str__(self):
		print self.commandExecute.__str__()
	def __retr__(self):
		self.__str__(self)
	
	tillCompletion = staticmethod(tillCompletion)