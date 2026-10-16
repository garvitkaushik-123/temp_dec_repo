package com.apm.insight.nativecrash;

import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.Npth;
import com.apm.insight.e;
import com.apm.insight.l.j;
import com.apm.insight.l.m;
import com.apm.insight.runtime.a.c;
import com.apm.insight.runtime.a.f;
import com.apm.insight.runtime.l;
import com.ironsource.C3040d4;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class NativeCrashCollector {
    public static int a() {
        return 6;
    }

    public static void onNativeCrash(final String str) {
        final long currentTimeMillis = System.currentTimeMillis();
        com.apm.insight.a.a((Object) "[onNativeCrash] enter");
        try {
            com.apm.insight.k.b.a().b();
            final File e = j.e(new File(j.a(), e.f()));
            com.apm.insight.entity.a a2 = f.a().a(CrashType.NATIVE, new c.a() { // from class: com.apm.insight.nativecrash.NativeCrashCollector.1
                @Override // com.apm.insight.runtime.a.c.a
                public final com.apm.insight.entity.a a(int i, com.apm.insight.entity.a aVar) {
                    if (i == 1) {
                        String str2 = str;
                        if (str2 != null && str2.length() != 0) {
                            aVar.a("java_data", (Object) NativeCrashCollector.b(str));
                        }
                        aVar.a("crash_after_crash", Npth.hasCrashWhenNativeCrash() ? "true" : "false");
                        return aVar;
                    }
                    if (i != 2) {
                        if (i != 3) {
                            if (i == 4) {
                                com.apm.insight.l.a.a(e.g(), aVar.c());
                                return aVar;
                            }
                        } else if (com.apm.insight.runtime.a.d()) {
                            aVar.a("all_thread_stacks", m.b(str));
                            aVar.a("has_all_thread_stack", "true");
                        }
                        return aVar;
                    }
                    if (e.x()) {
                        JSONArray b = com.apm.insight.b.f.b().b();
                        long uptimeMillis = SystemClock.uptimeMillis();
                        JSONObject a3 = com.apm.insight.b.f.b().a(uptimeMillis).a();
                        JSONArray a4 = com.apm.insight.b.j.a(uptimeMillis);
                        aVar.a("history_message", (Object) b);
                        aVar.a("current_message", a3);
                        aVar.a("pending_messages", (Object) a4);
                    }
                    aVar.a("disable_looper_monitor", String.valueOf(com.apm.insight.runtime.a.c()));
                    aVar.a("npth_force_apm_crash", String.valueOf(com.apm.insight.c.a.a()));
                    return aVar;
                }

                @Override // com.apm.insight.runtime.a.c.a
                public final com.apm.insight.entity.a b(int i, com.apm.insight.entity.a aVar) {
                    try {
                        JSONObject c = aVar.c();
                        if (c.length() > 0) {
                            com.apm.insight.l.f.a(new File(e.getAbsolutePath() + '.' + i), c);
                        }
                    } catch (IOException e2) {
                        com.apm.insight.c.a();
                        com.apm.insight.runtime.j.a(e2, "NPTH_CATCH");
                    }
                    if (i == 0) {
                        com.apm.insight.a.a.a();
                        com.apm.insight.a.a.a();
                        CrashType crashType = CrashType.NATIVE;
                        e.f();
                    }
                    return aVar;
                }
            });
            JSONObject c = a2.c();
            if (c != null && c.length() != 0) {
                long currentTimeMillis2 = System.currentTimeMillis();
                long j = currentTimeMillis2 - currentTimeMillis;
                try {
                    c.put("java_end", currentTimeMillis2);
                    a2.b("crash_cost", String.valueOf(j));
                    a2.a("crash_cost", String.valueOf(j / 1000));
                } catch (Throwable unused) {
                }
                File file = new File(e.getAbsolutePath() + ".tmp");
                com.apm.insight.l.f.a(file, c);
                file.renameTo(e);
            }
            try {
                if (l.a().d().isEmpty()) {
                    return;
                }
                File file2 = new File(j.a(), e.f());
                c cVar = new c(file2);
                cVar.b(file2);
                a(cVar.c(), cVar.a(), str);
            } catch (Throwable unused2) {
                a("", null, str);
            }
        } catch (Throwable th) {
            try {
                com.apm.insight.c.a();
                com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
            } finally {
                try {
                    if (!l.a().d().isEmpty()) {
                        File file3 = new File(j.a(), e.f());
                        c cVar2 = new c(file3);
                        cVar2.b(file3);
                        a(cVar2.c(), cVar2.a(), str);
                    }
                } catch (Throwable unused3) {
                    a("", null, str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (C3040d4.h.Z.equalsIgnoreCase(str)) {
            return m.a(Looper.getMainLooper().getThread().getStackTrace());
        }
        ThreadGroup threadGroup = Looper.getMainLooper().getThread().getThreadGroup();
        int activeCount = threadGroup.activeCount();
        Thread[] threadArr = new Thread[activeCount + (activeCount / 2)];
        int enumerate = threadGroup.enumerate(threadArr);
        for (int i = 0; i < enumerate; i++) {
            String name = threadArr[i].getName();
            if (!TextUtils.isEmpty(name) && (name.equals(str) || name.startsWith(str) || name.endsWith(str))) {
                return m.a(threadArr[i].getStackTrace());
            }
        }
        try {
            for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                String name2 = entry.getKey().getName();
                if (name2.equals(str) || name2.startsWith(str) || name2.endsWith(str)) {
                    return m.a(entry.getValue());
                }
            }
        } catch (Throwable th) {
            com.apm.insight.c.a();
            com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
        }
        return "";
    }

    private static void a(String str, String str2, String str3) {
        for (ICrashCallback iCrashCallback : l.a().d()) {
            try {
                if (iCrashCallback instanceof com.apm.insight.b) {
                    ((com.apm.insight.b) iCrashCallback).a(CrashType.NATIVE, str, str3, str2);
                } else {
                    iCrashCallback.onCrash(CrashType.NATIVE, str, null);
                }
            } catch (Throwable th) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
            }
        }
    }
}
