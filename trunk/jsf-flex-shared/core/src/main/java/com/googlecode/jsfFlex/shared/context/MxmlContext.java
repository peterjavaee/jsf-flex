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
package com.googlecode.jsfFlex.shared.context;

import java.util.Map;
import java.util.Set;

import com.googlecode.jsfFlex.shared.tasks._CommonTaskRunner;
import com.googlecode.jsfFlex.shared.tasks._FileManipulatorTaskRunner;
import com.googlecode.jsfFlex.shared.tasks._FlexTaskRunner;
import com.googlecode.jsfFlex.shared.tasks._RunnerFactory;

/**
 * An abstract class providing the needed methods of its implementation.<br>
 * Also static method getCurrentInstance provides an easy method of retrieving current<br>
 * MxmlContext instance from the ThreadLocal.<br>
 * 
 * @author Ji Hoon Kim
 */
public abstract class MxmlContext {
	
	public abstract boolean isProductionEnv();
	
	public abstract void setProductionEnv(boolean productionEnv);
	
	public abstract boolean isSimplySWF();
	
	public abstract void setSimplySWF(boolean simplySWF);
	
	public abstract Map getApplicationIdValueMap();
	
	public abstract String getCurrMxml();
	
	public abstract void setCurrMxml(String currMxml);
	
	public abstract String getFlexSDKPath();
	
	public abstract void setFlexSDKPath(String flexSDKPath);
	
	public abstract Set getMxmlObjectBeanWrapperSet();
	
	public abstract void setMxmlObjectBeanWrapperSet(Set mxmlObjectBeanWrapperSet);
	
	public abstract String getMxmlPath();
	
	public abstract void setMxmlPath(String mxmlPath);
	
	public abstract String getPreMxmlPath();
	
	public abstract void setPreMxmlPath(String preMxmlPath);
	
	public abstract Map getPreMxmlCompMap();
	
	public abstract String getSwfBasePath();
	
	public abstract void setSwfBasePath(String swfBasePath);
	
	public abstract String getSwcPath();
	
	public abstract void setSwcPath(String swcPath);
	
	public abstract String getSwfPath();
	
	public abstract void setSwfPath(String swfPath);
	
	public abstract String getSwfWebPath();
	
	public abstract void setSwfWebPath(String swfWebPath);
	
	public abstract _CommonTaskRunner getCommonRunner();
	
	public abstract _FlexTaskRunner getFlexRunner();
	
	public abstract _FileManipulatorTaskRunner getFileManipulatorRunner();
	
	public abstract _RunnerFactory getRunnerFactoryInstance();
	
	private static ThreadLocal _currentInstance = new ThreadLocal()
    {
        protected Object initialValue()
        {
            return null;
        }
    };

    public static MxmlContext getCurrentInstance()
    {
        return (MxmlContext)_currentInstance.get();
    }

    protected static void setCurrentInstance(MxmlContext context)
    {
    	_currentInstance.set(context);
    }

}
