package com.automation.tests; // 021320

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
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

        desiredCapabilities.setCapability("appActivity", "com.android.calculator2"); // 6
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
            driver = new AndroidDriver<>(new URL("http://localhost:4728/wd/hub"), desiredCapabilities); // 8
        // URL is not compatible, so more actions -> surround with try & catch
        //  then, "AppiumDriver driver" does not work, so create another method on the top -> #10
        //  then delete "AppiumDriver" in front of "driver" and use only "driver" here (#8)
        } catch (MalformedURLException e) { // 9
            e.printStackTrace(); // 9
        }
        Thread.sleep(3000); // 12
        // sleep has an error, so go to #1 and add "throws Exception"

        driver.closeApp(); // 11
    }
}
