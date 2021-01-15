package sevenkey.open.utils.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class RSAUtil {
    private static final String encode = "UTF-8";

    public RSAUtil() {
    }

    public static String rsaSign(String priKey, Map<String, Object> params) throws OpenException {
        if (!StringUtils.isBlank(priKey) && params != null && params.size() != 0) {
            String src = paramConvertor(params);
            System.out.println("RSA私钥参数排序：=====>" + src);

            try {
                PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(priKey));
                KeyFactory fac = KeyFactory.getInstance("RSA");
                RSAPrivateKey privateKey = (RSAPrivateKey) fac.generatePrivate(keySpec);
                Signature sigEng = Signature.getInstance("SHA256WithRSA");
                sigEng.initSign(privateKey);
                sigEng.update(src.getBytes("UTF-8"));
                byte[] signature = sigEng.sign();
                return Base64.encodeBase64String(signature).replaceAll("\r|\n", "");
            } catch (Exception var8) {
                throw new OpenException("sign error");
            }
        } else {
            throw new OpenException("sign params can not be empty");
        }
    }

    public static boolean rsaSignVerify(String pubKey, Map<String, Object> params) throws OpenException {
        if (!StringUtils.isBlank(pubKey) && params != null && params.size() != 0) {
            Object sign = params.get("sign");
            if (sign != null && StringUtils.isBlank(sign.toString())) {
                throw new OpenException("sign can not be empty");
            } else {
                String src = paramConvertor(params);

                try {
                    X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.decodeBase64(pubKey));
                    KeyFactory fac = KeyFactory.getInstance("RSA");
                    RSAPublicKey rsaPubKey = (RSAPublicKey) fac.generatePublic(keySpec);
                    Signature sigEng = Signature.getInstance("SHA256WithRSA");
                    sigEng.initVerify(rsaPubKey);
                    sigEng.update(src.getBytes("UTF-8"));
                    byte[] signature = Base64.decodeBase64(sign.toString());
                    return sigEng.verify(signature);
                } catch (Exception var9) {
                    throw new OpenException("verify sign error");
                }
            }
        } else {
            throw new OpenException("sign params can not be empty");
        }
    }

    public static String encrypt(String data, String publicKey) throws OpenException {
        try {
            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKey));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            Key pubKey = keyFactory.generatePublic(x509KeySpec);
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(1, pubKey);
            return Base64.encodeBase64URLSafeString(cipher.doFinal(data.getBytes("UTF-8")));
        } catch (Exception var6) {
            throw new OpenException("RSA加密异常");
        }
    }

    public static String decrypt(String data, String privateKey) throws OpenException {
        try {
            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKey));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            Key priKey = keyFactory.generatePrivate(pkcs8KeySpec);
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(2, priKey);
            return new String(cipher.doFinal(Base64.decodeBase64(data)), "UTF-8");
        } catch (Exception var6) {
            throw new OpenException("RSA解密异常");
        }
    }


    public static String paramConvertor(Map<String, Object> paramMap) {
        TreeMap<String, Object> sortMap = new TreeMap(paramMap);
        if (sortMap.containsKey("sign")) {
            sortMap.remove("sign");
        }

        StringBuilder sb = new StringBuilder();
        Iterator var3 = sortMap.entrySet().iterator();

        while (var3.hasNext()) {
            Map.Entry<String, Object> entry = (Map.Entry) var3.next();
            sb.append((String) entry.getKey() + "=" + entry.getValue());
            sb.append("&");
        }

        String s = sb.toString();
        if (s.endsWith("&")) {
            s = StringUtils.substringBeforeLast(s, "&");
        }

        return s;
    }

    public static Map<String, String> initRSAKey() throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        KeyPair keyPair = kpg.generateKeyPair();
        Key publicKey = keyPair.getPublic();
        String publicKeyStr = Base64.encodeBase64URLSafeString(publicKey.getEncoded());
        Key privateKey = keyPair.getPrivate();
        String privateKeyStr = Base64.encodeBase64URLSafeString(privateKey.getEncoded());
        Map<String, String> keyPairMap = new HashMap();
        keyPairMap.put("publicKey", publicKeyStr);
        keyPairMap.put("privateKey", privateKeyStr);
        return keyPairMap;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("-----------------------------");
        Map<String, String> map = initRSAKey();
        System.out.println("---------------------dsd--------");
        System.out.println(map.toString());
        System.out.println("---------------------kkk--------");
    }
}
