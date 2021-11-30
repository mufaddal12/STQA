import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.util.List;
import java.util.Map;

public class CommonUtility {
    public By Loginbtn= By.xpath("//*[contains(text(),'Log in')]");
    public By inputusertxt=By.xpath("//*[@id=\"loginForm\"]/div[1]/input");
    public By password=By.xpath("//*[@id=\"loginForm\"]/div[2]/input");
    public static WebDriver driver;
    public CommonUtility() {

}

    @BeforeSuite
    public void setup()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    public void sendText(By element,String input)
   {
       driver.findElement(element).sendKeys(input);
   }
   public void clickOnBtn(By element)
   {
       WebDriverWait wait = new WebDriverWait(driver, 10);
       WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(element));
       btn.click();

   }
   public String getText(By element)
   {    WebDriverWait wait = new WebDriverWait(driver,10);
       wait.until(ExpectedConditions.visibilityOfElementLocated(element));

       return driver.findElement(element).getText();
   }
    public List<WebElement> getList(By element)
    {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        WebElement ele=driver.findElement(element);
        Select select = new Select(ele);
        java.util.List<WebElement> options = select.getOptions();
        return options;
    }
    public void selectOption(By element,String text)
    {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        Select ele = new Select(driver.findElement(element));
        ele.selectByVisibleText(text);
    }
    public void Login(Map<String,String> data)
    {
        this.sendText(inputusertxt,data.get("username"));
        this.sendText(password,data.get("password"));
        this.clickOnBtn(Loginbtn);
    }
}
