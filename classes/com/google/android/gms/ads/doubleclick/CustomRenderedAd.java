package com.google.android.gms.ads.doubleclick;

import android.view.View;

public abstract interface CustomRenderedAd
{
  public abstract String getBaseUrl();
  
  public abstract String getContent();
  
  public abstract void onAdRendered(View paramView);
  
  public abstract void recordClick();
  
  public abstract void recordImpression();
}


/* Location:              /Users/tjledwith/Downloads/dex2jar-0.0.9.8/classes_dex2jar.jar!/com/google/android/gms/ads/doubleclick/CustomRenderedAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */