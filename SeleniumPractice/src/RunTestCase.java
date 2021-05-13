
public class RunTestCase extends Demo {
    public static void main(String args[]) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\IdeaProjects\\libs\\chromedriver.exe");
        Demo obj=new Demo();

        // Launch browser
        obj.launchBrowser();

        // verify home page
        obj.verifyHomePage();
        // Login
        obj.login();

        // Add Customer
        obj.addCustomer();

        // Delete Customer
          obj.deleteCustomer();

        // Select value from dropdown
        obj.selectLink();

        // Close browser
        obj.closeBrowser();


    }


}
