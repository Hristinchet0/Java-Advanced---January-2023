package logger_library_01;

import logger_library_01.appenders.Appender;
import logger_library_01.appenders.ConsoleAppender;
import logger_library_01.appenders.FileAppender;
import logger_library_01.appenders.XmlAppender;
import logger_library_01.layouts.SimpleLayout;
import logger_library_01.layouts.XmlLayout;
import logger_library_01.loggers.Logger;
import logger_library_01.loggers.MessageLogger;
import logger_library_01.layouts.Layout;
import logger_library_01.utilities.LogFile;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int appendersCount = Integer.parseInt(scanner.nextLine());

        Map<Appender, MessageLogger.LogLevel> appenderLogLevelMap = new LinkedHashMap<>();

        while (appendersCount-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String appenderType = tokens[0];
            String layoutType = tokens[1];
            MessageLogger.LogLevel logLevel =
                    tokens.length == 3 ? MessageLogger.LogLevel.valueOf(tokens[2]) : MessageLogger.LogLevel.INFO;


            Layout layout = createLayout(layoutType);
            Appender appender = createAppender(appenderType, layout);
            appenderLogLevelMap.put(appender, logLevel);
        }

        Logger logger = new MessageLogger(appenderLogLevelMap);

        String line = scanner.nextLine();

        while (!line.equalsIgnoreCase("END")) {

            String[] tokens = line.split("\\|");

            MessageLogger.LogLevel logLevel = MessageLogger.LogLevel.valueOf(tokens[0]);

            String timeStamp = tokens[1];
            String message = tokens[2];

            switch (logLevel) {
                case INFO -> logger.logInfo(timeStamp, message);
                case WARNING -> logger.logWarning(timeStamp, message);
                case ERROR -> logger.logError(timeStamp, message);
                case CRITICAL -> logger.logCritical(timeStamp, message);
                case FATAL -> logger.logFatal(timeStamp, message);
            }


            line = scanner.nextLine();

        }

        System.out.println(logger.toString());

    }

    private static Appender createAppender(String appenderType, Layout layout) {
        return switch (appenderType) {
            case "ConsoleAppender" -> new ConsoleAppender(layout);
            case "FileAppender" -> new FileAppender(layout, new LogFile());
            case "XmlAppender" -> new XmlAppender(layout);
            default -> throw new IllegalStateException("Unexpected appender type: " + appenderType);

        };
    }

    private static Layout createLayout(String layoutType) {
        return layoutType.equals("SimpleLayout") ? new SimpleLayout() : new XmlLayout();
    }
}
