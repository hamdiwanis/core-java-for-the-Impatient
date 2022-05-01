package ch4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Ex6Test {
    @Test
    public void testBrokenSymmetry() {
        var x = new Ex6.DiscountedItem("Item", 100, 40);
        var y = new Ex6.Item("Item", 100);
        var z = new Ex6.DiscountedItem("Item", 100, 50);

        assertTrue(x.equals(y));
        assertTrue(y.equals(z));
        assertFalse(x.equals(z));
    }
}