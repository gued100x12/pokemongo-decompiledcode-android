package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal..Gson.Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Primitives;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ReflectiveTypeAdapterFactory
  implements TypeAdapterFactory
{
  private final ConstructorConstructor constructorConstructor;
  private final Excluder excluder;
  private final FieldNamingStrategy fieldNamingPolicy;
  
  public ReflectiveTypeAdapterFactory(ConstructorConstructor paramConstructorConstructor, FieldNamingStrategy paramFieldNamingStrategy, Excluder paramExcluder)
  {
    this.constructorConstructor = paramConstructorConstructor;
    this.fieldNamingPolicy = paramFieldNamingStrategy;
    this.excluder = paramExcluder;
  }
  
  private BoundField createBoundField(final Gson paramGson, final Field paramField, String paramString, final TypeToken<?> paramTypeToken, boolean paramBoolean1, boolean paramBoolean2)
  {
    new BoundField(paramString, paramBoolean1, paramBoolean2)
    {
      final TypeAdapter<?> typeAdapter = paramGson.getAdapter(paramTypeToken);
      
      void read(JsonReader paramAnonymousJsonReader, Object paramAnonymousObject)
        throws IOException, IllegalAccessException
      {
        Object localObject = this.typeAdapter.read(paramAnonymousJsonReader);
        if ((localObject != null) || (!this.val$isPrimitive)) {
          paramField.set(paramAnonymousObject, localObject);
        }
      }
      
      void write(JsonWriter paramAnonymousJsonWriter, Object paramAnonymousObject)
        throws IOException, IllegalAccessException
      {
        Object localObject = paramField.get(paramAnonymousObject);
        new TypeAdapterRuntimeTypeWrapper(paramGson, this.typeAdapter, paramTypeToken.getType()).write(paramAnonymousJsonWriter, localObject);
      }
    };
  }
  
  private Map<String, BoundField> getBoundFields(Gson paramGson, TypeToken<?> paramTypeToken, Class<?> paramClass)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if (paramClass.isInterface()) {}
    for (;;)
    {
      return localLinkedHashMap;
      Type localType1 = paramTypeToken.getType();
      while (paramClass != Object.class)
      {
        Field[] arrayOfField = paramClass.getDeclaredFields();
        int i = arrayOfField.length;
        int j = 0;
        if (j < i)
        {
          Field localField = arrayOfField[j];
          boolean bool1 = excludeField(localField, true);
          boolean bool2 = excludeField(localField, false);
          if ((!bool1) && (!bool2)) {}
          BoundField localBoundField2;
          do
          {
            j++;
            break;
            localField.setAccessible(true);
            Type localType4 = paramTypeToken.getType();
            Type localType5 = localField.getGenericType();
            Type localType6 = .Gson.Types.resolve(localType4, paramClass, localType5);
            BoundField localBoundField1 = createBoundField(paramGson, localField, getFieldName(localField), TypeToken.get(localType6), bool1, bool2);
            localBoundField2 = (BoundField)localLinkedHashMap.put(localBoundField1.name, localBoundField1);
          } while (localBoundField2 == null);
          throw new IllegalArgumentException(localType1 + " declares multiple JSON fields named " + localBoundField2.name);
        }
        Type localType2 = paramTypeToken.getType();
        Type localType3 = paramClass.getGenericSuperclass();
        paramTypeToken = TypeToken.get(.Gson.Types.resolve(localType2, paramClass, localType3));
        paramClass = paramTypeToken.getRawType();
      }
    }
  }
  
  private String getFieldName(Field paramField)
  {
    SerializedName localSerializedName = (SerializedName)paramField.getAnnotation(SerializedName.class);
    if (localSerializedName == null) {}
    for (String str = this.fieldNamingPolicy.translateName(paramField);; str = localSerializedName.value()) {
      return str;
    }
  }
  
  public <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken)
  {
    Object localObject = null;
    Class localClass = paramTypeToken.getRawType();
    if (!Object.class.isAssignableFrom(localClass)) {}
    for (;;)
    {
      return (TypeAdapter<T>)localObject;
      localObject = new Adapter(this.constructorConstructor.get(paramTypeToken), getBoundFields(paramGson, paramTypeToken, localClass), null);
    }
  }
  
  public boolean excludeField(Field paramField, boolean paramBoolean)
  {
    if ((!this.excluder.excludeClass(paramField.getType(), paramBoolean)) && (!this.excluder.excludeField(paramField, paramBoolean))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static final class Adapter<T>
    extends TypeAdapter<T>
  {
    private final Map<String, ReflectiveTypeAdapterFactory.BoundField> boundFields;
    private final ObjectConstructor<T> constructor;
    
    private Adapter(ObjectConstructor<T> paramObjectConstructor, Map<String, ReflectiveTypeAdapterFactory.BoundField> paramMap)
    {
      this.constructor = paramObjectConstructor;
      this.boundFields = paramMap;
    }
    
    public T read(JsonReader paramJsonReader)
      throws IOException
    {
      Object localObject;
      if (paramJsonReader.peek() == JsonToken.NULL)
      {
        paramJsonReader.nextNull();
        localObject = null;
      }
      for (;;)
      {
        return (T)localObject;
        localObject = this.constructor.construct();
        try
        {
          paramJsonReader.beginObject();
          for (;;)
          {
            if (!paramJsonReader.hasNext()) {
              break label113;
            }
            String str = paramJsonReader.nextName();
            localBoundField = (ReflectiveTypeAdapterFactory.BoundField)this.boundFields.get(str);
            if ((localBoundField != null) && (localBoundField.deserialized)) {
              break;
            }
            paramJsonReader.skipValue();
          }
        }
        catch (IllegalStateException localIllegalStateException)
        {
          for (;;)
          {
            ReflectiveTypeAdapterFactory.BoundField localBoundField;
            throw new JsonSyntaxException(localIllegalStateException);
            localBoundField.read(paramJsonReader, localObject);
          }
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          throw new AssertionError(localIllegalAccessException);
        }
        label113:
        paramJsonReader.endObject();
      }
    }
    
    public void write(JsonWriter paramJsonWriter, T paramT)
      throws IOException
    {
      if (paramT == null) {
        paramJsonWriter.nullValue();
      }
      for (;;)
      {
        return;
        paramJsonWriter.beginObject();
        try
        {
          Iterator localIterator = this.boundFields.values().iterator();
          while (localIterator.hasNext())
          {
            ReflectiveTypeAdapterFactory.BoundField localBoundField = (ReflectiveTypeAdapterFactory.BoundField)localIterator.next();
            if (localBoundField.serialized)
            {
              paramJsonWriter.name(localBoundField.name);
              localBoundField.write(paramJsonWriter, paramT);
            }
          }
          paramJsonWriter.endObject();
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          throw new AssertionError();
        }
      }
    }
  }
  
  static abstract class BoundField
  {
    final boolean deserialized;
    final String name;
    final boolean serialized;
    
    protected BoundField(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.name = paramString;
      this.serialized = paramBoolean1;
      this.deserialized = paramBoolean2;
    }
    
    abstract void read(JsonReader paramJsonReader, Object paramObject)
      throws IOException, IllegalAccessException;
    
    abstract void write(JsonWriter paramJsonWriter, Object paramObject)
      throws IOException, IllegalAccessException;
  }
}


/* Location:              /Users/tjledwith/Downloads/dex2jar-0.0.9.8/classes_dex2jar.jar!/com/google/gson/internal/bind/ReflectiveTypeAdapterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */