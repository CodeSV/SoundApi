package com.qa.service;

import org.testng.annotations.DataProvider;

public class SoundApiDataProvider
{
   /**
    * For now i've just hard coded the values in data provider. in general I
    * would add it to the excel and write a utility to read from excel
    * 
    * @return
    */
   @DataProvider(name = "positiveTests")
   public static Object[][] positiveTests()
   {
      return new Object[][] { { "PHeP5aWWj4M1O6yd5s162EnfGnGpdu5Pbexo7FmO", "5", "", "5" } };
   }

   @DataProvider(name = "negativeTests")
   public static Object[][] negativeTests()
   {
      return new Object[][] { { "xyz", "5", "", "<h1>API_KEY_INVALID</h1>",
            "<p>An invalid api_key was supplied. Get one at https://api.nasa.gov</p>" } };
   }
}