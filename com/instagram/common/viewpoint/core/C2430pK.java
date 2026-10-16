package com.instagram.common.viewpoint.core;

import android.os.Handler;
import android.os.Message;

/* renamed from: com.facebook.ads.redexgen.X.pK, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2430pK implements C4W {
    public Message A00;
    public C2429pJ A01;

    public C2430pK() {
    }

    private void A00() {
        this.A00 = null;
        this.A01 = null;
        C2429pJ.A01(this);
    }

    public final C2430pK A01(Message message, C2429pJ c2429pJ) {
        this.A00 = message;
        this.A01 = c2429pJ;
        return this;
    }

    public final void A02() {
        ((Message) AbstractC07133y.A01(this.A00)).sendToTarget();
        A00();
    }

    public final boolean A03(Handler handler) {
        boolean success = handler.sendMessageAtFrontOfQueue((Message) AbstractC07133y.A01(this.A00));
        A00();
        return success;
    }
}
