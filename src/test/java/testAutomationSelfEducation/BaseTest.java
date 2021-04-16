package testAutomationSelfEducation;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import aquality.selenium.elements.interfaces.IElementFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import testAutomationSelfEducation.util.FluentApi;
import testAutomationSelfEducation.util.PathsProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected final IElementFactory elementFactory;
    protected final FluentApi fluentApi = new FluentApi();
    protected BaseTest() {
        elementFactory = AqualityServices.getElementFactory();
    }
    protected Browser getBrowser() {
        return AqualityServices.getBrowser();
    }

    private final Properties properties = PathsProperties.readFile();
    private final String default_url = properties.getProperty("default_url.path");

    @BeforeMethod
    protected void beforeMethod() {
        AqualityServices.getBrowser().goTo(default_url);
        getBrowser().maximize();
        AqualityServices.getBrowser().getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterTest() {
        if (AqualityServices.isBrowserStarted()) {
            AqualityServices.getBrowser().quit();
        }
    }
}
