package logger_library_01.loggers;

import logger_library_01.appenders.Appender;
import logger_library_01.appenders.FileAppender;
import java.util.Map;

public class MessageLogger implements Logger {

    public enum LogLevel {
        INFO,
        WARNING,
        ERROR,
        CRITICAL,
        FATAL
    }

    private Map<Appender, LogLevel> appendersWithLevels;

    public MessageLogger(Map<Appender, LogLevel> appendersWithLevels) {
        this.appendersWithLevels = appendersWithLevels;
    }

    @Override
    public void logInfo(String timeStamp, String message) {
        logToAllAppenders(timeStamp, LogLevel.INFO, message);
    }

    @Override
    public void logWarning(String timeStamp, String message) {
        logToAllAppenders(timeStamp, LogLevel.WARNING, message);
    }

    @Override
    public void logError(String timeStamp, String message) {
        logToAllAppenders(timeStamp, LogLevel.ERROR, message);
    }

    @Override
    public void logCritical(String timeStamp, String message) {
        logToAllAppenders(timeStamp, LogLevel.CRITICAL, message);
    }

    @Override
    public void logFatal(String timeStamp, String message) {
        logToAllAppenders(timeStamp, LogLevel.FATAL, message);
    }

    private void logToAllAppenders(String timeStamp, LogLevel logLevel, String message) {
        for (var entry :  appendersWithLevels.entrySet()) {
            Appender appender = entry.getKey();
            LogLevel appenderLevel = entry.getValue();
            if(appenderLevel.ordinal() <= logLevel.ordinal()) {
                appender.append(timeStamp, logLevel, message);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Logger info");
        sb.append(System.lineSeparator());
        //"Logger info
        //Appender type: {appender type}, Layout type: {layout type}, Report level: {REPORT LEVEL}, Messages appended: {count}, File size: {size}"
        for (Map.Entry<Appender, LogLevel> entry : appendersWithLevels.entrySet()) {
            Appender appender = entry.getKey();
            LogLevel logLevel = entry.getValue();

            sb.append(String.format("Appender type: %s, Layout type: %s, ",
                    appender.getClass().getSimpleName(), appender.getLayout().getClass().getSimpleName()))
                    .append(String.format("Report level: %s, ", logLevel.toString()))
                    .append(String.format("Message appended: %d", appender.getMessagesCount()));

            if (appender instanceof FileAppender) {
                sb.append(String.format(", File size: %d", ((FileAppender)appender).getFile().size()));
            }

            sb.append(System.lineSeparator());
        }

        return sb.toString().trim();

    }
}
