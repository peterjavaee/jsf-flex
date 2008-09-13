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
package com.googlecode.jsfFlex.renderkit;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.render.RenderKit;
import javax.faces.render.RenderKitFactory;

/**
 * @author Ji Hoon Kim
 */
public class MXMLRenderKitFactoryImpl extends RenderKitFactory {
	
	private static final String MXML_RENDER_KIT_ID = "MXML_BASIC";
	
	private final Map _renderKits;
	private final List _additionalRenderKitList;
	
	private MXMLRenderKitImplWrapper _mxmlRenderKit;
	
	public MXMLRenderKitFactoryImpl(){
		super();
		_renderKits = new HashMap();
		_additionalRenderKitList = new LinkedList();
	}
	
	public void addRenderKit(String renderKitId, RenderKit renderKit) {
		if(renderKitId == null){
			throw new NullPointerException("addRenderKit : renderKitId is null");
		}
		
		if(renderKit == null){
			throw new NullPointerException("addRenderKit : renderKit is null");
		}
		
		//HACK for now, TODO implement it better later
		if(renderKitId.equals(MXML_RENDER_KIT_ID)){
			_mxmlRenderKit = (MXMLRenderKitImplWrapper) renderKit;
			_mxmlRenderKit.addRenderKitList(_additionalRenderKitList);
			_additionalRenderKitList.clear();
		}else{
			
			if(_mxmlRenderKit != null){
				_mxmlRenderKit.addRenderKit(renderKit);
			}else{
				_additionalRenderKitList.add(renderKit);
			}
			
		}
		
		_renderKits.put(renderKitId, renderKit);
		
	}
	
	public RenderKit getRenderKit(FacesContext context, String renderKitId) {
		if(renderKitId == null){
			throw new NullPointerException("getRenderKit : renderKitId is null");
		}
		Object renderKit = _renderKits.get(renderKitId);
		
		return renderKit == null ? null : (RenderKit) renderKit;
	}
	
	public Iterator getRenderKitIds() {
		return _renderKits.keySet().iterator();
	}
	
}
