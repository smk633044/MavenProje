package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day09_Assertion {

     private static WebDriver driver;


      @BeforeClass
    public static void setUp(){
          WebDriverManager.chromedriver().setup();
           driver = new ChromeDriver();
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      }
      @Test
      public void test1(){
          driver.get("http://google.com");

          //Test Case : Google.com'un basligi "Google Arama Sayfasi" olsun.
          String title = driver.getTitle();
          System.out.println(title);


          // Google''in title'i  "Google AramaSayfasi"na esit mi , degil mi?

          Assert.assertEquals("Google Arama Sayfasi",title);

         // Assert.assertEquals(5,5);
         // Assert.assertEquals(true,false);
         // Assert.assertEquals("Yazi", "Google");

      }

      @Test
      public void test2(){
        driver.get("http://amazon.com");
        //Amazon.com'un basligi Amazon kelimesini iceriyor olsun.
          String title = driver.getTitle();

          boolean iceriyorMu = title.contains("Amazon"); // "true ya da "false""

          //boolean veri tipinde bir deger giriyoruz.
          Assert.assertTrue(iceriyorMu);  // bunun True oldugunu  dogrula.
                                         // parantezin icerisi TRUE ise test basarili demektir.

      }


    @Test
    public void test3(){
          driver.get("http://facebook.com");

          String title = driver.getTitle();

          // Facebook.com'un title'i Youtube kelimesini icermesin.

           boolean iceriyorMu = title.contains("Youtube");

          Assert.assertFalse(iceriyorMu);// False oldugunu dogrula.
                                         // Yani FALSE olursa burda testim basarili demektir
    }

    @Test
    public void test4(){
        driver.get("http://google.com");
        String title = driver.getTitle();
        System.out.println("MERHABALAR..");
        Assert.assertEquals("Google Arama Sayfasi",title);

        //eger test basarisizsa icerisinde bulunulan testin kalan kismi calistirmiyor.
        System.out.println("TEST DOGRULAMA ISLEMI BITTI..");



    }

    @Test
    public void test5(){
        driver.get("http://facebook.com");

        String title = driver.getTitle();

        // Facebook.com'un title'i Youtube kelimesini icermesin.

        boolean iceriyorMu = title.contains("Google");

        Assert.assertFalse(iceriyorMu);// False oldugunu dogrula.
        // Yani FALSE olursa burda testim basarili demektir
        System.out.println("TEST DOGRULAMA ISLEMI BITTI..");

    }


      @AfterClass
    public static void tearDown(){
          driver.quit();
      }







}
