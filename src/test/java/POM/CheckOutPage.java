package POM;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CheckOutPage {
    private WebDriver driver;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void newBillingAddress(){
        WebElement selectAddress = driver.findElement(By.id("billing-address-select"));
        Select select = new Select(selectAddress);
        select.selectByVisibleText("New Address");
    }

    public void fillForm1(String firstName, String lastName, String address, String city){
        WebElement first = driver.findElement(By.id("billing:firstname"));
        first.clear();
        first.sendKeys(firstName);
        WebElement last = driver.findElement(By.id("billing:lastname"));
        last.clear();
        last.sendKeys(lastName);
        WebElement add = driver.findElement(By.id("billing:street1"));
        add.clear();
        add.sendKeys(address);
        WebElement City = driver.findElement(By.id("billing:city"));
        City.clear();
        City.sendKeys(city);
    }

    public void fillForm2(String state, String zip, String country, String telephone){
        WebElement State = driver.findElement(By.id("billing:region_id"));
        Select newState = new Select(State);
        newState.selectByVisibleText(state);
        WebElement Zip = driver.findElement(By.id("billing:postcode"));
        Zip.clear();
        Zip.sendKeys(zip);
        WebElement Country = driver.findElement(By.id("billing:country_id"));
        Select newCountry = new Select(Country);
        newCountry.selectByVisibleText(country);
        WebElement Tel = driver.findElement(By.id("billing:telephone"));
        Tel.clear();
        Tel.sendKeys(telephone);
    }

    public void chooseDifferentAddress(){
        WebElement dif = driver.findElement(By.xpath("//label[@for='billing:use_for_shipping_no']"));
        dif.click();
    }

    public void clickBillingContinue(){
        WebElement con = driver.findElement(By.xpath("//button[@onclick='billing.save()']//span//span[contains(text(),'Continue')]"));
        con.click();
    }

    public void newShippingAddress(){
        WebElement selectAddress = driver.findElement(By.id("shipping-address-select"));
        Select select = new Select(selectAddress);
        select.selectByVisibleText("New Address");
    }

    public void fillForm3(String firstName, String lastName, String address, String city){
        WebElement first = driver.findElement(By.id("shipping:firstname"));
        first.clear();
        first.sendKeys(firstName);
        WebElement last = driver.findElement(By.id("shipping:lastname"));
        last.clear();
        last.sendKeys(lastName);
        WebElement add = driver.findElement(By.id("shipping:street1"));
        add.clear();
        add.sendKeys(address);
        WebElement City = driver.findElement(By.id("shipping:city"));
        City.clear();
        City.sendKeys(city);
    }

    public void fillForm4(String state, String zip, String country, String telephone){
        WebElement State = driver.findElement(By.id("shipping:region_id"));
        Select newState = new Select(State);
        newState.selectByVisibleText(state);
        WebElement Zip = driver.findElement(By.id("shipping:postcode"));
        Zip.clear();
        Zip.sendKeys(zip);
        WebElement Country = driver.findElement(By.id("shipping:country_id"));
        Select newCountry = new Select(Country);
        newCountry.selectByVisibleText(country);
        WebElement Tel = driver.findElement(By.id("shipping:telephone"));
        Tel.clear();
        Tel.sendKeys(telephone);
    }

    public void clickShippingContinue(){
        WebElement con = driver.findElement(By.xpath("//button[@onclick='shipping.save()']//span//span[contains(text(),'Continue')]"));
        con.click();
    }

    public void clickShippingMethod(){
        WebElement con = driver.findElement(By.xpath("//button[@onclick='shippingMethod.save()']//span//span[contains(text(),'Continue')]"));
        con.click();
    }

    public void selectCheck(){
        WebElement check = driver.findElement(By.id("p_method_checkmo"));
        check.click();
    }

    public void clickPaymentContinue(){
        WebElement con = driver.findElement(By.xpath("//button[@onclick='payment.save()']"));
        con.click();
    }

    public void clickPlaceOrder(){
        WebElement order = driver.findElement(By.xpath("//span[contains(text(),'Place Order')]"));
        order.click();
    }

    public void verifyOrder(){
        WebElement heading = driver.findElement(By.xpath("//h1[normalize-space()='Your order has been received.']"));
        String expectedOrder = "YOUR ORDER HAS BEEN RECEIVED.";
        Assert.assertEquals(expectedOrder, heading.getText());
    }
}
