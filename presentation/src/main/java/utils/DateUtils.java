package utils;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtils {

    public static final String SERVICES_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssz";

    public static long getDaysBetween(Date startDate, Date endDate) {
        final long diff = endDate.getTime() - startDate.getTime();
        if (diff <= 0) {
            return 0;
        }

        return (long) Math.ceil((double) diff / (TimeUnit.DAYS.toMillis(1)));
    }

    public static long getDaysWithoutTimeBetween(Date startDate, Date endDate) {
        long daysBetween = 0;

        Calendar startDateClone = Calendar.getInstance();
        startDateClone.setTime(startDate);
        removeTime(startDateClone);

        Calendar endDateClone = Calendar.getInstance();
        endDateClone.setTime(endDate);
        removeTime(endDateClone);

        long diff = endDateClone.getTimeInMillis() - startDateClone.getTimeInMillis();

        daysBetween = (long) Math.ceil((double) (diff / (float) (1000 * 60 * 60 * 24)));
        return daysBetween;
    }

    public static long getTimeInMillisecondsBetween(Calendar startCal, Calendar endCal) {
        long diff = endCal.getTimeInMillis() - startCal.getTimeInMillis();

        if (diff < 0) {
            return 0;
        }
        return diff;
    }

    public static Calendar getMidNightTime(Calendar cal) {
        removeTime(cal);
        return cal;
    }

    private static void removeTime(Calendar startDateClone) {
        startDateClone.set(Calendar.AM_PM, Calendar.AM);
        startDateClone.set(Calendar.HOUR, 0);
        startDateClone.set(Calendar.MINUTE, 0);
        startDateClone.set(Calendar.SECOND, 0);
        startDateClone.set(Calendar.MILLISECOND, 0);
    }
}
