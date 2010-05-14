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

import com.googlecode.jsfFlex.attributes.IFlexUIBaseAttributes;
import com.googlecode.jsfFlex.attributes.IFlexUIColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUICondenseWhiteAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDataAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDataChangeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDisabledColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontAntiAliasTypeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontFamilyAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontGridFitTypeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontSharpnessAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontSizeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontStyleAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontThicknessAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontWeightAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIListDataAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPaddingBottomAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPaddingLeftAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPaddingRightAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPaddingTopAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISelectableAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIStyleSheetAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextAlignAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextDecorationAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextIndentAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITruncateToFitAttribute;

/**
 * @author Ji Hoon Kim
 */
@JSFComponent
interface IFlexUILabelAttributes 
            extends IFlexUICondenseWhiteAttribute, IFlexUIDataAttribute, IFlexUIListDataAttribute, IFlexUISelectableAttribute, 
            IFlexUITruncateToFitAttribute, IFlexUIColorAttribute, IFlexUIDisabledColorAttribute, IFlexUIFontAntiAliasTypeAttribute, 
            IFlexUIFontFamilyAttribute, IFlexUIFontGridFitTypeAttribute, IFlexUIFontSharpnessAttribute, IFlexUIFontSizeAttribute,
            IFlexUIFontStyleAttribute, IFlexUIFontThicknessAttribute, IFlexUIFontWeightAttribute, IFlexUIPaddingLeftAttribute, 
            IFlexUIPaddingRightAttribute, IFlexUITextAlignAttribute, IFlexUITextDecorationAttribute, IFlexUITextIndentAttribute, 
            IFlexUIDataChangeAttribute, IFlexUIPaddingTopAttribute, IFlexUIPaddingBottomAttribute, IFlexUIStyleSheetAttribute, 
            IFlexUIBaseAttributes {
    
    String getHtmlText();
    
    void setHtmlText(String htmlText);
    
    String getText();
    
    void setText(String text);
    
}
