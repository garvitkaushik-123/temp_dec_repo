package com.ironsource;

import android.app.Activity;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdInfo;

/* loaded from: classes6.dex */
public interface I6 {
    void a();

    void a(Activity activity);

    void a(IronSourceError ironSourceError);

    void a(LevelPlayAdInfo levelPlayAdInfo);

    void b(IronSourceError ironSourceError);

    void b(LevelPlayAdInfo levelPlayAdInfo);

    void c(LevelPlayAdInfo levelPlayAdInfo);

    void loadAd();
}
