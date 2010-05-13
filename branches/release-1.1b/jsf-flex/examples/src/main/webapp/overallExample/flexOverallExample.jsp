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
#descriptionStyle{
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

<f:view renderKitId="FLEX_BASIC">
	
	<h:form>
		<div>
    	The button on the right is to test out the decode process and make sure that the information is mapped correctly.
    	<h:commandButton value="DecodeTester" action="success" /> <br/>
    	Also there exists a button  and a linkButton within flexApplication that will also perform a submission.
    	</div>
    	
        <div id="descriptionStyle">
            Note that the client validation for the component with id textInputRef [namely flexNumberValidator] is not a child tag
            of the flexTextInput tag. <br/>However the regular validation tag [validateLongRange] is a child tag which performs the validation
            on the server side.
            <br />
            <h:message for="textAreaRef" errorClass="errorStyle" />
        </div>
        <br />
        
	    <jf:flexApplication mxmlPackageName="flexOverallExample" height="90%" width="90%" errorColor="#B80000" errorFontSize="13">
	    	<jf:flexLabel text="Following label contains korean text to demonstrate locale [if browser's language is set to korean]" color="#FFFFFF" fontWeight="bold"/>
	    	<jf:flexLabel text="@Resource(bundle='LocaleExample', key='greeting')" color="#FFFFFF" fontWeight="bold" fontSize="14"/>
	    	
	        <jf:flexScript>
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
				
				public var complexStruct:XMLList = <root>
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
													</root>.menuitem;
				[Bindable]
				public var complexStructCollection:XMLListCollection = new XMLListCollection(complexStruct);
				
				private function increaseProgressBar():void{
					progressBarRef.setProgress((progressBarRef.value + 10) % 110, 100);
				}
				
				private function decreaseProgressBar():void{
					progressBarRef.setProgress(progressBarRef.value == 0 ? 0 : progressBarRef.value - 10, 100);
				}
				
		    </jf:flexScript>
		    <!-- Validation on the client side -->
		    <jf:flexNumberValidator exceedsMaxError="The number provided exceeds max value [60]." property="text"
		    						domain="int" integerError="Must be an integer value."
			    					lowerThanMinError="The number provided is lower than min value [10]." maxValue="60" minValue="10" 
			    					required="true" source="{textInputRef}" />
			
			<jf:flexAccordion width="100%" height="100%" selectedIndex="#{flexOverallBean.accordionSelectedIndex}">
			    
				<jf:flexTabNavigator width="100%" height="100%" selectedIndex="#{flexOverallBean.tabNavigatorSelectedIndex}">
						
			    		<jf:flexPanel label="First Tab" width="100%" height="100%">
			    			<jf:flexDividedBox direction="horizontal" width="100%" height="100%">
			    			
				    			<jf:flexBox width="30%" height="100%">
					    			<jf:flexTextInput id="textInputRef" text="#{flexOverallBean.textInputText}" />
					    			<jf:flexRichTextEditor textBinding="htmlText" htmlText="#{flexOverallBean.richTextEditorHtmlText}" />
							    	<jf:flexTextArea id="textAreaRef" text="#{flexOverallBean.textAreaText}" >
							    		<f:validateLongRange minimum="10" maximum="60" />
							    	</jf:flexTextArea>
							    	<jf:flexDateField text="#{flexOverallBean.dateFieldText}" width="100" />
							    	<jf:flexCheckBox label="CheckBox am I [\^$.|?*+(){}" selected="#{flexOverallBean.checkBoxSelected}" />
						    	</jf:flexBox>
						    	
						    	<jf:flexBox width="70%" height="100%">
						    		<jf:flexDataGrid bindingBeanList="#{flexOverallBean.wisePeopleEntries}" width="100%" 
						    							rowCount="4" resizableColumns="true" editable="true">
								    	<jf:flexColumns>
								    		<jf:flexDataGridColumn dataField="name" headerText="Name" />
								    		<jf:flexDataGridColumn wordWrap="true" dataField="quote" headerText="Quote" minWidth="170" />
								    		<jf:flexDataGridColumn dataField="email" headerText="Email" />
								    	</jf:flexColumns>
								    </jf:flexDataGrid>
							   </jf:flexBox>
					    	
					    	</jf:flexDividedBox>
					    </jf:flexPanel>
			    			
			    		<jf:flexPanel label="Second Tab" width="100%" height="100%">
					    	<jf:flexComboBox text="#{flexOverallBean.comboBoxText}" selectedIndex="#{flexOverallBean.comboBoxSelectedIndex}" 
					    							dataProviderCollection="#{flexOverallBean.comboBoxDisplayEntries}" />
					    	<jf:flexRadioButton groupName="radioTest" label="First" value="First" 
					    							selectedValue="#{flexOverallBean.radioButtonSelectedValue}" selected="#{flexOverallBean.radioButtonFirstSelected}"/>
					       	<jf:flexRadioButton groupName="radioTest" label="Second" value="Second" selected="#{flexOverallBean.radioButtonSecondSelected}"/>
					       	
					       	<jf:flexNumericStepper minimum="0" maximum="10" value="#{flexOverallBean.numericStepperValue}" />
					       	<jf:flexColorPicker labelField="ColorPicker am I" selectedColor="#{flexOverallBean.colorPickerSelectedColor}" />
					       	<jf:flexDateChooser selectedDate="#{flexFaceletOverallBean.selectedDate}" width="300" />
			    		</jf:flexPanel>
	
			    </jf:flexTabNavigator>
			            	
		       	<jf:flexPanel width="100%" height="100%">
			    		  
			    		  <jf:flexDividedBox direction="horizontal" width="100%" height="100%">
			    		  	
			    		  	<jf:flexBox width="50%" height="100%">
				    			<jf:flexLinkButton action="success" label="To Submit" />
				        		<jf:flexButton label="Click Me for a nice message" buttonDown="alertMe();"/>
				        		<jf:flexButton action="#{flexOverallBean.buttonAction}" label="Will submit the form"/>
				        		<jf:flexLabel text="Simple List" />
				        		<jf:flexList width="100" dataProvider="{reallySimpleArray}" selectedIndex="#{flexOverallBean.listSelectedIndex}" />
				        		<jf:flexTree width="100" dataProvider="{complexStructCollection}" labelField="@label" selectedIndex="#{flexOverallBean.treeSelectedIndex}"/>
				        	</jf:flexBox>
				        	
			        		<jf:flexBox width="50%" height="100%">
				        		<jf:flexLabel text="Simple ButtonBar" />
				        		<jf:flexButtonBar>
				        			<jf:flexDataProvider>
	                                    <jf:flexObject>
	                                    	<jf:flexObjectStaticProperty staticPropertyName="label" staticPropertyValue="First Nesting" />
	                                    </jf:flexObject>
	                                    <jf:flexObject>
	                                    	<jf:flexObjectStaticProperty staticPropertyName="label" staticPropertyValue="Second Nesting" />
	                                    </jf:flexObject>
	                                </jf:flexDataProvider>
				        		</jf:flexButtonBar>
				        		<jf:flexLabel text="Simple ToggleButtonBar" />
				        		<jf:flexToggleButtonBar dataProvider="{reallySimpleArray}" />
				        		
				        		<jf:flexLabel text="Simple TabBar" />
				        		<jf:flexTabBar dataProvider="{reallySimpleArray}" />
				        		<jf:flexLabel text="Simple LinkBar" />
				        		<jf:flexLinkBar dataProvider="{reallySimpleArray}" />
				        	</jf:flexBox>
			        		
				          </jf:flexDividedBox>
				          
				</jf:flexPanel>
				
				<jf:flexBox width="100%" height="100%">
				
					<jf:flexBox width="100%" height="40%">
						
						<jf:flexLabel text="Simple VScrollBar" />
						<jf:flexVScrollBar />
						<jf:flexSpacer height="10" />
						
						<jf:flexLabel text="Simple HScrollBar" />
						<jf:flexHScrollBar />
						
						<jf:flexSpacer height="20" />
				        <jf:flexHRule width="100%" />
				        <jf:flexSpacer height="20" />
					    
						<jf:flexLabel text="Simple HSlider" />
						<jf:flexHSlider value="#{flexOverallBean.horizontalSliderValue}" />
						<jf:flexSpacer height="10" />
							
						<jf:flexLabel text="Simple VSlider" />
						<jf:flexVSlider value="#{flexOverallBean.verticalSliderValue}" />
						
					</jf:flexBox>
					
					<jf:flexTitleWindow title="Title Window" x="168" y="86" borderStyle="inset">
					    
					    <jf:flexTile>
					        <jf:flexButton label="Increase Progress Bar" buttonDown="increaseProgressBar();"/>
					        <jf:flexButton label="Decrease Progress Bar" buttonDown="decreaseProgressBar();" />
					    </jf:flexTile>
					    
					    <jf:flexProgressBar id="progressBarRef" mode="manual" minimum="0" maximum="100"	value="#{flexOverallBean.progressBarValue}" />
					    
					</jf:flexTitleWindow>
					
				</jf:flexBox>
				
			</jf:flexAccordion>
			
			<jf:flexApplicationControlBar dock="true">
	        	<jf:flexMenuBar dataProvider="{complexStructCollection}" labelField="@label" />
			    <jf:flexPopUpButton creationComplete="initMenu(event);" width="135" />
			    <jf:flexPopUpMenuButton dataProvider="{complexStructCollection}" labelField="@label" />
			</jf:flexApplicationControlBar>
			    		  
	    </jf:flexApplication>
    
    </h:form>
</f:view>

</body>

</html>
