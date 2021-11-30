import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class RegisterTest extends Registerpage {

    @DataProvider(name = "register")
    public Object[][] register() {
        GetData obj = new GetData("Register");
        System.out.print(obj);
        return obj.getdata();

    }

    @Test(dataProvider = "register")
    public void check_registration(Map<String, String> data) {
        this.driver.get("http://localhost:8000/register/");
        System.out.println(data);
        String a = checkRegistration(data);
        if (data.get("password").equals("abcde")) {
            Assert.assertTrue(a.contains("Registered"), "Ouput expected" + "User registration" + "but actual" + a);
        } else {
            Assert.assertTrue(a.contains("Invalid"), "Ouput expected" + "Invalid registration" + "but actual" + a);

        }

    }
}
