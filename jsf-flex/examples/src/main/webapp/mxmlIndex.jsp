<%--
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
  --%>

<%@ page session="false" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<head>
<style type="text/css">
.fieldDescription{
	color:#708090;
	font-family:verdana;
	font-size:14px;
	font-weight:700;
	text-align:center;
	text-decoration:underline;
	width:50%;
}

</style>
</head>

<f:view>
	<body>
	<div class="fieldDescription">Welcome to JSF Flex Project</div>
	<br>
	<h:panelGrid>
		<h:outputLink value="mxmlSimple/mxmlSimple.jsf">
			<f:verbatim>A page for testing a simple creation of mxmlApplication</f:verbatim>
		</h:outputLink>
		<h:outputLink value="overallExample/mxmlOverallExample.jsf">
			<f:verbatim>An overall example of the components</f:verbatim>
		</h:outputLink>
		<h:outputLink
			value="multipleRequestDataGridExample/mxmlMultipleRequestDataGridExample.jsf">
			<f:verbatim>An example demonstrating a data grid that performs multiple request for large data that is fetched asynchronously</f:verbatim>
		</h:outputLink>
	</h:panelGrid>
	</body>
</f:view>
