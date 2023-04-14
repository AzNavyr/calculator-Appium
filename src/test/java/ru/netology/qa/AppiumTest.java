package ru.netology.qa;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AppiumTest {

    private AndroidDriver driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "TestEmulator");
        desiredCapabilities.setCapability("appium:app", "C:\\Users\\User\\AndroidStudioProjects\\mqa-homeworks\\2.2 UI Automator\\sample\\app\\build\\outputs\\apk\\debug\\app-debug.apk");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void setEmptyTextTest() {
        MobileElement el1 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/textToBeChanged");
        el1.getText();
        MobileElement el3 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/userInput");
        el3.setValue(" ");
        MobileElement el2 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/buttonChange");
        el2.click();

        Assertions.assertEquals( "Hello UiAutomator!", el1.getText());
    }

    @Test
    public void sampleTest() {
        MobileElement el4 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/userInput");
        el4.sendKeys("SetText");
        MobileElement el5 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/buttonActivity");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/text");
        el6.getText();

        Assertions.assertEquals("SetText", el6.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
