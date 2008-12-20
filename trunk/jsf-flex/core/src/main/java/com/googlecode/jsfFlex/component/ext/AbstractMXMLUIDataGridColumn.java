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

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.googlecode.jsfFlex.component.MXMLUISimpleBase;
import com.googlecode.jsfFlex.component.attributes._MXMLUIColumnData;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDataFieldAttribute;

/**
 * @JSFComponent
 *   name     = "jf:mxmlDataGridColumn"
 *   class    = "com.googlecode.jsfFlex.component.ext.MXMLUIDataGridColumn"
 *   type     = "com.googlecode.jsfFlex.MXMLUIDataGridColumn"
 *   tagClass = "com.googlecode.jsfFlex.taglib.ext.MXMLUIDataGridColumnTag"
 *   family   = "javax.faces.MXMLSimple"
 *   defaultRendererType= "com.googlecode.jsfFlex.MXMLDataGridColumn"
 *   
 * @JSFJspProperties
 * 		properties	=		
 *   						@JSFJspProperty
 *   						 name		= "dataTipField"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The name of the field in the data provider to display as the datatip."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "dataTipFunction"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "Specifies a callback function to run on each item of the data provider to determine its dataTip."
 *   						,
 *   
 *							@JSFJspProperty
 *   						 name		= "editable"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "A flag that indicates whether the items in the column are editable."
 *   						,
 *   						
 *							@JSFJspProperty
 *   						 name		= "editorDataField"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The name of the property of the item editor that contains the new data for the list item."
 *   						,
 *   
 *							@JSFJspProperty
 *   						 name		= "editorHeightOffset"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The height of the item editor, in pixels, relative to the size of the item renderer."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "editorUsesEnterKey"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "A flag that indicates whether the item editor uses Enter key."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "editorWidthOffset"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "The width of the item editor, in pixels, relative to the size of the item renderer."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "editorXOffset"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "The x location of the upper-left corner of the item editor, in pixels, relative to the upper-left corner of the item."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "editorYOffset"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "The y location of the upper-left corner of the item editor, in pixels, relative to the upper-left corner of the item."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "headerRenderer"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The class factory for item renderer instances that display the column header for the column."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "headerText"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Text for the header of this column."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "headerWordWrap"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "A flag that indicates whether text in the header will be word wrapped if it doesn't fit on one line."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "imeMode"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "Specifies the IME (input method editor) mode."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "itemEditor"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "A class factory for the instances of the item editor to use for the column, when it is editable."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "itemRenderer"
 *   						 returnType	= "java.lang.String" 
 *   						 longDesc	= "The class factory for item renderer instances that display the data for each item in the column."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "labelFunction"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "A function that determines the text to display in this column."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "minWidth"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The minimum width of the column."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "rendererIsEditor"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "A flag that indicates that the item renderer is also an item editor."
 *   						,
 *   
 *							@JSFJspProperty
 *   						 name		= "resizable"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "A flag that indicates whether the user is allowed to resize the width of the column."
 *   						,
 *   						
 *							@JSFJspProperty
 *   						 name		= "showDataTips"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "A flag that indicates whether the datatips are shown in the column."
 *   						,
 *   
 *							@JSFJspProperty
 *   						 name		= "sortable"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "A flag that indicates whether the user can click on the header of this column to sort the data provider."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "sortCompareFunction"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "A callback function that gets called when sorting the data in the column."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "sortDescending"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "A flag that indicates, if the column is the field used the sort the dataprovider, whether the sort is in descending order."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "visible"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "A flag that indicates whethe the column is visible."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "wordWrap"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "A flag that indicates whether the text in a row of this column is word wrapped if it doesn't fit on one line If undefined, the DataGrid control's wordWrap property is used."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "backgroundColor"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The Background color of the column."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "color"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Color of text in the component, including the component label."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "disabledColor"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "Color of text in the component if it is disabled."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "fontAntiAliasType"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "Sets the antiAliasType property of internal TextFields. The possible values are "normal" (flash.text.AntiAliasType.NORMAL) and "advanced" (flash.text.AntiAliasType.ADVANCED)."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "fontFamily"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Name of the font to use."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "fontGridFitType"
 *   						 returnType	= "java.lang.String" 
 *   						 longDesc	= "Sets the gridFitType property of internal TextFields that represent text in Flex controls. The possible values are "none" (flash.text.GridFitType.NONE), "pixel" (flash.text.GridFitType.PIXEL), and "subpixel" (flash.text.GridFitType.SUBPIXEL)."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "fontSharpness"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "Sets the sharpness property of internal TextFields that represent text in Flex controls. This property specifies the sharpness of the glyph edges. The possible values are Numbers from -400 through 400."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "fontSize"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "Height of the text, in pixels."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "fontStyle"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Determines whether the text is italic font."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "fontThickness"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Sets the thickness property of internal TextFields that represent text in Flex controls. This property specifies the thickness of the glyph edges. The possible values are Numbers from -200 to 200."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "fontWeight"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "Determines whether the text is boldface. Recognized values are "normal" and "bold"."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "headerStyleName"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "The name of a CSS style declaration for controlling other aspects of the appearance of the column headers."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "paddingLeft"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The number of pixels between the container's left border and its content area."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "paddingRight"
 *   						 returnType	= "java.lang.String" 
 *   						 longDesc	= "The number of pixels between the container's right border and its content area."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "textAlign"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Alignment of text within a container. Possible values are "left", "right", or "center"."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "textDecoration"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "Determines whether the text is underlined."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "textIndent"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "Offset of first line of text from the left side of the container, in pixels."
 *   						   						
 * @author Ji Hoon Kim
 */
