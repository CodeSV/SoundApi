package com.qa.service;

import java.util.HashMap;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.utils.BaseHttpsClient;

public class SoundApiTests
{
   Logger log = Logger.getLogger(SoundApiTests.class.getName());
   BaseHttpsClient baseClass = new BaseHttpsClient();
   ObjectMapper mapper = new ObjectMapper();
   public static final String URL = "https://api.nasa.gov/planetary/sounds";
   public static final String YAHOO = "https://beta.finance.yahoo.com/__assets/charts/ddshadow2.json";
   HashMap<String, Object> params = new HashMap<String, Object>();

   @AfterClass(alwaysRun=true)
   public void cleanUp()
   {
      try{
         params.clear();
      }catch(Exception e)
      {
         Assert.fail("Not able to clear values in hashmap",e);
      }
   }

  /**
   * Method to create request url
   * @param api_key -- UUID value
   * @param limit --Maximum number of records to be fetched per buffer
   * @param searchKey -- search value
   * @return end point url
   */
   private String createRequestUrl(String api_key, String limit, String searchKey)
   {
      params.put("api_key", api_key);
      params.put("limit", limit);
      params.put("q", searchKey);
      String url = null;
      try
      {
         url = baseClass.concatenateUrlParams(URL, params);
         log.info("request url:" + url);
      } catch (Exception e)
      {
         Assert.fail("Error while creating the request url", e);
      }
      return url;
   }

  /**
    * Get a reference to response with a SoundResponseData result.
    * @return Ref to  response.
   */
   public TypeReference<SoundResponseData> soundTypeRef()
   {
      return new TypeReference<SoundResponseData>() {
      };
   }

   /**
    * Get a reference to response with a ErrorData result.
    * @return Ref to  response.
   */
   public TypeReference<ErrorData> errTypeRef()
   {
      return new TypeReference<ErrorData>() {
      };
   }

   @Test(dataProviderClass = SoundApiDataProvider.class, dataProvider = "positiveTests")
   public void checkSoundApi(String api_key, String limit, String searchKey, String expectedCount) throws Exception
   {
      String url = createRequestUrl(api_key, limit, searchKey);
      String result = baseClass.getGetResponse(url);

      SoundResponseData response = mapper.readValue(result, soundTypeRef());
      Assert.assertEquals(response.getCount(), Integer.parseInt(expectedCount),
            "Returned count is not same as expected");
      int size = response.getCount();
      if (size > 0)
      {
         for (int i = 0; i < size; i++)
         {
            Assert.assertNotNull(response.getResults().get(i).getId(), "Id cannot be null");
            Assert.assertNotNull(response.getResults().get(i).getLicense(), "License cannot be null");
            Assert.assertNotNull(response.getResults().get(i).getDownload_url(), "download url cannot be null");
         }
      }
   }

   @Test(dataProviderClass = SoundApiDataProvider.class, dataProvider = "negativeTests")
   public void negativeTestSoundApi(String api_key, String limit, String searchKey, String expectedCode,
         String expectedMsg) throws Exception
   {
      String url = createRequestUrl(api_key, limit, searchKey);
      String result = baseClass.getGetResponse(url);
      Document doc = Jsoup.parse(result);
      Assert.assertEquals(doc.getElementsByTag("h1").toString(), expectedCode,
            "Returned error code is not same as expected");
      Assert.assertEquals(doc.getElementsByTag("p").toString(), expectedMsg,
            "Returned error message is not same as expected");
      // ErrorData response = mapper.readValue(result, errTypeRef());
      // System.out.println(response.getError());
   }

   public TypeReference<YahooData> yahooResponse()
   {
      return new TypeReference<YahooData>() {
      };
   }

   @Test()
   public void checkYahooApi() throws Exception
   {
      String ir = baseClass.getGetResponse(YAHOO);
      YahooData response = mapper.readValue(ir, yahooResponse());
      log.info(response.getBaseUrl());
   }

}