package com.bytedance.sdk.openadsdk.component.FC;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.model.aqO;
import com.bytedance.sdk.openadsdk.core.wC.Xb;

/* loaded from: classes3.dex */
public class eli extends com.bytedance.sdk.openadsdk.core.wC.eli {
    private Xb eli;

    public eli(Context context) {
        super(context);
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.eli
    protected void eli(View view, int i, aqO aqo) {
        Xb xb = this.eli;
        if (xb != null) {
            xb.eli(view, i, aqo);
        }
    }

    public void eli(Xb xb) {
        this.eli = xb;
        xb.addView(this, new FrameLayout.LayoutParams(-1, -1));
    }
}
