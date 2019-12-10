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
}
