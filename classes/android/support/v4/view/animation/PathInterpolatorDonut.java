package android.support.v4.view.animation;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

class PathInterpolatorDonut
  implements Interpolator
{
  private static final float PRECISION = 0.002F;
  private final float[] mX;
  private final float[] mY;
  
  public PathInterpolatorDonut(float paramFloat1, float paramFloat2)
  {
    this(createQuad(paramFloat1, paramFloat2));
  }
  
  public PathInterpolatorDonut(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this(createCubic(paramFloat1, paramFloat2, paramFloat3, paramFloat4));
  }
  
  public PathInterpolatorDonut(Path paramPath)
  {
    PathMeasure localPathMeasure = new PathMeasure(paramPath, false);
    float f = localPathMeasure.getLength();
    int i = 1 + (int)(f / 0.002F);
    this.mX = new float[i];
    this.mY = new float[i];
    float[] arrayOfFloat = new float[2];
    for (int j = 0; j < i; j++)
    {
      localPathMeasure.getPosTan(f * j / (i - 1), arrayOfFloat, null);
      this.mX[j] = arrayOfFloat[0];
      this.mY[j] = arrayOfFloat[1];
    }
  }
  
  private static Path createCubic(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Path localPath = new Path();
    localPath.moveTo(0.0F, 0.0F);
    localPath.cubicTo(paramFloat1, paramFloat2, paramFloat3, paramFloat4, 1.0F, 1.0F);
    return localPath;
  }
  
  private static Path createQuad(float paramFloat1, float paramFloat2)
  {
    Path localPath = new Path();
    localPath.moveTo(0.0F, 0.0F);
    localPath.quadTo(paramFloat1, paramFloat2, 1.0F, 1.0F);
    return localPath;
  }
  
  public float getInterpolation(float paramFloat)
  {
    float f1 = 0.0F;
    if (paramFloat <= 0.0F) {}
    for (;;)
    {
      return f1;
      if (paramFloat >= 1.0F)
      {
        f1 = 1.0F;
      }
      else
      {
        int i = 0;
        int j = -1 + this.mX.length;
        while (j - i > 1)
        {
          int k = (i + j) / 2;
          if (paramFloat < this.mX[k]) {
            j = k;
          } else {
            i = k;
          }
        }
        float f2 = this.mX[j] - this.mX[i];
        if (f2 == 0.0F)
        {
          f1 = this.mY[i];
        }
        else
        {
          float f3 = (paramFloat - this.mX[i]) / f2;
          float f4 = this.mY[i];
          f1 = f4 + f3 * (this.mY[j] - f4);
        }
      }
    }
  }
}


/* Location:              /Users/tjledwith/Downloads/dex2jar-0.0.9.8/classes_dex2jar.jar!/android/support/v4/view/animation/PathInterpolatorDonut.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */