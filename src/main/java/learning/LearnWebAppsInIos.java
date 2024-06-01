package learning;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;
import wrappers.GenericWrappers;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Collections;

public class LearnWebAppsInIos extends GenericWrappers {
    @Test
    public void runScript() throws URISyntaxException, MalformedURLException, InterruptedException {
        launchSafariBrowser("", "https://www.google.com", "1A69E837-798C-40B3-9229-BA47180D13F2");
//    deleteSafariCookies();
        enterValue(getWebElement(Locators.NAME.asString(), "q"), "Lokesh Kumar", false);
        WebElement ele = getWebElement(Locators.NAME.asString(), "q");
        int x = (int) (ele.getRect().getX() + (ele.getRect().getWidth() * 0.5));
        int y = (int) (ele.getRect().getY() + (ele.getRect().getHeight() * 0.5) + 60);
        System.out.println(x);
        System.out.println(y);
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new Pause(finger, Duration.ofMillis(100)));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(tap));
//        click(getWebElement(Locators.NAME.asString(), "q"));

        switchNativeView();
        click(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Search"));
        switchWebView();
        click(getWebElement(Locators.XPATH.asString(), "(//span[@class='d3o3Ad'])[2]"));
        sleep(5000);
        closeApp();
    }
}