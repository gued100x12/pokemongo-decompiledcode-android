package android.support.v4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.View;

class LayoutInflaterCompatBase
{
  static void setFactory(LayoutInflater paramLayoutInflater, LayoutInflaterFactory paramLayoutInflaterFactory)
  {
    if (paramLayoutInflaterFactory != null) {}
    for (FactoryWrapper localFactoryWrapper = new FactoryWrapper(paramLayoutInflaterFactory);; localFactoryWrapper = null)
    {
      paramLayoutInflater.setFactory(localFactoryWrapper);
      return;
    }
  }
  
  static class FactoryWrapper
    implements LayoutInflater.Factory
  {
    final LayoutInflaterFactory mDelegateFactory;
    
    FactoryWrapper(LayoutInflaterFactory paramLayoutInflaterFactory)
    {
      this.mDelegateFactory = paramLayoutInflaterFactory;
    }
    
    public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
    {
      return this.mDelegateFactory.onCreateView(null, paramString, paramContext, paramAttributeSet);
    }
    
    public String toString()
    {
      return getClass().getName() + "{" + this.mDelegateFactory + "}";
    }
  }
}


/* Location:              /Users/tjledwith/Downloads/dex2jar-0.0.9.8/classes_dex2jar.jar!/android/support/v4/view/LayoutInflaterCompatBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */