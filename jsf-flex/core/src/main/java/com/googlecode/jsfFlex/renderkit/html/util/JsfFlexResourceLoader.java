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
package com.googlecode.jsfFlex.renderkit.html.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.myfaces.renderkit.html.util.DefaultResourceProvider;
import org.apache.myfaces.renderkit.html.util.MyFacesResourceLoader;
import org.apache.myfaces.renderkit.html.util.ResourceLoader;
import org.apache.myfaces.renderkit.html.util.ResourceProvider;

/**
 * This code is basically the replica of the MyFaces MyFacesResourceLoader, except the lack of private 
 * lastModified method check. 
 * 
 * TODO: Implement this better later when free time.
 * 
 * @author Ji Hoon Kim
 */
public class JsfFlexResourceLoader extends MyFacesResourceLoader implements ResourceLoader {
	
	private static final Log log = LogFactory.getLog(JsfFlexResourceLoader.class);
	
	static final String JSF_FLEX_COMP = "com.googlecode.jsfFlex";
	
	public void serveResource(ServletContext context, HttpServletRequest request,
            HttpServletResponse response, String resourceUri) throws IOException {
		
		String[] uriParts = resourceUri.split("/", 2);
		String component = uriParts[0];
        
		if (component == null || component.trim().length() == 0){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid request");
            log.error("Could not find parameter for component to load a resource.");
            return;
        }
        
        Class componentClass;
        String className = JSF_FLEX_COMP + "." + component;
        
        try{
            componentClass = loadComponentClass(className);
        }catch (ClassNotFoundException e){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
            log.error("Could not find the class for component " + className + " to load a resource.");
            return;
        }
        
        String resource = uriParts[1];
        if (resource == null || resource.trim().length() == 0){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "No resource defined");
            log.error("No resource defined component class " + className);
            return;
        }

        InputStream is = null;

        try{
			
        	ResourceProvider resourceProvider;
			if (ResourceProvider.class.isAssignableFrom(componentClass)){
				
				try{
					resourceProvider = (ResourceProvider) componentClass.newInstance();
				}catch (InstantiationException e){
					response.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE, "Unable to instantiate resource provider for resource "
							+ resource + " for component " + component);
					log.error("Unable to instantiate resource provider for resource " + resource + " for component " + component, e);
					return;
				}catch (IllegalAccessException e){
					response.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE, "Unable to instantiate resource provider for resource "
							+ resource + " for component " + component);
					log.error("Unable to instantiate resource provider for resource " + resource + " for component " + component, e);
					return;
				}
				
			}else{
				resourceProvider = new DefaultResourceProvider(componentClass);
			}

			if (!resourceProvider.exists(context, resource)){
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Unable to find resource "
                        + resource + " for component " + component
                        + ". Check that this file is available " + "in the classpath in sub-directory "
                        + "/resource of the package-directory.");
                
                log.error("Unable to find resource " + resource + " for component " + component
                        + ". Check that this file is available " + "in the classpath in sub-directory "
                        + "/resource of the package-directory.");
            }else{
				
            	long lastModified = resourceProvider.getLastModified(context, resource);
				long browserDate = request.getDateHeader("If-Modified-Since");
				
				if (browserDate > -1){
					// normalize to seconds - this should work with any os
					lastModified = (lastModified / 1000) * 1000;
					browserDate = (browserDate / 1000) * 1000;
					if (lastModified == browserDate){
						// the browser already has the correct version
						response.setStatus(HttpURLConnection.HTTP_NOT_MODIFIED);
						return;
					}
				}

				int contentLength = resourceProvider.getContentLength(context, resource);
				String contentEncoding = resourceProvider.getEncoding(context, resource);

				is = resourceProvider.getInputStream(context, resource);

				defineContentHeaders(request, response, resource, contentLength, contentEncoding);
                defineCaching(request, response, resource, lastModified);
                writeResource(request, response, is);
            }
        }finally{
        	
        }
	}
	
}
