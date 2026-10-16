package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdInfo;

/* renamed from: com.ironsource.oa, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public interface InterfaceC3232oa {
    void d(IronSourceError ironSourceError);

    void k();

    void l();

    void n();

    void onAdClicked();

    void onAdLeftApplication();

    void onAdLoadFailed(IronSourceError ironSourceError);

    void onAdLoaded(LevelPlayAdInfo levelPlayAdInfo);
}
