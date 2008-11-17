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
import com.googlecode.jsfFlex.component.attributes._MXMLUIColumnData;

/**
 * @JSFComponent
 *   name     = "jf:mxmlDataGridColumn"
 *   class    = "com.googlecode.jsfFlex.component.ext.MXMLUIDataGridColumn"
 *   type     = "com.googlecode.jsfFlex.MXMLUIDataGridColumn"
 *   tagClass = "com.googlecode.jsfFlex.taglib.ext.MXMLUIDataGridColumnTag"
 *   family   = "javax.faces.MXMLSimpleBase"
 *   defaultRendererType= "com.googlecode.jsfFlex.MXMLDataGridColumn"
 *   
 * @JSFJspProperties
 * 		properties	=		
 *   						@JSFJspProperty
 * 							 name		= "dataField"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The name of the field or property in the data provider item associated with the column."
 *   						,
 *   						
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
						implements _MXMLUIColumnData {
	
}
