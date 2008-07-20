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
package com.googlecode.jsfFlex.renderkit;

import org.apache.myfaces.shared_tomahawk.renderkit.html.HTML;

/**
 * @author Ji Hoon Kim
 */
public interface MXML extends HTML {
	
	//UIComponent Properties
    String CACHE_POLICY_ATTR = "cachePolicy";
    String CURRENT_STATE_ATTR = "currentState";
    String DOUBLE_CLICK_ENABLED_ATTR = "doubleClickEnabled";
    String ENABLED_ATTR = "enabled";
    String EXPLICIT_HEIGHT_ATTR = "explicitHeight";
    String EXPLICIT_MAX_HEIGHT_ATTR = "explicitMaxHeight";
    String EXPLICIT_MAX_WIDTH_ATTR = "explicitMaxWidth";
    String EXPLICIT_MIN_HEIGHT_ATTR = "explicitMinHeight";
    String EXPLICIT_MIN_WIDTH_ATTR = "explicitMinWidth";
    String EXPLICIT_WIDTH_ATTR = "explicitWidth";
    String FOCUS_ENABLED_ATTR = "focusEnabled";
    String INCLUDE_IN_LAYOUT_ATTR = "includeInLayout";
    String MAX_HEIGHT_ATTR = "maxHeight";
    String MAX_WIDTH_ATTR = "maxWidth";
    String MEASURED_HEIGHT_ATTR = "measuredHeight";
    String MEASURED_MIN_HEIGHT_ATTR = "measuredMinHeight";
    String MEASURED_MIN_WIDTH_ATTR = "measuredMinWidth";
    String MEASURED_WIDTH_ATTR = "measuredWidth";
    String MIN_HEIGHT_ATTR = "minHeight";
    String MIN_WIDTH_ATTR = "minWidth";
    String MOUSE_FOCUS_ENABLED_ATTR = "mouseFocusEnabled";
    String PERCENT_HEIGHT_ATTR = "percentHeight";
    String PERCENT_WIDTH_ATTR = "percentWidth";
    String SCALE_X_ATTR = "scaleX";
    String SCALE_Y_ATTR = "scaleY";
    String STATES_ATTR = "states";
    String STYLE_NAME_ATTR = "styleName";
    String TOOL_TIP_ATTR = "toolTip";
    String TRANSITIONS_ATTR = "transitions";
    String VALIDATION_SUB_FIELD_ATTR = "validationSubField";
    String X_ATTR = "x";
    String Y_ATTR = "y";
    
    String[] MXML_UICOMPONENT_PROPERTIES =
    {
    		CACHE_POLICY_ATTR,
    		CURRENT_STATE_ATTR,
    		DOUBLE_CLICK_ENABLED_ATTR,
    		ENABLED_ATTR,
    		EXPLICIT_HEIGHT_ATTR,
    		EXPLICIT_MAX_HEIGHT_ATTR,
    		EXPLICIT_MAX_WIDTH_ATTR,
    		EXPLICIT_MIN_HEIGHT_ATTR,
    		EXPLICIT_MIN_WIDTH_ATTR,
    		EXPLICIT_WIDTH_ATTR,
    		FOCUS_ENABLED_ATTR,
    		HEIGHT_ATTR,
    		ID_ATTR,
    		INCLUDE_IN_LAYOUT_ATTR,
    		MAX_HEIGHT_ATTR,
    		MAX_WIDTH_ATTR,
    		MEASURED_HEIGHT_ATTR,
    		MEASURED_MIN_HEIGHT_ATTR,
    		MEASURED_MIN_WIDTH_ATTR,
    		MEASURED_WIDTH_ATTR,
    		MIN_HEIGHT_ATTR,
    		MIN_WIDTH_ATTR,
    		MOUSE_FOCUS_ENABLED_ATTR,
    		PERCENT_HEIGHT_ATTR,
    		PERCENT_WIDTH_ATTR,
    		SCALE_X_ATTR,
    		SCALE_Y_ATTR,
    		STATES_ATTR,
    		STYLE_NAME_ATTR,
    		TOOL_TIP_ATTR,
    		TRANSITIONS_ATTR,
    		VALIDATION_SUB_FIELD_ATTR,
    		WIDTH_ATTR,
    		X_ATTR,
    		Y_ATTR
    };
  	
