package Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class util {
    
    public static WebDriver driver;
    
    public String excelfile;
    public String sheetname;
    
    public void launchbrowserandurl(String browser,String url) {
        if(browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }else if(browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
        }else {
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    
    public void clickbtn(WebElement ele) {
        ele.click();
    }
    
    public void closebtn() {
        driver.close();
    }
    
    public void quitbtn() {
        driver.quit();
    }
    
    public void findelementbyidandsendkeys(String idvalue,String name) {
        driver.findElement(By.id(idvalue)).sendKeys(name);
    }
    
    public String[][] excelread( String excelfile , String sheetname) throws IOException{
        XSSFWorkbook book=new XSSFWorkbook("C:\\Users\\harin\\eclipse-workspace\\POM_DemoBlaze_excelread\\Excel_sheet\\"+excelfile+".xlsx");
        XSSFSheet sheet=book.getSheet(sheetname);
        int rowcount=sheet.getLastRowNum();
        int columncount=sheet.getRow(0).getLastCellNum();
        String data[][]=new String[rowcount][columncount];
        for(int i=1;i<=rowcount;i++) {
            XSSFRow row=sheet.getRow(i);
            for(int j=0;j<columncount;j++) {
                XSSFCell cell=row.getCell(j);
                data[i-1][j]=cell.getStringCellValue();
            }
        }
        book.close();
        return data;
    }
    
    public String randomnamegenerator() {
        String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        StringBuilder build=new StringBuilder();
        Random random=new Random();
        int length=7;
        
        for(int i=0;i<length;i++) {
            int index=random.nextInt(alphabet.length());
            
            char randomchar=alphabet.charAt(index);
            
            build.append(randomchar);
        }
        String name=build.toString();
        System.out.println("randome name : "+name);
        return name ;  
    }
    
    public String TakeScreenshot(String screenshotname) throws IOException {
        Date d=new Date();
        String time=new SimpleDateFormat("yyyyMMdd_HHmmss").format(d);
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String path="C:\\Users\\harin\\eclipse-workspace\\POM_DemoBlaze_excelread\\Screenshot\\"+screenshotname+"_"+time+".png";
        File des=new File(path);
        FileUtils.copyFile(src, des);
        return path;
    }
}
