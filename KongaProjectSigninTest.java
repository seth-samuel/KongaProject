import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class KongaProjectSigninTest {

    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the chromedriver is
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. Open your Chrome browser
        driver = new ChromeDriver(chromeOptions);
        //2. Visit the URL Konga
        driver.get("https://www.konga.com");
        //Test1. Verify the user input the right url and is on the right page site
        if (driver.getCurrentUrl().contains("https://www.konga.com"))
            //Pass
            System.out.println("correct page site");
        else
            //Fail
            System.out.println("Wrong page site");
        //3. Maximize the browser
        driver.manage().window().maximize();
        //4. Click on Signin button to open the Signin page
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(5000);
    }


    @Test (priority = 0)
    public void Signin() throws InterruptedException {
        //5. Input email on the user email field
        driver.findElement(By.id("username")).sendKeys("samuelkafinta454@gmail.com");
        //6. Input password on the user password field
        driver.findElement(By.id("password")).sendKeys("sk4545@@");
        //7. Click on the signin button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        String expectedURL = "https://www.konga.com";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedURL))
            //Pass
            System.out.println("correct Login details");
        else
            //Fail
            System.out.println("Wrong Login details");
        Thread.sleep(5000);



    }
    @Test (priority = 1)
    public void Computers_and_accessories() throws InterruptedException {
        //8. Click on Computers_and_accessories
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
        //test2. Verify that when user clicks on Computers_and_accessories, the user is directed to Computers_and_accessories page
        String expectedURL = "https://www.konga.com";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedURL))
            //Pass
            System.out.println("correct category");
        else
            //Fail
            System.out.println("Wrong category");
        Thread.sleep(5000);


    }

    @Test (priority = 2)
    public void Laptop() throws InterruptedException {
        //9. Click on Laptop
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/label/span")).click();
        //10. Click on Apple MacBooks
        driver.findElement(By.cssSelector("#mainContent > section._8d917_1ixfS > section > div > section > div:nth-child(2) > div.ec98e_ZsoHv > ul > li:nth-child(3) > a > ul > li:nth-child(1) > a > label > span")).click();
        Thread.sleep(5000);


    }

    @Test (priority = 3)
    public void Add_Item_To_Cart() throws InterruptedException {
        //11.Add an Apple MacBook to cart
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[1]/div/div/div[2]/form/div[3]/button")).click();
        Thread.sleep(5000);
        //12. Go to cart
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]/span[1]")).click();
        //13. click on payment button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/footer/section[2]/div/div[2]/div[1]/div[1]/div[2]/a/h4")).click();
        //14. click on card payment method
        driver.findElement(By.xpath("//*[@id=\"payment\"]/li[5]/a")).click();
        //15. click on continue
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/form/div[8]/div[1]/button")).click();
        //16. click on pay now
        driver.findElement(By.xpath("driver.findElement(By.xpath(\"//*[@id=\\\"payment\\\"]/li[5]/a\")).click();")).click();
        //17. Input invalid card details
        driver.findElement(By.xpath(  "driver.findElement(By.xpath(\"//*[@id=\\\"payment\\\"]/li[5]/a\")).click();")).click();
        //18. click on pay now
        driver.findElement(By.xpath("//*[@id=\"validateCardForm\"]")).click();
        Thread.sleep(5000);

    }
    @AfterTest
    public void closeBrowser()  {
        driver.quit();
    }
    
}
