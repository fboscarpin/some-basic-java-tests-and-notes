package new2022;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import supportMethods.SupportFilesUsers;

import static supportMethods.SeleniumSupport.getDriver;

public class WebAutomationTest {

    static WebDriver driver ;

    public WebAutomationTest() {
        this.driver = getDriver();
    }

    @Test
    public void testSauceLabsWebsite(){

        // get user data
        SupportFilesUsers user = new SupportFilesUsers();
        String username = user.returnUsersCSV(1)[0];
        String password = user.returnUsersCSV(1)[1];

        // nagivate to website
        driver.get("https://www.saucedemo.com/");

        // find ui elements
        WebElement userField = driver.findElement(By.id("user-name"));
        WebElement passField = driver.findElement(By.id("password"));
        WebElement submit = driver.findElement(By.xpath("//*[@class='submit-button btn_action']"));

        // login action

        userField.sendKeys(username);
        passField.sendKeys(password);
        submit.click();

//        driver.quit();
    }

}


