/**
 * @author Mawaddah Hanbali
 */
package ass2W10D2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ChromWebDriverAss2W10D2 {
	public WebDriver driver;

	@Parameters("browser")

	/**
	 * Set up browser settings and open the application
	 */

	@BeforeSuite
	public void setUp(@Optional String browser) {
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
		} else {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\lo0ol\\" + "Downloads\\Compressed\\chromedriver_win32_2\\chromedriver.exe");
			driver = new ChromeDriver();
		}

	}

	/**
	 * Open the application
	 */

	@BeforeTest
	public void nevigate() {

		// Maximize current window
		driver.manage().window().maximize();

		// Navigate to a WebSite
		driver.navigate().to("https://www.instagram.com/?hl=en");

	}

	/**
	 * Test error message
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void TestNG() throws InterruptedException {

		// wait until the login form appears.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='loginForm']")));

		// username
		WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys("Mawaddah@gmail.com");

		// password
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("Mawaddah@gmail.com");

		// log-in button
		WebElement loging = driver.findElement(By.xpath("//button[contains(@type,'submit')]"));
		loging.click();

		// wait until error message displayed
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(@role,'alert')]")));

		WebElement error = driver.findElement(By.xpath("//p[contains(@role,'alert')]"));
		if (error.isDisplayed()) {
			String text = error.getText();
			Assert.assertEquals(text, "Sorry, your password was incorrect. Please double-check your password.");
		}

		Thread.sleep(3000);

	}

	/**
	 * Tear down the setup after test completes
	 */
	@AfterSuite
	public void terminateBrowser() {
		// Close the browser
		driver.quit();
	}
}
