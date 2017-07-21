package CES29.Q2;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {
	    "pretty", "json:target/Open-Google-WebSite.json"},
	   features = {"src/test/resources"},
	   glue = {"CES29.Q2"}
)


public class ATMRunner {
 
}
