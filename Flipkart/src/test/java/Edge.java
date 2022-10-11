import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Edge {
  @Test
  public void f() throws InterruptedException {
	  System.setProperty("webdriver.edge.driver", "C:\\Users\\hp\\OneDrive\\Desktop\\edgedriver_win64/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Long loadtime = (Long) ((JavascriptExecutor) driver).executeScript("return performance.timing.loadEventEnd - performance.timing.navigationStart;");
		System.out.println("Load time is: " + loadtime);
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("._2hriZF ._2doB4z")).click();
		driver.findElement(By.name("q")).sendKeys("iPhone 13");
		
		Thread.sleep(3000);
		driver.findElement(By.className("L0Z3Pu")).click();
		Thread.sleep(3000);
		
		WebElement ImageFile = driver.findElement(By.xpath("//img[contains(@class,'_396cs4 _3exPp9')]"));
    
    Boolean ImagePresent = (Boolean)(js.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile));
    if (!ImagePresent){
         System.out.println("Image not displayed");
    }
    else{
        System.out.println("Image displayed");
    }
	  
	  	js.executeScript("return window.scrollBy(0,1000)");  
	  	System.out.println("Scroll available");
	  	Thread.sleep(3000);
	  	
	  	js.executeScript("window.scroll(0,document.body.scrollHeight)");
	  	System.out.println("Scroll to bottom available");
	  	Thread.sleep(3000);
	  	
  }
}
