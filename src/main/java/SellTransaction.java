import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SellTransaction extends CommonUtility{
        By sellButton=By.xpath("//*[@id=\"sidebar\"]/ul/li[5]/a");
        By companyDropdown=By.xpath("//*[@id=\"share\"]");
        By quantity=By.xpath("//*[@id=\"quantity\"]");
        By bidPrice=By.xpath("//*[@id=\"bidPrice\"]");
        By Loginbtn= By.xpath("//*[contains(text(),'Log in')]");
        By inputusertxt=By.xpath("//*[@id=\"loginForm\"]/div[1]/input");
        By password=By.xpath("//*[@id=\"loginForm\"]/div[2]/input");
        By submitButton=By.xpath("//*[@id=\"submitForm\"]");
        By assertiontxt=By.xpath("/html/body/div[2]/div[2]/div/section/div/div/div/div[2]/p[2]");


        public void SellStock(Map<String,String > data)
        {
            this.sendText(inputusertxt,data.get("username"));
            this.sendText(password,data.get("password"));
            this.clickOnBtn(Loginbtn);
            this.clickOnBtn(sellButton);
            List<WebElement> options= this.getList(companyDropdown);
            String bidprice="";
            List<String> bidpriceList;
            for(WebElement item:options)
            {

                System.out.println("Companies to sell "+ item.getText());
                if(item.getText().contains(data.get("company")))
                {
                    this.selectOption(companyDropdown,item.getText());
                    bidprice= Arrays.asList(item.getText().split("\\.")).get(1);
                    bidprice=Arrays.asList(bidprice.split("-")).get(0);
                    System.out.println(bidprice);
                }

            }
            this.sendText(quantity,data.get("quantity"));
            this.sendText(bidPrice,bidprice);
            this.clickOnBtn(submitButton);

        }
    }


