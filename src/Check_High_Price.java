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

public class check_High_price {

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
@Test()
public void high_Price() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[4]")).click();
List<WebElement>  high_Price_List=driver.findElements(By.className("inventory_item_price"));
List<Double> Addtion=new ArrayList<>();
for(int i=0;i<High_Price_List.size();i++) {
	String hieh_Price=high_Price_list.get(i).getText();
	
	String update_High_price =hieh_Price.replace("$", "");
	
	hieh_Price.trim();
	
	  double val = Double.parseDouble(update_High_price);
	  Addtion.add(val);
	  
	  
 
}

for(int j=0;j<Addtion.size();j++) {
	boolean chech_High_price=Addtion.get(0)>Addtion.get(Addtion.size()-1);
	 	
	Assert.assertEquals(chech_High_price , true);
}
}


}
