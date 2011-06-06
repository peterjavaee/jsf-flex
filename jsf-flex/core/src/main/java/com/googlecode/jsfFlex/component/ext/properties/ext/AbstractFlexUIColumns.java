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
package com.googlecode.jsfFlex.component.ext.properties.ext;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import org.apache.myfaces.buildtools.maven2.plugin.builder.annotation.JSFComponent;

import com.googlecode.jsfFlex.component.AbstractFlexUISimpleBase;
import com.googlecode.jsfFlex.component.ext.AbstractFlexUIDataGrid;
import com.googlecode.jsfFlex.component.ext.AbstractFlexUIDataGridColumn;

/**
 * @author Ji Hoon Kim
 */
@JSFComponent(
        name                =   "jf:flexColumns",
        clazz               =   "com.googlecode.jsfFlex.component.ext.properties.ext.FlexUIColumns",
        type                =   "com.googlecode.jsfFlex.FlexUIColumns",
        tagClass            =   "com.googlecode.jsfFlex.taglib.component.ext.properties.ext.FlexUIColumnsTag",
        family              =   "javax.faces.FlexSimple",
        defaultRendererType =   "com.googlecode.jsfFlex.FlexColumns"
)
@FacesComponent("com.googlecode.jsfFlex.FlexUIColumns")
public abstract class AbstractFlexUIColumns 
                        extends AbstractFlexUISimpleBase {
    
    @Override
    public void encodeEnd(FacesContext context) throws IOException {
        super.encodeEnd(context);
        
        AbstractFlexUIDataGrid dataGridComponent = AbstractFlexUIDataGrid.class.cast( getParent() );
        Map<String, AbstractFlexUIDataGridColumn> dataGridColumnComponentMapping = dataGridComponent.getDataGridColumnComponentMapping();
        
        List<UIComponent> dataGridColumnComponents = getChildren();
        for(UIComponent currChild : dataGridColumnComponents){
            AbstractFlexUIDataGridColumn currDataGridColumnComponent = AbstractFlexUIDataGridColumn.class.cast( currChild );
            dataGridColumnComponentMapping.put(currDataGridColumnComponent.getDataField(), currDataGridColumnComponent);
        }
        
        if(dataGridColumnComponents.size() > 0){
            AbstractFlexUIDataGridColumn currDataGridColumnComponent = AbstractFlexUIDataGridColumn.class.cast( dataGridColumnComponents.get(0) );
            dataGridComponent.setFilterColumn(currDataGridColumnComponent.getDataField());
        }
        
    }
    
}