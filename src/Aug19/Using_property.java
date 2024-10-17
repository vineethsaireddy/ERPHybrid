package Aug19;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Using_property 
{
WebDriver driver;
Properties pro;

@BeforeMethod
public void Setup() throws Throwable
{
	pro = new Properties();
	pro.load(new FileInputStream("primusbank.properties"));
	driver = new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.get(pro.getProperty("url"));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.xpath(pro.getProperty("objuser"))).sendKeys(pro.getProperty("Username"));
	driver.findElement(By.xpath(pro.getProperty("objpass"))).sendKeys(pro.getProperty("password"));
	driver.findElement(By.xpath(pro.getProperty("objlogin"))).click();	
}
	
@Test(priority = 1)
public void Branchcreation() throws Throwable
{
	driver.findElement(By.xpath(pro.getProperty("objBranches"))).click();
	driver.findElement(By.xpath(pro.getProperty("objNewBranch"))).click();
	driver.findElement(By.xpath(pro.getProperty("objBname"))).sendKeys(pro.getProperty("Branchname"));
	driver.findElement(By.xpath(pro.getProperty("objAddress1"))).sendKeys(pro.getProperty("Add1"));
	driver.findElement(By.xpath(pro.getProperty("objAddress2"))).sendKeys(pro.getProperty("Add2"));
	driver.findElement(By.xpath(pro.getProperty("objAddress3"))).sendKeys(pro.getProperty("Add3"));
	Thread.sleep(2000);
	driver.findElement(By.xpath(pro.getProperty("objArea"))).sendKeys(pro.getProperty("Area"));
	Thread.sleep(2000);
	driver.findElement(By.xpath(pro.getProperty("objZip"))).sendKeys(pro.getProperty("zip"));
	Thread.sleep(2000);
	new Select(driver.findElement(By.xpath(pro.getProperty("objcountry")))).selectByVisibleText(pro.getProperty("country"));
	Thread.sleep(2000);
	new Select(driver.findElement(By.xpath(pro.getProperty("objstate")))).selectByVisibleText(pro.getProperty("state"));
	Thread.sleep(2000);
	new Select(driver.findElement(By.xpath(pro.getProperty("objcity")))).selectByVisibleText(pro.getProperty("city"));
	Thread.sleep(2000);
    driver.findElement(By.xpath(pro.getProperty("objSubmit"))).click();
	
	String alrttext = driver.switchTo().alert().getText();
	System.out.println(alrttext);
	Thread.sleep(3000);
	driver.switchTo().alert().accept();

}

@Test(priority = 0)
public void Rolecreation() throws Throwable {
	
	driver.findElement(By.xpath(pro.getProperty("objRoles"))).click();
	driver.findElement(By.xpath(pro.getProperty("objNewRole"))).click();
	driver.findElement(By.xpath(pro.getProperty("objRoleName"))).sendKeys(pro.getProperty("Rolename"));
	driver.findElement(By.xpath(pro.getProperty("objRoleDesc"))).sendKeys(pro.getProperty("RoleDesc"));
    new Select(driver.findElement(By.xpath(pro.getProperty("objRoletype")))).selectByVisibleText(pro.getProperty("Roletype"));
	Thread.sleep(2000);    
	driver.findElement(By.xpath(pro.getProperty("objsubmit"))).click();
	Thread.sleep(2000);
	driver.switchTo().alert().accept();
}

@AfterMethod
public void teardown()
{
	driver.findElement(By.xpath(pro.getProperty("objLogout"))).click();
	
	
	
}
	
	
}
