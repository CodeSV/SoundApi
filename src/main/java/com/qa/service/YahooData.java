package com.qa.service;

public class YahooData
{
   boolean enabled;
   int multiplier;
   int threshold;
   int delay;
   String baseUrl;

   public boolean isEnabled()
   {
      return enabled;
   }

   public void setEnabled(boolean enabled)
   {
      this.enabled = enabled;
   }

   public int getMultiplier()
   {
      return multiplier;
   }

   public void setMultiplier(int multiplier)
   {
      this.multiplier = multiplier;
   }

   public int getThreshold()
   {
      return threshold;
   }

   public void setThreshold(int threshold)
   {
      this.threshold = threshold;
   }

   public int getDelay()
   {
      return delay;
   }

   public void setDelay(int delay)
   {
      this.delay = delay;
   }

   public String getBaseUrl()
   {
      return baseUrl;
   }

   public void setBaseUrl(String baseUrl)
   {
      this.baseUrl = baseUrl;
   }
}