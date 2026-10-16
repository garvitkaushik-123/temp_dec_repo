package com.instagram.common.viewpoint.core;

import android.os.Handler;
import android.os.Looper;

/* renamed from: com.facebook.ads.redexgen.X.4e, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C07194e extends E8 {
    public final /* synthetic */ C4V A00;

    public C07194e(C4V c4v) {
        this.A00 = c4v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.instagram.common.viewpoint.core.UN
    /* renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A03(E9 e9) {
        new Handler(Looper.getMainLooper()).post(new RunnableC1756du(this));
    }
}
