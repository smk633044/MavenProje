package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class day07_IlkDers {

    public static void main(String[] args) {
        //Browserlari kullanabilmek icin WebDriverManager kutuphanesini kullaniyor.
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.get("https://www.amazon.com");

        //  WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        // aramaKutusu.sendKeys("iphone" );
        // aramaKutusu.submit();

        WebElement aramaKutu = driver.findElement(By.xpath("//input[@class='nav-input']"));
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        aramaKutu.sendKeys("samsung headphones" + Keys.ENTER);

        // aramaKutu.submit();

        WebElement yazi = driver.findElement(By.xpath("//span[@dir='auto']"));
        System.out.println(yazi.getText());

        WebElement ilkUrun = driver.findElement(By.xpath("//span[@class = 'a-size-medium a-color-base a-text-normal']"));
        System.out.println(ilkUrun.getText());

        List<WebElement> listem = driver.findElements(By.xpath("//span[@class = 'a-size-medium a-color-base a-text-normal']"));



    for (WebElement w : listem) { // for(int i = 0 ; i < listem.size(); i++
        // seklinde de yazilabilir. )
        System.out.println(w.getText());

    }
    }
}


