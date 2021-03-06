package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;

public class TeeOutputStream
  extends ProxyOutputStream
{
  protected OutputStream branch;
  
  public TeeOutputStream(OutputStream paramOutputStream1, OutputStream paramOutputStream2)
  {
    super(paramOutputStream1);
    this.branch = paramOutputStream2;
  }
  
  public void close()
    throws IOException
  {
    try
    {
      super.close();
      return;
    }
    finally
    {
      this.branch.close();
    }
  }
  
  public void flush()
    throws IOException
  {
    super.flush();
    this.branch.flush();
  }
  
  /**
   * @deprecated
   */
  public void write(int paramInt)
    throws IOException
  {
    try
    {
      super.write(paramInt);
      this.branch.write(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /**
   * @deprecated
   */
  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      super.write(paramArrayOfByte);
      this.branch.write(paramArrayOfByte);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /**
   * @deprecated
   */
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    try
    {
      super.write(paramArrayOfByte, paramInt1, paramInt2);
      this.branch.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/tjledwith/Downloads/dex2jar-0.0.9.8/classes_dex2jar.jar!/org/apache/commons/io/output/TeeOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */