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
package com.googlecode.jsfFlex.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Ji Hoon Kim
 */
public final class JsfFlexHttpServiceServlet extends HttpServlet {
	
	private static final long serialVersionUID = 0L;
	
	private static final String COMPONENT_ID = "componentId";
	private static final String METHOD_TO_INVOKE = "methodToInvoke";
	private static final String SERVLET_RETURN_METHOD = "servletReturnMethod";
	
	private static final String SERVLET_NAME_VALUE_RESULT_FORMAT = "nameValue";
	private static final String SERVLET_RAW_RESULT_FORMAT = "raw";
	private static final String SERVLET_XML_RESULT_FORMAT = "xml";
	
	private static final _ServiceRequestDataRetrieverFlusher NAME_VALUE_SERVICE_REQUEST_DATA_RETRIEVER_FLUSHER = new NameValueServiceRequestDataRetrieverFlusher();
	private static final _ServiceRequestDataRetrieverFlusher RAW_SERVICE_REQUEST_DATA_RETRIEVER_FLUSHER = new RawServiceRequestDataRetrieverFlusher();
	private static final _ServiceRequestDataRetrieverFlusher XML_SERVICE_REQUEST_DATA_RETRIEVER_FLUSHER = new XMLServiceRequestDataRetrieverFlusher();
	
	public void init() throws ServletException {
		super.init();
	}
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	
	/* 
	 * This method will be used to delete information with JSON content
	 * (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doDelete(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doDelete(request, response);
	}
	
	/* 
	 * This method will be used to retrieve information with JSON content
	 * (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		String componentId = request.getParameter(COMPONENT_ID);
		String methodToInvoke = request.getParameter(METHOD_TO_INVOKE);
		String servletReturnMethod = request.getParameter(SERVLET_RETURN_METHOD);
		
		_ServiceRequestDataRetrieverFlusher serviceRequestDataRetrieverFlusher = null;
		
		if(servletReturnMethod.equals(SERVLET_NAME_VALUE_RESULT_FORMAT)){
			serviceRequestDataRetrieverFlusher = NAME_VALUE_SERVICE_REQUEST_DATA_RETRIEVER_FLUSHER;
		}else if(servletReturnMethod.equals(SERVLET_RAW_RESULT_FORMAT)){
			serviceRequestDataRetrieverFlusher = RAW_SERVICE_REQUEST_DATA_RETRIEVER_FLUSHER;
		}else if(servletReturnMethod.equals(SERVLET_XML_RESULT_FORMAT)){
			serviceRequestDataRetrieverFlusher = XML_SERVICE_REQUEST_DATA_RETRIEVER_FLUSHER;
		}
		
		serviceRequestDataRetrieverFlusher.retrieveFlushData(response, componentId, methodToInvoke);
		
	}
	
	/* 
	 * This method will be used to update information with JSON content
	 * (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}
	
	/* 
	 * This method will be used to add information with JSON content
	 * (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPut(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPut(request, response);
	}
	
}
