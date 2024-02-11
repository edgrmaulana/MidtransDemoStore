package org.midtransdemo.tests.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.core.steps.UIInteractions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;

@Component("org.midtransdemo.tests.utils.CommonUtility")
public class CommonUtility extends UIInteractions {

    public WebDriver initializeChrome(){
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("start-maximized");

        return new ChromeDriver(chromeOptions);
    }
    public void openPage(String url){
        initializeChrome().close();
        openUrl(url);
        getDriver().manage().window().maximize();
    }
}
