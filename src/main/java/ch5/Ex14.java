package ch5;

import java.util.logging.Filter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class Ex14 {
    public static void main(String[] args) {
        var logger = Logger.getGlobal();
        logger.setFilter(new BadWordsFilter());

        logger.info("Allowed Message");
        logger.info("Not Allowed Message because it has C++");
    }

    public static class BadWordsFilter implements Filter {
        String[] blackList = {"C++", "Drugs"};

        @Override
        public boolean isLoggable(LogRecord record) {
            var message = record.getMessage();
            for (var blackListedWord : blackList) {
                boolean hasBlackListedWord = message.toLowerCase().contains(blackListedWord.toLowerCase());
                if (hasBlackListedWord) {
                    return false;
                }
            }

            return true;
        }
    }
}
