package com.bytedance.sdk.openadsdk.utils;

import android.os.Build;
import android.text.TextUtils;
import com.ironsource.C3040d4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class Ue {
    public static boolean DbA = false;
    private static int MGA = Integer.MAX_VALUE;
    public static boolean eli = false;
    private static String ui;
    private static final CharSequence Os = "amigo";
    private static final CharSequence aGH = "funtouch";
    private static final ConcurrentHashMap<String, String> kb = new ConcurrentHashMap<>();

    public static String eli() {
        if (!TextUtils.isEmpty(ui)) {
            return ui;
        }
        String eli2 = com.bytedance.sdk.openadsdk.core.FC.eli("sdk_local_rom_info", 604800000L);
        ui = eli2;
        if (TextUtils.isEmpty(eli2)) {
            String CMM = CMM();
            ui = CMM;
            com.bytedance.sdk.openadsdk.core.FC.eli("sdk_local_rom_info", CMM);
        }
        return ui;
    }

    private static String CMM() {
        if (Dfc()) {
            return aqO();
        }
        if (ui()) {
            return nlS();
        }
        if (DbA()) {
            return dV();
        }
        if (nGm()) {
            return QX();
        }
        String NU = NU();
        if (!TextUtils.isEmpty(NU)) {
            return NU;
        }
        if (kb()) {
            return MGA();
        }
        if (wC()) {
            return FC();
        }
        if (aGH()) {
            return Os();
        }
        String aAs = aAs();
        return !TextUtils.isEmpty(aAs) ? aAs : Build.DISPLAY;
    }

    public static boolean DbA() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static String Os() {
        return aGH("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static boolean aGH() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static boolean ui() {
        if (!DbA) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    eli = true;
                    DbA = true;
                    return true;
                }
            } catch (Exception unused) {
            }
            DbA = true;
        }
        return eli;
    }

    public static String MGA() {
        return aGH("ro.vivo.os.build.display.id") + "_" + aGH("ro.vivo.product.version");
    }

    public static boolean kb() {
        String aGH2 = aGH("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(aGH2) && aGH2.toLowerCase().contains(aGH);
    }

    public static boolean wC() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase().contains(Os);
    }

    public static String FC() {
        return Build.DISPLAY + "_" + aGH("ro.gn.sv.version");
    }

    public static String aAs() {
        if (du()) {
            return "eui_" + aGH("ro.letv.release.version") + "_" + Build.DISPLAY;
        }
        return "";
    }

    public static boolean du() {
        return !TextUtils.isEmpty(aGH("ro.letv.release.version"));
    }

    public static String nlS() {
        if (ui()) {
            return "miui_" + aGH("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
        }
        return "";
    }

    public static String NU() {
        String nn = nn();
        if (nn != null && nn.toLowerCase().contains("emotionui")) {
            return nn + "_" + Build.DISPLAY;
        }
        return "";
    }

    public static String nn() {
        return aGH("ro.build.version.emui");
    }

    public static boolean Dfc() {
        return "smartisan".equalsIgnoreCase(Build.MANUFACTURER) || "smartisan".equalsIgnoreCase(Build.BRAND);
    }

    public static String aqO() {
        if (Dfc()) {
            try {
                return "smartisan_".concat(String.valueOf(aGH("ro.smartisan.version")));
            } catch (Throwable unused) {
            }
        }
        return Build.DISPLAY;
    }

    public static String dV() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    public static boolean nGm() {
        if (MGA == Integer.MAX_VALUE) {
            String str = Build.MANUFACTURER;
            String kb2 = dZ.kb("kllk");
            if (!TextUtils.isEmpty(str) && str.toLowerCase().contains(kb2)) {
                MGA = 1;
            } else {
                MGA = 0;
            }
        }
        return MGA == 1;
    }

    public static String QX() {
        if (nGm()) {
            return "coloros_" + aGH(dZ.kb("ro.build.version.kllkrom")) + "_" + Build.DISPLAY;
        }
        return "";
    }

    public static boolean Xb() {
        try {
            if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase().startsWith("huawei")) {
                if (TextUtils.isEmpty(Build.MANUFACTURER)) {
                    return false;
                }
                if (!Build.MANUFACTURER.toLowerCase().startsWith("huawei")) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean eli(String str) {
        if (TextUtils.isEmpty(str)) {
            str = nn();
        }
        return (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("emotionui")) || Xb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String Os(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        Process exec;
        String str2 = "";
        Process process = null;
        try {
            try {
                try {
                    exec = Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str)));
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()), 1024);
                    } catch (IllegalThreadStateException unused) {
                        bufferedReader = null;
                    }
                } catch (IOException e) {
                    com.bytedance.sdk.component.utils.Xb.eli("ToolUtils", "Exception while closing InputStream", e);
                }
            } catch (IllegalThreadStateException unused2) {
                bufferedReader = null;
            }
        } catch (Throwable th2) {
            bufferedReader = null;
            th = th2;
        }
        try {
            str2 = bufferedReader.readLine();
            exec.exitValue();
            bufferedReader.close();
        } catch (IllegalThreadStateException unused3) {
            process = exec;
            try {
                process.destroy();
            } catch (Throwable unused4) {
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return str2;
        } catch (Throwable th3) {
            th = th3;
            try {
                com.bytedance.sdk.component.utils.Xb.eli("ToolUtils", "Unable to read sysprop ".concat(String.valueOf(str)), th);
                return str2;
            } finally {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                        com.bytedance.sdk.component.utils.Xb.eli("ToolUtils", "Exception while closing InputStream", e2);
                    }
                }
            }
        }
        return str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String aGH(String str) {
        String str2;
        new Object[]{"getSystemPropertyTask() called with: propName = [", str, C3040d4.i.e};
        String str3 = kb.get(str);
        if (str3 != null) {
            return str3;
        }
        if (TextUtils.isEmpty("")) {
            final com.bytedance.sdk.component.wC.kb kbVar = new com.bytedance.sdk.component.wC.kb(new eli(str), 5, 2);
            cyF.DbA(new com.bytedance.sdk.component.wC.wC("_getSystemPropertyTask") { // from class: com.bytedance.sdk.openadsdk.utils.Ue.1
                @Override // java.lang.Runnable
                public void run() {
                    kbVar.run();
                }
            });
            str2 = (String) kbVar.get(1L, TimeUnit.SECONDS);
            return str2 != null ? "" : str2;
        }
        str2 = "";
        if (str2 != null) {
        }
    }

    public static class eli implements Callable<String> {
        private final String eli;

        public eli(String str) {
            this.eli = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
        public String call() throws Exception {
            String str = (String) Ue.kb.get(this.eli);
            if (str != null) {
                return str;
            }
            System.currentTimeMillis();
            String Os = Ue.Os(this.eli);
            System.currentTimeMillis();
            if (Os != null) {
                Ue.kb.put(this.eli, Os);
            }
            return Os;
        }
    }
}
