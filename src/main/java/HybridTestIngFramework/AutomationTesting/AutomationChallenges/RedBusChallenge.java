package HybridTestIngFramework.AutomationTesting.AutomationChallenges;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RedBusChallenge {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
        driver = new ChromeDriver(option);
        driver.get("https://www.redbus.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("div.labelCalendarContainer")).click();
        WebElement CalendarUI = driver.findElement(By.cssSelector("div[class*='DatePicker__CalendarContainer']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style','background: blue; border: 4px solid gray;');", CalendarUI);
        System.out.println(getWeekEndDates("Dec 2024"));
        driver.close();
    }

    public static List<String> getWeekEndDates(String expectedMonth) {
        String month;
        String reqMonth = "";
        do {
            month = driver.findElement(By.cssSelector("div[class*='DayNavigator__IconBlock']:nth-child(2)")).getText();
            reqMonth = reqMonth + "\n" + month;
            driver.findElement(By.cssSelector("div[class*='DayNavigator__IconBlock']:nth-child(3)")).click();
        }
        while (!month.contains(expectedMonth));
        driver.findElement(By.cssSelector("div[class*='DayNavigator__IconBlock']:nth-child(1)")).click();

        ArrayList<String> weekendDate = new ArrayList<>();

        try {
            System.out.println(reqMonth);

            List<WebElement> sat = driver.findElements(By.cssSelector("span[class*='bwoYtA']"));

            for (WebElement satweek : sat) {
                if (!satweek.getText().isEmpty()) {
                    weekendDate.add(satweek.getText());
                }
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return weekendDate;
    }
}
