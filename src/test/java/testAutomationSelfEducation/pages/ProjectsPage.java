package testAutomationSelfEducation.pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ProjectsPage extends Form {

    private final ITextBox versionName = getElementFactory().getTextBox(By.xpath("//p[contains(text(),'Reporting')]/span"), "version Name");
    private final String listNames = "//a[@class='list-group-item']";

    public ProjectsPage(By locator, String name) {
        super(locator, name);
    }

    public IElement getVersionName() {
        return versionName;
    }

    public List<WebElement> getListProjectNames() {
        return AqualityServices.getBrowser().getDriver().findElements(By.xpath(listNames));
    }
    public void getRandomProjectNames(List<WebElement> webElementList) {
        Random ran = new Random();
        int x = ran.nextInt(6);
        int counter = 0;
        for (WebElement element : webElementList) {
            if (counter == x) {
                element.click();
                break;
            }
            counter++;
        }
        System.out.println(webElementList.get(1));
    }
}