package testAutomationSelfEducation.pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomProjectPage extends Form {

    private final String listTime = "//table[@class='table']/tbody/tr/td[6]";
    private final String bigTimeNameTest = "//table[@class='table']/tbody/tr/td[6][contains(text(),'%s')]/../td[1]/a";

    public RandomProjectPage(By locator, String name) {
        super(locator, name);
    }

    private List<WebElement> getListProjectNames() {
        return AqualityServices.getBrowser().getDriver().findElements(By.xpath(listTime));
    }

    public String getTimeText() {
        List<WebElement> webElementList = getListProjectNames();
        ArrayList str = new ArrayList();
        for (WebElement element : webElementList) {
            str.add(element.getText());
        }
        Collections.sort(str);
        Collections.reverse(str);
        String time = str.get(0).toString();
        return time;
    }

    public void clickBigTimeTest(String time) {
        String fullLocator = String.format(bigTimeNameTest, time);
        AqualityServices.getBrowser().getDriver().findElement(By.xpath(fullLocator)).click();
    }
}
