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
import java.util.Collection;
import java.util.Map;

import javax.el.ValueExpression;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFComponent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.googlecode.jsfFlex.attributes.IFlexUIAlternatingItemColorsAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIArrowButtonWidthAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBorderColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIBorderThicknessAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIChangeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUICloseAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUICloseDurationAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUICloseEasingFunctionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUICornerRadiusAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDataChangeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDataProviderAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDataProviderCollectionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDisabledColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDisabledIconColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDropDownBorderColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDropDownStyleNameAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDropdownFactoryAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIDropdownWidthAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIEditableAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIEnterAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFillAlphasAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFillColorsAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFocusAlphaAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFocusRoundedCornersAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontAntiAliasTypeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontFamilyAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontGridFitTypeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontSharpnessAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontSizeAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontStyleAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontThicknessAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIFontWeightAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIHighlightAlphasAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIIconColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIItemRendererAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIItemRollOutAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIItemRollOverAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUILabelFieldAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUILabelFunctionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUILeadingAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIOpenAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIOpenDurationAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIOpenEasingFunctionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPaddingBottomAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPaddingLeftAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPaddingRightAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPaddingTopAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIPromptAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIRollOverColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIRowCountAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUIScrollAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISelectedIndexAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISelectionColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISelectionDurationAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUISelectionEasingFunctionAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextAlignAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextDecorationAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextIndentAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextRollOverColorAttribute;
import com.googlecode.jsfFlex.attributes.IFlexUITextSelectedColorAttribute;
import com.googlecode.jsfFlex.shared.beans.additionalScriptContent.AdditionalApplicationScriptContent;
import com.googlecode.jsfFlex.shared.context.AbstractFlexContext;
import com.googlecode.jsfFlex.shared.util.FlexJsfUtil;

/**
 * AbstractFlexUIComboBox is a special case where the preserving of the state of the "text" field<br>
 * is held within the code. Main reason is because it extends FlexUISelectedIndexBase and there exists<br>
 * no reason to create an another base class to preserve both "selectedIndex" + "text".<br>
 * @author Ji Hoon Kim
 */
