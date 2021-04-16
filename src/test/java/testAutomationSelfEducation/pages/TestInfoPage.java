package testAutomationSelfEducation.pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestInfoPage extends Form {

    private final String listNames = "//div/p[3][contains(text(),'%s')]";

    public TestInfoPage(By locator, String name) {
        super(locator, name);
    }

    public WebElement getInfoTimeTest(String time) {
        String fullLocator = String.format(listNames, time);
        return AqualityServices.getBrowser().getDriver().findElement(By.xpath(fullLocator));
    }
}
