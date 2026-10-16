package com.inmobi.media;

import androidx.browser.trusted.sharing.ShareTarget;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public abstract class Ac extends N9 {
    public final AtomicBoolean A;
    public final int y;
    public final int z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ac(String url, C2897ue c2897ue, String str, int i, int i2) {
        super("POST", url, c2897ue, G4.a(G4.f2291a, false, 1, null), (InterfaceC2971z5) null, ShareTarget.ENCODING_TYPE_URL_ENCODED, 64);
        Intrinsics.checkNotNullParameter("POST", "requestType");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(ShareTarget.ENCODING_TYPE_URL_ENCODED, "requestContentType");
        this.y = i;
        this.z = i2;
        this.m = str;
        this.A = new AtomicBoolean(false);
    }
}
