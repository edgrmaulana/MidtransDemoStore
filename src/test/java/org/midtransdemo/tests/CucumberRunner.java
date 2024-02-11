package org.midtransdemo.tests;

import cucumber.runtime.SerenityObjectFactory;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = {"org.midtransdemo.tests.steps",
                "org.midtransdemo.tests.hooks"},
        objectFactory = SerenityObjectFactory.class,
        tags = "@MidtransDemoStoreFeature")
public class CucumberRunner {

}
