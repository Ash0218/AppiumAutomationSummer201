package com.automation.tests; // 021320

import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Day1 {

    @Test
    public void test1(){ // 1
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities(); // 2

        // since we use android, put android. could be IOS.
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID); // 3

        // version of your device.
        desiredCapabilities.setCapability(MobileCapabilityType.VERSION, "7.0"); // 4

        // name of your device. If it's a real device, you need to use udid parameter.
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2"); // 5
        // either you can specify app -> //path/tothe/app.apk
        //  or, if app is already installed, you need to specify appActivity and AppPackage
        //  this info, you can find in the internet, at work - from developers
        //  otherwise, you can use apk info app to find this information.
    }
}
