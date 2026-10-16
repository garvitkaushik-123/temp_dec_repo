package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.Dk, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C0940Dk extends UN<C4A> {
    public final /* synthetic */ C0939Dj A00;

    public C0940Dk(C0939Dj c0939Dj) {
        this.A00 = c0939Dj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.instagram.common.viewpoint.core.UN
    /* renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A03(C4A c4a) {
        C0966Ek c0966Ek;
        C0966Ek c0966Ek2;
        C0966Ek c0966Ek3;
        String A02;
        c0966Ek = this.A00.A00;
        if (c0966Ek == null) {
            return;
        }
        C0939Dj c0939Dj = this.A00;
        C0939Dj c0939Dj2 = this.A00;
        c0966Ek2 = this.A00.A00;
        int duration = c0966Ek2.getDuration();
        c0966Ek3 = this.A00.A00;
        A02 = c0939Dj2.A02(duration - c0966Ek3.getCurrentPositionInMillis());
        c0939Dj.setText(A02);
    }

    @Override // com.instagram.common.viewpoint.core.UN
    public final Class<C4A> A01() {
        return C4A.class;
    }
}
