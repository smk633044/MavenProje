package com.techproed;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class Day08_BeforeAfterClass {

    @AfterClass   // bu annotationa sahip method, her classtaki testler calistirildiktan sonra calisir.
    public static void tearDown(){
        System.out.println("tearDown calisti.");

    }


    @Test
    public void test1(){
        System.out.println("Test 1 calisti.");
    }


    @Test
    public void test2(){
        System.out.println("Test 2 calisti.");
    }

    @BeforeClass  // bu annotationa sahip method, her class calismadan once calisir.
    public static void setUp(){
        System.out.println("setUp  calisti.");

    }

}
