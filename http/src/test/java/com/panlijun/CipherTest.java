package com.panlijun;

import org.junit.Test;
import org.slf4j.Logger;
import sun.misc.IOUtils;
import sun.nio.ch.IOUtil;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import static org.slf4j.LoggerFactory.getLogger;

public class CipherTest {

    private final Logger log = getLogger(getClass());

    String publicKey = "MIGeMA0GCSqGSIb3DQEBAQUAA4GMADCBiAKBgGcXw8Q/altKcAzLmXTSrGvDjDol" +
            "SBe6fm2fIWB1gepVuSiCA3x0ZE6bkPPDFf/FLjMACDbbvCrLUgFrxJXoiUMvr3e9" +
            "Hu+ymC5xbtYBlhjHQ7gezF1D917J3XvyriVS+fJw3UKuXkA8CfIoTYiwckveDPr0" +
            "mQVDylG/vQyWbr1BAgMBAAE=";

    String privateKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGAZxfDxD9qW0pwDMuZ" +
            "dNKsa8OMOiVIF7p+bZ8hYHWB6lW5KIIDfHRkTpuQ88MV/8UuMwAINtu8KstSAWvE" +
            "leiJQy+vd70e77KYLnFu1gGWGMdDuB7MXUP3Xsnde/KuJVL58nDdQq5eQDwJ8ihN" +
            "iLByS94M+vSZBUPKUb+9DJZuvUECAwEAAQKBgCqKn/pHwPfTC9H74mNW3FfL5f3I" +
            "jKteBfXuiLNpSicNIM8ad53P2eSmRXaRtm5JS/s3tCwPGOL/6+MyOXky8BEGfD8G" +
            "Pga00i2k/L23xSG0dDXHQyooGUanRwjxJc19qpnT79TSLPsbu6oE3EnMxsi4GKoZ" +
            "EPvStu6RK3yWKA8BAkEAtza5zuUsZyrkWfUd6cbRgjdyn3XvmP7QjqUNL2SnkQwo" +
            "ClMRlXciwi90fSnAxMDL6+grECZSNBl3ZBWyJRYR2QJBAJAMjK77gU7m7H/OgmWO" +
            "Shgy1YACnxZvWPN9V+3SCuHsW0hsC3D1OfFwuDOeUn5fsuv1dgYxmjmn+wisfHeW" +
            "fakCQQCslcGsUpdkS7Q1xT+7Yw0ic+bmrWrZHVgKtxHXjiKG8QOazitnN4WnlJpP" +
            "+Q/ch5zQibBfEyomZ8Lepc1dQA/pAkBEl6U6AYsObkm5hjVzdHD12ubtQNJOVZEu" +
            "yMXg+f6ym+DPuJsuG6eOv5UHB2HSyXEiiMy9oEsHH2UbOT8/lsqZAkAN1wFiPegj" +
            "0yoJYQTTXFyoAkkp47As0gsdu3yJpIBchXB7SkXWANFgYHw102ShN/0TZo3cvL8T" +
            "HmxS4ClzXspF";

    String content = "明文数据";

    @Test
    public void should_obtain_publicKey_by_public_cipher() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance("RSA");

        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(publicKey));
        PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(x509EncodedKeySpec);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] bytes = rsaSplitCodec(cipher, Cipher.ENCRYPT_MODE, content.getBytes(), 1024);

        System.out.println(new String(bytes));
        System.out.println(Base64.getEncoder().encodeToString(bytes));

    }

    @Test
    public void should_decrypt_by_private_key() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException {
        String decryptData = "RWzKd40rgRrkqJlTLNBimVhHqVRnySMeNLpQcN5YJcHytusphiOoCPnNOlOSClXsX43eEBhD/w7orfJV0m5TiEMcf42s13tMpxWbl+jGZwNGnwTyFfMelHtIODWM+D76U1peY6mPtDtbSv3gUHSqhFQbNWa6tMca6dyAy7iz788=";
        Cipher cipher = Cipher.getInstance("RSA");
        
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey));
        PrivateKey privateKey = KeyFactory.getInstance("RSA").generatePrivate(pkcs8EncodedKeySpec);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        byte[] bytes = rsaSplitCodec(cipher, Cipher.DECRYPT_MODE, Base64.getDecoder().decode(decryptData), 1024);

        System.out.println(new String(bytes));

    }

    @Test
    public void should_sign_with_private_key() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {

        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey));
        PrivateKey privateKey = KeyFactory.getInstance("RSA").generatePrivate(pkcs8EncodedKeySpec);

        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(content.getBytes());
        byte[] sign = signature.sign();
        System.out.println(Base64.getEncoder().encodeToString(sign));
    }

    @Test
    public void should_valid_with_public_key() throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
        String sign = "MW44va8ib5JwN/89ZOnodcfnjPKOuPV8qbiLGmsXk7cB6d2EaBlhFeoNzksglHllVl9DkLMEpVmTc43qauzOhxojizjCrXXwGIu5pr7sH+VOYsa2KveAGebgboXGmoOqsnBYPkKwtYkmvB4IK4toYbPTpBF8nh5GaPzxeq0/gHY=";
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(publicKey));
        PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(x509EncodedKeySpec);
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(publicKey);
        signature.update(content.getBytes());
        boolean verify = signature.verify(Base64.getDecoder().decode(sign.getBytes()));
        System.out.println(verify);


    }

    private static byte[] rsaSplitCodec(Cipher cipher, int opmode, byte[] datas, int keySize){
        int maxBlock = 0;

        System.out.println(cipher.getBlockSize());
        if(opmode == Cipher.DECRYPT_MODE){
            maxBlock = keySize / 8;
        }else{
            maxBlock = keySize / 8 - 11;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] buff;
        int i = 0;
        try{
            while(datas.length > offSet){
                if(datas.length-offSet > maxBlock){
                    buff = cipher.doFinal(datas, offSet, maxBlock);
                }else{
                    buff = cipher.doFinal(datas, offSet, datas.length-offSet);
                }
                out.write(buff, 0, buff.length);
                i++;
                offSet = i * maxBlock;
            }
        }catch(Exception e){
            throw new RuntimeException("加解密阀值为["+maxBlock+"]的数据时发生异常", e);
        }
        byte[] resultDatas = out.toByteArray();
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultDatas;
    }
}
