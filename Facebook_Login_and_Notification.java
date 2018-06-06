package com.webautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver WDname = new ChromeDriver();

        WDname.get("http://www.facebook.com");
        WebElement emailInput = WDname.findElement(By.id("email"));
        emailInput.sendKeys("sfsdfas");
        WebElement passwordInput =  WDname.findElement(By.id("pass"));
        passwordInput.sendKeys("SDfasdf");

        WDname.findElement(By.id("loginbutton")).click();


        WebDriverWait wait = new WebDriverWait(WDname, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("notificationsCountValue")));

        System.out.println("new notifications : " + element.getText());

    }
}
