package com.fasterxml.jackson.databind.jsonFormatVisitors;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializerProvider;

public abstract interface JsonArrayFormatVisitor
  extends JsonFormatVisitorWithSerializerProvider
{
  public abstract void itemsFormat(JsonFormatTypes paramJsonFormatTypes)
    throws JsonMappingException;
  
  public abstract void itemsFormat(JsonFormatVisitable paramJsonFormatVisitable, JavaType paramJavaType)
    throws JsonMappingException;
  
  public static class Base
    implements JsonArrayFormatVisitor
  {
    protected SerializerProvider _provider;
    
    public Base() {}
    
    public Base(SerializerProvider paramSerializerProvider)
    {
      this._provider = paramSerializerProvider;
    }
    
    public SerializerProvider getProvider()
    {
      return this._provider;
    }
    
    public void itemsFormat(JsonFormatTypes paramJsonFormatTypes)
      throws JsonMappingException
    {}
    
    public void itemsFormat(JsonFormatVisitable paramJsonFormatVisitable, JavaType paramJavaType)
      throws JsonMappingException
    {}
    
    public void setProvider(SerializerProvider paramSerializerProvider)
    {
      this._provider = paramSerializerProvider;
    }
  }
}


/* Location:              /Users/tjledwith/Downloads/dex2jar-0.0.9.8/classes_dex2jar.jar!/com/fasterxml/jackson/databind/jsonFormatVisitors/JsonArrayFormatVisitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */