package partyplanner;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

 @RunWith(Cucumber.class)
 @CucumberOptions(
		 features="src/test/resources",
	         monochrome= true,
		 snippets =CucumberOptions.SnippetType.CAMELCASE,
	         glue={"partyplanner"},
		 plugin= { "summary","html:target/cucumber/test-summary.html"}
 )

public class AcceptanceTest {
	
	 
}
