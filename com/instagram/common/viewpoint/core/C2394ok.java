package com.instagram.common.viewpoint.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;

@MetaExoPlayerCustomization("Should be final")
/* renamed from: com.facebook.ads.redexgen.X.ok, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C2394ok implements AnonymousClass78 {
    public static String[] A05 = {"hSbyIXWx35EcWpJ5mgpqJrodnP2zgUAj", "AVKvZ0FxnTaSPhab1fIF2iZ72kGLJbya", "jBX7iJXGD8JRWgbUYtK1siSQEeTEZwCL", "i2fIBHFmzda6l4Lh5IwFm1sKJFPGPiRM", "MPSpeSFedASltWD94wRgDX9C2oesADq", "pjPp4ZdncQK9eqjJ4SlffLD", "oopCB6d3Vy5GhBPVddSO0qnC65I08xM", "WPZc57Li25BnEd3F6sy7axVnNov0V"};
    public long A00;
    public long A01;
    public C2468px A02 = C2468px.A06;
    public boolean A03;
    public final AnonymousClass45 A04;

    public C2394ok(AnonymousClass45 anonymousClass45) {
        this.A04 = anonymousClass45;
    }

    public void A00() {
        if (!this.A03) {
            this.A00 = this.A04.A6J();
            this.A03 = true;
        }
    }

    public void A01() {
        if (this.A03) {
            A02(A8p());
            this.A03 = false;
        }
    }

    public void A02(long j) {
        this.A01 = j;
        if (this.A03) {
            this.A00 = this.A04.A6J();
        }
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass78
    public C2468px A8m() {
        return this.A02;
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass78
    public long A8p() {
        long elapsedSinceBaseMs = this.A01;
        if (this.A03) {
            long A6J = this.A04.A6J();
            long positionUs = this.A00;
            long j = A6J - positionUs;
            if (this.A02.A01 == 1.0f) {
                long positionUs2 = C5C.A0O(j);
                return elapsedSinceBaseMs + positionUs2;
            }
            long positionUs3 = this.A02.A03(j);
            return elapsedSinceBaseMs + positionUs3;
        }
        return elapsedSinceBaseMs;
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass78
    public void AJd(C2468px c2468px) {
        if (this.A03) {
            long A8p = A8p();
            String[] strArr = A05;
            if (strArr[3].charAt(3) == strArr[2].charAt(3)) {
                throw new RuntimeException();
            }
            A05[7] = "MyAjQeitkUrtgk2AHovxe6SLNdU2U";
            A02(A8p);
        }
        this.A02 = c2468px;
    }
}
