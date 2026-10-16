package com.bytedance.sdk.openadsdk.eli.DbA.eli;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.wC.QX;

/* loaded from: classes3.dex */
public class DbA extends Os {
    public DbA(Context context, ev evVar, AdSlot adSlot) {
        super(context, evVar, adSlot);
    }

    @Override // com.bytedance.sdk.openadsdk.eli.DbA.eli.Os
    protected void eli() {
        this.aAs = new QX(this.wC, this.DbA, this.FC, this.du, false);
        this.eli.eli(((QX) this.aAs).getVideoController());
        Os();
    }

    public com.bytedance.sdk.openadsdk.multipro.DbA.eli DbA() {
        if (this.aAs != null) {
            return ((QX) this.aAs).getVideoModel();
        }
        return null;
    }
}
