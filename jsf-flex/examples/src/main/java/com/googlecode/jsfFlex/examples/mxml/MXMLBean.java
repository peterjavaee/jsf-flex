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
package com.googlecode.jsfFlex.examples.mxml;

import java.io.Serializable;

import com.googlecode.jsfFlex.shared.beans.mxml.MXMLArrayBean;
import com.googlecode.jsfFlex.shared.beans.mxml.MXMLObjectBean;
import com.googlecode.jsfFlex.shared.beans.mxml._MXMLBean;
import com.googlecode.jsfFlex.shared.util.MXMLConstants;

/**
 * A simple bean to demonstrate the binding of the fields.<br>
 * 
 * @author Ji Hoon Kim
 */
public class MXMLBean implements Serializable {
	
	private static final long serialVersionUID = -6445125288869734960L;
	
	private Integer _accordionSelectedIndex;
	private Integer _tabNavigatorSelectedIndex;
	private String _textInputText;
	private String _richTextEditorHtmlText;
	private String _textAreaText;
	private String _dateFieldText;
	private Boolean _checkBoxSelected;
	private Integer _comboBoxSelectedIndex;
	private String _comboBoxText;
	private Boolean _radioButtonFirstSelected;
	private Boolean _radioButtonSecondSelected;
	private String _radioButtonSelectedValue;
	private String _numericStepperValue;
	private String _colorPickerSelectedColor;
	private Integer _listSelectedIndex;
	private Integer _treeSelectedIndex;
	private String _horizontalSliderValue;
	private String _verticalSliderValue;
	private String _progressBarValue;
	private MXMLArrayBean _comboBoxDataProviderMXMLBean;
	
	public MXMLBean(){
		super();
		_accordionSelectedIndex = new Integer(0);
		_tabNavigatorSelectedIndex = new Integer(0);
		_textInputText = "";
		_richTextEditorHtmlText = "";
		_textAreaText = "";
		_dateFieldText = "";
		_checkBoxSelected = Boolean.valueOf(false);
		_comboBoxSelectedIndex = new Integer(0);
		_comboBoxText = "";
		_radioButtonFirstSelected = Boolean.valueOf(false);
		_radioButtonSecondSelected = Boolean.valueOf(false);
		_radioButtonSelectedValue = "";
		_numericStepperValue = "";
		_listSelectedIndex = new Integer(0);
		_treeSelectedIndex = new Integer(0);
		_horizontalSliderValue = "";
		_verticalSliderValue = "";
		_progressBarValue = "";
		
		_comboBoxDataProviderMXMLBean = new MXMLArrayBean(Boolean.TRUE);
		MXMLObjectBean _mxmlObjectBean = new MXMLObjectBean(Boolean.FALSE);
		
		String label = "label";
		String data = MXMLConstants.STRING_QUOTE + "First" + MXMLConstants.STRING_QUOTE;
		_mxmlObjectBean.addData(label, data);
		
		label = "data";
		data = MXMLConstants.STRING_QUOTE + "First" + MXMLConstants.STRING_QUOTE;
		_mxmlObjectBean.addData(label, data);
		
		
		_comboBoxDataProviderMXMLBean.addBean(_mxmlObjectBean);
		
		_mxmlObjectBean = new MXMLObjectBean(Boolean.FALSE);
		
		label = "label";
		data = MXMLConstants.STRING_QUOTE + "Second" + MXMLConstants.STRING_QUOTE;
		_mxmlObjectBean.addData(label, data);
		
		label = "data";
		data = MXMLConstants.STRING_QUOTE + "Second" + MXMLConstants.STRING_QUOTE;
		_mxmlObjectBean.addData(label, data);
		
		_comboBoxDataProviderMXMLBean.addBean(_mxmlObjectBean);
		
	}
	
