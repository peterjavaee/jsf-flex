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
package com.googlecode.jsfFlex.renderkit.ext;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.apache.myfaces.shared_tomahawk.renderkit.html.HTML;

import com.googlecode.jsfFlex.renderkit.MXMLRendererBase;

/**
 * @JSFRenderer 
 *   renderKitId = "MXML_BASIC" 
 *   family      = "javax.faces.MXMLInput"
 *   type        = "com.googlecode.jsfFlex.MXMLInput"
 * 
 * This renderer should be used for components that do require preservation of values.<br>
 * In another words, components that ultimately extend from MXMLUIInputBase [i.e. AbstractMXMLUIRichTextEditor].<br>
 * The main difference between this renderer and MXMLSimpleBaseRenderer is that this renderer creates html components<br>
 * to avoid having javascript error.<br>
 * 
 * @author Ji Hoon Kim
 */
public class MXMLInputRenderer extends MXMLRendererBase{
	
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		super.encodeEnd(context, component);
		//Just to make the Javascript for Tomahawk happy
		ResponseWriter writer = context.getResponseWriter();
		writer.startElement(HTML.INPUT_ELEM, component);
		writer.writeAttribute(HTML.ID_ATTR, component.getClientId(context), null);
		writer.writeAttribute(HTML.STYLE_ATTR, "display:none", null);
		writer.endElement(HTML.INPUT_ELEM);
	
	}
	
}
