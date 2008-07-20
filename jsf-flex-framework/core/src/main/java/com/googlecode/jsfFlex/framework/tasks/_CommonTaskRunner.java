package com.googlecode.jsfFlex.framework.tasks;

import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;

public interface _CommonTaskRunner extends _TaskRunner{
	
	void unZipFile(String file, String dest) throws ComponentBuildException;
	
}
