package tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import page.objects.HomePageTab;

public class LogInNewAccount extends TestBase{
    private HomePageTab home;

    @Test
    public void registerNewUser() {
        homePageTab();
        assertPositiveLogIn();
    }

    @AfterTest
    public void tearDown(){
        driver.close();
        driver.quit();
    }

    private void homePageTab(){
        home = new HomePageTab(driver);
        home.cookiesClose();
        home.signInAddButton();
        home.typeEmailAddress("uneducated@zane.pro");
        home.typePasswordAddress("Test321123!@#");
        home.logIn();
    }

    private void assertPositiveLogIn(){
        WebElement myAccount = driver.findElement(By.cssSelector("span[class=\"base\"]"));
        boolean checker = myAccount.isDisplayed();
        Assert.assertTrue(checker);
    }
}