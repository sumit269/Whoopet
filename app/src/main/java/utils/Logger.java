package utils;

import timber.log.Timber;

/**
 * Created by SumitBhatia on 10/07/15.
 */
public class Logger {
    public static boolean LOGGING_ENABLED = false;

    public static void info(Exception exception) {
        info(null, exception);
    }

    public static void info(String tag, Exception exception) {
        Timber.e(tag + "::" + exception.getMessage());
    }

    public static void error(Exception exception) {
        error(null, exception);
    }

    public static void error(String tag, Exception exception) {
        Timber.e(exception.getMessage());
    }

    public static void debug(Exception exception) {
        debug(null, exception);
    }

    public static void debug(String tag, Exception exception) {
        Timber.e(tag + "::" + exception.getMessage());
    }

    public static void warn(Exception exception) {
        warn(null, exception);
    }

    public static void warn(String tag, Exception exception) {
        Timber.w(exception.getMessage());
    }
}
