package com.loan.model;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Risk {

    public static boolean isRiskyTime() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        Date currentDate = new Date();
        String currentTime = timeFormat.format(currentDate);
//checkint ar laikas tarp 00:00 ir 06:00
        return true;
    }
}
