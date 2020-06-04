package utils;

import org.assertj.core.util.Lists;
import org.junit.Test;
import sevenkey.open.utils.utils.CSVUtil;

import java.io.File;
import java.util.List;

public class CSVUtilTest {

    @Test
    public void testBuIdCSV() {
        String fileName = "/Users/weijianyu/IdeaProjects/open-utils/utils/build/resources/test/buId.csv";

        List<String> buIds = Lists.newArrayList();
        buIds.add("1");
        buIds.add("2");
        buIds.add("3");
        buIds.add("4");
        buIds.add("5");
        buIds.add("6");
        buIds.add("7");
        buIds.add("8");
        buIds.add("9");
        buIds.add("10");
        buIds.add("11");

        CSVUtil.write(fileName, buIds);
    }

    @Test
    public void testBuIdCSVFile() {
        String fileName = "/Users/weijianyu/IdeaProjects/open-utils/utils/build/resources/test/latitude.csv";

        File file = new File("/Users/weijianyu/IdeaProjects/open-utils/utils/build/resources/test/la");

        CSVUtil.write(fileName, file);
    }
}
