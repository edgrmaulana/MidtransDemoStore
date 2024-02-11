package org.midtransdemo.tests.hooks;

import org.junit.After;
import org.junit.Before;
import org.midtransdemo.tests.utils.CommonUtility;

public class CucumberHooks extends CommonUtility {

    @After
    public void afterRun(){
        initializeChrome().close();
    }

    @Before
    public void beforeRun(){

    }
}
