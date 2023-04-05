package logger_library_01.layouts;

import logger_library_01.loggers.MessageLogger;

public class SimpleLayout implements Layout{

    @Override
    public String format(String timeStamp, MessageLogger.LogLevel logLevel, String message) {
        return String.format("%s – %s – %s", timeStamp, logLevel, message);
    }
}
