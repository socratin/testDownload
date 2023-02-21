import com.google.common.collect.Table;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.html.HTMLTableElement;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MainClass {
    static WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.driver", "C:\\Users\\user\\Downloads\\chromedriver_win32 (3)");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Start");
        getSite("https://www.nix.ru/autocatalog/nix_computers/X6000-ULTIMATE-X6343UGi-Core-i7-13700KF-32-Gb-1-Tb-SSD-plus-4-Tb-16-Gb-GeForce-RTX4080-OC_701901.html#goods_garanty");
        WebElement radioButton1 = getElement("//dd[1]//label[1]//input[1]");
        WebElement radioButton2 = getElement("//dd[2]//label[1]//input[1]");

        System.out.println("Radibutton 1 " + radioButton1.isSelected() + "Radiobutton2 " + radioButton2.isSelected());
        radioButton2.click();

        System.out.println("Radibutton 1 " + radioButton1.isSelected() + "Radiobutton2 " + radioButton2.isSelected());
        //WebElement link = driver.findElement(By.xpath("//input[@placeholder='Поиск по товарам']"));
        //Actions action = new Actions(driver);
        //action.moveToElement(link).build().perform();

        System.out.println("The end");
        System.out.println("Start2");
        WebElement link = getElement("//a[contains(text(),'Miditower Thermaltake <CA-1K8-00M1WN-01> V200 TG R')]");
        WebElement link2 = getElement("//ul[@class='moscow-menu']//ul[1]//li[1]//a[1]");
        System.out.println(link.isDisplayed());
        System.out.println(link2.isDisplayed());
        if (link.isDisplayed()) link.click();
        System.out.println("Stop 2");
        System.out.println((driver.findElements(By.xpath("//*[@id=\"button\"]/yt-icon"))).size());

    }

    public static void getSite(String site){
        driver.get(site);
    }
    public static SearchContext findElement(String xPath){
        WebElement tableElement = driver.findElement(By.xpath(xPath));
        return tableElement;
    }
    public static WebElement getElement(String xpath){
       return driver.findElement(By.xpath(xpath));
    }
}