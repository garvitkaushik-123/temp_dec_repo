package com.bytedance.sdk.openadsdk.component.reward.view;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* loaded from: classes3.dex */
public class FC extends com.bytedance.sdk.openadsdk.core.ui.Os {
    private final com.bytedance.sdk.openadsdk.component.reward.eli.eli eli;

    public FC(com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar) {
        super(eliVar.FS);
        this.eli = eliVar;
        if (eliVar.yKf != null || Build.VERSION.SDK_INT < 35) {
            return;
        }
        setFitsSystemWindows(true);
    }

    public void eli(com.bytedance.sdk.openadsdk.component.reward.DbA.DbA dbA) {
        RFEndCardBackUpLayout wC;
        dbA.eli(this);
        if (this.eli.eli != 1 && (wC = dbA.wC()) != null) {
            addView(wC, new FrameLayout.LayoutParams(-1, -1));
        }
        eli(dbA.FC(), this);
        eli(dbA.aAs(), this);
    }

    private void eli(View view, ViewGroup viewGroup) {
        if (view != null) {
            viewGroup.addView(view, new FrameLayout.LayoutParams(-1, -1));
        }
    }
}
