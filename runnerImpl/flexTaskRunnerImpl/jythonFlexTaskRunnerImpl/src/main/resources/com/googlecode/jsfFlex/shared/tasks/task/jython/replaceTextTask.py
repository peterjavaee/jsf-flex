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
 * A very simple implementation of replacing texts
 * TODO: Implement it better later
 *
 * @author Ji Hoon Kim
 */
"""

from com.googlecode.jsfFlex.shared.tasks.task.jython import _JythonTaskPerformer

import re
from renameTask import RenameTask

class ReplaceTextTask(_JythonTaskPerformer):
	def __init__(self, fileName, replaceDictionary, replaceAllOccurrence):
		self.__file = fileName
		self.__replaceDictionary = replaceDictionary
		self.__replaceAllOccurrence = replaceAllOccurrence
	
	"""
	TODO: Must implement it better in the future
	"""	
	def performTask(self):
		_replaceFileName = self.__file.split(".");
		_replaceFileName = ( _replaceFileName[0] + '.tmp' 
								if _replaceFileName and _replaceFileName.__len__() > 0 else _self.__file + 'tmp')
		
		__tempFile = open(_replaceFileName, 'w')
		fileReaderIter = ( self.__processInfo(lineContent) for lineContent in open(self.__file) )
		
		for content in fileReaderIter
			_tempFile.write(content)
		
		__tempFile.flush()
		__tempFile.close()
		_toRename = RenameTask(_replaceFileName, self.__file, 1)
		_toRename.performTask()
		
	def __processInfo(self, lineContent):
		for key in self.__replaceDictionary:
			if key:
				lineContent = re.sub(key, self.__replaceDictionary[key], lineContent, self.__replaceAllOccurrence)
		
		return lineContent
		
	def __str__(self):
		print self.__file, self.__replaceDictionary.__str__(), self.__replaceAllOccurrence.__str__()
	def __retr__(self):
		self.__str__(self)