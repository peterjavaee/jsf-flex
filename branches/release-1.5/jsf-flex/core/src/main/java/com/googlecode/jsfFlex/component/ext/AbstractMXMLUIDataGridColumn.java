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

import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFComponent;

import com.googlecode.jsfFlex.attributes._MXMLUIBackgroundColorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIColorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIDataFieldAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIDataTipFieldAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIDataTipFunctionAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIDisabledColorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIEditableAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIEditorDataFieldAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIEditorHeightOffsetAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIEditorUsesEnterKeyAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIEditorWidthOffsetAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIEditorXOffsetAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIEditorYOffsetAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIFontAntiAliasTypeAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIFontFamilyAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIFontGridFitTypeAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIFontSharpnessAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIFontSizeAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIFontStyleAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIFontThicknessAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIFontWeightAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIHeaderRendererAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIHeaderStyleNameAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIHeaderTextAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIHeaderWordWrapAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIImeModeAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIItemEditorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIItemRendererAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUILabelFunctionAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIMinWidthAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIPaddingLeftAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIPaddingRightAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIRendererIsEditorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIResizableAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIShowDataTipsAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUISortCompareFunctionAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUISortDescendingAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUISortableAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUITextAlignAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUITextDecorationAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUITextIndentAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIVisibleAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIWordWrapAttribute;

/**
 * @author Ji Hoon Kim
 */
@JSFComponent(
        name                =   "jf:mxmlDataGridColumn",
        clazz               =   "com.googlecode.jsfFlex.component.ext.MXMLUIDataGridColumn",
        type                =   "com.googlecode.jsfFlex.MXMLUIDataGridColumn",
        tagClass            =   "com.googlecode.jsfFlex.taglib.ext.MXMLUIDataGridColumnTag",
        family              =   "javax.faces.MXMLInput",
        defaultRendererType =   "com.googlecode.jsfFlex.MXMLDataGridColumn"
)
public abstract class AbstractMXMLUIDataGridColumn 
						extends AbstractDataGridColumnComponentBase
						implements _MXMLUIDataFieldAttribute, _MXMLUIDataTipFieldAttribute, _MXMLUIDataTipFunctionAttribute, 
                        _MXMLUIEditableAttribute, _MXMLUIEditorDataFieldAttribute, _MXMLUIEditorHeightOffsetAttribute, 
                        _MXMLUIEditorUsesEnterKeyAttribute, _MXMLUIEditorWidthOffsetAttribute, _MXMLUIEditorXOffsetAttribute, 
                        _MXMLUIEditorYOffsetAttribute, _MXMLUIHeaderRendererAttribute, _MXMLUIHeaderTextAttribute, 
                        _MXMLUIHeaderWordWrapAttribute, _MXMLUIImeModeAttribute, _MXMLUIItemEditorAttribute, 
                        _MXMLUIItemRendererAttribute, _MXMLUILabelFunctionAttribute, _MXMLUIMinWidthAttribute, 
                        _MXMLUIRendererIsEditorAttribute, _MXMLUIResizableAttribute, _MXMLUIShowDataTipsAttribute, 
                        _MXMLUISortableAttribute, _MXMLUISortCompareFunctionAttribute, _MXMLUISortDescendingAttribute, 
                        _MXMLUIVisibleAttribute, _MXMLUIWordWrapAttribute, _MXMLUIBackgroundColorAttribute, _MXMLUIColorAttribute, 
                        _MXMLUIDisabledColorAttribute, _MXMLUIFontAntiAliasTypeAttribute, _MXMLUIFontFamilyAttribute, 
                        _MXMLUIFontGridFitTypeAttribute, _MXMLUIFontSharpnessAttribute, _MXMLUIFontSizeAttribute, 
                        _MXMLUIFontStyleAttribute, _MXMLUIFontThicknessAttribute, _MXMLUIFontWeightAttribute, 
                        _MXMLUIHeaderStyleNameAttribute, _MXMLUIPaddingLeftAttribute, _MXMLUIPaddingRightAttribute, 
                        _MXMLUITextAlignAttribute, _MXMLUITextDecorationAttribute, _MXMLUITextIndentAttribute {
	
}
