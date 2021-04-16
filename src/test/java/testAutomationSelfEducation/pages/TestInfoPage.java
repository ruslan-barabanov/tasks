package testAutomationSelfEducation.pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestInfoPage extends Form {

    public TestInfoPage(By locator, String name) {
        super(locator, name);
    }

    public WebElement getInfoTimeTest(String time) {
        return AqualityServices.getBrowser().getDriver().findElement(By.xpath("//div/p[3][contains(text(),'" + time + "')]"));
    }
}
