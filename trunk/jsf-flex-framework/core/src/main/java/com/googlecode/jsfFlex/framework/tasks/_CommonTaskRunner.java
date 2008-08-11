package com.googlecode.jsfFlex.framework.tasks;

import java.io.File;
import java.io.InputStream;

import com.googlecode.jsfFlex.framework.exception.ComponentBuildException;

public interface _CommonTaskRunner extends _TaskRunner{
	
	void unZipArchiveRelative(String file, String dest) throws ComponentBuildException;
	
	void unZipArchiveAbsolute(File file, String dest) throws ComponentBuildException;
	
	void unZipArchiveAbsolute(InputStream file, String dest) throws ComponentBuildException;
	
}
