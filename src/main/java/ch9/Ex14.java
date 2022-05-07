package ch9;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Ex14 {
    private static void serialize(Point[] points, String filePath) {
        try (
                var fileOutputStream = Files.newOutputStream(Paths.get(filePath));
                var writer = new ObjectOutputStream(fileOutputStream);
        ) {
            writer.writeObject(points);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Point[] deserialize(String filePath) {
        try (
                var fileInputStream = Files.newInputStream(Paths.get(filePath));
                var reader = new ObjectInputStream(fileInputStream);
        ) {
            return (Point[]) reader.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class Point implements Serializable {
        private double x;
        private double y;


        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
