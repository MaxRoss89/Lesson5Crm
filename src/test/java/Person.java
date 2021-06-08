import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static java.lang.Thread.sleep;

public class Person {

    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static final String STUDENT_LOGIN = "user";
    private static final String STUDENT_PASSWORD = "1234";
    private static  WebDriver driver;
    private static Object CharSequence;

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);


        driver.get(LOGIN_PAGE_URL);

        WebElement loginTextInput = driver.findElement(By.xpath("//*[@id='prependedInput']"));
        loginTextInput.sendKeys(STUDENT_LOGIN);
        sleep(2000);

        WebElement passwordTextInput = driver.findElement(By.xpath("//*[@id='prependedInput2']"));
        passwordTextInput.sendKeys(STUDENT_PASSWORD);
        sleep(2000);

        WebElement loginButton = driver.findElement(By.xpath("//*[@id='_submit']"));
        loginButton.click();

        Actions actions = new Actions(driver);
        WebElement contragents = driver.findElement(By.xpath("//div[@id='main-menu']//*[text()='Контрагенты']"));
        actions.moveToElement(contragents).perform();

        driver.findElement(By.xpath("//div[@id='main-menu']//*[text()='Контактные лица']")).click();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[text()='Создать контактное лицо']")).click();

        Thread.sleep(2000);
        driver.findElement(By.name("crm_contact[lastName]")).sendKeys("Иванов");
        assert CharSequence != null;
        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("Иван");
        assert CharSequence != null;

        driver.findElement(By.xpath("//span[contains(text(),'Укажите организацию')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(text(),'Все организации')]")).click();

        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("Менеджер");
        assert CharSequence != null;

        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();




    }
}