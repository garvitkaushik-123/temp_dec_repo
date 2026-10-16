package com.ironsource;

import android.app.Activity;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdInfo;

/* loaded from: classes6.dex */
public interface B6 {
    void a(Activity activity);

    void a(C3262q6 c3262q6);

    void a(C3262q6 c3262q6, IronSourceError ironSourceError);

    void a(C3262q6 c3262q6, LevelPlayAdInfo levelPlayAdInfo);

    void b(C3262q6 c3262q6, IronSourceError ironSourceError);

    void b(C3262q6 c3262q6, LevelPlayAdInfo levelPlayAdInfo);

    void c(C3262q6 c3262q6, LevelPlayAdInfo levelPlayAdInfo);

    void loadAd();
}
