package com.apm.insight.l;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.util.Locale;

/* compiled from: RomUtils.java */
/* loaded from: classes2.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    private static final CharSequence f299a = "amigo";
    private static final CharSequence b = "funtouch";

    public static String a() {
        if (d.b()) {
            return d.b() ? "miui_" + a("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL : "";
        }
        if (!d.c()) {
            if (b()) {
                return b() ? "coloros_" + a("ro.build.version.opporom") + "_" + Build.DISPLAY : "";
            }
            String a2 = d.a();
            String str = (a2 == null || !a2.toLowerCase(Locale.getDefault()).contains("emotionui")) ? "" : a2 + "_" + Build.DISPLAY;
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            String a3 = a("ro.vivo.os.build.display.id");
            if (!TextUtils.isEmpty(a3) && a3.toLowerCase(Locale.getDefault()).contains(b)) {
                return a("ro.vivo.os.build.display.id") + "_" + a("ro.vivo.product.version");
            }
            if (!TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase(Locale.getDefault()).contains(f299a)) {
                return Build.DISPLAY + "_" + a("ro.gn.sv.version");
            }
            String str2 = Build.MANUFACTURER + Build.BRAND;
            if (!TextUtils.isEmpty(str2)) {
                String lowerCase = str2.toLowerCase(Locale.getDefault());
                if (lowerCase.contains("360") || lowerCase.contains("qiku")) {
                    return a("ro.build.uiversion") + "_" + Build.DISPLAY;
                }
            }
            String str3 = TextUtils.isEmpty(a("ro.letv.release.version")) ? "" : "eui_" + a("ro.letv.release.version") + "_" + Build.DISPLAY;
            return !TextUtils.isEmpty(str3) ? str3 : Build.DISPLAY;
        }
        String str4 = Build.DISPLAY;
        return (str4 == null || !str4.toLowerCase(Locale.getDefault()).contains("flyme")) ? "" : str4;
    }

    private static boolean b() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase(Locale.getDefault()).contains("oppo");
    }

    private static String a(String str) {
        BufferedReader bufferedReader;
        String str2 = "";
        try {
            Process exec = Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str)));
            bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()), 1024);
            try {
                str2 = bufferedReader.readLine();
                exec.destroy();
                com.apm.insight.a.a((Closeable) bufferedReader);
                return str2;
            } catch (Throwable unused) {
                com.apm.insight.a.a((Closeable) bufferedReader);
                return str2;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }
}
