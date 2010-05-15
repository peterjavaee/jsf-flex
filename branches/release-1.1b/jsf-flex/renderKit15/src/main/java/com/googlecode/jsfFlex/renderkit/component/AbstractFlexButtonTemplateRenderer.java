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
import java.util.EnumSet;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import com.googlecode.jsfFlex.renderkit.annotation.IJsfFlexAttribute;
import com.googlecode.jsfFlex.renderkit.annotation.IJsfFlexAttributeProperties;
import com.googlecode.jsfFlex.renderkit.flex.AbstractFlexResponseWriter;
import com.googlecode.jsfFlex.shared.adapter.IFlexEvent;
import com.googlecode.jsfFlex.shared.adapter.IFlexEvent.EVENT_HANDLER_TYPE;
import com.googlecode.jsfFlex.shared.adapter.IFlexEvent.EVENT_HANDLER_TYPE.ACTION_SCRIPT_IMPORT;
import com.googlecode.jsfFlex.shared.beans.additionalScriptContent.AdditionalApplicationScriptContent;
import com.googlecode.jsfFlex.shared.context.AbstractFlexContext;

/**
 * @author Ji Hoon Kim
 */
@IJsfFlexAttributeProperties(
		componentNodeAttributes={},

		jsfFlexAttributes={
				@IJsfFlexAttribute(attribute="autoRepeat"),
				@IJsfFlexAttribute(attribute="emphasized"),
                @IJsfFlexAttribute(attribute="fontContext"),
				@IJsfFlexAttribute(attribute="label"),
				@IJsfFlexAttribute(attribute="labelPlacement"),
				@IJsfFlexAttribute(attribute="selectedField"),
				@IJsfFlexAttribute(attribute="stickyHighlighting"),
				@IJsfFlexAttribute(attribute="toggle"),
				@IJsfFlexAttribute(attribute="borderColor"),
				@IJsfFlexAttribute(attribute="color"),
				@IJsfFlexAttribute(attribute="cornerRadius"),
				@IJsfFlexAttribute(attribute="disabledColor"),
				@IJsfFlexAttribute(attribute="disabledIcon"),
				@IJsfFlexAttribute(attribute="disabledSkin"),
				@IJsfFlexAttribute(attribute="downIcon"),
				@IJsfFlexAttribute(attribute="downSkin"),
				@IJsfFlexAttribute(attribute="fillAlphas"),
				@IJsfFlexAttribute(attribute="fillColors"),
				@IJsfFlexAttribute(attribute="focusAlpha"),
				@IJsfFlexAttribute(attribute="focusRoundedCorners"),
				@IJsfFlexAttribute(attribute="fontAntiAliasType"),
				@IJsfFlexAttribute(attribute="fontFamily"),
				@IJsfFlexAttribute(attribute="fontGridFitType"),
				@IJsfFlexAttribute(attribute="fontSharpness"),
				@IJsfFlexAttribute(attribute="fontSize"),
				@IJsfFlexAttribute(attribute="fontStyle"),
				@IJsfFlexAttribute(attribute="fontThickness"),
				@IJsfFlexAttribute(attribute="fontWeight"),
				@IJsfFlexAttribute(attribute="highlightAlphas"),
				@IJsfFlexAttribute(attribute="horizontalGap"),
				@IJsfFlexAttribute(attribute="icon"),
                @IJsfFlexAttribute(attribute="kerning"),
				@IJsfFlexAttribute(attribute="leading"),
                @IJsfFlexAttribute(attribute="letterSpacing"),
				@IJsfFlexAttribute(attribute="overIcon"),
				@IJsfFlexAttribute(attribute="overSkin"),
				@IJsfFlexAttribute(attribute="paddingBottom"),
				@IJsfFlexAttribute(attribute="paddingLeft"),
				@IJsfFlexAttribute(attribute="paddingRight"),
				@IJsfFlexAttribute(attribute="paddingTop"),
				@IJsfFlexAttribute(attribute="repeatDelay"),
				@IJsfFlexAttribute(attribute="repeatInterval"),
				@IJsfFlexAttribute(attribute="selectedDisabledIcon"),
				@IJsfFlexAttribute(attribute="selectedDisabledSkin"),
				@IJsfFlexAttribute(attribute="selectedDownIcon"),
				@IJsfFlexAttribute(attribute="selectedDownSkin"),
				@IJsfFlexAttribute(attribute="selectedOverIcon"),
				@IJsfFlexAttribute(attribute="selectedOverSkin"),
				@IJsfFlexAttribute(attribute="selectedUpIcon"),
				@IJsfFlexAttribute(attribute="selectedUpSkin"),
                @IJsfFlexAttribute(attribute="skin"),
				@IJsfFlexAttribute(attribute="textAlign"),
				@IJsfFlexAttribute(attribute="textDecoration"),
				@IJsfFlexAttribute(attribute="textIndent"),
				@IJsfFlexAttribute(attribute="textRollOverColor"),
				@IJsfFlexAttribute(attribute="textSelectedColor"),
				@IJsfFlexAttribute(attribute="upIcon"),
				@IJsfFlexAttribute(attribute="upSkin"),
				@IJsfFlexAttribute(attribute="verticalGap"),
				@IJsfFlexAttribute(attribute="buttonDown"),
				@IJsfFlexAttribute(attribute="change"),
				@IJsfFlexAttribute(attribute="dataChange")
		}
)
public abstract class AbstractFlexButtonTemplateRenderer extends AbstractFlexComponentRenderer {
	
	@Override
	public void encodeBegin(FacesContext context, UIComponent componentObj) throws IOException {
		super.encodeBegin(context, componentObj);
		
        AbstractFlexContext flexContext = AbstractFlexContext.getCurrentInstance();
		AbstractFlexResponseWriter writer = AbstractFlexResponseWriter.class.cast( context.getResponseWriter() );
		writer.mapFields(AbstractFlexButtonTemplateRenderer.class, componentObj, null);
		
		if(componentObj instanceof IFlexEvent){
            IFlexEvent flexEvent = IFlexEvent.class.cast( componentObj );
            EVENT_HANDLER_TYPE eventHandlerType = flexEvent.getEventHandlerType();
            AdditionalApplicationScriptContent additionalApplicationScriptContent = flexContext.getAdditionalAppScriptContent();
            EnumSet<ACTION_SCRIPT_IMPORT> actionScriptImports = eventHandlerType.getActionScriptImports();
            
            for(ACTION_SCRIPT_IMPORT currASImport : actionScriptImports){
                additionalApplicationScriptContent.addActionScriptImport(currASImport.getActionScriptImport());
            }
            
            additionalApplicationScriptContent.addEventHandler(flexEvent.getEventHandlerSrcId(), flexEvent.getEventHandlerTgtId(), flexEvent.getEventHandlerId(),
                    flexEvent.getEventHandlerType(), flexEvent.getEventHandlerEventName());
        }
        
	}
	
}
