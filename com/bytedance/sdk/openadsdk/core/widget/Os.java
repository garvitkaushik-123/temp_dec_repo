package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.SSo;

/* loaded from: classes3.dex */
public class Os extends com.bytedance.sdk.openadsdk.core.ui.aGH {
    public Os(Context context) {
        super(context);
        eli();
    }

    private void eli() {
        setVisibility(8);
        setId(com.bytedance.sdk.openadsdk.utils.aqO.Zo);
    }

    public void eli(int i, ev evVar) {
        if (evVar.Kv() || (evVar.Jt() && evVar.nGm())) {
            SSo.eli((View) this, 0);
            com.bytedance.sdk.openadsdk.nGm.DbA.DbA().eli((int) SSo.eli(getContext(), i, true), this, evVar);
        }
    }
}
