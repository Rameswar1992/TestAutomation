package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;

public class Utilities {
    public static void highlight(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: gray; border: 2px solid red;');", element);
    }

    public static void switchWindow(WebDriver driver) {
        String parentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        Iterator<String> iterator = allWindows.iterator();
        while (iterator.hasNext()) {
            String child_window = iterator.next();
            if (!parentWindow.equals(child_window)) {
                driver.switchTo().window(child_window);
            }
        }
    }
}