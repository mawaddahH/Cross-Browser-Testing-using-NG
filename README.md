# Cross-Browser-Testing-using-NG
Assignment 2 W10D2 - SDA - Software QA Bootcamp

## Table of contents
* [Question](#question)
* [Answer](#answer)
* [Output Screenshots](#output-screenshots)

---
## Question
Create Automation Scripts using the TestNG framework for Cross Browser Testing.

- STEP 1: Initialize a parameter with the name browser.
- STEP 2: Initialize the browser driver depending on the parameter value. For a browser value equal to Chrome, initialize a chrome driver,and so on.
- STEP 3: Open the website “instagram.com” on the browser and click an element with the help of Selenium.
- STEP 4: Specify the browser values in the TestNG XML file.

---

## Answer
I used [Instagram](https://www.instagram.com/?hl=en) website
Before running the code, there are some steps that need to take considered:

### First:
Setup Latest [Web Driver](https://chromedriver.chromium.org/downloads) for Chrome Driver,
Setup Latest [Web Driver](https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/) for Edge Driver,
and etup Latest [Web Driver](https://github.com/mozilla/geckodriver/releases) for Firefox Driver.

Donwload the necessary jar files:
- [Selenium](https://www.selenium.dev/downloads/) (Lastest).
- [TestNG](http://www.java2s.com/Code/Jar/t/Downloadtestng685jar.htm)  (Lastest).
- [jcommander](http://www.java2s.com/Code/Jar/j/Downloadjcommanderjar.htm)  (Lastest). 

### Second:
Add them as a library in the classpath of the project
- _click-reight on the file project >Build path > configure Bild path > Java Build Path > Libraries > classpath > add external JARs > Apply and close_.

### Third:
I opened the website, then take web elements, and then add them to the code.
I used the annotation:

```md
 @Parameters("browser")
```

```md
@Optional
```

In the Code
```md
@Parameters("browser")

@BeforeSuite
public void setUp( @Optional String browser) {
	// the path for open WebSite
if (browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\lo0ol\\" + "Downloads\\Compressed\\chromedriver_win32_2\\chromedriver.exe");
		driver = new ChromeDriver();
	} else if (browser.equalsIgnoreCase("edge")) {
		// the path for open WebSite
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\lo0ol\\Downloads" + "\\Compressed\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();

	} else if (browser.equalsIgnoreCase("firefox")) {
		// the path for open WebSite
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\lo0ol\\Downloads\\" + "Compressed\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
		else {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\lo0ol\\" + "Downloads\\Compressed\\chromedriver_win32_2\\chromedriver.exe");
		driver = new ChromeDriver();
	}
}
```

Then I passed the values in the TestNG XML file:
```md
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Suite">
<parameter name="browser" value="firefox"/>  
  <test thread-count="5" name="Test">
    <classes>
      <class name="ass2W10D2.ChromWebDriverAss2W10D2"/>
    </classes>
  </test> <!-- Test -->
</suite> <!-- Suite -->

```
---

## Output Screenshots:

<p align="center">
<img src="https://user-images.githubusercontent.com/48597284/185636822-7767e081-8c52-4af5-994f-3afbd4b4753a.png" width=80% height=80%>


https://user-images.githubusercontent.com/48597284/185637434-a0c130f1-8d12-4168-8afa-1bab88683abf.mp4



</p>
