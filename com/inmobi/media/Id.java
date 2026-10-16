package com.inmobi.media;

import android.net.ConnectivityManager;
import android.net.Network;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Id extends ConnectivityManager.NetworkCallback {
    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        ConcurrentHashMap concurrentHashMap = Jd.f2329a;
        Intrinsics.checkNotNullExpressionValue("Jd", "access$getTAG$p(...)");
        super.onAvailable(network);
        Intrinsics.checkNotNullExpressionValue("Jd", "access$getTAG$p(...)");
        Uc.f().b(new C2607d2(10, 4, "available"));
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        ConcurrentHashMap concurrentHashMap = Jd.f2329a;
        Intrinsics.checkNotNullExpressionValue("Jd", "access$getTAG$p(...)");
        super.onLost(network);
        Uc.f().b(new C2607d2(10, 4, "lost"));
    }
}
