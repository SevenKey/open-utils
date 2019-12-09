package sevenkey.open.utils.algorithm.sort;

/**
 * @author weijianyu
 */
public class Sort {

    /**
     * 归并排序
     */
    public static void mergeSort(int[] array, int l, int r) {
        if (l >= r) {
            return;
        }
        int middle = (l + r) / 2;
        mergeSort(array, l, middle);
        mergeSort(array, middle + 1, r);

        merge(array, l, middle, r);
    }

    private static void merge(int[] array, int l, int q, int r) {
        int[] tempArray = new int[r - l + 1];
        int p = 0;
        int i = l;
        int j = q + 1;
        while (i <= q && j <= r) {
            tempArray[p++] = array[i] <= array[j] ? array[i++] : array[j++];
        }

        if (i <= q) {
            for (; i <= q; i++) {
                tempArray[p++] = array[i];
            }
        }

        if (j <= r) {
            for (; j <= r; j++) {
                tempArray[p++] = array[j];
            }
        }

        for (int k = 0; k < tempArray.length; k++) {
            array[l + k] = tempArray[k];
        }
    }
}
