<h3 style="color: green">Selenium - Automation using Eclipse.</h3>

#Configuration
1. Download <b>Selenium client & Web driver Language Bindings</b> for java www.seleniumhq.org/download/
2. Download <b>geckodriver</b> for firefox from https://github.com/mozilla/geckodriver/releases OR <b>chromedriver</b> for chrome jar from https://sites.google.com/a/chromium.org/chromedriver/
3. Add <b>jars to external library</b> on java project follow this link http://toolsqa.com/selenium-webdriver/configure-eclipse-with-selenium-webdriver/
3. Install <b>TestNG plugin</b>, follow this link (find "how to install" from README.md) https://github.com/cbeust/testng-eclipse/
4. Setup example for:
   - <b>firefox driver:</b><br />
     
     ````js
     System.setProperty("webdriver.gecko.driver", "C:\\pathto\\my\\geckodriver.exe");<br />
     driver = new FirefoxDriver();<br />
     driver.get("http://www.google.com");<br />
     driver.quit();<br />
     ````
     
   - <b>chrome driver:</b><br />
   
     ````js
     System.setProperty("webdriver.chrome.driver", "C:\\pathto\\my\\chromedriver.exe")<br />
     WebDriver driver = new ChromeDriver();<br />
     driver.get("http://www.google.com");<br />
     driver.quit();<br />
     ````

#Selenium Script 

1. Selenium script can be found in this link: http://www.guru99.com/accessing-forms-in-webdriver.html
2. Exception / error handling can be found from this link : http://toolsqa.com/selenium-webdriver/exception-handling-selenium-webdriver/

#Java 

- Learn java can be found from this link https://www.codecademy.com/learn/learn-java

