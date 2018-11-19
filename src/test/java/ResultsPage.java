import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultsPage {
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/h1/span[2]")
	private WebElement results;
	
	public int getNumberOfResults() {
		return Integer.parseInt(results.getText().substring(0,1));
	}
}
