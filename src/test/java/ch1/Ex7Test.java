package ch1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Ex7Test {
    @Test
    void unsigned_sum_return_expected_results() {
        int result = Ex7.unsignedSum(2, (int) 4_294_967_293L);

        assertEquals((int) 4_294_967_295L, result);
    }

    @Test
    void unsigned_difference_return_expected_results() {
        int result = Ex7.unsignedDifference((int) 4_294_967_293L, 2);

        assertEquals((int) 4_294_967_291L, result);
    }

    @Test
    void unsigned_product_return_expected_results() {
        int result = Ex7.unsignedProduct((int) 2_000_000_000L, 2);

        assertEquals((int) 4_000_000_000L, result);
    }

    @Test
    void unsigned_quotient_return_expected_results() {
        int result = Ex7.unsignedQuotient((int) 4_000_000_000L, 2);

        assertEquals((int) 2_000_000_000L, result);
    }

    @Test
    void unsigned_remainder_return_expected_results() {
        int result = Ex7.unsignedRemainder((int) 4_000_000_001L, (int) 4_000_000_000L);

        assertEquals(1, result);
    }
}