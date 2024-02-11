package org.midtransdemo.tests.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;

@Component("org.midtransdemo.tests.utils.CommonUtility")
public class CommonUtility {

    public WebDriver initializeChrome(){
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        return new ChromeDriver(chromeOptions);
    }
    public void openPage(String url){
        initializeChrome().get(url);
    }
}
