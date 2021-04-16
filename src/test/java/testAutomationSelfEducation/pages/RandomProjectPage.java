package testAutomationSelfEducation.pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomProjectPage extends Form {

    public RandomProjectPage(By locator, String name) {
        super(locator, name);
    }

    public List<WebElement> getListProjectNames() {
        return AqualityServices.getBrowser().getDriver().
                findElements(By.xpath("//table[@class='table']/tbody/tr/td[6]"));
    }

    public String getTimeText(List<WebElement> webElementList) {
        ArrayList str = new ArrayList();
        for (WebElement element : webElementList) {
            str.add(element.getText());
        }
        Collections.sort(str);
        Collections.reverse(str);
        System.out.println(str.get(0));
        String time = str.get(0).toString();
        return time;
    }

    public void clickBigTimeTest(String time) {
        AqualityServices.getBrowser().getDriver().findElement(By.xpath("//table[@class='table']/tbody/tr/td[6][contains(text(),'" + time + "')]/../td[1]")).click();
    }
}
