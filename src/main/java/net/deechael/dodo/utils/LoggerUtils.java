package net.deechael.dodo.utils;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.ConsoleAppender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class LoggerUtils {

    public static Logger getLogger(Class<?> clazz) {
        return getLogger(clazz, Level.INFO);
    }

    public static Logger getLogger(Class<?> clazz, Level level) {
        ch.qos.logback.classic.Logger lgr = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(clazz);
        LoggerContext loggerContext = lgr.getLoggerContext();
        loggerContext.reset();

        PatternLayoutEncoder encoder = new PatternLayoutEncoder();
        encoder.setContext(loggerContext);
        encoder.setPattern("[%date] [%logger{32}] [%thread] [%level] %message%n");
        encoder.start();

        ConsoleAppender<ILoggingEvent> appender = new ConsoleAppender<ILoggingEvent>();
        appender.setContext(loggerContext);
        appender.setEncoder(encoder);
        appender.start();

        lgr.addAppender(appender);
        lgr.setLevel(level);
        return lgr;
    }

    private LoggerUtils() {
    }

}
