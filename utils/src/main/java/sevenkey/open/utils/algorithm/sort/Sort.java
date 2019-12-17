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

    /**
     * 二分搜索
     *
     * @param array 数组
     * @param n     长度
     * @param value 查找的值
     * @return 返回下标
     */
    public static int bSearch(int[] array, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            if (array[middle] == value) {
                return middle;
            } else if (array[middle] > value) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    /**
     * 二分搜索 第一个相同的
     *
     * @param array 数组
     * @param n     长度
     * @param value 查找的值
     * @return 返回下标
     */
    public static int bSearchFirstEquals(int[] array, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            if (array[middle] == value) {
                if (middle == 0 || array[middle - 1] < value) {
                    return middle;
                } else {
                    high = middle - 1;
                }
            } else if (array[middle] > value) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    /**
     * 二分搜索 最后一个相同的
     *
     * @param array 数组
     * @param n     长度
     * @param value 查找的值
     * @return 返回下标
     */
    public static int bSearchLastEquals(int[] array, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            if (array[middle] == value) {
                if (middle == n - 1 || array[middle + 1] > value) {
                    return middle;
                } else {
                    low = middle + 1;
                }
            } else if (array[middle] > value) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    /**
     * 二分搜索 第一个大于等于
     *
     * @param array 数组
     * @param n     长度
     * @param value 查找的值
     * @return 返回下标
     */
    public static int bSearchFirstGTE(int[] array, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            if (array[middle] >= value) {
                if (middle == 0 || array[middle - 1] < value) {
                    return middle;
                }
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    /**
     * 二分搜索 最后一个小于等于
     *
     * @param array 数组
     * @param n     长度
     * @param value 查找的值
     * @return 返回下标
     */
    public static int bSearchLastLTE(int[] array, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            if (array[middle] > value) {
                high = middle - 1;
            } else {
                if (middle == n - 1 || array[middle + 1] > value) {
                    return middle;
                }
                low = middle + 1;
            }
        }
        return -1;
    }
}

