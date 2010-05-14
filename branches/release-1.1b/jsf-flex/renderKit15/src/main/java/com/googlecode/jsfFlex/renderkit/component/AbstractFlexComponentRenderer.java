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
				@IJsfFlexAttribute(attribute="id", byMethod=true),
                @IJsfFlexAttribute(attribute="automationName"),
				@IJsfFlexAttribute(attribute="cachePolicy"),
				@IJsfFlexAttribute(attribute="currentState"),
				@IJsfFlexAttribute(attribute="doubleClickEnabled"),
				@IJsfFlexAttribute(attribute="enabled"),
				@IJsfFlexAttribute(attribute="explicitHeight"),
				@IJsfFlexAttribute(attribute="explicitMaxHeight"),
				@IJsfFlexAttribute(attribute="explicitMaxWidth"),
				@IJsfFlexAttribute(attribute="explicitMinHeight"),
				@IJsfFlexAttribute(attribute="explicitMinWidth"),
				@IJsfFlexAttribute(attribute="explicitWidth"),
				@IJsfFlexAttribute(attribute="focusEnabled"),
				@IJsfFlexAttribute(attribute="height"),
				@IJsfFlexAttribute(attribute="includeInLayout"),
				@IJsfFlexAttribute(attribute="maxHeight"),
				@IJsfFlexAttribute(attribute="maxWidth"),
				@IJsfFlexAttribute(attribute="measuredHeight"),
				@IJsfFlexAttribute(attribute="measuredMinHeight"),
				@IJsfFlexAttribute(attribute="measuredMinWidth"),
				@IJsfFlexAttribute(attribute="measuredWidth"),
				@IJsfFlexAttribute(attribute="minHeight"),
				@IJsfFlexAttribute(attribute="minWidth"),
				@IJsfFlexAttribute(attribute="mouseFocusEnabled"),
				@IJsfFlexAttribute(attribute="percentHeight"),
				@IJsfFlexAttribute(attribute="percentWidth"),
				@IJsfFlexAttribute(attribute="scaleX"),
				@IJsfFlexAttribute(attribute="scaleY"),
				@IJsfFlexAttribute(attribute="states"),
				@IJsfFlexAttribute(attribute="styleName"),
				@IJsfFlexAttribute(attribute="toolTip"),
				@IJsfFlexAttribute(attribute="transitions"),
				@IJsfFlexAttribute(attribute="validationSubField"),
				@IJsfFlexAttribute(attribute="width"),
				@IJsfFlexAttribute(attribute="x"),
				@IJsfFlexAttribute(attribute="y"),
				@IJsfFlexAttribute(attribute="bottom"),
				@IJsfFlexAttribute(attribute="errorColor"),
				@IJsfFlexAttribute(attribute="focusBlendMode"),
				@IJsfFlexAttribute(attribute="focusSkin"),
				@IJsfFlexAttribute(attribute="focusThickness"),
				@IJsfFlexAttribute(attribute="horizontalCenter"),
				@IJsfFlexAttribute(attribute="left"),
				@IJsfFlexAttribute(attribute="right"),
				@IJsfFlexAttribute(attribute="themeColor"),
				@IJsfFlexAttribute(attribute="top"),
				@IJsfFlexAttribute(attribute="verticalCenter"),
				@IJsfFlexAttribute(attribute="addedEffect"),
				@IJsfFlexAttribute(attribute="creationCompleteEffect"),
				@IJsfFlexAttribute(attribute="focusInEffect"),
				@IJsfFlexAttribute(attribute="focusOutEffect"),
				@IJsfFlexAttribute(attribute="hideEffect"),
				@IJsfFlexAttribute(attribute="mouseDownEffect"),
				@IJsfFlexAttribute(attribute="mouseUpEffect"),
				@IJsfFlexAttribute(attribute="moveEffect"),
				@IJsfFlexAttribute(attribute="removedEffect"),
				@IJsfFlexAttribute(attribute="resizeEffect"),
				@IJsfFlexAttribute(attribute="rollOutEffect"),
				@IJsfFlexAttribute(attribute="rollOverEffect"),
				@IJsfFlexAttribute(attribute="showEffect"),
				@IJsfFlexAttribute(attribute="add"),
				@IJsfFlexAttribute(attribute="creationComplete"),
				@IJsfFlexAttribute(attribute="currentStateChange"),
				@IJsfFlexAttribute(attribute="currentStateChanging"),
				@IJsfFlexAttribute(attribute="dragComplete"),
				@IJsfFlexAttribute(attribute="dragDrop"),
				@IJsfFlexAttribute(attribute="dragEnter"),
				@IJsfFlexAttribute(attribute="dragExit"),
				@IJsfFlexAttribute(attribute="dragOver"),
				@IJsfFlexAttribute(attribute="effectEnd"),
				@IJsfFlexAttribute(attribute="effectStart"),
				@IJsfFlexAttribute(attribute="enterState"),
				@IJsfFlexAttribute(attribute="exitState"),
				@IJsfFlexAttribute(attribute="hide"),
				@IJsfFlexAttribute(attribute="initialize"),
				@IJsfFlexAttribute(attribute="invalid"),
				@IJsfFlexAttribute(attribute="mouseDownOutside"),
				@IJsfFlexAttribute(attribute="mouseWheelOutside"),
				@IJsfFlexAttribute(attribute="move"),
				@IJsfFlexAttribute(attribute="preinitialize"),
				@IJsfFlexAttribute(attribute="record"),
				@IJsfFlexAttribute(attribute="remove"),
				@IJsfFlexAttribute(attribute="resize"),
				@IJsfFlexAttribute(attribute="show"),
				@IJsfFlexAttribute(attribute="toolTipCreate"),
				@IJsfFlexAttribute(attribute="toolTipEnd"),
				@IJsfFlexAttribute(attribute="toolTipHide"),
				@IJsfFlexAttribute(attribute="toolTipShow"),
				@IJsfFlexAttribute(attribute="toolTipShown"),
				@IJsfFlexAttribute(attribute="toolTipStart"),
				@IJsfFlexAttribute(attribute="updateComplete"),
				@IJsfFlexAttribute(attribute="valid"),
				@IJsfFlexAttribute(attribute="valueCommit")
		}
)
public abstract class AbstractFlexComponentRenderer extends AbstractFlexComponentBaseRenderer {
	
	@Override
	public void encodeBegin(FacesContext context, UIComponent componentObj) throws IOException {
		super.encodeBegin(context, componentObj);
		
		AbstractFlexResponseWriter writer = AbstractFlexResponseWriter.class.cast( context.getResponseWriter() );
		writer.mapFields(AbstractFlexComponentRenderer.class, componentObj, null);
		
	}
	
}
