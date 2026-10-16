package com.inmobi.media;

import android.util.Base64;
import com.inmobi.commons.core.configs.AdConfig;
import com.inmobi.commons.core.configs.RootConfig;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* renamed from: com.inmobi.media.oe, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC2800oe {
    public static String a(Map map, String str) {
        HashMap hashMap;
        EnumC2560a7 enumC2560a7 = Cb.f2253a;
        A5 a2 = Cb.a("getToken", "AB", false);
        long currentTimeMillis = System.currentTimeMillis();
        if (map != null) {
            Vc.a((String) map.get("tp"));
            Vc.b((String) map.get("tp-v"));
        }
        a();
        if (!Uc.q()) {
            if (a2 != null) {
                Intrinsics.checkNotNullExpressionValue("com.inmobi.media.oe", "LOG_TAG");
                a2.b("com.inmobi.media.oe", "InMobi SDK is not initialised. Cannot fetch a token.");
            }
            a(90, currentTimeMillis, a2);
            return null;
        }
        LinkedHashMap linkedHashMap = O2.f2380a;
        RootConfig rootConfig = (RootConfig) AbstractC2808p5.a("root", "null cannot be cast to non-null type com.inmobi.commons.core.configs.RootConfig", null);
        if (rootConfig.getMonetizationDisabled()) {
            a(2012, currentTimeMillis, a2);
            if (a2 != null) {
                Intrinsics.checkNotNullExpressionValue("com.inmobi.media.oe", "LOG_TAG");
                a2.b("com.inmobi.media.oe", "Monetization disabled. cannot provide token");
            }
            return null;
        }
        AdConfig adConfig = (AdConfig) AbstractC2808p5.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, "null cannot be cast to non-null type com.inmobi.commons.core.configs.AdConfig", null);
        C2817pe c2817pe = new C2817pe(new C2897ue(adConfig.getIncludeIds()), a2, rootConfig, adConfig);
        c2817pe.C = map;
        c2817pe.B = str;
        HashMap hashMapOf = MapsKt.hashMapOf(TuplesKt.to("h-user-agent", Uc.k()));
        if (hashMapOf != null && (hashMap = c2817pe.k) != null) {
            hashMap.putAll(hashMapOf);
        }
        c2817pe.f();
        if (!c2817pe.d) {
            if (a2 != null) {
                Intrinsics.checkNotNullExpressionValue("com.inmobi.media.oe", "LOG_TAG");
                a2.b("com.inmobi.media.oe", "get Signals failed - GDPR Compliance");
            }
            a(2141, currentTimeMillis, a2);
            return null;
        }
        a(currentTimeMillis, a2);
        if (a2 != null) {
            Intrinsics.checkNotNullExpressionValue("com.inmobi.media.oe", "LOG_TAG");
            a2.a("com.inmobi.media.oe", "get signals success");
        }
        String c = c2817pe.c();
        Charset charset = Charsets.UTF_8;
        byte[] bytes = c.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] encode = Base64.encode(bytes, 8);
        Intrinsics.checkNotNullExpressionValue(encode, "encode(...)");
        return new String(encode, charset);
    }

    public static final void b() {
        HashMap hashMapOf = MapsKt.hashMapOf(TuplesKt.to("networkType", L3.q()), TuplesKt.to("plType", "AB"));
        Pd pd = Pd.f2401a;
        Pd.b("AdGetSignalsCalled", hashMapOf, Td.f2443a);
    }

    public static void a(final int i, final long j, A5 a5) {
        if (a5 != null) {
            Intrinsics.checkNotNullExpressionValue("com.inmobi.media.oe", "LOG_TAG");
            a5.c("com.inmobi.media.oe", "submitAdGetSignalsFailed - errorCode - " + i + ", startTime - " + j);
        }
        Uc.a(new Runnable() { // from class: com.inmobi.media.oe$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC2800oe.a(j, i);
            }
        });
        if (a5 != null) {
            a5.a();
        }
    }

    public static final void a(long j, int i) {
        HashMap hashMapOf = MapsKt.hashMapOf(TuplesKt.to("latency", Long.valueOf(System.currentTimeMillis() - j)), TuplesKt.to("networkType", L3.q()), TuplesKt.to(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i)), TuplesKt.to("plType", "AB"));
        Pd pd = Pd.f2401a;
        Pd.b("AdGetSignalsFailed", hashMapOf, Td.f2443a);
    }

    public static void a(final long j, A5 a5) {
        if (a5 != null) {
            Intrinsics.checkNotNullExpressionValue("com.inmobi.media.oe", "LOG_TAG");
            a5.c("com.inmobi.media.oe", "submitAdGetSignalsSucceeded - startTime - " + j);
        }
        Uc.a(new Runnable() { // from class: com.inmobi.media.oe$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC2800oe.a(j);
            }
        });
        if (a5 != null) {
            a5.a();
        }
    }

    public static final void a(long j) {
        HashMap hashMapOf = MapsKt.hashMapOf(TuplesKt.to("latency", Long.valueOf(System.currentTimeMillis() - j)), TuplesKt.to("networkType", L3.q()), TuplesKt.to("plType", "AB"));
        Pd pd = Pd.f2401a;
        Pd.b("AdGetSignalsSucceeded", hashMapOf, Td.f2443a);
    }

    public static void a() {
        Uc.a(new Runnable() { // from class: com.inmobi.media.oe$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC2800oe.b();
            }
        });
    }
}
