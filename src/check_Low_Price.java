import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class check_Low_Price {

	public WebDriver driver;

	@BeforeTest()
	public void Log_in() throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		String user_Name = "standard_user";
		String Password = "secret_sauce";

		driver.get("https://www.saucedemo.com/");

		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(user_Name);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(Password);
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	}

	@Test(groups = "sorting")
	public void check_Low_To_High() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]")).click();

		List<WebElement> price_List = driver.findElements(By.className("inventory_item_price"));
		List<Double> myNewpriceList = new ArrayList<>();
		for (int i = 0; i < Price_List.size(); i++) {
			
			String price = Price_List.get(i).getText();

			price.trim();

			String updat_Price = price.replace("$", "");

			double val = Double.parseDouble(updat_Price);

			myNewpriceList.add(val);

		}
		
		for(int k=0;k<myNewpriceList.size();k++) {
			
			boolean checkProcess=myNewpriceList.get(0) < myNewpriceList.get(myNewpriceList.size()-1);
			
			Assert.assertEquals(checkProcess, true);
		}
		
}
	
	

}