@JSFComponent(
        name                =   "jf:flexComboBox",
        clazz               =   "com.googlecode.jsfFlex.component.ext.FlexUIComboBox",
        type                =   "com.googlecode.jsfFlex.FlexUIComboBox",
        tagClass            =   "com.googlecode.jsfFlex.taglib.component.ext.FlexUIComboBoxTag",
        family              =   "javax.faces.FlexInput",
        defaultRendererType =   "com.googlecode.jsfFlex.FlexComboBox",
        tagSuperclass       =   "com.googlecode.jsfFlex.taglib.FlexUIInputTagBase"
)
public abstract class AbstractFlexUIComboBox 
						extends com.googlecode.jsfFlex.component.FlexUISelectedIndexBase
						implements IFlexUIComboBaseAttributes, IFlexUIDropdownFactoryAttribute, IFlexUIDropdownWidthAttribute, 
                        IFlexUIItemRendererAttribute, IFlexUILabelFieldAttribute, IFlexUILabelFunctionAttribute, 
                        IFlexUIPromptAttribute, IFlexUIRowCountAttribute, IFlexUIAlternatingItemColorsAttribute, IFlexUIArrowButtonWidthAttribute, 
                        IFlexUIBorderColorAttribute, IFlexUIBorderThicknessAttribute, IFlexUICloseDurationAttribute, 
                        IFlexUICloseEasingFunctionAttribute, IFlexUIColorAttribute, IFlexUICornerRadiusAttribute, 
                        IFlexUIDisabledColorAttribute, IFlexUIDisabledIconColorAttribute, IFlexUIDropDownBorderColorAttribute, 
                        IFlexUIDropDownStyleNameAttribute, IFlexUIFillAlphasAttribute, IFlexUIFillColorsAttribute, IFlexUIFocusAlphaAttribute, 
                        IFlexUIFocusRoundedCornersAttribute, IFlexUIFontAntiAliasTypeAttribute, IFlexUIFontFamilyAttribute, 
                        IFlexUIFontGridFitTypeAttribute, IFlexUIFontSharpnessAttribute, IFlexUIFontSizeAttribute, 
                        IFlexUIFontStyleAttribute, IFlexUIFontThicknessAttribute, IFlexUIFontWeightAttribute, 
                        IFlexUIHighlightAlphasAttribute, IFlexUIIconColorAttribute, IFlexUILeadingAttribute, IFlexUIOpenDurationAttribute, 
                        IFlexUIOpenEasingFunctionAttribute, IFlexUIPaddingTopAttribute, IFlexUIPaddingBottomAttribute, 
                        IFlexUIPaddingLeftAttribute, IFlexUIPaddingRightAttribute, IFlexUIRollOverColorAttribute, 
                        IFlexUISelectionColorAttribute, IFlexUISelectionDurationAttribute, IFlexUISelectionEasingFunctionAttribute, 
                        IFlexUITextAlignAttribute, IFlexUITextDecorationAttribute, IFlexUITextIndentAttribute, 
                        IFlexUITextRollOverColorAttribute, IFlexUITextSelectedColorAttribute, IFlexUIChangeAttribute, 
                        IFlexUICloseAttribute, IFlexUIDataChangeAttribute, IFlexUIEnterAttribute, IFlexUIItemRollOutAttribute, 
                        IFlexUIItemRollOverAttribute, IFlexUIOpenAttribute, IFlexUIScrollAttribute, IFlexUIDataProviderCollectionAttribute, 
                        IFlexUIDataProviderAttribute, IFlexUIEditableAttribute, IFlexUISelectedIndexAttribute, 
                        IFlexUITextAttribute {
	
	private final static Log _log = LogFactory.getLog(AbstractFlexUIComboBox.class);
	
	private static final String COMBO_BOX_UICOMPONENT_PACKAGE_IMPORT = "mx.controls.ComboBox";
	
	private static final String DATA_PROPERTY = "data";
	private static final String LABEL_PROPERTY = "label";
	
	private static final String TEXT_ATTR = "text";
	private static final String TEXT_ID_APPENDED = "_text";
	
	private JSONObject initValue;
	
	{
		try{
			initValue = new JSONObject();
			initValue.put(ATTRIBUTE, TEXT_ATTR);
			
			_initValues.put(initValue);
			
		}catch(JSONException jsonException){
			_log.info("Error while formatting to JSON content", jsonException);
		}
	}
	
	protected void populateComponentInitValues(){
		super.populateComponentInitValues();
		
		try{
			if(getText() != null){
				initValue.put(VALUE, FlexJsfUtil.escapeCharacters( getText() ));
			}
		}catch(JSONException jsonException){
			_log.info("Error while formatting to JSON content", jsonException);
		}
	}
	
	public void encodeBegin(FacesContext context) throws IOException {
		super.encodeBegin(context);
		
		Collection<? extends Object> dataProviderCollection = getDataProviderCollection();
		if(dataProviderCollection != null && dataProviderCollection.size() > 0){
			//For AbstractFlexUIComboBox, entries within the collection must be of type SelectItem
			AbstractFlexContext mxmlContext = AbstractFlexContext.getCurrentInstance();
			AdditionalApplicationScriptContent additionalApplicationScriptContent = mxmlContext.getAdditionalAppScriptContent();
			additionalApplicationScriptContent.addActionScriptImport(COMBO_BOX_UICOMPONENT_PACKAGE_IMPORT);
			
			JSONArray comboBoxContent = new JSONArray();
			for(Object currInstace : dataProviderCollection){
				SelectItem currSelectItem = SelectItem.class.cast( currInstace );
				
				JSONObject comboBoxEntry = new JSONObject();
				
				try{
					comboBoxEntry.put(DATA_PROPERTY, currSelectItem.getValue().toString());
					comboBoxEntry.put(LABEL_PROPERTY, currSelectItem.getLabel());
					comboBoxContent.put(comboBoxEntry);
				}catch(JSONException jsonException){
					_log.info("Error setting the following content for dataProviderCollection " + 
											currSelectItem.getValue() + currSelectItem.getLabel(), jsonException);
				}
				
			}
			
			additionalApplicationScriptContent.addSimpleDataProviderSetter(getId(), comboBoxContent.toString());
			
		}
		
	}
	
	public void decode(FacesContext context) {
    	super.decode(context);
    	
    	Map<String, String> requestMap = context.getExternalContext().getRequestParameterMap();
    	
    	String textId = getId() + TEXT_ID_APPENDED;
    	String textUpdateVal = requestMap.get(textId);
    	
    	if(textUpdateVal != null){
    		setText(textUpdateVal);
    	}
    }
    
    public void processUpdates(FacesContext context) {
    	super.processUpdates(context);
    	
    	if (!isRendered() || !isValid()){
    		return;
    	}
    	
    	ValueExpression ve = getValueExpression(TEXT_ATTR);
    	
    	if(ve != null && !ve.isReadOnly(context.getELContext())){
    		ve.setValue(context.getELContext(), getText());
    		setText(null);
    	}
    	
    }
	
}
