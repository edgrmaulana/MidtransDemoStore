package org.midtransdemo.tests.utils;

import net.serenitybdd.core.steps.UIInteractions;
import org.springframework.stereotype.Component;

@Component("org.midtransdemo.tests.utils.CommonUtility")
public class CommonUtility extends UIInteractions {

    public void openPage(String url){
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        openUrl(url);
        getDriver().manage().window().maximize();
    }
}
