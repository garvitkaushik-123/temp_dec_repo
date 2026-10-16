package com.ironsource;

import com.ironsource.O7;
import com.unity3d.mediation.rewarded.LevelPlayReward;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.pd, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3252pd implements O7, O7.a {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, LevelPlayReward> f3642a = new LinkedHashMap();
    private final Map<String, LevelPlayReward> b = new LinkedHashMap();

    @Override // com.ironsource.O7.a
    public void a(String placement, String rewardName, int i) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        Intrinsics.checkNotNullParameter(rewardName, "rewardName");
        this.f3642a.put(placement, new LevelPlayReward(rewardName, i));
    }

    @Override // com.ironsource.O7.a
    public void b(String adUnitId, String rewardName, int i) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(rewardName, "rewardName");
        this.b.put(adUnitId, new LevelPlayReward(rewardName, i));
    }

    private final LevelPlayReward b(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return this.f3642a.get(str);
    }

    @Override // com.ironsource.O7
    public LevelPlayReward a(String str, String adUnitId) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        LevelPlayReward b = b(str);
        return b == null ? a(adUnitId) : b;
    }

    private final LevelPlayReward a(String str) {
        return this.b.get(str);
    }
}
