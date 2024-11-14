/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.vutu.selenium.guru99;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author vuanh
 */
public class Guru99Test {

    private static WebDriver myBrowser;
    private static String driverPath = "chromedriver.exe";
    
    @BeforeAll
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        
        myBrowser = new ChromeDriver();
        myBrowser.get("https://google.com");
        myBrowser.manage().window().maximize();
    }
    
    @Test
    public void testLoginGivenRightAccountSayHelloUserName() throws InterruptedException {
        String userName = "mngr600971";
        String pass = "YtAjyjE";
        
        myBrowser.get("https://demo.guru99.com/V1/");
        
        WebElement userTag = myBrowser.findElement(By.xpath("(//input[@name='uid'])[1]"));
        userTag.sendKeys(userName);
        
        WebElement passTag = myBrowser.findElement(By.cssSelector("input[name='password']"));
        passTag.sendKeys(pass);
        
        WebElement loginTag = myBrowser.findElement(By.xpath("(//input[@name='btnLogin'])[1]"));
        loginTag.click();
        
        Thread.sleep(3000);
        
        WebElement helloTag = myBrowser.findElement(By.xpath("(//marquee[@class='heading3'])[1]"));
//        System.out.println("Msg after login: " + helloTag.getText());
        assertEquals("Welcome To Manager's Page of GTPL Bank", helloTag.getText());
        
        
        Thread.sleep(5000);
    }
    
    @AfterAll
    public static void tearDownClass() {
        myBrowser.quit();
    }
    
}
