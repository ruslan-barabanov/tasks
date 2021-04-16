package testAutomationSelfEducation.selfEducationTest;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import testAutomationSelfEducation.BaseTest;
import testAutomationSelfEducation.pages.*;
import java.io.IOException;
import java.util.*;

public class SelfEducationTest extends BaseTest {
    protected SelfEducationTest() {
    }
    ProjectsPage projectsPage = new ProjectsPage(By.xpath(""), "button add");
    RandomProjectPage randomProjectPage = new RandomProjectPage(By.xpath(""), "Random page");
    TestInfoPage testInfoPage = new TestInfoPage(By.xpath(""), "Time info");

    @Test()
    public void mainSelfAducationTest() throws IOException {
        String token = fluentApi.sendPostGetToken();
        System.out.println(token);
        Cookie actualTokenCookie = new Cookie("tokenCookie", token);
        getBrowser().getDriver().manage().addCookie(actualTokenCookie);
        Cookie expectedTokenCookie = getBrowser().getDriver().manage().getCookieNamed("tokenCookie");
        Assert.assertEquals(actualTokenCookie, expectedTokenCookie);
        getBrowser().getDriver().navigate().refresh();
        String actualText = projectsPage.getVersionName().getText();
        System.out.println(actualText);
        List<WebElement> webElementList = projectsPage.getListProjectNames();
        projectsPage.getRandomProjectNames(webElementList);
        List<WebElement> webElementTime = randomProjectPage.getListProjectNames();
        String mostLongTime = randomProjectPage.getTimeText(webElementTime);
        randomProjectPage.clickBigTimeTest(mostLongTime);
        String str = testInfoPage.getInfoTimeTest(mostLongTime).getText();
        String actual = str.replace("Duration (H:m:s.S): ","");
        System.out.println(actual);
        Assert.assertEquals(mostLongTime,actual);
    }
}
