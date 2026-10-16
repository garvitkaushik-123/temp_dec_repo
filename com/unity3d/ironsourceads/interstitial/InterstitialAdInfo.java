package com.unity3d.ironsourceads.interstitial;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class InterstitialAdInfo {

    /* renamed from: a, reason: collision with root package name */
    private final String f6431a;
    private final String b;

    public InterstitialAdInfo(String instanceId, String adId) {
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        Intrinsics.checkNotNullParameter(adId, "adId");
        this.f6431a = instanceId;
        this.b = adId;
    }

    public final String getAdId() {
        return this.b;
    }

    public final String getInstanceId() {
        return this.f6431a;
    }

    public String toString() {
        return "[instanceId: '" + this.f6431a + "', adId: '" + this.b + "']";
    }
}
