package com.hotelbookingsystem.utils;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeUtils {

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy", new Locale("es", "ES"));
    public static final DateTimeFormatter TIME_FORMATTER =  DateTimeFormatter.ofPattern("HH:mm 'hrs'", new Locale("es","ES"));

}
