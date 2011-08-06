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
package com.googlecode.jsfFlex.validator.ext;

import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFComponent;

import com.googlecode.jsfFlex.attributes._MXMLUIAllowedFormatCharsAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIDayListenerAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIDayPropertyAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIDaySourceAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIFormatErrorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIInputFormatAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIInvalidCharErrorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIMonthListenerAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIMonthPropertyAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIMonthSourceAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIValidateAsStringAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIWrongDayErrorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIWrongLengthErrorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIWrongMonthErrorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIWrongYearErrorAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIYearListenerAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIYearPropertyAttribute;
import com.googlecode.jsfFlex.attributes._MXMLUIYearSourceAttribute;
import com.googlecode.jsfFlex.component.MXMLUISimpleBase;

/**
 * One thing to note about MXML Formatter and Validator is that they are not actually converters or validators<br>
 * respectively but actually are components. This is so because they perform the formatting and validation<br>
 * as Flex components on the client side and not on the server side.<br>
 * 
 * @author Ji Hoon Kim
 */
@JSFComponent(
        name                =   "jf:mxmlDateValidator",
        clazz               =   "com.googlecode.jsfFlex.validator.ext.MXMLUIDateValidator",
        type                =   "com.googlecode.jsfFlex.MXMLUIDateValidator",
        tagClass            =   "com.googlecode.jsfFlex.taglib.validator.ext.MXMLUIDateValidatorTag",
        family              =   "javax.faces.MXMLSimple",
        defaultRendererType =   "com.googlecode.jsfFlex.MXMLDateValidator"
)
public abstract class AbstractMXMLUIDateValidator 
						extends MXMLUISimpleBase 
						implements _MXMLUIValidatorAttributes, _MXMLUIAllowedFormatCharsAttribute, _MXMLUIDayListenerAttribute, 
                        _MXMLUIDayPropertyAttribute, _MXMLUIDaySourceAttribute, _MXMLUIFormatErrorAttribute, 
                        _MXMLUIInputFormatAttribute, _MXMLUIInvalidCharErrorAttribute, _MXMLUIMonthListenerAttribute, 
                        _MXMLUIMonthPropertyAttribute, _MXMLUIMonthSourceAttribute, _MXMLUIValidateAsStringAttribute, 
                        _MXMLUIWrongDayErrorAttribute, _MXMLUIWrongLengthErrorAttribute, _MXMLUIWrongMonthErrorAttribute, 
                        _MXMLUIWrongYearErrorAttribute, _MXMLUIYearListenerAttribute, _MXMLUIYearPropertyAttribute, 
                        _MXMLUIYearSourceAttribute {
	
}