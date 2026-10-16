package com.bytedance.adsdk.DbA;

import android.content.Context;
import android.os.Trace;
import java.io.File;

/* loaded from: classes3.dex */
public class ui {
    private static boolean DbA = false;
    private static com.bytedance.adsdk.DbA.aGH.MGA FC = null;
    private static long[] MGA = null;
    private static boolean Os = true;
    private static com.bytedance.adsdk.DbA.aGH.ui aAs = null;
    private static boolean aGH = true;
    private static volatile com.bytedance.adsdk.DbA.aGH.wC du = null;
    public static boolean eli = false;
    private static int kb;
    private static volatile com.bytedance.adsdk.DbA.aGH.kb nlS;
    private static String[] ui;
    private static int wC;

    public static void eli(String str) {
        if (DbA) {
            int i = kb;
            if (i == 20) {
                wC++;
                return;
            }
            ui[i] = str;
            MGA[i] = System.nanoTime();
            Trace.beginSection(str);
            kb++;
        }
    }

    public static float DbA(String str) {
        int i = wC;
        if (i > 0) {
            wC = i - 1;
            return 0.0f;
        }
        if (!DbA) {
            return 0.0f;
        }
        int i2 = kb - 1;
        kb = i2;
        if (i2 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (!str.equals(ui[i2])) {
            throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + ui[kb] + ".");
        }
        Trace.endSection();
        return (System.nanoTime() - MGA[kb]) / 1000000.0f;
    }

    public static com.bytedance.adsdk.DbA.aGH.wC eli(Context context) {
        com.bytedance.adsdk.DbA.aGH.wC wCVar;
        com.bytedance.adsdk.DbA.aGH.wC wCVar2 = du;
        if (wCVar2 != null) {
            return wCVar2;
        }
        synchronized (com.bytedance.adsdk.DbA.aGH.wC.class) {
            wCVar = du;
            if (wCVar == null) {
                com.bytedance.adsdk.DbA.aGH.kb DbA2 = DbA(context);
                com.bytedance.adsdk.DbA.aGH.MGA mga = FC;
                if (mga == null) {
                    mga = new com.bytedance.adsdk.DbA.aGH.DbA();
                }
                wCVar = new com.bytedance.adsdk.DbA.aGH.wC(DbA2, mga);
                du = wCVar;
            }
        }
        return wCVar;
    }

    public static com.bytedance.adsdk.DbA.aGH.kb DbA(Context context) {
        com.bytedance.adsdk.DbA.aGH.kb kbVar;
        if (!Os) {
            return null;
        }
        final Context applicationContext = context.getApplicationContext();
        com.bytedance.adsdk.DbA.aGH.kb kbVar2 = nlS;
        if (kbVar2 != null) {
            return kbVar2;
        }
        synchronized (com.bytedance.adsdk.DbA.aGH.kb.class) {
            kbVar = nlS;
            if (kbVar == null) {
                com.bytedance.adsdk.DbA.aGH.ui uiVar = aAs;
                if (uiVar == null) {
                    uiVar = new com.bytedance.adsdk.DbA.aGH.ui() { // from class: com.bytedance.adsdk.DbA.ui.1
                        @Override // com.bytedance.adsdk.DbA.aGH.ui
                        public File eli() {
                            return new File(applicationContext.getCacheDir(), "lottie_network_cache");
                        }
                    };
                }
                kbVar = new com.bytedance.adsdk.DbA.aGH.kb(uiVar);
                nlS = kbVar;
            }
        }
        return kbVar;
    }

    public static boolean eli() {
        return aGH;
    }
}
