package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBoxHelper {


    private WebDriver webDriver; //null

    private static TextBoxHelper textBoxHelper;

    private TextBoxHelper(WebDriver driver){
            webDriver = driver;
    }

    public static TextBoxHelper getInstance(WebDriver driver){

        textBoxHelper = new TextBoxHelper(driver);
        return textBoxHelper;
    }

    public void enterText(By locater,String textValue){

        webDriver.findElement(locater).sendKeys(textValue);
    }

    public void clickElement(By locater){
        webDriver.findElement(locater).click();
    }

    public String getTextValue(By locater){

       String textValue = webDriver.findElement(locater).getText();
       return textValue;
    }


}
