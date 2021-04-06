package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageTab {

    private WebDriver driver;

    public HomePageTab(WebDriver driver) {
        this.driver = driver;
    }

    public void cookiesClose(){
        WebElement cookieClose = driver.findElement(By.cssSelector("div[class=\"cookie-info\"] button"));
        cookieClose.click();
    }

    public void signInAddButton(){
        WebElement signInActiveButton = driver.findElement(By.id("signin"));
        signInActiveButton.click();
    }

    public void registerButton(){
        WebElement registerButton = driver.findElement(By.cssSelector("div[class='primary register-button'] button"));
        registerButton.click();
    }

    public void typeEmailAddress(String email) {
        WebElement typeEmail = driver.findElement(By.cssSelector("#email"));
        typeEmail.sendKeys(email);
    }

    public void typePasswordAddress(String password) {
        WebElement typePassword = driver.findElement(By.cssSelector("#pass"));
        typePassword.sendKeys(password);
    }

    public void logIn() {
        WebElement logIn = driver.findElement(By.cssSelector("#send2"));
        logIn.click();
    }
}
