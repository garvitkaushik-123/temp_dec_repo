package com.inmobi.media;

import com.inmobi.commons.core.configs.AdConfig;
import com.inmobi.commons.core.configs.Config;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public abstract class Fa {

    /* renamed from: a, reason: collision with root package name */
    public final Pa f2284a;
    public final Ba b;
    public final Ka c;
    public volatile Ca d;
    public final ConcurrentHashMap e;
    public AdConfig.PingsV2Config f;

    public Fa(Pa dao, Ba ba, Ka networkHandler) {
        Intrinsics.checkNotNullParameter(dao, "dao");
        Intrinsics.checkNotNullParameter(networkHandler, "networkHandler");
        this.f2284a = dao;
        this.b = ba;
        this.c = networkHandler;
        this.d = Ca.f2252a;
        this.e = new ConcurrentHashMap();
        Ea ea = new Ea(this);
        LinkedHashMap linkedHashMap = O2.f2380a;
        Config a2 = M2.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, Uc.b(), ea);
        Intrinsics.checkNotNull(a2, "null cannot be cast to non-null type com.inmobi.commons.core.configs.AdConfig");
        this.f = ((AdConfig) a2).getPingV2();
    }

    public final void a(final C2976za ping, ExecutorService executorService, final Function1 onPingResponse) {
        Intrinsics.checkNotNullParameter(ping, "ping");
        Intrinsics.checkNotNullParameter(onPingResponse, "onPingResponse");
        if (this.d == Ca.f2252a || this.e.containsKey(ping.b)) {
            return;
        }
        this.e.put(ping.b, ping.f2774a);
        if (executorService != null) {
            executorService.execute(new Runnable() { // from class: com.inmobi.media.Fa$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    Fa.a(Function1.this, this, ping);
                }
            });
        }
    }

    public static final void a(Function1 onPingResponse, Fa this$0, C2976za ping) {
        Intrinsics.checkNotNullParameter(onPingResponse, "$onPingResponse");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ping, "$ping");
        onPingResponse.invoke(this$0.c.a(ping));
        this$0.e.remove(ping.b);
    }

    public final boolean a(Ca ca) {
        int ordinal = ca.ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal == 2) {
                    if (this.d.compareTo(Ca.c) >= 0) {
                        return false;
                    }
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else if (this.d != Ca.c) {
                return false;
            }
        } else if (this.d == Ca.f2252a) {
            return false;
        }
        return true;
    }
}
