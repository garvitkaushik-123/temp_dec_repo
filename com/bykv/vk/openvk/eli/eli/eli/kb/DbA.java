package com.bykv.vk.openvk.eli.eli.eli.kb;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes3.dex */
public class DbA {
    private static final MessageDigest eli = eli();
    private static final char[] DbA = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private DbA() {
    }

    private static MessageDigest eli() {
        try {
            return MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static String eli(String str) {
        byte[] digest;
        MessageDigest messageDigest = eli;
        if (messageDigest == null || TextUtils.isEmpty(str)) {
            return "";
        }
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        synchronized (DbA.class) {
            digest = messageDigest.digest(bytes);
        }
        return eli(digest);
    }

    public static String eli(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length << 1];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = DbA;
            cArr[i] = cArr2[(b & 240) >> 4];
            i += 2;
            cArr[i2] = cArr2[b & Ascii.SI];
        }
        return new String(cArr);
    }
}
