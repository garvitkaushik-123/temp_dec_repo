package com.instagram.common.viewpoint.core;

import android.view.View;
import java.util.Comparator;

/* renamed from: com.facebook.ads.redexgen.X.Pu, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1257Pu implements Comparator<View> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.Comparator
    /* renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compare(View view, View view2) {
        C1251Po c1251Po = (C1251Po) view.getLayoutParams();
        C1251Po c1251Po2 = (C1251Po) view2.getLayoutParams();
        if (c1251Po.A05 != c1251Po2.A05) {
            return c1251Po.A05 ? 1 : -1;
        }
        return c1251Po.A02 - c1251Po2.A02;
    }
}
