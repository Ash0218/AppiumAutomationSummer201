package com.automation.tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

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

    public void test(){

    }
}
