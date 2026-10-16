package com.apm.insight.nativecrash;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.apm.insight.b.d;
import com.apm.insight.b.f;
import com.apm.insight.e;
import com.apm.insight.l.j;
import java.io.File;

/* loaded from: classes2.dex */
public class NativeImpl {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f303a = false;
    private static volatile boolean b = false;
    private static boolean c = true;

    public static void c() {
    }

    public static void d() {
    }

    private static native boolean doCheckNativeCrash();

    private static native void doCloseFile(int i);

    private static native int doCreateCallbackThread();

    private static native void doDump(String str);

    private static native void doDumpFds(String str);

    private static native void doDumpHprof(String str);

    private static native void doDumpLogcat(String str, String str2, String str3);

    private static native void doDumpMaps(String str);

    private static native void doDumpMemInfo(String str);

    private static native void doDumpThreads(String str);

    private static native long doGetAppCpuTime();

    private static native long doGetChildCpuTime();

    private static native String doGetCrashHeader(String str);

    private static native long doGetDeviceCpuTime();

    private static native int doGetFDCount();

    private static native String[] doGetFdDump(int i, int i2, int[] iArr, String[] strArr);

    private static native long doGetFreeMemory();

    private static native long doGetThreadCpuTime(int i);

    private static native int doGetThreadsCount();

    private static native long doGetTotalMemory();

    private static native long doGetVMSize();

    private static native void doInitThreadDump();

    private static native int doLock(String str, int i);

    private static native int doOpenFile(String str);

    private static native void doRebuildTombstone(String str, String str2, String str3);

    private static native void doSetAlogConfigPath(String str);

    private static native void doSetAlogFlushAddr(long j);

    private static native void doSetAlogLogDirAddr(long j);

    private static native void doSetResendSigQuit(int i);

    private static native void doSetUploadEnd();

    private static native void doSignalMainThread();

    private static native int doStart(int i, String str, String str2, String str3, int i2);

    private static native void doStartAnrMonitor(int i);

    private static native void doWriteFile(int i, String str, int i2);

    private static native boolean is64Bit();

    public static boolean a() {
        if (b) {
            return f303a;
        }
        b = true;
        if (!f303a) {
            f303a = com.apm.insight.a.b("apminsighta");
        }
        return f303a;
    }

    public static boolean a(Context context) {
        String a2;
        boolean a3 = a();
        if (a3) {
            String str = j.j(context) + "/apminsight";
            if (new File(context.getApplicationInfo().nativeLibraryDir, "libapminsightb.so").exists()) {
                a2 = context.getApplicationInfo().nativeLibraryDir;
            } else {
                a2 = com.apm.insight.h.b.a();
                com.apm.insight.h.b.b("apminsightb");
            }
            doStart(Build.VERSION.SDK_INT, a2, str, e.f(), e.m());
        }
        return a3;
    }

    public static int b() {
        if (f303a) {
            return doCreateCallbackThread();
        }
        return -1;
    }

    public static void a(long j) {
        if (f303a) {
            try {
                doSetAlogFlushAddr(j);
            } catch (Throwable unused) {
            }
        }
    }

    public static void b(long j) {
        if (f303a) {
            try {
                doSetAlogLogDirAddr(j);
            } catch (Throwable unused) {
            }
        }
    }

    public static String a(String str) {
        if (f303a) {
            return doGetCrashHeader(str);
        }
        return null;
    }

    public static void a(File file) {
        if (f303a) {
            doRebuildTombstone(j.c(file).getAbsolutePath(), j.b(file).getAbsolutePath(), j.d(file).getAbsolutePath());
        }
    }

    public static void b(String str) {
        if (f303a) {
            doDumpHprof(str);
        }
    }

    public static boolean e() {
        if (!f303a) {
            return false;
        }
        try {
            return doCheckNativeCrash();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean f() {
        if (!f303a) {
            return false;
        }
        try {
            return is64Bit();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void g() {
        new Thread(new Runnable() { // from class: com.apm.insight.nativecrash.NativeImpl.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    NativeImpl.l();
                } catch (Throwable th) {
                    try {
                        com.apm.insight.c.a(th, "NPTH_ANR_MONITOR_ERROR");
                    } catch (Throwable unused) {
                    }
                }
            }
        }, "NPTH-AnrMonitor").start();
    }

    private static void reportEventForAnrMonitor() {
        try {
            System.currentTimeMillis();
            e.j();
            d.c();
            f.a(e.g()).a().e();
        } catch (Throwable unused) {
        }
    }

    public static int c(String str) {
        if (f303a && !TextUtils.isEmpty(str)) {
            try {
                return doLock(str, -1);
            } catch (Throwable unused) {
            }
        }
        return -1;
    }

    public static int a(int i) {
        if (f303a && i >= 0) {
            try {
                return doLock("", i);
            } catch (Throwable unused) {
            }
        }
        return -1;
    }

    public static void a(String str, String str2, String str3) {
        if (f303a) {
            try {
                doDumpLogcat(str, str2, str3);
            } catch (Throwable unused) {
            }
        }
    }

    public static void d(String str) {
        if (f303a) {
            try {
                doDumpMemInfo(str);
            } catch (Throwable unused) {
            }
        }
    }

    public static void e(String str) {
        if (f303a) {
            try {
                doDumpFds(str);
            } catch (Throwable unused) {
            }
        }
    }

    public static void f(String str) {
        if (f303a) {
            try {
                doDumpMaps(str);
            } catch (Throwable unused) {
            }
        }
    }

    public static void g(String str) {
        if (f303a) {
            try {
                doDumpThreads(str);
            } catch (Throwable unused) {
            }
        }
    }

    public static int h(String str) {
        if (!f303a) {
            return -1;
        }
        try {
            return doOpenFile(str);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static void a(int i, String str) {
        if (!f303a || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            doWriteFile(i, str, str.length());
        } catch (Throwable unused) {
        }
    }

    public static void b(int i) {
        if (f303a) {
            try {
                doCloseFile(i);
            } catch (Throwable unused) {
            }
        }
    }

    private static void handleNativeCrash(String str) {
        NativeCrashCollector.onNativeCrash(str);
    }

    public static void i(String str) {
        if (f303a) {
            doDump(str);
        }
    }

    public static void a(boolean z) {
        c = z;
        if (f303a) {
            doSetResendSigQuit(z ? 1 : 0);
        }
    }

    public static boolean h() {
        return c;
    }

    public static void i() {
        if (f303a) {
            doSignalMainThread();
        }
    }

    public static void j() {
        if (f303a) {
            doSetUploadEnd();
        }
    }

    public static void k() {
        if (f303a) {
            doInitThreadDump();
        }
    }

    static /* synthetic */ void l() {
        if (f303a) {
            try {
                doStartAnrMonitor(Build.VERSION.SDK_INT);
            } catch (Throwable unused) {
            }
        }
    }
}
