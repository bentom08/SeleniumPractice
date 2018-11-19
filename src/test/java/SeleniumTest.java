import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumTest {

	WebDriver driver;
	private static final String google = "http://www.google.com";
	private static final String demo = "http://thedemosite.co.uk/addauser.php";
	private static final String login = "http://thedemosite.co.uk/login.php";
	private static final String shopping = "http://automationpractice.com/index.php";
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Downloads/chromedriver_win32/chromedriver.exe");
		
		driver = (WebDriver) new ChromeDriver();
	}
	
	@After
	public void voidtearDown() {
		driver.quit();
	}
	
	@Test
	@Ignore
	public void test() throws InterruptedException {
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.get(google);
	}
	
	@Test
	@Ignore
	public void test2() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get(google);
		
		WebElement checkElement = driver.findElement(By.name("q"));
		WebElement searchElement = driver.findElement(By.name("btnK"));
		
		checkElement.click();
		checkElement.sendKeys("Hello World");
		Thread.sleep(200);
		searchElement.click();
	}
	
	@Test
	@Ignore
	public void demoSite() {
		driver.manage().window().maximize();
		driver.get(demo);
		
		WebElement usernameElement = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input"));
		WebElement passwordElement = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input"));
		WebElement saveElement = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input"));
			
		String username = "Ben2";
		String password = "password";
		
		usernameElement.sendKeys(username);
		passwordElement.sendKeys(password);
		saveElement.click();
		
		driver.get(login);
		
		WebElement loginusernameElement = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input"));
		WebElement loginpasswordElement = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input"));
		WebElement testLoginElement = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input"));
		
		
		loginusernameElement.sendKeys(username);
		loginpasswordElement.sendKeys(password);
		testLoginElement.click();
		
		WebElement returnElement = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
		assertEquals("**Successful Login**", returnElement.getText());
		
	}
	
	@Test
	@Ignore
	public void testShoppingSite() {
		driver.manage().window().maximize();
		driver.get(shopping);
		
		ShoppingHomePage homePage = PageFactory.initElements(driver, ShoppingHomePage.class);
		homePage.searchFor("T-Shirt");
		
		List<String> results = new ArrayList<>();
		
		ResultsPage resultsPage = PageFactory.initElements(driver, ResultsPage.class);
		int numberOfResults = resultsPage.getNumberOfResults();
		
		for(int i = 1; i <= numberOfResults; i++) {
			results.add(driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li["+i+"]/div/div[2]/h5/a")).getText());
		}
		
		assertEquals(true, results.contains("Faded Short Sleeve T-shirts"));
	}
	
	@Test
	public void testQASite() {
		
	}
}
