package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.File;

/* compiled from: SameSDCardTool.java */
/* loaded from: classes6.dex */
public class s0 {

    /* renamed from: a, reason: collision with root package name */
    static String f4380a = "";
    private static volatile boolean b = false;
    private static int c = -1;
    private static int d = -1;
    private static long e;

    /* compiled from: SameSDCardTool.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            s0.b();
        }
    }

    public static void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (b) {
                return;
            }
            b = true;
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                f4380a = externalFilesDir.getAbsolutePath();
            }
            try {
                b(context);
            } catch (Exception unused) {
                b(context);
            }
        } catch (Exception e2) {
            p0.b("SameSDCardTool", e2.getMessage());
        }
    }

    private static void b(Context context) {
        File externalFilesDir;
        if (TextUtils.isEmpty(f4380a) && (externalFilesDir = context.getExternalFilesDir(null)) != null) {
            f4380a = externalFilesDir.getAbsolutePath();
        }
        if (!TextUtils.isEmpty(f4380a)) {
            com.mbridge.msdk.foundation.same.directory.e.a(new com.mbridge.msdk.foundation.same.directory.d(f4380a));
            com.mbridge.msdk.foundation.same.directory.e.b().a();
        }
        b();
    }

    public static int c() {
        return d;
    }

    public static int a() {
        if (System.currentTimeMillis() - e > 1800000) {
            com.mbridge.msdk.foundation.same.threadpool.a.e().execute(new a());
        }
        return c;
    }

    public static void b() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long blockSize = statFs.getBlockSize();
            long availableBlocks = statFs.getAvailableBlocks();
            d = Long.valueOf(((statFs.getBlockCount() * blockSize) / 1000) / 1000).intValue();
            c = Long.valueOf(((availableBlocks * blockSize) / 1000) / 1000).intValue();
            e = System.currentTimeMillis();
        } catch (Exception e2) {
            p0.b("SameSDCardTool", e2.getMessage());
        }
    }
}
