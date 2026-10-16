package com.bykv.vk.openvk.eli.eli.eli;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.DbA.eli.du;
import java.io.File;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class Os {
    private static Context DbA = null;
    private static int MGA = 1;
    private static String Os = null;
    private static boolean aGH = false;
    public static boolean eli = false;
    private static du ui;

    public static Context eli() {
        return DbA;
    }

    public static String DbA() {
        if (TextUtils.isEmpty(Os)) {
            try {
                File file = new File(eli().getFilesDir(), "ttad_dir");
                if (!file.exists()) {
                    file.mkdirs();
                }
                Os = file.getAbsolutePath();
            } catch (Throwable unused) {
            }
        }
        return Os;
    }

    public static void eli(Context context, String str) {
        DbA = context;
        Os = str;
    }

    public static boolean Os() {
        return aGH;
    }

    public static void eli(boolean z) {
        aGH = z;
    }

    public static du aGH() {
        if (ui == null) {
            ui = new du.eli("v_config").eli(10000L, TimeUnit.MILLISECONDS).DbA(10000L, TimeUnit.MILLISECONDS).Os(10000L, TimeUnit.MILLISECONDS).eli();
        }
        return ui;
    }

    public static void eli(du duVar) {
        ui = duVar;
    }

    public static boolean ui() {
        return eli;
    }

    public static void eli(int i) {
        MGA = i;
    }

    public static int MGA() {
        return MGA;
    }
}
