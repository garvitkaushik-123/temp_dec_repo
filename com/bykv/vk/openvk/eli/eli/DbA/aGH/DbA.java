package com.bykv.vk.openvk.eli.eli.DbA.aGH;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes3.dex */
public class DbA {
    public static long eli(String str, String str2) {
        File Os = Os(str, str2);
        if (Os.exists()) {
            return Os.length();
        }
        File DbA = DbA(str, str2);
        if (DbA.exists()) {
            return DbA.length();
        }
        return 0L;
    }

    public static File DbA(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str2 + ".temp");
    }

    public static File Os(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str2);
    }

    public static void eli(RandomAccessFile randomAccessFile, byte[] bArr, int i, int i2, String str) throws IOException {
        try {
            randomAccessFile.seek(i);
            randomAccessFile.write(bArr, 0, i2);
        } catch (Throwable unused) {
        }
    }
}
