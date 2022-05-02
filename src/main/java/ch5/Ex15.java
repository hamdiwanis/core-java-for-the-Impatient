package ch5;

import java.util.Date;
import java.util.logging.*;

public class Ex15 {
    public static void main(String[] args) {
        Handler handler = new ConsoleHandler();
        handler.setFormatter(new HTMLFormatter());

        var logger = Logger.getGlobal();
        logger.setUseParentHandlers(false);
        logger.addHandler(handler);

        logger.info("Test Message 1");
        logger.info("Test Message 2");
    }

    public static class HTMLFormatter extends Formatter {

        @Override
        public String getHead(Handler h) {
            return "<body>";
        }

        @Override
        public String getTail(Handler h) {
            return "</body>";
        }

        @Override
        public String format(LogRecord record) {
            return ("" +
                    "<tr><td>" +
                    (new Date(record.getMillis())).toString() +
                    "</td><td>" +
                    record.getMessage() +
                    "</td></tr>\n"
            );
        }
    }
}
