package com.apm.insight.runtime.a;

import android.content.Context;
import com.apm.insight.CrashType;
import com.apm.insight.entity.Header;

/* compiled from: LaunchCrashAssembly.java */
/* loaded from: classes2.dex */
final class k extends c {
    k(Context context, b bVar, d dVar) {
        super(CrashType.LAUNCH, context, bVar, dVar);
    }

    @Override // com.apm.insight.runtime.a.c
    public final com.apm.insight.entity.a a(int i, com.apm.insight.entity.a aVar) {
        com.apm.insight.entity.a a2 = super.a(i, aVar);
        if (i == 0) {
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
            try {
                a2.d().f().put("launch_did", com.apm.insight.i.a.a(this.b));
            } catch (Throwable unused) {
            }
        } else if (i == 5) {
            Header.b(a2.d());
            return a2;
        }
        return a2;
    }
}
