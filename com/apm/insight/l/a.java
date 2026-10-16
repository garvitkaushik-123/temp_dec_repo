package com.apm.insight.l;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import com.ironsource.N6;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import org.json.JSONObject;

/* compiled from: App.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f286a = null;
    private static Class<?> b = null;
    private static Field c = null;
    private static Field d = null;
    private static boolean e = false;

    private static long a(int i) {
        if (i < 0) {
            return 0L;
        }
        return i << 10;
    }

    public static boolean a() {
        return com.apm.insight.runtime.a.b.d().f();
    }

    public static ActivityManager.ProcessErrorStateInfo a(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return null;
        }
        int myPid = Process.myPid();
        List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
        if (processesInErrorState != null) {
            for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                if (processErrorStateInfo.pid == myPid && processErrorStateInfo.condition == 2) {
                    return processErrorStateInfo;
                }
            }
        }
        return null;
    }

    public static boolean b(Context context) {
        String b2 = b();
        if (b2 != null && b2.contains(":")) {
            return false;
        }
        if (b2 == null || !b2.equals(context.getPackageName())) {
            return b2 != null && b2.equals(context.getApplicationInfo().processName);
        }
        return true;
    }

    public static void a(String str) {
        f286a = str;
    }

    public static String b() {
        if (!TextUtils.isEmpty(f286a)) {
            return f286a;
        }
        String c2 = c();
        f286a = c2;
        if (!TextUtils.isEmpty(c2)) {
            return f286a;
        }
        String d2 = d();
        f286a = d2;
        if (!TextUtils.isEmpty(d2)) {
            return f286a;
        }
        String e2 = e();
        f286a = e2;
        if (e2 == null) {
            f286a = "";
        }
        return f286a;
    }

    private static String c() {
        try {
            return Application.getProcessName();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static String d() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static String e() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                int read = bufferedReader.read();
                if (read > 0) {
                    sb.append((char) read);
                } else {
                    String sb2 = sb.toString();
                    com.apm.insight.a.a((Closeable) bufferedReader);
                    return sb2;
                }
            }
        } catch (Throwable unused2) {
            com.apm.insight.a.a((Closeable) bufferedReader);
            return null;
        }
    }

    public static void a(Context context, JSONObject jSONObject) {
        try {
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("dalvikPrivateDirty", a(memoryInfo.dalvikPrivateDirty));
            jSONObject2.put("dalvikPss", a(memoryInfo.dalvikPss));
            jSONObject2.put("dalvikSharedDirty", a(memoryInfo.dalvikSharedDirty));
            jSONObject2.put("nativePrivateDirty", a(memoryInfo.nativePrivateDirty));
            jSONObject2.put("nativePss", a(memoryInfo.nativePss));
            jSONObject2.put("nativeSharedDirty", a(memoryInfo.nativeSharedDirty));
            jSONObject2.put("otherPrivateDirty", a(memoryInfo.otherPrivateDirty));
            jSONObject2.put("otherPss", a(memoryInfo.otherPss));
            jSONObject2.put("otherSharedDirty", memoryInfo.otherSharedDirty);
            try {
                String memoryStat = memoryInfo.getMemoryStat("summary.graphics");
                if (!TextUtils.isEmpty(memoryStat)) {
                    jSONObject2.put("summary.graphics", a(Integer.parseInt(memoryStat)));
                }
            } catch (Throwable unused) {
            }
            jSONObject2.put("totalPrivateClean", c.a(memoryInfo));
            jSONObject2.put("totalPrivateDirty", memoryInfo.getTotalPrivateDirty());
            jSONObject2.put("totalPss", a(memoryInfo.getTotalPss()));
            jSONObject2.put("totalSharedClean", c.b(memoryInfo));
            jSONObject2.put("totalSharedDirty", a(memoryInfo.getTotalSharedDirty()));
            jSONObject2.put("totalSwappablePss", a(c.c(memoryInfo)));
            jSONObject.put("memory_info", jSONObject2);
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                JSONObject jSONObject3 = new JSONObject();
                ActivityManager.MemoryInfo memoryInfo2 = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo2);
                jSONObject3.put(N6.w, memoryInfo2.availMem);
                jSONObject3.put("lowMemory", memoryInfo2.lowMemory);
                jSONObject3.put("threshold", memoryInfo2.threshold);
                jSONObject3.put("totalMem", i.a(memoryInfo2));
                jSONObject.put("sys_memory_info", jSONObject3);
            }
            JSONObject jSONObject4 = new JSONObject();
            boolean z = true;
            com.apm.insight.entity.a.a(jSONObject, "filters", "native_heap_leak", String.valueOf(Debug.getNativeHeapAllocatedSize() > 209715200));
            jSONObject4.put("native_heap_size", Debug.getNativeHeapSize());
            jSONObject4.put("native_heap_alloc_size", Debug.getNativeHeapAllocatedSize());
            jSONObject4.put("native_heap_free_size", Debug.getNativeHeapFreeSize());
            Runtime runtime = Runtime.getRuntime();
            long maxMemory = runtime.maxMemory();
            long freeMemory = runtime.freeMemory();
            long j = runtime.totalMemory();
            jSONObject4.put("max_memory", maxMemory);
            jSONObject4.put("free_memory", freeMemory);
            jSONObject4.put("total_memory", j);
            if (j - freeMemory <= maxMemory * 0.95f) {
                z = false;
            }
            com.apm.insight.entity.a.a(jSONObject, "filters", "java_heap_leak", String.valueOf(z));
            if (activityManager != null) {
                jSONObject4.put("memory_class", activityManager.getMemoryClass());
                jSONObject4.put("large_memory_class", activityManager.getLargeMemoryClass());
            }
            jSONObject.put("app_memory_info", jSONObject4);
        } catch (Throwable unused2) {
        }
    }

    public static String c(Context context) {
        Class<?> e2 = e(context);
        if (c == null && e2 != null) {
            try {
                c = e2.getDeclaredField("VERSION_NAME");
            } catch (NoSuchFieldException unused) {
            }
        }
        Field field = c;
        if (field != null) {
            try {
                return String.valueOf(field.get(null));
            } catch (Throwable unused2) {
                return "";
            }
        }
        return "";
    }

    public static int d(Context context) {
        Class<?> e2 = e(context);
        if (d == null && e2 != null) {
            try {
                d = e2.getDeclaredField("VERSION_CODE");
            } catch (NoSuchFieldException unused) {
            }
        }
        Field field = d;
        if (field == null) {
            return -1;
        }
        try {
            return ((Integer) field.get(null)).intValue();
        } catch (Throwable unused2) {
            return -1;
        }
    }

    private static Class<?> e(Context context) {
        if (b == null && !e) {
            try {
                b = Class.forName(context.getPackageName() + ".BuildConfig");
            } catch (ClassNotFoundException unused) {
            }
            e = true;
        }
        return b;
    }
}
