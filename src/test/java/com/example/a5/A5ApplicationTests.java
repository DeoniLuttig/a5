package com.example.a5;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class A5ApplicationTests {

    private final BinPacking binPacking;

    A5ApplicationTests() {
        this.binPacking = new BinPacking();
    }

    @Test
    void test_miniMumBinsRequired_shouldSucceed() {
        List<Double> items = List.of(0.1, 0.2, 0.3);

        int result = binPacking.minimumBinsRequired(items);
        assertEquals(result, 1);
    }

    @Test
    void test_miniMumBinsRequired_shouldSucceed2() {
        List<Double> items = List.of(0.1, 0.2, 0.3, 0.9, 0.8);

        int result = binPacking.minimumBinsRequired(items);
        assertEquals(result, 3);
    }

    @Test
    void test_isValidList_shouldSucceed() {
        List<Double> items = List.of(0.1, 0.2, 0.3);

        boolean result = binPacking.isValidList(items);
        assertTrue(result);
    }

    @Test
    void test_isValidList_shouldFail() {
        List<Double> items = List.of(3.0);

        boolean result = binPacking.isValidList(items);
        assertFalse(result);
    }


}