public abstract class AbstractMXMLUIDataGridColumn 
						extends MXMLUISimpleBase 
						implements _MXMLUIColumnData, _MXMLUIDataFieldAttribute {
	
	private final static Log _log = LogFactory.getLog(AbstractMXMLUIDataGridColumn.class);
	
	private static final String REQUEST_KEYS_KEY = "requestKeys";
	private static final String RESULT_CODE_KEY = "resultCode";
	
	private Set _modifiedDataFieldSet;
	
	{
		_modifiedDataFieldSet = new LinkedHashSet();
	}
	
	public List getFormatedColumnData(){
		// for more complicated Grids, the return data might consist of XML entries
		return getColumnData();
	}
	
	public void encodeEnd(FacesContext context) throws IOException {
		super.encodeEnd(context);
		
		/*
		 * adding the component to the map for future asynchronous request reference by
		 * DataGridColumnServiceRequest.as
		 */
		Map sessionMap = context.getExternalContext().getSessionMap();
		sessionMap.put(getId(), this);
	}
	
	public void decode(FacesContext context) {
		super.decode(context);
		
		/*
		 * No longer needed, so remove the content.
		 * Below is a pure HACK till JSF 2.0.
		 * Also saveState + restoreState has been implemented for future JSF impl.
		 */
		Map sessionMap = context.getExternalContext().getSessionMap();
		AbstractMXMLUIDataGridColumn instance = (AbstractMXMLUIDataGridColumn) sessionMap.remove(getId());
		_modifiedDataFieldSet = instance._modifiedDataFieldSet;
		
		List columnData = getColumnData();
		
		//Set modifiedDataFieldSet
		for(Iterator keyIterator = _modifiedDataFieldSet.iterator(); keyIterator.hasNext();){
			ModifiedDataField currModifiedDataField = (ModifiedDataField) keyIterator.next();
			columnData.set(currModifiedDataField._rowIndex, currModifiedDataField._modifiedValue);
		}
		
	}
	
	public Object saveState(FacesContext context) {
		Object[] values = new Object[2];
		values[0] = super.saveState(context);
		values[1] = _modifiedDataFieldSet;
		
		return values;
	}
	
	public void restoreState(FacesContext context, Object state) {
		Object[] values = (Object[]) state;
		super.restoreState(context, values[0]);
		_modifiedDataFieldSet = (Set) values[1];
	}
	
	public Map updateModifiedDataField(){
		Map updateResult = new LinkedHashMap();
		boolean success = true;
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		String requestKey = (String) request.getParameter(REQUEST_KEYS_KEY);
		List requestKeyList = Arrays.asList(requestKey.split(","));
		
		for(Iterator keyIterator = requestKeyList.iterator(); keyIterator.hasNext();){
			String actualCurrKey = (String) keyIterator.next();
			String currValue = (String) request.getParameter(actualCurrKey);
			
			int rowIndex;
			
			try{
				rowIndex = Integer.parseInt(actualCurrKey);
			}catch(NumberFormatException parsingException){
				_log.info("Error parsing of " + actualCurrKey + " to an int", parsingException);
				continue;
			}
			
			ModifiedDataField currModifiedDataField = new ModifiedDataField(rowIndex, currValue);
			synchronized(_modifiedDataFieldSet){
				_modifiedDataFieldSet.add(currModifiedDataField);
			}
		}
		
		updateResult.put(RESULT_CODE_KEY, Boolean.valueOf(success));
		return updateResult;
	}
	
	private static class ModifiedDataField implements Serializable {
		
		private static final long serialVersionUID = -9043196776952660308L;
		
		private final int _rowIndex;
		private final String _modifiedValue;
		
		private ModifiedDataField(int rowIndex, String modifiedValue){
			super();
			_rowIndex = rowIndex;
			_modifiedValue = modifiedValue;
		}
		
		public boolean equals(Object instance) {
			if(!(instance instanceof ModifiedDataField)){
				return false;
			}
			
			ModifiedDataField modifiedDataFieldInstance = (ModifiedDataField) instance;
			return _rowIndex == modifiedDataFieldInstance._rowIndex;
		}
		public int hashCode() {
			return _rowIndex;
		}
		
	}
	
}
