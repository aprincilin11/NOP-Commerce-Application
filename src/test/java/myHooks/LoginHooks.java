package myHooks;

import gherkin.ast.Scenario;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import org.junit.After;
import org.junit.Before;

public class LoginHooks {

    

    @Before//(order = 1) //1. order execution will be in ascending order.
    // 2. instead of order we can give the @smoke here to execute this methods for the particular scenario, since we mentioned in
    // feature file that the @smoke where the scenario is, as well as we need to mention in test runner class also
    public void setUp_browser( Scenario sc){
        // By passing the scenario as a parameter, then that particular scenario or all scenarios will be executed
        // along with the step defn where ever it passed with/without name- another feature of cucumber
        System.out.println("Running setUp method before the step definition methods: Setting up the browser");
        System.out.println(sc.getName()); // Scenario's name will be displayed
    }

    @Before//(order = 2)
    public void setUp_url(){
        System.out.println("Running setUp method before the step definition methods: Setting up the URL");
    }

    @After//(order  = 2)     //order execution will be in descending order
    public void logout_app(Scenario sc){
        System.out.println("Running this method after all of the step definition method will be executed: close the app");
    }
    @After //(order = 1)
    public void tearDown(){
        System.out.println("Running this method after all of the step definition method will be executed: logout the app");
    }

    @BeforeStep
    public void takeScreenShot(){
        System.out.println("Take screen shot before each step ");
    }



    @AfterStep
    public void refresh(){
        System.out.println("Refresh the page after each step");
    }

//    Hooks Implementation:

// 1. feature file creation
//2. Step defn
//3. New package with the class for hooks with @before and @After annotations
//4. Test runner - in test runner we have add the package name of the hooks with the step defn package name

//    so when executing the method it will automatically go the @before method and execute whatever we wrote in there
//    and step defn will be executed and finally the @After method will be executed
//
//    Its like TestNG annotations but we r giving it in a separate package with a class
// We can have, multiple @before and @After methods, by giving order it will be executed in every scenarios by the order
}
