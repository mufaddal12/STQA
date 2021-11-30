import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class BuyTest extends BuyTransaction{


    @DataProvider(name="buystock")
    public Object[][] register(){
        GetData obj=new GetData("buystock");
        return obj.getdata();

    }

    @Test(dataProvider = "buystock")
    public void check_registration(Map<String,String> data) {
        try {
            this.driver.get("http://localhost:8000/login/");
            this.BuyStock(data);
            WebDriverWait wait = new WebDriverWait(driver,30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div/section[1]/div/div[2]/div/div[1]/h2")));
            Assert.assertTrue(driver.getCurrentUrl().equals("http://localhost:8000/"),"Not directed to homepage ,buy order not executed");
            this.driver.findElement(By.xpath("//*[@id=\"sidebar\"]/ul/li[9]/a/span")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginForm\"]/button")));



        } catch (Exception e) {
            e.printStackTrace();

            Assert.fail();
        }
    }
}
