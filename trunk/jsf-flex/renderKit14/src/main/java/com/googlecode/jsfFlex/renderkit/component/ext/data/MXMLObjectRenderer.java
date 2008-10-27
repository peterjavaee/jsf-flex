package com.googlecode.jsfFlex.renderkit.component.ext.data;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import com.googlecode.jsfFlex.renderkit.component.MXMLComponentRenderer;
import com.googlecode.jsfFlex.renderkit.mxml.AbstractMXMLResponseWriter;
import com.googlecode.jsfFlex.shared.adapter._MXMLContract;

/**
 * @JSFRenderer
 *  renderKitId = "MXML_BASIC" 
 *  family      = "javax.faces.MXMLSimpleBase"
 *  type        = "com.googlecode.jsfFlex.MXMLObject"
 * 
 * @JsfFlexAttributes
 * 	label=false
 * 	data=false
 * 
 * @author Ji Hoon Kim
 */
public final class MXMLObjectRenderer extends MXMLComponentRenderer {
	
	private static final String MXML_OBJECT_REPLACE_MAPPING;
	private static final String MXML_COMPONENT_NAME = "Object";
	
	static{
		//TODO : find a better method to implement the below tasks
		String packageName = MXMLObjectRenderer.class.getPackage().getName();
		packageName = packageName.replace('.', '/');
		MXML_OBJECT_REPLACE_MAPPING = packageName + "/replaceMapping/MXMLObjectRendererReplaceMapping.xml";
	}
	
	public void encodeBegin(FacesContext context, UIComponent componentObj) throws IOException {
		super.encodeBegin(context, componentObj);
		
		_MXMLContract componentMXML = (_MXMLContract) componentObj;
		
		AbstractMXMLResponseWriter writer = (AbstractMXMLResponseWriter) context.getResponseWriter();
		writer.mapFields(MXMLObjectRenderer.class, componentObj, MXML_OBJECT_REPLACE_MAPPING);
		writer.createPreMxml(writer, componentMXML, MXML_COMPONENT_NAME, null);
		
	}
	
}
