# TestApi
You are the lead test engineer for our Developers API (https://api.nasa.gov/api.html#sounds) that is soon to be released to the public.
Problem  
1.	How would you certify this API for public consumption, with parameters q, limit & api_key? Create a README.md file to document your tests.  
GET https://api.nasa.gov/planetary/sounds  
2.	Code a few key examples to demonstrate how you can automate your tests.  

Test Cases:  
1. Provide apikey and check the api -- it should return only 10 results  
2. provide limit parameter and check if it is returning only provided number of results  
3. Dont pass any parameters to the api -- check error response  
4. Dont pass any api key parameter -- check if correct error response is returned  
5. Pass higher value for limit and check the response  
6. Pass null for api key -- check the response  
7. Pass alphabets for limit and check the response  
8. Pass invalid value for api key and check response  
9. Pass empty value for limit and check  
10. Pass valid values for q(search pattern), check if results are displayed correctly  
11. Invalid value for q  
12. Pass negative value for limit and check the response  
13. Pass multiple simultaneous requests and see how the api behaves  
14. Run api with 1000 inputs (same api key) and check the response  

