import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class Test {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.avito.ru/");
//        driver.findElement(By.cssSelector(".category-select-root-2U90T")).click();
//        driver.findElement(By.xpath("//*[@id=\"category\"]/option[39]")).click();
//        driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys("Принтер");
//        driver.findElement(By.cssSelector(".main-text-2PaZG")).click();
//        driver.findElement(By.xpath
//                ("/html/body/div[1]/div[2]/div/div[2]/div/div[6]/div/div/span/div/div[1]/div[2]/div/input"))
//                .sendKeys("Владивосток");
//        driver.findElement(By.xpath
//                ("/html/body/div[1]/div[2]/div/div[2]/div/div[6]/div/div/span/div/div[1]/div[2]/div/ul/li[1]")).click();
//        driver.findElement(By.xpath
//                ("/html/body/div[1]/div[2]/div/div[2]/div/div[6]/div/div/span/div/div[3]/div[2]/div/button")).click();
        Select categories = new Select(driver.findElement(By.xpath("//select[@name='category_id']")));
        categories.selectByValue("99");
        driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys("Принтер");
        driver.findElement(By.cssSelector(".main-text-2PaZG")).click();
        driver.findElement(By.xpath
                ("/html/body/div[1]/div[2]/div/div[2]/div/div[6]/div/div/span/div/div[1]/div[2]/div/input"))
                .sendKeys("Владивосток");
        WebDriverWait waiter = new WebDriverWait(driver, 10);
        synchronized (waiter) {
            waiter.wait(3000);
        }
        driver.findElement(By.xpath
                ("/html/body/div[1]/div[2]/div/div[2]/div/div[6]/div/div/span/div/div[1]/div[2]/div/ul/li[1]"))
                .click();
        driver.findElement(By.xpath
                ("/html/body/div[1]/div[2]/div/div[2]/div/div[6]/div/div/span/div/div[3]/div[2]/div/button"))
                .click();
        WebElement withEx = driver.findElement(
                By.xpath("/html/body/div[1]/div[3]/div[3]/div[1]/div/div[2]/div[1]/form/div[6]/div/div/div/div/div/div/label"));


        if (!withEx.isSelected()) {
            driver.findElement(By.xpath("//input[@type='checkbox'][@data-marker='delivery-filter/input']")).click();
        }

        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[3]/div[1]/div/div[2]/div[2]/div/button[1]")).click();
        Select sortBy = new Select(driver.findElement(
                By.xpath("/html/body/div[1]/div[3]/div[3]/div[3]/div[1]/div[2]/select")));
        sortBy.selectByValue("2");

    }
}
