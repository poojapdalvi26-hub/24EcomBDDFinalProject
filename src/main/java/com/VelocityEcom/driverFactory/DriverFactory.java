package com.VelocityEcom.driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    static WebDriver driver;

  public static void setBrowser(String browser){
      if(browser.equals("chrome"))
      {
        driver= new ChromeDriver();
      }else if(browser.equals("edge"))
      {
          driver= new EdgeDriver();
      } else if (browser.equals("firefox")) {

          driver= new FirefoxDriver();
      }
      System.out.println("setting browser as" +browser);
  }

  public static WebDriver getDriver()
  {
      return driver;
  }
}