	public Integer getAccordionSelectedIndex() {
		return _accordionSelectedIndex;
	}
	public void setAccordionSelectedIndex(Integer accordionSelectedIndex) {
		_accordionSelectedIndex = accordionSelectedIndex;
	}
	public Boolean getCheckBoxSelected() {
		return _checkBoxSelected;
	}
	public void setCheckBoxSelected(Boolean checkBoxSelected) {
		_checkBoxSelected = checkBoxSelected;
	}
	public String getColorPickerSelectedColor() {
		return _colorPickerSelectedColor;
	}
	public void setColorPickerSelectedColor(String colorPickerSelectedColor) {
		_colorPickerSelectedColor = colorPickerSelectedColor;
	}
	public _MXMLBean getComboBoxDataProviderMXMLBean() {
		return _comboBoxDataProviderMXMLBean;
	}
	public void setComboBoxDataProviderMXMLBean(MXMLArrayBean comboBoxDataProviderMXMLBean) {
		_comboBoxDataProviderMXMLBean = comboBoxDataProviderMXMLBean;
	}
	public Integer getComboBoxSelectedIndex() {
		return _comboBoxSelectedIndex;
	}
	public void setComboBoxSelectedIndex(Integer comboBoxSelectedIndex) {
		_comboBoxSelectedIndex = comboBoxSelectedIndex;
	}
	public String getComboBoxText() {
		return _comboBoxText;
	}
	public void setComboBoxText(String comboBoxText) {
		_comboBoxText = comboBoxText;
	}
	public String getDateFieldText() {
		return _dateFieldText;
	}
	public void setDateFieldText(String dateFieldText) {
		_dateFieldText = dateFieldText;
	}
	public String getHorizontalSliderValue() {
		return _horizontalSliderValue;
	}
	public void setHorizontalSliderValue(String horizontalSliderValue) {
		_horizontalSliderValue = horizontalSliderValue;
	}
	public Integer getListSelectedIndex() {
		return _listSelectedIndex;
	}
	public void setListSelectedIndex(Integer listSelectedIndex) {
		_listSelectedIndex = listSelectedIndex;
	}
	public String getNumericStepperValue() {
		return _numericStepperValue;
	}
	public void setNumericStepperValue(String numericStepperValue) {
		_numericStepperValue = numericStepperValue;
	}
	public String getProgressBarValue() {
		return _progressBarValue;
	}
	public void setProgressBarValue(String progressBarValue) {
		_progressBarValue = progressBarValue;
	}
	public Boolean getRadioButtonFirstSelected() {
		return _radioButtonFirstSelected;
	}
	public void setRadioButtonFirstSelected(Boolean radioButtonFirstSelected) {
		_radioButtonFirstSelected = radioButtonFirstSelected;
	}
	public Boolean getRadioButtonSecondSelected() {
		return _radioButtonSecondSelected;
	}
	public void setRadioButtonSecondSelected(Boolean radioButtonSecondSelected) {
		_radioButtonSecondSelected = radioButtonSecondSelected;
	}
	public String getRadioButtonSelectedValue() {
		return _radioButtonSelectedValue;
	}
	public void setRadioButtonSelectedValue(String radioButtonSelectedValue) {
		_radioButtonSelectedValue = radioButtonSelectedValue;
	}
	public String getRichTextEditorHtmlText() {
		return _richTextEditorHtmlText;
	}
	public void setRichTextEditorHtmlText(String richTextEditorHtmlText) {
		_richTextEditorHtmlText = richTextEditorHtmlText;
	}
	public Integer getTabNavigatorSelectedIndex() {
		return _tabNavigatorSelectedIndex;
	}
	public void setTabNavigatorSelectedIndex(Integer tabNavigatorSelectedIndex) {
		_tabNavigatorSelectedIndex = tabNavigatorSelectedIndex;
	}
	public String getTextAreaText() {
		return _textAreaText;
	}
	public void setTextAreaText(String textAreaText) {
		_textAreaText = textAreaText;
	}
	public String getTextInputText() {
		return _textInputText;
	}
	public void setTextInputText(String textInputText) {
		_textInputText = textInputText;
	}
	public Integer getTreeSelectedIndex() {
		return _treeSelectedIndex;
	}
	public void setTreeSelectedIndex(Integer treeSelectedIndex) {
		_treeSelectedIndex = treeSelectedIndex;
	}
	public String getVerticalSliderValue() {
		return _verticalSliderValue;
	}
	public void setVerticalSliderValue(String verticalSliderValue) {
		_verticalSliderValue = verticalSliderValue;
	}
	
}
