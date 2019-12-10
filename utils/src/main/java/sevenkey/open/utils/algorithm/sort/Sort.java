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


    /**
     * 快排
     *
     * @param array 数组
     * @param l     l
     * @param r     r
     */
    public static void quickSort(int[] array, int l, int r) {
        if (l >= r) {
            return;
        }

        int temp = array[l];

        int i = l;
        int j = r;
        while (i < j) {

            while (i < j && array[j] >= temp) {
                j--;
            }

            while (i < j && array[i] <= temp) {
                i++;
            }

            if (i < j) {
                int value = array[i];
                array[i++] = array[j];
                array[j--] = value;
            }
        }
        array[l] = array[j];
        array[j] = temp;

        quickSort(array, l, i);
        quickSort(array, i + 1, r);
    }

    /**
     * 寻找第 K 大数字
     *
     * @param array 数组
     * @param l     l
     * @param r     r
     * @param k     k
     * @return 数字
     */
    public static int searchK(int[] array, int l, int r, int k) {
        if (k > r + 1 || k <= 0) {
            return 0;
        }

        while (l <= r) {
            int j = searchK(array, l, r);
            if (k == (r - j + 1)) {
                return array[j];
            } else if (k < (r - j + 1)) {
                l = j + 1;
            } else {
                r = j - 1;
            }
        }
        return 0;
    }

    private static int searchK(int[] array, int l, int r) {
        int temp = array[l];

        int i = l;
        int j = r;
        while (i < j) {

            while (i < j && array[j] >= temp) {
                j--;
            }

            while (i < j && array[i] <= temp) {
                i++;
            }

            if (i < j) {
                int value = array[i];
                array[i++] = array[j];
                array[j--] = value;
            }
        }
        array[l] = array[j];
        array[j] = temp;

        return j;
    }
}

