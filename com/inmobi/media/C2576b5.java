package com.inmobi.media;

import java.lang.ref.WeakReference;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.b5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2576b5 extends Ma {
    public final O4 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2576b5(Pa dao) {
        super(dao);
        Intrinsics.checkNotNullParameter(dao, "dao");
        this.e = new O4(dao, new C2558a5(this), this.d);
    }

    @Override // com.inmobi.media.Ma
    public final void a(C2976za ping) {
        Intrinsics.checkNotNullParameter(ping, "ping");
        try {
            String str = ping.b;
            WeakReference weakReference = (WeakReference) this.b.get(ping.h);
            La la = weakReference != null ? (La) weakReference.get() : null;
            if (!a(ping.e)) {
                Ma.a(0, "Database capacity exceeded for pings", (short) 2248, ping, System.currentTimeMillis(), la);
                return;
            }
            Pa pa = this.f2362a;
            Intrinsics.checkNotNullParameter(ping, "ping");
            pa.a(ping);
            O4 o4 = this.e;
            Objects.toString(o4.d);
            if (o4.d == Ca.b) {
                o4.d = Ca.c;
                o4.a();
                o4.d();
            }
            Da a2 = this.d.a(ping);
            if (Ga.a(a2)) {
                String str2 = a2.f2264a.b;
                b(a2, la);
            } else {
                String str3 = a2.f2264a.b;
                a(a2, la);
            }
        } catch (Error e) {
            WeakReference weakReference2 = (WeakReference) this.b.get(ping.h);
            Ma.a(0, e.getMessage(), (short) 2251, ping, System.currentTimeMillis(), weakReference2 != null ? (La) weakReference2.get() : null);
        } catch (Exception e2) {
            WeakReference weakReference3 = (WeakReference) this.b.get(ping.h);
            Ma.a(0, e2.getMessage(), (short) 2250, ping, System.currentTimeMillis(), weakReference3 != null ? (La) weakReference3.get() : null);
        }
    }
}
