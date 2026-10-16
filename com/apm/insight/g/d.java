package com.apm.insight.g;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import com.adjust.sdk.Constants;
import com.apm.insight.CrashType;
import com.apm.insight.Npth;
import com.apm.insight.e;
import com.apm.insight.l.f;
import com.apm.insight.l.j;
import com.apm.insight.l.m;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.runtime.a.c;
import com.apm.insight.runtime.h;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import java.io.File;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: JavaCrash.java */
/* loaded from: classes2.dex */
public final class d implements c {

    /* renamed from: a, reason: collision with root package name */
    private Context f252a;

    @Override // com.apm.insight.g.c
    public final void a(final long j, final Thread thread, final Throwable th, final String str, final String str2, final boolean z) {
        final File file = new File(j.a(this.f252a), str);
        a.a().a(file.getName());
        file.mkdirs();
        f.d(file);
        final boolean c = m.c(th);
        com.apm.insight.entity.a a2 = com.apm.insight.runtime.a.f.a().a(CrashType.JAVA, new c.a() { // from class: com.apm.insight.g.d.1

            /* renamed from: a, reason: collision with root package name */
            private long f253a = 0;

            @Override // com.apm.insight.runtime.a.c.a
            public final com.apm.insight.entity.a a(int i, com.apm.insight.entity.a aVar) {
                this.f253a = SystemClock.uptimeMillis();
                if (i == 0) {
                    aVar.a("data", (Object) m.a(th));
                    aVar.a("isOOM", Boolean.valueOf(c));
                    aVar.a("isJava", (Object) 1);
                    aVar.a("crash_time", Long.valueOf(j));
                    aVar.a("launch_mode", Integer.valueOf(com.apm.insight.runtime.a.b.b()));
                    aVar.a("launch_time", Long.valueOf(com.apm.insight.runtime.a.b.c()));
                    String str3 = str2;
                    if (str3 != null) {
                        aVar.a("crash_md5", (Object) str3);
                        aVar.a("crash_md5", str2);
                        boolean z2 = z;
                        if (z2) {
                            aVar.a("has_ignore", String.valueOf(z2));
                        }
                    }
                } else {
                    if (i == 1) {
                        Thread thread2 = thread;
                        aVar.a("crash_thread_name", (Object) (thread2 != null ? thread2.getName() : ""));
                        aVar.a(ScarConstants.TOKEN_ID_KEY, Integer.valueOf(Process.myTid()));
                        aVar.a("crash_after_crash", Npth.hasCrashWhenJavaCrash() ? "true" : "false");
                        aVar.a("crash_after_native", NativeImpl.e() ? "true" : "false");
                        a.a().a(thread, th, false, aVar);
                        return aVar;
                    }
                    if (i == 2) {
                        if (c) {
                            com.apm.insight.l.a.a(d.this.f252a, aVar.c());
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
                    if (i == 3) {
                        JSONObject b2 = m.b(Thread.currentThread().getName());
                        if (b2 != null) {
                            aVar.a("all_thread_stacks", b2);
                        }
                        aVar.a("logcat", (Object) h.a(e.f()));
                        return aVar;
                    }
                    if (i != 4) {
                        if (i == 5) {
                            aVar.a("crash_uuid", (Object) str);
                            return aVar;
                        }
                    } else if (!c) {
                        com.apm.insight.l.a.a(d.this.f252a, aVar.c());
                        return aVar;
                    }
                }
                return aVar;
            }

            @Override // com.apm.insight.runtime.a.c.a
            public final com.apm.insight.entity.a b(int i, com.apm.insight.entity.a aVar) {
                try {
                    f.a(new File(file, file.getName() + "." + i), aVar.c());
                    return aVar;
                } catch (IOException e) {
                    e.printStackTrace();
                    return aVar;
                }
            }
        });
        long currentTimeMillis = System.currentTimeMillis() - j;
        try {
            a2.a("crash_type", Constants.NORMAL);
            a2.b("crash_cost", String.valueOf(currentTimeMillis));
            a2.a("crash_cost", String.valueOf(currentTimeMillis / 1000));
        } catch (Throwable th2) {
            com.apm.insight.c.a();
            com.apm.insight.runtime.j.a(th2, "NPTH_CATCH");
        }
    }

    public d(Context context) {
        this.f252a = context;
    }
}
