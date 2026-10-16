package com.mbridge.msdk.foundation.same.report.crashreport;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.ironsource.C3040d4;
import com.mbridge.msdk.foundation.tools.p0;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: MBridgeUncaughtExceptionHandler.java */
/* loaded from: classes6.dex */
public class e implements Thread.UncaughtExceptionHandler {
    private static volatile e d;

    /* renamed from: a, reason: collision with root package name */
    private final String f4317a = "CrashHandlerUtil";
    private Thread.UncaughtExceptionHandler b;
    private final WeakReference<Context> c;

    private e(Context context) {
        this.c = new WeakReference<>(context);
    }

    public static e a(Context context) {
        if (d == null) {
            synchronized (e.class) {
                if (d == null) {
                    d = new e(context);
                }
            }
        }
        return d;
    }

    private void b(Thread thread, Throwable th) {
        try {
            List<String> a2 = b.a();
            StackTraceElement[] stackTrace = th.getStackTrace();
            StringBuilder sb = new StringBuilder();
            String str = th.getClass() + ": " + th.getMessage();
            sb.append(str).append("\n");
            boolean a3 = a(a2, str);
            int i = 0;
            for (int i2 = 0; i2 < stackTrace.length; i2++) {
                String stackTraceElement = stackTrace[i2].toString();
                if (a(a2, stackTraceElement)) {
                    a3 = true;
                    if (i2 == 0) {
                        i = 1;
                    }
                }
                sb.append(stackTraceElement).append("\n");
            }
            if (a3 && sb.length() >= 1) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(C3040d4.h.W, "2000052");
                jSONObject.put("crash_first_index_from_mtg", i);
                JSONObject a4 = a(String.valueOf(System.currentTimeMillis()));
                a4.put("crashinfo", sb.toString());
                jSONObject.put("exception", a4);
                if (jSONObject.length() > 0) {
                    com.mbridge.msdk.foundation.same.report.metrics.d.b().a(jSONObject);
                }
                try {
                    Thread.sleep(500L);
                    return;
                } catch (InterruptedException e) {
                    p0.b("CrashHandlerUtil", e.getMessage());
                    return;
                }
            }
            a(thread, th);
        } catch (Throwable th2) {
            a(thread, th);
            p0.b("CrashHandlerUtil", th2.getMessage());
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (th != null) {
            try {
                b(thread, th);
            } catch (Throwable th2) {
                p0.b("CrashHandlerUtil", th2.getMessage());
            }
        }
        a(thread, th);
    }

    public void a() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        this.b = defaultUncaughtExceptionHandler;
        if (defaultUncaughtExceptionHandler instanceof e) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.c.get() == null) {
                return jSONObject;
            }
            jSONObject.put("max_memory", String.valueOf((float) ((Runtime.getRuntime().maxMemory() * 1.0d) / 1048576.0d)));
            jSONObject.put("memoryby_app", String.valueOf((float) ((Runtime.getRuntime().totalMemory() * 1.0d) / 1048576.0d)));
            jSONObject.put("remaining_memory", (float) ((Runtime.getRuntime().freeMemory() * 1.0d) / 1048576.0d));
            jSONObject.put("crashtime", str);
            return jSONObject;
        } catch (Throwable th) {
            p0.b("CrashHandlerUtil", th.getMessage());
            return jSONObject;
        }
    }

    private boolean a(List<String> list, String str) {
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (str.contains(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(Thread thread, Throwable th) {
        try {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
            if (uncaughtExceptionHandler != null) {
                if (uncaughtExceptionHandler instanceof e) {
                    return;
                }
                uncaughtExceptionHandler.uncaughtException(thread, th);
            } else {
                Process.killProcess(Process.myPid());
                System.exit(1);
            }
        } catch (Throwable th2) {
            p0.b("CrashHandlerUtil", th2.getMessage());
        }
    }
}
