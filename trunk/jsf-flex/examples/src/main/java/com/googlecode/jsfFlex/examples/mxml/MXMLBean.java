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
package com.googlecode.jsfFlex.mxml;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ji Hoon Kim
 */
public class MXMLBean implements Serializable {
	
	private static final long serialVersionUID = -6445125288869734960L;
	
	private Integer _tabNavigatorSelectedIndex;
	private String _textInputText;
	private String _richTextEditorHtmlText;
	private String _textAreaText;
	private String _dateFieldText;
	private Boolean _checkBoxSelected;
	private String _comboBoxText;
	private String _radioButtonSelectedValue;
	private String _numericStepperValue;
	private String _colorPickerSelectedColor;
	private Integer _listSelectedIndex;
	private Integer _treeSelectedIndex;
	private String _horizontalSliderValue;
	private String _verticalSliderValue;
	
	private List _menuList;
		
	public MXMLBean(){
		super();
		_tabNavigatorSelectedIndex = new Integer(0);
		_textInputText = new String();
		_richTextEditorHtmlText = new String();
		_textAreaText = new String();
		_dateFieldText = new String();
		_checkBoxSelected = new Boolean(false);
		_comboBoxText = new String();
		_radioButtonSelectedValue = new String();
		_numericStepperValue = new String();
		_listSelectedIndex = new Integer(0);
		_treeSelectedIndex = new Integer(0);
		_horizontalSliderValue = new String();
		_verticalSliderValue = new String();
		_menuList = new LinkedList();
		_menuList.add("First Menu");
		_menuList.add("Second Menu");
		_menuList.add("Third Menu");
		_menuList.add("Fourth Menu");
		
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
	public List getMenuList() {
		return _menuList;
	}
	public void setMenuList(List menuList) {
		_menuList = menuList;
	}
	public String getNumericStepperValue() {
		return _numericStepperValue;
	}
	public void setNumericStepperValue(String numericStepperValue) {
		_numericStepperValue = numericStepperValue;
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
