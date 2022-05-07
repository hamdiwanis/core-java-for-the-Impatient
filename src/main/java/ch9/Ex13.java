package ch9;

import java.io.*;

public class Ex13 {
    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T clone(T obj) {
        try (
                var backup = new ByteArrayOutputStream();
                var backupWriter = new ObjectOutputStream(backup);
        ) {
            backupWriter.writeObject(obj);
            backupWriter.flush();

            try (var backupReader = new ObjectInputStream(new ByteArrayInputStream(backup.toByteArray()))) {
                return (T) backupReader.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
