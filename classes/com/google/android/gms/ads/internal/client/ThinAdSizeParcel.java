package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.internal.zzgr;

@zzgr
public class ThinAdSizeParcel
  extends AdSizeParcel
{
  public ThinAdSizeParcel(AdSizeParcel paramAdSizeParcel)
  {
    super(paramAdSizeParcel.versionCode, paramAdSizeParcel.zzte, paramAdSizeParcel.height, paramAdSizeParcel.heightPixels, paramAdSizeParcel.zztf, paramAdSizeParcel.width, paramAdSizeParcel.widthPixels, paramAdSizeParcel.zztg, paramAdSizeParcel.zzth, paramAdSizeParcel.zzti);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, this.versionCode);
    zzb.zza(paramParcel, 2, this.zzte, false);
    zzb.zzc(paramParcel, 3, this.height);
    zzb.zzc(paramParcel, 6, this.width);
    zzb.zzI(paramParcel, i);
  }
}


/* Location:              /Users/tjledwith/Downloads/dex2jar-0.0.9.8/classes_dex2jar.jar!/com/google/android/gms/ads/internal/client/ThinAdSizeParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */