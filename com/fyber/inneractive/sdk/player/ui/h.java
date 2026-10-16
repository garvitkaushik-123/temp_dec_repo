package com.fyber.inneractive.sdk.player.ui;

import android.view.ViewGroup;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.util.f1;
import com.fyber.inneractive.sdk.util.k1;

/* loaded from: classes4.dex */
public final class h implements a {
    @Override // com.fyber.inneractive.sdk.player.ui.a
    public final f1 a(UnitDisplayType unitDisplayType, int i, int i2, boolean z, f1 f1Var, int i3, int i4, int i5, int i6) {
        if (f1Var == null) {
            return null;
        }
        if (unitDisplayType == UnitDisplayType.SQUARE) {
            int min = Math.min(i3, i5) - com.fyber.inneractive.sdk.util.o.b(i6 * 2);
            f1Var.f1758a = min;
            f1Var.b = min;
            return f1Var;
        }
        if (unitDisplayType == UnitDisplayType.LANDSCAPE) {
            int min2 = Math.min(i3, i5) - com.fyber.inneractive.sdk.util.o.b(i6 * 2);
            f1Var.f1758a = min2;
            f1Var.b = (min2 * 9) / 16;
            return f1Var;
        }
        if (unitDisplayType == UnitDisplayType.MRECT) {
            f1Var.f1758a = com.fyber.inneractive.sdk.util.o.b(300);
            f1Var.b = com.fyber.inneractive.sdk.util.o.b(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
            return f1Var;
        }
        if (unitDisplayType == UnitDisplayType.DEFAULT && z) {
            k1.a(unitDisplayType, f1Var, i, i2, i3, i4);
            return f1Var;
        }
        f1Var.f1758a = 0;
        f1Var.b = 0;
        return f1Var;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.a
    public final f1 a(UnitDisplayType unitDisplayType, int i, int i2, f1 f1Var, int i3, ViewGroup viewGroup) {
        f1 f1Var2 = new f1(0, 0);
        if (unitDisplayType == UnitDisplayType.SQUARE) {
            int i4 = f1Var.f1758a;
            k1.a(unitDisplayType, f1Var2, i, i2, i4, i4);
            return f1Var2;
        }
        k1.a(unitDisplayType, f1Var2, i, i2, f1Var.f1758a, f1Var.b);
        return f1Var2;
    }
}
