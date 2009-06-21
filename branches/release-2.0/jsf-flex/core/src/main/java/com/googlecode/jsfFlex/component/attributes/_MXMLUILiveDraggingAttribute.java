package com.googlecode.jsfFlex.component.attributes;

import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFProperty;

/**
 * @author Ji Hoon Kim
 */
public interface _MXMLUILiveDraggingAttribute {
	
	/**
	 * If true, the children adjacent to a divider are continuously resized while the user drags it.
	 */
    @JSFProperty(
            required        =   false,
            rtexprvalue     =   false,
            desc            =   "If true, the children adjacent to a divider are continuously resized while the user drags it."
    )
	String getLiveDragging();
	
}
