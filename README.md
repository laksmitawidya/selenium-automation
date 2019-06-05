<h3 style="color: green">Selenium - Automation using Eclipse.</h3>

<b>Configuration</b>
1. Download <b>Selenium client & Web driver Language Bindings</b> for java www.seleniumhq.org/download/
2. Download <b>geckodriver</b> for firefox from https://github.com/mozilla/geckodriver/releases OR <b>chromedriver</b> for chrome jar from https://sites.google.com/a/chromium.org/chromedriver/
3. Add <b>jars to external library</b> on java project follow this link http://toolsqa.com/selenium-webdriver/configure-eclipse-with-selenium-webdriver/
3. Install <b>TestNG plugin</b>, follow this link (find "how to install" from README.md) https://github.com/cbeust/testng-eclipse/
4. Setup example for:
   - <b>Firefox driver:</b><br />
     
     ````js
     System.setProperty("webdriver.gecko.driver", "C:\\pathto\\my\\geckodriver.exe");
     driver = new FirefoxDriver();
     driver.get("http://www.google.com");
     driver.quit();
     ````
     
   - <b>Chrome driver:</b><br />
   
     ````js
     System.setProperty("webdriver.chrome.driver", "C:\\pathto\\my\\chromedriver.exe")
     WebDriver driver = new ChromeDriver();
     driver.get("http://www.google.com");
     driver.quit();
     ````

<b>Selenium Script</b>

1. Selenium script can be found in this link: http://www.guru99.com/accessing-forms-in-webdriver.html
2. Exception / error handling can be found from this link : http://toolsqa.com/selenium-webdriver/exception-handling-selenium-webdriver/
3. For full screenshot https://www.assertthat.com/posts/selenium_shutterbug_make_custom_screenshots_with_selenium_webdriver, the jars file can be found in http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22selenium-shutterbug%22

<b>Java</b>

- Learn/best practice using java language can be found from this link https://www.codecademy.com/learn/learn-java

`HAPPY TESTING!` 
