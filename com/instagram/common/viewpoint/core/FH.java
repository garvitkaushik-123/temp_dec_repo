package com.instagram.common.viewpoint.core;

import android.view.ViewGroup;
import java.util.List;

/* loaded from: assets/audience_network/classes2.dex */
public final class FH extends AbstractC1277Qq<FC> {
    public final int A00;
    public final C1929gi A01;
    public final ViewOnClickListenerC1127Kr A02;
    public final List<String> A03;

    public FH(C1929gi c1929gi, List<String> screenshotUrls, int i, ViewOnClickListenerC1127Kr viewOnClickListenerC1127Kr) {
        this.A03 = screenshotUrls;
        this.A00 = i;
        this.A01 = c1929gi;
        this.A02 = viewOnClickListenerC1127Kr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.instagram.common.viewpoint.core.AbstractC1277Qq
    /* renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final FC A0F(ViewGroup viewGroup, int i) {
        FD fd = new FD(this.A01);
        if (C1379Up.A1D(this.A01)) {
            fd.setOnClickListener(new ViewOnClickListenerC1796eZ(this));
        }
        return new FC(fd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.instagram.common.viewpoint.core.AbstractC1277Qq
    /* renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final void A0K(FC fc, int i) {
        String str = this.A03.get(i);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -1);
        int startSpacing = this.A00 * 4;
        if (i != 0) {
            startSpacing = this.A00;
        }
        marginLayoutParams.setMargins(startSpacing, 0, i >= A0B() + (-1) ? this.A00 * 4 : this.A00, 0);
        fc.A0p().setLayoutParams(marginLayoutParams);
        fc.A0p().A00(str);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1277Qq
    public final int A0B() {
        return this.A03.size();
    }
}
