package com.fyber.inneractive.sdk.player.ui;

import android.view.ViewGroup;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.util.f1;
import com.fyber.inneractive.sdk.util.k1;

/* loaded from: classes4.dex */
public final class f implements a {
    @Override // com.fyber.inneractive.sdk.player.ui.a
    public final f1 a(UnitDisplayType unitDisplayType, int i, int i2, boolean z, f1 f1Var, int i3, int i4, int i5, int i6) {
        f1 f1Var2;
        if (unitDisplayType == UnitDisplayType.DEFAULT && z) {
            f1Var2 = f1Var;
            k1.a(unitDisplayType, f1Var2, i, i2, i3, i4);
        } else {
            f1Var2 = f1Var;
        }
        f1Var2.f1758a = 0;
        f1Var2.b = 0;
        return f1Var2;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.a
    public final f1 a(UnitDisplayType unitDisplayType, int i, int i2, f1 f1Var, int i3, ViewGroup viewGroup) {
        f1 f1Var2 = new f1(0, 0);
        if (unitDisplayType == UnitDisplayType.SQUARE) {
            int min = Math.min(f1Var.f1758a, i3);
            if (viewGroup != null) {
                viewGroup.getLayoutParams().width = min;
                viewGroup.getLayoutParams().height = min;
            }
            k1.a(unitDisplayType, f1Var2, i, i2, min, min);
            return f1Var2;
        }
        k1.a(unitDisplayType, f1Var2, i, i2, f1Var.f1758a, f1Var.b);
        return f1Var2;
    }
}