    //UIComponent Styles
    String BOTTOM_ATTR = "bottom";
    String ERROR_COLOR_ATTR = "errorColor";
    String FOCUS_BLEND_MODE_ATTR = "focusBlendMode";
    String FOCUS_SKIN_ATTR = "focusSkin";
    String FOCUS_THICKNESS_ATTR = "focusThickness";
    String HORIZONTAL_CENTER_ATTR = "horizontalCenter";
    String LEFT_ATTR = "left";
    String RIGHT_ATTR = "right";
    String THEME_COLOR_ATTR = "themeColor";
    String TOP_ATTR = "top";
    String VERTICAL_CENTER_ATTR = "verticalCenter";
  	
    String[] MXML_UICOMPONENT_STYLES = 
    {
    		BOTTOM_ATTR,
    		ERROR_COLOR_ATTR,
    		FOCUS_BLEND_MODE_ATTR,
    		FOCUS_SKIN_ATTR,
    		FOCUS_THICKNESS_ATTR,
    		HORIZONTAL_CENTER_ATTR,
    		LEFT_ATTR,
    		RIGHT_ATTR,
    		THEME_COLOR_ATTR,
    		TOP_ATTR,
    		VERTICAL_CENTER_ATTR
    };
    
    //UIComponent Effects
    String ADDED_EFFECT_ATTR = "addedEffect";
    String CREATION_COMPLETE_EFFECT_ATTR = "creationCompleteEffect";
    String FOCUS_IN_EFFECT_ATTR = "focusInEffect";
    String FOCUS_OUT_EFFECT_ATTR = "focusOutEffect";
    String HIDE_EFFECT_ATTR = "hideEffect";
    String MOUSE_DOWN_EFFECT_ATTR = "mouseDownEffect";
    String MOUSE_UP_EFFECT_ATTR = "mouseUpEffect";
    String MOVE_EFFECT_ATTR = "moveEffect";
    String REMOVED_EFFECT_ATTR = "removedEffect";
    String RESIZE_EFFECT_ATTR = "resizeEffect";
    String ROLLOUT_EFFECT_ATTR = "rollOutEffect";
    String ROLLOVER_EFFECT_ATTR = "rollOverEffect";
    String SHOW_EFFECT_ATTR = "showEffect";
    
    String[] MXML_UICOMPONENT_EFFECTS = 
    {
    		ADDED_EFFECT_ATTR,
    		CREATION_COMPLETE_EFFECT_ATTR,
    		FOCUS_IN_EFFECT_ATTR,
    		FOCUS_OUT_EFFECT_ATTR,
    		HIDE_EFFECT_ATTR,
    		MOUSE_DOWN_EFFECT_ATTR,
    		MOUSE_UP_EFFECT_ATTR,
    		MOVE_EFFECT_ATTR,
    		REMOVED_EFFECT_ATTR,
    		RESIZE_EFFECT_ATTR,
    		ROLLOUT_EFFECT_ATTR,
    		ROLLOVER_EFFECT_ATTR,
    		SHOW_EFFECT_ATTR	
    };
  	
