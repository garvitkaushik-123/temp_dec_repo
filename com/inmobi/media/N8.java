package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public class N8 extends C2613d8 {
    public /* synthetic */ N8(String str, String str2, M8 m8, String str3) {
        this(str, str2, "TEXT", m8, str3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N8(String assetId, String assetName, String assetType, M8 assetStyle, String str) {
        super(assetId, assetName, assetType, assetStyle, 16);
        Intrinsics.checkNotNullParameter(assetId, "assetId");
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        Intrinsics.checkNotNullParameter(assetType, "assetType");
        Intrinsics.checkNotNullParameter(assetStyle, "assetStyle");
        this.e = str;
    }
}
