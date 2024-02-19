package buontyhunter.common.Logger;

public interface Logger {
    public void enableLog();

    public void disableLog();

    public boolean isLogging();

    public boolean log(String message, LogType type);

}
