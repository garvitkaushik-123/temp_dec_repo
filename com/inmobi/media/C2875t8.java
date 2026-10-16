package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.t8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2875t8 extends C2613d8 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2875t8(String assetId, String assetName, C2630e8 assetStyle, String url) {
        super(assetId, assetName, "ICON", assetStyle, 16);
        Intrinsics.checkNotNullParameter(assetId, "assetId");
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        Intrinsics.checkNotNullParameter(assetStyle, "assetStyle");
        Intrinsics.checkNotNullParameter(url, "url");
        this.e = url;
    }
}
