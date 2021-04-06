package page.objects;

import com.mifmif.common.regex.Generex;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreatingNewAccountTab {

    private WebDriver driver;

    public CreatingNewAccountTab(WebDriver driver) {
        this.driver = driver;
    }

    public void typeIntoFirstNameField(String userFirstName){
        WebElement lastName = driver.findElement(By.id("firstname"));
        lastName.sendKeys(userFirstName);
    }

    public void typeIntoLastNameField(String userLastName){
        WebElement lastName = driver.findElement(By.id("lastname"));
        lastName.sendKeys(userLastName);
    }

    public void checkboxNewsletter(){
        WebElement checkBoxNewsletter = driver.findElement(By.id("is_subscribed"));
        checkBoxNewsletter.click();
    }

    public void emailGenerator(String regex){
        WebElement email = driver.findElement(By.cssSelector("input[id='email_address']"));
        String generatedEmail = new Generex(regex).random();
        email.sendKeys(generatedEmail);
    }

    public void typeIntoPasswordField(String hashedPassword){
        WebElement password =driver.findElement(By.cssSelector("#password"));
        password.sendKeys(decoder(hashedPassword));
    }

    public void typeIntoConfirmPasswordField(String hashedPassword){
        WebElement confirmPassword = driver.findElement(By.cssSelector("#password-confirmation"));
        confirmPassword.sendKeys(decoder(hashedPassword));
    }

    public void accountCreateButton(){
        WebElement createAccount = driver.findElement(By.cssSelector("button[class=\"action submit primary\"]"));
        createAccount.click();
    }

    private String decoder(String password) {
        byte[] decodedKey = Base64.decodeBase64(password);
        return new String(decodedKey);
    }
}
