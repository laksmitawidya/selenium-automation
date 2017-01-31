#Selenium - Automation. 

1. Download Selenium client & Web driver Language Bindings for java and Gecko for firefox/chromedriver for chrome jar from www.seleniumhq.org/download/
2. Add jars to external library on java project follow this link http://toolsqa.com/selenium-webdriver/configure-eclipse-with-selenium-webdriver/
3. Install TestNG plugin follow this link https://github.com/cbeust/testng-eclipse/
4. Setup example for:
   - firefox driver:
     System.setProperty("webdriver.gecko.driver", "C:\\pathto\\my\\geckodriver.exe");
     
     driver = new FirefoxDriver();
     
     driver.get("http://www.google.com");
   - chrome driver:
     System.setProperty("webdriver.chrome.driver", "C:\\pathto\\my\\chromedriver.exe");
     
     WebDriver driver = new ChromeDriver();
     
     driver.get("http://www.google.com");


