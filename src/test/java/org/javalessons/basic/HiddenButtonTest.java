package org.javalessons.basic;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class HiddenButtonTest {


    public static final String HTTPS_SCOOL = "https://school-samples-qa-modal.azurewebsites.net";
    public static final long wait_time = 15;
    WebDriver driver;



    @Before
    public void executeBeforeEach() {
        String chromeDriverPath = "/Users/xxx/Downloads/chromedriver";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
    }

    @After
    public void executeAfterEach() {
        driver.quit();
    }

    @Test
    public void testGoogleSearchWorks() throws InterruptedException {
        driver.get(HTTPS_SCOOL);

        WebElement element = driver.findElement(By.id("open-modal-button"));
        element.click();
        WebDriverWait wait = new WebDriverWait(driver, wait_time);


        /**
         Other possibility to wait for the visibility of the element
         Thread.sleep(15000);
         */

        WebElement waitedElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-body")));
        String myWaitedElement = waitedElement.getText();

        assertEquals("Secret content", myWaitedElement);
        System.out.println(myWaitedElement);


    }



}
