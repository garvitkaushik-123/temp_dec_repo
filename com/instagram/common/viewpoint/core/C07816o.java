package com.instagram.common.viewpoint.core;

import android.os.Handler;
import android.os.Looper;

/* renamed from: com.facebook.ads.redexgen.X.6o, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C07816o extends E8 {
    public final /* synthetic */ C07736g A00;

    public C07816o(C07736g c07736g) {
        this.A00 = c07736g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.instagram.common.viewpoint.core.UN
    /* renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A03(E9 e9) {
        new Handler(Looper.getMainLooper()).post(new RunnableC1486Yx(this));
    }
}
