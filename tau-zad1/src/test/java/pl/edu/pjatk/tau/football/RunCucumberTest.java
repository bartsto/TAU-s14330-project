package pl.edu.pjatk.tau.football;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format = { "pretty" }, monochrome = true, features = {"classpath:pl.edu.pjatk.tau.football/cucumberTeam.feature"})
public class RunCucumberTest {
}
