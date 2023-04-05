package logger_library_01.appenders;

import logger_library_01.layouts.Layout;

public abstract class BaseAppender implements Appender{
    private Layout layout;
    protected int counter;

    protected BaseAppender(Layout layout) {
        this.layout = layout;
    }

    public Layout getLayout() {
        return layout;
    }

    public int getCounter() {
        return counter;
    }
     @Override
    public int getMessagesCount() {
        return counter;
     }
}
