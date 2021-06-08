import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

public class CreateProject {

    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static final String STUDENT_LOGIN = "user";
    private static final String STUDENT_PASSWORD = "1234";
    private static  WebDriver driver;



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

        driver.findElement(By.xpath("/html/body/div[2]/div/header/div[2]/ul/li[3]/a/span")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/header/div[2]/ul/li[3]/ul/li[4]/a/span")).click();
        sleep(5000);

        // Создать проект

        driver.findElement(By.xpath("//a[@title='Создать проект']")).click();


        // Заполнение полей

        //Наименование

        sleep(5000);
        driver.findElement(By.name("crm_project[name]")).sendKeys("ftdexese");

        // Организация
        driver.findElement(By.xpath("//span[contains(text(),'Укажите организацию')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(text(),'Все организации')]")).click();

        //Подразделение
        driver.findElement(By.xpath(".//div/div/div[2]/input")).sendKeys(new CharSequence[]{"Test"});
        Select expenditureDropDown = new Select(driver.findElement(By.xpath(".//div[5]/div[2]/div/select")));
        expenditureDropDown.selectByVisibleText("Research & Development");
        Assert.assertNotNull(expenditureDropDown);

        //Куратор проекта
        Select curator = new Select(driver.findElement(By.name("crm_project[curator]")));
        curator.selectByVisibleText("Applanatest1 Applanatest1 Applanatest1");

        //Руководитель
        Select expenditureDropDown1 = new Select(driver.findElement(By.xpath(".//div[7]/div[2]/div/select")));
        expenditureDropDown1.selectByVisibleText("Applanatest1 Applanatest1 Applanatest1");
        Assert.assertNotNull(expenditureDropDown1);

        //Администратор
        Select administrator = new Select(driver.findElement(By.name("crm_project[administrator]")));
        administrator.selectByVisibleText("Applanatest1 Applanatest1 Applanatest1");

        //Менеджер
        Select expenditureDropDown2 = new Select(driver.findElement(By.xpath(".//div[9]/div[2]/div/select")));
        expenditureDropDown2.selectByVisibleText("Applanatest1 Applanatest1 Applanatest1");
        Assert.assertNotNull(expenditureDropDown2);


        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();

    }


}