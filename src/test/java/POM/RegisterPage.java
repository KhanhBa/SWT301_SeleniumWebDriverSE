package POM;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterPage {
    private WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        driver.get("http://live.techpanda.org/");
    }

    public void goToMyAccount() {
        WebElement account = driver.findElement(By.linkText("ACCOUNT"));
        account.click();
        WebElement myAccount = driver.findElement(By.linkText("My Account"));
        myAccount.click();
    }

    public void createAccount(){
        WebElement create = driver.findElement(By.xpath("//a[@title='Create an Account']"));
        create.click();
    }

    public void fillFirstName(String first){
        WebElement firstname = driver.findElement(By.id("firstname"));
        firstname.clear();
        firstname.sendKeys(first);
    }

    public void fillLastName(String last){
        WebElement lastname = driver.findElement(By.id("lastname"));
        lastname.clear();
        lastname.sendKeys(last);
    }

    public void fillEmail(String email){
        WebElement email_address = driver.findElement(By.id("email_address"));
        email_address.clear();
        email_address.sendKeys(email);
    }

    public void fillPassword(String pass){
        WebElement password = driver.findElement(By.id("password"));
        password.clear();
        password.sendKeys(pass);
    }

    public void fillConfirm(String confirm){
        WebElement confirmation = driver.findElement(By.id("confirmation"));
        confirmation.clear();
        confirmation.sendKeys(confirm);
    }

    public void clickRegister() {
        WebElement register = driver.findElement(By.xpath("//span[contains(text(),'Register')]"));
        register.click();
    }

}