package utils;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class StringUtils {

    public static final String EMPTY_STRING = "";

    public static boolean isNullOrEmptyOrBlank(String str){
        return str == null || str.trim().length() == 0;
    }

    public static String[] splitDoubleValueIntoStrings(final double value) {
        DecimalFormat formater = new DecimalFormat(".#");
        formater.setMinimumFractionDigits(2);

        String[] result = new String[2];
        result[0] = "" + (int)value;
        result[1] = formater.format(value % 1);

        return result;
    }

    public static String removeNonDigits(final String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        return str.replaceAll("[^0-9\\.]+", "");
    }
}
