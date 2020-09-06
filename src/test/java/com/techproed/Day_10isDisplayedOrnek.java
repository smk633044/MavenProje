package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day_10isDisplayedOrnek {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();

    }

    @Before
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.bestbuy.com");

    }

    @After
    public void afterMethod(){
        driver.quit();
    }






    // titleTest => sayfa basliginin "Best" icerdigini(contains dogrulayin
    @Test
    public void titleTest(){
        String sayfaBasligi = driver.getTitle();
        boolean bestKelimesiniIceriyorMu = sayfaBasligi.contains("Best");// true veya false

        Assert.assertTrue(bestKelimesiniIceriyorMu);

    }

   // logoTest=> BestBuy logosunun goruntulenip goruntulenmedigini dogrulayin

    @Test
    public void logoTest(){
        WebElement logo= driver.findElement(By.className("logo"));
                                        // By.xpath("//img[@class='logo']")
        boolean logoGorunuyorMu = logo.isDisplayed();// true veya false

        Assert.assertTrue(logoGorunuyorMu);

    }

    // mexicoLinkTest => Linkin goruntulenip goruntulenmedigini dogrulayin

    @Test
    public void mexicoLinkTest(){


        //<a href="https://www.bestbuy.com/?intl=nosplash" class="us-link">
        // <img src="https://www.bestbuy.com/~assets/bby/_intl/landing_page/images/maps/usa.svg" alt="United States">
        // <h4>United States</h4>
        // </a>


        WebElement mexicoLinki = driver.findElement(By.partialLinkText("Mexico"));
        boolean linkGorunuyorMu = mexicoLinki.isDisplayed();

        Assert.assertTrue(linkGorunuyorMu);


    }




}
