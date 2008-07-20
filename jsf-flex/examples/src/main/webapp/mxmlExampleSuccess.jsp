<%@ page session="false" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://jsf-flex.googlecode.com" prefix="jf"%>

<html>

<!--
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
//-->

<body>

<f:view>
	
    Tab Navigator Selected Index <h:outputText value="#{mxmlBean.tabNavigatorSelectedIndex}"></h:outputText>
    TextInput Text <h:outputText value="#{mxmlBean.textInputText}"></h:inputText>
    RichTextEditorHtmlText <h:outputText value="#{mxmlBean.richTextEditorHtmlText}"></h:inputTextarea>
    TextArea Text <h:outputText value="#{mxmlBean.textAreaText}"></h:inputTextarea>
    DateField Text <h:outputText value="#{mxmlBean.dateFieldText}"></h:inputText>
    CheckBox Selected <h:outputText value="#{mxmlBean.checkBoxSelected}"></h:outputText>
    ComboBox Text <h:outputText value="#{mxmlBean.comboBoxText}"></h:outputText>
    RadioButtonSelected Value <h:outputText value="#{mxmlBean.radioButtonSelectedValue}"></h:outputText>
    NumericStepper Value <h:outputText value="#{mxmlBean.numericStepperValue}"></h:outputText>
    ColorPicker SelectedColor <h:outputText value="#{mxmlBean.colorPickerSelectedColor}"></h:outputText>
    List SelectedIndex <h:outputText value="#{mxmlBean.listSelectedIndex}"></h:outputText>
    Tree SelectedIndex <h:outputText value="#{mxmlBean.treeSelectedIndex}"></h:outputText>
    HorizontalSlider Value <h:outputText value="#{mxmlBean.horizontalSliderValue}"></h:outputText>
    VerticalSlider Value <h:outputText value="#{mxmlBean.verticalSliderValue}"></h:outputText>
	
</f:view>

<%@include file="inc/page_footer.jsp" %>

</body>

</html>
