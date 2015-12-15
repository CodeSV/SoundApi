package com.qa.service;

import java.util.Date;

public class Data
{
   String description;
   String license;
   String title;
   String download_url;
   long duration;
   Date last_modified;
   String stream_url;
   String tag_list;
   long id;

   public String getDescription()
   {
      return description;
   }

   public void setDescription(String description)
   {
      this.description = description;
   }

   public String getLicense()
   {
      return license;
   }

   public void setLicense(String license)
   {
      this.license = license;
   }

   public String getTitle()
   {
      return title;
   }

   public void setTitle(String title)
   {
      this.title = title;
   }

   public String getDownload_url()
   {
      return download_url;
   }

   public void setDownload_url(String download_url)
   {
      this.download_url = download_url;
   }

   public long getDuration()
   {
      return duration;
   }

   public void setDuration(long duration)
   {
      this.duration = duration;
   }

   public Date getLast_modified()
   {
      return last_modified;
   }

   public void setLast_modified(Date last_modified)
   {
      this.last_modified = last_modified;
   }

   public String getStream_url()
   {
      return stream_url;
   }

   public void setStream_url(String stream_url)
   {
      this.stream_url = stream_url;
   }

   public String getTag_list()
   {
      return tag_list;
   }

   public void setTag_list(String tag_list)
   {
      this.tag_list = tag_list;
   }

   public long getId()
   {
      return id;
   }

   public void setId(long id)
   {
      this.id = id;
   }

}