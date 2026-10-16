package com.ironsource.mediationsdk.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.ironsource.C3193m5;
import com.ironsource.C3260q4;
import com.ironsource.H9;
import com.ironsource.mediationsdk.logger.IronLog;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

@Deprecated
/* loaded from: classes6.dex */
public class IronSourceAES {
    private static SecretKeySpec a(String str) throws UnsupportedEncodingException {
        byte[] bArr = new byte[32];
        Arrays.fill(bArr, (byte) 0);
        byte[] bytes = str.getBytes("UTF-8");
        System.arraycopy(bytes, 0, bArr, 0, bytes.length < 32 ? bytes.length : 32);
        return new SecretKeySpec(bArr, "AES");
    }

    public static synchronized String compressAndEncrypt(String str) {
        String compressAndEncrypt;
        synchronized (IronSourceAES.class) {
            compressAndEncrypt = compressAndEncrypt(C3193m5.b().c(), str);
        }
        return compressAndEncrypt;
    }

    public static synchronized String decode(String str, String str2) {
        synchronized (IronSourceAES.class) {
            byte[] decodeToBytes = decodeToBytes(str, str2);
            if (decodeToBytes == null) {
                return "";
            }
            return new String(decodeToBytes);
        }
    }

    public static synchronized byte[] decodeToBytes(String str, String str2) {
        synchronized (IronSourceAES.class) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            try {
                SecretKeySpec a2 = a(str);
                byte[] bArr = new byte[16];
                Arrays.fill(bArr, (byte) 0);
                IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
                byte[] decode = Base64.decode(str2, 0);
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
                cipher.init(2, a2, ivParameterSpec);
                return cipher.doFinal(decode);
            } catch (Exception e) {
                C3260q4.d().a(e);
                IronLog.INTERNAL.error("exception on decryption error: " + e.getMessage());
                return null;
            }
        }
    }

    public static synchronized String decryptAndDecompress(String str) {
        String decryptAndDecompress;
        synchronized (IronSourceAES.class) {
            decryptAndDecompress = decryptAndDecompress(C3193m5.b().c(), str);
        }
        return decryptAndDecompress;
    }

    public static synchronized String encode(String str, String str2) {
        synchronized (IronSourceAES.class) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (TextUtils.isEmpty(str2)) {
                return "";
            }
            try {
                return encodeFromBytes(str, str2.getBytes("UTF8"));
            } catch (Exception e) {
                C3260q4.d().a(e);
                IronLog.INTERNAL.error(e.toString());
                return "";
            }
        }
    }

    public static synchronized String encodeFromBytes(String str, byte[] bArr) {
        synchronized (IronSourceAES.class) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (bArr == null) {
                return "";
            }
            try {
                SecretKeySpec a2 = a(str);
                byte[] bArr2 = new byte[16];
                Arrays.fill(bArr2, (byte) 0);
                IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
                cipher.init(1, a2, ivParameterSpec);
                return Base64.encodeToString(cipher.doFinal(bArr), 0).replaceAll(System.getProperty("line.separator"), "");
            } catch (Exception e) {
                C3260q4.d().a(e);
                IronLog.INTERNAL.error(e.toString());
                return "";
            }
        }
    }

    public static synchronized String encrypt(String str) {
        String encode;
        synchronized (IronSourceAES.class) {
            encode = encode(C3193m5.b().c(), str);
        }
        return encode;
    }

    public static synchronized String compressAndEncrypt(String str, String str2) {
        synchronized (IronSourceAES.class) {
            if (TextUtils.isEmpty(str2)) {
                return "";
            }
            try {
                byte[] a2 = H9.a(str2);
                if (a2 != null) {
                    return encodeFromBytes(str, a2);
                }
            } catch (Exception e) {
                C3260q4.d().a(e);
                IronLog.INTERNAL.error(e.toString());
            }
            return "";
        }
    }

    public static synchronized String decryptAndDecompress(String str, String str2) {
        synchronized (IronSourceAES.class) {
            if (TextUtils.isEmpty(str2)) {
                return "";
            }
            try {
                byte[] decodeToBytes = decodeToBytes(str, str2);
                if (decodeToBytes != null) {
                    return H9.a(decodeToBytes);
                }
            } catch (Exception e) {
                C3260q4.d().a(e);
                IronLog.INTERNAL.error(e.toString());
            }
            return "";
        }
    }
}
