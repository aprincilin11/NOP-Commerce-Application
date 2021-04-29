package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class LoginStepDefinition {


   public static  WebDriver driver; //to avoid the null pointer exception we r making the driver into static and in 2nd scenario
    // we r using if statement to make the driver point the 2nd scenario

    @Given("User is already on Login page")
    public void user_is_already_on_login_page() {
        System.setProperty("webdriver.chrome.driver", "C:\\Delina\\Drivers-Selenium\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://freecrm.com/");
    }

    @When("Title of login page is Free CRM")
    public void title_of_login_page_is_free_crm() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "#1 Free CRM customer relationship management software cloud");
        System.out.println("Login page title has verified");

    }

    @Then("User enters username and password")
    public void user_enters_username_and_password() {
        driver.findElement(By.xpath("//a[@class=\"btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left\"]")).click();
        driver.findElement(By.xpath("//input[@name=\"email\"] ")).sendKeys("aprincilin@gmail.com");
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("$Yallmusic123");

    }

    @Then("User clicks on login button")
    public void user_clicks_on_login_button() {
        driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();

    }

    @Then("User is on homepage")
    public void user_is_on_homepage() {

        // We have to make the driver to point the next scenario, otherwise the driver will be on the 1st scenario and gives 'Null pointer exception'
        if(driver==null) {
        driver = new ChromeDriver();

            String newTitle = driver.getTitle();
            Assert.assertEquals(newTitle, "Cogmento CRM");
            System.out.println("Account page title got verified");
        }
    }

     // First Scenario is over
     // Second scenario is to check the name displayed on homepage or not



    @Given("User is already on homepage")
    public void user_is_already_on_homepage(){
        String newTitle = driver.getTitle();
        Assert.assertEquals(newTitle, "Cogmento CRM");
        System.out.println("Account page title is verified");
    }

    @Then("User checks on the name has displayed or not")
    public void user_checks_on_the_name_has_displayed_or_not() {

        //driver.findElement(By.xpath("//span[contains(text(),'Calendar')]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Boolean b = driver.findElement(By.xpath("//span[contains(text(),'Princy Arul')]")).isDisplayed();
        //System.out.println(b);

    }

    @Then("User quit the browser")
    public void user_quit_the_browser() {
        driver.close();
    }

}
