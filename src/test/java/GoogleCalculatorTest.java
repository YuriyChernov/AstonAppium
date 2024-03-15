import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class GoogleCalculatorTest {
    private AppiumDriver<AndroidElement> driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 7 Pro API 34");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.calculator");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.calculator2.Calculator");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Epic(value = "Google калькулятор")
    @Feature(value = "Простые математические операции")
    @Story(value = "Сложение")
    @Test
    public void additionTest() {
        Allure.getLifecycle().updateTestCase(result -> {
            result.setName("Сложение");
        });
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='2']")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='plus']")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='3']")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='equals']")).click();
        String result = driver.findElement(By.className("android.widget.TextView")).getText();
        Assert.assertEquals(result, "5");
    }

    @Epic(value = "Google калькулятор")
    @Feature(value = "Простые математические операции")
    @Story(value = "Вычитание")
    @Test
    public void subtractionTest() {
        Allure.getLifecycle().updateTestCase(result -> {
            result.setName("Вычитание");
        });
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='7']")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='minus']")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='2']")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='equals']")).click();
        String result = driver.findElement(By.className("android.widget.TextView")).getText();
        Assert.assertEquals(result, "5");
    }

    @Epic(value = "Google калькулятор")
    @Feature(value = "Простые математические операции")
    @Story(value = "Умножение")
    @Test
    public void multiplicationTest() {
        Allure.getLifecycle().updateTestCase(result -> {
            result.setName("Умножение");
        });
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='4']")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='multiply']")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='8']")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='equals']")).click();
        String result = driver.findElement(By.className("android.widget.TextView")).getText();
        Assert.assertEquals(result, "32");
    }

    @Epic(value = "Google калькулятор")
    @Feature(value = "Простые математические операции")
    @Story(value = "Деление")
    @Test
    public void divisionTest() {
        Allure.getLifecycle().updateTestCase(result -> {
            result.setName("Деление");
        });
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='6']")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='divide']")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='3']")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='equals']")).click();
        String result = driver.findElement(By.className("android.widget.TextView")).getText();
        Assert.assertEquals(result, "2");
    }

    @AfterTest
    public void finish() {
        if (driver != null)
            driver.quit();
    }
}
