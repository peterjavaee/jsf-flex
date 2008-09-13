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
package com.googlecode.jsfFlex.taglib.ext;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;

import com.googlecode.jsfFlex.shared.util.MXMLConstants;

/**
 * The reason that this tag is created rather than having myfaces plug-In generate it<br>
 * is because of the need to capture the contents of the JSP tag as an attribute of<br>
 * MXMLConstants.TAG_BODY_CONTENT_ATTR. This will enable writing of ActionScript contents<br>
 * as body of mxmlScript JSP tag.
 * 
 * @author Ji Hoon Kim
 */
public class MXMLUIScriptTag extends javax.faces.webapp.UIComponentBodyTag {
	
	private String _scriptContent;

	public String getComponentType() {
		return com.googlecode.jsfFlex.component.ext.MXMLUIScript.COMPONENT_TYPE;
	}

	public String getRendererType() {
		return com.googlecode.jsfFlex.component.ext.MXMLUIScript.DEFAULT_RENDERER_TYPE;
	}
	
	public int doStartTag() throws JspException
    {
        super.doStartTag();
        return BodyTag.EVAL_BODY_BUFFERED;
    }
	
	public int doAfterBody() throws JspException
    {
		BodyContent bodyContent = getBodyContent();
        if (bodyContent != null)
        {
        	setScriptContent(bodyContent.getString());
        	bodyContent.clearBody();
        	getComponentInstance().getAttributes().put(MXMLConstants.TAG_BODY_CONTENT_ATTR, _scriptContent);
        }
        return super.doAfterBody();
    }
	
	public void release() {
		super.release();
		
		_scriptContent = null;
		
	}
	
	public String getScriptContent() {
		return _scriptContent;
	}
	public void setScriptContent(String scriptContent) {
		_scriptContent = scriptContent;
	}

}
