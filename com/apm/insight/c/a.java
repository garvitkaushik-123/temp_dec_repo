package com.apm.insight.c;

import com.apm.insight.e;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: CommandWriter.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static AtomicBoolean f230a = new AtomicBoolean(false);

    public static boolean a() {
        synchronized (f230a) {
            if (f230a.get()) {
                return false;
            }
            f230a.set(true);
            return b();
        }
    }

    public static boolean b() {
        if (!com.apm.insight.runtime.a.g()) {
            return false;
        }
        try {
            File file = new File(e.h().getFilesDir(), "apminsight/crashCommand");
            file.mkdirs();
            new File(file, "0_" + System.currentTimeMillis()).createNewFile();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
