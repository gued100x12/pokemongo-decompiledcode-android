package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.introspect.AnnotationIntrospectorPair;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;

public final class BaseSettings
  implements Serializable
{
  private static final TimeZone DEFAULT_TIMEZONE = TimeZone.getTimeZone("GMT");
  private static final long serialVersionUID = 1L;
  protected final AnnotationIntrospector _annotationIntrospector;
  protected final ClassIntrospector _classIntrospector;
  protected final DateFormat _dateFormat;
  protected final Base64Variant _defaultBase64;
  protected final HandlerInstantiator _handlerInstantiator;
  protected final Locale _locale;
  protected final PropertyNamingStrategy _propertyNamingStrategy;
  protected final TimeZone _timeZone;
  protected final TypeFactory _typeFactory;
  protected final TypeResolverBuilder<?> _typeResolverBuilder;
  protected final VisibilityChecker<?> _visibilityChecker;
  
  public BaseSettings(ClassIntrospector paramClassIntrospector, AnnotationIntrospector paramAnnotationIntrospector, VisibilityChecker<?> paramVisibilityChecker, PropertyNamingStrategy paramPropertyNamingStrategy, TypeFactory paramTypeFactory, TypeResolverBuilder<?> paramTypeResolverBuilder, DateFormat paramDateFormat, HandlerInstantiator paramHandlerInstantiator, Locale paramLocale, TimeZone paramTimeZone, Base64Variant paramBase64Variant)
  {
    this._classIntrospector = paramClassIntrospector;
    this._annotationIntrospector = paramAnnotationIntrospector;
    this._visibilityChecker = paramVisibilityChecker;
    this._propertyNamingStrategy = paramPropertyNamingStrategy;
    this._typeFactory = paramTypeFactory;
    this._typeResolverBuilder = paramTypeResolverBuilder;
    this._dateFormat = paramDateFormat;
    this._handlerInstantiator = paramHandlerInstantiator;
    this._locale = paramLocale;
    this._timeZone = paramTimeZone;
    this._defaultBase64 = paramBase64Variant;
  }
  
  private DateFormat _force(DateFormat paramDateFormat, TimeZone paramTimeZone)
  {
    if ((paramDateFormat instanceof StdDateFormat)) {}
    DateFormat localDateFormat;
    for (Object localObject = ((StdDateFormat)paramDateFormat).withTimeZone(paramTimeZone);; localObject = localDateFormat)
    {
      return (DateFormat)localObject;
      localDateFormat = (DateFormat)paramDateFormat.clone();
      localDateFormat.setTimeZone(paramTimeZone);
    }
  }
  
  public AnnotationIntrospector getAnnotationIntrospector()
  {
    return this._annotationIntrospector;
  }
  
  public Base64Variant getBase64Variant()
  {
    return this._defaultBase64;
  }
  
  public ClassIntrospector getClassIntrospector()
  {
    return this._classIntrospector;
  }
  
  public DateFormat getDateFormat()
  {
    return this._dateFormat;
  }
  
  public HandlerInstantiator getHandlerInstantiator()
  {
    return this._handlerInstantiator;
  }
  
  public Locale getLocale()
  {
    return this._locale;
  }
  
  public PropertyNamingStrategy getPropertyNamingStrategy()
  {
    return this._propertyNamingStrategy;
  }
  
  public TimeZone getTimeZone()
  {
    TimeZone localTimeZone = this._timeZone;
    if (localTimeZone == null) {
      localTimeZone = DEFAULT_TIMEZONE;
    }
    return localTimeZone;
  }
  
  public TypeFactory getTypeFactory()
  {
    return this._typeFactory;
  }
  
  public TypeResolverBuilder<?> getTypeResolverBuilder()
  {
    return this._typeResolverBuilder;
  }
  
  public VisibilityChecker<?> getVisibilityChecker()
  {
    return this._visibilityChecker;
  }
  
  public boolean hasExplicitTimeZone()
  {
    if (this._timeZone != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public BaseSettings with(Base64Variant paramBase64Variant)
  {
    if (paramBase64Variant == this._defaultBase64) {}
    for (;;)
    {
      return this;
      this = new BaseSettings(this._classIntrospector, this._annotationIntrospector, this._visibilityChecker, this._propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, this._dateFormat, this._handlerInstantiator, this._locale, this._timeZone, paramBase64Variant);
    }
  }
  
  public BaseSettings with(Locale paramLocale)
  {
    if (this._locale == paramLocale) {}
    for (;;)
    {
      return this;
      this = new BaseSettings(this._classIntrospector, this._annotationIntrospector, this._visibilityChecker, this._propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, this._dateFormat, this._handlerInstantiator, paramLocale, this._timeZone, this._defaultBase64);
    }
  }
  
  public BaseSettings with(TimeZone paramTimeZone)
  {
    if (paramTimeZone == null) {
      throw new IllegalArgumentException();
    }
    if (paramTimeZone == this._timeZone) {}
    for (;;)
    {
      return this;
      DateFormat localDateFormat = _force(this._dateFormat, paramTimeZone);
      this = new BaseSettings(this._classIntrospector, this._annotationIntrospector, this._visibilityChecker, this._propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, localDateFormat, this._handlerInstantiator, this._locale, paramTimeZone, this._defaultBase64);
    }
  }
  
  public BaseSettings withAnnotationIntrospector(AnnotationIntrospector paramAnnotationIntrospector)
  {
    if (this._annotationIntrospector == paramAnnotationIntrospector) {}
    for (;;)
    {
      return this;
      this = new BaseSettings(this._classIntrospector, paramAnnotationIntrospector, this._visibilityChecker, this._propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, this._dateFormat, this._handlerInstantiator, this._locale, this._timeZone, this._defaultBase64);
    }
  }
  
  public BaseSettings withAppendedAnnotationIntrospector(AnnotationIntrospector paramAnnotationIntrospector)
  {
    return withAnnotationIntrospector(AnnotationIntrospectorPair.create(this._annotationIntrospector, paramAnnotationIntrospector));
  }
  
  public BaseSettings withClassIntrospector(ClassIntrospector paramClassIntrospector)
  {
    if (this._classIntrospector == paramClassIntrospector) {}
    for (;;)
    {
      return this;
      this = new BaseSettings(paramClassIntrospector, this._annotationIntrospector, this._visibilityChecker, this._propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, this._dateFormat, this._handlerInstantiator, this._locale, this._timeZone, this._defaultBase64);
    }
  }
  
  public BaseSettings withDateFormat(DateFormat paramDateFormat)
  {
    if (this._dateFormat == paramDateFormat) {}
    for (;;)
    {
      return this;
      if ((paramDateFormat != null) && (hasExplicitTimeZone())) {
        paramDateFormat = _force(paramDateFormat, this._timeZone);
      }
      ClassIntrospector localClassIntrospector = this._classIntrospector;
      AnnotationIntrospector localAnnotationIntrospector = this._annotationIntrospector;
      VisibilityChecker localVisibilityChecker = this._visibilityChecker;
      PropertyNamingStrategy localPropertyNamingStrategy = this._propertyNamingStrategy;
      TypeFactory localTypeFactory = this._typeFactory;
      TypeResolverBuilder localTypeResolverBuilder = this._typeResolverBuilder;
      HandlerInstantiator localHandlerInstantiator = this._handlerInstantiator;
      Locale localLocale = this._locale;
      TimeZone localTimeZone = this._timeZone;
      Base64Variant localBase64Variant = this._defaultBase64;
      this = new BaseSettings(localClassIntrospector, localAnnotationIntrospector, localVisibilityChecker, localPropertyNamingStrategy, localTypeFactory, localTypeResolverBuilder, paramDateFormat, localHandlerInstantiator, localLocale, localTimeZone, localBase64Variant);
    }
  }
  
  public BaseSettings withHandlerInstantiator(HandlerInstantiator paramHandlerInstantiator)
  {
    if (this._handlerInstantiator == paramHandlerInstantiator) {}
    for (;;)
    {
      return this;
      this = new BaseSettings(this._classIntrospector, this._annotationIntrospector, this._visibilityChecker, this._propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, this._dateFormat, paramHandlerInstantiator, this._locale, this._timeZone, this._defaultBase64);
    }
  }
  
  public BaseSettings withInsertedAnnotationIntrospector(AnnotationIntrospector paramAnnotationIntrospector)
  {
    return withAnnotationIntrospector(AnnotationIntrospectorPair.create(paramAnnotationIntrospector, this._annotationIntrospector));
  }
  
  public BaseSettings withPropertyNamingStrategy(PropertyNamingStrategy paramPropertyNamingStrategy)
  {
    if (this._propertyNamingStrategy == paramPropertyNamingStrategy) {}
    for (;;)
    {
      return this;
      this = new BaseSettings(this._classIntrospector, this._annotationIntrospector, this._visibilityChecker, paramPropertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, this._dateFormat, this._handlerInstantiator, this._locale, this._timeZone, this._defaultBase64);
    }
  }
  
  public BaseSettings withTypeFactory(TypeFactory paramTypeFactory)
  {
    if (this._typeFactory == paramTypeFactory) {}
    for (;;)
    {
      return this;
      this = new BaseSettings(this._classIntrospector, this._annotationIntrospector, this._visibilityChecker, this._propertyNamingStrategy, paramTypeFactory, this._typeResolverBuilder, this._dateFormat, this._handlerInstantiator, this._locale, this._timeZone, this._defaultBase64);
    }
  }
  
  public BaseSettings withTypeResolverBuilder(TypeResolverBuilder<?> paramTypeResolverBuilder)
  {
    if (this._typeResolverBuilder == paramTypeResolverBuilder) {}
    for (;;)
    {
      return this;
      this = new BaseSettings(this._classIntrospector, this._annotationIntrospector, this._visibilityChecker, this._propertyNamingStrategy, this._typeFactory, paramTypeResolverBuilder, this._dateFormat, this._handlerInstantiator, this._locale, this._timeZone, this._defaultBase64);
    }
  }
  
  public BaseSettings withVisibility(PropertyAccessor paramPropertyAccessor, JsonAutoDetect.Visibility paramVisibility)
  {
    return new BaseSettings(this._classIntrospector, this._annotationIntrospector, this._visibilityChecker.withVisibility(paramPropertyAccessor, paramVisibility), this._propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, this._dateFormat, this._handlerInstantiator, this._locale, this._timeZone, this._defaultBase64);
  }
  
  public BaseSettings withVisibilityChecker(VisibilityChecker<?> paramVisibilityChecker)
  {
    if (this._visibilityChecker == paramVisibilityChecker) {}
    for (;;)
    {
      return this;
      this = new BaseSettings(this._classIntrospector, this._annotationIntrospector, paramVisibilityChecker, this._propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, this._dateFormat, this._handlerInstantiator, this._locale, this._timeZone, this._defaultBase64);
    }
  }
}


/* Location:              /Users/tjledwith/Downloads/dex2jar-0.0.9.8/classes_dex2jar.jar!/com/fasterxml/jackson/databind/cfg/BaseSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */