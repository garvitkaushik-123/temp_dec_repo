package com.instagram.common.viewpoint.core;

import android.widget.ImageView;
import android.widget.RelativeLayout;

/* renamed from: com.facebook.ads.redexgen.X.3S, reason: invalid class name */
/* loaded from: assets/audience_network/classes2.dex */
public final class C3S extends ED {
    public static String[] A04 = {"hk0dnqphYZ0B2FA2HHbeoaEOUC9cHUBv", "tTD1hmxYdA3U5n9t8Z20NsAIS", "BfpeWRttIDT9n", "BdF5VvNpfNEd8dAFz8yBB3tju8j2QPKu", "opIRFI8OjkHX6xnIsWRzCqWD0", "Ob0oYr4gU4dgC4EVWukqT8XlG8BtSCcB", "HPuRIIJ62FmEL4YF0ip1f4WrSa12U9bK", "7SB"};
    public final ImageView A00;
    public final C1929gi A01;
    public final UN<C4K> A02;
    public final UN<E3> A03;

    public C3S(C1929gi c1929gi) {
        this(c1929gi, false);
    }

    public C3S(C1929gi c1929gi, boolean z) {
        super(c1929gi);
        ImageView.ScaleType scaleType;
        int color;
        this.A03 = new C0932Dc(this);
        this.A02 = new C0931Db(this);
        this.A01 = c1929gi;
        this.A00 = new ImageView(c1929gi);
        if (!z) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
            color = -16777216;
        } else {
            scaleType = ImageView.ScaleType.FIT_START;
            color = 0;
        }
        this.A00.setScaleType(scaleType);
        YB.A0N(this.A00, color);
        this.A00.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.A00);
    }

    @Override // com.instagram.common.viewpoint.core.ED
    public final void A07() {
        super.A07();
        if (getVideoView() != null) {
            UM<UN, UL> eventBus = getVideoView().getEventBus();
            UN[] unArr = new UN[2];
            String[] strArr = A04;
            if (strArr[3].charAt(25) != strArr[5].charAt(25)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[7] = "Nqq";
            strArr2[2] = "4efeQvUmAeHBj";
            unArr[0] = this.A03;
            unArr[1] = this.A02;
            eventBus.A03(unArr);
        }
    }

    @Override // com.instagram.common.viewpoint.core.ED
    public final void A08() {
        if (getVideoView() != null) {
            getVideoView().getEventBus().A04(this.A02, this.A03);
        }
        super.A08();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.A00.layout(0, 0, i3 - i, i4 - i2);
    }

    public void setImage(String str) {
        setImage(str, null);
    }

    public void setImage(String str, InterfaceC1585b8 interfaceC1585b8) {
        if (str == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        LM downloadImageTask = new LM(this.A00, this.A01).A04();
        if (interfaceC1585b8 != null) {
            downloadImageTask.A06(interfaceC1585b8);
        }
        downloadImageTask.A07(str);
    }
}
