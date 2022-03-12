package new2022;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static supportMethods.seleniumSupport.getDriver;

public class WebAutomationTest {

    static WebDriver driver ;

    public WebAutomationTest() {
        this.driver = getDriver();
    }

    @Test
    public void testSauceLabsWebsite(){

        driver.get("https://www.saucedemo.com/");

        WebElement userField = driver.findElement(By.id("user-name"));
        WebElement passField = driver.findElement(By.id("password"));
        WebElement submit = driver.findElement(By.xpath("//*[@class='submit-button btn_action']"));

        userField.sendKeys("standard_user");
        passField.sendKeys("secret_sauce");
        submit.click();

        driver.quit();
    }

}


