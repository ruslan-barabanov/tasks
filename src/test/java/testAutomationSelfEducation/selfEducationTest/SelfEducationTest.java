package testAutomationSelfEducation.selfEducationTest;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import testAutomationSelfEducation.BaseTest;
import testAutomationSelfEducation.pages.*;
import testAutomationSelfEducation.util.WorkWithCookie;

import java.io.IOException;

public class SelfEducationTest extends BaseTest {
    protected SelfEducationTest() {
    }

    public ProjectsPage projectsPage = new ProjectsPage(By.xpath(""), "button add");
    public RandomProjectPage randomProjectPage = new RandomProjectPage(By.xpath(""), "Random page");
    public TestInfoPage testInfoPage = new TestInfoPage(By.xpath(""), "Time info");
    public WorkWithCookie workWithCookie = new WorkWithCookie();

    @Test()
    public void mainSelfAducationTest() {
        try {
            String token = fluentApi.sendPostGetToken();
            Assert.assertNotNull(token, "token was not generated");
            Cookie actualTokenCookie = workWithCookie.newCookie("token", token);
            getBrowser().getDriver().manage().addCookie(actualTokenCookie);
            getBrowser().getDriver().navigate().refresh();
            Cookie expectedTokenCookie = getBrowser().getDriver().manage().getCookieNamed("token");
            Assert.assertEquals(actualTokenCookie, expectedTokenCookie, "cookies are not as expected");
        } catch (IOException e) {
            System.out.println("token was not generated");
        }
        String expectedText = "Version: 4";
        String actualText = projectsPage.getVersionName().getText();
        Assert.assertEquals(expectedText, actualText, "version does not match");
        projectsPage.clickRandomProjectNames();
        String mostLongTime = randomProjectPage.getTimeText();
        randomProjectPage.clickBigTimeTest(mostLongTime);
        String str = testInfoPage.getInfoTimeTest(mostLongTime).getText();
        String actual = str.replace("Duration (H:m:s.S): ", "");
        System.out.println(actual);
        Assert.assertEquals(mostLongTime, actual, "time does not correspond to the greatest");
    }
}
