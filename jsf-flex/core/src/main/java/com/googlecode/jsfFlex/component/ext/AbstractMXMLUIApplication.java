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
package com.googlecode.jsfFlex.component.ext;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.apache.myfaces.custom.dojo.DojoConfig;
import org.apache.myfaces.custom.dojo.DojoUtils;
import org.apache.myfaces.renderkit.html.util.AddResource;
import org.apache.myfaces.renderkit.html.util.AddResourceFactory;

import com.googlecode.jsfFlex.component.MXMLUISimpleBase;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBackgroundAlphaAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBackgroundAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBackgroundColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBackgroundDisabledColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBarColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBorderAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBorderColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBorderThicknessAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUICornerRadiusAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDataChangeAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDisabledColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFontGeneralAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFontSpecificAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFontFamilyAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIGapAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIHideAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIHorizontalAlignAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIHorizontalScrollPositionAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIIconAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUILabelAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUILayoutAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIModalAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIPaddingHorizontalAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIPaddingVerticalAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIScrollAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIScrollAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIScrollBarAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIShadowAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUITextStyleAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIThumbSkinAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUITitleAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUITrackAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIVerticalAlignAttribute;
import com.googlecode.jsfFlex.component.attributes.compBase._MXMLUIBaseAttributes;
import com.googlecode.jsfFlex.component.attributes.compBase._MXMLUIContainerAttributes;
import com.googlecode.jsfFlex.framework.context.MxmlContext;
import com.googlecode.jsfFlex.framework.context.MxmlContextImpl;
import com.googlecode.jsfFlex.framework.util.MXMLConstants;
import com.googlecode.jsfFlex.renderkit.MXML;
import com.googlecode.jsfFlex.renderkit.html.util.JsfFlexResourceHandler;
import com.googlecode.jsfFlex.shared.adapter._MXMLApplicationContract;
import com.googlecode.jsfFlex.util.MXMLJsfUtil;

/**
 * @JSFComponent
 *   name     = "jf:mxmlApplication"
 *   class    = "com.googlecode.jsfFlex.component.ext.MXMLUIApplication"
 *   family   = "javax.faces.MXMLApplication"
 *   type     = "com.googlecode.jsfFlex.MXMLUIApplication"
 *   tagClass = "com.googlecode.jsfFlex.taglib.ext.MXMLUIApplicationTag"
 *   tagSuperclass = "org.apache.myfaces.shared_impl.taglib.UIComponentTagBase"
 *   defaultRendererType= "com.googlecode.jsfFlex.MXMLApplication"
 *   
 * @JSFJspProperties
 * 		properties	=		
 *   						@JSFJspProperty
 * 							 name		= "controlBar"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The ApplicationControlBar for this Application."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "frameRate"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Specifies the frame rate of the application."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "pageTitle"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Specifies a string that appears in the title bar of the browser."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "preloader"
 *   						 returnType	= "java.lang.String" 
 *   						 longDesc	= "Specifies the path of a SWC component class or ActionScript component class that defines a custom progress bar."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "resetHistory"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "If true, the application's history state is reset to its initial state whenever the application is reloaded."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "scriptRecursionLimit"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Specifies the maximum depth of the Adobe Flash Player call stack before Flash Player stops."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "scriptTimeLimit"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Specifies the maximum duration, in seconds, that an ActionScript event handler can execute beforethe Flash Player assumes that it is hung, and aborts it."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "usePreloader"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "If true, specifies to display the application preloader."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "viewSourceURL"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "URL where the application's source can be viewed."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "xmlnsMX"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Namespace."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "backgroundGradientAlphas"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Specifies the alpha transparency values used for the background gradient fill of the application."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "backgroundGradientColors"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Specifies the colors used to tint the background gradient fill of the application."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "applicationComplete"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Dispatched after the Application has been initialized, processed by the LayoutManager,and attached to the display list."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "error"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Dispatched when an error occurs anywhere in the application, such as an HTTPService,WebService, or RemoteObject fails."
 *   						
 * @author Ji Hoon Kim
 */
