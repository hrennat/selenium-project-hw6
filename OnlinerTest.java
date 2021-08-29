import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class OnlinerTest {

    @Test
    public  void testRates() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.onliner.by");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='container']/div/div/header/div[2]/div/nav/ul[2]/li[1]/a/span")));
        element.click();
        WebElement element1 = driver.findElement(By.xpath("//*[@id='container']/div/div[2]/div/div/div/div[2]/div[1]/h1"));
        wait.until(ExpectedConditions.visibilityOf(element1));
        String getH1 = element1.getText();
        driver.quit();
        assertEquals("Лучшие курсы валют", getH1);
    }

    @Test
    public  void testCart() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.onliner.by");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='userbar']/div[3]/div/a")));
        element.click();
        WebElement element1 = driver.findElement(By.xpath("//*[@id='container']/div[2]/div/div/div/div/div[2]/div/div[1]"));
        wait.until(ExpectedConditions.visibilityOf(element1));
        String getH1 = element1.getText();
        driver.quit();
        assertEquals("Корзина", getH1);
    }

    @Test
    public void testSearch() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.onliner.by");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = driver.findElement(By.xpath("//*[@id='fast-search']/form/input[1]"));
        String s=driver.findElement(By.xpath("//*[@id='fast-search']/form/input[1][@placeholder]")).getAttribute("placeholder");
        assertTrue(s.contains("Поиск в Каталоге. Например,"));
        driver.quit();
    }

    @Test
    public  void testSamsungUnselected() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.onliner.by");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()= 'Телевизоры']")));
        element.click();
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='schema-filter']/div[3]/div[5]/div[2]/ul/li[2]/label/span[2]")));
        checkbox.click();
        WebElement checkboxInput = driver.findElement(By.xpath("//*[@id='schema-filter']/div[3]/div[5]/div[2]/ul/li[2]/label/span[1]/input"));
        boolean result = checkboxInput.isSelected();
        assertFalse(result);


        driver.quit();
    }

    @Test
    public void testSelectedAnotherTV() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.onliner.by");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()= 'Телевизоры']")));
        element.click();
        WebElement checkboxSmg = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='schema-filter']/div[3]/div[5]/div[2]/ul/li[2]/label/span[2]")));
        checkboxSmg.click();
        WebElement checkboxPhilips = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='schema-filter__list']//span[text()='Philips']")));
        checkboxPhilips.click();
        WebElement b = wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Philips")));
        List<WebElement> a = driver.findElements(By.xpath("//span[@data-bind='html: product.extended_name || product.full_name']"));
        List<String> tvPhilips =  new ArrayList<>();
        for (WebElement span : a)
        {
            String text = span.getText();
            tvPhilips.add(text);
        }
        for (int i = 0; i < tvPhilips.size(); i++) {

            // System.out.println(tvPhilips.get(i));
            assertTrue(tvPhilips.get(i).contains("Philips"));

        }
        driver.quit();
    }
}
