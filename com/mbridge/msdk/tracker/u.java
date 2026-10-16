package com.mbridge.msdk.tracker;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.ironsource.C3040d4;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: ReportMonitor.java */
/* loaded from: classes6.dex */
public class u {
    private static volatile u g;

    /* renamed from: a, reason: collision with root package name */
    private m f4974a;
    private x b;
    private volatile boolean c = false;
    private int d = 30000;
    private final HashMap<String, String> e = new HashMap<>();
    Handler f = new a(Looper.getMainLooper());

    /* compiled from: ReportMonitor.java */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 1) {
                return;
            }
            try {
                u.this.b();
                u.this.f.removeMessages(1);
                u.this.d();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private u() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            this.f.sendEmptyMessageDelayed(1, this.d);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b() {
        m[] b = m.b();
        if (b.length == 0) {
            return;
        }
        try {
            for (m mVar : b) {
                String f = mVar.f();
                if (!"monitor".equals(f)) {
                    String d = mVar.d();
                    long[] e = mVar.e();
                    long j = e[1];
                    if (j != 0) {
                        long j2 = e[0];
                        if (this.e.containsKey(f)) {
                            if ((j2 + "").equals(this.e.get(f))) {
                            }
                        }
                        this.e.put(f, j2 + "");
                        if (this.f4974a != null) {
                            try {
                                e eVar = new e("event_lib_monitor");
                                eVar.a(1);
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put(C3040d4.h.W, "m_report_rate");
                                jSONObject.put("task_name", f);
                                jSONObject.put("task_count", j);
                                jSONObject.put("task_session_id", d);
                                jSONObject.put("task_ts", j2);
                                eVar.a(jSONObject);
                                this.f4974a.d(eVar);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public synchronized void c() {
        if (this.c) {
            return;
        }
        this.c = true;
        d();
    }

    public void a(Context context, x xVar, int i, JSONObject jSONObject) {
        this.b = xVar;
        this.d = i;
        m a2 = m.a("monitor", context, xVar);
        this.f4974a = a2;
        if (a2 != null) {
            a2.a(jSONObject);
            this.f4974a.h();
        }
        c();
    }

    public static u a() {
        if (g == null) {
            synchronized (u.class) {
                if (g == null) {
                    g = new u();
                }
            }
        }
        return g;
    }
}
