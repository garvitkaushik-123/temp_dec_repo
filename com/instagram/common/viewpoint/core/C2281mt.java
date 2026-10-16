package com.instagram.common.viewpoint.core;

import android.net.Uri;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.EOFException;
import java.io.IOException;

/* renamed from: com.facebook.ads.redexgen.X.mt, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2281mt implements InterfaceC1036Hd {
    public final byte[] A00 = new byte[4096];

    @Override // com.instagram.common.viewpoint.core.InterfaceC1036Hd
    public final /* synthetic */ int AIp(InterfaceC06692c interfaceC06692c, int i, boolean z) {
        return AbstractC1033Ha.A00(this, interfaceC06692c, i, z);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1036Hd
    public final /* synthetic */ void AIr(C07364v c07364v, int i) {
        AbstractC1033Ha.A01(this, c07364v, i);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1036Hd
    public final void A6e(C2489qI c2489qI) {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1036Hd
    public final int AIq(InterfaceC06692c interfaceC06692c, int i, boolean z, int i2) throws IOException {
        int bytesSkipped = interfaceC06692c.read(this.A00, 0, Math.min(this.A00.length, i));
        if (bytesSkipped == -1) {
            if (z) {
                return -1;
            }
            throw new EOFException();
        }
        return bytesSkipped;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1036Hd
    public final void AIs(C07364v c07364v, int i, int i2) {
        c07364v.A0g(i);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1036Hd
    public final void AIu(long j, int i, int i2, int i3, C1034Hb c1034Hb) {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1036Hd
    @MetaExoPlayerCustomization("New API added for Meta")
    public final void AKf(Uri uri) {
    }
}
