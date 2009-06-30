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
package com.googlecode.jsfFlex.renderkit.component.ext;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFRenderer;

import com.googlecode.jsfFlex.renderkit.annotation.FlexComponentNodeAttribute;
import com.googlecode.jsfFlex.renderkit.annotation.JsfFlexAttribute;
import com.googlecode.jsfFlex.renderkit.annotation.JsfFlexAttributeProperties;
import com.googlecode.jsfFlex.renderkit.component.MXMLContainerTemplateRenderer;
import com.googlecode.jsfFlex.renderkit.mxml.AbstractMXMLResponseWriter;
import com.googlecode.jsfFlex.shared.adapter._MXMLContract;

/**
 * @author Ji Hoon Kim
 */
@JSFRenderer(
		renderKitId="MXML_BASIC",
		family="javax.faces.MXMLInput",
		type="com.googlecode.jsfFlex.MXMLAccordion"
)
@JsfFlexAttributeProperties(
		mxmlComponentPackage="mx.containers",
		mxmlComponentName="Accordion",
		mxmlComponentNodeAttributes={
				@FlexComponentNodeAttribute(
						htmlType="input", 
						typeAttributeValue="hidden", 
						valueAttributeValue="selectedIndex",
						isValueDynamic=true,
						isValueNested=false,
						valueNestedValues={},
						nameAttributeValue="id",
						isNameDynamic=true,
						nameAppend="_selectedIndex")
		},

		jsfFlexAttributes={
				@JsfFlexAttribute(attribute="headerRenderer"),
				@JsfFlexAttribute(attribute="historyManagementEnabled"),
				@JsfFlexAttribute(attribute="resizeToContent"),
				@JsfFlexAttribute(attribute="fillAlphas"),
				@JsfFlexAttribute(attribute="fillColors"),
				@JsfFlexAttribute(attribute="focusAlpha"),
				@JsfFlexAttribute(attribute="focusRoundedCorners"),
				@JsfFlexAttribute(attribute="headerHeight"),
				@JsfFlexAttribute(attribute="headerStyleName"),
				@JsfFlexAttribute(attribute="horizontalGap"),
				@JsfFlexAttribute(attribute="openDuration"),
				@JsfFlexAttribute(attribute="openEasingFunction"),
				@JsfFlexAttribute(attribute="selectedFillColors"),
				@JsfFlexAttribute(attribute="textRollOverColor"),
				@JsfFlexAttribute(attribute="textSelectedColor"),
				@JsfFlexAttribute(attribute="verticalGap"),
				@JsfFlexAttribute(attribute="change")
		}
)
public final class MXMLAccordionRenderer extends MXMLContainerTemplateRenderer {
	
	@Override
	public void encodeBegin(FacesContext context, UIComponent componentObj) throws IOException {
		super.encodeBegin(context, componentObj);
		
		_MXMLContract componentMXML = (_MXMLContract) componentObj;
		
		AbstractMXMLResponseWriter writer = (AbstractMXMLResponseWriter) context.getResponseWriter();
		writer.mapFields(MXMLAccordionRenderer.class, componentObj, null);
		writer.createPreMxml(componentMXML, MXMLAccordionRenderer.class.getAnnotation(JsfFlexAttributeProperties.class).mxmlComponentName(), 
				null);
		
	}
	
}
