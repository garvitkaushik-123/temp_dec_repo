package com.instagram.common.viewpoint.core;

/* loaded from: assets/audience_network/classes2.dex */
public class C3 implements InterfaceC2165ko {
    public final /* synthetic */ CC A00;

    public C3(final CC val$separatorMatcher) {
        this.A00 = val$separatorMatcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.facebook.ads.redexgen.X.2R] */
    @Override // com.instagram.common.viewpoint.core.InterfaceC2165ko
    /* renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final C2R AAl(final C2166kp splitter, final CharSequence toSplit) {
        return new AbstractC0903Bw(splitter, toSplit) { // from class: com.facebook.ads.redexgen.X.2R
            @Override // com.instagram.common.viewpoint.core.AbstractC0903Bw
            public final int A04(int separatorPosition) {
                return separatorPosition + 1;
            }

            @Override // com.instagram.common.viewpoint.core.AbstractC0903Bw
            public final int A05(int start) {
                return C3.this.A00.A08(this.A03, start);
            }
        };
    }
}
