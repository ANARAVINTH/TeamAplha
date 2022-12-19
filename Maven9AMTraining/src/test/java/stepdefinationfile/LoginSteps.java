package stepdefinationfile;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import resuable.LaunchBrowser;

import java.io.IOException;
import java.time.Duration;

public class LoginSteps extends LaunchBrowser {

    int a =1;
    private WebDriver driver;
    private WebElement currencyElement;
    @When("User Enter the Username {string} and password {string}")
     private  void enterUsernamePassword(String userName,String password){

        System.out.println(userName);

        driver.findElement(By.name("username")).sendKeys(userName);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.pollingEvery(Duration.ofSeconds(5));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
        driver.findElement(By.id("password")).sendKeys("123");

    }

    @Given("User Navigates to the salesforce login page")
    public void naviagteURL() throws IOException {

      driver =  LaunchBrowser.launchBrowser();
       int valoeOfA = LaunchBrowser.number();

    }

    @And("User clicks the login button")
    public void clickLogin(){

        //driver.findElement(By.id("Login")).click();
        driver.findElement(By.cssSelector("input[id='Login']")).click();

        driver.findElement(By.linkText("Use Custom Domain")).click();
        driver.findElement(By.partialLinkText(" Athens of the")).click();
        driver.findElement(By.className("inputwidefocus_mt8-mb16"));

    }

    @Then("User should navigate to the homepage")
    public void validate(){

    }

    @Then("User Validate the error message")
    public void validateErrorMessage(){

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("error")));

        String actualErrorMessage = driver.findElement(By.id("error")).getText();

        String expectedErrorMessage = "check your username and password. If you still can't log in, contact your Salesforce administrator.";

        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);



    }


    @Given("User Navigate to the required URL")
    public void url() throws IOException {

      driver =  LaunchBrowser.launchBrowser();
    }
    @Then("User selects the values from the dropdown")
    public void handleDropdown() {

        currencyElement = driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListCurrency"));

        LaunchBrowser.selectDrop(currencyElement);
      Select selectCurrency = new Select(currencyElement);
       // selectCurrency.selectByIndex(3);
       // selectCurrency.selectByVisibleText("AED");
        selectCurrency.selectByValue("CAD");


    }

    @And("User get the dropdown value")

    public  void getValues(){

      int currencyDropdownSize =  currencyElement.findElements(By.tagName("option")).size();

      for (int i =0 ; i < currencyDropdownSize ; i++ ){

         String currencyValue = currencyElement.findElements(By.tagName("option")).get(i).getText();

          System.out.println(currencyValue);
        }
    }


    @Then("User selects the values from the dynamic dropdown")
    public void selectDynamicDropdown(){
        driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='CJB']")).click();

     //  WebElement toDropdownElement = driver.findElement(By.id("glsControlGroupSearchView_AvailabilitySearchInputSearchViewdestinationStation1_CTNR"));
     //   toDropdownElement.findElement(By.xpath("//a[@value='MAA']")).click();

        driver.findElement(By.xpath("//div[@id='glsControlGroupSearchView_AvailabilitySearchInputSearchViewdestinationStation1_CTNR']//a[@value='MAA']")).click();





    }

    @Then("User selects the value from Autosuggestive dropdown")
    public void selectAutoSuggestiveValue() throws InterruptedException {

        driver.findElement(By.name("flying_from_N")).click();

        Thread.sleep(500);

        WebElement fromValue =  driver.findElement(By.name("flying_from"));
        fromValue.sendKeys("che");
        Thread.sleep(500);
        int i =0;

        while(i<4){
            fromValue.sendKeys(Keys.ARROW_DOWN);
            i++;
        }

        fromValue.sendKeys(Keys.ENTER);
    }

    @Then("Handle the frame")
    public void handleTheFrame() {

      WebElement frameElement =  driver.findElement(By.className("demo-frame"));
      driver.switchTo().frame(frameElement);

      Actions actions = new Actions(driver);

      WebElement source =driver.findElement(By.id("draggable"));
      WebElement target = driver.findElement(By.id("droppable"));

     // actions.doubleClick();

        actions.dragAndDrop(source,target).build().perform();
        actions.clickAndHold().build().perform();


      driver.switchTo().defaultContent()  ;
      driver.findElement(By.linkText("Droppable")).click();
    }

    @Then("handle frame")
    public void handleFrame() {

       WebElement infosysTable = driver.findElement(By.cssSelector(".infobox.vcard"));

       int columnOneSize =infosysTable.findElements(By.tagName("td")).size();

        System.out.println(columnOneSize);

        for(int i=2;i< columnOneSize; i++ ){

           String columnValue = infosysTable.findElements(By.tagName("td")).get(i).getText();
            System.out.println(columnValue);

        }

        WebElement contentsTable = driver.findElement(By.className("toc"));
       int size = contentsTable.findElements(By.tagName("li")).size();

       for(int i=0; i<size;i++){
          String value = contentsTable.findElements(By.tagName("li")).get(i).getText();

           if(value.equals("abc")){

           }

       }

      WebElement acquisitionsTable = driver.findElement(By.xpath("//table[@class='wikitable']"));

        acquisitionsTable.findElements(By.tagName("/tbody/tr/td[4]")).size();




    }

    @Then("count links")
    public void countLinks() {

      WebElement footer =  driver.findElement(By.id("footer-habitat"));

      int footerSize = footer.findElements(By.tagName("a")).size();

        System.out.println(footerSize);


    }

    @And("Handle Calander")
    public void handleCalander() {

        driver.findElement(By.cssSelector(".ui-datepicker-trigger")).click();

        while(!driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//div[@class='ui-datepicker-title']")).getText().contains("April")) {
            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
        }



    String actualAlertMessage = driver.switchTo().alert().getText();

        driver.switchTo().alert().sendKeys("abc");
        driver.switchTo().alert().accept();

    }
}
