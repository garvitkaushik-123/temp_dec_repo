package com.inmobi.media;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: classes4.dex */
public final class N {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f2367a;
    public final String b;
    public final boolean c;
    public final AtomicBoolean d;
    public final String e;
    public InterfaceC2971z5 f;

    public N(WeakReference adUnitEventListener, String adtype, boolean z) {
        Intrinsics.checkNotNullParameter(adUnitEventListener, "adUnitEventListener");
        Intrinsics.checkNotNullParameter(adtype, "adtype");
        this.f2367a = adUnitEventListener;
        this.b = adtype;
        this.c = z;
        this.d = new AtomicBoolean(false);
        this.e = String.valueOf(Reflection.getOrCreateKotlinClass(N.class).getSimpleName());
    }

    public final void a(Yd yd) {
        Zd zd;
        AtomicBoolean atomicBoolean;
        if (this.d.getAndSet(true)) {
            InterfaceC2971z5 interfaceC2971z5 = this.f;
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).c(this.e, "skipping as Impression is already Called");
            }
            if (yd != null) {
                U0 u0 = yd.f2499a;
                if (u0 == null || (zd = u0.b) == null || (atomicBoolean = zd.f2509a) == null || !atomicBoolean.getAndSet(true)) {
                    yd.a().put("networkType", L3.q());
                    yd.a().put(IronSourceConstants.EVENTS_ERROR_CODE, (short) 2179);
                    LinkedHashMap a2 = yd.a();
                    Pd pd = Pd.f2401a;
                    Pd.b("AdImpressionSuccessful", a2, Td.f2443a);
                    return;
                }
                return;
            }
            return;
        }
        Zc zc = Zc.f2508a;
        String str = this.b;
        Boolean valueOf = Boolean.valueOf(this.c);
        zc.getClass();
        Zc.a(str, valueOf);
        F0 f0 = (F0) this.f2367a.get();
        if (f0 != null) {
            f0.a(yd);
        } else if (yd != null) {
            yd.c();
        }
        InterfaceC2971z5 interfaceC2971z52 = this.f;
        if (interfaceC2971z52 != null) {
            ((A5) interfaceC2971z52).a(this.e, "==== CHECKPOINT REACHED - IMPRESSION FIRED ====");
        }
        InterfaceC2971z5 interfaceC2971z53 = this.f;
        if (interfaceC2971z53 != null) {
            ((A5) interfaceC2971z53).b();
        }
    }
}
