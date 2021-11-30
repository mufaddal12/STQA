import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class Registerpage extends CommonUtility{
    public String checkRegistration(Map<String, String> data) {

        WebElement element = driver.findElement(By.xpath("//input[@name='username']"));
        element.sendKeys(data.get("username"));
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys(data.get("password"));
        WebElement button = driver.findElement(By.xpath("//button"));
        button.click();
        return (driver.findElement(By.xpath("/html/body/div/div/div/div[2]/p")).getText());
    }

}
