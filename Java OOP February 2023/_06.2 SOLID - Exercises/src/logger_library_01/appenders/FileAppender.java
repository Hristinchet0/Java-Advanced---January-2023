package logger_library_01.appenders;

import logger_library_01.layouts.Layout;
import logger_library_01.loggers.MessageLogger;
import logger_library_01.utilities.File;

public class FileAppender extends BaseAppender {
    private File file;
    public FileAppender(Layout layout, File file) {
        super(layout);
        this.file = file;
    }

    @Override
    public void append(String timeStamp, MessageLogger.LogLevel logLevel, String message) {
        counter++;
        file.write(getLayout().format(timeStamp, logLevel, message));
    }

    public File getFile() {
        return file;
    }
}
