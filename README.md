Selenium - Automation. 

#Configuration
1. Download Selenium client & Web driver Language Bindings for java www.seleniumhq.org/download/
2. Download Gecko for firefox from https://github.com/mozilla/geckodriver/releases OR chromedriver for chrome jar from https://sites.google.com/a/chromium.org/chromedriver/
3. Add jars to external library on java project follow this link http://toolsqa.com/selenium-webdriver/configure-eclipse-with-selenium-webdriver/
3. Install TestNG plugin, follow this link (find "how to install" from README.md) https://github.com/cbeust/testng-eclipse/
4. Setup example for:
   - firefox driver:
     System.setProperty("webdriver.gecko.driver", "C:\\pathto\\my\\geckodriver.exe");_
     driver = new FirefoxDriver();_
     driver.get("http://www.google.com");_
     driver.quit();_
   - chrome driver:
     System.setProperty("webdriver.chrome.driver", "C:\\pathto\\my\\chromedriver.exe");_
     WebDriver driver = new ChromeDriver();_
     driver.get("http://www.google.com");_
     driver.quit();_

#Selenium Script 

1. Selenium script can be found in this link: http://www.guru99.com/accessing-forms-in-webdriver.html
2. Exception / error handling can be found from this link : http://toolsqa.com/selenium-webdriver/exception-handling-selenium-webdriver/

#Java 

- Learn java can be found from this link https://www.codecademy.com/learn/learn-java