public abstract class AbstractMXMLUIApplication 
						extends MXMLUISimpleBase 
						implements _MXMLUIContainerAttributes, _MXMLUIBaseAttributes, _MXMLApplicationContract,
						_MXMLUIBackgroundAlphaAttribute, _MXMLUIBackgroundAttributes, _MXMLUIBackgroundColorAttribute, 
						_MXMLUIBackgroundDisabledColorAttribute, _MXMLUIBarColorAttribute, _MXMLUIBorderAttributes, 
						_MXMLUIBorderColorAttribute, _MXMLUIBorderThicknessAttribute, _MXMLUIColorAttribute, 
						_MXMLUICornerRadiusAttribute, _MXMLUIDataChangeAttribute, _MXMLUIDisabledColorAttribute, 
						_MXMLUIFontFamilyAttribute, _MXMLUIFontGeneralAttributes, _MXMLUIFontSpecificAttributes, 
						_MXMLUIGapAttributes, _MXMLUIHorizontalAlignAttribute, _MXMLUIHorizontalScrollPositionAttribute,  
						_MXMLUILabelAttribute, _MXMLUILayoutAttribute, _MXMLUIModalAttributes, _MXMLUIPaddingHorizontalAttributes,  
						_MXMLUIPaddingVerticalAttributes, _MXMLUIScrollAttribute, _MXMLUIScrollAttributes, 
						_MXMLUIScrollBarAttributes, _MXMLUIShadowAttributes, _MXMLUITextStyleAttributes, 
						_MXMLUIThumbSkinAttributes, _MXMLUITrackAttributes, _MXMLUIVerticalAlignAttribute, 
						_MXMLUITitleAttribute, _MXMLUIIconAttribute, _MXMLUIHideAttribute {
	
	private static final String MXML_COMPONENT_RENDERER = "com.googlecode.jsfFlex.MXMLApplication";
	
	private static final String MX_ACTUAL_KEY = "xmlns:mx";
	private static final String MX_XMLNS_KEY = "xmlnsMX";
	private static final String MX_DEFAULT_XMLNS = "http://www.adobe.com/2006/mxml";
    private static final String INITIALIZE_CALL = "initializeApp(event);";
	
	private String _applicationPath;
    
	public String getMXMLComponentRenderer() {
		return MXML_COMPONENT_RENDERER;
	}
	
	public Map getComponentValues(){
		return null;
	}
	
	public void encodeBegin(FacesContext context) throws IOException {
		
		ServletContext servContext = (ServletContext) context.getExternalContext().getContext();
		setApplicationPath( servContext.getRealPath(new String()) );
		
		if(getAttributes().get(MX_XMLNS_KEY) == null){
			getAttributes().put(MX_ACTUAL_KEY, MX_DEFAULT_XMLNS);
		}else{
			getAttributes().put(MX_ACTUAL_KEY, getAttributes().get(MX_XMLNS_KEY));
		}
		
		MxmlContext mxmlContext = new MxmlContextImpl(getMxmlPackageName());
		
		mxmlContext.initRunners();
		mxmlContext.setProductionEnv(isProductionMode());
		mxmlContext.setSimplySWF(isSimplySWFMode());
		
		String swfWebPath = MXMLConstants.SWF_DIRECTORY_NAME + "/" + getMxmlPackageName() + "/";
		mxmlContext.setSwfWebPath(swfWebPath);
		
		//setting or appending scripts to execute upon application initialization
		String _init = (String) getAttributes().get(MXML.INITIALIZE_ATTR);
		_init = (_init == null) ? INITIALIZE_CALL : _init + " " + INITIALIZE_CALL;
		getAttributes().put(MXML.INITIALIZE_ATTR, _init);
		
		//to reflect the correct state when debugging
		if(isProductionMode()){
			//do not need to create preMXML, MXML, and SWF files
			
		}else{
			String mxmlPath = _applicationPath + File.separatorChar + MXMLConstants.MXML_DIRECTORY_NAME + File.separatorChar +
									getMxmlPackageName() + File.separatorChar;
			String swfPath = _applicationPath + File.separatorChar + MXMLConstants.SWF_DIRECTORY_NAME + File.separatorChar +
									getMxmlPackageName() + File.separatorChar + getMxmlPackageName() + MXMLConstants.SWF_FILE_EXT;
			String swfBasePath = _applicationPath + File.separatorChar + MXMLConstants.SWF_DIRECTORY_NAME + File.separatorChar;
			/*
			 * 	The above swfBasePath will hold placeholder of where swf-source-files's source-file[s] will be echoed to.
			 * 	The files that will be echoed can be found in mxmlConstants.xml and are simply the contents that will be used
			 * 	by the system's ActionScripts.
			 */
			String flexSDKPath = _applicationPath + File.separatorChar + MXMLConstants.FLEX_SDK_DIRECTORY_NAME + File.separatorChar;
			
			mxmlContext.setFlexSDKPath(flexSDKPath);
			mxmlContext.setMxmlPath(mxmlPath);
			mxmlContext.setSwfPath(swfPath);
			mxmlContext.setSwfBasePath(swfBasePath);
			
			if(isSimplySWFMode()){
				//do not need to create preMXML files
				
			}else{
				String preMxmlPath = _applicationPath + File.separatorChar + MXMLConstants.PREMXML_DIRECTORY_NAME + File.separatorChar +
										getMxmlPackageName() + File.separatorChar;
				mxmlContext.setPreMxmlPath(preMxmlPath);
				
			}
			
		}
		
		MXMLJsfUtil.setComponentProperties(this, context);
		super.encodeBegin(context);
	}
	
	public void encodeEnd(FacesContext context) throws IOException {
		
		DojoConfig currentConfig = DojoUtils.getDjConfigInstance(context);
		DojoUtils.addMainInclude(context, this, null, currentConfig);
		
		AddResource addResource = AddResourceFactory.getInstance(context);
		addResource.addJavaScriptAtPosition(context, AddResource.HEADER_BEGIN, new JsfFlexResourceHandler(
												getClass(), 
												MXMLConstants.JSF_FLEX_COMMUNICATOR_JS));
		super.encodeEnd(context);
	}
	
	public boolean isDebugMode() {
    	return getMode().equals("debugMode");
    }
    public boolean isProductionMode() {
        return getMode().equals("productionMode");
    }
    public boolean isSimplySWFMode() {
        return getMode().equals("simplySwfMode");
    }
    public String getApplicationPath() {
		return _applicationPath;
	}
	public void setApplicationPath(String applicationPath) {
		_applicationPath = applicationPath;
	}
	
	/**
	 * The mxmlPackageName for the application.
	 * 
	 *@JSFProperty
	 *    required        = true
	 *    rtexprvalue     = false
	 *    desc            = "The mxmlPackageName for the application."
	 */
	public abstract String getMxmlPackageName();

	/**
	 * This value can be of debugMode, productionMode [default], and simplySWF mode. Depending on the value, different action will be taken for the creation of preMxml, Mxml,and SWF files.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "This value can be of debugMode, productionMode [default], and simplySWF mode. Depending on the value, different action will be taken for the creation of preMxml, Mxml,and SWF files."
	 */
	public abstract String getMode();

	/**
	 * This value will be passed to the mxmlc compiler when creating a SWF. It must be an absolutePath to a filesystem where additional ActionScript and MXML files that areneeded for the current SWF generation are located at. There can be multiple valuesseparated with a space.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "This value will be passed to the mxmlc compiler when creating a SWF. It must be an absolutePath to a filesystem where additional ActionScript and MXML files that areneeded for the current SWF generation are located at. There can be multiple valuesseparated with a space."
	 */
	public abstract String getSourcePath();

	/**
	 * This value will be passed to the mxmlc compiler when creating a SWF. It represents the defaultBgColor, surprise.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "This value will be passed to the mxmlc compiler when creating a SWF. It represents the defaultBgColor, surprise."
	 */
	public abstract String getDefaultBgColor();

	/**
	 * This value will be passed to the mxmlc compiler when creating a SWF. It represents the max level of recursion that the Flash VM will allow.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "This value will be passed to the mxmlc compiler when creating a SWF. It represents the max level of recursion that the Flash VM will allow."
	 */
	public abstract Integer getMaxLvRecursion();

	/**
	 * This value will be passed to the mxmlc compiler when creating a SWF. It represents the max script exec time that the Flash VM will allow.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "This value will be passed to the mxmlc compiler when creating a SWF. It represents the max script exec time that the Flash VM will allow."
	 */
	public abstract Integer getMaxScriptExecTime();

	/**
	 * This value will be passed to the mxmlc compiler when creating a SWF. It represents whether the creation of the SWF files will based incrementally.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "This value will be passed to the mxmlc compiler when creating a SWF. It represents whether the creation of the SWF files will based incrementally."
	 */
	public abstract boolean isIncremental();

	/**
	 * This value will be passed to the mxmlc compiler when creating a SWF. It should bean absolutePath to a loadConfig XML file that specifies attributes for the mxmlc.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "This value will be passed to the mxmlc compiler when creating a SWF. It should bean absolutePath to a loadConfig XML file that specifies attributes for the mxmlc."
	 */
	public abstract String getLoadConfig();

	/**
	 * This value will be passed to the mxmlc compiler when creating a SWF. It simply is a metadata for the SWF.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "This value will be passed to the mxmlc compiler when creating a SWF. It simply is a metadata for the SWF."
	 */
	public abstract String getDescription();

	/**
	 * This value will be passed to the mxmlc compiler when creating a SWF. It simply is a metadata for the SWF.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "This value will be passed to the mxmlc compiler when creating a SWF. It simply is a metadata for the SWF."
	 */
	public abstract String getCreator();

	/**
	 * This value will be passed to the mxmlc compiler when creating a SWF. It simply is a metadata for the SWF.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "This value will be passed to the mxmlc compiler when creating a SWF. It simply is a metadata for the SWF."
	 */
	public abstract String getPublisher();

	/**
	 * This value will be passed to the mxmlc compiler when creating a SWF. It simply is a metadata for the SWF.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "This value will be passed to the mxmlc compiler when creating a SWF. It simply isa  metadata for the SWF."
	 */
	public abstract String getLanguage();

	/**
	 * This value will be passed to the mxmlc compiler when creating a SWF. It simply is a metadata for the SWF.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "This value will be passed to the mxmlc compiler when creating a SWF. It simply is a metadata for the SWF."
	 */
	public abstract String getDate();
	
}
