package com.learn.pageModel.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chandrad on 2/16/17.
 */
public class CommonMethods {

    public static String getUniqueEmail(String name){
        String value = name + new SimpleDateFormat("ddMMYYhhmm").format(new Date()) + "@mailinator.com";
        return value;
    }

    public static String timeStamp(String name) {
        String value = name + new SimpleDateFormat("ddMMYYhhmmss").format(new Date());
        return value;
    }
}
