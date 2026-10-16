package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTClientBidding;

/* loaded from: classes3.dex */
class nn implements TTClientBidding {
    private final MGA eli;

    nn(Context context, com.bytedance.sdk.openadsdk.core.model.eli eliVar) {
        this.eli = new MGA(context, eliVar);
    }

    public MGA eli() {
        return this.eli;
    }

    public void eli(boolean z) {
        this.eli.eli(z);
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