    //UIComponent Events
    String ADD_ATTR = "add";
    String CREATION_COMPLETE_ATTR = "creationComplete";
    String CURRENT_STATE_CHANGE_ATTR = "currentStateChange";
    String CURRENT_STATE_CHANGING_ATTR = "currentStateChanging";
    String DRAG_COMPLETE_ATTR = "dragComplete";
    String DRAG_DROP_ATTR = "dragDrop";
    String DRAG_ENTER_ATTR = "dragEnter";
    String DRAG_EXIT_ATTR = "dragExit";
    String DRAG_OVER_ATTR = "dragOver";
    String EFFECT_END_ATTR = "effectEnd";
    String EFFECT_START_ATTR = "effectStart";
    String ENTER_STATE_ATTR = "enterState";
    String EXIT_STATE_ATTR = "exitState";
    String HIDE_ATTR = "hide";
    String INITIALIZE_ATTR = "initialize";
    String INVALID_ATTR = "invalid";
    String MOUSE_DOWN_OUTSIDE_ATTR = "mouseDownOutside";
    String MOUSE_WHEEL_OUTSIDE_ATTR = "mouseWheelOutside";
    String MOVE_ATTR = "move";
    String PREINITIALIZE_ATTR = "preinitialize";
    String RECORD_ATTR = "record";
    String REMOVE_ATTR = "remove";
    String RESIZE_ATTR = "resize";
    String SHOW_ATTR = "show";
    String TOOL_TIP_CREATE_ATTR = "toolTipCreate";
    String TOOL_TIP_END_ATTR = "toolTipEnd";
    String TOOL_TIP_HIDE_ATTR = "toolTipHide";
    String TOOL_TIP_SHOW_ATTR = "toolTipShow";
    String TOOL_TIP_SHOWN_ATTR = "toolTipShown";
    String TOOL_TIP_START_ATTR = "toolTipStart";
    String UPDATE_COMPLETE_ATTR = "updateComplete";
    String VALID_ATTR = "valid";
    String VALUE_COMMIT = "valueCommit";
	
    String[] MXML_UICOMPONENT_EVENTS =
    {
    		ADD_ATTR,
    		CREATION_COMPLETE_ATTR,
    		CURRENT_STATE_CHANGE_ATTR,
    		CURRENT_STATE_CHANGING_ATTR,
    		DRAG_COMPLETE_ATTR,
    		DRAG_DROP_ATTR,
    		DRAG_ENTER_ATTR,
    		DRAG_EXIT_ATTR,
    		DRAG_OVER_ATTR,
    		EFFECT_END_ATTR,
    		EFFECT_START_ATTR,
    		ENTER_STATE_ATTR,
    		EXIT_STATE_ATTR,
    		HIDE_ATTR,
    		INITIALIZE_ATTR,
    		INVALID_ATTR,
    		MOUSE_DOWN_OUTSIDE_ATTR,
    		MOUSE_WHEEL_OUTSIDE_ATTR,
    		MOVE_ATTR,
    		PREINITIALIZE_ATTR,
    		RECORD_ATTR,
    		REMOVE_ATTR,
    		RESIZE_ATTR,
    		SHOW_ATTR,
    		TOOL_TIP_CREATE_ATTR,
    		TOOL_TIP_END_ATTR,
    		TOOL_TIP_HIDE_ATTR,
    		TOOL_TIP_SHOW_ATTR,
    		TOOL_TIP_SHOWN_ATTR,
    		TOOL_TIP_START_ATTR,
    		UPDATE_COMPLETE_ATTR,
    		VALID_ATTR,
    		VALUE_COMMIT
    };
    
    /*
     * 
     * Below is a listing of Common :
     * 		Properties
     * 		Styles
     * 		Effects
     * 		Events
     * 
     * Common being defined as at least two components under mx.controls package having the variable
     * but is not an absolute list
     * 
     */
    
