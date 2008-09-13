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

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.ResponseStream;
import javax.faces.context.ResponseWriter;
import javax.faces.render.RenderKit;
import javax.faces.render.Renderer;
import javax.faces.render.ResponseStateManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.myfaces.shared_impl.renderkit.html.HtmlRendererUtils;

import com.googlecode.jsfFlex.renderkit.mxml.MXMLResponseStateManager;
import com.googlecode.jsfFlex.renderkit.mxml.MXMLResponseWriterImpl;

/**
 * @author Ji Hoon Kim
 */
public class MXMLRenderKitImpl extends RenderKit {
	
	private static final Log _log = LogFactory.getLog(MXMLRenderKitImpl.class);
	
	private Map _renderers;
	private ResponseStateManager _responseStateManager;
	
	public MXMLRenderKitImpl(){
		super();
		_renderers = new HashMap();
		_responseStateManager = new MXMLResponseStateManager();
	}
	
	public void addRenderer(String family, String rendererType, Renderer renderer) {
		if(family == null){
			throw new NullPointerException("addRenderer: component family must not be null");
		}
		if(rendererType == null){
			throw new NullPointerException("addRenderer: rendererType must not be null");
		}
		
		Object _rendererTypeObject;
		Map _rendererTypeMap;
		/*
		 * Since there exists many rendererType for a single family
		 */
		if((_rendererTypeObject = _renderers.get(family)) != null){
			_rendererTypeMap = (Map) _rendererTypeObject;
			_rendererTypeMap.put(rendererType, renderer);
		}else{
			_rendererTypeMap = new HashMap();
			_rendererTypeMap.put(rendererType, renderer);
			_renderers.put(family, _rendererTypeMap);
		}
		
	}
	
	public Renderer getRenderer(String family, String rendererType) {
		if(family == null){
			throw new NullPointerException("getRenderer: component family must not be null");
		}
		if(rendererType == null){
			throw new NullPointerException("getRenderer: rendererType must not be null");
		}
		
		Renderer _renderer = null;
		Object _rendererTypeObject = _renderers.get(family);
		if(_rendererTypeObject == null){
			_log.info("Empty entry within getRenderes for family [ " + family + " ] rendererType [ " + rendererType + " ] ");
		}else{
			Map _rendererTypeMap = (Map) _rendererTypeObject;
			Object _rendererObject;
			_renderer = (_rendererObject = _rendererTypeMap.get(rendererType)) != null ? (Renderer) _rendererObject : null; 
		}
		
		return _renderer;
	}
	
	public ResponseStream createResponseStream(final OutputStream outPutStream) {
		
		return new ResponseStream(){
					
					public void write(int b) throws IOException {
						outPutStream.write(b);
		            }
					
		            public void write(byte b[]) throws IOException {
		            	outPutStream.write(b);
		            }
		            
		            public void write(byte b[], int off, int len) throws IOException {
		            	outPutStream.write(b, off, len);
		            }
		            
		            public void flush() throws IOException {
		            	outPutStream.flush();
		            }
		            
		            public void close() throws IOException {
		            	outPutStream.close();
		            }
						
				};
	}
	
	public ResponseWriter createResponseWriter(Writer writer, String contentTypeListString, String characterEncoding){
		String selectedContentType = HtmlRendererUtils.selectContentType(contentTypeListString);

        if(characterEncoding==null)
        {
            characterEncoding = HtmlRendererUtils.DEFAULT_CHAR_ENCODING;
        }

        return new MXMLResponseWriterImpl(writer, selectedContentType, characterEncoding);
	}

	public ResponseStateManager getResponseStateManager() {
		return _responseStateManager;
	}

}
