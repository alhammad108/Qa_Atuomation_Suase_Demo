import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.UpdateConfig;
import com.github.dockerjava.core.dockerfile.DockerfileStatement.Add;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Check_High_Price {

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
@Test()
public void High_Price() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[4]")).click();
List<WebElement>  High_Price_List=driver.findElements(By.className("inventory_item_price"));
List<Double> Addtion=new ArrayList<>();
for(int i=0;i<High_Price_List.size();i++) {
	String Hieh_Price=High_Price_List.get(i).getText();
	
	String Update_High_Price =Hieh_Price.replace("$", "");
	
	Hieh_Price.trim();
	
	  double val = Double.parseDouble(Update_High_Price);
	  Addtion.add(val);
	  
	  
 
}

for(int j=0;j<Addtion.size();j++) {
	boolean Chech_High_Price=Addtion.get(0)>Addtion.get(Addtion.size()-1);
	 	
	Assert.assertEquals(Chech_High_Price , true);
}
}


}
