package com.bykv.vk.openvk.preload.geckox.utils;

import com.google.common.base.Ascii;
import com.mbridge.msdk.foundation.tools.SameMD5;
import io.ktor.util.date.GMTDateParser;
import java.io.InputStream;
import java.security.MessageDigest;

/* compiled from: MD5Utils.java */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static char[] f979a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', GMTDateParser.DAY_OF_MONTH, 'e', 'f'};

    public static void a(InputStream inputStream, String str) throws Exception {
        if (str == null) {
            throw new RuntimeException("md5 check failed: md5 == null");
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(SameMD5.TAG);
            try {
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = inputStream.read(bArr, 0, 4096);
                        if (read == -1) {
                            break;
                        } else {
                            messageDigest.update(bArr, 0, read);
                        }
                    }
                    try {
                        byte[] digest = messageDigest.digest();
                        String a2 = a(digest, digest.length);
                        if (!str.equals(a2)) {
                            throw new RuntimeException("md5 check failed file: local md5:" + a2 + " expect md5:" + str);
                        }
                    } catch (Exception e) {
                        throw new RuntimeException("md5 check failed:" + e.getMessage(), e);
                    }
                } catch (Exception e2) {
                    throw new RuntimeException("md5 check failed:" + e2.getMessage(), e2);
                }
            } finally {
                CloseableUtils.close(inputStream);
            }
        } catch (Exception e3) {
            throw new RuntimeException("md5 check failed:" + e3.getMessage(), e3);
        }
    }

    private static String a(byte[] bArr, int i) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        if (i > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i2 = i << 1;
        char[] cArr = new char[i2];
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            byte b = bArr[i4];
            int i5 = i3 + 1;
            char[] cArr2 = f979a;
            cArr[i3] = cArr2[(b & 255) >> 4];
            i3 += 2;
            cArr[i5] = cArr2[b & Ascii.SI];
        }
        return new String(cArr, 0, i2);
    }
}
