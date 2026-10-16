package com.inmobi.media;

import android.net.Network;
import android.os.SystemClock;
import com.inmobi.commons.core.configs.AdConfig;
import com.inmobi.commons.core.configs.Config;
import com.unity3d.services.UnityAdsConstants;
import java.net.InetAddress;
import java.util.LinkedHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.r3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2837r3 implements N2 {

    /* renamed from: a, reason: collision with root package name */
    public static AdConfig.CustomNetworkValidation f2691a;
    public static volatile Network b;
    public static volatile boolean c;
    public static long d;
    public static long e;
    public static final AtomicBoolean f;

    static {
        C2837r3 c2837r3 = new C2837r3();
        LinkedHashMap linkedHashMap = O2.f2380a;
        Config a2 = M2.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, Uc.b(), c2837r3);
        Intrinsics.checkNotNull(a2, "null cannot be cast to non-null type com.inmobi.commons.core.configs.AdConfig");
        f2691a = ((AdConfig) a2).getCustomNwValidation();
        c = true;
        f = new AtomicBoolean(false);
    }

    public static void a(final Network network) {
        long nonValidatedExpiry;
        long j = e;
        if (j != 0) {
            ScheduledExecutorService scheduledExecutorService = Ie.f2319a;
            long elapsedRealtime = SystemClock.elapsedRealtime() - j;
            AdConfig.CustomNetworkValidation customNetworkValidation = f2691a;
            if (elapsedRealtime < (customNetworkValidation != null ? customNetworkValidation.getRefreshDebounceTime() : 1000L)) {
                return;
            }
        }
        e = SystemClock.elapsedRealtime();
        if (Intrinsics.areEqual(b, network)) {
            long j2 = d;
            ScheduledExecutorService scheduledExecutorService2 = Ie.f2319a;
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - j2;
            if (c) {
                AdConfig.CustomNetworkValidation customNetworkValidation2 = f2691a;
                nonValidatedExpiry = customNetworkValidation2 != null ? customNetworkValidation2.getValidatedExpiry() : UnityAdsConstants.Timeout.INIT_TIMEOUT_MS;
            } else {
                AdConfig.CustomNetworkValidation customNetworkValidation3 = f2691a;
                nonValidatedExpiry = customNetworkValidation3 != null ? customNetworkValidation3.getNonValidatedExpiry() : 30000L;
            }
            if (elapsedRealtime2 <= nonValidatedExpiry) {
                return;
            }
        }
        if (f.compareAndSet(false, true)) {
            ((ScheduledThreadPoolExecutor) AbstractC2970z4.c.getValue()).execute(new Runnable() { // from class: com.inmobi.media.r3$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C2837r3.b(network);
                }
            });
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:0|1|(2:2|3)|(6:7|8|9|10|11|12)|19|9|10|11|12|(2:(1:17)|(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
    
        r1 = com.inmobi.media.S5.f2425a;
        r1 = new com.inmobi.media.C2640f2(r3);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, "event");
        com.inmobi.media.S5.d.a(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void b(Network network) {
        boolean z;
        AdConfig.CustomNetworkValidation customNetworkValidation;
        String urlDomain;
        Intrinsics.checkNotNullParameter(network, "$network");
        try {
            try {
                customNetworkValidation = f2691a;
            } finally {
                f.set(false);
            }
        } catch (Exception unused) {
        }
        if (customNetworkValidation != null && (urlDomain = customNetworkValidation.getUrlDomain()) != null) {
            z = !Intrinsics.areEqual(InetAddress.getByName(urlDomain).toString(), "");
            c = z;
            b = network;
            d = SystemClock.elapsedRealtime();
        }
        z = false;
        c = z;
        b = network;
        d = SystemClock.elapsedRealtime();
    }

    @Override // com.inmobi.media.N2
    public final void a(Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (config instanceof AdConfig) {
            f2691a = ((AdConfig) config).getCustomNwValidation();
        }
    }
}
