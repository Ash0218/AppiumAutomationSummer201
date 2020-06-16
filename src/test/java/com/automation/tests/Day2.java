package com.automation.tests;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class Day2 {
    private AndroidDriver<MobileElement> driver; // 1

    @Before
    public void setup(){ // 2
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities(); // 3
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2"); // 4
        desiredCapabilities.setCapability(MobileCapabilityType.VERSION, "7.0"); // 5
        desiredCapabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"/api_demos.apk"); // 6
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID); // 7
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2"); // 8
        try { // 10
            driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities); // 9
        // put mouse in URL (it was red) and add more actions -> surround try and catch
        } catch (MalformedURLException e) { // 10
            e.printStackTrace(); // 11
        }
    }

    @After
    public void teardown(){ // 12
        driver.closeApp(); // 13
    }


    @Test
    public void test() throws Exception{ // 14
     //   Thread.sleep(5000); // 15
        WebDriverWait wait = new WebDriverWait(driver, 20); // 16
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Views"))); // 17
        // Views -> was copied from Appium
        // It is explicit wait.
        // Implicit wait -> apply to all elements
        // don't use implicit and explicit together

        driver.findElement(MobileBy.AccessibilityId("Views")).click(); // 18


        MobileElement webview = driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable("
                 + "new UiSelector().scrollable(true)).scrollIntoView("
                 + "new UiSelector().textContains(\"WebView\"));")); // 19
        // it is from: developer.android.com/reference/android/support/test/uiautomator/UiSelector#checkable
        // instead of testContains, you can use: text or id, className
        // if you want to know if the text is Webview, open Appium ->
        //  in the emulator in Appium, click the word, check the text
        //  shows "WebView"

        webview.click(); // 20

        // go back
        driver.navigate().back(); // 21

        MobileElement imageSwitcher = driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable("
                + "new UiSelector().scrollable(true)).scrollIntoView("
                + "new UiSelector().textContains(\"ImageSwitcher\"));")); // 22

        imageSwitcher.click(); // 23

    }
}
