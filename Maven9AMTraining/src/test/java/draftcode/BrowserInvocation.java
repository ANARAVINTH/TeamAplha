package draftcode;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserInvocation {

    static WebDriver driver;
    static int a = 1;

    public static void main(String[] args) {
        System.out.println(a);
        System.setProperty("webdriver.chrome.driver","D:\\SeleniumFiles\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://login.salesforce.com/");

        driver.findElement(By.name("username")).sendKeys("Aravinth");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.id("Login")).click();
        String actualErrorMessage = driver.findElement(By.id("error")).getText();

        String expectedErrorMessage = "check your username and password. If you still can't log in, contact your Salesforce administrator.";

        if(actualErrorMessage.equals(expectedErrorMessage) ){

            System.out.println("Error message are equal");
        }
        else {
            System.out.println("errro message are not equal");
        }

        WebElement one = driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']"));

        int size =one.findElements(By.xpath("//*[@class='ui-state-default']")).size();

        for(int i=0 ; i <size;i++){

            String date =one.findElements(By.xpath("//*[@class='ui-state-default']")).get(i).getText();

            if(date.equals("23")){
                one.findElements(By.xpath("//a[@class='ui-state-default']")).get(i).click();
                break;
            }

        }

        driver.findElement(By.className("ui-datepicker-month")).getText();

        //While Loop

    }

}

