package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<ProxyRequest>
{
  static void zza(ProxyRequest paramProxyRequest, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzaq(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 1, paramProxyRequest.url, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1000, paramProxyRequest.versionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 2, paramProxyRequest.httpMethod);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, paramProxyRequest.timeoutMillis);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 4, paramProxyRequest.body, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 5, paramProxyRequest.zzSK, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzI(paramParcel, i);
  }
  
  public ProxyRequest zzM(Parcel paramParcel)
  {
    int i = 0;
    Bundle localBundle = null;
    int j = zza.zzap(paramParcel);
    long l = 0L;
    byte[] arrayOfByte = null;
    String str = null;
    int k = 0;
    while (paramParcel.dataPosition() < j)
    {
      int m = zza.zzao(paramParcel);
      switch (zza.zzbM(m))
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        str = zza.zzp(paramParcel, m);
        break;
      case 1000: 
        k = zza.zzg(paramParcel, m);
        break;
      case 2: 
        i = zza.zzg(paramParcel, m);
        break;
      case 3: 
        l = zza.zzi(paramParcel, m);
        break;
      case 4: 
        arrayOfByte = zza.zzs(paramParcel, m);
        break;
      case 5: 
        localBundle = zza.zzr(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new ProxyRequest(k, str, i, l, arrayOfByte, localBundle);
  }
  
  public ProxyRequest[] zzaD(int paramInt)
  {
    return new ProxyRequest[paramInt];
  }
}


/* Location:              /Users/tjledwith/Downloads/dex2jar-0.0.9.8/classes_dex2jar.jar!/com/google/android/gms/auth/api/proxy/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */