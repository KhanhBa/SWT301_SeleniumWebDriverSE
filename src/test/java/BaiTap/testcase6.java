package BaiTap;

import POM.CartPage;
import POM.CheckOutPage;
import POM.LoginPage;
import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import POM.RegisterPage;
import org.testng.asserts.Assertion;

@Test
public class testcase6 {
    public static void testTC6() {
        WebDriver driver = driverFactory.getChromeDriver();
        String email = "Khanhba007@gmail.com";
        String password = "123456";
        String country = "United States";
        String state = "Florida";
        String zip = "2000";
        String firstname = "Khanh";
        String lastname = "Ba";
        String address = "hcm123";
        String city = "HCM";
        String telephone = "0123456789";

        try{
            LoginPage login = new LoginPage(driver);
            login.goToMyAccount();
            login.Login(email, password);
            login.clickLogin();
            Thread.sleep(2000);

            WebElement wishlist = driver.findElement(By.linkText("MY WISHLIST"));
            wishlist.click();

            WebElement addToCart = driver.findElement(By.xpath("//button[@type='button']//span//span[contains(text(),'Add to Cart')]"));
            addToCart.click();

            CartPage cart = new CartPage(driver);
            cart.enterCountry(country);
            cart.enterStateProvince(state);
            cart.enterZip(zip);
            cart.clickEstimate();
            cart.verifyShippingCost();
            cart.clickUpdateTotal();
            cart.verifyTotal();
            cart.clickCheckout();
            Thread.sleep(2000);

            CheckOutPage checkout = new CheckOutPage(driver);
            checkout.newBillingAddress();
            checkout.fillForm1(firstname, lastname, address, city);
            checkout.fillForm2(state, zip, country, telephone);
            checkout.chooseDifferentAddress();
            checkout.clickBillingContinue();
            Thread.sleep(2000);

            checkout.newShippingAddress();
            checkout.fillForm3(firstname, lastname, address, city);
            checkout.fillForm4(state, zip, country, telephone);
            checkout.clickShippingContinue();
            Thread.sleep(2000);

            checkout.clickShippingMethod();
            checkout.selectCheck();
            checkout.clickPaymentContinue();
            checkout.clickPlaceOrder();
            Thread.sleep(2000);

            checkout.verifyOrder();


        } catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();

    }
}
