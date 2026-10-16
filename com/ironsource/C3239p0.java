package com.ironsource;

import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.p0, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3239p0 {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, R0> f3625a = new HashMap<>();

    /* renamed from: com.ironsource.p0$a */
    public enum a {
        DidntAttemptToLoad,
        FailedToLoad,
        LoadedSuccessfully,
        FailedToShow,
        ShowedSuccessfully,
        NotPartOfWaterfall
    }

    public final R0 a(String adUnitId, List<? extends NetworkSettings> providers, int i) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(providers, "providers");
        R0 r0 = this.f3625a.get(adUnitId);
        if (r0 != null) {
            return r0;
        }
        R0 r02 = new R0(providers, i);
        this.f3625a.put(adUnitId, r02);
        return r02;
    }
}
