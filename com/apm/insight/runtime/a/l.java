package com.apm.insight.runtime.a;

import android.content.Context;
import com.apm.insight.CrashType;
import com.apm.insight.entity.Header;
import com.apm.insight.nativecrash.NativeCrashCollector;

/* compiled from: NativeCrashAssembly.java */
/* loaded from: classes2.dex */
final class l extends c {
    @Override // com.apm.insight.runtime.a.c
    protected final boolean c() {
        return false;
    }

    l(Context context, b bVar, d dVar) {
        super(CrashType.NATIVE, context, bVar, dVar);
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
        if (i != 1) {
            if (i != 2) {
                return a2;
            }
            Header.a(a2.d());
            return a2;
        }
        Header d = a2.d();
        d.d();
        d.e();
        return a2;
    }

    @Override // com.apm.insight.runtime.a.c
    public final int a() {
        return NativeCrashCollector.a();
    }
}
