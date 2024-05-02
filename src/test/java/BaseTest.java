import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageObjects.HomePage;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    RemoteWebDriver driver;
    HomePage homePage;


    @BeforeClass
    public void SetUp() throws Exception {


        // Set up Chrome options
        ChromeOptions options = new ChromeOptions();
        // You can set other options as needed
        options.addArguments("start-maximized"); // opens browser window maximized

         driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);

        // Navigate to website
        driver.get("https://www.ae.com/us/en");
        System.out.println("Page title is: " + driver.getTitle());


        homePage = new HomePage(driver);

        ScreenshotListener screenshotListener = new ScreenshotListener();
        screenshotListener.setDriver(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
