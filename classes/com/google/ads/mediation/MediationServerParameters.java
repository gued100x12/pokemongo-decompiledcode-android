package com.google.ads.mediation;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@Deprecated
public abstract class MediationServerParameters
{
  public void load(Map<String, String> paramMap)
    throws MediationServerParameters.MappingException
  {
    HashMap localHashMap = new HashMap();
    for (Field localField3 : getClass().getFields())
    {
      Parameter localParameter = (Parameter)localField3.getAnnotation(Parameter.class);
      if (localParameter != null) {
        localHashMap.put(localParameter.name(), localField3);
      }
    }
    if (localHashMap.isEmpty()) {
      zzb.zzaH("No server options fields detected. To suppress this message either add a field with the @Parameter annotation, or override the load() method.");
    }
    Iterator localIterator1 = paramMap.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      Field localField2 = (Field)localHashMap.remove(localEntry.getKey());
      if (localField2 != null) {
        try
        {
          localField2.set(this, localEntry.getValue());
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          zzb.zzaH("Server option \"" + (String)localEntry.getKey() + "\" could not be set: Illegal Access");
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          zzb.zzaH("Server option \"" + (String)localEntry.getKey() + "\" could not be set: Bad Type");
        }
      } else {
        zzb.zzaF("Unexpected server option: " + (String)localEntry.getKey() + " = \"" + (String)localEntry.getValue() + "\"");
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator2 = localHashMap.values().iterator();
    while (localIterator2.hasNext())
    {
      Field localField1 = (Field)localIterator2.next();
      if (((Parameter)localField1.getAnnotation(Parameter.class)).required())
      {
        zzb.zzaH("Required server option missing: " + ((Parameter)localField1.getAnnotation(Parameter.class)).name());
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append(((Parameter)localField1.getAnnotation(Parameter.class)).name());
      }
    }
    if (localStringBuilder.length() > 0) {
      throw new MappingException("Required server option(s) missing: " + localStringBuilder.toString());
    }
    zzz();
  }
  
  protected void zzz() {}
  
  public static final class MappingException
    extends Exception
  {
    public MappingException(String paramString)
    {
      super();
    }
  }
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  protected static @interface Parameter
  {
    String name();
    
    boolean required() default true;
  }
}


/* Location:              /Users/tjledwith/Downloads/dex2jar-0.0.9.8/classes_dex2jar.jar!/com/google/ads/mediation/MediationServerParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */