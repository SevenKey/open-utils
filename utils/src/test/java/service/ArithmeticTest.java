package service;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class ArithmeticTest {

    private static final List<Integer> NUMBER_ARRAY = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9);

    private long sum(List<Integer> result) {
        if(CollectionUtils.isEmpty(result)){
            return 0;
        }

        long sum = 1;
        for (Integer item : result) {
            sum *= item;
        }

        return sum;
    }

    private void print(List<Integer> result) {
        for (Integer item : result) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    private void findKMuiltResult(int n, List<Integer> result) {
        long k = sum(result);

        for (int i : NUMBER_ARRAY) {
            if (result.contains(1) && i == 1) {
                continue;
            }

            result.add(i);
            if (k * i == n) {
                print(result);
            } else if (k * i > n) {
                result.remove(i);
                return;
            } else {
                findKMuiltResult(n, result);
            }
        }
    }

    @Test
    public void testFindKMuiltResult() {
        System.out.println(ArithmeticTest.class.getSimpleName());
    }
}
