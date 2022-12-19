package stepdefinationfile;

import draftcode.BrowserInvocation;
import helper.TextBoxHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import resuable.LaunchBrowser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HomePageSteps extends LaunchBrowser {

   private WebDriver driver;
   private TextBoxHelper textBoxHelper;
    @Given("launch URL")
    public  void url() throws IOException {

        driver = LaunchBrowser.launchBrowser(); //actual property

         textBoxHelper=  TextBoxHelper.getInstance(driver);
    }

    @When("US and PW")
    public void usAndPW() {

        textBoxHelper.enterText(By.cssSelector(".input.r4.wide.mb16.mt8.username"),"Learnmore");
        textBoxHelper.enterText(By.xpath("//input[@id='password']"),"123");

    }

    @And("Click login")
    public void clickLogin() {
        textBoxHelper.clickElement(By.id("Login"));
    }

    @When("Validate error")
    public void validateError() {

        String expectedResult = " check your  and password. If you still can't log in, contact your Salesforce administrator.";
        String actualResult = textBoxHelper.getTextValue(By.id("error"));

        Assert.assertEquals(expectedResult,actualResult);
    }

    @When("Iterate the dropdown value with the help of list")
    public void iterateTheDropdownValueWithTheHelpOfList() {

        WebElement currenyElement = driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListCurrency"));
        List<WebElement> dropvalues = currenyElement.findElements(By.tagName("option"));
        ArrayList<String> values = new ArrayList<String>();
        for(WebElement output:dropvalues){

           String currecyvalues = output.getText();
           values.add(currecyvalues);


        }
        System.out.println(values);

        for (String o:values){

           if(o.equals("USD")){

              Assert.assertEquals(o,"USD");
            }

        }

    }

    @When("count links using list")
    public void countLinksUsingList() {

       int totalLink = driver.findElements(By.tagName("a")).size();
        System.out.println(totalLink);

       WebElement footer = driver.findElement(By.id("footer-habitat"));
      int footerLink= footer.findElements(By.tagName("a")).size();
        System.out.println(footerLink);

    List <WebElement> productLinks =   footer.findElements(By.xpath("//div[@id='nav_menu-2']/ul/li/a"));

        for (WebElement e:productLinks){

           String keyAction = Keys.chord(Keys.CONTROL,Keys.ENTER);
            e.sendKeys(keyAction);
        }

      Set<String> windowValues =  driver.getWindowHandles();

        for(String winProp:windowValues){
           String title = driver.switchTo().window(winProp).getTitle();
            System.out.println(title);
        }

    driver.switchTo().defaultContent();

    }
}
