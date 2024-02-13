package buontyhunter.common.Logger;

import java.util.*;

public class AppLogger implements Logger {

    public static boolean DEFAULT_LOG_ENABLED = true;

    public static AppLogger instance = null;

    public static Logger getLogger() {
        if (AppLogger.instance == null) {
            AppLogger.instance = new AppLogger();
        }

        return AppLogger.instance;
    }

    private Logger defaultLogger = new LoggerImpl();

    private final Map<LogType, Boolean> logEnabled = new HashMap<>();

    public AppLogger() {
        logEnabled.put(LogType.CORE, true);
        logEnabled.put(LogType.GRAPHICS, false);
        logEnabled.put(LogType.MODEL, false);

        if (AppLogger.DEFAULT_LOG_ENABLED) {
            defaultLogger.enableLog();
        } else {
            defaultLogger.disableLog();
        }
    }

    @Override
    public void enableLog() {
        defaultLogger.enableLog();
    }

    @Override
    public void disableLog() {
        defaultLogger.disableLog();
    }

    @Override
    public boolean isLogging() {
        return defaultLogger.isLogging();
    }

    @Override
    public boolean log(String message, LogType type) {
        if (logEnabled.containsKey(type) && logEnabled.get(type)) {
            return defaultLogger.log(message, type);
        }
        return false;
    }
}
