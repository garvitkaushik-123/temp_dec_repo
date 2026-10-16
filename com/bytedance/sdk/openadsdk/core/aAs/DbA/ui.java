package com.bytedance.sdk.openadsdk.core.aAs.DbA;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;

/* loaded from: classes3.dex */
public class ui extends com.bytedance.adsdk.ugeno.DbA.Os<FrameLayout> {
    public ui(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.Os
    /* renamed from: Os, reason: merged with bridge method [inline-methods] */
    public FrameLayout eli() {
        FrameLayout frameLayout = new FrameLayout(this.DbA);
        com.bytedance.sdk.openadsdk.core.model.DbA dbA = new com.bytedance.sdk.openadsdk.core.model.DbA();
        dbA.eli(true);
        PAGLogoView pAGLogoView = new PAGLogoView(this.DbA);
        pAGLogoView.initData(dbA);
        frameLayout.addView(pAGLogoView);
        return frameLayout;
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.Os
    public void DbA() {
        super.DbA();
    }
}
