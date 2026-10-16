package com.mbridge.msdk.foundation.tools;

import com.google.common.base.Ascii;
import io.ktor.util.date.GMTDateParser;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: SameFileMD5.java */
/* loaded from: classes6.dex */
public class m0 {

    /* renamed from: a, reason: collision with root package name */
    protected static char[] f4374a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', GMTDateParser.DAY_OF_MONTH, 'e', 'f'};
    protected static MessageDigest b = null;
    private static String c = "SameFileMD5";

    static {
        try {
            b = MessageDigest.getInstance(SameMD5.TAG);
        } catch (NoSuchAlgorithmException e) {
            System.err.println(m0.class.getName() + "初始化失败，MessageDigest不支持MD5Util.");
            e.printStackTrace();
        }
    }

    public static String a(File file) throws IOException {
        RandomAccessFile randomAccessFile;
        MessageDigest messageDigest;
        if (file == null || !file.exists()) {
            return "";
        }
        try {
            messageDigest = MessageDigest.getInstance(SameMD5.TAG);
            randomAccessFile = new RandomAccessFile(file, "r");
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        try {
            byte[] bArr = new byte[10485760];
            while (true) {
                int read = randomAccessFile.read(bArr);
                if (read == -1) {
                    String a2 = a(messageDigest.digest());
                    try {
                        randomAccessFile.close();
                        return a2;
                    } catch (IOException e) {
                        p0.b(c, e.getMessage());
                        return a2;
                    }
                }
                messageDigest.update(bArr, 0, read);
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                p0.b(c, th.getMessage());
                return "";
            } finally {
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e2) {
                        p0.b(c, e2.getMessage());
                    }
                }
            }
        }
    }

    private static String a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    private static String a(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer(i2 * 2);
        int i3 = i2 + i;
        while (i < i3) {
            a(bArr[i], stringBuffer);
            i++;
        }
        return stringBuffer.toString();
    }

    private static void a(byte b2, StringBuffer stringBuffer) {
        char[] cArr = f4374a;
        char c2 = cArr[(b2 & 240) >> 4];
        char c3 = cArr[b2 & Ascii.SI];
        stringBuffer.append(c2);
        stringBuffer.append(c3);
    }
}
