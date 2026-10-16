package com.apm.insight.h;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.apm.insight.l.f;
import com.google.firebase.sessions.settings.RemoteSettings;
import dalvik.system.BaseDexClassLoader;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: SafelyLibraryLoader.java */
/* loaded from: classes2.dex */
public class c {
    static {
        new ArrayList();
    }

    public static String a(Context context, String str, File file) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String a2 = a(applicationInfo.sourceDir, str, file);
        if (a2 == null) {
            return null;
        }
        for (String str2 : applicationInfo.splitSourceDirs) {
            a2 = a(str2, str, file);
            if (a2 == null) {
                return null;
            }
        }
        try {
            ClassLoader classLoader = c.class.getClassLoader();
            while (!(classLoader instanceof BaseDexClassLoader) && classLoader.getParent() != null) {
                classLoader = classLoader.getParent();
            }
            if (!(classLoader instanceof BaseDexClassLoader)) {
                return a2;
            }
            Field declaredField = BaseDexClassLoader.class.getDeclaredField("pathList");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(classLoader);
            Field declaredField2 = obj.getClass().getDeclaredField("nativeLibraryDirectories");
            declaredField2.setAccessible(true);
            for (String str3 : (String[]) declaredField2.get(obj)) {
                File file2 = new File(str3, System.mapLibraryName(str));
                if (file2.exists()) {
                    f.a(file2, file);
                    com.apm.insight.a.a(file.getAbsolutePath());
                    return null;
                }
            }
            return "not_found";
        } catch (Throwable th) {
            return th.getMessage();
        }
    }

    private static String a(String str, String str2, File file) {
        InputStream inputStream;
        ZipFile zipFile;
        String message;
        ZipEntry entry;
        FileOutputStream fileOutputStream = null;
        try {
            zipFile = new ZipFile(new File(str), 1);
            try {
                entry = zipFile.getEntry("lib/" + Build.CPU_ABI + RemoteSettings.FORWARD_SLASH_STRING + System.mapLibraryName(str2));
            } catch (Throwable th) {
                th = th;
                inputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            zipFile = null;
        }
        if (entry == null) {
            int indexOf = Build.CPU_ABI.indexOf(45);
            StringBuilder sb = new StringBuilder("lib/");
            String str3 = Build.CPU_ABI;
            if (indexOf <= 0) {
                indexOf = Build.CPU_ABI.length();
            }
            String sb2 = sb.append(str3.substring(0, indexOf)).append(RemoteSettings.FORWARD_SLASH_STRING).append(System.mapLibraryName(str2)).toString();
            ZipEntry entry2 = zipFile.getEntry(sb2);
            if (entry2 == null) {
                message = "Library entry not found:".concat(String.valueOf(sb2));
                com.apm.insight.a.a((Closeable) null);
                com.apm.insight.a.a((Closeable) null);
                com.apm.insight.a.a(zipFile);
                return message;
            }
            entry = entry2;
        }
        file.createNewFile();
        InputStream inputStream2 = zipFile.getInputStream(entry);
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = inputStream2.read(bArr);
                    if (read <= 0) {
                        com.apm.insight.a.a(file.getAbsolutePath());
                        com.apm.insight.a.a((Closeable) fileOutputStream2);
                        com.apm.insight.a.a((Closeable) inputStream2);
                        com.apm.insight.a.a(zipFile);
                        return null;
                    }
                    fileOutputStream2.write(bArr, 0, read);
                }
            } catch (Throwable th3) {
                fileOutputStream = fileOutputStream2;
                inputStream = inputStream2;
                th = th3;
                try {
                    message = th.getMessage();
                    com.apm.insight.a.a((Closeable) fileOutputStream);
                    com.apm.insight.a.a((Closeable) inputStream);
                    com.apm.insight.a.a(zipFile);
                    return message;
                } catch (Throwable th4) {
                    com.apm.insight.a.a((Closeable) fileOutputStream);
                    com.apm.insight.a.a((Closeable) inputStream);
                    com.apm.insight.a.a(zipFile);
                    throw th4;
                }
            }
        } catch (Throwable th5) {
            inputStream = inputStream2;
            th = th5;
        }
    }
}
