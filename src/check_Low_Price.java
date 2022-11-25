import java.util.ArrayList;
import java.util.List;

//price.split("$");عشان تشيل الاشي الي بطلبو بس لما يكون في list 
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
		String User_Name = "standard_user";
		String Password = "secret_sauce";

		driver.get("https://www.saucedemo.com/");

		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(User_Name);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(Password);
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	}

	@Test(groups = "sorting")
	public void Check_Low_To_High() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]")).click();

		List<WebElement> Price_List = driver.findElements(By.className("inventory_item_price"));
		List<Double> myNewPriceList = new ArrayList<>();
		for (int i = 0; i < Price_List.size(); i++) {
			
			String price = Price_List.get(i).getText();

			price.trim();// ذا كان في سبيس بالكود بشيلها

			String Updat_Price = price.replace("$", "");

			double val = Double.parseDouble(Updat_Price);

			myNewPriceList.add(val);

		}
		
		for(int k=0;k<myNewPriceList.size();k++) {
			
			boolean CheckProcess=myNewPriceList.get(0) < myNewPriceList.get(myNewPriceList.size()-1);
			
			Assert.assertEquals(CheckProcess, true);
		}
		
}
	
	

}
