package org.andestech.learning.rfb18.g2;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class AppTest
{
    private WebDriver wd = null;

    @BeforeClass
    public void initData(){
    System.setProperty("webdriver.chrome.driver",
            "E:\\drivers\\selenium\\chromedriver.exe");
    System.out.println("+++ Class: " + this);

    }

    @Test
    public void testCaseChrome01()
    {


        wd = new ChromeDriver();
        wd.manage().timeouts().pageLoadTimeout(15000, TimeUnit.MILLISECONDS);

        wd.get("http://lenta.ru");

       // wd.close();

        wd.navigate().to("http://google.com");
       // wd.get("http://google.com");

        wd.navigate().back();
        wd.navigate().refresh();



        assertTrue( true );
        System.out.println("---" +
                Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Test
    public void testCaseChromeGoogleSearch() throws InterruptedException {


        wd = new ChromeDriver();
       // wd.manage().timeouts().pageLoadTimeout(15000, TimeUnit.MILLISECONDS);

        wd.get("http://google.com");

        WebElement element = wd.findElement(By.name("q"));

        element.sendKeys("Bank rating");
        element.submit();

        //List<WebElement> elements = wd.findElements(By.tagName("cite"));
        List<WebElement> elements = wd.findElements(By.cssSelector("cite"));


        int n = 1;
        for(WebElement el: elements)
        {
            System.out.println(n + " -> " + el.getText());
            n++;
        }

        WebElement link = wd.findElement(By.cssSelector("#pnnext"));

        link.click();
       // Thread.sleep(1000);

        List<WebElement> elements2 = wd.findElements(By.cssSelector("cite"));

        for(WebElement el: elements2)
        {
            System.out.println(n + " -> " + el.getText());
            n++;
        }

        Thread.sleep(2000);


        System.out.println("---" +
                Thread.currentThread().getStackTrace()[1].getMethodName());
    }

@Test
public void TestSiteDesign() throws InterruptedException {
    wd = new ChromeDriver();
    Wait wait = new WebDriverWait(wd, 1);

    wd.manage().timeouts().setScriptTimeout(300,TimeUnit.MILLISECONDS);

    //wd.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
    // wd.manage().timeouts().pageLoadTimeout(15000, TimeUnit.MILLISECONDS);

    wd.get("http://andestech.org/learning/rfb18/index.html");

   // Thread.sleep(2000);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("footer")));

    WebElement element = wd.findElement(By.cssSelector("footer"));
    System.out.println(element.getCssValue("border"));
    System.out.println(element.getAttribute("innerHTML"));




}


    @AfterClass
    public void tearDown()
    {
      if(wd != null) wd.quit();
      System.out.println("--- Class: " + this);
    }

}
