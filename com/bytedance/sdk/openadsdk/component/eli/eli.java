package com.bytedance.sdk.openadsdk.component.eli;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.Vy.DbA.ui;
import com.bytedance.sdk.openadsdk.core.DbA.Os;
import com.bytedance.sdk.openadsdk.core.model.ev;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class eli extends com.bytedance.sdk.openadsdk.core.DbA.eli {
    private final com.bytedance.sdk.openadsdk.component.wC.eli eli;

    public eli(Context context, ev evVar, String str, int i, com.bytedance.sdk.openadsdk.component.wC.eli eliVar) {
        super(context, evVar, str, i);
        this.eli = eliVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.DbA.eli, com.bytedance.sdk.openadsdk.core.DbA.DbA, com.bytedance.sdk.openadsdk.core.DbA.Os
    public void eli(View view, float f, float f2, float f3, float f4, SparseArray<Os.eli> sparseArray, boolean z) {
        if (view.getTag() == "open_ad_click_button_tag") {
            eli("click_bar");
        } else {
            eli("click_material");
        }
        HashMap hashMap = new HashMap();
        hashMap.put("duration", Long.valueOf(this.eli.Os()));
        eli(hashMap);
        super.eli(view, f, f2, f3, f4, sparseArray, z);
        ui.eli(this.MGA, 9);
    }
}
