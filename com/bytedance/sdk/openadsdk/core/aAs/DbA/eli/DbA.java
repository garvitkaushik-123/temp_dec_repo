package com.bytedance.sdk.openadsdk.core.aAs.DbA.eli;

import android.content.Context;
import com.bytedance.adsdk.DbA.MGA;
import com.bytedance.adsdk.ugeno.aGH;

/* loaded from: classes3.dex */
public class DbA extends MGA {
    private aGH eli;

    public DbA(Context context) {
        super(context);
    }

    public void eli(aGH agh) {
        this.eli = agh;
    }

    @Override // com.bytedance.adsdk.DbA.MGA, android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aGH agh = this.eli;
        if (agh != null) {
            agh.kb();
        }
    }

    @Override // com.bytedance.adsdk.DbA.MGA, android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aGH agh = this.eli;
        if (agh != null) {
            agh.wC();
        }
    }
}
