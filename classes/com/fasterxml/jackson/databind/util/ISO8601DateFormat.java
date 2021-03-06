package com.fasterxml.jackson.databind.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ISO8601DateFormat
  extends DateFormat
{
  private static Calendar CALENDAR = new GregorianCalendar();
  private static NumberFormat NUMBER_FORMAT = new DecimalFormat();
  private static final long serialVersionUID = 1L;
  
  public ISO8601DateFormat()
  {
    this.numberFormat = NUMBER_FORMAT;
    this.calendar = CALENDAR;
  }
  
  public Object clone()
  {
    return this;
  }
  
  public StringBuffer format(Date paramDate, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition)
  {
    paramStringBuffer.append(ISO8601Utils.format(paramDate));
    return paramStringBuffer;
  }
  
  public Date parse(String paramString)
    throws ParseException
  {
    return ISO8601Utils.parse(paramString, new ParsePosition(0));
  }
  
  public Date parse(String paramString, ParsePosition paramParsePosition)
  {
    try
    {
      Date localDate2 = ISO8601Utils.parse(paramString, paramParsePosition);
      localDate1 = localDate2;
    }
    catch (ParseException localParseException)
    {
      for (;;)
      {
        Date localDate1 = null;
      }
    }
    return localDate1;
  }
  
  public String toString()
  {
    return getClass().getName();
  }
}


/* Location:              /Users/tjledwith/Downloads/dex2jar-0.0.9.8/classes_dex2jar.jar!/com/fasterxml/jackson/databind/util/ISO8601DateFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */