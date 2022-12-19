package resuable;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class LaunchBrowser {
  static WebDriver driver;

  protected static WebDriver launchBrowser() throws IOException {
      String path =System.getProperty("user.dir") ;
      System.out.println(path);
      FileInputStream fis  = new FileInputStream(new File("D:\\Selenium\\Nov9AM\\Maven9AMTraining\\src\\main\\resources\\utilities\\utlity.properties"));
      Properties properties = new Properties();
      properties.load(fis);

      if(properties.getProperty("Browser").equalsIgnoreCase("chrome")) {
          System.setProperty("webdriver.chrome.driver", path + "/src/main/resources/driver/chromedriver.exe");
          driver = new ChromeDriver();
      }
      else if (properties.getProperty("Browser").equalsIgnoreCase("edge")){
          System.setProperty("webdriver.edge.driver", path + "/src/main/resources/driver/chromedriver.exe");
          driver = new EdgeDriver();
      }
      else {

          throw new InvalidArgumentException("Please Enter the Correct Browser Name");
      }

      driver.navigate().to(properties.getProperty("url"));
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
      return driver;
  }

  public static void selectDrop(WebElement element){

      Select s = new Select(element);

  }

  public static int number(){

      int a =22;
      return a;
  }


}
