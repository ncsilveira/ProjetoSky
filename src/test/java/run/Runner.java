package run;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/feature",
                glue = "steps",
                monochrome = true,
                snippets = SnippetType.CAMELCASE,
                tags = {"@consultarProgramaAtual"}
    )
public class Runner {
}
