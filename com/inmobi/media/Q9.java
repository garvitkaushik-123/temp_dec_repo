package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* loaded from: classes4.dex */
public final class Q9 implements O9 {

    /* renamed from: a, reason: collision with root package name */
    public final int f2408a;

    public Q9(String resolvedUrl, int i, ByteString bodyBytes, K9 responseMetaData) {
        Intrinsics.checkNotNullParameter(resolvedUrl, "resolvedUrl");
        Intrinsics.checkNotNullParameter(bodyBytes, "bodyBytes");
        Intrinsics.checkNotNullParameter(responseMetaData, "responseMetaData");
        this.f2408a = i;
    }

    @Override // com.inmobi.media.O9
    public final int a() {
        return this.f2408a;
    }

    @Override // com.inmobi.media.O9
    public final String b() {
        return null;
    }
}
