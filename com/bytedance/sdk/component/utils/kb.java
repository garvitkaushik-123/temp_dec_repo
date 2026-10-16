package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes3.dex */
public class kb {
    public static File eli(Context context, boolean z, String str, String str2) {
        String DbA = DbA(context);
        if (z) {
            str = eli(context) + "-" + str;
        }
        if (DbA != null && !DbA.endsWith(File.separator)) {
            DbA = DbA + File.separator;
        }
        String str3 = DbA + str;
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str3, str2);
    }

    public static File eli(Context context, boolean z, String str) {
        String absolutePath = context.getCacheDir().getAbsolutePath();
        if (z) {
            str = eli(context) + "-" + str;
        }
        if (absolutePath != null && !absolutePath.endsWith(File.separator)) {
            absolutePath = absolutePath + File.separator;
        }
        File file = new File(absolutePath + str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static String DbA(Context context) {
        File cacheDir;
        if (context == null || (cacheDir = context.getCacheDir()) == null) {
            return null;
        }
        return cacheDir.getPath();
    }

    public static List<File> eli(File file) {
        LinkedList linkedList = new LinkedList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return linkedList;
        }
        List<File> asList = Arrays.asList(listFiles);
        Collections.sort(asList, new eli(null));
        return asList;
    }

    public static void DbA(File file) throws IOException {
        if (file.exists()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (file.setLastModified(currentTimeMillis)) {
                return;
            }
            ui(file);
            if (file.lastModified() < currentTimeMillis) {
                new StringBuilder("Last modified date ").append(new Date(file.lastModified()));
                file.getAbsolutePath();
            }
        }
    }

    public static void Os(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        try {
            if (file.isFile()) {
                file.delete();
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        Os(file2);
                    } else {
                        try {
                            file2.delete();
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
            file.delete();
        } catch (Throwable unused2) {
        }
    }

    private static void ui(File file) throws IOException {
        RandomAccessFile randomAccessFile;
        long j;
        long length = file.length();
        if (length == 0) {
            MGA(file);
            return;
        }
        try {
            randomAccessFile = new RandomAccessFile(file, "rwd");
            j = length - 1;
        } catch (Throwable unused) {
            randomAccessFile = null;
        }
        try {
            randomAccessFile.seek(j);
            byte readByte = randomAccessFile.readByte();
            randomAccessFile.seek(j);
            randomAccessFile.write(readByte);
            randomAccessFile.close();
        } catch (Throwable unused2) {
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
        }
    }

    private static void MGA(File file) throws IOException {
        if (!file.delete() || !file.createNewFile()) {
            throw new IOException("Error recreate zero-size file ".concat(String.valueOf(file)));
        }
    }

    private static final class eli implements Comparator<File> {
        private int eli(long j, long j2) {
            if (j < j2) {
                return -1;
            }
            return j == j2 ? 0 : 1;
        }

        private eli() {
        }

        /* synthetic */ eli(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.Comparator
        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return eli(file.lastModified(), file2.lastModified());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0048, code lost:
    
        if (r2 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] aGH(File file) {
        FileInputStream fileInputStream;
        if (file != null && file.isFile() && file.exists() && file.canRead() && file.length() > 0) {
            try {
                Long valueOf = Long.valueOf(file.length());
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[valueOf.intValue()];
                    if (fileInputStream.read(bArr) == valueOf.longValue()) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused) {
                        }
                        return bArr;
                    }
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
                fileInputStream = null;
            }
            try {
                fileInputStream.close();
            } catch (Throwable unused4) {
            }
        }
        return null;
    }

    /* renamed from: com.bytedance.sdk.component.utils.kb$1, reason: invalid class name */
    static class AnonymousClass1 implements Comparator<File> {
        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(File file, File file2) {
            throw null;
        }
    }

    public static String eli(Context context) {
        String eli2 = CMM.eli(context);
        return (TextUtils.isEmpty(eli2) || !eli2.contains(":")) ? eli2 : eli2.replace(":", "-");
    }
}
