package logger_library_01.appenders;

import logger_library_01.layouts.Layout;
import logger_library_01.loggers.MessageLogger;

public interface Appender {
    void append(String timeStamp, MessageLogger.LogLevel logLevel, String message);

    Layout getLayout();
    int getMessagesCount();
}
