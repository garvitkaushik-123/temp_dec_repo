package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;

/* loaded from: classes3.dex */
public class nGm extends MGA {
    public DbA eli;

    public nGm(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar) {
        super(context, dynamicRootView, wCVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.MGA, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.nro
    public boolean FC() {
        return super.FC();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui
    protected DbA eli(Bitmap bitmap) {
        eli eliVar = new eli(bitmap, this.eli);
        this.eli = eliVar;
        return eliVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui
    protected GradientDrawable getDrawable() {
        DbA dbA = new DbA();
        this.eli = dbA;
        return dbA;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ui
    protected GradientDrawable eli(GradientDrawable.Orientation orientation, int[] iArr) {
        DbA dbA = new DbA(orientation, iArr);
        this.eli = dbA;
        return dbA;
    }
}
