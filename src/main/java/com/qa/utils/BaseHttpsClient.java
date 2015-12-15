package com.qa.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class BaseHttpsClient
{
   Logger log = Logger.getLogger(BaseHttpsClient.class.getName());

   /**
    * Method to make rest call
    * @param -- end point url
    * @return -- response
    */
   public String getGetResponse(String url) throws Exception
   {
      URL serviceUrl = new URL(url);
      HttpURLConnection con = (HttpURLConnection) serviceUrl.openConnection();
      con.setRequestProperty("Content-Type", "application/json");
      con.setRequestMethod("GET");
      con.connect();
      log.info(String.valueOf(con.getResponseCode()));
      InputStreamReader ir = null;
      // if response code is 200 then get inputstream
      if (con.getResponseCode() == 200)
      {
         ir = new InputStreamReader(con.getInputStream());
      } else
      {
         // if response code is other than 200 then get error stream
         ir = new InputStreamReader(con.getErrorStream());
      }
      BufferedReader br = new BufferedReader(ir);
      StringBuilder sb = new StringBuilder();
      String inputLine;
      while ((inputLine = br.readLine()) != null)
      {
         sb.append(inputLine);
      }
      System.out.println(sb.toString());
      StringWriter writer = new StringWriter();
      writer.append("\nResponse:\n");
      writer.append("  URL:           ").append(con.getURL().toString()).append("\n");
      writer.append("  Response Code: ").append(Integer.toString(con.getResponseCode())).append("\n");
      writer.append("  Response Msg:  ").append(con.getResponseMessage()).append("\n");
      writer.append("  Header Fields: ").append(con.getHeaderFields().toString()).append("\n");
      writer.append("  Content:       ").append(sb.toString()).append("\n");
      log.info(writer.toString());
      return sb.toString();
   }

   /**
    * Method to concatenate parameters to the base url
    * @param -- base url
    * @param -- other parameters
    * @return -- url after concatenating parameters
    */
   public String concatenateUrlParams(String url, HashMap<String, Object> params) throws Exception
   {
      StringBuilder sb = new StringBuilder();
      sb.append(url);
      if (params != null && params.size() > 0)
      {
         if (!url.endsWith("?"))
         {
            sb.append("?");
         }
      }
      for (Map.Entry<String, Object> entry : params.entrySet())
      {
         if (sb.length() > 1)
         {
            sb.append("&");
         }
         sb.append(URLEncoder.encode(entry.getKey(), "utf-8"));
         sb.append("=");
         sb.append(URLEncoder.encode(entry.getValue().toString(), "utf-8"));
      }
      return sb.toString();
   }
}