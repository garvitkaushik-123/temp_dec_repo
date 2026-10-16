package com.pgl.ssdk;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipFile;

/* loaded from: classes6.dex */
public class s0 {
    public static boolean a(String str) {
        return new File(str).mkdirs();
    }

    public static void a(String str, int i) {
        t0.a("android.os.FileUtils", str, Integer.valueOf(i), -1, -1);
    }

    public static void a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static void a(ZipFile zipFile) {
        if (zipFile == null) {
            return;
        }
        try {
            zipFile.close();
        } catch (IOException unused) {
        }
    }
}
