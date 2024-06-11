package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class WomenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyTheSortByProductNameFilter(){
        /**
         *  Mouse Hover on Women Menu
         *  * Mouse Hover on Tops
         */
        mouseHoverToElement(By.xpath("//span[normalize-space()='Women']"));
        mouseHoverToElement(By.xpath("(//a[@id='ui-id-9'])[1]"));
        clickOnElement(By.cssSelector("#ui-id-11"));
        selectByVisibleTextFromDropDown(By.xpath("//div[@class='page-wrapper']//div[2]//div[3]//select[1]"),"Product Name ");

        //Verify the products name display in alphabetical order

        List<WebElement> allList=driver.findElements(By.xpath("//strong[@class = 'product name product-item-name']"));
        for (WebElement element : allList) {
            System.out.println(element.getText());
        }
    }
    @Test
    public void verifyTheSortByPriceFilter(){
        mouseHoverToElement(By.xpath("//span[normalize-space()='Women']"));
        mouseHoverToElement(By.xpath("(//a[@id='ui-id-9'])[1]"));
        clickOnElement(By.cssSelector("#ui-id-11"));
        selectByVisibleTextFromDropDown(By.xpath("//div[@class='page-wrapper']//div[2]//div[3]//select[1]"),"Price");
        List<WebElement> allList=driver.findElements(By.xpath("//span//span[@class = 'price']"));
        for (WebElement element : allList) {
            System.out.println(element.getText());
        }
    }
    @After
    public  void tearDown(){
        closeBrowser();
    }
}
