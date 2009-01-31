<%@ page session="false" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://jsf-flex.googlecode.com" prefix="jf"%>

<html>

<!--
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
//-->

<body>

<f:view renderKitId="MXML_BASIC">
    
    <h:form>
    	
    	<jf:mxmlApplication mxmlPackageName="mxmlToggleButtonBar" height="50%" width="50%">
    		<jf:mxmlToggleButtonBar>
    			<jf:mxmlDataProvider>
   					<jf:mxmlObject label="Flash" />
   					<jf:mxmlObject label="Director" />
   					<jf:mxmlObject label="Dreamweaver" />
   					<jf:mxmlObject label="ColdFusion" />
    			</jf:mxmlDataProvider>
    		</jf:mxmlToggleButtonBar>
    	</jf:mxmlApplication>
    	
    </h:form>
    
</f:view>

</body>

</html>
