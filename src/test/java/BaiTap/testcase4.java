package BaiTap;

import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.sql.SQLOutput;

@Test
public class testcase4 {
    public static void testTC4() {
        WebDriver driver = driverFactory.getChromeDriver();

        try {
            // Step 1: Go to link
            driver.get("http://live.techpanda.org/");

            // Step 2: Click on 'MOBILE' menu
            driver.findElement(By.linkText("MOBILE")).click();
            Thread.sleep(2000);

            // Step 3: Click on 'Add To Compare' for Sony Xperia
            driver.findElement(By.xpath("(//a[text()='Add to Compare'])[2]")).click();
            Thread.sleep(2000);

            // Click on 'Add To Compare' for Iphone
            driver.findElement(By.xpath("(//a[text()='Add to Compare'])[3]")).click();
            Thread.sleep(2000);

            // Step 4: Click on 'COMPARE' button
            driver.findElement(By.xpath("//button[@title='Compare']//span//span[contains(text(),'Compare')]")).click();
            Thread.sleep(2000);

            // Step 5: Switch to the popup window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            Thread.sleep(2000);

            // Verify the pop-up window and check the products are reflected
            WebElement comparedSX = driver.findElement(By.xpath("//a[normalize-space()='Sony Xperia']"));
            WebElement comparedIphone = driver.findElement(By.xpath("//a[normalize-space()='IPhone']"));
            Assert.assertEquals(comparedSX.getText(), "SONY XPERIA");
            Assert.assertEquals(comparedIphone.getText(), "IPHONE");
            System.out.println("Products are reflected: " + comparedSX.getText() + " + " + comparedIphone.getText());

            WebElement popupHeading = driver.findElement(By.xpath("//h1[normalize-space()='Compare Products']"));
            String expectedHeading = "COMPARE PRODUCTS";
            Assert.assertEquals(popupHeading.getText(), expectedHeading);
            System.out.println("Popup window opened with heading: " + popupHeading.getText());

            // screenshot
            TakesScreenshot screenshot =((TakesScreenshot)driver);
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            String png = ("D:\\SWT\\selenium-webdriver-java\\src\\test\\resources\\Screenshot\\testcase4.png");
            FileUtils.copyFile(srcFile, new File(png));

            // Step 6: Close the popup window
            driver.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
