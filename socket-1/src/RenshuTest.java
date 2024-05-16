
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RenshuTest {
    
    Renshu renshu = new Renshu();
    
    @Test
    void testDoubleValue() {
        assertEquals(4, renshu.doubleValue(2));
        assertEquals(0, renshu.doubleValue(0));
        assertEquals(-6, renshu.doubleValue(-3));
    }

    @Test
    void testSumUpToN() {
        assertEquals(15, renshu.sumUpToN(5));
        assertEquals(0, renshu.sumUpToN(0));
        assertEquals(1, renshu.sumUpToN(1));
    }

    @Test
    void testSumFromPtoQ() {
        assertEquals(15, renshu.sumFromPtoQ(1, 5));
        assertEquals(0, renshu.sumFromPtoQ(0, 0));
        assertEquals(55, renshu.sumFromPtoQ(1, 10));
    }

    @Test
    void testSumFromArrayIndex() {
        int[] array = {1, 2, 3, 4, 5};
        assertEquals(15, renshu.sumFromArrayIndex(array, 0));
        assertEquals(12, renshu.sumFromArrayIndex(array, 1));
        assertEquals(-1, renshu.sumFromArrayIndex(array, 5));
    }

    @Test
    void testSelectMaxValue() {
        int[] array = {1, 2, 3, 4, 5};
        assertEquals(5, renshu.selectMaxValue(array));
        int[] array2 = {-1, -2, -3, -4, -5};
        assertEquals(-1, renshu.selectMaxValue(array2));
    }

    @Test
    void testSelectMaxIndex() {
        int[] array = {1, 2, 3, 4, 5};
        assertEquals(4, renshu.selectMaxIndex(array));
        int[] array2 = {-1, -2, -3, -4, -5};
        assertEquals(0, renshu.selectMaxIndex(array2));
    }

    @Test
    void testSwapArrayElements() {
        int[] array = {10, 9, 8, 4, 15, 0, -3, 18, 9, 7};
        int[] expected = {7, 9, 8, 4, 15, 0, -3, 18, 9, 10};
        renshu.swapArrayElements(array, 0, 9);
        assertTrue(Arrays.equals(array, expected));
    }

    @Test
    void testSwapTwoArrays() {
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};
        int[] expected1 = {4, 5, 6};
        int[] expected2 = {1, 2, 3};
        assertTrue(renshu.swapTwoArrays(array1, array2));
        assertTrue(Arrays.equals(array1, expected1));
        assertTrue(Arrays.equals(array2, expected2));
        
        int[] array3 = {1, 2};
        assertFalse(renshu.swapTwoArrays(array1, array3));
    }

    @Test
    void bubbleSort() {
        int[] a = new int[]{5, 2, 3, 5, 4};
        renshu.bubbleSort(a);
        assertArrayEquals(new int[]{2, 3, 4, 5, 5}, a);
    }
    
    @Test
    void quickSort() {
        int[] a = new int[]{5, 2, 3, 5, 4};
        renshu.quickSort(a);
        assertArrayEquals(new int[]{2, 3, 4, 5, 5}, a);
    }
    
    @Test
    void quickSortShortTime() {
        int[] a = new int[1000000];
        Random r = new Random();
        for (int i = 0; i < 1000000; i++) {
            a[i] = r.nextInt(1000000);
        }
        Assertions.assertTimeout(Duration.ofSeconds(1), () -> { // NOTE: 1秒以内に実行できる
            renshu.quickSort(a);
            assertTrue(isSorted(a)); // NOTE: ソートされている
        });
    }
    
    boolean isSorted(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) return false;
        }
        return true;
    }
}
