package utils;

import org.junit.Assert;
import org.junit.Test;
import sevenkey.open.utils.utils.RSAUtil;

import java.util.Map;

public class RSAUtilTest {

    private static final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCo8bmfuveRMxBU+79ShzipiAkMzKbU71//A9RhlitAFN6qFIKo8Rvz2OTe5RqwI/MxQR0/CujDIscvyRAYMRq1xTiOAS9HyaCb4/pBwdfccZ3A6Am+qOpauiLsI6PglXi+TYqRC7YZ7uCFQtidMEDjvx6qX5I8daoHP8Jg2WS04QIDAQAB";

    private static final String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKjxuZ+695EzEFT7v1KHOKmICQzMptTvX/8D1GGWK0AU3qoUgqjxG/PY5N7lGrAj8zFBHT8K6MMixy/JEBgxGrXFOI4BL0fJoJvj+kHB19xxncDoCb6o6lq6Iuwjo+CVeL5NipELthnu4IVC2J0wQOO/Hqpfkjx1qgc/wmDZZLThAgMBAAECgYEAqM1t1SVw+4l0BhXMIl+tw+aCdGF/SD8tQZbH/AGZkVvI51O7AaZ3cXwDoppzwg8JjOssl7MEwwTa1OomxKU7s0eW+gNDoIhyhU/hGHyhVWxzVmOr84LEeTP8rHAQMkw3r7AMoWsbzqKrAZKEvIm/0ist6Zzc8ufmqT6re598BqkCQQDQBF4nUp8ykuIsQqe+Fbh/wJSZ0UZaHW9/7A89cG7r0qEllPRWg73wls+VVvq4SujWpn4YFEP6Go5oR4Gax5RPAkEAz+oQnQgv+YlyDjNvxR8bgEx08Ihd+ocoiq/2BMNBoxq/2or2vnMV5wcpZmRTOsK2LPiKkJrUzS8fX0bJ9yhnzwJAX51iWdjUbD6vz4Bj8i+xuqcepwVWvR1Cnx42cxs3IRaUE94/4XR03h20FQUCAawNEn09AHxwMon6Y1xa6nZKaQJAUgCHPOgVw92p1mADHUP/nMKK/LNMHZthKhHsfkRkhuft80wLtWG+qbfxZCj9ipdxMpt0S0RF2gdT4EgTMCAHkQJAQwmHU7rYjG6iWzXXxDsjYCxFoWX51nVq68PN5khztWYk/VQoW6SWLvHV73Wykht+vfLg6IXXgz5zJfzBJFLkYA==";

    @Test
    public void test() throws Exception {
        Map<String, String> keyMap = RSAUtil.initRSAKey();

        String privateKey = keyMap.get("privateKey");
        String publicKey = keyMap.get("publicKey");

        String data = "hello world";
        String encryptData = RSAUtil.encrypt(data, publicKey);
        Assert.assertNotNull(encryptData);
        System.out.println("encryptData: " + encryptData);

        String decryptData = RSAUtil.decrypt(encryptData, privateKey);
        Assert.assertNotNull(decryptData);
        System.out.println("decryptData: " + decryptData);
    }

    @Test
    public void test1() throws Exception {
        String encryptData = "FD-NJzhZTz3fkdhjK_DQe9zsxnFf3mWnl1frEOhbdSHo4OFsKH6p-ipkiejPidXlWwlMfJcEdrKNnhyjbovqisVbeTM9wIFhQ9SIr-rALCB6CsT67GVUCW8aP5vf8KknN_P0mHdytrI83pErNt0Ac-0qKWCmiCLgpEJa0ZzqcTk";
        String decryptData = RSAUtil.decrypt(encryptData, privateKey);
        Assert.assertNotNull(decryptData);
        System.out.println("decryptData: " + decryptData);
    }

    @Test
    public void test2() throws Exception{
        String data = "65446256500907075219156256997425";

        String encryptData = RSAUtil.encrypt(data, publicKey);

        System.out.println(encryptData);
    }

}
