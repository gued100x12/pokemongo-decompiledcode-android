package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.graphics.BitmapCompat;
import android.support.v4.view.GravityCompat;
import android.util.Log;
import java.io.InputStream;

public class RoundedBitmapDrawableFactory
{
  private static final String TAG = "RoundedBitmapDrawableFactory";
  
  public static RoundedBitmapDrawable create(Resources paramResources, Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (Object localObject = new RoundedBitmapDrawable21(paramResources, paramBitmap);; localObject = new DefaultRoundedBitmapDrawable(paramResources, paramBitmap)) {
      return (RoundedBitmapDrawable)localObject;
    }
  }
  
  public static RoundedBitmapDrawable create(Resources paramResources, InputStream paramInputStream)
  {
    RoundedBitmapDrawable localRoundedBitmapDrawable = create(paramResources, BitmapFactory.decodeStream(paramInputStream));
    if (localRoundedBitmapDrawable.getBitmap() == null) {
      Log.w("RoundedBitmapDrawableFactory", "RoundedBitmapDrawable cannot decode " + paramInputStream);
    }
    return localRoundedBitmapDrawable;
  }
  
  public static RoundedBitmapDrawable create(Resources paramResources, String paramString)
  {
    RoundedBitmapDrawable localRoundedBitmapDrawable = create(paramResources, BitmapFactory.decodeFile(paramString));
    if (localRoundedBitmapDrawable.getBitmap() == null) {
      Log.w("RoundedBitmapDrawableFactory", "RoundedBitmapDrawable cannot decode " + paramString);
    }
    return localRoundedBitmapDrawable;
  }
  
  private static class DefaultRoundedBitmapDrawable
    extends RoundedBitmapDrawable
  {
    DefaultRoundedBitmapDrawable(Resources paramResources, Bitmap paramBitmap)
    {
      super(paramBitmap);
    }
    
    void gravityCompatApply(int paramInt1, int paramInt2, int paramInt3, Rect paramRect1, Rect paramRect2)
    {
      GravityCompat.apply(paramInt1, paramInt2, paramInt3, paramRect1, paramRect2, 0);
    }
    
    public boolean hasMipMap()
    {
      if ((this.mBitmap != null) && (BitmapCompat.hasMipMap(this.mBitmap))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public void setMipMap(boolean paramBoolean)
    {
      if (this.mBitmap != null)
      {
        BitmapCompat.setHasMipMap(this.mBitmap, paramBoolean);
        invalidateSelf();
      }
    }
  }
}


/* Location:              /Users/tjledwith/Downloads/dex2jar-0.0.9.8/classes_dex2jar.jar!/android/support/v4/graphics/drawable/RoundedBitmapDrawableFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */