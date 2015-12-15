package com.qa.service;

import java.util.List;

public class SoundResponseData{
   int count;
   List<Data> results;

   public int getCount()
   {
      return count;
   }

   public void setCount(int count)
   {
      this.count = count;
   }

   public List<Data> getResults()
   {
      return results;
   }

   public void setResults(List<Data> results)
   {
      this.results = results;
   }

}
