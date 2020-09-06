package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day10_DopDown {

  static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void test1(){
        driver.get("http://amazon.com");
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
         // select class'indan nesne uretmeden dropDown uzerinde islem yapamayiz
         // Eger  mulakatta dropDown ile ilgili bir soru gelirse. kesinlikle
         // select class'indan bahsetmemiz gerekiyor. Cunku select class olmadan dropDown kullanamayiz.

        Select select = new Select(dropDown);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
         // Secenegin yazisina gore . secim yapabiliriz.
        select.selectByVisibleText("Baby");


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        // Secenegin value attribute kullanilarak secim yapilir.
        select.selectByValue("search-alias=automotive-intl-ship");



        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
           // Secenegin bulundugu siraya gore secim yapilabilir.
        select.selectByIndex(5);  //!!! Dikkat  Index 0 'dan baslar.....0, 1,2 3.......'

           // getFirstSelectedOption- dropDown uzerinde suanda secili olan
           // webelementi size return eder (yazdirir)
        WebElement secim = select.getFirstSelectedOption();
        System.out.println(secim.getText());  // sectigimiz kategoriyi ekranba bu sekilde yazabiliriz.....

            //getOptions() tum secenekleri  List<WebElement> seklinde size return eder.
         List<WebElement> liste= select.getOptions();
            // Eger bir listeyi EKRANA YAZDIRMAK istiyorsak "for dongusu" nu  her zaman kullaniyorduk.
         for(WebElement w : liste){
             System.out.println(w.getText());
         }
            // liste.size() tum  seceneklerin toplam sayisini size return eder(yazdirir)
         int toplamSecenekSayisi = liste.size();
        System.out.println("Toplam secim sayisi : " + toplamSecenekSayisi);

    }
}
