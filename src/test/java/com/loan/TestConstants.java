package com.loan;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static java.math.BigDecimal.ONE;

public class TestConstants {
    public static final long PERSONAL_NUMBER = 1L;
    public static final String NAME = "Petras";
    public static final String LAST_NAME = "Pavardenis";
    public static final int SIX_MONTHS = 6;
    public static final String CLIENT_IP = "192.168.1.2";
    public static final String CLIENT_IP_2 = "192.168.1.3";
    public static final BigDecimal LOAN_AMOUNT = ONE;
    public static final LocalDateTime LOCAL_DATE_TIME_MINUS_DAY = LocalDateTime.now().minusDays(1);
    public static final LocalDateTime LOCAL_DATE_TIME_MINUS_2DAYS = LocalDateTime.now().minusDays(2);
}
