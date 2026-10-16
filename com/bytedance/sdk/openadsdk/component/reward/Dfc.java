package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTClientBidding;

/* loaded from: classes3.dex */
class Dfc implements TTClientBidding {
    private final wC eli;

    Dfc(Context context, com.bytedance.sdk.openadsdk.core.model.eli eliVar, AdSlot adSlot) {
        this.eli = new wC(context, eliVar, adSlot);
    }

    public wC eli() {
        return this.eli;
    }

    public void DbA() {
        this.eli.eli();
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d) {
        this.eli.win(d);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d, String str, String str2) {
        this.eli.loss(d, str, str2);
    }
}
