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
 * A very simple implementation of deleting files/directories
 * TODO: Implement it better later
 *
 * @author Ji Hoon Kim
 */
"""

from com.googlecode.jsfFlex.shared.tasks.jython import _JythonTaskPerformer

import os

class DeleteTask(_JythonTaskPerformer):
	def __init__(self, deleteResource, isDirectory):
		self.__deleteResource = deleteResource
		self.__isDirectory = isDirectory
		
	def performTask(self):
		if self.__isDirectory:
			os.rmdir(self.__deleteResource)
		else:
			os.remove(self.__deleteResource)
			
	def __str__(self):
		print self.__deleteResource, self.__isDirectory
	def __retr__(self):
		self.__str__(self)