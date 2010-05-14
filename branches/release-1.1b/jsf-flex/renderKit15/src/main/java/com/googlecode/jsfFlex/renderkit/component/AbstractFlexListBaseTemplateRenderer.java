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
				@IJsfFlexAttribute(attribute="allowDragSelection"),
				@IJsfFlexAttribute(attribute="allowMultipleSelection"),
				@IJsfFlexAttribute(attribute="columnCount"),
				@IJsfFlexAttribute(attribute="columnWidth"),
				@IJsfFlexAttribute(attribute="dataProvider", byMethod=true),
				@IJsfFlexAttribute(attribute="dataTipField"),
				@IJsfFlexAttribute(attribute="dataTipFunction"),
				@IJsfFlexAttribute(attribute="dragEnabled"),
				@IJsfFlexAttribute(attribute="dragMoveEnabled"),
				@IJsfFlexAttribute(attribute="dropEnabled"),
				@IJsfFlexAttribute(attribute="iconField"),
				@IJsfFlexAttribute(attribute="iconFunction"),
				@IJsfFlexAttribute(attribute="itemRenderer"),
				@IJsfFlexAttribute(attribute="labelField"),
				@IJsfFlexAttribute(attribute="labelFunction"),
                @IJsfFlexAttribute(attribute="lockedColumnCount"),
                @IJsfFlexAttribute(attribute="lockedRowCount"),
				@IJsfFlexAttribute(attribute="menuSelectionMode"),
                @IJsfFlexAttribute(attribute="offscreenExtraRowsOrColumns"),
				@IJsfFlexAttribute(attribute="rowCount", byMethod=true),
				@IJsfFlexAttribute(attribute="rowHeight"),
				@IJsfFlexAttribute(attribute="selectable"),
				@IJsfFlexAttribute(attribute="selectedIndex", byMethod=true),
				@IJsfFlexAttribute(attribute="selectedIndices"),
				@IJsfFlexAttribute(attribute="selectedItem"),
				@IJsfFlexAttribute(attribute="selectedItems"),
				@IJsfFlexAttribute(attribute="showDataTips"),
				@IJsfFlexAttribute(attribute="variableRowHeight"),
				@IJsfFlexAttribute(attribute="wordWrap"),
				@IJsfFlexAttribute(attribute="alternatingItemColors"),
				@IJsfFlexAttribute(attribute="dropIndicatorSkin"),
				@IJsfFlexAttribute(attribute="focusAlpha"),
				@IJsfFlexAttribute(attribute="focusRoundedCorners"),
				@IJsfFlexAttribute(attribute="paddingBottom"),
				@IJsfFlexAttribute(attribute="paddingLeft"),
				@IJsfFlexAttribute(attribute="paddingRight"),
				@IJsfFlexAttribute(attribute="paddingTop"),
				@IJsfFlexAttribute(attribute="rollOverColor"),
				@IJsfFlexAttribute(attribute="selectionColor"),
				@IJsfFlexAttribute(attribute="selectionDisabledColor"),
				@IJsfFlexAttribute(attribute="selectionDuration"),
				@IJsfFlexAttribute(attribute="selectionEasingFunction"),
				@IJsfFlexAttribute(attribute="textRollOverColor"),
				@IJsfFlexAttribute(attribute="textSelectedColor"),
				@IJsfFlexAttribute(attribute="useRollOver"),
				@IJsfFlexAttribute(attribute="verticalAlign"),
				@IJsfFlexAttribute(attribute="change"),
				@IJsfFlexAttribute(attribute="dataChange"),
				@IJsfFlexAttribute(attribute="itemDoubleClick"),
				@IJsfFlexAttribute(attribute="itemRollOut"),
				@IJsfFlexAttribute(attribute="itemRollOver"),
				@IJsfFlexAttribute(attribute="itemClick")
		}
)
public abstract class AbstractFlexListBaseTemplateRenderer extends AbstractFlexScrollControlTemplateRenderer {
	
	@Override
	public void encodeBegin(FacesContext context, UIComponent componentObj) throws IOException {
		super.encodeBegin(context, componentObj);
		
		AbstractFlexResponseWriter writer = AbstractFlexResponseWriter.class.cast( context.getResponseWriter() );
		writer.mapFields(AbstractFlexListBaseTemplateRenderer.class, componentObj, null);
		
	}
	
}
