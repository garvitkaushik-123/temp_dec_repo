package com.inmobi.media;

import java.lang.ref.WeakReference;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class F3 extends Ma {
    public final W9 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F3(Pa dao) {
        super(dao);
        Intrinsics.checkNotNullParameter(dao, "dao");
        this.e = new W9(dao, new E3(this), this.d);
    }

    @Override // com.inmobi.media.Ma
    public final void a(C2976za ping) {
        Intrinsics.checkNotNullParameter(ping, "ping");
        Intrinsics.checkNotNullExpressionValue("F3", "TAG");
        String str = ping.b;
        if (!a(ping.e)) {
            WeakReference weakReference = (WeakReference) this.b.get(ping.h);
            Ma.a(0, "Database capacity exceeded for pings", (short) 2248, ping, System.currentTimeMillis(), weakReference != null ? (La) weakReference.get() : null);
            return;
        }
        Pa pa = this.f2362a;
        Intrinsics.checkNotNullParameter(ping, "ping");
        pa.a(ping);
        W9 w9 = this.e;
        Objects.toString(w9.d);
        if (w9.d == Ca.b) {
            w9.d = Ca.c;
            w9.a();
        }
    }
}
