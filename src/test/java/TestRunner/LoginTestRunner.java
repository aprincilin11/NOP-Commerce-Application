package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"C:\\Users\\rajas\\IdeaProjects\\nopCommerce_project\\Features\\login.feature"}

        , glue = {"stepDefinitions", "myHooks"}   // myHooks is the name of the package like testNG, before and After annotations
        // This annotations will be executed in all scenarios

        ,tags = "@smoke or @Regression" // Another feature in Hooks
        , plugin = {"pretty",     // gives a clear output in a readable way
        "json: json-report",
        "junit: freeCrm-junitReport",
        "html:freeCrm-output"
}

        // this is coming from the dependency "extentreports-cucumber4-adapter"
        // To get the reports, we have to give the type of report we need and the report name we want to create
        // Reports will be created inside the 'target' package usually
        // After run this test we can able to see the reports inside the target folder
        //Here 3 types of report we asked : html,xml and Json

        ,publish = true     // To publish the reports outside- anywhere - whoever having the link can view it

        // If we give like this the output option looks different to view the reports
        // this is the feature introduced after JVM 6.9, so that we can get the reports through publishing it
        // and also it will be viewable only for 24 hrs.
        // COpy the link in the console and give it in a browser and see the reports
        //If we dont give this we have to create a file according to the console output instructions(Inside the box) inside the
        // src/test/resources.   and inside the file we have to give 'cucumber.publish.enabled=true' (given inside the console - box)

        ,dryRun = true
        // will give checks the steps matching with the feature file steps



)

public class LoginTestRunner {
}
