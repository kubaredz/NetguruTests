package tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import page.objects.CreatingNewAccountTab;
import page.objects.HomePageTab;

public class RegisterNewAccount extends TestBase {
    private HomePageTab home;
    private CreatingNewAccountTab creatingAcc;

    @Test
    public void registerNewUser() {
        homePageTab();
        creatingNewAccountTab();
        assertPositiveRegister();
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
        home.registerButton();
    }

    private void creatingNewAccountTab(){
        creatingAcc = new CreatingNewAccountTab(driver);
        creatingAcc.typeIntoFirstNameField("Jakub");
        creatingAcc.typeIntoLastNameField("Redzinski");
        creatingAcc.checkboxNewsletter();
        creatingAcc.emailGenerator("\\w{10}\\@gmail\\.com");
        creatingAcc.typeIntoPasswordField("VGVzdDMyMTEyMyFAIw==");
        creatingAcc.typeIntoConfirmPasswordField("VGVzdDMyMTEyMyFAIw==");
        creatingAcc.accountCreateButton();
    }

    private void assertPositiveRegister(){
        WebElement message = driver.findElement(new By.ByXPath(
                "//div[contains(text(),'Dziękujemy za rejestrację w Sprint Bakoniuk Sp. J.')]"));
        boolean checker = message.isDisplayed();
        Assert.assertTrue(checker);
    }
}
