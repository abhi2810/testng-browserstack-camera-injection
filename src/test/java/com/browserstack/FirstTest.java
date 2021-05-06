package com.browserstack;

import io.appium.java_client.ios.IOSElement;
import org.testng.annotations.Test;

import java.time.Instant;

public class FirstTest extends BrowserStackTestNGTest {

    public static String IMAGE_INJECTION_SCRIPT = "browserstack_executor: {\"action\": \"cameraImageInjection\", \"arguments\": {\"imageUrl\": \"%s\" }}";

    @Test
    public void test() throws Exception {
        driver.executeScript(String.format(IMAGE_INJECTION_SCRIPT,"media://3d04d830719b025f38797527267bce6e193280de"));
        IOSElement textButton = driver.findElementByAccessibilityId("Take Photo");
        textButton.click();
        System.out.println("clicked Take Photo");
        Thread.sleep(2000);
        IOSElement popButton = driver.findElementByAccessibilityId("OK");
        popButton.click();
        System.out.println("clicked OK");
        Thread.sleep(5000);
        IOSElement cap = driver.findElementByName("PhotoCapture");
        cap.click();
        System.out.println("time of capture" + Instant.now());
        System.out.println("clicked capture photo");
        Thread.sleep(5000);
        IOSElement usePhoto = driver.findElementByName("Use Photo");
        usePhoto.click();
        Thread.sleep(5000);
    }
}
