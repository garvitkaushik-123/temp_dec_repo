package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.Properties;

/* loaded from: classes3.dex */
public class qj implements Thread.UncaughtExceptionHandler {
    public static volatile boolean eli;
    private final Thread.UncaughtExceptionHandler DbA = Thread.getDefaultUncaughtExceptionHandler();
    private String Os;

    public static qj eli() {
        return new qj();
    }

    private qj() {
        Thread.setDefaultUncaughtExceptionHandler(this);
        DbA();
    }

    private void DbA() {
        Context eli2 = com.bytedance.sdk.openadsdk.core.dV.eli();
        if (eli2 == null) {
            return;
        }
        try {
            File file = new File(eli2.getFilesDir(), "TTCache");
            file.mkdirs();
            this.Os = file.getPath();
        } catch (Throwable unused) {
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        eli = true;
        com.bytedance.sdk.component.wC.FC.sCrashHappened = true;
        com.bytedance.sdk.component.wC.Os.aGH.Os = true;
        boolean z = false;
        com.bytedance.sdk.component.wC.MGA.eli(false);
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            if (stringWriter2 != null) {
                z = stringWriter2.contains(AdSlot.class.getPackage().getName());
            }
        } catch (Throwable unused) {
        }
        if (z) {
            eli(thread, th);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.DbA;
        if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == this) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v14, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r12v5, types: [java.util.Properties] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.util.Properties] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void eli(Thread thread, Throwable th) {
        ?? r1;
        boolean z;
        int i;
        FileInputStream fileInputStream = null;
        try {
            if (TextUtils.isEmpty(this.Os)) {
                DbA();
            }
        } catch (Throwable th2) {
            th = th2;
            r1 = 0;
        }
        if (TextUtils.isEmpty(this.Os)) {
            return;
        }
        File file = new File(this.Os, "tt_crash_count.properties");
        if (file.exists() && file.isFile() && file.canRead()) {
            ?? properties = new Properties();
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                properties.load(fileInputStream2);
                String property = properties.getProperty("crash_count", "0");
                String property2 = properties.getProperty("crash_last_time", "0");
                int intValue = Integer.valueOf(property).intValue();
                if (System.currentTimeMillis() - Long.valueOf(property2).longValue() < 300000) {
                    i = intValue + 1;
                    z = false;
                } else {
                    z = true;
                    i = 1;
                }
                boolean z2 = i >= 3;
                int i2 = z2 ? 0 : i;
                if (z2) {
                    try {
                        file.delete();
                    } catch (Throwable unused) {
                    }
                } else {
                    properties.setProperty("crash_count", String.valueOf(i2));
                    if (z) {
                        properties.setProperty("crash_last_time", String.valueOf(System.currentTimeMillis()));
                    }
                    ?? fileOutputStream = new FileOutputStream(file);
                    try {
                        properties.store(fileOutputStream, "tt_crash_info");
                        fileInputStream = fileOutputStream;
                    } catch (Throwable th3) {
                        r1 = fileOutputStream;
                        th = th3;
                        fileInputStream = fileInputStream2;
                        com.bytedance.sdk.component.utils.Xb.eli("TTCrashHandler", "crash count error", th);
                        if (fileInputStream != null) {
                        }
                        if (r1 == 0) {
                        }
                        r1.close();
                    }
                }
                if (z2) {
                    Os();
                }
                r1 = fileInputStream;
                fileInputStream = fileInputStream2;
            } catch (Throwable th4) {
                th = th4;
                r1 = fileInputStream;
            }
        } else {
            ?? properties2 = new Properties();
            properties2.setProperty("crash_count", "1");
            properties2.setProperty("crash_last_time", String.valueOf(System.currentTimeMillis()));
            r1 = new FileOutputStream(file);
            try {
                properties2.store(r1, "tt_crash_info");
                r1 = r1;
            } catch (Throwable th5) {
                th = th5;
                try {
                    com.bytedance.sdk.component.utils.Xb.eli("TTCrashHandler", "crash count error", th);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    if (r1 == 0) {
                        return;
                    }
                    r1.close();
                } finally {
                }
            }
        }
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (Throwable unused3) {
            }
        }
        if (r1 == 0) {
            return;
        }
        try {
            r1.close();
        } catch (Throwable unused4) {
        }
    }

    private void Os() {
        try {
            com.bytedance.sdk.openadsdk.component.kb.eli.eli(com.bytedance.sdk.openadsdk.core.dV.eli());
        } catch (Throwable unused) {
        }
        try {
            com.bytedance.sdk.openadsdk.component.reward.NU.eli(com.bytedance.sdk.openadsdk.core.dV.eli()).eli();
        } catch (Throwable unused2) {
        }
        try {
            com.bytedance.sdk.openadsdk.component.reward.ui.eli(com.bytedance.sdk.openadsdk.core.dV.eli()).eli();
        } catch (Throwable unused3) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.settings.NU.nY().eli();
        } catch (Throwable unused4) {
        }
        try {
            com.bytedance.sdk.component.adexpress.eli.DbA.DbA.DbA();
        } catch (Throwable unused5) {
        }
    }
}
