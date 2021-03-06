package com.upsight.android.analytics.event.comm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.upsight.android.analytics.event.UpsightPublisherData;
import com.upsight.android.analytics.event.UpsightPublisherData.Builder;
import com.upsight.android.analytics.internal.AnalyticsEvent;
import com.upsight.android.analytics.internal.AnalyticsEvent.Builder;
import com.upsight.android.persistence.annotation.UpsightStorableType;

@UpsightStorableType("upsight.comm.register")
public class UpsightCommRegisterEvent
  extends AnalyticsEvent<UpsightData>
{
  protected UpsightCommRegisterEvent() {}
  
  protected UpsightCommRegisterEvent(String paramString, UpsightData paramUpsightData, UpsightPublisherData paramUpsightPublisherData)
  {
    super(paramString, paramUpsightData, paramUpsightPublisherData);
  }
  
  public static Builder createBuilder()
  {
    return new Builder();
  }
  
  public static class Builder
    extends AnalyticsEvent.Builder<UpsightCommRegisterEvent, UpsightCommRegisterEvent.UpsightData>
  {
    private String token;
    
    protected UpsightCommRegisterEvent build()
    {
      return new UpsightCommRegisterEvent("upsight.comm.register", new UpsightCommRegisterEvent.UpsightData(this), this.mPublisherDataBuilder.build());
    }
    
    public Builder setToken(String paramString)
    {
      this.token = paramString;
      return this;
    }
  }
  
  static class UpsightData
  {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("token")
    String token;
    
    protected UpsightData() {}
    
    protected UpsightData(UpsightCommRegisterEvent.Builder paramBuilder)
    {
      this.token = paramBuilder.token;
    }
    
    public String getToken()
    {
      return this.token;
    }
  }
}


/* Location:              /Users/tjledwith/Downloads/dex2jar-0.0.9.8/classes_dex2jar.jar!/com/upsight/android/analytics/event/comm/UpsightCommRegisterEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */