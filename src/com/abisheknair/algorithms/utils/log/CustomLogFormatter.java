package com.abisheknair.algorithms.utils.log;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class CustomLogFormatter extends Formatter {

    @Override
    public String format(LogRecord logRecord) {

        final String infoLogStringFormat = "[%1$tF %1$tT] [%2$s] %3$s %n";
        final String errorLogStringFormart = "[%1$tF %1$tT] [%2$s] %3$s::%4$s %5$s %n";

        String logStringMessage;

        if(logRecord.getLevel() == Level.SEVERE) {

            Throwable thrownException = logRecord.getThrown();

            logStringMessage =
                    String.format(errorLogStringFormart,
                        new Date(logRecord.getMillis()),
                        logRecord.getLevel(),
                        logRecord.getSourceClassName(),
                        logRecord.getSourceMethodName(),
                        logRecord.getMessage());

            if(thrownException != null) {
                thrownException.printStackTrace();
            }

        } else {

            logStringMessage =
                    String.format(infoLogStringFormat,
                        new Date(logRecord.getMillis()),
                        logRecord.getLevel(),
                        logRecord.getMessage());
        }

        return logStringMessage;
    }
}
