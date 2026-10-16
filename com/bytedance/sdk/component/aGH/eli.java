package com.bytedance.sdk.component.aGH;

import android.text.TextUtils;
import android.util.Base64;
import com.ironsource.D5;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public class eli {
    private static String eli;

    public static String eli(String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            if (TextUtils.isEmpty(eli)) {
                eli = eli("AES/CBC/PKCS5Padding");
            }
            Cipher cipher = Cipher.getInstance(eli);
            cipher.init(1, secretKeySpec);
            return Base64.encodeToString(cipher.doFinal(str.getBytes(D5.N)), 0);
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }

    public static String eli(String str, String str2, String str3) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), "AES");
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(str2.getBytes()));
            return Base64.encodeToString(cipher.doFinal(str.getBytes(D5.N)), 0);
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }

    public static String DbA(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(str2.getBytes()));
            return new String(cipher.doFinal(decode));
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }

    public static String DbA(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            if (TextUtils.isEmpty(eli)) {
                eli = eli("AES/CBC/PKCS5Padding");
            }
            Cipher cipher = Cipher.getInstance(eli);
            cipher.init(2, secretKeySpec);
            return new String(cipher.doFinal(decode));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String eli(String str) {
        int[] iArr = new int[str.length()];
        iArr[4] = 6;
        iArr[5] = 1;
        iArr[6] = 1;
        return new String(eli(str.getBytes(), iArr));
    }

    public static byte[] eli(byte[] bArr, int[] iArr) {
        if (bArr == null || bArr.length == 0 || iArr == null || iArr.length == 0) {
            return bArr;
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = (byte) (bArr[i] ^ iArr[i % iArr.length]);
        }
        return bArr2;
    }
}
