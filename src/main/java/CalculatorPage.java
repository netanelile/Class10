import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorPage {

    WebDriver driver;

    public CalculatorPage(){
        this.driver = DriverSibgleton.getDriverInstance();
    }

    public void printSevenButtonDemensions(){
        WebElement sevenBTN = driver.findElement(Constants.SEVEN_BUTTON);

        System.out.println("Height: " + sevenBTN.getRect().getHeight());
        System.out.println("Width: " + sevenBTN.getRect().getWidth());
        System.out.println("X: " + sevenBTN.getRect().getX());
        System.out.println("Y: " + sevenBTN.getRect().getY());
    }

    public void clickSidIfDisplayed(){
        if (driver.findElement(Constants.SEVEN_BUTTON).isDisplayed()){
            driver.findElement(Constants.SEVEN_BUTTON).click();
        }
    }

    public void calculateUsingIntVariable(int number){

    }
}