    //Common Properties
    String ALIGN_SYMBOL_ATTR = "alignSymbol";
    String ALLOW_MULTIPLE_SELECTION_ATTR = "allowMultipleSelection";
    String ALLOW_NEGATIVE_ATTR = "allowNegative";
    String ALLOWED_FORMAT_CHARS_ATTR = "allowedFormatChars";
    String CONDENSE_WHITE_ATTR = "condenseWhite";
    String CURRENCY_SYMBOL_ATTR = "currencySymbol";
    String DATA_ATTR = "data";
    String DATA_DESCRIPTOR_ATTR = "dataDescriptor";
    String DATA_PROVIDER_ATTR = "dataProvider";
    String DAY_NAMES_ATTR = "dayNames";
    String DECIMAL_POINT_COUNT_ERROR_ATTR = "decimalPointCountError";
    String DECIMAL_SEPARATOR_ATTR = "decimalSeparator";
    String DIRECTION_ATTR = "direction";
    String DISABLED_DAYS_ATTR = "disabledDays";
    String DISABLED_RANGES_ATTR = "disabledRanges";
    String DISPLAY_AS_PASSWORD_ATTR = "displayAsPassword";
    String DISPLAYED_MONTH_ATTR = "displayedMonth";
    String DISPLAYED_YEAR_ATTR = "displayedYear";
    String DOMAIN_ATTR = "domain";
    String DRAG_MOVE_ENABLED_ATTR = "dragMoveEnabled";
    String EDITABLE_ATTR = "editable";
    String EDITED_ITEM_POSITION_ATTR = "editedItemPosition";
    String EXCEEDS_MAX_ERROR_ATTR = "exceedsMaxError";
    String FIRST_DAY_OF_WEEK_ATTR = "firstDayOfWeek";
    String FORMAT_STRING_ATTR = "formatString";
    String HORIZONTAL_SCROLL_POLICY_ATTR = "horizontalScrollPolicy";
    String HORIZONTAL_SCROLL_POSITION_ATTR = "horizontalScrollPosition";
    String HTML_TEXT_ATTR = "htmlText";
    String ICON_FIELD_ATTR = "iconField";
    String IME_MODE_ATTR = "imeMode";
    String INVALID_FORMAT_CHARS_ERROR_ATTR = "invalidFormatCharsError";
    String ITEM_EDITOR_INSTANCE_ATTR = "itemEditorInstance";
    String ITEM_RENDERER_ATTR = "itemRenderer";
    String INVALID_CHAR_ERROR_ATTR = "invalidCharError";
    String LABEL_ATTR = "label";
    String LABEL_FIELD_ATTR = "labelField";
    String LABEL_FUNCTION_ATTR = "labelFunction";
    String LABEL_PLACEMENT_ATTR = "labelPlacement";
    String LAYOUT_ATTR = "layout";
    String LENGTH_ATTR = "length";
    String LIST_DATA_ATTR = "listData";
    String LOWER_THAN_MIN_ERROR_ATTR = "lowerThanMinError";
    String MAINTAIN_ASPECT_RATIO_ATTR = "maintainAspectRatio";
    String MAX_CHARS_ATTR = "maxChars";
    String MAX_HORIZONTAL_SCROLL_POSITION_ATTR = "maxHorizontalScrollPosition";
    String MAX_VALUE_ATTR = "maxValue";
    String MAXIMUM_ATTR = "maximum";
    String MINIMUM_ATTR = "minimum";
    String MIN_VALUE_ATTR = "minValue";
    String MIN_YEAR_ATTR = "minYear";
    String MONTH_NAMES_ATTR = "monthNames";
    String MONTH_SYMBOL_ATTR = "monthSymbol";
    String NEGATIVE_ERROR_ATTR = "negativeError";
    String PRECISION_ATTR = "precision";
    String PRECISION_ERROR_ATTR = "precisionError";
    String RESTRICT_ATTR = "restrict";
    String ROW_COUNT_ATTR = "rowCount";
    String SELECTABLE_ATTR = "selectable";
    String SELECTABLE_RANGE_ATTR = "selectableRange";
    String SELECTED_DATE_ATTR = "selectedDate";
    String SELECTED_INDEX_ATTR = "selectedIndex";
    String SELECTED_ITEM_ATTR = "selectedItem";
    String SELECTION_BEGIN_INDEX_ATTR = "selectionBeginIndex";
    String SELECTION_END_INDEX_ATTR = "selectionEndIndex";
    String SEPARATION_ERROR_ATTR = "separationError";
    String SHOW_ROOT_ATTR = "showRoot";
    String SHOW_TODAY_ATTR = "showToday";
    String SOURCE_ATTR = "source";
    String TEXT_ATTR = "text";
    String TEXT_BINDING_ATTR = "textBinding";
    String TEXT_HEIGHT_ATTR = "textHeight";
    String TEXT_WIDTH_ATTR = "textWidth";
    String THOUSANDS_SEPARATOR_ATTR = "thousandsSeparator";
    String VALUE_ATTR = "value";
    String VERTICAL_SCROLL_POLICY_ATTR = "verticalScrollPolicy";
    String VERTICAL_SCROLL_POSITION_ATTR = "verticalScrollPosition";
    String WORD_WRAP_ATTR = "wordWrap";
    String WRONG_LENGTH_ERROR_ATTR = "wrongLengthError";
    String YEAR_NAVIGATION_ENABLED_ATTR = "yearNavigationEnabled";
    String YEAR_SYMBOL_ATTR = "yearSymbol";
    
