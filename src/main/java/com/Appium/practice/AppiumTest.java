package com.Appium.practice;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumTest {
    @BeforeTest
    public void setup() {
        AppiumBase.start();
    }

    @Test
    public void testAppium() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("noReset", "false");
        capabilities.setCapability("deviceName", "RZCT41LPXGL");
        capabilities.setCapability("platformVersion", "14");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UIAutomator2");
        capabilities.setCapability("appPackage", "in.amazon.mShop.android.shopping");
        capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
        capabilities.setCapability("newCommandTimeout", "30");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
//        driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Select English\"]")).click();
//        driver.findElement(By.id("in.amazon.mShop.android.shopping:id/continue_button")).click();
    }
//        try {
//            WebElement element =driver.findElement(By.id("in.amazon.mShop.android.shopping:id/skip_sign_in_button"));
//            if (element.isDisplayed()) {
//                element.click();
//            }
//        }
//        catch (Exception e){
//        //    e.printStackTrace();
//            System.out.println("exception : " +e.getMessage());
//        }
//         driver.switchTo().frame(driver.findElement(By.id("android:id/content")));
//        driver.findElement(By.id("in.amazon.mShop.android.shopping:id/chrome_search_hint_view")).click();
//        driver.findElement(By.id("in.amazon.mShop.android.shopping:id/rs_search_src_text")).sendKeys("samsung a52s");

    @AfterTest
    public void stop() {
        AppiumBase.stop();
    }
}
