package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.AutocompletePredictionBuffer;
import com.google.android.gms.location.places.GeoDataApi;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.PlacePhotoMetadataResult;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.zzf;
import com.google.android.gms.location.places.zzf.zzb;
import com.google.android.gms.location.places.zzl;
import com.google.android.gms.location.places.zzl.zza;
import com.google.android.gms.location.places.zzl.zzc;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Arrays;
import java.util.List;

public class zzd
  implements GeoDataApi
{
  public PendingResult<PlaceBuffer> addPlace(GoogleApiClient paramGoogleApiClient, final AddPlaceRequest paramAddPlaceRequest)
  {
    paramGoogleApiClient.zzb(new zzl.zzc(Places.zzaGz, paramGoogleApiClient)
    {
      protected void zza(zze paramAnonymouszze)
        throws RemoteException
      {
        paramAnonymouszze.zza(new zzl(this, paramAnonymouszze.getContext()), paramAddPlaceRequest);
      }
    });
  }
  
  public PendingResult<AutocompletePredictionBuffer> getAutocompletePredictions(GoogleApiClient paramGoogleApiClient, final String paramString, final LatLngBounds paramLatLngBounds, final AutocompleteFilter paramAutocompleteFilter)
  {
    paramGoogleApiClient.zza(new zzl.zza(Places.zzaGz, paramGoogleApiClient)
    {
      protected void zza(zze paramAnonymouszze)
        throws RemoteException
      {
        paramAnonymouszze.zza(new zzl(this), paramString, paramLatLngBounds, paramAutocompleteFilter);
      }
    });
  }
  
  public PendingResult<PlaceBuffer> getPlaceById(GoogleApiClient paramGoogleApiClient, final String... paramVarArgs)
  {
    int i = 1;
    if ((paramVarArgs != null) && (paramVarArgs.length >= i)) {}
    for (;;)
    {
      zzx.zzaa(i);
      paramGoogleApiClient.zza(new zzl.zzc(Places.zzaGz, paramGoogleApiClient)
      {
        protected void zza(zze paramAnonymouszze)
          throws RemoteException
        {
          List localList = Arrays.asList(paramVarArgs);
          paramAnonymouszze.zza(new zzl(this, paramAnonymouszze.getContext()), localList);
        }
      });
      int j = 0;
    }
  }
  
  public PendingResult<PlacePhotoMetadataResult> getPlacePhotos(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    paramGoogleApiClient.zza(new zzf.zzb(Places.zzaGz, paramGoogleApiClient)
    {
      protected void zza(zze paramAnonymouszze)
        throws RemoteException
      {
        paramAnonymouszze.zza(new zzf(this), paramString);
      }
    });
  }
}


/* Location:              /Users/tjledwith/Downloads/dex2jar-0.0.9.8/classes_dex2jar.jar!/com/google/android/gms/location/places/internal/zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */