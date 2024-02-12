package buontyhunter.common.Logger;

public class LoggerImpl implements Logger {
    private boolean logEnabled = false;

    @Override
    public void enableLog() {
        logEnabled = true;
    }

    @Override
    public void disableLog() {
        logEnabled = false;
    }

    @Override
    public boolean isLogging() {
        return logEnabled;
    }

    @Override
    public boolean log(String message, LogType type) {
        if (logEnabled) {
            System.out.println(type.toString() + ": " + message);
        }

        return logEnabled;
    }

}
