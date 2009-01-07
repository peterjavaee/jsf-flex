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
package com.googlecode.jsfFlex.examples.mxml.multipleRequestDataGridExample;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ji Hoon Kim
 */
public class MXMLMultipleRequestDataGridExampleBean implements Serializable {
	
	private static final long serialVersionUID = 1501524398537830947L;
	
	private static final String LARGE_DATA_STRING_DISPLAY_MESSAGE = "Displaying column data for ";
	
	private List _largeFirstColumnData;
	private List _largeSecondColumnData;
	
	public MXMLMultipleRequestDataGridExampleBean(){
		super();
		
		_largeFirstColumnData = new LinkedList();
		_largeSecondColumnData = new LinkedList();
		
		for(int i=0; i < 500; i ++){
			_largeFirstColumnData.add(LARGE_DATA_STRING_DISPLAY_MESSAGE + i);
			_largeSecondColumnData.add(Integer.valueOf(i));
		}
	}
	
	public List getLargeFirstColumnData() {
		return _largeFirstColumnData;
	}
	public void setLargeFirstColumnData(List largeFirstColumnData) {
		_largeFirstColumnData = largeFirstColumnData;
	}
	public List getLargeSecondColumnData() {
		return _largeSecondColumnData;
	}
	public void setLargeSecondColumnData(List largeSecondColumnData) {
		_largeSecondColumnData = largeSecondColumnData;
	}
	
}
