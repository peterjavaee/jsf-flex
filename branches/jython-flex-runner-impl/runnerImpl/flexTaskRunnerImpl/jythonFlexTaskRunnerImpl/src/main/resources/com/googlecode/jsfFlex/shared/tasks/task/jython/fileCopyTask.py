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
 * A very simple implementation of performing copy tasks
 * TODO: Implement it better later
 * When moving to python >= 2.6, include ignore_patterns to shutil.copytree 
 * Meaning there currently does not exist support for filtering of file types
 * If jython implementation will take a bit of time in its implementation, 
 * consider implementing it here
 *
 * @author Ji Hoon Kim
 */
"""

from com.googlecode.jsfFlex.shared.tasks.task.jython import _JythonTaskPerformer

import os
import shutil

class FileCopyTask(_JythonTaskPerformer):
	def __init__(self, copyFile, copyDirParameters, copyTo):
		self.__copyFile = copyFile
		self.__copyDirParameters = copyDirParameters
		self.__copyTo = copyTo
		
	def performTask(self):
		if self.__copyFile:
			shutil.copy2(self.__copyFile, self.__copyTo)
		elif self.__copyDirParameters and self.__copyDirParameters.__len__() > 0:
			shutil.copytree(self.__copyDirParameters[0], self.__copyTo)
			
	def __str__(self):
		print self.__copyFile, self.__copyDirParameters.__str__(), self.__copyTo
	def __retr__(self):
		self.__str__(self)