    //Common Style
    String ALTERNATING_ITEM_COLORS_ATTR = "alternatingItemColors";
    String ARROW_BUTTON_WIDTH_ATTR = "arrowButtonWidth";
    String BACKGROUND_ALPHA_ATTR = "backgroundAlpha";
    String BACKGROUND_COLOR_ATTR = "backgroundColor";
    String BACKGROUND_DISABLED_COLOR_ATTR = "backgroundDisabledColor";
    String BACKGROUND_IMAGE_ATTR = "backgroundImage";
    String BACKGROUND_SIZE_ATTR = "backgroundSize";
    String BAR_COLOR_ATTR = "barColor";
    String BORDER_COLOR_ATTR = "borderColor";
    String BORDER_SIDES_ATTR = "borderSides";
    String BORDER_SKIN_ATTR = "borderSkin";
    String BORDER_STYLE_ATTR = "borderStyle";
    String BORDER_THICKNESS_ATTR = "borderThickness";
    String CLOSE_DURATION_ATTR = "closeDuration";
    String CLOSE_EASING_FUNCTION_ATTR = "closeEasingFunction";
    String COLOR_ATTR = "color";
    String CORNER_RADIUS_ATTR = "cornerRadius";
    String DATA_TIP_PLACEMENT_ATTR = "dataTipPlacement";
    String DISABLED_COLOR_ATTR = "disabledColor";
    String DISABLED_SKIN_ATTR = "disabledSkin";
    String DOWN_ARROW_DISABLED_SKIN_ATTR = "downArrowDisabledSkin";
    String DOWN_ARROW_DOWN_SKIN_ATTR = "downArrowDownSkin";
    String DOWN_ARROW_OVER_SKIN_ATTR = "downArrowOverSkin";
    String DOWN_ARROW_UP_SKIN_ATTR = "downArrowUpSkin";
    String DOWN_SKIN_ATTR = "downSkin";
    String DROP_SHADOW_COLOR_ATTR = "dropShadowColor";
    String DROP_SHADOW_ENABLED_ATTR = "dropShadowEnabled";
    String FILL_ALPHAS_ATTR = "fillAlphas";
    String FILL_COLORS_ATTR = "fillColors";
    String FOCUS_ALPHA_ATTR = "focusAlpha";
    String FOCUS_ROUNDED_CORNERS_ATTR = "focusRoundedCorners";
    String FONT_ANTI_ALIAS_TYPE_ATTR = "fontAntiAliasType";
    String FONT_FAMILY_ATTR = "fontFamily";
    String FONT_GRID_FIT_TYPE_ATTR = "fontGridFitType";
    String FONT_SHARPNESS_ATTR = "fontSharpness";
    String FONT_SIZE_ATTR = "fontSize";
    String FONT_STYLE_ATTR = "fontStyle";
    String FONT_THICKNESS_ATTR = "fontThickness";
    String FONT_WEIGHT_ATTR = "fontWeight";
    String HEADER_COLORS_ATTR = "headerColors";
    String HEADER_STYLE_NAME_ATTR = "headerStyleName";
    String HIGHLIGHT_ALPHAS_ATTR = "highlightAlphas";
    String HORIZONTAL_ALIGN_ATTR = "horizontalAlign";
    String HORIZONTAL_GAP_ATTR = "horizontalGap";
    String HORIZONTAL_SCROLL_BAR_STYLENAME = "horizontalScrollBarStyleName";
    String LEADING_ATTR = "leading";
    String MODAL_TRANSPARENCY_BLUR_ATTR = "modalTransparencyBlur";
    String MODAL_TRANSPARENCY_COLOR_ATTR = "modalTransparencyColor";
    String MODAL_TRANSPARENCY_DURATION_ATTR = "modalTransparencyDuration";
    String MODAL_TRANSPARENCY_ATTR = "modalTransparency";
    String OPEN_DURATION_ATTR = "openDuration";
    String OPEN_EASING_FUNCTION_ATTR = "openEasingFunction";
    String OVER_SKIN_ATTR = "overSkin";
    String PADDING_BOTTOM_ATTR = "paddingBottom";
    String PADDING_LEFT_ATTR = "paddingLeft";
    String PADDING_RIGHT_ATTR = "paddingRight";
    String PADDING_TOP_ATTR = "paddingTop";
    String REPEAT_DELAY_ATTR = "repeatDelay";
    String REPEAT_INTERVAL_ATTR = "repeatInterval";
    String ROLL_OVER_COLOR_ATTR = "rollOverColor";
    String SELECTION_COLOR_ATTR = "selectionColor";
    String SELECTION_DISABLED_COLOR_ATTR = "selectionDisabledColor";
    String SELECTION_DURATION_ATTR = "selectionDuration";
    String SELECTION_EASING_FUNCTION_ATTR = "selectionEasingFunction";
    String SHADOW_COLOR_ATTR = "shadowColor";
    String SHADOW_DIRECTION_ATTR = "shadowDirection";
    String SHADOW_DISTANCE_ATTR = "shadowDistance";
    String STROKE_COLOR_ATTR = "strokeColor";
    String STROKE_WIDTH_ATTR = "strokeWidth";
    String TEXT_ALIGN_ATTR = "textAlign";
    String TEXT_DECORATION_ATTR = "textDecoration";
    String TEXT_INDENT_ATTR = "textIndent";
    String TEXT_ROLL_OVER_COLOR_ATTR = "textRollOverColor";
    String TEXT_SELECTED_COLOR_ATTR = "textSelectedColor";
    String THUMB_OVER_SKIN_ATTR = "thumbOverSkin";
    String THUMB_UP_SKIN_ATTR = "thumbUpSkin";
    String THUMB_DOWN_SKIN_ATTR = "thumbDownSkin";
    String TODAY_COLOR_ATTR = "todayColor";
    String TODAY_STYLE_NAME_ATTR = "todayStyleName";
    String TRACK_COLORS_ATTR = "trackColors";
    String TRACK_SKIN_ATTR = "trackSkin";
    String UP_ARROW_DISABLED_SKIN_ATTR = "upArrowDisabledSkin";
    String UP_ARROW_DOWN_SKIN_ATTR = "upArrowDownSkin";
    String UP_ARROW_OVER_SKIN_ATTR = "upArrowOverSkin";
    String UP_ARROW_UP_SKIN_ATTR = "upArrowUpSkin";
    String UP_SKIN_ATTR = "upSkin";
    String VERTICAL_ALIGN_ATTR = "verticalAlign";
    String VERTICAL_GAP_ATTR = "verticalGap";
    String VERTICAL_SCROLL_BAR_STYLE_NAME_ATTR = "verticalScrollBarStyleName";
    String WEEK_DAY_STYLE_NAME_ATTR = "weekDayStyleName";
    
    //Common Event
    String CHANGE_ATTR = "change";
    String CLOSE_ATTR = "close";
    String COMPLETE_ATTR = "complete";
    String DATA_CHANGE_ATTR = "dataChange";
    String ENTER_ATTR = "enter";
    String ITEM_CLICK_ATTR = "itemClick";
    String ITEM_EDIT_BEGIN_ATTR = "itemEditBegin";
    String ITEM_EDIT_END_ATTR = "itemEditEnd";
    String ITEM_FOCUS_IN_ATTR = "itemFocusIn";
    String ITEM_FOCUS_OUT_ATTR = "itemFocusOut";
    String ITEM_ROLL_OUT_ATTR = "itemRollOut";
    String ITEM_ROLL_OVER_ATTR = "itemRollOver";
    String OPEN_ATTR = "open";
    String PROGRESS_ATTR = "progress";
    String SCROLL_ATTR = "scroll";
    
    //Common Effect
    String COMPLETE_EFFECT_ATTR = "completeEffect";
    
}
