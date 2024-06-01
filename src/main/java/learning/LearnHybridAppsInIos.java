package learning;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class LearnHybridAppsInIos extends GenericWrappers {
    @Test
    public void runScript() throws URISyntaxException, MalformedURLException, InterruptedException {
        launchIosApp("", "1A69E837-798C-40B3-9229-BA47180D13F2", "", "com.example.apple-samplecode.UICatalog", "");
        //swipe("up");
        swipeUpInAppUntilElementIsVisible(Locators.ACCESSIBILITY_ID.asString(), "Web View");
        click(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Web View"));
        printContext();
        switchWebView();
//        click(getWebElement(Locators.ID.asString(), "globalnav-menutrigger-button"));
        click(getWebElement(Locators.XPATH.asString(), "//a[text()='Learn more' and @data-analytics-title=\"learn more - iphone 15 pro\"]"));
        sleep(5000);
        click(getWebElement(Locators.LINK_TEXT.asString(), "Buy"));
        sleep(5000);
        closeApp();
    }
}