package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart(){
        /**
         *  Mouse Hover on Men Menu
         *  * Mouse Hover on Bottoms
         *  * Click on Pants
         */
        mouseHoverToElement(By.xpath("//span[normalize-space()='Men']"));
        mouseHoverToElement(By.xpath("(//span[contains(text(),'Bottoms')])[2]"));
        clickOnElement(By.xpath("(//span[contains(text(),'Pants')])[2]"));
        mouseHoverToElement(By.xpath("(//img[@alt='Cronus Yoga Pant '])[1]"));
        clickOnElement(By.xpath("(//div[@id='option-label-size-143-item-175'])[1]"));
        // * Mouse Hover on product name
        // ‘Cronus Yoga Pant’ and click on colour
        // Black.

        //mouseHoverToElement(By.xpath("(//img[@alt='Cronus Yoga Pant '])[1]"));
        mouseHoverAndClickOnElement(By.xpath("(//div[@id='option-label-color-93-item-49'])[1]"));
        //click on add to cart
        mouseHoverAndClickOnElement(By.xpath("(//span[contains(text(),'Add to Cart')])[1]"));
        verifyElements("Not matched","You added Cronus Yoga Pant to your shopping cart.",By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));

        //click on add to cart
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        verifyElements("Not matched","Shopping Cart",By.xpath("//span[@class='base']"));

        // Verify the product name ‘CronusYogaPant’
        verifyElements("Not matched","Cronus Yoga Pant",By.xpath("(//a[normalize-space()='Cronus Yoga Pant'])[2]"));

        // Verify the product size ‘32’
        verifyElements("Not","32",By.xpath("//dd[contains(text(),'32')]"));
        // * Verify the product colour ‘Black’
        verifyElements("Not","Black",By.xpath("//dd[contains(text(),'Black')]"));

    }
    @After
    public  void tearDown(){
        closeBrowser();
    }
}
