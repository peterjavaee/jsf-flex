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

import com.googlecode.jsfFlex.component.MXMLUISimpleBase;
import com.googlecode.jsfFlex.component.attributes._MXMLUIAllowMultipleSelectionAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBackgroundAlphaAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBackgroundAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBackgroundColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBatchColumnDataRetrievalSize;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBorderAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBorderColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIBorderThicknessAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIColumnCountAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUICornerRadiusAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDataProviderAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDisabledColorAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIDragAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFontFamilyAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIFontGeneralAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIHeaderHeightAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIIconFieldAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIItemInfoAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUILabelFieldAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUILabelFunctionAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUILeadingAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIRepeatAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIScrollAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUIScrollAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIShadowAttributes;
import com.googlecode.jsfFlex.component.attributes._MXMLUIShowHeadersAttribute;
import com.googlecode.jsfFlex.component.attributes._MXMLUITextStyleAttributes;
import com.googlecode.jsfFlex.component.attributes.compBase._MXMLUIBaseAttributes;
import com.googlecode.jsfFlex.component.attributes.compBase._MXMLUIListBaseAttributes;
import com.googlecode.jsfFlex.component.attributes.compBase._MXMLUIScrollBarAttributes;
import com.googlecode.jsfFlex.component.attributes.compBase._MXMLUIScrollControlAttributes;

/**
 * @JSFComponent
 *   name     = "jf:mxmlDataGrid"
 *   class    = "com.googlecode.jsfFlex.component.ext.MXMLUIDataGrid"
 *   type     = "com.googlecode.jsfFlex.MXMLUIDataGrid"
 *   tagClass = "com.googlecode.jsfFlex.taglib.ext.MXMLUIDataGridTag"
 *   family   = "javax.faces.MXMLSimple"
 *   defaultRendererType= "com.googlecode.jsfFlex.MXMLDataGrid"
 *   
 * @JSFJspProperties
 * 		properties	=		
 *   						@JSFJspProperty
 * 							 name		= "columns"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "An array of DataGridColumn objects, one for each column that can be displayed."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "draggableColumns"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "A flag that indicates whether the user is allowed to reorder columns."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "editable"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "A flag that indicates whether or not the user can edit items in the data provider."
 *   						,
 *   
 *							@JSFJspProperty
 *   						 name		= "editedItemPosition"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "The column and row index of the item renderer for the data provider item being edited, if any."
 *   						,
 *   						
 *							@JSFJspProperty
 *   						 name		= "horizontalScrollPosition"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The offset into the content from the left edge."
 *   						,
 *   
 *							@JSFJspProperty
 *   						 name		= "imeMode"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Specifies the IME (input method editor) mode."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "itemEditorInstance"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "A reference to the currently active instance of the item editor, if it exists."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "minColumnWidth"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "The minimum width of the columns, in pixels."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "resizableColumns"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "A flag that indicates whether the user can change the size of the columns."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "sortableColumns"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "A flag that indicates whether the user can sort the data provider items by clicking on a column header cell."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "backgroundDisabledColor"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The background color of the DataGrid when disabled."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "columnDropIndicatorSkin"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The class to use as the skin that indicates that a column can be dropped in the current location."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "columnResizeSkin"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "The class to use as the skin for a column that is being resized."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "headerColors"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "An array of two colors used to draw the header background gradient."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "headerDragProxyStyleName"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The name of a CSS style declaration for controlling aspects of the appearance of column when the user is dragging it to another location."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "headerSeparatorSkin"
 *   						 returnType	= "java.lang.String" 
 *   						 longDesc	= "The skin that defines the appearance of the separators between column headers in a DataGrid."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "headerStyleName"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "The name of a CSS style declaration for controlling other aspects of the appearance of the column headers."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "horizontalGridLineColor"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The color of the horizontal grid lines."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "horizontalGridLines"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "A flag that indicates whether to show horizontal grid lines between the rows."
 *   						,
 *   
 *							@JSFJspProperty
 *   						 name		= "rollOverColor"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "The color of the row background when the user rolls over the row."
 *   						,
 *   						
 *							@JSFJspProperty
 *   						 name		= "selectionColor"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The color of the background for the row when the user selects an item renderer in the row."
 *   						,
 *   
 *							@JSFJspProperty
 *   						 name		= "sortArrowSkin"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The class to use as the skin for the arrow that indicates the column sort direction."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "stretchCursor"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "The class to use as the skin for the cursor that indicates that a column can be resized."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "verticalGridLineColor"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "The color of the vertical grid lines."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "verticalGridLines"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "A flag that indicates whether to show vertical grid lines between the columns."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "columnStretch"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "Dispatched when a user changes the width of a column, indicating that the amount of data displayed in that column may have changed."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "headerRelease"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Dispatched when the user releases the mouse button on a column header to request the control to sort the grid contents based on the contents of the column."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "headerShift"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Dispatched when the user releases the mouse button on a column header after having dragged the column to a new location resulting in shifting the column to a new index."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "itemEditBegin"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "Dispatched when the editedItemPosition property has been set and the item can be edited."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "itemEditEnd"
 *   						 returnType = "java.lang.String"
 *   						 longDesc	= "Dispatched when an item editing session ends for any reason."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "itemFocusIn"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Dispatched when an item renderer gets focus, which can occur if the user clicks on an item in the DataGrid control or navigates to the item using a keyboard."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "itemFocusOut"
 *   						 returnType	= "java.lang.String" 
 *   						 longDesc	= "Dispatched when an item renderer loses focus, which can occur if the user clicks another item in the DataGrid control or clicks outside the control, or uses the keyboard to navigate to another item in the DataGrid control or outside the control."
 *   						   						
 * @author Ji Hoon Kim
 */
public abstract class AbstractMXMLUIDataGrid 
						extends MXMLUISimpleBase
						implements _MXMLUIHeaderHeightAttribute, _MXMLUIShowHeadersAttribute,
						_MXMLUIListBaseAttributes, _MXMLUIAllowMultipleSelectionAttribute, _MXMLUIColumnCountAttribute, 
						_MXMLUIScrollControlAttributes, _MXMLUIScrollAttributes, _MXMLUIDataProviderAttribute,
						_MXMLUIBackgroundAlphaAttribute, _MXMLUIBackgroundColorAttribute, _MXMLUIDragAttributes,
						_MXMLUIIconFieldAttribute, _MXMLUIItemInfoAttributes, _MXMLUILabelFieldAttribute, 
						_MXMLUILabelFunctionAttribute, _MXMLUIScrollAttribute, _MXMLUITextStyleAttributes,
						_MXMLUIBackgroundAttributes, _MXMLUIBorderColorAttribute, _MXMLUIBorderAttributes, 
						_MXMLUIBorderThicknessAttribute, _MXMLUIColorAttribute, _MXMLUICornerRadiusAttribute, 
						_MXMLUIDisabledColorAttribute, _MXMLUIShadowAttributes, _MXMLUIFontFamilyAttribute, 
						_MXMLUIFontGeneralAttributes, _MXMLUIScrollBarAttributes, _MXMLUILeadingAttribute, 
						_MXMLUIRepeatAttributes, _MXMLUIBatchColumnDataRetrievalSize, _MXMLUIBaseAttributes {
	
}
