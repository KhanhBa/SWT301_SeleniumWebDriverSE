package POM;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        driver.get("http://live.techpanda.org/");
    }

    public void goToMyAccount() {
        WebElement account = driver.findElement(By.linkText("ACCOUNT"));
        account.click();
        WebElement myAccount = driver.findElement(By.linkText("My Account"));
        myAccount.click();
    }

    public void Login(String email, String password){
        WebElement e = driver.findElement(By.id("email"));
        e.clear();
        e.sendKeys(email);
        WebElement p = driver.findElement(By.id("pass"));
        p.clear();
        p.sendKeys(password);
    }

    public void clickLogin(){
        WebElement loginButton = driver.findElement(By.name("send"));
        loginButton.click();
    }
}
