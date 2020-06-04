package sevenkey.open.utils.utils;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.jumpmind.symmetric.csv.CsvWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * csv 操作工具
 *
 * @author weijianyu
 */
@Slf4j
public class CSVUtil {

    private CSVUtil() {
    }

    /**
     * contents 内容写进fileName文件 csv 格式
     *
     * @param fileName 文件名称
     */
    public static void write(String fileName, List<String> contents) {
        try {
            CsvWriter wr = new CsvWriter(fileName, ',', StandardCharsets.UTF_8);
            wr.writeRecord(contents.toArray(new String[]{}));
            wr.close();
        } catch (Exception e) {
            log.error("csv write fail", e);
        }
    }

    /**
     * file 内容写进fileName文件 csv 格式
     *
     * @param fileName 文件名称
     * @param file     写入内容
     */
    public static void write(String fileName, File file) {
        List<String> contents = Lists.newArrayList();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), StandardCharsets.UTF_8));
            CsvWriter wr = new CsvWriter(fileName, ',', StandardCharsets.UTF_8);

            String line = null;
            while ((line = reader.readLine()) != null) {
                contents.add(line);
            }

            wr.writeRecord(contents.toArray(new String[]{}));
            reader.close();
            wr.close();
        } catch (Exception e) {
            log.error("csv write fail", e);
        }
    }
}
