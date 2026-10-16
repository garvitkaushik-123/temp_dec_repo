package com.instagram.common.viewpoint.core;

import android.os.Bundle;
import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.he, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1987he extends PL {
    public static String[] A01 = {"TEi6qE8rkCQGgGy4v7NzSxsVq0pzva7O", "YDOvw0rnr4UKw3Mnxoslotwc24p8", "a0zjiBNZeYiCSuvwyHtYeell8KyTQ5xY", "ogjV6WpDB35FLp8RKY", "WANqVRIVKxhPnPWopei7e1k0CZWy62T", "aZZWj5Yt51SqLR33GVZjsdPHZCc7cpWa", "7MlacYU9Pwo9bfliYZC3slRrct3tH7Ko", "0XE4m45s2Z74YdVCvJuFI2R02XTQtmXa"};
    public final C1984hb A00;

    public C1987he(C1984hb c1984hb) {
        this.A00 = c1984hb;
    }

    @Override // com.instagram.common.viewpoint.core.PL
    public final void A08(View view, Q6 q6) {
        super.A08(view, q6);
        if (!this.A00.A0B() && this.A00.A01.getLayoutManager() != null) {
            R2 layoutManager = this.A00.A01.getLayoutManager();
            if (A01[1].length() != 28) {
                throw new RuntimeException();
            }
            A01[4] = "lLG2rM4BR6TSMRI6WEis0bH1e3aTZeM";
            layoutManager.A1E(view, q6);
        }
    }

    @Override // com.instagram.common.viewpoint.core.PL
    public final boolean A09(View view, int i, Bundle bundle) {
        if (super.A09(view, i, bundle)) {
            return true;
        }
        if (!this.A00.A0B() && this.A00.A01.getLayoutManager() != null) {
            return this.A00.A01.getLayoutManager().A1Z(view, i, bundle);
        }
        return false;
    }
}
