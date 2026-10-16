package com.apm.insight.l;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: Device.java */
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f289a = false;
    private static int b = -1;
    private static final Pattern c = Pattern.compile("^0-([\\d]+)$");

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = b("ro.build.version.emui");
        }
        if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.getDefault()).startsWith("emotionui")) {
            return e();
        }
        return true;
    }

    public static String a() {
        return b("ro.build.version.emui");
    }

    private static String b(String str) {
        BufferedReader bufferedReader;
        String str2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), 1024);
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            str2 = bufferedReader.readLine();
            bufferedReader.close();
            com.apm.insight.a.a((Closeable) bufferedReader);
            return str2;
        } catch (Throwable unused2) {
            com.apm.insight.a.a((Closeable) bufferedReader);
            return str2;
        }
    }

    private static boolean e() {
        try {
            if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase(Locale.getDefault()).startsWith("huawei")) {
                if (TextUtils.isEmpty(Build.MANUFACTURER)) {
                    return false;
                }
                if (!Build.MANUFACTURER.toLowerCase(Locale.getDefault()).startsWith("huawei")) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean b() {
        if (!f289a) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    com.apm.insight.k.e.f277a = true;
                    f289a = true;
                    return com.apm.insight.k.e.f277a;
                }
            } catch (Exception unused) {
            }
            f289a = true;
        }
        return com.apm.insight.k.e.f277a;
    }

    public static boolean c() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static int d() {
        int i = b;
        if (i > 0) {
            return i;
        }
        int c2 = c("/sys/devices/system/cpu/possible");
        if (c2 <= 0) {
            c2 = c("/sys/devices/system/cpu/present");
        }
        if (c2 <= 0) {
            c2 = e("/sys/devices/system/cpu/");
        }
        if (c2 <= 0) {
            c2 = Runtime.getRuntime().availableProcessors();
        }
        if (c2 <= 0) {
            c2 = 1;
        }
        b = c2;
        return c2;
    }

    private static int c(String str) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                int d = d(readLine);
                try {
                    bufferedReader.close();
                } catch (IOException unused2) {
                }
                return d;
            }
        } catch (Throwable unused3) {
            if (bufferedReader == null) {
                return -1;
            }
            bufferedReader.close();
            return -1;
        }
        try {
            bufferedReader.close();
            return -1;
        } catch (IOException unused4) {
            return -1;
        }
    }

    private static int d(String str) {
        Matcher matcher = c.matcher(str);
        if (!matcher.matches()) {
            return -1;
        }
        try {
            return Integer.parseInt(matcher.group(1)) + 1;
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private static int e(String str) {
        try {
            File[] listFiles = new File(str).listFiles(new FilenameFilter() { // from class: com.apm.insight.l.d.1

                /* renamed from: a, reason: collision with root package name */
                private final Pattern f290a = Pattern.compile("^cpu[\\d]+$");

                @Override // java.io.FilenameFilter
                public final boolean accept(File file, String str2) {
                    return this.f290a.matcher(str2).matches();
                }
            });
            if (listFiles == null || listFiles.length <= 0) {
                return -1;
            }
            return listFiles.length;
        } catch (Throwable unused) {
            return -1;
        }
    }
}
