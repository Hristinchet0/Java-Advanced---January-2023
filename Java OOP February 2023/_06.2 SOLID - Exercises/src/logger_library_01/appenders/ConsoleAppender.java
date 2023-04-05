package logger_library_01.appenders;

import logger_library_01.loggers.MessageLogger;
import logger_library_01.layouts.Layout;

public class ConsoleAppender extends BaseAppender{


    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String timeStamp, MessageLogger.LogLevel logLevel, String message) {
        counter++;
        System.out.println(getLayout().format(timeStamp, logLevel, message));
    }
}
