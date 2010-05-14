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

import com.googlecode.jsfFlex.renderkit.FlexRendererBase;
import com.googlecode.jsfFlex.renderkit.flex.AbstractFlexResponseWriter;
import com.googlecode.jsfFlex.shared.adapter.IFlexContract;
import com.googlecode.jsfFlex.shared.context.AbstractFlexContext;

/**
 * @author Ji Hoon Kim
 */
public abstract class AbstractFlexComponentBaseRenderer extends FlexRendererBase {
	
	@Override
	public void encodeEnd(FacesContext context, UIComponent componentObj) throws IOException {
		super.encodeEnd(context, componentObj);
		
		AbstractFlexContext mxmlContext = AbstractFlexContext.getCurrentInstance();
		if(mxmlContext.isProductionEnv()){
			return;
		}
		
		IFlexContract componentFlex = IFlexContract.class.cast( componentObj );
		AbstractFlexResponseWriter writer = AbstractFlexResponseWriter.class.cast( context.getResponseWriter() );
		
		writer.getFlexTaskRunner().writeBodyContent(componentFlex);
        
	}
	
}
