package com.tau.poom;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseConfiguration {
    private WebDriver driver;

    public BaseConfiguration(WebDriver drive) {
        this.driver=drive;
    }

    public WebDriver SetUpConfiguracion(WebDriver driver) {
        System.setProperty("webdriver.chrome.driver","src/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }
    public void openBrowser(String url){
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void tyPe(String valor, By element){
        driver.findElement(element).sendKeys(valor);
    }

    public void clic(By element){
       driver.findElement(element).click();
    }

    public Boolean isElementPresent(By element){
        boolean status = false;
        if(!driver.findElements(element).isEmpty()){
            status = driver.findElement(element).isDisplayed();
        }

        return status;
    }

    public String getText(By element){
        String text = null;
         text = driver.findElement(element).getText();
        return text;
    }

    public  String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
// after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = System.getProperty("user.dir") + "/test-output/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }
}
