import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public class Test {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.avito.ru/");
        Select categories = new Select(driver.findElement(By.xpath("//select[@name='category_id']")));
        categories.selectByValue("99");
        driver.findElement(By.xpath("//*[@id='search']")).sendKeys("Принтер");
        driver.findElement(By.xpath("//*[@data-marker='search-form/region']")).click();
        driver.findElement(By.xpath("//*[@data-marker='popup-location/region/input']"))
                .sendKeys("Владивосток");
        WebDriverWait waiter = new WebDriverWait(driver, 3000);
        synchronized (waiter) {
            waiter.wait(1500);
        }
        driver.findElement(By.xpath("//*[@data-marker='suggest(0)']")).click();
        driver.findElement(By.xpath("//*[@data-marker='popup-location/save-button']")).click();

        findAndClick(driver, "//*[@data-marker ='delivery-filter']");
        findAndClick(driver, "//*[@data-marker ='search-filters/submit-button']");
        driver.findElement(By.xpath
                ("/html/body/div[1]/div[3]/div[3]/div[3]/div[1]/div[2]/select/option[3]")).click();

        List<WebElement> elements = driver.findElements(By.xpath("//div[@data-marker='item']"));
        List<Item> items = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            String input = (elements.get(i)
                    .findElement(By.xpath(".//*[@data-marker='item-title']")))
                    .getAttribute("title");
            String name = input.replace(" в Владивостоке","");
            int price = Integer.parseInt(elements.get(i)
                    .findElement(By.xpath(".//*[@itemprop='price']"))
                    .getAttribute("content"));
            Item item = new Item(name, price);
            items.add(item);
        }
        items.forEach(System.out::println);
    }

    public static void findAndClick(WebDriver driver, String xPath) {
        WebElement deliveryButton = driver.findElement(By.xpath(xPath));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", deliveryButton);
        deliveryButton.click();
    }
}
