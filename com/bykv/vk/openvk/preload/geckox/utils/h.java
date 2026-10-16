package com.bykv.vk.openvk.preload.geckox.utils;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: UnZipUtils.java */
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private static byte[] f981a = {80, 75, 3, 4};
    private static byte[] b = {80, 75, 5, 6};

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.Closeable, java.io.FileOutputStream, java.io.OutputStream] */
    public static void a(InputStream inputStream, String str, String str2) throws Exception {
        ZipInputStream zipInputStream = null;
        try {
            String canonicalPath = new File(str).getCanonicalPath();
            ZipInputStream zipInputStream2 = new ZipInputStream(inputStream);
            boolean z = false;
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream2.getNextEntry();
                    if (nextEntry == null) {
                        if (!z) {
                            inputStream.reset();
                            if (!a(inputStream)) {
                                throw new RuntimeException("not zip file  channel:".concat(String.valueOf(str2)));
                            }
                            throw new RuntimeException("unzip file: channel:".concat(String.valueOf(str2)));
                        }
                        CloseableUtils.close(zipInputStream2);
                        return;
                    }
                    String name = nextEntry.getName();
                    if (!name.startsWith("__MACOSX/") && !name.equals(".DS_Store") && !name.contains("../")) {
                        if (!name.startsWith(str2 + File.separator)) {
                            throw new RuntimeException("the zip package outermost folder is not named by channel channel:".concat(String.valueOf(str2)));
                        }
                        if (nextEntry.isDirectory()) {
                            File file = new File(canonicalPath, name);
                            if (!file.getCanonicalPath().startsWith(canonicalPath)) {
                                throw new RuntimeException("directory traversal, dir:" + name + ", channel:" + str2);
                            }
                            file.mkdirs();
                        } else {
                            String canonicalPath2 = new File(canonicalPath, name).getCanonicalPath();
                            if (!canonicalPath2.startsWith(canonicalPath)) {
                                throw new RuntimeException("directory traversal, file name:".concat(String.valueOf(name)));
                            }
                            File file2 = new File(canonicalPath2);
                            file2.getParentFile().mkdirs();
                            try {
                                ?? fileOutputStream = new FileOutputStream(file2);
                                try {
                                    b.a(zipInputStream2, fileOutputStream);
                                    CloseableUtils.close((Closeable) fileOutputStream);
                                } catch (Throwable th) {
                                    th = th;
                                    zipInputStream = fileOutputStream;
                                    CloseableUtils.close(zipInputStream);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                    }
                    z = true;
                } catch (Throwable th3) {
                    th = th3;
                    zipInputStream = zipInputStream2;
                    CloseableUtils.close(zipInputStream);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
    
        if (java.util.Arrays.equals(com.bykv.vk.openvk.preload.geckox.utils.h.b, r1) != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean a(InputStream inputStream) throws Exception {
        try {
            byte[] bArr = new byte[4];
            boolean z = false;
            if (inputStream.read(bArr, 0, 4) != 4) {
                return false;
            }
            if (!Arrays.equals(f981a, bArr)) {
            }
            z = true;
            return z;
        } finally {
            CloseableUtils.close(inputStream);
        }
    }
}
