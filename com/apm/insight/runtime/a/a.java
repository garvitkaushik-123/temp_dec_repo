package com.apm.insight.runtime.a;

import android.content.Context;
import com.apm.insight.CrashType;
import com.apm.insight.entity.Header;

/* compiled from: ANRAssembly.java */
/* loaded from: classes2.dex */
final class a extends c {
    a(Context context, b bVar, d dVar) {
        super(CrashType.ANR, context, bVar, dVar);
    }

    @Override // com.apm.insight.runtime.a.c
    public final com.apm.insight.entity.a a(com.apm.insight.entity.a aVar) {
        com.apm.insight.entity.a a2 = super.a(aVar);
        Header a3 = Header.a(this.b);
        Header.a(a3);
        Header.b(a3);
        a3.c();
        a3.d();
        a3.e();
        a2.a(a3);
        a2.a("process_name", (Object) com.apm.insight.l.a.b());
        com.apm.insight.a.a(a2, a3, this.f316a);
        return a2;
    }
}
