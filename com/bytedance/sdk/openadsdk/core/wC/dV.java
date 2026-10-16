package com.bytedance.sdk.openadsdk.core.wC;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.utils.SSo;

/* loaded from: classes3.dex */
public class dV extends eli {
    private Xb NU;
    private FrameLayout eli;
    private FrameLayout nn;

    public dV(Context context) {
        super(context);
        this.DbA = context;
    }

    public void eli(com.bytedance.sdk.openadsdk.core.model.ev evVar, Xb xb, ViewGroup viewGroup) {
        if (evVar == null) {
            return;
        }
        setBackgroundColor(-1);
        this.Os = evVar;
        this.NU = xb;
        if (evVar.cK() == 7) {
            this.MGA = "rewarded_video";
        } else {
            this.MGA = "fullscreen_interstitial_ad";
        }
        DbA();
        if (com.bytedance.sdk.openadsdk.core.model.Xb.Os(evVar)) {
            this.NU.addView(this, new ViewGroup.LayoutParams(-1, -1));
        } else {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.NU.addView(this, layoutParams);
        }
        View findViewById = viewGroup.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.cmk);
        if (findViewById != null) {
            Object tag = findViewById.getTag(com.bytedance.sdk.openadsdk.utils.aqO.cmk);
            if (tag instanceof String) {
                String str = (String) tag;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                com.bytedance.sdk.openadsdk.nGm.DbA.DbA().eli(str, findViewById);
            }
        }
    }

    private void DbA() {
        this.kb = SSo.DbA(this.DbA, this.NU.getExpectExpressWidth());
        this.wC = SSo.DbA(this.DbA, this.NU.getExpectExpressWidth());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.kb, this.wC);
        }
        layoutParams.width = this.kb;
        layoutParams.height = this.wC;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        this.Os.rn();
        Os();
    }

    private void Os() {
        com.bytedance.sdk.openadsdk.core.ui.Os os = new com.bytedance.sdk.openadsdk.core.ui.Os(this.DbA);
        this.eli = os;
        addView(os, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.ui.Os os2 = new com.bytedance.sdk.openadsdk.core.ui.Os(this.DbA);
        this.nn = os2;
        this.eli.addView(os2, new FrameLayout.LayoutParams(-1, -1));
        this.nn.removeAllViews();
    }

    public FrameLayout getVideoContainer() {
        return this.nn;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.eli
    protected void eli(View view, int i, com.bytedance.sdk.openadsdk.core.model.aqO aqo) {
        Xb xb = this.NU;
        if (xb != null) {
            xb.eli(view, i, aqo);
        }
    }

    public View getBackupContainerBackgroundView() {
        return this.eli;
    }
}
