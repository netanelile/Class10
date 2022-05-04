import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

public class MainTest {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.WAIT));
        wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.WAIT));
    }


    @Test
    public void FirstAssignment_Test(){

        driver.get("https://dgotlieb.github.io/Selenium/synchronization.html"); // Enter https://dgotlieb.github.io/Selenium/synchronization.html

        driver.findElement(By.id("btn")).click(); //Press on “remove checkbox” button

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("message")))); //find the new element that will show up under the CheckBox - use Implicit Wait.

        driver.findElement(By.id("hidden")).click(); //Press on “Show hidden” button

        try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();} // use Thread.sleep().

        Assert.assertTrue(driver.findElement(By.id("finish1")).isDisplayed()); //find the new element that will replace the “Show hidden” button

    }

    @Test
    public void SecondAssignment_Test(){
        System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
        driver = new ChromeDriver();
        NgWebDriver ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);
        ngWebDriver.waitForAngularRequestsToFinish();

        driver.get("https://dgotlieb.github.io/AngularJS/main.html"); // Enter https://dgotlieb.github.io/AngularJS/main.html Using ngWebDriver

        WebElement firstNameBTN = driver.findElement(ByAngular.model("firstName"));
        String myName = "Netanel";
        firstNameBTN.clear(); // Clear first name.
        firstNameBTN.sendKeys(myName); // Enter your first name instead.
        Assert.assertEquals(driver.findElement(ByAngular.binding("firstName")).getText(), myName); // Assert result.

        }

        //3. To wait till the whole page we just entered will finish uploading and all elements will be presented. And more importantly, when to stop waiting for it.

    @Test
    public void ForthAssignment_Test(){
        CalculatorPage cp = new CalculatorPage(); //Use a Singleton class to create and return your driver.
        driver.manage().window().maximize();
        driver.get("https://dgotlieb.github.io/WebCalculator/"); //Enter https://dgotlieb.github.io/WebCalculator/
        driver.manage().window().maximize();

        cp.printSevenButtonDemensions(); // Print “7” button dimensions (using Constant).
        cp.clickSidIfDisplayed(); // Check if “6” button is displayed

        //Didn't understand what to do with the Int variable

    }

    @Test
    public void FifthAssignment_Test(){

        WebDriver driver = new ChromeDriver();
        driver.get("http://Google.com"); //Open Google in first tab
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("http://YouTube.com"); //Open YouTube on the second tab
        ((JavascriptExecutor)driver).executeScript("window.open()");
        tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));
        driver.get("https://translate.google.com/"); //Open Google translate in the third tab.
        driver.switchTo().window(tabs.get(0)); // From translate go to Google
        driver.switchTo().window(tabs.get(1)); //from Google go to YouTube.



    }


}
