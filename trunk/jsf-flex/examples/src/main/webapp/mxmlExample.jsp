<%@ page session="false" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
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
<head>
<style type="text/css">
.descriptionStyle{
    color:#708090;
    font-family:verdana;
    font-size:11px;
    font-weight:700;
}

.errorStyle{
    color:#ff6666;
    font-family:verdana;
    font-size:11px;
    font-weight:700;
}
</style>
</head>
<body>

<f:view renderKitId="MXML_BASIC">
	
	<h:form>
    	The button on the right is to test out the decode process and make sure that the information is mapped correctly
    	
    	<h:commandButton value="DecodeTester" action="success" />
        <br>
        <div class="descriptionStyle">
            Note that the client validation for the component with id textInputRef [namely mxmlNumberValidator] is not a child tag
            of the mxmlTextInput tag. However the regular validation tag [validateLongRange] is a child tag which performs the validation
            on the server side. In future it is thought to prevent submission of data if there exists errors.
            <br>
            <h:message for="textInputRef" errorClass="errorStyle" />
        </div>
        <br>
        
	    <jf:mxmlApplication mxmlPackageName="anotherSwf" height="5%" width="90%" verticalScrollPolicy="off" backgroundColor="0xCC6666">
	    	<jf:mxmlLabel text="I simply am an another SWF file. DHan, DHAn, DHAN!!!" color="#FFFFFF" fontWeight="bold"/>
	    </jf:mxmlApplication>
	    
	    <jf:mxmlApplication mxmlPackageName="initialPackage" height="85%" width="90%" errorColor="#B80000" errorFontSize="13">
	        <jf:mxmlScript>
	        	import flash.events.Event;
	        	
		    	import mx.collections.XMLListCollection;
		    	import mx.controls.Alert;
		    	import mx.controls.Menu;
		    	import mx.controls.PopUpButton;
		    	import mx.events.MenuEvent;
		    	
		    	private function alertMe():void {
		    		Alert.show("Uhm, I have been alerted");
		    	}
		    	
		    	private var myMenu:Menu;
		    	private var popUpButton:PopUpButton;
				
				private function initMenu(event:Event):void {
	                myMenu = new Menu();
	                var dp:Object = [{label: "New Folder"}, {label: "Sent Items"}, {label: "Inbox"}];        
	                myMenu.dataProvider = dp;
	                myMenu.selectedIndex = 0;
	                myMenu.addEventListener("itemClick", itemClickHandler);
	                popUpButton = event.target as PopUpButton;
	                popUpButton.popUp = myMenu;
	                popUpButton.label = "Put in: " + myMenu.dataProvider[myMenu.selectedIndex].label;
	            }
	            
	            private function itemClickHandler(event:MenuEvent):void {
	                var label:String = event.item.label;        
	                popUpButton.label = "Put in: " + label;
	                popUpButton.close();
	                myMenu.selectedIndex = event.index;
	            }
		    	
		    	[Bindable]
				public var reallySimpleArray:Array = ["First", "Second", "Third"];
				
				public var complexStruct:XMLList = <>
														<menuitem label="Menu1">
									                        <menuitem label="MenuItem 1-A" data="1A"/>
									                        <menuitem label="MenuItem 1-B" data="1B"/>
									                    </menuitem>
									                    <menuitem label="Menu2">
									                        <menuitem label="MenuItem 2-A" type="check"  data="2A"/>
									                        <menuitem type="separator" />
									                        <menuitem label="MenuItem 2-B" >
									                            <menuitem label="SubMenuItem 3-A" type="radio"
									                                groupName="one" data="3A"/>
									                            <menuitem label="SubMenuItem 3-B" type="radio"
									                                groupName="one" data="3B"/>
									                        </menuitem>
									                    </menuitem>
													</>;
				[Bindable]
				public var complexStructCollection:XMLListCollection = new XMLListCollection(complexStruct);
				
				private function increaseProgressBar():void{
					progressBarRef.setProgress((progressBarRef.value + 10) % 110, 100);
				}
				
				private function decreaseProgressBar():void{
					progressBarRef.setProgress(progressBarRef.value == 0 ? 0 : progressBarRef.value - 10, 100);
				}
				
		    </jf:mxmlScript>
		    <!-- Validation on the client side -->
		    <jf:mxmlNumberValidator exceedsMaxError="The number provided exceeds max value [60]." property="text"
		    						domain="int" integerError="Must be an integer value."
			    					lowerThanMinError="The number provided is lower than min value [10]." maxValue="60" minValue="10" 
			    					required="true" source="{textInputRef}" />
			
			<jf:mxmlAccordion width="100%" height="100%" selectedIndex="#{mxmlBean.accordionSelectedIndex}">
			    
				<jf:mxmlTabNavigator width="100%" height="100%" selectedIndex="#{mxmlBean.tabNavigatorSelectedIndex}">
						
			    		<jf:mxmlPanel label="First Tab" width="100%" height="100%">
			    			<jf:mxmlDividedBox direction="horizontal" width="100%" height="100%">
			    			
				    			<jf:mxmlBox width="40%" height="100%">
					    			<jf:mxmlTextInput id="textInputRef" text="#{mxmlBean.textInputText}" >
					    				<f:validateLongRange minimum="10" maximum="60" />
					    			</jf:mxmlTextInput>
					    			<jf:mxmlRichTextEditor textBinding="htmlText" htmlText="#{mxmlBean.richTextEditorHtmlText}" />
							    	<jf:mxmlTextArea text="#{mxmlBean.textAreaText}" />
							    	<jf:mxmlDateField text="#{mxmlBean.dateFieldText}" />
							    	<jf:mxmlCheckBox label="CheckBox am I [\^$.|?*+(){}" selected="#{mxmlBean.checkBoxSelected}" />
						    	</jf:mxmlBox>
						    	
						    	<jf:mxmlBox width="60%" height="100%">
						    		<jf:mxmlDataGrid width="100%" rowCount="4" rowHeight="110" resizableColumns="true">
						    			<jf:mxmlColumns>
						    				<jf:mxmlDataGridColumn dataField="name" headerText="Name" columnData="#{mxmlBean.nameColumnData}" />
						    				<jf:mxmlDataGridColumn wordWrap="true" dataField="quote" headerText="Quote" columnData="#{mxmlBean.quoteColumnData}" />
						    				<jf:mxmlDataGridColumn dataField="email" headerText="Email" columnData="#{mxmlBean.emailColumnData}" />
						    			</jf:mxmlColumns>
						    		</jf:mxmlDataGrid>
						    	</jf:mxmlBox>
					    	
					    	</jf:mxmlDividedBox>
					    </jf:mxmlPanel>
			    			
			    		<jf:mxmlPanel label="Second Tab" width="100%" height="100%">
					    	<jf:mxmlComboBox text="#{mxmlBean.comboBoxText}" selectedIndex="#{mxmlBean.comboBoxSelectedIndex}" 
					    							dataProviderCollection="#{mxmlBean.comboBoxDisplayEntries}" />
					    	<jf:mxmlRadioButton groupName="radioTest" label="First" value="First" 
					    							selectedValue="#{mxmlBean.radioButtonSelectedValue}" selected="#{mxmlBean.radioButtonFirstSelected}"/>
					       	<jf:mxmlRadioButton groupName="radioTest" label="Second" value="Second" selected="#{mxmlBean.radioButtonSecondSelected}"/>
					       	
					       	<jf:mxmlNumericStepper minimum="0" maximum="10" value="#{mxmlBean.numericStepperValue}" />
					       	<jf:mxmlColorPicker labelField="ColorPicker am I" selectedColor="#{mxmlBean.colorPickerSelectedColor}" />
			    		</jf:mxmlPanel>
	
			    </jf:mxmlTabNavigator>
			            	
		       	<jf:mxmlPanel width="100%" height="100%">
			    		  
			    		  <jf:mxmlDividedBox direction="horizontal" width="100%" height="100%">
			    		  	
			    		  	<jf:mxmlBox width="50%" height="100%">
				    			<jf:mxmlLinkButton label="To Link to something" />
				        		<jf:mxmlButton label="Click Me for a nice message" buttonDown="alertMe();"/>
				        		<jf:mxmlLabel text="Simple List" />
				        		<jf:mxmlList width="100" dataProvider="{reallySimpleArray}" selectedIndex="#{mxmlBean.listSelectedIndex}" />
				        		<jf:mxmlTree width="100" dataProvider="{complexStructCollection}" labelField="@label" selectedIndex="#{mxmlBean.treeSelectedIndex}"/>
				        	</jf:mxmlBox>
				        	
			        		<jf:mxmlBox width="50%" height="100%">
				        		<jf:mxmlLabel text="Simple ButtonBar" />
				        		<jf:mxmlButtonBar>
				        			<jf:mxmlDataProvider>
	                                    <jf:mxmlObject label="First Nesting" />
	                                    <jf:mxmlObject label="Second Nesting" />
	                                </jf:mxmlDataProvider>
				        		</jf:mxmlButtonBar>
				        		<jf:mxmlLabel text="Simple ToggleButtonBar" />
				        		<jf:mxmlToggleButtonBar dataProvider="{reallySimpleArray}" />
				        		
				        		<jf:mxmlLabel text="Simple TabBar" />
				        		<jf:mxmlTabBar dataProvider="{reallySimpleArray}" />
				        		<jf:mxmlLabel text="Simple LinkBar" />
				        		<jf:mxmlLinkBar dataProvider="{reallySimpleArray}" />
				        	</jf:mxmlBox>
			        		
				          </jf:mxmlDividedBox>
				          
				</jf:mxmlPanel>
				
				<jf:mxmlBox width="100%" height="100%">
				
					<jf:mxmlBox width="100%" height="40%">
						
						<jf:mxmlLabel text="Simple VScrollBar" />
						<jf:mxmlVScrollBar />
						<jf:mxmlSpacer height="10" />
						
						<jf:mxmlLabel text="Simple HScrollBar" />
						<jf:mxmlHScrollBar />
						
						<jf:mxmlSpacer height="20" />
				        <jf:mxmlHRule width="100%" />
				        <jf:mxmlSpacer height="20" />
					    
						<jf:mxmlLabel text="Simple HSlider" />
						<jf:mxmlHSlider value="#{mxmlBean.horizontalSliderValue}" />
						<jf:mxmlSpacer height="10" />
							
						<jf:mxmlLabel text="Simple VSlider" />
						<jf:mxmlVSlider value="#{mxmlBean.verticalSliderValue}" />
						
					</jf:mxmlBox>
					
					<jf:mxmlTitleWindow title="Title Window" x="168" y="86" borderStyle="inset">
					    
					    <jf:mxmlTile>
					        <jf:mxmlButton label="Increase Progress Bar" buttonDown="increaseProgressBar();"/>
					        <jf:mxmlButton label="Decrease Progress Bar" buttonDown="decreaseProgressBar();" />
					    </jf:mxmlTile>
					    
					    <jf:mxmlProgressBar id="progressBarRef" mode="manual" minimum="0" maximum="100"	value="#{mxmlBean.progressBarValue}" />
					    
					</jf:mxmlTitleWindow>
					
				</jf:mxmlBox>
				
			</jf:mxmlAccordion>
			
			<jf:mxmlApplicationControlBar dock="true">
	        	<jf:mxmlMenuBar dataProvider="{complexStructCollection}" labelField="@label" />
			    <jf:mxmlPopUpButton creationComplete="initMenu(event);" width="135" />
			    <jf:mxmlPopUpMenuButton dataProvider="{complexStructCollection}" labelField="@label" />
			</jf:mxmlApplicationControlBar>
			    		  
	    </jf:mxmlApplication>
    
    </h:form>
</f:view>

</body>

</html>
