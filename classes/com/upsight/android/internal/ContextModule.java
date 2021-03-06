package com.upsight.android.internal;

import android.content.Context;
import android.util.Log;
import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;
import com.upsight.android.internal.logger.LogWriter;
import com.upsight.android.internal.persistence.storable.StorableIdFactory;
import com.upsight.android.logger.UpsightLogger.Level;
import dagger.Module;
import dagger.Provides;
import java.util.UUID;
import javax.inject.Singleton;

@Module
public final class ContextModule
{
  private final Context mApplicationContext;
  
  public ContextModule(Context paramContext)
  {
    this.mApplicationContext = paramContext.getApplicationContext();
  }
  
  @Provides
  @Singleton
  Context provideApplicationContext()
  {
    return this.mApplicationContext;
  }
  
  @Provides
  @Singleton
  Bus provideBus()
  {
    return new Bus(ThreadEnforcer.ANY);
  }
  
  @Provides
  @Singleton
  LogWriter provideLogWriter()
  {
    new LogWriter()
    {
      private void logMessage(String paramAnonymousString1, UpsightLogger.Level paramAnonymousLevel, String paramAnonymousString2)
      {
        switch (ContextModule.3.$SwitchMap$com$upsight$android$logger$UpsightLogger$Level[paramAnonymousLevel.ordinal()])
        {
        }
        for (;;)
        {
          return;
          Log.v(paramAnonymousString1, paramAnonymousString2);
          continue;
          Log.d(paramAnonymousString1, paramAnonymousString2);
          continue;
          Log.i(paramAnonymousString1, paramAnonymousString2);
          continue;
          Log.w(paramAnonymousString1, paramAnonymousString2);
          continue;
          Log.e(paramAnonymousString1, paramAnonymousString2);
        }
      }
      
      public void write(String paramAnonymousString1, UpsightLogger.Level paramAnonymousLevel, String paramAnonymousString2)
      {
        if (paramAnonymousString2.length() > 4000)
        {
          int i = paramAnonymousString2.length() / 4000;
          int j = 0;
          if (j <= i)
          {
            int k = 4000 * (j + 1);
            if (k >= paramAnonymousString2.length()) {
              logMessage(paramAnonymousString1, paramAnonymousLevel, paramAnonymousString2.substring(j * 4000));
            }
            for (;;)
            {
              j++;
              break;
              logMessage(paramAnonymousString1, paramAnonymousLevel, paramAnonymousString2.substring(j * 4000, k));
            }
          }
        }
        else
        {
          logMessage(paramAnonymousString1, paramAnonymousLevel, paramAnonymousString2);
        }
      }
    };
  }
  
  @Provides
  @Singleton
  StorableIdFactory provideTypeIdGenerator()
  {
    new StorableIdFactory()
    {
      public String createObjectID()
      {
        return UUID.randomUUID().toString();
      }
    };
  }
}


/* Location:              /Users/tjledwith/Downloads/dex2jar-0.0.9.8/classes_dex2jar.jar!/com/upsight/android/internal/ContextModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */