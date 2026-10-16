package com.bytedance.sdk.component.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes3.dex */
public class VM {
    public static List<File> eli(String str, String str2) throws IOException {
        return eli(str, str2, (String) null);
    }

    public static List<File> eli(String str, String str2, String str3) throws IOException {
        return eli(eli(str), eli(str2), str3);
    }

    public static List<File> eli(File file, File file2, String str) throws IOException {
        if (file == null || file2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(file);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        try {
            if (DbA(str)) {
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    String name = nextElement.getName();
                    if (name.contains("../")) {
                        new StringBuilder("entryName: ").append(name);
                    } else if (!eli(file2, arrayList, zipFile, nextElement, name)) {
                        return arrayList;
                    }
                }
            } else {
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement2 = entries.nextElement();
                    String name2 = nextElement2.getName();
                    if (name2.contains("../")) {
                        new StringBuilder("entryName: ").append(name2);
                    } else if (name2.contains(str) && !eli(file2, arrayList, zipFile, nextElement2, name2)) {
                        return arrayList;
                    }
                }
            }
            return arrayList;
        } finally {
            zipFile.close();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean eli(File file, List<File> list, ZipFile zipFile, ZipEntry zipEntry, String str) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        BufferedInputStream bufferedInputStream;
        Throwable th;
        File file2 = new File(file, str);
        list.add(file2);
        if (zipEntry.isDirectory()) {
            return eli(file2);
        }
        if (!DbA(file2)) {
            return false;
        }
        try {
            fileOutputStream = new FileOutputStream(file2);
            try {
                bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                try {
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                    try {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int read = bufferedInputStream.read(bArr);
                            if (read != -1) {
                                bufferedOutputStream.write(bArr, 0, read);
                            } else {
                                bufferedInputStream.close();
                                bufferedOutputStream.close();
                                fileOutputStream.close();
                                return true;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream = null;
                    th = th;
                    if (bufferedInputStream != null) {
                    }
                    if (bufferedOutputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedOutputStream = null;
                bufferedInputStream = null;
            }
        } catch (Throwable th5) {
            th = th5;
            bufferedOutputStream = null;
            fileOutputStream = null;
            bufferedInputStream = null;
        }
    }

    private static boolean eli(File file) {
        if (file != null) {
            return file.exists() ? file.isDirectory() : file.mkdirs();
        }
        return false;
    }

    private static boolean DbA(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (!eli(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (Throwable unused) {
            return false;
        }
    }

    private static File eli(String str) {
        if (DbA(str)) {
            return null;
        }
        return new File(str);
    }

    private static boolean DbA(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
