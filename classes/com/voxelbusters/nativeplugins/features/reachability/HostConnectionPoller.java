package com.voxelbusters.nativeplugins.features.reachability;

import com.voxelbusters.nativeplugins.utilities.Debug;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class HostConnectionPoller
{
  private long connectionTimeOutPeriod = 60L;
  private int currentRetryCount;
  private String ip = "8.8.8.8";
  private int maxRetryCount = 3;
  private int port = 56;
  private Future socketFutureTask = null;
  private float timeGapBetweenPolls = 2.0F;
  
  private void ReportConnectionFailure()
  {
    this.currentRetryCount = (1 + this.currentRetryCount);
    if (this.currentRetryCount > getMaxRetryCount())
    {
      NetworkReachabilityHandler.sendSocketConnectionStatus(false);
      this.currentRetryCount = 0;
    }
  }
  
  private void ReportConnectionSuccess()
  {
    NetworkReachabilityHandler.sendSocketConnectionStatus(true);
  }
  
  void Start()
  {
    if (this.socketFutureTask != null) {
      this.socketFutureTask.cancel(true);
    }
    this.socketFutureTask = Executors.newSingleThreadExecutor().submit(new Runnable()
    {
      public void run()
      {
        InetSocketAddress localInetSocketAddress = new InetSocketAddress(HostConnectionPoller.this.getIp(), HostConnectionPoller.this.getPort());
        for (;;)
        {
          Socket localSocket = new Socket();
          try
          {
            localSocket.connect(localInetSocketAddress, (int)(1000L * HostConnectionPoller.this.getConnectionTimeOutPeriod()));
            HostConnectionPoller.this.ReportConnectionSuccess();
            localSocket.close();
            try
            {
              Thread.sleep((1000.0F * HostConnectionPoller.this.timeGapBetweenPolls));
            }
            catch (InterruptedException localInterruptedException)
            {
              localInterruptedException.printStackTrace();
            }
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              HostConnectionPoller.this.ReportConnectionFailure();
              localIOException.printStackTrace();
            }
          }
        }
      }
    });
  }
  
  public long getConnectionTimeOutPeriod()
  {
    return this.connectionTimeOutPeriod;
  }
  
  public String getIp()
  {
    return this.ip;
  }
  
  public int getMaxRetryCount()
  {
    return this.maxRetryCount;
  }
  
  public int getPort()
  {
    return this.port;
  }
  
  public float getTimeGapBetweenPolls()
  {
    return this.timeGapBetweenPolls;
  }
  
  public void setConnectionTimeOutPeriod(int paramInt)
  {
    if (paramInt != 0) {
      this.connectionTimeOutPeriod = paramInt;
    }
    for (;;)
    {
      return;
      Debug.warning("NativePlugins.NetworkConnectivity", "time out value should not be zero. Considering default 60 secs for timeout");
    }
  }
  
  public void setIp(String paramString)
  {
    this.ip = paramString;
  }
  
  public void setMaxRetryCount(int paramInt)
  {
    this.maxRetryCount = paramInt;
  }
  
  public void setPort(int paramInt)
  {
    this.port = paramInt;
  }
  
  public void setTimeGapBetweenPolls(float paramFloat)
  {
    this.timeGapBetweenPolls = paramFloat;
  }
}


/* Location:              /Users/tjledwith/Downloads/dex2jar-0.0.9.8/classes_dex2jar.jar!/com/voxelbusters/nativeplugins/features/reachability/HostConnectionPoller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */