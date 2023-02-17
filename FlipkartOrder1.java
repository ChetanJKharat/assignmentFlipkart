package assignment;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartOrder1{
   public static void main(String[] args){
       

     // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        // open  the Flipkart website
        driver.get("https://www.flipkart.com");
        
        // Maximize window
        driver.manage().window().maximize();
 
        // Wait for the search box to be visible
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));

        // Type "ipad" into the search box
        searchBox.sendKeys("ipad");


     // Wait for the search suggestions to be displayed
     WebElement suggestion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_3OO5Xc']")));

        // Now Click on the first search suggestion
        suggestion.click();

        // Wait for the "Online Only" filter to be visible and click on it
        WebElement onlineOnlyFilter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Online Only']")));
        onlineOnlyFilter.click();

        // Wait for the results to be displayed and click on the first one
        WebElement firstResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_2kHMtA']//div[1]//a")));
        firstResult.click();

        // Wait for the "Buy Now" button to be visible and click on it
        WebElement buyNowButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='BUY NOW']")));
        buyNowButton.click();

        // Enter a random email and phone number in the checkout page
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
        emailField.sendKeys("example@gmail.com");

        WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='tel']")));
        phoneField.sendKeys("1234567890");

        // Place the order
        WebElement placeOrderButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='PLACE ORDER']")));
        placeOrderButton.click();

        // Close the browser
        driver.quit();
    }
}
