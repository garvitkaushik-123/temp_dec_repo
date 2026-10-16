package com.inmobi.media;

import android.widget.RelativeLayout;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.n5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2775n5 extends Af {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RelativeLayout.LayoutParams f2647a;

    public C2775n5(RelativeLayout.LayoutParams layoutParams) {
        this.f2647a = layoutParams;
    }

    @Override // com.inmobi.media.Af
    public final void a(EnumC2813pa orientation, Cf finalInsets) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(finalInsets, "finalInsets");
        B2.a(finalInsets, this.f2647a, orientation);
    }
}
