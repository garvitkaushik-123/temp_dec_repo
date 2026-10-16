package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class F9 extends C2613d8 {
    public final boolean x;
    public String y;
    public boolean z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F9(String assetId, String assetName, C2630e8 assetStyle, String textValue, boolean z) {
        super(assetId, assetName, "WEBVIEW", assetStyle, 16);
        Intrinsics.checkNotNullParameter(assetId, "assetId");
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        Intrinsics.checkNotNullParameter(assetStyle, "assetStyle");
        Intrinsics.checkNotNullParameter(textValue, "textValue");
        this.x = z;
        this.e = textValue;
    }

    public final void b() {
        this.z = true;
    }

    public final void e(String str) {
        this.y = str;
    }
}
