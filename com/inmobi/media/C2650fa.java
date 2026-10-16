package com.inmobi.media;

import com.inmobi.commons.core.configs.AdConfig;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Dispatcher;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/* renamed from: com.inmobi.media.fa, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2650fa implements Ja {

    /* renamed from: a, reason: collision with root package name */
    public final G5 f2570a;

    public C2650fa(AdConfig.PingsV2Config pingsConfig) {
        Intrinsics.checkNotNullParameter(pingsConfig, "pingsConfig");
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(pingsConfig.getMaxBatchSize().getHigh());
        Unit unit = Unit.INSTANCE;
        C2687he timeoutConfig = new C2687he(pingsConfig.getConnectTimeout(), pingsConfig.getReadTimeout(), pingsConfig.getCallTimeout());
        Interceptor[] interceptors = new Interceptor[0];
        Intrinsics.checkNotNullParameter(interceptors, "interceptors");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(timeoutConfig, "timeoutConfig");
        this.f2570a = new G5(interceptors, dispatcher, timeoutConfig);
    }

    @Override // com.inmobi.media.Ja
    public final Object a(C2976za ping) {
        Intrinsics.checkNotNullParameter(ping, "ping");
        HashMap hashMap = new HashMap(ping.c);
        hashMap.put("user-agent", Uc.k());
        L9 request = new L9(ping.f2774a, hashMap, ping.d);
        G5 g5 = this.f2570a;
        g5.getClass();
        Intrinsics.checkNotNullParameter(request, "request");
        C2591c3 c2591c3 = g5.f2292a;
        c2591c3.getClass();
        Intrinsics.checkNotNullParameter(request, "request");
        OkHttpClient okHttpClient = c2591c3.f2531a;
        Request.Builder url = new Request.Builder().url(request.f2352a);
        for (Map.Entry entry : hashMap.entrySet()) {
            url.addHeader((String) entry.getKey(), (String) entry.getValue());
        }
        url.get();
        Pair pair = new Pair(url.build(), null);
        Request request2 = (Request) pair.component1();
        C2807p4 c2807p4 = (C2807p4) pair.component2();
        return c2807p4 != null ? c2807p4 : c2591c3.a(okHttpClient, request2, request.f2352a);
    }
}
