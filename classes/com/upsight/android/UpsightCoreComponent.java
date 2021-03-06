package com.upsight.android;

import android.content.Context;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.otto.Bus;
import com.upsight.android.persistence.UpsightDataStore;
import javax.inject.Named;
import rx.Scheduler;

public abstract interface UpsightCoreComponent
{
  public abstract Context applicationContext();
  
  @Named("background")
  public abstract UpsightDataStore backgroundDataStore();
  
  public abstract Bus bus();
  
  public abstract ObjectMapper objectMapper();
  
  @Named("callback")
  public abstract Scheduler observeOnScheduler();
  
  @Named("execution")
  public abstract Scheduler subscribeOnScheduler();
  
  public abstract UpsightContext upsightContext();
  
  public static abstract interface Factory
  {
    public abstract UpsightCoreComponent create(Context paramContext);
  }
}


/* Location:              /Users/tjledwith/Downloads/dex2jar-0.0.9.8/classes_dex2jar.jar!/com/upsight/android/UpsightCoreComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */