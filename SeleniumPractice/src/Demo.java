import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.security.PublicKey;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;


public class Demo {

    WebDriver driver = new ChromeDriver();

    public void launchBrowser() {

        driver.navigate().to("http://demo.guru99.com/V4/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        System.out.println("Browser Launched Successfully");


    }
    public void verifyHomePage()
    {
        driver.findElement(By.name("uid")).isDisplayed();
        driver.findElement(By.name("password")).isDisplayed();
        driver.findElement(By.name("btnLogin")).isDisplayed();
        driver.findElement(By.xpath("//h2[text()='Guru99 Bank']")).isDisplayed();
        System.out.println("Home Page Verified Successfully");

    }


    public void login() {
        driver.findElement(By.name("uid")).sendKeys("mngr325793");
        driver.findElement(By.name("password")).sendKeys("yrUbAmU");
        driver.findElement(By.name("btnLogin")).submit();
        System.out.println("Login Successful");
    }
    public void addCustomer() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='addcustomerpage.php']")).click();
        driver.findElement(By.name("name")).sendKeys("Simran");
        driver.findElement(By.xpath("//tr//td[2]//input[@value='f']")).click();

        driver.findElement(By.id("dob")).sendKeys("21-10-1996");
        driver.findElement(By.name("addr")).sendKeys("121 Green church");

        driver.findElement(By.name("city")).sendKeys("Patiala");
        driver.findElement(By.name("state")).sendKeys("Punjab");
        driver.findElement(By.name("pinno")).sendKeys("147001");

        driver.findElement(By.name("telephoneno")).sendKeys("9876542313");
        driver.findElement(By.name("emailid")).sendKeys("tiet6@yopmail.com");
        driver.findElement(By.name("password")).sendKeys("welcome");
        driver.findElement(By.name("res")).isDisplayed();
        driver.findElement(By.xpath("//input[@name='sub']")).click();

        driver.findElement(By.xpath("//p[contains(text(),'Customer Registered Successfully!!!')]")).isDisplayed();

        WebElement cusid=driver.findElement(By.xpath("//tbody//table[@id='customer']//tr[4]//td[2]"));

        System.out.println("Customer id : "+cusid.getText());
        sleep(3000);

        System.out.println("Customer Added Successfully");
    }
   public void deleteCustomer() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='DeleteCustomerInput.php']")).click();
       WebElement ele= driver.findElement(By.name("cusid"));
      ele.sendKeys("68602");
       driver.findElement(By.name("AccSubmit")).click();
       // Handling alerts
       sleep(2000);
       driver.switchTo().alert().accept();
       driver.switchTo().alert().accept();
        System.out.println("Customer Deleted Successfully");
    }

    public void selectLink() throws InterruptedException {
        WebElement ele1=driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//li//a[contains(text(),'Selenium')]"));
        ele1.click();
        sleep(3000);
        driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li[11]//a[contains(text(),'Login')]")).click();


        System.out.println("Value from dropdown selected successfully");

    }
    public void closeBrowser(){
        driver.quit();
    }


}


