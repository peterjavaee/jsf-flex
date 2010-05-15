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
package com.googlecode.jsfFlex.renderkit.flex;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Constructor;

import javax.faces.component.UIComponent;
import javax.faces.context.ResponseWriter;

/**
 * @author Ji Hoon Kim
 */
class FlexResponseWriterImpl extends AbstractFlexResponseWriter {
    
    private static final String FLEX_RESPONSE_WRITER_BASE_IMPL = "org.apache.myfaces.shared_impl.renderkit.html.HtmlResponseWriterImpl";
    private static final Constructor FLEX_RESPONSE_WRITER_BASE_IMPLEMENTOR_CONSTRUCTOR;
    
    private final ResponseWriter _flexResponseWriterBaseImplementor;
    
    static{
        
        Class flexResponseWriterBaseImplementorClass;
        
        try{
            flexResponseWriterBaseImplementorClass = Class.forName(FLEX_RESPONSE_WRITER_BASE_IMPL, false, Thread.currentThread().getContextClassLoader());
        }catch(ClassNotFoundException classNotFound){
            throw new RuntimeException("Failure in retrieving the class for " + FLEX_RESPONSE_WRITER_BASE_IMPL, classNotFound);
        }
        
        try{
            FLEX_RESPONSE_WRITER_BASE_IMPLEMENTOR_CONSTRUCTOR = flexResponseWriterBaseImplementorClass.getDeclaredConstructor(new Class[]{Writer.class, String.class, String.class});
        }catch(NoSuchMethodException noSuchMethod){
            throw new RuntimeException("Failure in retrieving the constructor for " +  FLEX_RESPONSE_WRITER_BASE_IMPL, noSuchMethod);
        }
        
    }
    
    FlexResponseWriterImpl(){
        super();
        _flexResponseWriterBaseImplementor = null;
    }
    
    FlexResponseWriterImpl(Writer writer, String contentType, String characterEncoding){
        super();
        
        try{
            _flexResponseWriterBaseImplementor = ResponseWriter.class.cast( FLEX_RESPONSE_WRITER_BASE_IMPLEMENTOR_CONSTRUCTOR.newInstance(new Object[]{writer, contentType, characterEncoding}) );
        }catch(Exception instantiatingException){
            throw new RuntimeException("Failure in instantiating a class for " + FLEX_RESPONSE_WRITER_BASE_IMPL, instantiatingException);
        }
        
    }
    
    public ResponseWriter cloneWithWriter(Writer writer) {
        
        return new FlexResponseWriterImpl(writer, getContentType(), getCharacterEncoding());
    }
    
    public void endDocument() throws IOException {
        _flexResponseWriterBaseImplementor.endDocument();
    }
    
    public void endElement(String name) throws IOException {
        _flexResponseWriterBaseImplementor.endElement(name);
    }
    
    public void flush() throws IOException {
        _flexResponseWriterBaseImplementor.flush();
    }
    
    public String getCharacterEncoding() {
        return _flexResponseWriterBaseImplementor.getCharacterEncoding();
    }
    
    public String getContentType() {
        return _flexResponseWriterBaseImplementor.getContentType();
    }
    
    public void startDocument() throws IOException {
        _flexResponseWriterBaseImplementor.startDocument();
    }
    
    public void startElement(String name, UIComponent uiComponent) throws IOException {
        _flexResponseWriterBaseImplementor.startElement(name, uiComponent);
    }
    
    public void writeAttribute(String name, Object value, String componentPropertyName) throws IOException {
        _flexResponseWriterBaseImplementor.writeAttribute(name, value, componentPropertyName);
    }
    
    public void writeComment(Object value) throws IOException {
        _flexResponseWriterBaseImplementor.writeComment(value);
    }
    
    public void writeText(Object value, String componentPropertyName) throws IOException {
        _flexResponseWriterBaseImplementor.writeText(value, componentPropertyName);
    }
    
    public void writeText(char cbuf[], int off, int len) throws IOException {
        _flexResponseWriterBaseImplementor.writeText(cbuf, off, len);
    }
    
    public void writeText(Object text, UIComponent component, String property) throws IOException {
        _flexResponseWriterBaseImplementor.writeText(text, component, property);
    }
    
    public void writeURIAttribute(String name, Object value, String componentPropertyName) throws IOException {
        _flexResponseWriterBaseImplementor.writeURIAttribute(name, value, componentPropertyName);
    }
    
    public void close() throws IOException {
        _flexResponseWriterBaseImplementor.close();
    }
    
    public void write(char cbuf[], int off, int len) throws IOException {
        _flexResponseWriterBaseImplementor.write(cbuf, off, len);
    }
    
}
