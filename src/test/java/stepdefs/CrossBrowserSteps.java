package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CrossBrowserSteps {

    boolean chromeOK = false;
    boolean edgeOK = false;
    boolean firefoxOK = false;

    public boolean openBrowser(String browserName) {

        WebDriver driver = null;

        try {

            switch (browserName.toLowerCase()) {

                case "chrome":
                    driver = new ChromeDriver();
                    break;

                case "edge":
                    driver = new EdgeDriver();
                    break;

                case "firefox":
                    driver = new FirefoxDriver();
                    break;

                default:
//                    System.out.println("Invalid browser name: " + browserName);
                    return false;
            }
            
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));
            driver.get("https://www.google.com");
            
            boolean ok = driver.getTitle().contains("Google");

            driver.quit();
            return ok;

        } catch (Exception e) {
            return false;
        }
    }

    @When("I open google on chrome edge and firefox")
    public void testAllBrowsers() {

        chromeOK = openBrowser("chrome");
        edgeOK = openBrowser("edge");
        firefoxOK = openBrowser("firefox");
    }

    @Then("I print the status of all browsers")
    public void printStatus() {

        System.out.println("Chrome working  : " + chromeOK);
        System.out.println("Edge working    : " + edgeOK);
        System.out.println("Firefox working : " + firefoxOK);
    }
}