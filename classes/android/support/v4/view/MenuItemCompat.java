package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.internal.view.SupportMenuItem;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public class MenuItemCompat
{
  static final MenuVersionImpl IMPL;
  public static final int SHOW_AS_ACTION_ALWAYS = 2;
  public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
  public static final int SHOW_AS_ACTION_IF_ROOM = 1;
  public static final int SHOW_AS_ACTION_NEVER = 0;
  public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
  private static final String TAG = "MenuItemCompat";
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 14) {
      IMPL = new IcsMenuVersionImpl();
    }
    for (;;)
    {
      return;
      if (i >= 11) {
        IMPL = new HoneycombMenuVersionImpl();
      } else {
        IMPL = new BaseMenuVersionImpl();
      }
    }
  }
  
  public static boolean collapseActionView(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {}
    for (boolean bool = ((SupportMenuItem)paramMenuItem).collapseActionView();; bool = IMPL.collapseActionView(paramMenuItem)) {
      return bool;
    }
  }
  
  public static boolean expandActionView(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {}
    for (boolean bool = ((SupportMenuItem)paramMenuItem).expandActionView();; bool = IMPL.expandActionView(paramMenuItem)) {
      return bool;
    }
  }
  
  public static ActionProvider getActionProvider(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {}
    for (ActionProvider localActionProvider = ((SupportMenuItem)paramMenuItem).getSupportActionProvider();; localActionProvider = null)
    {
      return localActionProvider;
      Log.w("MenuItemCompat", "getActionProvider: item does not implement SupportMenuItem; returning null");
    }
  }
  
  public static View getActionView(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {}
    for (View localView = ((SupportMenuItem)paramMenuItem).getActionView();; localView = IMPL.getActionView(paramMenuItem)) {
      return localView;
    }
  }
  
  public static boolean isActionViewExpanded(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {}
    for (boolean bool = ((SupportMenuItem)paramMenuItem).isActionViewExpanded();; bool = IMPL.isActionViewExpanded(paramMenuItem)) {
      return bool;
    }
  }
  
  public static MenuItem setActionProvider(MenuItem paramMenuItem, ActionProvider paramActionProvider)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {
      paramMenuItem = ((SupportMenuItem)paramMenuItem).setSupportActionProvider(paramActionProvider);
    }
    for (;;)
    {
      return paramMenuItem;
      Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
    }
  }
  
  public static MenuItem setActionView(MenuItem paramMenuItem, int paramInt)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {}
    for (MenuItem localMenuItem = ((SupportMenuItem)paramMenuItem).setActionView(paramInt);; localMenuItem = IMPL.setActionView(paramMenuItem, paramInt)) {
      return localMenuItem;
    }
  }
  
  public static MenuItem setActionView(MenuItem paramMenuItem, View paramView)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {}
    for (MenuItem localMenuItem = ((SupportMenuItem)paramMenuItem).setActionView(paramView);; localMenuItem = IMPL.setActionView(paramMenuItem, paramView)) {
      return localMenuItem;
    }
  }
  
  public static MenuItem setOnActionExpandListener(MenuItem paramMenuItem, OnActionExpandListener paramOnActionExpandListener)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {}
    for (Object localObject = ((SupportMenuItem)paramMenuItem).setSupportOnActionExpandListener(paramOnActionExpandListener);; localObject = IMPL.setOnActionExpandListener(paramMenuItem, paramOnActionExpandListener)) {
      return (MenuItem)localObject;
    }
  }
  
  public static void setShowAsAction(MenuItem paramMenuItem, int paramInt)
  {
    if ((paramMenuItem instanceof SupportMenuItem)) {
      ((SupportMenuItem)paramMenuItem).setShowAsAction(paramInt);
    }
    for (;;)
    {
      return;
      IMPL.setShowAsAction(paramMenuItem, paramInt);
    }
  }
  
  static class IcsMenuVersionImpl
    extends MenuItemCompat.HoneycombMenuVersionImpl
  {
    public boolean collapseActionView(MenuItem paramMenuItem)
    {
      return MenuItemCompatIcs.collapseActionView(paramMenuItem);
    }
    
    public boolean expandActionView(MenuItem paramMenuItem)
    {
      return MenuItemCompatIcs.expandActionView(paramMenuItem);
    }
    
    public boolean isActionViewExpanded(MenuItem paramMenuItem)
    {
      return MenuItemCompatIcs.isActionViewExpanded(paramMenuItem);
    }
    
    public MenuItem setOnActionExpandListener(MenuItem paramMenuItem, final MenuItemCompat.OnActionExpandListener paramOnActionExpandListener)
    {
      if (paramOnActionExpandListener == null) {}
      for (MenuItem localMenuItem = MenuItemCompatIcs.setOnActionExpandListener(paramMenuItem, null);; localMenuItem = MenuItemCompatIcs.setOnActionExpandListener(paramMenuItem, new MenuItemCompatIcs.SupportActionExpandProxy()
          {
            public boolean onMenuItemActionCollapse(MenuItem paramAnonymousMenuItem)
            {
              return paramOnActionExpandListener.onMenuItemActionCollapse(paramAnonymousMenuItem);
            }
            
            public boolean onMenuItemActionExpand(MenuItem paramAnonymousMenuItem)
            {
              return paramOnActionExpandListener.onMenuItemActionExpand(paramAnonymousMenuItem);
            }
          })) {
        return localMenuItem;
      }
    }
  }
  
  static class HoneycombMenuVersionImpl
    implements MenuItemCompat.MenuVersionImpl
  {
    public boolean collapseActionView(MenuItem paramMenuItem)
    {
      return false;
    }
    
    public boolean expandActionView(MenuItem paramMenuItem)
    {
      return false;
    }
    
    public View getActionView(MenuItem paramMenuItem)
    {
      return MenuItemCompatHoneycomb.getActionView(paramMenuItem);
    }
    
    public boolean isActionViewExpanded(MenuItem paramMenuItem)
    {
      return false;
    }
    
    public MenuItem setActionView(MenuItem paramMenuItem, int paramInt)
    {
      return MenuItemCompatHoneycomb.setActionView(paramMenuItem, paramInt);
    }
    
    public MenuItem setActionView(MenuItem paramMenuItem, View paramView)
    {
      return MenuItemCompatHoneycomb.setActionView(paramMenuItem, paramView);
    }
    
    public MenuItem setOnActionExpandListener(MenuItem paramMenuItem, MenuItemCompat.OnActionExpandListener paramOnActionExpandListener)
    {
      return paramMenuItem;
    }
    
    public void setShowAsAction(MenuItem paramMenuItem, int paramInt)
    {
      MenuItemCompatHoneycomb.setShowAsAction(paramMenuItem, paramInt);
    }
  }
  
  static class BaseMenuVersionImpl
    implements MenuItemCompat.MenuVersionImpl
  {
    public boolean collapseActionView(MenuItem paramMenuItem)
    {
      return false;
    }
    
    public boolean expandActionView(MenuItem paramMenuItem)
    {
      return false;
    }
    
    public View getActionView(MenuItem paramMenuItem)
    {
      return null;
    }
    
    public boolean isActionViewExpanded(MenuItem paramMenuItem)
    {
      return false;
    }
    
    public MenuItem setActionView(MenuItem paramMenuItem, int paramInt)
    {
      return paramMenuItem;
    }
    
    public MenuItem setActionView(MenuItem paramMenuItem, View paramView)
    {
      return paramMenuItem;
    }
    
    public MenuItem setOnActionExpandListener(MenuItem paramMenuItem, MenuItemCompat.OnActionExpandListener paramOnActionExpandListener)
    {
      return paramMenuItem;
    }
    
    public void setShowAsAction(MenuItem paramMenuItem, int paramInt) {}
  }
  
  public static abstract interface OnActionExpandListener
  {
    public abstract boolean onMenuItemActionCollapse(MenuItem paramMenuItem);
    
    public abstract boolean onMenuItemActionExpand(MenuItem paramMenuItem);
  }
  
  static abstract interface MenuVersionImpl
  {
    public abstract boolean collapseActionView(MenuItem paramMenuItem);
    
    public abstract boolean expandActionView(MenuItem paramMenuItem);
    
    public abstract View getActionView(MenuItem paramMenuItem);
    
    public abstract boolean isActionViewExpanded(MenuItem paramMenuItem);
    
    public abstract MenuItem setActionView(MenuItem paramMenuItem, int paramInt);
    
    public abstract MenuItem setActionView(MenuItem paramMenuItem, View paramView);
    
    public abstract MenuItem setOnActionExpandListener(MenuItem paramMenuItem, MenuItemCompat.OnActionExpandListener paramOnActionExpandListener);
    
    public abstract void setShowAsAction(MenuItem paramMenuItem, int paramInt);
  }
}


/* Location:              /Users/tjledwith/Downloads/dex2jar-0.0.9.8/classes_dex2jar.jar!/android/support/v4/view/MenuItemCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */