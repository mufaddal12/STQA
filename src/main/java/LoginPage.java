import org.openqa.selenium.By;

import java.util.Map;

public class LoginPage extends CommonUtility {
    By Loginbtn = By.xpath("//*[contains(text(),'Log in')]");
    By inputusertxt = By.xpath("//*[@id=\"loginForm\"]/div[1]/input");
    By password = By.xpath("//*[@id=\"loginForm\"]/div[2]/input");
    By homepageassertiontxt = By.xpath("/html/body/header/nav/a[2]");
    By invalidassertiontxt = By.xpath("/html/body/div/div/div/div[2]/p");
    By logoutbtn = By.xpath("//*[@id=\"sidebar\"]/ul/li[9]/a");

    public String checkLogin(Map<String, String> data) {
        this.sendText(inputusertxt, data.get("username"));
        this.sendText(password, data.get("password"));
        this.clickOnBtn(Loginbtn);
        if (data.get("loginStatus").equals("true")) {
            String a = this.getText(homepageassertiontxt);
            this.clickOnBtn(logoutbtn);
            return a;
        } else {
            return this.getText(invalidassertiontxt);
        }

    }

}
