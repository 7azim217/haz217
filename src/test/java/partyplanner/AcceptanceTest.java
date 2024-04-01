package partyplanner;


import java.util.Scanner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

 @RunWith(Cucumber.class)
 @CucumberOptions(
		 features="Features",
		 plugin= { "summary","html:target/cucumber/test-summary.html"},
		 monochrome= true,
		 snippets =SnippetType.CAMELCASE,
		 glue="partyplanner")

public class AcceptanceTest {
	
	 
}
