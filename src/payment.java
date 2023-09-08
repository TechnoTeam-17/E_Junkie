import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.function.Function;

public class payment extends BaseDriver {
    @Test
    public void test(){
        startp();
        MyFunc.Bekle(1);
        WebElement addtc= driver.findElement(By.xpath("//*[text()='Add to Cart']"));
        addtc.click();
        MyFunc.Bekle(2);

      driver.switchTo().frame(0);
      JavascriptExecutor js=(JavascriptExecutor)driver;
      WebElement read= driver.findElement(By.xpath("//*[@class='Payment-Button CC']"));
      js.executeScript("arguments[0].scrollIntoView(true);", read);
      js.executeScript("arguments[0].click();", read);
        WebElement email1= driver.findElement(By.xpath("//*[@placeholder='Email']"));
        email1.sendKeys("abuzer@gmail.com");

        WebElement email2= driver.findElement(By.xpath("//*[@placeholder='Confirm Email']"));
        email2.sendKeys("abuzer@gmail.com");

        WebElement namecd= driver.findElement(By.xpath("//*[@placeholder='Name On Card']"));
        namecd.sendKeys("abuzer kadayif");

        WebElement addres= driver.findElement(By.xpath("//*[@placeholder='Address Line 1']"));
        addres.sendKeys("bizim sok sizin mh no:79 ");

        WebElement city= driver.findElement(By.xpath("//*[@placeholder='City']"));
        city.sendKeys("Amsterdam");

        WebElement contry= driver.findElement(By.xpath("//*[@value='NL']"));
        contry.click();

        WebElement stat= driver.findElement(By.xpath("//*[@placeholder='State']"));
        stat.sendKeys("GOOD");


        WebElement zip= driver.findElement(By.xpath("//*[@placeholder='ZIP/Postal Code']"));
        zip.sendKeys("1010bb");

        js.executeScript("window.scrollTo(0, 700);");
        MyFunc.Bekle(5);
        WebElement opt= driver.findElement(By.xpath("//*[@class='BuyerNotes']/child::textarea"));
        opt.sendKeys("please send my book clearly !!!");

      WebElement card=driver.findElement(By.xpath("//*[@value='MasterCard']"));
      card.click();
      WebElement cardnum= driver.findElement(By.xpath("//*[@data-cardinal-field='AccountNumber']"));
      cardnum.sendKeys("4242 4242 4242 4242");
      MyFunc.Bekle(1);
      WebElement carddate= driver.findElement(By.xpath("//*[@autocomplete='cc-exp']"));
      carddate.sendKeys("1223");
      WebElement cvv= driver.findElement(By.xpath("//*[@autocomplete='cc-csc']"));
      cvv.sendKeys("000");
      WebElement payd= driver.findElement(By.xpath(" //*[@class='Pay-Button']"));
      payd.click();
      MyFunc.Bekle(2);
      WebElement shadowWebParent = driver.findElement(By.name("close-circle"));
      MyFunc.Bekle(2);

      WebElement cong = driver.findElement(By.xpath("//span[contains(text(),'your order is confirmed. Thank you!')]"));
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'your order is confirmed. Thank you!')]")));
      Assert.assertTrue(cong.isDisplayed());

    }
}
