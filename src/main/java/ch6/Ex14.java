package ch6;

import java.util.ArrayList;

public class Ex14 {
    public static <T extends AutoCloseable> void closeAll(ArrayList<T> elems) throws Exception {
        Exception exception = null;

        for (T elem : elems) {
            try {
                elem.close();
            } catch (Exception ex) {
                if (exception == null) {
                    exception = ex;
                } else {
                    ex.addSuppressed(exception);
                    exception = ex;
                }
            }
        }
        ;

        if (exception != null) {
            throw exception;
        }
    }
}
