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
package com.googlecode.jsfFlex.component.attributes;

/**
 * @JSFJspProperties
 * 		properties	=		
 *   						@JSFJspProperty
 * 							 name		= "todayStyleName"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Name of the style sheet definition to configure the appearance of the current day's numeric text, which is highlighted in the control when the showToday property is true. Specify a color style to change the font color. If omitted, the current day textinherits the text styles of the control."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "todayColor"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Color of the background of today's date. The default value is 0x2B333C."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "yearNavigationEnabled"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Enables year navigation."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "disabledRanges"
 *   						 returnType	= "java.lang.String" 
 *   						 longDesc	= "Disables single and multiple days."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "displayedMonth"
 *   						 returnType	= "java.lang.String" 
 *   						 longDesc	= "Used together with the displayedYear property, the displayedMonth property specifies the month displayed in the control."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "selectedDate"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Date selected in the control."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "displayedYear"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Used together with the displayedMonth property, the displayedYear property specifies the month displayed in the control."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "showToday"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "If true, specifies that today is highlighted in the DateChooser control."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "firstDayOfWeek"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Number representing the day of the week to display in the first column of the control."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "dayNames"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The weekday names for the control."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "monthNames"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Names of the months displayed at the top of the DateChooser control."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "disabledDays"
 *   						 returnType	= "java.lang.String" 
 *   						 longDesc	= "The days to disable in a week."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "selectableRange"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Range of dates between which dates are selectable."
 *   						,
 *   						
 *   						@JSFJspProperty
 *   						 name		= "yearSymbol"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "This property is appended to the end of the year displayed at the top of the DateChooser control."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "minYear"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "The first year selectable in the control."
 *   						, 
 *   						
 *   						@JSFJspProperty
 *   						 name		= "monthSymbol"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "This property is appended to the end of the value specified by the monthNames property to define the names of the months displayed at the top of the DateChooser control."
 *   						,
 *   						
 *   						@JSFJspProperty
 * 							 name		= "weekDayStyleName"
 *   						 returnType	= "java.lang.String"
 *   						 longDesc	= "Name of the style sheet definition to configure the weekday names of the control. If omitted, the weekday names inherit the text styles of the control."
 *   						
 * @author Ji Hoon Kim
 */
public interface _MXMLUIDateAttributes {
	
	/**
	 * Name of the style sheet definition to configure the appearance of the current day's numeric text, which is highlighted in the control when the showToday property is true. Specify a color style to change the font color. If omitted, the current day text inherits the text styles of the control.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Name of the style sheet definition to configure the appearance of the current day's numeric text, which is highlighted in the control when the showToday property is true. Specify a color style to change the font color. If omitted, the current day text inherits the text styles of the control."
	 */
	String getTodayStyleName();

	/**
	 * Color of the background of today's date. The default value is 0x2B333C.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Color of the background of today's date. The default value is 0x2B333C."
	 */
	String getTodayColor();

	/**
	 * Enables year navigation.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Enables year navigation."
	 */
	String getYearNavigationEnabled();

	/**
	 * Disables single and multiple days.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Disables single and multiple days."
	 */
	String getDisabledRanges();

	/**
	 * Used together with the displayedYear property, the displayedMonth propertyspecifies the month displayed in the control.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Used together with the displayedYear property, the displayedMonth propertyspecifies the month displayed in the control."
	 */
	String getDisplayedMonth();

	/**
	 * Date selected in the control.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Date selected in the control."
	 */
	String getSelectedDate();

	/**
	 * Used together with the displayedMonth property, the displayedYear property specifies themonth displayed in the control.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Used together with the displayedMonth property, the displayedYear property specifies themonth displayed in the control."
	 */
	String getDisplayedYear();

	/**
	 * If true, specifies that today is highlighted in the DateChooser control.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "If true, specifies that today is highlighted in the DateChooser control."
	 */
	String getShowToday();

	/**
	 * Number representing the day of the week to display in the first column of the control.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Number representing the day of the week to display in the first column of the control."
	 */
	String getFirstDayOfWeek();

	/**
	 * The weekday names for the control.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "The weekday names for the control."
	 */
	String getDayNames();

	/**
	 * Names of the months displayed at the top of the DateChooser control.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Names of the months displayed at the top of the DateChooser control."
	 */
	String getMonthNames();

	/**
	 * The days to disable in a week.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "The days to disable in a week."
	 */
	String getDisabledDays();

	/**
	 * Range of dates between which dates are selectable.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "Range of dates between which dates are selectable."
	 */
	String getSelectableRange();

	/**
	 * This property is appended to the end of the year displayed at the top of the DateChoosercontrol.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "This property is appended to the end of the year displayed at the top of the DateChoosercontrol."
	 */
	String getYearSymbol();

	/**
	 * The first year selectable in the control.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "The first year selectable in the control."
	 */
	String getMinYear();

	/**
	 * This property is appended to the end of the value specified by the monthNames property todefine the names of the months displayed at the top of the DateChooser control.
	 * 
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = "This property is appended to the end of the value specified by the monthNames property todefine the names of the months displayed at the top of the DateChooser control."
	 */
	String getMonthSymbol();

	/**
	 *@JSFProperty
	 *    required        = false
	 *    rtexprvalue     = false
	 *    desc            = Name of the style sheet definition to configure the weekday names of the control. If omitted,the weekday names inherit the text styles of the control.
	 */
	String getWeekDayStyleName();
	
}
