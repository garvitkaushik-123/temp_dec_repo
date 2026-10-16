package com.apm.insight.j;

import android.content.Context;
import android.os.Handler;
import com.apm.insight.e;
import com.apm.insight.runtime.m;
import com.apm.insight.runtime.o;
import java.util.Map;

/* compiled from: CommonParamsTask.java */
/* loaded from: classes2.dex */
public final class b extends a {
    private static Runnable b = new Runnable() { // from class: com.apm.insight.j.b.1
        @Override // java.lang.Runnable
        public final void run() {
            m.a().a().removeCallbacks(this);
            m.a().a(new b(m.a().a(), e.g()));
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private Context f262a;

    public b(Handler handler, Context context) {
        super(handler, 30000L);
        this.f262a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Map<String, Object> map;
        try {
            map = e.a().c().getCommonParams();
        } catch (Throwable unused) {
            map = null;
        }
        if (map != null) {
            try {
                if (com.apm.insight.nativecrash.b.a(map)) {
                    a(b());
                }
            } catch (Throwable unused2) {
                return;
            }
        }
        o.a().a(map, com.apm.insight.entity.b.b());
    }

    public static void c() {
        m.a().a(b, 100L);
    }
}
