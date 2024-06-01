package learning;

import org.testng.annotations.Test;
import wrappers.GenericWrappers;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class LearnPickerWheel extends GenericWrappers {
    @Test
    public void runScript() throws URISyntaxException, MalformedURLException, InterruptedException {
        launchIosApp("", "1A69E837-798C-40B3-9229-BA47180D13F2", "", "com.example.apple-samplecode.UICatalog", "");
        click(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Picker View"));
        swipeWithinWebElement("up", getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Red color component value"));
        enterValue(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Red color component value"), "100", false);
        String a = getText(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Red color component value"));
        System.out.println(a);
        while (Integer.parseInt(a) != 120) {
            String b = getText(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Red color component value"));
            if (Integer.parseInt(b) > 120)
                choosePreviousOptionInPickerWheel(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Red color component " +
                        "value"));
            else if (Integer.parseInt(b) < 120)
                chooseNextOptionInPickerWheel(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Red color " +
                        "component " +
                        "value"));
            else
                break;
        }
        chooseNextOptionInPickerWheel(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Blue color component " +
                "value"));
        choosePreviousOptionInPickerWheel(getWebElement(Locators.ACCESSIBILITY_ID.asString(), "Green color component " +
                "value"));
        sleep(4000);
        closeApp();


    }
}