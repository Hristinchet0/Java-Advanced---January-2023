package logger_library_01.layouts;

import logger_library_01.loggers.MessageLogger;

public interface Layout {
    String format (String timeStamp, MessageLogger.LogLevel logLevel, String message);
}
