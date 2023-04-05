package logger_library_01.layouts;

import logger_library_01.loggers.MessageLogger;

public class XmlLayout implements Layout{
    @Override
    public String format(String timeStamp, MessageLogger.LogLevel logLevel, String message) {
        return String.format(
                "<log>%n" +
                "   <date>%s</date>%n" +
                "   <level>%s</level>%n" +
                "   <message>%s</message>%n" +
                "</log>%n", timeStamp, logLevel, message);
    }
}
