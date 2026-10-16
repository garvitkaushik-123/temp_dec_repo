package com.bytedance.sdk.openadsdk.core.DbA;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.DbA.Os;
import com.bytedance.sdk.openadsdk.core.model.ev;

/* loaded from: classes3.dex */
public abstract class ui extends eli {
    protected abstract void eli(View view, float f, float f2, float f3, float f4, SparseArray<Os.eli> sparseArray, int i, int i2, int i3, boolean z);

    public ui(Context context, ev evVar, String str, int i) {
        super(context, evVar, str, i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.DbA.eli, com.bytedance.sdk.openadsdk.core.DbA.DbA, com.bytedance.sdk.openadsdk.core.DbA.Os
    public void eli(View view, float f, float f2, float f3, float f4, SparseArray<Os.eli> sparseArray, boolean z) {
        if (eli(view, z)) {
            eli(view, f, f2, f3, f4, sparseArray, this.VM, this.Ue, this.KM, z);
        }
        super.eli(view, f, f2, f3, f4, sparseArray, z);
    }
}
