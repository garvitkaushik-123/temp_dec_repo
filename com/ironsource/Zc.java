package com.ironsource;

import com.unity3d.mediation.LevelPlay;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Zc {

    /* renamed from: a, reason: collision with root package name */
    private final String f3165a;
    private final LevelPlay.AdFormat b;

    public Zc(String placementName, LevelPlay.AdFormat adFormat) {
        Intrinsics.checkNotNullParameter(placementName, "placementName");
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        this.f3165a = placementName;
        this.b = adFormat;
    }

    public final String a() {
        return this.f3165a + "_" + this.b;
    }
}
