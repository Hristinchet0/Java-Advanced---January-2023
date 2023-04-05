package logger_library_01.loggers;

public interface Logger {
    void logInfo(String timeStamp, String message);
    void logWarning(String timeStamp, String message);
    void logError(String timeStamp, String message);
    void logCritical(String timeStamp, String message);
    void logFatal(String timeStamp, String message);
}
