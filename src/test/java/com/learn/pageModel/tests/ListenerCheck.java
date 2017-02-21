package com.learn.pageModel.tests;

import com.learn.pageModel.common.DriverManager;
import com.learn.pageModel.pages.HomePage;
import org.testng.annotations.Test;

/**
 * Created by chandrad on 2/21/17.
 */
public class ListenerCheck {


    @Test
    public void random(){
        HomePage page = new HomePage(DriverManager.getDriver()) ;
        page.getProductNamesFromList();
    }


}
