package com.apm.insight.runtime.a;

import android.content.Context;
import com.apm.insight.CrashType;
import com.apm.insight.entity.Header;

/* compiled from: EnsureAssembly.java */
/* loaded from: classes2.dex */
public final class i extends c {
    @Override // com.apm.insight.runtime.a.c
    protected final boolean b() {
        return false;
    }

    @Override // com.apm.insight.runtime.a.c
    protected final boolean c() {
        return false;
    }

    i(Context context, b bVar, d dVar) {
        super(CrashType.ENSURE, context, bVar, dVar);
    }

    @Override // com.apm.insight.runtime.a.c
    public final com.apm.insight.entity.a a(com.apm.insight.entity.a aVar) {
        com.apm.insight.entity.a a2 = super.a(aVar);
        com.apm.insight.a.a(a2, (Header) null, this.f316a);
        return a2;
    }
}
