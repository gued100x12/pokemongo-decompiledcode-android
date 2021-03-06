package com.google.android.gms.ads.internal.reward.client;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.client.zzh;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class zzi
  implements RewardedVideoAd
{
  private final Context mContext;
  private String zzGY;
  private RewardedVideoAdListener zzHd;
  private final zzb zzHe;
  private final Object zzpd = new Object();
  
  public zzi(Context paramContext, zzb paramzzb)
  {
    this.zzHe = paramzzb;
    this.mContext = paramContext;
  }
  
  public void destroy()
  {
    for (;;)
    {
      synchronized (this.zzpd)
      {
        if (this.zzHe == null) {
          return;
        }
      }
      try
      {
        this.zzHe.destroy();
        continue;
        localObject2 = finally;
        throw ((Throwable)localObject2);
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not forward destroy to RewardedVideoAd", localRemoteException);
        }
      }
    }
  }
  
  public RewardedVideoAdListener getRewardedVideoAdListener()
  {
    synchronized (this.zzpd)
    {
      RewardedVideoAdListener localRewardedVideoAdListener = this.zzHd;
      return localRewardedVideoAdListener;
    }
  }
  
  public String getUserId()
  {
    synchronized (this.zzpd)
    {
      String str = this.zzGY;
      return str;
    }
  }
  
  public boolean isLoaded()
  {
    boolean bool1 = false;
    for (;;)
    {
      boolean bool2;
      synchronized (this.zzpd)
      {
        if (this.zzHe == null) {
          return bool1;
        }
      }
    }
  }
  
  public void loadAd(String paramString, AdRequest paramAdRequest)
  {
    for (;;)
    {
      synchronized (this.zzpd)
      {
        if (this.zzHe == null) {
          return;
        }
      }
      try
      {
        this.zzHe.zza(zzh.zzcB().zza(this.mContext, paramAdRequest.zzaF(), paramString));
        continue;
        localObject2 = finally;
        throw ((Throwable)localObject2);
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not forward loadAd to RewardedVideoAd", localRemoteException);
        }
      }
    }
  }
  
  public void pause()
  {
    for (;;)
    {
      synchronized (this.zzpd)
      {
        if (this.zzHe == null) {
          return;
        }
      }
      try
      {
        this.zzHe.pause();
        continue;
        localObject2 = finally;
        throw ((Throwable)localObject2);
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not forward pause to RewardedVideoAd", localRemoteException);
        }
      }
    }
  }
  
  public void resume()
  {
    for (;;)
    {
      synchronized (this.zzpd)
      {
        if (this.zzHe == null) {
          return;
        }
      }
      try
      {
        this.zzHe.resume();
        continue;
        localObject2 = finally;
        throw ((Throwable)localObject2);
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not forward resume to RewardedVideoAd", localRemoteException);
        }
      }
    }
  }
  
  public void setRewardedVideoAdListener(RewardedVideoAdListener paramRewardedVideoAdListener)
  {
    synchronized (this.zzpd)
    {
      this.zzHd = paramRewardedVideoAdListener;
      zzb localzzb = this.zzHe;
      if (localzzb != null) {}
      try
      {
        this.zzHe.zza(new zzg(paramRewardedVideoAdListener));
        return;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not forward setRewardedVideoAdListener to RewardedVideoAd", localRemoteException);
        }
      }
    }
  }
  
  public void setUserId(String paramString)
  {
    synchronized (this.zzpd)
    {
      if (!TextUtils.isEmpty(this.zzGY))
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("A user id has already been set, ignoring.");
        return;
      }
      this.zzGY = paramString;
      zzb localzzb = this.zzHe;
      if (localzzb == null) {}
    }
    try
    {
      this.zzHe.setUserId(paramString);
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not forward setUserId to RewardedVideoAd", localRemoteException);
      }
    }
  }
  
  public void show()
  {
    for (;;)
    {
      synchronized (this.zzpd)
      {
        if (this.zzHe == null) {
          return;
        }
      }
      try
      {
        this.zzHe.show();
        continue;
        localObject2 = finally;
        throw ((Throwable)localObject2);
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not forward show to RewardedVideoAd", localRemoteException);
        }
      }
    }
  }
}


/* Location:              /Users/tjledwith/Downloads/dex2jar-0.0.9.8/classes_dex2jar.jar!/com/google/android/gms/ads/internal/reward/client/zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */