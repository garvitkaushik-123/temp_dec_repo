package com.inmobi.media;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import com.inmobi.commons.core.configs.SignalsConfig;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.db, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2616db {

    /* renamed from: a, reason: collision with root package name */
    public static String f2549a;
    public static C2894ub b;
    public static final SignalsConfig c;
    public static int d;
    public static final Lazy e;

    static {
        LinkedHashMap linkedHashMap = O2.f2380a;
        c = (SignalsConfig) AbstractC2808p5.a("signals", "null cannot be cast to non-null type com.inmobi.commons.core.configs.SignalsConfig", null);
        e = LazyKt.lazy(C2599cb.f2536a);
    }

    public static boolean a(Context context) {
        boolean z;
        Intrinsics.checkNotNullParameter(context, "context");
        if (!L3.G()) {
            return false;
        }
        if (!((Boolean) e.getValue()).booleanValue()) {
            AbstractC2733kb.a(new C2668gb((short) 2230));
            return false;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
            Bundle bundle = applicationInfo.metaData;
            String string = bundle != null ? bundle.getString("com.google.android.play.billingclient.version") : null;
            z = CollectionsKt.contains(c.getPurchases().getVersionList(), string);
            if (!z) {
                AbstractC2733kb.a(new C2701ib(string));
            }
        } catch (Exception unused) {
            z = false;
        }
        if (!z) {
            return false;
        }
        int i = d;
        if (i != 1 && i != 2) {
            return true;
        }
        AbstractC2733kb.a(new C2668gb(i != 1 ? i != 2 ? (short) 0 : (short) 2232 : (short) 2231));
        return false;
    }
}
