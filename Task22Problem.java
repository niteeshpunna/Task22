package GuviTask22;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Task22Problem {
	
	@Test
	public void testSet() throws Exception {
		// Create a new instance of the Chrome driver
			WebDriver d= new ChromeDriver();
			d.manage().window().maximize();
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			d.manage().deleteAllCookies();
	
			// Launch the URL
			d.get("https://phptravels.com/demo/");
			
			//verify the page The Internet
			assertEquals(d.getTitle(),"Book Your Free Demo Now - Phptravels");
			
			//Enter First Name
			WebElement firstname = d.findElement(By.xpath("//input[@name='first_name']"));
			firstname.sendKeys("Niteesh");
			
			//Enter Last Name
			WebElement lastname = d.findElement(By.xpath("//input[@name='last_name']"));
			lastname.sendKeys("Kumar");
			
			//Enter Business Name
			WebElement businessname = d.findElement(By.xpath("//input[@placeholder='Business Name']"));
			businessname.sendKeys("Guvi Business");
			
			//Enter email ID
			WebElement email = d.findElement(By.name("email"));
			email.sendKeys("testuser@gmail.com");
			
			Thread.sleep(2000);
		//Logic for sum verification
					//Locate number1
					WebElement number1 = d.findElement(By.xpath("//span[@id='numb1']"));
					String num1 = number1.getText();
					//Convert string into Integer
					int n1= Integer.parseInt(num1);
					
					//Locate number2
					WebElement number2 = d.findElement(By.xpath("//span[@id='numb2']"));
					String num2 = number2.getText();
					int n2 = Integer.parseInt(num2);
					
					//calculating sum of two numbers
					int sum = n1+n2;
					// converting this sum into string because sendkeys method will take String as a parameter
					String sum1 = Integer.toString(sum);
					
					//Enter sum value
					WebElement result = d.findElement(By.id("number"));
					result.sendKeys(sum1);
		
			// Click on submit
			d.findElement(By.xpath("//button[@id='demo']")).click();
			Thread.sleep(2000);
			
			//Verify ThankYou message
			WebElement message1 = d.findElement(By.xpath("//h2[@class='text-center cw']"));
			assertEquals(message1.getText(),"Thank you!");
			
			//Verify the description
			WebElement message2 = d.findElement(By.xpath("//p[@class='text-center cw']"));
			assertEquals(message2.getText(),"We have sent your demo credentials to your email please check your email to test demo website. if message not found inbox please check spam folder");
			
			Thread.sleep(2000);
			
			//Take screenshot
			File screenshotFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
			//to copy screenshot into local folder
			FileUtils.copyFile(screenshotFile, new File("F:\\GUVI\\Screenshots\\task22.jpg"));
			Thread.sleep(2000);
			
			//Close the browser instance
			d.quit();
	}
}
