import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class junkie_debit extends BaseDriver {
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
        MyFunc.Bekle(1);
        WebElement shadowWebParent = driver.findElement(By.name("close-circle"));
        MyFunc.Bekle(1);
        SearchContext shadowC = shadowWebParent.getShadowRoot();
        WebElement inval = shadowC.findElement(By.xpath("//span[text()='Invalid Email']"));
        System.out.println("kabulBtn.getText() = " + inval.getText());
        //kabulBtn.click();
    }
}
