package com.ironsource;

import android.content.Context;
import com.ironsource.Wc;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.BasePlacement;

/* loaded from: classes6.dex */
public interface L7 {

    public interface a {
        void a(Context context, String str, IronSource.AD_UNIT ad_unit);

        void b(Context context, BasePlacement basePlacement, IronSource.AD_UNIT ad_unit);
    }

    Wc.b a(Context context, BasePlacement basePlacement, IronSource.AD_UNIT ad_unit);

    boolean c(Context context, BasePlacement basePlacement, IronSource.AD_UNIT ad_unit);
}
