package com.apm.insight.runtime.a;

import android.content.Context;
import com.apm.insight.CrashType;
import com.apm.insight.entity.Header;
import com.apm.insight.runtime.a.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* compiled from: CrashContextAssembly.java */
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private static volatile f f320a;
    private Context b;
    private Map<CrashType, c> c = new HashMap();
    private b d;
    private d e;

    private f(Context context) {
        this.b = context;
        try {
            this.d = b.d();
            this.e = new d(this.b);
        } catch (Throwable th) {
            com.apm.insight.c.a();
            com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
        }
    }

    public static f a() {
        if (f320a == null) {
            Context g = com.apm.insight.e.g();
            if (g == null) {
                throw new IllegalArgumentException("NpthBus not init");
            }
            f320a = new f(g);
        }
        return f320a;
    }

    private c a(CrashType crashType) {
        c cVar = this.c.get(crashType);
        if (cVar != null) {
            return cVar;
        }
        switch (AnonymousClass1.f321a[crashType.ordinal()]) {
            case 1:
                cVar = new j(this.b, this.d, this.e);
                break;
            case 2:
                cVar = new k(this.b, this.d, this.e);
                break;
            case 3:
                cVar = new l(this.b, this.d, this.e);
                break;
            case 4:
                cVar = new a(this.b, this.d, this.e);
                break;
            case 5:
                cVar = new h(this.b, this.d, this.e);
                break;
            case 6:
                cVar = new g(this.b, this.d, this.e);
                break;
            case 7:
                cVar = new e(this.b, this.d, this.e);
                break;
            case 8:
                cVar = new i(this.b, this.d, this.e);
                break;
        }
        if (cVar != null) {
            this.c.put(crashType, cVar);
        }
        return cVar;
    }

    /* compiled from: CrashContextAssembly.java */
    /* renamed from: com.apm.insight.runtime.a.f$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f321a;

        static {
            int[] iArr = new int[CrashType.values().length];
            f321a = iArr;
            try {
                iArr[CrashType.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f321a[CrashType.LAUNCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f321a[CrashType.NATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f321a[CrashType.ANR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f321a[CrashType.DART.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f321a[CrashType.CUSTOM_JAVA.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f321a[CrashType.BLOCK.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f321a[CrashType.ENSURE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public final com.apm.insight.entity.a a(CrashType crashType, c.a aVar) {
        c a2;
        if (crashType == null || (a2 = a(crashType)) == null) {
            return null;
        }
        return a2.a(null, aVar, true);
    }

    public final com.apm.insight.entity.a a(CrashType crashType, com.apm.insight.entity.a aVar) {
        c a2;
        return (crashType == null || (a2 = a(crashType)) == null) ? aVar : a2.a(aVar, null, false);
    }

    public final com.apm.insight.entity.a a(List<com.apm.insight.entity.a> list, JSONArray jSONArray) {
        if (list.isEmpty()) {
            return null;
        }
        com.apm.insight.entity.a aVar = new com.apm.insight.entity.a();
        JSONArray jSONArray2 = new JSONArray();
        Iterator<com.apm.insight.entity.a> it = list.iterator();
        while (it.hasNext()) {
            jSONArray2.put(it.next().c());
        }
        aVar.a("data", (Object) jSONArray2);
        aVar.a("all_data", (Object) jSONArray);
        Header a2 = Header.a(this.b);
        Header.a(a2);
        a2.c();
        a2.d();
        a2.e();
        Header.b(a2);
        aVar.a(a2);
        return aVar;
    }
}
