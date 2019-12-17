package algorithm.sort;

import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import sevenkey.open.utils.algorithm.sort.Sort;

import java.util.Comparator;
import java.util.List;

public class SortTest {

    @Test
    public void testMergeSort() {
        int[] array = new int[]{1, 5, 6, 2, 3, 4, 4, 7};
        List<Integer> cloneArrayList = Lists.newArrayList();
        for (int i = 0; i < array.length; i++) {
            cloneArrayList.add(array[i]);
        }

        Sort.mergeSort(array, 0, array.length - 1);

        cloneArrayList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? -1 : o1 == o2 ? 0 : 1;
            }
        });
        Integer[] cloneArray = cloneArrayList.toArray(new Integer[]{});

        for (int i = 0; i < array.length; i++) {
            Assert.assertEquals(cloneArray[i].intValue(), array[i]);
        }
    }

    @Test
    public void testQuickSort() {
        int[] array = new int[]{1, 5, 6, 2, 3, 4, 4, 7};
        List<Integer> cloneArrayList = Lists.newArrayList();
        for (int i = 0; i < array.length; i++) {
            cloneArrayList.add(array[i]);
        }

        Sort.quickSort(array, 0, array.length - 1);

        cloneArrayList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? -1 : o1 == o2 ? 0 : 1;
            }
        });
        Integer[] cloneArray = cloneArrayList.toArray(new Integer[]{});

        for (int i = 0; i < array.length; i++) {
            Assert.assertEquals(cloneArray[i].intValue(), array[i]);
        }
    }

    @Test
    public void testSearchK() {
        int[] array = new int[]{1, 5, 6, 2, 3, 4, 4, 7};
        Assert.assertEquals(0, Sort.searchK(array, 0, array.length - 1, 10));
        Assert.assertEquals(7, Sort.searchK(array, 0, array.length - 1, 1));
        Assert.assertEquals(6, Sort.searchK(array, 0, array.length - 1, 2));
        Assert.assertEquals(5, Sort.searchK(array, 0, array.length - 1, 3));
        Assert.assertEquals(4, Sort.searchK(array, 0, array.length - 1, 4));
        Assert.assertEquals(4, Sort.searchK(array, 0, array.length - 1, 5));
        Assert.assertEquals(3, Sort.searchK(array, 0, array.length - 1, 6));
        Assert.assertEquals(2, Sort.searchK(array, 0, array.length - 1, 7));
        Assert.assertEquals(1, Sort.searchK(array, 0, array.length - 1, 8));
        Assert.assertEquals(0, Sort.searchK(array, 0, array.length - 1, 9));
    }

    @Test
    public void testBSearch() {
        int[] array = new int[]{1, 6, 9, 12, 16, 17, 18, 19, 20, 21, 22, 23};
        Assert.assertEquals(-1, Sort.bSearch(array, array.length, 26));
        Assert.assertEquals(0, Sort.bSearch(array, array.length, 1));
        Assert.assertEquals(1, Sort.bSearch(array, array.length, 6));
        Assert.assertEquals(2, Sort.bSearch(array, array.length, 9));
        Assert.assertEquals(3, Sort.bSearch(array, array.length, 12));
        Assert.assertEquals(4, Sort.bSearch(array, array.length, 16));
        Assert.assertEquals(5, Sort.bSearch(array, array.length, 17));
        Assert.assertEquals(6, Sort.bSearch(array, array.length, 18));
        Assert.assertEquals(9, Sort.bSearch(array, array.length, 21));
        Assert.assertEquals(10, Sort.bSearch(array, array.length, 22));
        Assert.assertEquals(11, Sort.bSearch(array, array.length, 23));
    }

    @Test
    public void testBSearchFirstEquals() {
        int[] array = new int[]{1, 1, 1, 6, 9, 12, 12, 12, 18, 19, 20, 20, 20, 20, 20, 20, 22, 23, 23};
        Assert.assertEquals(-1, Sort.bSearchFirstEquals(array, array.length, 26));
        Assert.assertEquals(0, Sort.bSearchFirstEquals(array, array.length, 1));
        Assert.assertEquals(5, Sort.bSearchFirstEquals(array, array.length, 12));
        Assert.assertEquals(10, Sort.bSearchFirstEquals(array, array.length, 20));
        Assert.assertEquals(17, Sort.bSearchFirstEquals(array, array.length, 23));
    }

    @Test
    public void testBSearchLastEquals() {
        int[] array = new int[]{1, 1, 1, 6, 9, 12, 12, 12, 18, 19, 20, 20, 20, 20, 20, 20, 22, 23, 23};
        Assert.assertEquals(-1, Sort.bSearchLastEquals(array, array.length, 26));
        Assert.assertEquals(2, Sort.bSearchLastEquals(array, array.length, 1));
        Assert.assertEquals(7, Sort.bSearchLastEquals(array, array.length, 12));
        Assert.assertEquals(15, Sort.bSearchLastEquals(array, array.length, 20));
        Assert.assertEquals(18, Sort.bSearchLastEquals(array, array.length, 23));
    }

    @Test
    public void testBSearchFirstGTE() {
        int[] array = new int[]{1, 1, 1, 6, 9, 12, 12, 12, 18, 19, 20, 20, 20, 20, 20, 20, 22, 23, 23};
        Assert.assertEquals(-1, Sort.bSearchFirstGTE(array, array.length, 26));
        Assert.assertEquals(0, Sort.bSearchFirstGTE(array, array.length, 1));
        Assert.assertEquals(5, Sort.bSearchFirstGTE(array, array.length, 12));
        Assert.assertEquals(10, Sort.bSearchFirstGTE(array, array.length, 20));
        Assert.assertEquals(17, Sort.bSearchFirstGTE(array, array.length, 23));
        Assert.assertEquals(3, Sort.bSearchFirstGTE(array, array.length, 5));
        Assert.assertEquals(8, Sort.bSearchFirstGTE(array, array.length, 17));
    }

    @Test
    public void testBSearchLastLTE() {
        int[] array = new int[]{1, 1, 1, 6, 9, 12, 12, 12, 18, 19, 20, 20, 20, 20, 20, 20, 22, 23, 23};
        Assert.assertEquals(18, Sort.bSearchLastLTE(array, array.length, 26));
        Assert.assertEquals(2, Sort.bSearchLastLTE(array, array.length, 1));
        Assert.assertEquals(7, Sort.bSearchLastLTE(array, array.length, 12));
        Assert.assertEquals(15, Sort.bSearchLastLTE(array, array.length, 20));
        Assert.assertEquals(18, Sort.bSearchLastLTE(array, array.length, 23));
        Assert.assertEquals(2, Sort.bSearchLastLTE(array, array.length, 5));
        Assert.assertEquals(7, Sort.bSearchLastLTE(array, array.length, 17));
    }
}
