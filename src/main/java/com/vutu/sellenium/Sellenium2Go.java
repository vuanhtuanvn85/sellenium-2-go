/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.vutu.sellenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author vuanh
 */
public class Sellenium2Go {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello World!");
        searchGoogle();
    }
    
    public static void searchGoogle() throws InterruptedException {
        WebDriver myBrowser;
        String driverPath = "chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        
        ChromeOptions opt = new ChromeOptions();
//        opt.addArguments("--incognito");
//        opt.addArguments("--lang=vi");
        
        myBrowser = new ChromeDriver(opt);
        myBrowser.get("https://google.com");
        myBrowser.manage().window().maximize();
        
        WebElement searchBox = myBrowser.findElement(By.name("q"));
        searchBox.sendKeys("GET GO");
        searchBox.submit();
        
        Thread.sleep(3000);
        myBrowser.quit();
    }
}
