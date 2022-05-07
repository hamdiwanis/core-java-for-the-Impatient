package ch9;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Ex6 {
    public static void flipBMPHorizontally(String filePath) throws IOException {
        try (var image = new RandomAccessFile(filePath, "rw")) {
            byte[] imageBytes = new byte[Math.toIntExact(image.length())];
            for (int i = 0; i < image.length(); i++) {
                imageBytes[i] = image.readByte();
            }

            var dataOffset = byteArrayToInt(Arrays.copyOfRange(imageBytes, 10, 14));
            var height = byteArrayToInt(Arrays.copyOfRange(imageBytes, 22, 26));
            var width = byteArrayToInt(Arrays.copyOfRange(imageBytes, 18, 22));
            var bitDepth = byteArrayToInt(Arrays.copyOfRange(imageBytes, 28, 32));

            var pixelSize = bitDepth / 8;
            var rowSize = width * pixelSize;
            var padding = 0;

            var rowSizeReminder = rowSize % 4;
            if (rowSizeReminder != 0) {
                padding = 4 - rowSizeReminder;
                rowSize += padding;
            }

            for (int i = 0; i < height; i++) {
                var rowStart = dataOffset + (i * rowSize);
                var rowEnd = rowStart + rowSize;
                var rowBytes = Arrays.copyOfRange(imageBytes, rowStart, rowEnd - padding);
                var rowPixels = new ArrayList<byte[]>(rowBytes.length / pixelSize);

                for (int j = 0; j < rowBytes.length; j += pixelSize) {
                    rowPixels.add(Arrays.copyOfRange(rowBytes, j, j + pixelSize));
                }

                Collections.reverse(rowPixels);
                var reversedRowPixels = rowPixels;

                for (int j = 0; j < reversedRowPixels.size(); j++) {
                    var pixel = reversedRowPixels.get(j);

                    for (int k = 0; k < pixelSize; k++) {
                        image.seek(rowStart + ((long) pixelSize * j) + k);
                        image.writeByte(pixel[k]);
                    }
                }
            }
        }
    }

    static byte[] reverseArray(byte[] a) {
        int n = a.length;

        byte i, t;
        for (i = 0; i < n / 2; i++) {
            t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }

        return a;
    }

    static int byteArrayToInt(byte[] bytes) {
        ByteBuffer wrapped = ByteBuffer.wrap(reverseArray(bytes));
        return wrapped.getInt();
    }
}