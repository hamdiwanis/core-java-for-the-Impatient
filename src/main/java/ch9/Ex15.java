package ch9;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Ex15 {
    public static class Point implements Serializable {
        // private static final long serialVersionUID = $PreviousUID;
        private double[] coordinates = new double[2];

        public Point(double x, double y) {
            coordinates[0] = x;
            coordinates[1] = y;
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            var fields = in.readFields();
            coordinates = new double[]{fields.get("x", 0.0), fields.get("y", 0.0)};
        }
    }
}
