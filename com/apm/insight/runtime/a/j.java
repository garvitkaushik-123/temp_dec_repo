package com.apm.insight.runtime.a;

import android.content.Context;
import com.apm.insight.CrashType;
import com.apm.insight.entity.Header;

/* compiled from: JavaCrashAssembly.java */
/* loaded from: classes2.dex */
final class j extends c {
    j(Context context, b bVar, d dVar) {
        super(CrashType.JAVA, context, bVar, dVar);
    }

    @Override // com.apm.insight.runtime.a.c
    public final com.apm.insight.entity.a a(int i, com.apm.insight.entity.a aVar) {
        com.apm.insight.entity.a a2 = super.a(i, aVar);
        if (i == 0) {
            a2.a("app_count", (Object) 1);
            a2.a("magic_tag", "ss_app_log");
            Header a3 = Header.a(this.b);
            a3.c();
            a2.a(a3);
            com.apm.insight.a.a(a2, a3, this.f316a);
            return a2;
        }
        if (i == 1) {
            Header d = a2.d();
            d.d();
            d.e();
            return a2;
        }
        if (i == 2) {
            Header.a(a2.d());
            return a2;
        }
        if (i != 5) {
            return a2;
        }
        Header.b(a2.d());
        return a2;
    }
}
