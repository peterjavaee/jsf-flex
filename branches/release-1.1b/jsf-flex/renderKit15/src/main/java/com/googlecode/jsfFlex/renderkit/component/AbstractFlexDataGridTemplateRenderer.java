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
package com.googlecode.jsfFlex.renderkit.component;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import com.googlecode.jsfFlex.renderkit.annotation.IJsfFlexAttribute;
import com.googlecode.jsfFlex.renderkit.annotation.IJsfFlexAttributeProperties;
import com.googlecode.jsfFlex.renderkit.flex.AbstractFlexResponseWriter;

/**
 * @author Ji Hoon Kim
 */
@IJsfFlexAttributeProperties(
		componentNodeAttributes={},

		jsfFlexAttributes={
				@IJsfFlexAttribute(attribute="columns"),
				@IJsfFlexAttribute(attribute="draggableColumns"),
				@IJsfFlexAttribute(attribute="editable", byMethod=true),
				@IJsfFlexAttribute(attribute="editedItemPosition"),
				@IJsfFlexAttribute(attribute="horizontalScrollPosition"),
				@IJsfFlexAttribute(attribute="imeMode"),
				@IJsfFlexAttribute(attribute="itemEditorInstance"),
				@IJsfFlexAttribute(attribute="minColumnWidth"),
				@IJsfFlexAttribute(attribute="resizableColumns"),
				@IJsfFlexAttribute(attribute="sortableColumns"),
				@IJsfFlexAttribute(attribute="backgroundDisabledColor"),
				@IJsfFlexAttribute(attribute="columnDropIndicatorSkin"),
				@IJsfFlexAttribute(attribute="columnResizeSkin"),
				@IJsfFlexAttribute(attribute="headerColors"),
				@IJsfFlexAttribute(attribute="headerDragProxyStyleName"),
				@IJsfFlexAttribute(attribute="headerSeparatorSkin"),
				@IJsfFlexAttribute(attribute="headerStyleName"),
				@IJsfFlexAttribute(attribute="horizontalGridLineColor"),
				@IJsfFlexAttribute(attribute="horizontalGridLines"),
                @IJsfFlexAttribute(attribute="horizontalLockedSeparatorSkin"),
                @IJsfFlexAttribute(attribute="horizontalSeparatorSkin"),
                @IJsfFlexAttribute(attribute="iconColor"),
				@IJsfFlexAttribute(attribute="rollOverColor"),
				@IJsfFlexAttribute(attribute="selectionColor"),
				@IJsfFlexAttribute(attribute="sortArrowSkin"),
				@IJsfFlexAttribute(attribute="stretchCursor"),
				@IJsfFlexAttribute(attribute="verticalGridLineColor"),
				@IJsfFlexAttribute(attribute="verticalGridLines"),
                @IJsfFlexAttribute(attribute="verticalLockedSeparatorSkin"),
                @IJsfFlexAttribute(attribute="verticalSeparatorSkin"),
				@IJsfFlexAttribute(attribute="columnStretch"),
				@IJsfFlexAttribute(attribute="headerRelease"),
				@IJsfFlexAttribute(attribute="headerShift"),
				@IJsfFlexAttribute(attribute="itemEditBegin"),
                @IJsfFlexAttribute(attribute="itemEditBeginning"),
				@IJsfFlexAttribute(attribute="itemEditEnd"),
				@IJsfFlexAttribute(attribute="itemFocusIn"),
				@IJsfFlexAttribute(attribute="itemFocusOut")
		}
)
public abstract class AbstractFlexDataGridTemplateRenderer extends AbstractFlexDataGridBaseTemplateRenderer {
	
	@Override
	public void encodeBegin(FacesContext context, UIComponent componentObj) throws IOException {
		super.encodeBegin(context, componentObj);
		
		AbstractFlexResponseWriter writer = AbstractFlexResponseWriter.class.cast( context.getResponseWriter() );
		writer.mapFields(AbstractFlexDataGridTemplateRenderer.class, componentObj, null);
		
	}
	
}
