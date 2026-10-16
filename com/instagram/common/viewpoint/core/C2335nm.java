package com.instagram.common.viewpoint.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;

/* renamed from: com.facebook.ads.redexgen.X.nm, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2335nm implements DT, DU {
    public final int A00;
    public final /* synthetic */ C08529p A01;

    public C2335nm(C08529p c08529p, int i) {
        this.A01 = c08529p;
        this.A00 = i;
    }

    @Override // com.instagram.common.viewpoint.core.DU
    @MetaExoPlayerCustomization("Added in D21840558 for FBVP")
    public final long A89() {
        C2323na[] c2323naArr;
        c2323naArr = this.A01.A0L;
        return c2323naArr[this.A00].A0S();
    }

    @Override // com.instagram.common.viewpoint.core.DT
    public final boolean AAe() {
        return this.A01.A0f(this.A00);
    }

    @Override // com.instagram.common.viewpoint.core.DT
    public final void ACR() throws IOException {
        this.A01.A0d(this.A00);
    }

    @Override // com.instagram.common.viewpoint.core.DT
    public final int AHP(C07926z c07926z, C2410p0 c2410p0, int i) {
        return this.A01.A0Y(this.A00, c07926z, c2410p0, i);
    }

    @Override // com.instagram.common.viewpoint.core.DT
    public final int AK2(long j) {
        return this.A01.A0X(this.A00, j);
    }
}
