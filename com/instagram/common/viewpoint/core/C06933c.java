package com.instagram.common.viewpoint.core;

import android.os.Handler;

/* renamed from: com.facebook.ads.redexgen.X.3c, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C06933c extends AbstractC0949Dt {
    public final /* synthetic */ C0937Dh A00;

    public C06933c(C0937Dh c0937Dh) {
        this.A00 = c0937Dh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.instagram.common.viewpoint.core.UN
    /* renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A03(C0950Du c0950Du) {
        C0966Ek c0966Ek;
        Handler handler;
        c0966Ek = this.A00.A01;
        if (c0966Ek == null || c0950Du.A00().getAction() != 0) {
            return;
        }
        handler = this.A00.A04;
        handler.removeCallbacksAndMessages(null);
        this.A00.A07(new C1830f7(this));
    }
}
