package com.inmobi.media;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.ironsource.C3040d4;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* renamed from: com.inmobi.media.te, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2881te {

    /* renamed from: a, reason: collision with root package name */
    public static final C2881te f2715a = new C2881te();
    public static V0 b;

    public static void e() {
        boolean z;
        boolean booleanValue;
        V0 v0;
        try {
            Context d = Uc.d();
            if (d != null) {
                V0 v02 = new V0();
                try {
                    Reflection.getOrCreateKotlinClass(AdvertisingIdClient.class).getSimpleName();
                    try {
                        AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(d);
                        Intrinsics.checkNotNullExpressionValue(advertisingIdInfo, "getAdvertisingIdInfo(...)");
                        v02.a(advertisingIdInfo.getId());
                        v02.a(advertisingIdInfo.isLimitAdTrackingEnabled());
                        b = v02;
                        Boolean bool = AbstractC2564ab.b;
                        if (bool == null) {
                            Context d2 = Uc.d();
                            z = false;
                            if (d2 != null) {
                                ConcurrentHashMap concurrentHashMap = C6.b;
                                C6 a2 = B6.a(d2, "user_info_store");
                                Intrinsics.checkNotNullParameter("user_age_restricted", C3040d4.h.W);
                                AbstractC2564ab.b = Boolean.valueOf(a2.f2249a.getBoolean("user_age_restricted", false));
                            }
                            Boolean bool2 = AbstractC2564ab.b;
                            if (bool2 != null) {
                                booleanValue = bool2.booleanValue();
                            }
                            if (z && (v0 = b) != null) {
                                v0.a((String) null);
                            }
                            return;
                        }
                        booleanValue = bool.booleanValue();
                        z = booleanValue;
                        if (z) {
                            v0.a((String) null);
                        }
                    } catch (Exception unused) {
                        Intrinsics.checkNotNullExpressionValue("te", "TAG");
                    }
                } catch (NoClassDefFoundError unused2) {
                }
            }
        } catch (Exception unused3) {
            Intrinsics.checkNotNullExpressionValue("te", "TAG");
        }
    }

    public static final void f() {
        e();
    }

    public final void a() {
        try {
            e();
            d();
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue("te", "TAG");
        }
    }

    public final V0 b() {
        return b;
    }

    public final Boolean c() {
        V0 v0 = b;
        if (v0 != null) {
            return v0.c();
        }
        return null;
    }

    public final void d() {
        String a2;
        try {
            V0 v0 = b;
            if (v0 == null || (a2 = v0.a()) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue("te", "TAG");
            AbstractC2680h7.a((byte) 2, "te", "Publisher device Id is ".concat(a2));
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue("te", "TAG");
        }
    }

    public final void a(boolean z) {
        V0 v0 = b;
        if (v0 == null) {
            return;
        }
        if (z) {
            v0.a((String) null);
        } else if (v0.a() == null) {
            Uc.a(new Runnable() { // from class: com.inmobi.media.te$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C2881te.f();
                }
            });
        }
    }
}
