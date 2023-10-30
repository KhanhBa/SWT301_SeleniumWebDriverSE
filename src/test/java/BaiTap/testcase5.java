package BaiTap;

import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import POM.RegisterPage;
import org.testng.asserts.Assertion;

import java.io.File;

@Test
public class testcase5 {
    public static void testTC5() {
        WebDriver driver = driverFactory.getChromeDriver();
        String firstname = "Khanh";
        String midname= "Van";
        String lastname = "Ba";
        String email = "Khanhba007@gmail.com";
        String password = "123456";
        String confirm = "123456";

        try {
            // Step 1: Go to link
            RegisterPage page = new RegisterPage(driver);

            // Step 2: Click on my account link
            page.goToMyAccount();
            Thread.sleep(2000);

            // Step 3: Click Create an Account link
            page.createAccount();
            Thread.sleep(2000);

            // fill New User information excluding the registered Email ID.
            page.fillFirstName(firstname);
            page.fillLastName(lastname);
            page.fillEmail(email);
            page.fillPassword(password);
            page.fillConfirm(confirm);
            Thread.sleep(2000);

            // Step 4: Click Register
            page.clickRegister();
            Thread.sleep(2000);
            // screenshot Register
            TakesScreenshot screenshot =((TakesScreenshot)driver);
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            String png = ("D:\\SWT\\selenium-webdriver-java\\src\\test\\resources\\Screenshot\\testcase5_1.png");
            FileUtils.copyFile(srcFile, new File(png));

            //S Step 5: Verify Registration is done. Expected account registration done.
            WebElement registration = driver.findElement(By.xpath("//span[normalize-space()='Thank you for registering with Main Website Store.']"));
            String expectedRegistration = "Thank you for registering with Main Website Store.";
            Assert.assertEquals(registration.getText() ,expectedRegistration);
            System.out.println("Registration done!");

            // Step 6: Go to TV menu
            driver.findElement(By.linkText("TV")).click();
            Thread.sleep(2000);

            // Step 7: Add product (e.g., LG LCD) to your wish list
            driver.findElement(By.xpath("//a[contains(text(),'LG LCD')]//following::a[text()='Add to Wishlist']")).click();
            Thread.sleep(2000);

            // Step 8: Click 'SHARE WISHLIST'
            driver.findElement(By.xpath("//span[contains(text(),'Share Wishlist')]")).click();

            // Step 9: Enter Email and a message and click 'SHARE WISHLIST'
            driver.findElement(By.id("email_address")).sendKeys(email);
            driver.findElement(By.id("message")).sendKeys("Share wishlist!");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[@title='Share Wishlist']")).click();

            // Step 10: Check wishlist is shared
            WebElement share = driver.findElement(By.xpath("//span[normalize-space()='Your Wishlist has been shared.']"));
            String expectedShare = "Your Wishlist has been shared.";
            Assert.assertEquals(share.getText(), expectedShare);
            System.out.println("Wishlist shared successfully!");
            Thread.sleep(2000);
            // screenshot result
            String png2 = ("D:\\SWT\\selenium-webdriver-java\\src\\test\\resources\\Screenshot\\testcase5_2.png");
            FileUtils.copyFile(srcFile, new File(png2));
        } catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();
    }
}