import org.openqa.selenium.By;

import java.util.Map;

public class Logout extends CommonUtility{
By logoutbtn=By.xpath("//*[@id=\"sidebar\"]/ul/li[9]/a");
By assertion=By.xpath("/html/body/div/div/div/div[2]/h2");
    public String checkLogout(Map<String,String> data)
    {
        this.Login(data);
        this.clickOnBtn(logoutbtn);
        return this.getText(assertion);
    }
}
