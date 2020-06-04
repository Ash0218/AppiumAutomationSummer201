package com.automation.tests; // 021320

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Day1 {
    AppiumDriver<MobileElement> driver; // 10

    @Test
    public void test1() throws Exception { // 1
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities(); // 2

        // since we use android, put android. could be IOS.
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID); // 3

        // version of your device.
        desiredCapabilities.setCapability(MobileCapabilityType.VERSION, "7.0"); // 4

        // name of your device. If it's a real device, you need to use udid parameter.
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2"); // 5
        // either you can specify app -> //path/tothe/app.apk
        //  or, if app is already installed, you need to specify appActivity and AppPackage
        //  from the http://appium.io/docs/en/writing-running-appium/caps/ website.
        //  this info, you can find in the internet, at work - from developers
        //  otherwise, you can use apk info app to find this information.

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2"); // 13
        // it avoid issue of "could not find 'adb' in path.

        desiredCapabilities.setCapability("appPackage", "com.android.calculator2"); // 6
        // set your application's package name.

        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator"); // 7
        // Set your application's MainActivity i.e. the Launcher activity name.
        // Activity name of calculator for virtual mobile phone: go to settings
        //  in mobile phone -> you will see apk info -> double click -> click
        //  and hold Calculator -> click Detailed information -> you will see
        //  Activities: com.android … This is the activity name for calculator.

        // "http://localhost:4728/wd/hub" -> address of the appium server. If you have
        //  appium server on the same computer, just use local host.
        // 4723 -> default appium port.
        // We need to provide 2 parameters: URL of appium servers and desired capabilities.
        // In desired capabilities we specify device and application to test information.
        try { // 9
            driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities); // 8
        // URL is not compatible, so more actions -> surround with try & catch
        //  then, "AppiumDriver driver" does not work, so create another method on the top -> #10
        //  then delete "AppiumDriver" in front of "driver" and use only "driver" here (#8)
        } catch (MalformedURLException e) { // 9
            e.printStackTrace(); // 9
        }
        Thread.sleep(3000); // 12
        // sleep has an error, so go to #1 and add "throws Exception"
        // run -> test passed

        MobileElement digit2 = driver.findElement(By.id("com.android.calculator2:id/digit_2")); // 14
        // com.android.calculator2:id/digit_2 -> I copied from the Appium search box

        MobileElement digit4 = driver.findElement(By.id("com.android.calculator2:id/digit_4")); // 29
        MobileElement digit6 = driver.findElement(By.id("com.android.calculator2:id/digit_6")); // 24
        MobileElement digit7 = driver.findElement(By.id("com.android.calculator2:id/digit_7")); // 28

        MobileElement plus = driver.findElement(MobileBy.AccessibilityId("plus")); // 15
        // plus -> I copied from Appium search box
        // MobileBy -> a child class of By

        MobileElement equals = driver.findElement(MobileBy.AccessibilityId("equals")); // 16
        // equals -> I copied from Appium search box

        MobileElement result = driver.findElement(By.id("com.android.calculator2:id/result")); // 17
        // com.android.calculator2:id/result -> I copied from Appium search box

        MobileElement multiply = driver.findElement(MobileBy.AccessibilityId("multiply")); // 25
        MobileElement divide = driver.findElement(MobileBy.AccessibilityId("divide")); // 26
        MobileElement minus = driver.findElement(MobileBy.AccessibilityId("minus")); // 27

        digit2.click(); // 18
        // click on digit 2
        plus.click(); // 19
        // click on plus
        digit2.click(); // 20
        equals.click(); // 21
        // click on equals

        String resultText = result.getText(); // 22
        // read text of result

        Assert.assertEquals("4", resultText); // 23
        // assert that result equals to 4

        // 4 * 5 = 20
        getDigit(4).click(); // 32
        multiply.click(); // 34
        getDigit(5).click(); // 33
        equals.click(); // 35

        resultText = result.getText(); // 36
        Assert.assertEquals("20", resultText); // 37

        // 8/4 = 4
        getDigit(8).click(); // 38
        divide.click(); // 39
        getDigit(4).click(); // 40
        equals.click(); // 41

        resultText = result.getText(); // 42
        Assert.assertEquals("2", resultText); // 43

        // 50 - 30 = 20
        getDigit(5).click(); // 44
        getDigit(0).click(); // 45
        minus.click(); // 46
        getDigit(3).click(); // 47
        getDigit(0).click(); // 48
        equals.click(); // 49

        resultText = result.getText(); // 50
        Assert.assertEquals("20", resultText); // 51

        driver.closeApp(); // 11
    }


    @Test
    public void test2() throws Exception{ // 52
        // put throws Exception to compile #59
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities(); // 53
        desiredCapabilities.setCapability("platfromName", "Android"); // 54
        desiredCapabilities.setCapability(MobileCapabilityType.VERSION, "7.0"); // 55
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2"); // 56
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2"); // 57

        //to specify app for testing.
        //it can be on your computer or somewhere in cloud
        desiredCapabilities.setCapability("app", "https://cybertek-appium.s3.amazonaws.com/etsy.apk"); // 60
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities); // 58
        Thread.sleep(3000); // 59
    }


    public MobileElement getDigit(int digit){ // 30
        return driver.findElement(By.id("com.android.calculator2:id/digit_"+digit)); // 31
    }
}
