package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Day10_DropDownOrnek {
    // 1. Amazon.com'a gidelim.
    // 2. DropDown uzerinde Software secelim.
    // 3. Arama kutusuna JAVA yazalim ve arama yapalim.
    // 4. Sonuc sayisini ekrana yazdiralim.




    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

        @Test
          public void amazomAramaTesti(){
            driver.get("http://amazon.com");
            WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));

            Select select = new Select(dropDown);



            select.selectByVisibleText("Software");

            WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
            aramaKutusu.sendKeys("JAVA" + Keys.ENTER);
            // aramaKutusu.submit();

            WebElement sonucSayisi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
            System.out.println(sonucSayisi.getText());

            Assert.assertTrue(sonucSayisi.getText().contains("JAVA"));


            WebElement sonucSayisiCss = driver.findElement(By.cssSelector(".a-section.a-spacing-small.a-spacing-top-small"));
            System.out.println(sonucSayisiCss.getText());
           // Onemli= ((( Css selector ile bulmak istedigimizde  CLASS'in icindeki bosliklari kapatip yerine " . " isaretini koymamiz lazim')))



        }



















    }
