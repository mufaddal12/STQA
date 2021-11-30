import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginTest extends LoginPage{

    @DataProvider(name="login")
    public Object[][] register(){
        GetData obj=new GetData("Login");
        return obj.getdata();

    }


    @Test(dataProvider = "login")
    public void check_registration(Map<String,String> data) {
        try {
            this.driver.get("http://localhost:8000/login/");


            System.out.println(data);
            String a = checkLogin(data);
            if (data.get("loginStatus").equals("true")) {
                Assert.assertTrue(a.contains("WALLSTREET"), "Ouput expected" + "Wallstreet homepage" + "but actual" + a);
            } else {
                Assert.assertTrue(a.contains("Invalid Username or Password!"), "Ouput expected" + "Invalid Login" + "but actual" + a);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
