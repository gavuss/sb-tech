package page.res;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractTestPage;

import java.util.function.Function;

public class ResPage extends AbstractTestPage {

    @FindBy(css = "tbody")
    private WebElement checkForm;

    @FindBy(xpath = "(//td[@align])[2]")
    private WebElement message;

    public ResPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ResPage open(Function<WebDriver, Boolean>... conditions) {
        super.open();
        return this;
    }

    public String getResultMessage() {
        return message.getText();
    }

    @Override
    public boolean isLoaded() {
        return super.isLoaded() && checkForm.isDisplayed();
    }
}
