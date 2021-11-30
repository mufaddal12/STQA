import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class LogoutTest extends Logout {

    @DataProvider(name = "logout")
    public Object[][] register() {
        GetData obj = new GetData("logout");
        return obj.getdata();

    }

    @Test(dataProvider = "logout")
    public void check_registration(Map<String, String> data) {
        try {
            this.driver.get("http://localhost:8000/login/");
            String a = this.checkLogout(data);
            Assert.assertTrue(a.contains("Welcome"), "logout failed");
            Assert.assertTrue(driver.getCurrentUrl().equals("http://localhost:8000/login/"), "logout failed");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
