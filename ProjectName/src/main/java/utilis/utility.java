package utilis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class utility {
	 
	public static void getshot(WebDriver driver , int TESTID) throws IOException {
		
		TakesScreenshot take = (TakesScreenshot)driver;
		File source=take.getScreenshotAs(OutputType.FILE);
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date date = new Date();
		String time=df.format(date);
		File dest = new File("C:\\Users\\Shree\\Desktop\\Screenshots\\TESTTC"+TESTID+""+time+".jpeg");
		FileHandler.copy(source, dest);
		
	}
	
	public static String getexcelsheet(String sheet ,int row,int cellValue) throws EncryptedDocumentException, IOException  {
		
		FileInputStream file = new FileInputStream("C:\\Users\\Shree\\Desktop\\Excel\\Test.xlsx");
		Cell cell=WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(cellValue);
		
				try {
					String str = cell.getStringCellValue();
					return str;
				}
				catch(Exception e) {
					double d = cell.getNumericCellValue();	
					int convertValue= (int) d;
					String result = String.valueOf(convertValue);
					return result;
				}
				
	
	}
	
	
	
	
	
	
}
	

