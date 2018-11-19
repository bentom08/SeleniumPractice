import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingHomePage {
	
	@FindBy(xpath = "//*[@id=\"search_query_top\"]")
	private WebElement searchBar;
	
	@FindBy(xpath = "//*[@id=\"searchbox\"]/button")
	private WebElement searchButton;

	public void searchFor(String text) {
		searchBar.sendKeys(text);
		searchButton.click();
	}
}
