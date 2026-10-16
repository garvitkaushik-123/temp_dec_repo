package com.bytedance.sdk.openadsdk.core.MGA.eli;

import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.component.adexpress.DbA.du;
import com.bytedance.sdk.openadsdk.core.DbA.Os;
import com.bytedance.sdk.openadsdk.core.model.aqO;
import com.bytedance.sdk.openadsdk.utils.SSo;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class eli extends Os implements com.bytedance.sdk.component.adexpress.dynamic.MGA.eli {
    protected WeakReference<View> DbA;
    private du Os;
    protected WeakReference<View> eli;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.MGA.eli
    public void eli(du duVar) {
        this.Os = duVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.MGA.eli
    public void eli(View view) {
        this.eli = new WeakReference<>(view);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.MGA.eli
    public void DbA(View view) {
        this.DbA = new WeakReference<>(view);
    }

    @Override // com.bytedance.sdk.openadsdk.core.DbA.Os
    public void eli(View view, float f, float f2, float f3, float f4, SparseArray<Os.eli> sparseArray, boolean z) {
        eli(view, ((Integer) view.getTag()).intValue(), f, f2, f3, f4, sparseArray);
    }

    private void eli(View view, int i, float f, float f2, float f3, float f4, SparseArray<Os.eli> sparseArray) {
        if (this.Os != null) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            WeakReference<View> weakReference = this.DbA;
            if (weakReference != null) {
                int[] eli = SSo.eli(weakReference.get());
                if (eli != null) {
                    iArr = eli;
                }
                int[] Os = SSo.Os(this.DbA.get());
                if (Os != null) {
                    iArr2 = Os;
                }
            }
            String str = "";
            try {
                if (view.getTag(com.bytedance.sdk.component.adexpress.dynamic.eli.bf) != null) {
                    str = String.valueOf(view.getTag(com.bytedance.sdk.component.adexpress.dynamic.eli.bf));
                }
            } catch (Exception unused) {
            }
            this.Os.eli(view, i, new aqO.eli().aGH(f).Os(f2).DbA(f3).eli(f4).DbA(this.gG).eli(this.ujq).aGH(iArr[0]).ui(iArr[1]).MGA(iArr2[0]).kb(iArr2[1]).eli(sparseArray).eli(this.oWW).eli(str).eli());
        }
    }
}
