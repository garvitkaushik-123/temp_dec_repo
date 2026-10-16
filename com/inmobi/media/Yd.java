package com.inmobi.media;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Yd {

    /* renamed from: a, reason: collision with root package name */
    public final U0 f2499a;
    public final String b;
    public final String c;
    public final String d;
    public String e;

    public Yd(U0 u0, String str, String str2, String markupType) {
        Intrinsics.checkNotNullParameter(markupType, "markupType");
        this.f2499a = u0;
        this.b = str;
        this.c = str2;
        this.d = markupType;
    }

    public final LinkedHashMap a() {
        String m;
        String q;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        U0 u0 = this.f2499a;
        if (u0 != null && (q = u0.f2445a.q()) != null) {
            linkedHashMap.put("adType", q);
        }
        U0 u02 = this.f2499a;
        if (u02 != null) {
            linkedHashMap.put("plId", Long.valueOf(u02.f2445a.I().l()));
        }
        U0 u03 = this.f2499a;
        if (u03 != null && (m = u03.f2445a.I().m()) != null) {
            linkedHashMap.put("plType", m);
        }
        U0 u04 = this.f2499a;
        String str = null;
        if (u04 != null) {
            C2947y0 y = u04.f2445a.y();
            Boolean o = y != null ? y.o() : null;
            if (o != null) {
                linkedHashMap.put("isRewarded", o);
            }
        }
        String str2 = this.c;
        if (str2 != null) {
            linkedHashMap.put("creativeId", str2);
        }
        String str3 = this.b;
        if (str3 != null) {
            linkedHashMap.put("creativeType", str3);
        }
        linkedHashMap.put("markupType", this.d);
        String str4 = this.e;
        if (str4 != null) {
            str = str4;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("triggerSource");
        }
        linkedHashMap.put("trigger", str);
        U0 u05 = this.f2499a;
        if (u05 != null && u05.a().length() > 0) {
            linkedHashMap.put("metadataBlob", this.f2499a.a());
        }
        return linkedHashMap;
    }

    public final void b() {
        Zd zd;
        AtomicBoolean atomicBoolean;
        U0 u0 = this.f2499a;
        if (u0 == null || (zd = u0.b) == null || (atomicBoolean = zd.f2509a) == null || !atomicBoolean.getAndSet(true)) {
            a().put("networkType", L3.q());
            a().put(IronSourceConstants.EVENTS_ERROR_CODE, (short) 2180);
            LinkedHashMap a2 = a();
            Pd pd = Pd.f2401a;
            Pd.b("AdImpressionSuccessful", a2, Td.f2443a);
        }
    }

    public final void c() {
        Zd zd;
        AtomicBoolean atomicBoolean;
        U0 u0 = this.f2499a;
        if (u0 == null || (zd = u0.b) == null || (atomicBoolean = zd.f2509a) == null || !atomicBoolean.getAndSet(true)) {
            a().put("networkType", L3.q());
            a().put(IronSourceConstants.EVENTS_ERROR_CODE, (short) 2177);
            LinkedHashMap a2 = a();
            Pd pd = Pd.f2401a;
            Pd.b("AdImpressionSuccessful", a2, Td.f2443a);
        }
    }

    public final void d() {
        Zd zd;
        AtomicBoolean atomicBoolean;
        U0 u0 = this.f2499a;
        if (u0 == null || (zd = u0.b) == null || (atomicBoolean = zd.f2509a) == null || !atomicBoolean.getAndSet(true)) {
            a().put("networkType", L3.q());
            a().put(IronSourceConstants.EVENTS_ERROR_CODE, (short) 0);
            LinkedHashMap a2 = a();
            Pd pd = Pd.f2401a;
            Pd.b("AdImpressionSuccessful", a2, Td.f2443a);
        }
    }
}
