package services;

import android.support.annotation.Nullable;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class EncodeDecodeAES {

    // Use byte array to build SEED = ".dees ym si siht";
    public final static String SEED = new String(new byte[]{'.', 'd', 'e', 'e', 's', ' ', 'y', 'm', ' ', 's', 'i', ' ', 's', 'i', 'h', 't'});
    public static final String HEX_VALUE = "0123456789ABCDEF";
    private final static int JELLY_BEAN_4_2 = 17;
    private final static byte[] key = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private String seed;

    private EncodeDecodeAES(String realSeed) {
        this.seed = realSeed;
    }

    public static EncodeDecodeAES defaultDecoder() {
        return new EncodeDecodeAES(SEED);
    }

    public static EncodeDecodeAES userDecoder(String deviceId, String username) {
        return new EncodeDecodeAES(deviceId + username);
    }

    public String encrypt(@Nullable String clearText) throws GeneralSecurityException {
        if (clearText == null) {
            return clearText;
        }

        byte[] result = encrypt(clearText.getBytes());
        return toHex(result);
    }

    public byte[] encrypt(@Nullable byte[] data) throws GeneralSecurityException {
        if (data == null) {
            return data;
        }

        byte[] rawKey = getRawKey(seed.getBytes());
        return encrypt(rawKey, data);
    }

    private String decrypt(String seed, String encrypted) throws GeneralSecurityException {
        byte[] enc = toByte(encrypted);
        return new String(decrypt(enc));
    }

    public byte[] decrypt(@Nullable byte[] enc) throws GeneralSecurityException {
        if (enc == null) {
            return enc;
        }
        byte[] seedByte = seed.getBytes();
        System.arraycopy(seedByte, 0, key, 0, ((seedByte.length < 16) ? seedByte.length : 16));
        byte[] rawKey = getRawKey(seedByte);
        return decrypt(rawKey, enc);
    }

    public String decrypt(@Nullable String encrypted) throws GeneralSecurityException {
        if (encrypted == null) {
            return encrypted;
        }
        return decrypt(seed, encrypted);
    }

    private byte[] getRawKey(byte[] seed) throws NoSuchAlgorithmException, NoSuchProviderException {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom sr;
        if (android.os.Build.VERSION.SDK_INT >= JELLY_BEAN_4_2) {
            sr = SecureRandom.getInstance("SHA1PRNG", "Crypto");
        } else {
            sr = SecureRandom.getInstance("SHA1PRNG");
        }
        sr.setSeed(seed);
        try {
            kgen.init(256, sr);
        } catch (Exception e) {
            try {
                kgen.init(192, sr);
            } catch (Exception e1) {
                kgen.init(128, sr);
            }
        }
        SecretKey skey = kgen.generateKey();
        return skey.getEncoded();
    }

    private byte[] encrypt(byte[] raw, byte[] clear) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        return cipher.doFinal(clear);
    }

    private byte[] decrypt(byte[] raw, byte[] encrypted) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        return cipher.doFinal(encrypted);
    }

    public byte[] toByte(String hexString) {
        int len = hexString.length() / 2;
        byte[] result = new byte[len];
        for (int i = 0; i < len; i++)
            result[i] = Integer.valueOf(hexString.substring(2 * i, 2 * i + 2), 16).byteValue();
        return result;
    }

    public String toHex(byte[] buf) {
        if (buf == null)
            return "";
        StringBuffer result = new StringBuffer(2 * buf.length);
        for (byte aBuf : buf) {
            appendHex(result, aBuf);
        }
        return result.toString();
    }

    private void appendHex(StringBuffer sb, byte b) {
        sb.append(HEX_VALUE.charAt((b >> 4) & 0x0f)).append(HEX_VALUE.charAt(b & 0x0f));
    }
}
