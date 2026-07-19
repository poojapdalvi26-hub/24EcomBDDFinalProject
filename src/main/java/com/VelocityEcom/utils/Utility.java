package com.VelocityEcom.utils;

import com.VelocityEcom.driverFactory.DriverFactory;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utility {

    public static String readDataFromPropertiesFile(String key) throws IOException {

        //String projectPath= System.getProperty("user.dir");
        FileInputStream myFile = new FileInputStream("C:\\Users\\pooja\\IdeaProjects\\24JanEcomBDDFinal\\src\\main\\resources\\config.properties");
        Properties properties = new Properties();
        properties.load(myFile);
        System.out.println("Reading data from properties file " +key);
        String value=properties.getProperty(key);
        return value ;

    }

    //read data from excel
    public static String readDataFromExcel(int row, int cell) throws IOException {
        FileInputStream myFile= new FileInputStream("C:\\Users\\pooja\\OneDrive\\Documents\\Software tesing Course\\Automation\\Book1.xlsx");
        String value = WorkbookFactory.create(myFile).getSheet("Sheet3").getRow(row).getCell(cell).getStringCellValue();
        System.out.println("Reading data from excel sheet " + row + " cell " +cell);
        return value;
    }

    public static void scrollIntoView(WebElement element)
    {
        Actions actions= new Actions(DriverFactory.getDriver());
        actions.scrollToElement(element).perform();
        System.out.println("scrolling into view");
    }
}
